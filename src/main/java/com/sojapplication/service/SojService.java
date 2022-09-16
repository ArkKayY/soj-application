package com.sojapplication.service;

import com.sojapplication.model.SojRequest;
import com.sojapplication.model.SojResponse;

public interface SojService {

    SojResponse computeMin(SojRequest request);

    SojResponse computeMax(SojRequest request);

    SojResponse computeAverage(SojRequest request);

    SojResponse computeMedian(SojRequest request);

    SojResponse computePercentile(SojRequest request);

}
