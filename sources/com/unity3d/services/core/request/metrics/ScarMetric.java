package com.unity3d.services.core.request.metrics;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ScarMetric {
    private static final String ASYNC_PREFIX = "async";
    private static final String HB_SIGNALS_FETCH_FAILURE = "native_hb_signals_%s_fetch_failure";
    private static final String HB_SIGNALS_FETCH_START = "native_hb_signals_%s_fetch_start";
    private static final String HB_SIGNALS_FETCH_SUCCESS = "native_hb_signals_%s_fetch_success";
    private static final String HB_SIGNALS_UPLOAD_FAILURE = "native_hb_signals_%s_upload_failure";
    private static final String HB_SIGNALS_UPLOAD_START = "native_hb_signals_%s_upload_start";
    private static final String HB_SIGNALS_UPLOAD_SUCCESS = "native_hb_signals_%s_upload_success";
    private static final String REASON = "reason";
    private static final String SYNC_PREFIX = "sync";
    private static long _fetchStartTime;
    private static long _uploadStartTime;

    private static long getTotalFetchTime() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - _fetchStartTime);
    }

    private static long getTotalUploadTime() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - _uploadStartTime);
    }

    public static Metric hbSignalsFetchFailure(boolean z2, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put(REASON, str);
        Object[] objArr = new Object[1];
        if (z2) {
            str2 = "async";
        } else {
            str2 = "sync";
        }
        objArr[0] = str2;
        return new Metric(String.format(HB_SIGNALS_FETCH_FAILURE, objArr), Long.valueOf(getTotalFetchTime()), hashMap);
    }

    public static Metric hbSignalsFetchStart(boolean z2) {
        String str;
        _fetchStartTime = System.nanoTime();
        Object[] objArr = new Object[1];
        if (z2) {
            str = "async";
        } else {
            str = "sync";
        }
        objArr[0] = str;
        return new Metric(String.format(HB_SIGNALS_FETCH_START, objArr), (Object) null);
    }

    public static Metric hbSignalsFetchSuccess(boolean z2) {
        String str;
        Object[] objArr = new Object[1];
        if (z2) {
            str = "async";
        } else {
            str = "sync";
        }
        objArr[0] = str;
        return new Metric(String.format(HB_SIGNALS_FETCH_SUCCESS, objArr), Long.valueOf(getTotalFetchTime()));
    }

    public static Metric hbSignalsUploadFailure(boolean z2, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put(REASON, str);
        Object[] objArr = new Object[1];
        if (z2) {
            str2 = "async";
        } else {
            str2 = "sync";
        }
        objArr[0] = str2;
        return new Metric(String.format(HB_SIGNALS_UPLOAD_FAILURE, objArr), Long.valueOf(getTotalUploadTime()), hashMap);
    }

    public static Metric hbSignalsUploadStart(boolean z2) {
        String str;
        _uploadStartTime = System.nanoTime();
        Object[] objArr = new Object[1];
        if (z2) {
            str = "async";
        } else {
            str = "sync";
        }
        objArr[0] = str;
        return new Metric(String.format(HB_SIGNALS_UPLOAD_START, objArr), (Object) null);
    }

    public static Metric hbSignalsUploadSuccess(boolean z2) {
        String str;
        Object[] objArr = new Object[1];
        if (z2) {
            str = "async";
        } else {
            str = "sync";
        }
        objArr[0] = str;
        return new Metric(String.format(HB_SIGNALS_UPLOAD_SUCCESS, objArr), Long.valueOf(getTotalUploadTime()));
    }
}
