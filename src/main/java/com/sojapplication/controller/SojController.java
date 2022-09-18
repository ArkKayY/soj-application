package com.sojapplication.controller;

import com.sojapplication.model.SojRequest;
import com.sojapplication.model.SojResponse;
import com.sojapplication.model.VersionRequest;
import com.sojapplication.model.VersionResponse;
import com.sojapplication.service.SojService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SojController {

    private final SojService sojService;

    @Autowired
    public SojController(final SojService sojService) {
        this.sojService = sojService;
    }

    @PostMapping("/min")
    public ResponseEntity<SojResponse> computeMin(@RequestBody final SojRequest request) {
        final SojResponse response = this.sojService.computeMin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/max")
    public ResponseEntity<SojResponse> computeMax(@RequestBody final SojRequest request) {
        final SojResponse response = this.sojService.computeMax(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/avg")
    public ResponseEntity<SojResponse> computeAverage(@RequestBody final SojRequest request) {
        final SojResponse response = this.sojService.computeAverage(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/median")
    public ResponseEntity<SojResponse> computeMedian(@RequestBody final SojRequest request) {
        final SojResponse response = this.sojService.computeMedian(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/percentile")
    public ResponseEntity<SojResponse> computePercentile(@RequestBody final SojRequest request) {
        final SojResponse response = this.sojService.computePercentile(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/compare-versions")
    public ResponseEntity<VersionResponse> compareVersions(@RequestBody final VersionRequest request) {
        final VersionResponse response = this.sojService.compareVersions(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
