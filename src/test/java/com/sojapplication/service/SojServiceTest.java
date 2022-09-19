package com.sojapplication.service;

import com.sojapplication.exception.SojException;
import com.sojapplication.model.SojRequest;
import com.sojapplication.model.SojResponse;
import com.sojapplication.model.VersionResponse;
import com.sojapplication.service.impl.SojServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SojServiceTest {

    @InjectMocks
    private SojServiceImpl sojService;

    @Test
    public void testComputeMin_Success() {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        final List<Integer> expectedList = List.of(2, 3, 53, 56);

        final SojResponse actual = this.sojService.computeMin(request);
        assertEquals(actual.getNumbers(), expectedList);
    }

    @Test
    public void testComputeMin_Failure() {
        final SojRequest request1 = new SojRequest(new ArrayList<>(), 1);
        final SojRequest request2 = new SojRequest(List.of(56, 2, 53, 57, 3, 77), 0);

        assertThrows(SojException.class, () -> this.sojService.computeMin(request1));
        assertThrows(SojException.class, () -> this.sojService.computeMin(request2));
    }

    @Test
    public void testComputeMax_Success() {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        final List<Integer> expectedList = List.of(77, 57, 56, 53);

        final SojResponse actual = this.sojService.computeMax(request);
        assertEquals(actual.getNumbers(), expectedList);
    }

    @Test
    public void testComputeMax_Failure() {
        final SojRequest request1 = new SojRequest(new ArrayList<>(), 1);
        final SojRequest request2 = new SojRequest(List.of(56, 2, 53, 57, 3, 77), 0);

        assertThrows(SojException.class, () -> this.sojService.computeMax(request1));
        assertThrows(SojException.class, () -> this.sojService.computeMax(request2));
    }

    @Test
    public void testComputeAverage_Success() {
        final List<Integer> inputList = List.of(56, 2, 53, 57, 3, 77);
        final int quantifier = 4;
        final SojRequest request = new SojRequest(inputList, quantifier);

        final Double expectedAverage = 41.333333333333336;

        final SojResponse actual = this.sojService.computeAverage(request);
        assertEquals(actual.getAverage(), expectedAverage);
    }

    @Test
    public void testComputeAverage_Failure() {
        final SojRequest request1 = new SojRequest(new ArrayList<>(), 1);

        assertThrows(SojException.class, () -> this.sojService.computeAverage(request1));
    }

    @Test
    public void testComputeMedian_Success() {
        final List<Integer> inputList1 = new ArrayList<>(Arrays.asList(56, 2, 53, 57, 3, 77));
        final List<Integer> inputList2 = new ArrayList<>(Arrays.asList(56, 2, 53, 57, 3, 77, 88));
        final int quantifier = 4;
        final SojRequest request1 = new SojRequest(inputList1, quantifier);
        final SojRequest request2 = new SojRequest(inputList2, quantifier);

        final Double expectedMedian1 = 54.5;
        final Double expectedMedian2 = 56.0;

        final SojResponse actual1 = this.sojService.computeMedian(request1);
        final SojResponse actual2 = this.sojService.computeMedian(request2);
        
        assertEquals(actual1.getMedian(), expectedMedian1);
        assertEquals(actual2.getMedian(), expectedMedian2);
    }

    @Test
    public void testComputeMedian_Failure() {
        final SojRequest request1 = new SojRequest(new ArrayList<>(), 1);

        assertThrows(SojException.class, () -> this.sojService.computeMedian(request1));
    }

    @Test
    public void testComputePercentile_Success() {
        final List<Integer> inputList = new ArrayList<>(Arrays.asList(56, 2, 53, 57, 3, 77));
        final int quantifier = 30;
        final SojRequest request = new SojRequest(inputList, quantifier);

        final Integer expectedPercentile = 3;

        final SojResponse actual = this.sojService.computePercentile(request);
        assertEquals(actual.getPercentile(), expectedPercentile);
    }

    @Test
    public void testComputePercentile_Failure() {
        final SojRequest request1 = new SojRequest(new ArrayList<>(), 1);
        final SojRequest request2 = new SojRequest(List.of(56, 2, 53, 57, 3, 77), 0);
        final SojRequest request3 = new SojRequest(List.of(56, 2, 53, 57, 3, 77), 102);

        assertThrows(SojException.class, () -> this.sojService.computePercentile(request1));
        assertThrows(SojException.class, () -> this.sojService.computePercentile(request2));
        assertThrows(SojException.class, () -> this.sojService.computePercentile(request3));
    }

    @Test
    public void testCompareVersions_Positive() {
        final String version1 = "3.4";
        final String version2 = "1.2";
        final VersionResponse response = this.sojService.compareVersions(version1, version2);
        assertEquals(response.getVersionResult(), 1);
    }

    @Test
    public void testCompareVersions_Negative() {
        final String version1 = "1.2";
        final String version2 = "3.4";
        final VersionResponse response = this.sojService.compareVersions(version1, version2);
        assertEquals(response.getVersionResult(), -1);
    }

    @Test
    public void testCompareVersions_Equal() {
        final String version1 = "1.2";
        final String version2 = "1.2";
        final VersionResponse response = this.sojService.compareVersions(version1, version2);
        assertEquals(response.getVersionResult(), 0);
    }

}
