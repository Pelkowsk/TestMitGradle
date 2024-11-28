import os
import re

# Definieren der Ignore-Muster
IGNORE_PATTERNS = [
    re.compile(r'^build/.*'),
    re.compile(r'^gradle/wrapper/.*'),
    re.compile(r'^\.idea/.*'),
    re.compile(r'^[^/]+\.iml$'),
    re.compile(r'^\.gitignore$'),
    re.compile(r'^LICENSE$'),
    re.compile(r'^Dockerfile$'),
    re.compile(r'^\.github/.*'),
    # Weitere spezifische Muster können hier hinzugefügt werden
]

def is_ignored(relative_path, ignore_patterns):
    """Überprüft, ob ein relativer Pfad einem der Ignore-Muster entspricht."""
    for pattern in ignore_patterns:
        if pattern.match(relative_path):
            return True
    return False

def find_ignored_paths(base_path, ignore_patterns):
    """Findet alle Pfade, die ignoriert werden sollen, und gibt ihre relativen Pfade zurück."""
    ignored_paths = []
    for root, dirs, files in os.walk(base_path):
        # Berechnung des relativen Pfads zum Basisverzeichnis
        relative_root = os.path.relpath(root, base_path)
        # Prüfen und Verzeichnisse filtern
        for directory in dirs:
            dir_path = os.path.join(relative_root, directory)
            if is_ignored(dir_path, ignore_patterns):
                ignored_paths.append(dir_path)
        # Prüfen und Dateien filtern
        for file in files:
            file_path = os.path.join(relative_root, file)
            if is_ignored(file_path, ignore_patterns):
                ignored_paths.append(file_path)
    return ignored_paths

def save_to_file(file_path, data):
    """Schreibt die Liste der ignorierten Pfade in eine Datei."""
    with open(file_path, 'w') as f:
        for line in data:
            f.write(f"{line}\n")

def main():
    base_path = os.getcwd()  # Aktuelles Arbeitsverzeichnis
    ignored_paths = find_ignored_paths(base_path, IGNORE_PATTERNS)

    # Ignorierte Pfade speichern
    output_file = os.path.join(base_path, 'ignore_paths.txt')
    save_to_file(output_file, ignored_paths)

    print(f"Ignorierte Pfade wurden in '{output_file}' gespeichert.")
    print(f"Aktuelles Arbeitsverzeichnis: {os.getcwd()}")

if __name__ == '__main__':
    main()
