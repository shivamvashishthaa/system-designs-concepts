package com.shivam.shop_app.common.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/api/v1")
    public Map<String, String> home() {
        return Map.of(
                "application", "MiniShop",
                "message", "MiniShop is running!",
                "version", "v1"
        );
    }
}
