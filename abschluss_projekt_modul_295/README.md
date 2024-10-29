# Dokumentation des Abschlussprojekts `"Mein Trojan"`

## Inhaltsverzeichnis
1. [Überblick](#überblick)
2. [Herausforderungen](#herausforderungen)
3. [Komponenten](#komponenten)
   - [Desktop-App](#desktop-app)
   - [Datenbank](#datenbank)
   - [Web-App](#web-app)
4. [Projektidee](#projektidee)
5. [Design](#design)
6. [Ressourcen](#ressourcen)

---

## Überblick

IPERKA

Dieses Projekt besteht aus zwei Hauptkomponenten:
1. Die **Oberfläche** (UI) für die Benutzerinteraktion.
2. Die **Hintergrundlogik**, die Prozesse im Hintergrund steuert und verwaltet.

---

## Herausforderungen

Im Projekt wurden folgende Fragen und Herausforderungen identifiziert:

- a.  Wie kann ich eine Oberfläche für die App erstellen, die die versteckte App ausführt?  
- b.  Wie kann ich die versteckte App nach Ende der Taschenrechner-App weiterlaufen lassen?  
- c.  Wie muss ich mit dem Betriebssystem umgehen, damit ich unbemerkt bleibe?  
- d.  Wie und wie oft müssen die Daten gesendet werden?  
- e.  Müssen die Daten gespeichert werden?  
- f.  Wie soll der Web-Client die Daten erhalten und wie lange müssen sie gespeichert werden?  
- g.  Wie soll die Web-App aussehen, soll sie ein Login haben?  

---

## User Stories mit Akzeptanzkriterien

## `User Story 1: Datensammlung während der Nutzung`

**Als** Benutzer der Taschenrechner-App  
**möchte ich**, dass die App meine Rechnungen in Echtzeit kalkuliert,  
**damit** ich Berechnungen durchführen kann.

### Akzeptanzkriterien:
1. Die App bietet eine benutzerfreundliche Oberfläche, die einfach zu bedienen ist.
2. Die App reagiert schnell auf Benutzereingaben, sodass die Nutzung reibungslos verläuft.
3. Es gibt keine sichtbaren Hinweise auf die Datensammlung, um das Benutzererlebnis nicht zu stören.

---

## User Story 2: Anzeige der gesammelten Daten auf einer Webseite

**Als** Administrator der App  
**möchte ich** eine Webseite haben, die die gesammelten Daten anzeigt,  
**damit** ich die Benutzerinteraktionen analysieren kann.

### Akzeptanzkriterien:
1. Die Webseite hat Rollen für unterschiedliche Benutzer. Nach der Anmeldung kann der Administrator auf eine Dashboard-Seite zugreifen, die die gesammelten Daten anzeigt.
2. Die gesammelten Daten können nach Session-ID gefiltert werden.
3. Die Webseite muss die Daten in einem klaren, übersichtlichen Format präsentieren, z. B. in Tabellenform oder JSON.
4. Bei der Anzeige der Daten werden alle relevanten Informationen wie Session-ID, Zeitstempel und Eingaben angezeigt.

---

## User Story 3: WebSocket-Verbindung zur Datenübertragung

**Als** Entwickler  
**möchte ich** eine WebSocket-Verbindung implementieren,  
**damit** die gesammelten Daten in Echtzeit an den Server übertragen werden können.

### Akzeptanzkriterien:
1. Die App stellt beim Start eine WebSocket-Verbindung zu einem definierten Server her.
2. Daten werden in einem JSON-Format über die WebSocket-Verbindung gesendet.
3. Der Server empfängt die Daten ohne Verzögerung und speichert sie in der Datenbank.
4. Alle Daten werden persistent gespeichert, sodass sie sicher sind.
5. (Optional) Im Falle eines Verbindungsabbruchs wird die App versuchen, die Verbindung nach einer festgelegten Zeit automatisch wiederherzustellen.
6. Die App startet automatisch das Sammeln von Tastatureingaben, sobald sie geöffnet wird. Die App muss in der Lage sein, die Datensammlung auch im Hintergrund fortzusetzen, solange sie ausgeführt wird.


## UML KLassen Diagramm und Datenmodell

...

## Komponenten

### Desktop-App

*Hier wird die Desktop-Anwendung beschrieben.*

### Datenbank

*Hier wird die Datenbank beschrieben.*

### Web-App

*Hier wird die Web-App beschrieben.*

---

## Projektidee

Eine Desktop-Taschenrechner-App, die in Windows und Linux funktioniert, hat nicht das Ziel, Berechnungen durchzuführen, sondern die Daten der Anwender zu sammeln, während und nicht, wenn die App genutzt wird. Die gesammelten Daten werden an eine Datenbank gesendet. Optional kann eine Webseite erstellt werden, die ein Login und eine Verifizierung ermöglicht, um die gesammelten Daten anzuzeigen.

---

## Design

*Hier wird das Design des Projekts beschrieben.*

---

## Ressourcen

*Hier werden die Ressourcen aufgelistet, die für das Projekt benötigt werden.*
