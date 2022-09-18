package com.sojapplication.service;

import com.sojapplication.model.SojRequest;
import com.sojapplication.model.SojResponse;
import com.sojapplication.model.VersionRequest;
import com.sojapplication.model.VersionResponse;

public interface SojService {

    SojResponse computeMin(SojRequest request);

    SojResponse computeMax(SojRequest request);

    SojResponse computeAverage(SojRequest request);

    SojResponse computeMedian(SojRequest request);

    SojResponse computePercentile(SojRequest request);

    VersionResponse compareVersions(VersionRequest request);

}
