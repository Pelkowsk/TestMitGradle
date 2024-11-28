import os
import fnmatch

# Definieren der Ignore-Muster
ignore_patterns = [
    'TestMitGradle/build/*',
    'TestMitGradle/gradle/*',
    'TestMitGradle/.idea/*',
    'TestMitGradle/*.iml',
    'TestMitGradle/.gitignore',
    'TestMitGradle/LICENSE',
    'TestMitGradle/Dockerfile',
    'TestMitGradle/.github/*',
    'TestMitGradle/compliance-scripts/*',
    'TestMitGradle/gen/*',
    'TestMitGradle/gradle/*',
    'TestMitGradle/src/test/*',
]

def is_ignored(path, ignore_patterns):
    """Überprüft, ob ein Pfad einem der Ignore-Muster entspricht."""
    for pattern in ignore_patterns:
        if fnmatch.fnmatch(path, pattern):
            return True
    return False

def find_relevant_files(base_path, ignore_patterns):
    """Findet relevante Endpunktdateien, die nicht ignoriert werden sollen."""
    relevant_files = []
    for root, dirs, files in os.walk(base_path):
        # Filtere Verzeichnisse, die ignoriert werden sollen
        dirs[:] = [d for d in dirs if not is_ignored(os.path.join(root, d), ignore_patterns)]
        for file in files:
            file_path = os.path.join(root, file)
            if not is_ignored(file_path, ignore_patterns):
                relevant_files.append(file_path)
    return relevant_files

# Basisverzeichnis des Projekts
base_path = 'TestMitGradle'

# Finde relevante Dateien
relevant_files = find_relevant_files(base_path, ignore_patterns)

# Ausgabe der relevanten Dateien
for file in relevant_files:
    print(f"Relevante Datei zur Auswertung: {file}")
