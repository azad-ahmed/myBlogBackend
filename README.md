# Mein Quarkus Blog-Projekt


## Übersicht

###
- Das Projekt "Blog Backend" wird im Auftrag von Simeon Liniger an der HFTM-Schule entwickelt.
####
- Dies ist mein Quarkus-Projekt zur Erstellung eines Blogs mit GET, POST, PUT, PATCH und DELETE-Funktionen.
####

- Das Projekt "Blog Backend" ist ein Beispielprojekt, das mit dem Quarkus-Framework entwickelt wurde. Es dient als Backend für einen einfachen Blog und stellt RESTful-API-Endpunkte bereit, um Blogbeiträge zu verwalten.
####
- Das Quarkus-Framework wurde gewählt (HFTM-Studium), da es sich um ein leichtgewichtiges und leistungsstarkes Java-Framework handelt, das speziell für die Entwicklung von Cloud-nativen Anwendungen entwickelt wurde. Wir haben im 2. Studiumjahr Projekte mit Java-entwickelt, daher habe ich für Quarkus entschieden. Es zeichnet sich durch seine schnelle Startzeit, geringen Speicherbedarf und effiziente Verarbeitung von HTTP-Anfragen aus.
####
- Das Projekt verwendet Maven als Build-Management-Tool, um Abhängigkeiten zu verwalten und das Kompilieren des Codes sowie das Erstellen von Paketen zu erleichtern.
####
- Das Blog-Backend-Projekt kann als Ausgangspunkt dienen, um deine eigenen Anwendungen mit Quarkus zu entwickeln und zu erweitern. Du kannst weitere Funktionen hinzufügen, das Frontend integrieren oder das Projekt als Teil einer grösseren Anwendung verwenden.
###


### Die Hauptfunktionen des Blog-Backends sind:
##
#### Erstellen eines neuen Blogbeitrags:
-  Durch Aufrufen des POST-Endpunkts können Benutzer einen neuen Blogbeitrag erstellen. Die Informationen werden im Anfragekörper im JSON-Format übergeben.
#### Abrufen aller Blogbeiträge:
-  Durch Aufrufen des GET-Endpunkts erhalten Benutzer eine Liste aller vorhandenen Blogbeiträge.
#### Abrufen eines einzelnen Blogbeitrags:
-  Durch Aufrufen des GET-Endpunkts mit einer spezifischen ID erhalten Benutzer die Details eines einzelnen Blogbeitrags.
#### Aktualisieren eines Blogbeitrags:
- Durch Aufrufen des PUT-Endpunkts mit einer spezifischen ID können Benutzer einen vorhandenen Blogbeitrag aktualisieren. Die aktualisierten Informationen werden im Anfragekörper im JSON-Format übergeben.
#### Löschen eines Blogbeitrags:
- Durch Aufrufen des DELETE-Endpunkts mit einer spezifischen ID können Benutzer einen Blogbeitrag löschen.
###

### Datenbank
- Das Projekt verwendet auch eine Datenbank, die in der Datei src/main/resources/application.properties konfiguriert wird. Du kannst die Einstellungen anpassen, um deine bevorzugte Datenbank (z.B. MySQL, PostgreSQL) zu verwenden.
####

### Technologien, die ich einsetze.

- Quarkus: Eine leistungsstarke Java-Framework für Cloud-native Anwendungen.
- Maven: Ein Build-Management-Tool für die Java-Entwicklung.
- RESTEasy Reactive: Eine Quarkus-Erweiterung für die Entwicklung von reaktiven und skalierbaren RESTful-Webdiensten.
- JSON-B: Eine Java-API für die Serialisierung und Deserialisierung von Java-Objekten in JSON-Format.

- If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Projektstruktur

Das Projekt besteht aus folgenden Hauptkomponenten:

- `ch.hftm.model`: Enthält die Datenmodelle für Blogs und Kommentare.
- `ch.hftm.repository`: Stellt das Repository für den Zugriff auf die Datenbank bereit.
- `ch.hftm.service`: Enthält die Geschäftslogik für das Hinzufügen, Aktualisieren, Löschen und Abrufen von Blogs.
- `ch.hftm.web`: Stellt die REST-Schnittstelle für das Blog-System bereit.

## Konfiguration

Die Datenbankverbindung und andere Einstellungen können in der Datei `application.properties` konfiguriert werden. Stelle sicher, dass du die richtigen Werte für die MySQL-Verbindung bereitstellst.

## Verwendung

1. Starte deine MySQL-Datenbank. Du kannst Docker verwenden, indem du den Befehl `docker-compose up -d` ausführst und sicherstellst, dass die in der `docker-compose.yml` angegebenen Konfigurationen korrekt sind.

2. Führe den Befehl `./ mvnw quarkus:dev` aus, um das Projekt zu kompilieren und den Quarkus-Entwicklungsmodus zu starten.

3. Das Blog-System ist jetzt unter `http://localhost:8080/blog` erreichbar. Du kannst die verfügbaren REST-Endpunkte verwenden, um Blogs abzurufen, Blogs zu erstellen, Blogs zu aktualisieren, Blogs zu löschen und Kommentare zu erstellen.

4. Um Swagger UI aufzurufen, starte das Projekt und navigiere zu `http://localhost:8080/swagger-ui/` in deinem Webbrowser. Du kannst dort die verschiedenen API-Endpunkte anzeigen, deren Details überprüfen und sogar Anfragen direkt ausführen.

## Tests

Das Projekt enthält auch Tests, die die verschiedenen Komponenten überprüfen. Führe den Befehl `mvn test` aus, um die Tests auszuführen und sicherzustellen, dass alles korrekt funktioniert.

## Beitragende

- Azad Ahmed <azad.ahmed@hftm.ch>

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.
