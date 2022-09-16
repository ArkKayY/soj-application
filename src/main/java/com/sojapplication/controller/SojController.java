package com.sojapplication.controller;

import com.sojapplication.model.SojRequest;
import com.sojapplication.model.SojResponse;
import com.sojapplication.service.SojService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SojController {

    // Add a @Valid annotation and handle exception accordingly

    private final SojService sojService;

    @Autowired
    public SojController(final SojService sojService) {
        this.sojService = sojService;
    }

    @GetMapping("/min")
    public ResponseEntity<SojResponse> computeMin(@RequestBody final SojRequest request) {
        SojResponse response = this.sojService.computeMin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<SojResponse> computeMax(@RequestBody final SojRequest request) {
        SojResponse response = this.sojService.computeMin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/avg")
    public ResponseEntity<SojResponse> computeAverage(@RequestBody final SojRequest request) {
        SojResponse response = this.sojService.computeMin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/median")
    public ResponseEntity<SojResponse> computeMedian(@RequestBody final SojRequest request) {
        SojResponse response = this.sojService.computeMin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/percentile")
    public ResponseEntity<SojResponse> computePercentile(@RequestBody final SojRequest request) {
        SojResponse response = this.sojService.computeMin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
