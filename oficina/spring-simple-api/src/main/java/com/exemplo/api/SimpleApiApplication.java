package com.exemplo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Esta é a classe principal que inicia TUDO.
 * A anotação @SpringBootApplication faz três coisas:
 * 1. Habilita a autoconfiguração do Spring Boot.
 * 2. Procura por componentes (como Controladores) neste pacote.
 * 3. Marca a classe como uma fonte de configuração.
 */
@SpringBootApplication
public class SimpleApiApplication {

    public static void main(String[] args) {
        // Esta linha inicia o Tomcat embarcado e sua aplicação
        SpringApplication.run(SimpleApiApplication.class, args);
    }
}
