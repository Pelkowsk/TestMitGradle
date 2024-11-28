import json

# Pfade zu den Dateien
SCAN_RESULTS_FILE = 'scancode-results.json'
LICENSE_POLICY_FILE = 'license_policy.json'
OUTPUT_FILE = 'compliance_check_result.txt'

def load_json(file_path):
    with open(file_path, 'r') as f:
        return json.load(f)

def main():
    # Laden der ScanCode-Ergebnisse und der Lizenzrichtlinien
    scan_results = load_json(SCAN_RESULTS_FILE)
    license_policy = load_json(LICENSE_POLICY_FILE)

    allowed_licenses = set(license_policy['allowed_licenses'])
    forbidden_licenses = set(license_policy['forbidden_licenses'])

    violations = []

    # Überprüfung der erkannten Lizenzen
    for file in scan_results.get('files', []):
        for license_info in file.get('licenses', []):
            license_name = license_info.get('short_name')
            if license_name in forbidden_licenses:
                violations.append((file.get('path'), license_name))

    # Ergebnisse ausgeben und in Datei schreiben
    with open(OUTPUT_FILE, 'w') as output:
        if violations:
            output.write("Verbotene Lizenzen gefunden:\n")
            for path, license_name in violations:
                output.write(f"Datei: {path}, Lizenz: {license_name}\n")
            exit_code = 1
        else:
            output.write("Keine verbotenen Lizenzen gefunden.\n")
            exit_code = 0

    # Beenden mit entsprechendem Exit-Code
    exit(exit_code)

if __name__ == '__main__':
    main()
