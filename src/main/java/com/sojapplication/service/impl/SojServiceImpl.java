package com.sojapplication.service.impl;

import com.sojapplication.exception.SojException;
import com.sojapplication.model.SojRequest;
import com.sojapplication.model.SojResponse;
import com.sojapplication.model.VersionResponse;
import com.sojapplication.service.SojService;
import com.sojapplication.util.VersionCompareUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class SojServiceImpl implements SojService {

    @Override
    public SojResponse computeMin(final SojRequest request) {
        final List<Integer> inputList = request.getNumbers();

        if (CollectionUtils.isEmpty(inputList))
            throw new SojException("Numbers list should not be empty");

        int quantifier = request.getQuantifier();

        if (quantifier <= 0 || quantifier > inputList.size()) {
            throw new SojException("Please provide a valid quantifier");
        }

        final Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(inputList);

        final List<Integer> minNumbers = new ArrayList<>();
        while (quantifier-- > 0) {
            minNumbers.add(minHeap.poll());
        }

        final SojResponse response = SojResponse.builder().numbers(minNumbers).build();
        return response;
    }

    @Override
    public SojResponse computeMax(final SojRequest request) {
        final List<Integer> inputList = request.getNumbers();

        if (CollectionUtils.isEmpty(inputList))
            throw new SojException("Numbers list should not be empty");

        int quantifier = request.getQuantifier();

        if (quantifier <= 0 || quantifier > inputList.size()) {
            throw new SojException("Please provide a valid quantifier");
        }

        final Queue<Integer> maxHeap = new PriorityQueue<>(inputList.size(), Collections.reverseOrder());
        maxHeap.addAll(inputList);
        final List<Integer> maxNumbers = new ArrayList<>();
        while (quantifier-- > 0) {
            maxNumbers.add(maxHeap.poll());
        }
        final SojResponse response = SojResponse.builder().numbers(maxNumbers).build();
        return response;
    }

    @Override
    public SojResponse computeAverage(final SojRequest request) {
        final List<Integer> inputList = request.getNumbers();
        if (CollectionUtils.isEmpty(inputList))
            throw new SojException("Numbers list should not be empty");

        final Double average = inputList.stream().mapToDouble(val -> val).average().orElse(0.0);
        final SojResponse response = SojResponse.builder().average(average).build();
        return response;
    }

    @Override
    public SojResponse computeMedian(final SojRequest request) {
        final List<Integer> inputList = request.getNumbers();
        if (CollectionUtils.isEmpty(inputList))
            throw new SojException("Numbers list should not be empty");

        Collections.sort(inputList);

        final int size = inputList.size();
        final Double median;

        if (size % 2 == 0) {
            median = (inputList.get(size / 2) + inputList.get((size - 1) / 2)) / 2.0;
        } else {
            median = Double.valueOf(inputList.get(size / 2));
        }

        final SojResponse response = SojResponse.builder().median(median).build();
        return response;
    }

    @Override
    public SojResponse computePercentile(final SojRequest request) {
        final List<Integer> inputList = request.getNumbers();
        if (CollectionUtils.isEmpty(inputList))
            throw new SojException("Numbers list should not be empty");

        final int quantifier = request.getQuantifier();

        if (quantifier <= 0 || quantifier > 100)
            throw new SojException("Please enter a valid quantifier");

        Collections.sort(inputList);

        final int index = (int) Math.ceil((quantifier / 100.0) * inputList.size());
        final Integer qthPercentile = inputList.get(index - 1);
        final SojResponse response = SojResponse.builder().percentile(qthPercentile).build();
        return response;
    }

    @Override
    public VersionResponse compareVersions(final String version1, final String version2) {
        final int result = VersionCompareUtil.compareVersions(version1, version2);
        final VersionResponse response = VersionResponse.builder().versionResult(result).build();
        return response;
    }

}
