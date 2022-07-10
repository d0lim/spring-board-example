package com.studyspring.boardexample.controller;

import com.studyspring.boardexample.domain.UserRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class EnumController {

    @GetMapping("/enum")
    public Map<String, Object> getEnum() {
        Map<String, Object> enums = new LinkedHashMap<>();
        Class userRole = UserRole.class;
        enums.put("userRole", userRole.getEnumConstants());

        return enums;
    }
}
