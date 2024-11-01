const WebSocket = require('ws');

// Ersetze dies durch die URL deines Spring-WebSocket-Servers
const socket = new WebSocket('ws://localhost:8080/ws'); // Passe den Pfad an, wenn nötig

socket.on('open', () => {
    console.log("Verbindung zum Server hergestellt");
});

socket.on('error', (error) => {
    console.error("WebSocket-Fehler:", error);
});

socket.on('close', () => {
    console.log("Verbindung zum Server geschlossen");
});

socket.on('message', (message) => {
    console.log('Nachricht vom Server:', message);
});

// Beispiel für das Senden einer Nachricht
const sendMessage = (message) => {
    if (socket.readyState === WebSocket.OPEN) {
        socket.send(message);
    } else {
        console.log("Socket ist nicht verbunden");
    }
};

// Sende eine Testnachricht nach einer Sekunde
setTimeout(() => {
    sendMessage("Hallo vom Node.js-Client!");
}, 1000);
