# Mein Quarkus Blog-Projekt

- [Übersicht](#übersicht)
- [Funktionen](#funktionen)
- [Technologien](#technologien)
- [Projektstruktur](#projektstruktur)
- [Verwendung](#verwendung)
- [Tests](#tests)
- [Beitragende](#beitragende)

## Übersicht

Dieses Projekt ist ein Beispiel für ein Blog-Backend, das mit dem Quarkus-Framework entwickelt wurde. Es stellt RESTful-API-Endpunkte bereit, um Blogbeiträge zu verwalten.

## Funktionen

Das Blog-Backend bietet folgende Funktionen:

- **Erstellen eines neuen Blogbeitrags:** Durch einen POST-Request können Benutzer einen neuen Blogbeitrag erstellen. Die erforderlichen Informationen werden im Anfragekörper im JSON-Format übergeben.

- **Abrufen aller Blogbeiträge:** Durch einen GET-Request können Benutzer eine Liste aller vorhandenen Blogbeiträge abrufen.

- **Abrufen eines einzelnen Blogbeitrags:** Durch einen GET-Request mit einer spezifischen ID können Benutzer die Details eines einzelnen Blogbeitrags abrufen.

- **Aktualisieren eines Blogbeitrags:** Durch einen PUT-Request mit einer spezifischen ID können Benutzer einen vorhandenen Blogbeitrag aktualisieren. Die aktualisierten Informationen werden im Anfragekörper im JSON-Format übergeben.

- **Löschen eines Blogbeitrags:** Durch einen DELETE-Request mit einer spezifischen ID können Benutzer einen Blogbeitrag löschen.

## Technologien

Das Projekt nutzt folgende Technologien:

- **Quarkus:** Ein leichtgewichtiges und leistungsstarkes Java-Framework für Cloud-native Anwendungen. Es bietet eine schnelle Startzeit, geringen Speicherbedarf und effiziente Verarbeitung von HTTP-Anfragen.

- **Maven:** Ein Build-Management-Tool für die Java-Entwicklung. Maven wird verwendet, um Abhängigkeiten zu verwalten, den Code zu kompilieren und Pakete zu erstellen.

- **RESTEasy Reactive:** Eine Quarkus-Erweiterung für die Entwicklung von reaktiven und skalierbaren RESTful-Webdiensten. Sie bietet eine leistungsstarke Unterstützung für die Implementierung von RESTful-APIs.

- **JSON-B:** Eine Java-API für die Serialisierung und Deserialisierung von Java-Objekten im JSON-Format. JSON-B wird verwendet, um die Datenmodelle in JSON umzuwandeln und umgekehrt.

## Projektstruktur

Das Projekt ist wie folgt strukturiert:

- `src/main/java/ch/hftm/model`: Enthält die Datenmodelle für Blogs und Kommentare.
- `src/main/java/ch/hftm/repository`: Stellt das Repository für den Zugriff auf die Datenbank bereit.
- `src/main/java/ch/hftm/service`: Enthält die Geschäftslogik für das Hinzufügen, Aktualisieren, Löschen und Abrufen von Blogs.
- `src/main/java/ch/hftm/web`: Stellt die REST-Schnittstelle für das Blog-System bereit.
- `src/test/java/ch/hftm/model`: Enthält Unit-Tests für die Datenmodelle.
- `src/test/java/ch/hftm/service`: Enthält Unit-Tests für die Geschäftslogik.
- `src/test/java/ch/hftm/web`: Enthält Integrationstests für die REST-Schnittstelle.

## Verwendung

Folge diesen Schritten, um das Blog-Backend-Projekt zu verwenden:

1. **Starte deine MySQL-Datenbank:** Stelle sicher, dass du eine MySQL-Datenbank installiert hast. Du kannst Docker verwenden, indem du den Befehl `docker-compose up -d` ausführst und sicherstellst, dass die in der `docker-compose.yml` angegebenen Konfigurationen korrekt sind.

2. **Starte das Projekt:** Öffne eine Befehlszeile, wechsle zum Projektverzeichnis und führe den Befehl `./mvnw quarkus:dev` aus. Dadurch wird das Projekt kompiliert und der Quarkus-Entwicklungsmodus gestartet.

3. **Verwende die RESTful-API:** Das Blog-Backend ist nun unter `http://localhost:8080/blog` erreichbar. Du kannst die folgenden Endpunkte verwenden:

    - `GET /blog`: Abrufen aller Blogbeiträge.
    - `GET /blog/{id}`: Abrufen eines einzelnen Blogbeitrags anhand seiner ID.
    - `POST /blog`: Erstellen eines neuen Blogbeitrags.
    - `PUT /blog/{id}`: Aktualisieren eines vorhandenen Blogbeitrags.
    - `DELETE /blog/{id}`: Löschen eines Blogbeitrags.

4. **Swagger UI**: Das Blog-Backend enthält eine Swagger UI-Schnittstelle, die unter `http://localhost:8080/swagger-ui/` verfügbar ist. Du kannst diese URL in deinem Webbrowser öffnen, um die API-Endpunkte anzuzeigen, deren Details zu überprüfen und sogar Anfragen direkt über die UI auszuführen.

## Tests

Das Projekt enthält auch automatisierte Tests, um die Funktionalität sicherzustellen. Du kannst die Tests ausführen, indem du den Befehl `mvn test` in der Befehlszeile eingibst.

## Beitragende

- Azad Ahmed <azad.ahmed@hftm.ch>

> **_HINWEIS:_** Quarkus wird jetzt mit einer Dev UI ausgeliefert, die nur im Entwicklungsmodus unter `http://localhost:8080/q/dev/` verfügbar ist. Du kannst diese URL öffnen, um weitere Entwicklungs- und Debugging-Tools anzuzeigen.

