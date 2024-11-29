plugins {
    java
    id("antlr") // ANTLR-Plugin hinzufügen
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral() // Nutze Maven Central für Abhängigkeiten
}

dependencies {
    antlr("org.antlr:antlr4:4.13.2") // ANTLR-Bibliothek
    implementation("org.antlr:antlr4-runtime:4.13.2") // Laufzeit-Bibliothek für ANTLR
    testImplementation(platform("org.junit:junit-bom:5.10.0")) // JUnit BOM für Tests
    testImplementation("org.junit.jupiter:junit-jupiter") // JUnit Jupiter für Tests
}

tasks.generateGrammarSource {
    arguments.addAll(listOf("-visitor", "-listener", "-package", "org.example")) // Paketname für generierte Dateien festlegen
    outputDirectory = file("src/main/gen") // Ausgabeort für generierten Code
}

sourceSets {
    main {
        java.srcDirs("src/main/java", "src/main/gen") // Inkludiere generierten Code
    }
    test {
        java.srcDirs("src/test/java") // Quellverzeichnis für Tests
    }
}

tasks.test {
    useJUnitPlatform() // JUnit-Plattform verwenden
}

tasks.clean {
    delete("src/main/gen") // Lösche den generierten Code beim Bereinigen des Projekts
}
