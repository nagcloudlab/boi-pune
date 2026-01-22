package com.example.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@Getter
@Setter
class Info {
    private String serviceName = "Transfer Service";
    private String version = "1.0.0";
    private String ip;
    private int port;
}

@RestController
public class InfoController {

    @Value("${server.port}")
    int port;

    @GetMapping("/info")
    public Info getInfo() {
        Info info = new Info();
        try {
            String ipAddress = java.net.InetAddress.getLocalHost().getHostAddress();
            info.setIp(ipAddress);
        } catch (Exception e) {
            info.setIp("Unknown");
        }
        info.setPort(port);
        return info;
    }

}
