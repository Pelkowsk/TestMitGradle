import os
import fnmatch

# Definieren der Ignore-Muster
ignore_patterns = [
    'Pelkowsk/TestMitGradle/build/*',
    'Pelkowski/TestMitGradle/gradle/wrapper/*',
    'Pelkowsk/TestMitGradle/.idea/*',
    'Pelkowsk/TestMitGradle/*.iml',
    'Pelkowsk/TestMitGradle/.gitignore',
    'Pelkowsk/TestMitGradle/LICENSE',
    'Pelkowsk/TestMitGradle/Dockerfile',
    'Pelkowsk/TestMitGradle/.github/*',
    'Pelkowsk/TestMitGradle/compliance-scripts/*',
    'PelkowskTestMitGradle/gen/*',
    'Pelkowsk/TestMitGradle/gradle/*',
    'Pelkowsk/TestMitGradle/src/test/*',
]

def is_ignored(path, ignore_patterns):
    """Überprüft, ob ein Pfad einem der Ignore-Muster entspricht."""
    for pattern in ignore_patterns:
        if fnmatch.fnmatch(path, pattern):
            return True
    return False

def find_ignored_paths(base_path, ignore_patterns):
    """Findet alle Pfade, die ignoriert werden sollen."""
    ignored_paths = []
    for root, dirs, files in os.walk(base_path):
        # Prüfen und Verzeichnisse filtern
        for directory in dirs:
            dir_path = os.path.join(root, directory)
            if is_ignored(dir_path, ignore_patterns):
                ignored_paths.append(dir_path)
        # Prüfen und Dateien filtern
        for file in files:
            file_path = os.path.join(root, file)
            if is_ignored(file_path, ignore_patterns):
                ignored_paths.append(file_path)
    return ignored_paths

def save_to_file(file_path, data):
    """Schreibt die Liste der ignorierten Pfade in eine Datei."""
    with open(file_path, 'w') as f:
        for line in data:
            f.write(f"{line}\n")

def main():
    base_path = 'TestMitGradle'  # Wurzelverzeichnis
    ignored_paths = find_ignored_paths(base_path, ignore_patterns)

    # Ignorierte Pfade speichern
    save_to_file('ignore_paths.txt', ignored_paths)

    print(f"Ignorierte Pfade wurden in 'ignore_paths.txt' gespeichert.")

if __name__ == '__main__':
    main()
