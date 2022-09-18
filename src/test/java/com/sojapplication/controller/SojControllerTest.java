package com.sojapplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sojapplication.exception.SojException;
import com.sojapplication.model.SojRequest;
import com.sojapplication.model.SojResponse;
import com.sojapplication.model.VersionRequest;
import com.sojapplication.model.VersionResponse;
import com.sojapplication.service.SojService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SojController.class)
public class SojControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SojService sojService;

    @Test
    public void testComputeMin_Success() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        final List<Integer> responseList = List.of(2, 3, 53, 56);
        final SojResponse response = SojResponse.builder().numbers(responseList).build();

        when(this.sojService.computeMin(any(SojRequest.class))).thenReturn(response);

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/min")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.numbers", is(responseList)));
    }

    @Test
    public void testComputeMin_Failure() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        doThrow(SojException.class).when(this.sojService).computeMin(any(SojRequest.class));

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/min")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testComputeMax_Success() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        final List<Integer> responseList = List.of(77, 57, 56, 53);
        final SojResponse response = SojResponse.builder().numbers(responseList).build();

        when(this.sojService.computeMax(any(SojRequest.class))).thenReturn(response);

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/max")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.numbers", is(responseList)));
    }

    @Test
    public void testComputeMax_Failure() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        doThrow(SojException.class).when(this.sojService).computeMax(any(SojRequest.class));

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/max")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testComputeAverage_Success() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        final Double average = 41.333333333333336;
        final SojResponse response = SojResponse.builder().average(average).build();

        when(this.sojService.computeAverage(any(SojRequest.class))).thenReturn(response);

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/avg")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.average", is(average)));
    }

    @Test
    public void testComputeAverage_Failure() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        doThrow(SojException.class).when(this.sojService).computeAverage(any(SojRequest.class));

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/avg")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testComputeMedian_Success() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        final Double median = 54.5;
        final SojResponse response = SojResponse.builder().median(median).build();

        when(this.sojService.computeMedian(any(SojRequest.class))).thenReturn(response);

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/median")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.median", is(median)));
    }

    @Test
    public void testComputeMedian_Failure() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        doThrow(SojException.class).when(this.sojService).computeMedian(any(SojRequest.class));

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/median")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testComputePercentile_Success() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 30;
        final SojRequest request = new SojRequest(inputList, quantifier);

        final Integer percentile = 3;
        final SojResponse response = SojResponse.builder().percentile(percentile).build();

        when(this.sojService.computePercentile(any(SojRequest.class))).thenReturn(response);

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/percentile")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.percentile", is(percentile)));
    }

    @Test
    public void testComputePercentile_Failure() throws Exception {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 30;
        final SojRequest request = new SojRequest(inputList, quantifier);

        doThrow(SojException.class).when(this.sojService).computePercentile(any(SojRequest.class));

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/percentile")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testVersionCompare() throws Exception {
        final VersionRequest request = new VersionRequest("1.2", "3.4");
        final int versionResult = -1;
        final VersionResponse response = VersionResponse.builder().versionResult(versionResult).build();

        when(this.sojService.compareVersions(any(VersionRequest.class))).thenReturn(response);

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/compare-versions")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.versionResult", is(versionResult)));
    }

}
