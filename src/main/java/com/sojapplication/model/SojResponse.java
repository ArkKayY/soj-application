package com.sojapplication.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
public class SojResponse {

    private List<Integer> numbers;
    private Double average;
    private Double median;
    private Integer percentile;

}
