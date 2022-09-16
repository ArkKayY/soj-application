package com.sojapplication.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class SojResponse {

    private List<Integer> numbers;
    private Double        average;
    private Double        median;
    private Integer       element;

    public SojResponse(final List<Integer> numbers,
                       final Double average,
                       final Double median,
                       final Integer element) {
        this.numbers = numbers;
        this.average = average;
        this.median = median;
        this.element = element;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(final Double average) {
        this.average = average;
    }

    public Double getMedian() {
        return median;
    }

    public void setMedian(final Double median) {
        this.median = median;
    }

    public Integer getPercentile() {
        return element;
    }

    public void setPercentile(final Integer percentile) {
        this.element = percentile;
    }

}
