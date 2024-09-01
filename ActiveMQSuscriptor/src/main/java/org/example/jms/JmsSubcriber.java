package org.example.jms;

import org.example.models.Company;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsSubcriber {

    @JmsListener(destination = "${jsa.activemq.topic}")
    public void receive (Company msg){
        System.out.println("Mensaje Recibido: " + msg);
    }
}
