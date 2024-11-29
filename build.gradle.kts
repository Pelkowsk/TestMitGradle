plugins {
    java
    id("antlr") // Hinzufügen des ANTLR-Plugins
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    antlr("org.antlr:antlr4:4.13.2") // Korrekte Einbindung von ANTLR
    implementation("org.antlr:antlr4-runtime:4.13.2") // Laufzeit-Bibliothek für ANTLR
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.generateGrammarSource {
    arguments.addAll(listOf("-visitor", "-listener")) // Generiert Visitor und Listener
    outputDirectory = file("src/main/gen") // Ausgabeort für generierten Code
}

sourceSets {
    main {
        java.srcDirs("src/main/java", "src/main/gen") // Generierter Code wird inkludiert
    }
    test {
        java.srcDirs("src/test/java")
    }
}

tasks.test {
    useJUnitPlatform()
}
