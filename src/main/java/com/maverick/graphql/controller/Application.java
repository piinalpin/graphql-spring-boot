package com.maverick.graphql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Application {

    @GetMapping(value = "/", name = "GraphQL Application")
    public Map<String, String> main() {
        Map<String, String> ret = new HashMap<>();
        ret.put("message", "ok");
        return ret;
    }

}
