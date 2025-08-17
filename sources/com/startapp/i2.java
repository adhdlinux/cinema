package com.startapp;

import com.startapp.networkTest.results.ConnectivityTestResult;
import com.startapp.networkTest.results.LatencyResult;

public interface i2 {
    void a();

    void onConnectivityTestResult(ConnectivityTestResult connectivityTestResult);

    void onLatencyTestResult(LatencyResult latencyResult);
}
