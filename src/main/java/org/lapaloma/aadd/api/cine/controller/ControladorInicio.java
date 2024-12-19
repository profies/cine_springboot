package org.lapaloma.aadd.api.cine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorInicio {
    @RequestMapping("/")
    String hola() {
        return "HolaMundo";
    }
}
