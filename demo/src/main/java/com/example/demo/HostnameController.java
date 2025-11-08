package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HostnameController {

    @GetMapping("/api/hostname")
    public String getHostname() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            // Get the hostname
            String hostname = localHost.getHostName();
            // Optionally, get the IP address
            String ipAddress = localHost.getHostAddress();

            return "Server Hostname: " + hostname + ", IP Address: " + ipAddress;
        } catch (UnknownHostException e) {
            return "Could not determine server hostname: " + e.getMessage();
        }
    }
}