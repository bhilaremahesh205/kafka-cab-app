package com.cabbookdriver.controller;

import com.cabbookdriver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() throws InterruptedException {
        int range = 100;
        while (range > 0) {
            cabLocationService.updateLocation(Math.random() + " , " + Math.random());
            Thread.sleep(1000);
            range--;
        }

        return ResponseEntity.ok(Map.of("message", "Location Updated"));
    }
}
