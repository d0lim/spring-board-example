package com.studyspring.boardexample.controller;

import com.studyspring.boardexample.constants.EnumModel;
import com.studyspring.boardexample.constants.EnumValue;
import com.studyspring.boardexample.domain.UserRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
}
