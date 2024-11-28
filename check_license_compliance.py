import json
import sys

# Pfade zu den Dateien
SCAN_RESULTS_FILE = 'scancode-results.json'
LICENSE_POLICY_FILE = 'license_policy.json'
OUTPUT_FILE = 'compliance_check_result.txt'

def load_json(file_path):
    """Lädt eine JSON-Datei und gibt deren Inhalt zurück."""
    try:
        with open(file_path, 'r') as f:
            return json.load(f)
    except FileNotFoundError:
        print(f"Fehler: Datei '{file_path}' nicht gefunden.")
        sys.exit(1)
    except json.JSONDecodeError:
        print(f"Fehler: Datei '{file_path}' enthält ungültiges JSON.")
        sys.exit(1)

def main():
    # Laden der ScanCode-Ergebnisse und der Lizenzrichtlinien
    scan_results = load_json(SCAN_RESULTS_FILE)
    license_policy = load_json(LICENSE_POLICY_FILE)

    allowed_licenses = set(license_policy.get('allowed_licenses', []))
    forbidden_licenses = set(license_policy.get('forbidden_licenses', []))

    no_license_files = []
    forbidden_license_files = []

    # Überprüfung der erkannten Lizenzen
    for file in scan_results.get('files', []):
        file_path = file.get('path')
        licenses = file.get('licenses', [])

        if not licenses:
            no_license_files.append(file_path)
        else:
            for license_info in licenses:
                license_key = license_info.get('key')
                if license_key in forbidden_licenses:
                    forbidden_license_files.append((file_path, license_key))

    # Ergebnisse ausgeben und in Datei schreiben
    with open(OUTPUT_FILE, 'w') as output:
        if no_license_files:
            output.write("Die folgenden Dateien enthalten keinen Lizenzeintrag:\n")
            for path in no_license_files:
                output.write(f" - {path}\n")
            output.write("\n")

        if forbidden_license_files:
            output.write("Die folgenden Dateien enthalten verbotene Lizenzen:\n")
            for path, license_key in forbidden_license_files:
                output.write(f" - Datei: {path}, Lizenz: {license_key}\n")
            output.write("\n")

        if not no_license_files and not forbidden_license_files:
            output.write("Alle Dateien sind lizenzkonform.\n")

    # Beenden mit entsprechendem Exit-Code
    if no_license_files or forbidden_license_files:
        sys.exit(1)
    else:
        sys.exit(0)

if __name__ == '__main__':
    main()
