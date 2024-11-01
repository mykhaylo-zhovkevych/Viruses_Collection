# Inhaltsverzeichnis

1. [Informieren](#informieren)
   - [Überblick](#überblick)
   - [Herausforderungen](#herausforderungen)
   - [Projektidee](#projektidee)
2. [Planen](#planen)
   - [User Stories und Akzeptanzkriterien](#user-stories-und-akzeptanzkriterien)
   - [Arbeitsplan mit Arbeitspaketen und Aufwandsschätzungen](#arbeitsplan-mit-arbeitspaketen-und-aufwandsschätzungen)
3. [Entscheiden](#entscheiden)
4. [Realisieren](#realisieren)
   - [Komponenten](#komponenten)
     - [Desktop-Anwendung](#desktop-anwendung)
     - [Server](#server)
     - [Datenbank](#datenbank)
     - [Web-App](#web-app)
   - [Design](#design)
   - [Klassendiagramm und Datenmodelle](#klassendiagramm-und-datenmodelle)
   - [API-Dokumentation](#api-dokumentation)
5. [Kontrollieren](#kontrollieren)
   - [Testplan](#testplan)
6. [Auswerten](#auswerten)
   - [Installationsanleitung](#installationsanleitung)
   - [Ressourcen](#ressourcen)

---

## Informieren

### Überblick

Dieses Projekt besteht aus drei Hauptkomponenten:
1. Die **Oberfläche** (UI) für die Benutzerinteraktion.
2. Die **Hintergrundlogik**, die Prozesse im Hintergrund steuert und verwaltet.
3. Die **Serverseitige Logik**, die Daten im Frontend darstellt.

---

### Herausforderungen

Im Projekt wurden folgende Fragen und Herausforderungen identifiziert:

- a. Wie kann ich eine Oberfläche für die App erstellen, die die versteckte App ausführt?  
- b. Wie kann ich die versteckte App nach Ende der Taschenrechner-App weiterlaufen lassen?  
- c. Wie muss ich mit dem Betriebssystem umgehen, damit ich unbemerkt bleibe?  
- d. Wie und wie oft müssen die Daten gesendet werden?  
- e. Müssen die Daten gespeichert werden?  
- f. Wie soll der Web-Client die Daten erhalten und wie lange müssen sie gespeichert werden?  
- g. Wie soll die Web-App aussehen, soll sie ein Login haben?

---

### Projektidee

Eine Desktop-Taschenrechner-App, die in Windows und Linux funktioniert, hat nicht das Ziel, Berechnungen durchzuführen, sondern die Daten der Anwender zu sammeln, während und nicht, wenn die App genutzt wird. Die gesammelten Daten werden an eine Datenbank gesendet. Optional kann eine Webseite erstellt werden, die ein Login und eine Verifizierung ermöglicht, um die gesammelten Daten anzuzeigen.

---

## Planen

### Arbeitsplan und Arbeitspakete mit Aufwandsschätzungen.

| Datum       | Zeit   | Arbeitspaket         | Erwartete Aufgabe                                | Erledigte Aufgabe                                      |
|-------------|--------|----------------------|--------------------------------------------------|--------------------------------------------------------|
| 29.10.2024                | 3 Std   | Projektinitialisierung                     | Leere Projekte für Frontend und Backend erstellen, MainApp mit Dateispeicherung einrichten | Leere Projekte für Frontend und Backend erstellt, MainApp speichert Daten in `Keys.txt` |
| 30.10.2024  31.10.2024  | 2 Std   | Planung                                    | Aufgaben abschätzen, Theorie wiederholen/vertiefen, UML-Diagramme/Datenmodelle und Struktur planen | Aufgaben grob geschätzt, Struktur in UML-Diagrammen/Datenmodellen festgelegt |
| 01.11.2024                | --- Std  | WebSocket-Server                           | Spring Boot WebSocket-Server erstellen, grundlegende Verbindung testen | WebSocket-Server erstellt, Verbindung getestet                 |
| 01.11.2024  05.11.2024   | --- Std | MainApp-Datenversendung umsetzen          | Die MainApp sendet die Daten an den WebSocket-Server reibungslos und die Daten werden in der richtigen Form gespeichert | -------------------------------                               |
| 01.11.2024  02.11.2024   | --- Std | Datenmodellierung umsetzen                 | Datenmodelle für Benutzer und Sitzungen mit Spring Boot realisieren  | Datenmodelle in Spring entworfen und dokumentiert            |
| 03.11.2024                | --- Std | Frontend-Verbindung                        | Einfache WebSocket-UI zur Anzeige empfangener Daten                 | -------------------------------                               |
| 05.11.2024                | --- Std | Dokumentation                              | Die Dokumentation fertigstellen und alles auf mögliche Verbesserungen prüfen, sei es technisch oder textlich | -------------------------------                               |

---

### User Stories und Akzeptanzkriterien

#### `User Story 1: Datensammlung während der Nutzung`

**Als** Benutzer der Taschenrechner-App  
**möchte ich**, dass die App meine Rechnungen in Echtzeit kalkuliert,  
**damit** ich Berechnungen durchführen kann.

##### Akzeptanzkriterien:
1. Die App bietet eine benutzerfreundliche Oberfläche, die einfach zu bedienen ist.
2. Die App reagiert schnell auf Benutzereingaben, sodass die Nutzung reibungslos verläuft.
3. Es gibt keine sichtbaren Hinweise auf die Datensammlung, um das Benutzererlebnis nicht zu stören.

---

#### `User Story 2: Anzeige der gesammelten Daten auf einer Webseite`

**Als** Administrator der App  
**möchte ich** eine Webseite haben, die die gesammelten Daten anzeigt,  
**damit** ich die Benutzerinteraktionen analysieren kann.

##### Akzeptanzkriterien:
1. Die Webseite hat Rollen für unterschiedliche Benutzer. Nach der Anmeldung kann der Administrator auf eine Dashboard-Seite zugreifen, die die gesammelten Daten anzeigt.
2. Die gesammelten Daten können nach Session-ID gefiltert werden.
3. Die Webseite muss die Daten in einem klaren, übersichtlichen Format präsentieren, z. B. in Tabellenform oder JSON.
4. Bei der Anzeige der Daten werden alle relevanten Informationen wie Session-ID, Zeitstempel und Eingaben angezeigt.

---

#### `User Story 3: WebSocket-Verbindung zur Datenübertragung`

**Als** Entwickler  
**möchte ich** eine WebSocket-Verbindung implementieren,  
**damit** die gesammelten Daten in Echtzeit an den Server übertragen werden können.

##### Akzeptanzkriterien:
1. Die Trojan-App stellt beim Start eine WebSocket-Verbindung zu einem definierten Server her.
2. Daten werden in einem JSON-Format über die WebSocket-Verbindung gesendet.
3. Der Server empfängt die Daten ohne Verzögerung und speichert sie in der Datenbank.
4. Alle Daten werden persistent gespeichert, sodass sie sicher sind.
5. Die App startet automatisch das Sammeln von Tastatureingaben, sobald sie geöffnet wird. Die App muss in der Lage sein, die Datensammlung auch im Hintergrund fortzusetzen, solange sie ausgeführt wird.

---

## Entscheiden

*Hier werden Entscheidungen über die Umsetzung getroffen.*

---

## Realisieren

### Komponenten

#### Desktop-Anwendung

*Hier wird die Desktop-Anwendung beschrieben.*

#### Server

Die Websocket-Server muss eine zwischenrolle innerhalb Desktop-Anwendung und Web-App spielen und ermöglicht eine effiziente und sofortige Datenübertragung zwischen meiner Desktop-Anwendung und dem Server. Dann es soll die Daten persistent gespeichert werden und in Web App darstellt.

Innere Struktur:

## 1. `config/`

Dieses Package enthält die Konfigurationsklassen, die den WebSocket-Server einrichten und anpassen. Es legt fest, wie der WebSocket-Server funktioniert und welche Endpunkte verfügbar sind.

- **`WebSocketConfig.java`**:  
  - Richtet die WebSocket-Verbindung ein.
  - Definiert den WebSocket-Endpunkt, über den die Desktop-Anwendung und die Web-App mit dem Server kommunizieren können.
  - Aktiviert und konfiguriert den Nachrichtenbroker, der Nachrichten weiterleitet.
  - **Beispiel**: Die Annotation `@EnableWebSocketMessageBroker` signalisiert Spring Boot, dass WebSocket-Nachrichten unterstützt werden.

## 2. `controller/`

Das `controller` Package beinhaltet die "Controller"-Klassen, die Nachrichten von Clients empfangen und verarbeiten.

- **`WebSocketController.java`**:  
  - Nimmt eingehende Nachrichten entgegen und entscheidet, wie sie weitergeleitet werden.
  - Verwendet `@MessageMapping`, um bestimmte Methoden auf definierte Nachrichtenkanäle reagieren zu lassen.
  - **Beispiel**: Eine Methode in dieser Klasse könnte eine eingehende Nachricht empfangen und an alle verbundenen Clients weiterleiten.

## 3. `handler/`

Hier liegen die benutzerdefinierten Handler-Klassen, die spezielle Logik für die Verarbeitung von Nachrichten implementieren.

- **`CustomWebSocketHandler.java`**:  
  - Reagiert auf eingehende Nachrichten und ermöglicht individuelle Verarbeitung.
  - Enthält Logik, um Nachrichten zu speichern oder zu verändern, bevor sie weitergeleitet werden.
  - **Beispiel**: Die Klasse könnte Nachrichten filtern oder validieren, bevor sie anderen Clients zur Verfügung gestellt werden.

## 4. `listener/`

Dieses Package enthält Klassen, die auf spezifische Ereignisse wie Tastenkombinationen reagieren.

- **`KeyEventListener.java`**:  
  - Dieser Listener reagiert auf definierte Tastenkombinationen (z. B. `Enter + C`) und führt eine Aktion aus, wie das Verschieben des Eingabefokus auf ein bestimmtes Datenfeld.
  - **Beispiel**: Wenn die Tastenkombination `Enter + C` gedrückt wird, wird die Nachricht in das Feld für `action` und nicht in `text` gespeichert.

## 5. `model/`

Das `model` Package definiert die Datenstrukturen, die im gesamten Server verwendet werden.

- **`Message.java`**:  
  - Repräsentiert eine Nachricht mit Feldern wie `content` (Nachrichtentext) und `sender` (Absender).
  - Dieses Modell hilft dabei, die Struktur und die benötigten Felder jeder Nachricht zu definieren.
  - **Beispiel**: Beim Senden einer Nachricht wird ein `Message`-Objekt erstellt und weiterverarbeitet.

## 6. `repository/`

Das `repository` Package enthält Klassen, die sich um die Interaktion mit der Datenbank kümmern und Daten persistent speichern.

- **`MessageRepository.java`**:  
  - Bietet Methoden, um Nachrichten in einer Datenbank zu speichern, zu lesen und zu löschen.
  - Durch die Verwendung eines `Repository`-Interfaces, z. B. mit Spring Data JPA, können Nachrichten dauerhaft gespeichert und bei Bedarf abgerufen werden.
  - **Beispiel**: `save()`-Methoden zum Speichern von Nachrichten oder `findAll()`-Methoden zum Abrufen aller Nachrichten für die Web-App.

## 7. `service/`

Das `service` Package enthält die Geschäftslogik der Anwendung. Hier werden eingehende Daten verarbeitet, bevor sie weitergeleitet werden.

- **`MessageService.java`**:  
  - Beinhaltet Methoden zur Verwaltung und Verarbeitung von Nachrichten, z. B. zur Überprüfung oder Modifikation vor der Weiterleitung.
  - Kann zur Validierung oder Anpassung von Nachrichten verwendet werden.
  - **Beispiel**: Die `MessageService`-Klasse kann eine Nachricht formatieren oder filtern, bevor sie an den Controller weitergegeben und an die Clients verteilt wird.

---

#### Datenbank

*Hier wird die Datenbank beschrieben.*

#### Web-App

*Hier wird die Web-App beschrieben.*

---

### Design

*Hier wird das Design des Projekts beschrieben.*

---

### Klassendiagramm und Datenmodelle

*Hier werden Klassendiagramme und Datenmodelle vorgestellt.*

---

### API-Dokumentation

*Hier wird die API-Dokumentation beschrieben.*

---

## Kontrollieren

### Testplan

*Hier werden Tests und Überprüfungen durchgeführt.*

---

## Auswerten

### Installationsanleitung

*Hier wird die Installationsanleitung für das Projekt beschrieben.*

### Ressourcen

*Hier werden die Ressourcen aufgelistet, die für das Projekt benötigt werden.*
