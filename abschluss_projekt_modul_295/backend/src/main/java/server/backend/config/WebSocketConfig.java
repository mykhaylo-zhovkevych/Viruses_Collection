package backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// @Configuration: Diese Annotation kennzeichnet die Klasse als eine Quelle für Spring-Bean-Definitionen.
@Configuration
// @EnableWebSocketMessageBroker: Aktiviert die WebSocket-Nachrichtenvermittlung in der Anwendung.
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // enableSimpleBroker("/topic"): Aktiviert einen einfachen, in-memory Nachrichtenbroker für das Senden von Nachrichten an Clients, die sich auf ein bestimmtes Präfix abonniert haben.
        config.enableSimpleBroker("/topic"); 
        // Definiert das Präfix für Nachrichten, die von der Anwendung verarbeitet werden (d.h. Nachrichten, die an Controller gesendet werden).
        config.setApplicationDestinationPrefixes("/app");
    }

    // registerStompEndpoints: Registriert einen STOMP-Endpunkt, über den die Clients sich mit dem Server verbinden können. In diesem Fall ist der Endpunkt /ws, und es wird SockJS verwendet, um die WebSocket-Funktionalität in Browsern zu unterstützen, die keine WebSockets unterstützen.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:8080").withSockJS();
    }
}
