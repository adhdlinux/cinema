package com.startapp.networkTest.startapp;

import com.startapp.networkTest.results.ConnectivityTestResult;
import com.startapp.networkTest.results.LatencyResult;

public interface ConnectivityTestListener {
    void onConnectivityTestFinished(Runnable runnable);

    void onConnectivityTestResult(ConnectivityTestResult connectivityTestResult);

    void onLatencyTestResult(LatencyResult latencyResult);
}
