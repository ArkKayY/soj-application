package com.sojapplication.service;

import com.sojapplication.model.SojRequest;
import com.sojapplication.model.SojResponse;
import com.sojapplication.model.VersionResponse;

public interface SojService {

    /**
     * Computes and returns the # of minimum values in the list
     *
     * @param request input list to compute
     * @return # of minimum values
     */
    SojResponse computeMin(SojRequest request);

    /**
     * Computes and returns the # of maximum values in the list
     *
     * @param request input list to compute
     * @return # of maximum values
     */
    SojResponse computeMax(SojRequest request);

    /**
     * Computes and returns the average of all the values in the list
     *
     * @param request input list to compute
     * @return average of all values
     */
    SojResponse computeAverage(SojRequest request);

    /**
     * Computes and returns the median of all the values in the list
     *
     * @param request input list to compute
     * @return median of all values
     */
    SojResponse computeMedian(SojRequest request);

    /**
     * Computes and returns the qth percentile of all the values in the list using nearest-rank method
     *
     * @param request input list to compute
     * @return qth percentile of the element list
     */
    SojResponse computePercentile(SojRequest request);

    /**
     * Compares two version numbers
     *
     * @param request input containing 2 versions
     * @return version result containing a int value
     */
    VersionResponse compareVersions(final String version1, final String version2);

}
