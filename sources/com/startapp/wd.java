package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import com.startapp.networkTest.results.BaseResult;
import com.startapp.networkTest.results.ConnectivityTestResult;
import com.startapp.networkTest.results.LatencyResult;
import com.startapp.networkTest.results.NetworkInformationResult;
import com.startapp.networkTest.startapp.ConnectivityTestListener;
import com.startapp.networkTest.startapp.CoverageMapperManager;
import java.util.Map;

public class wd implements ConnectivityTestListener, CoverageMapperManager.OnNetworkInfoResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36841a;

    public wd(Context context) {
        this.f36841a = context;
    }

    public final void a(z8 z8Var, BaseResult baseResult) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Map<Activity, Integer> map = lb.f34876a;
            String encodeToString = Base64.encodeToString(lb.a(String.valueOf(h0.b(baseResult))), 11);
            if (encodeToString != null) {
                y8 y8Var = new y8(z8Var);
                y8Var.f36958h = Long.valueOf(currentTimeMillis);
                y8Var.f36955e = encodeToString;
                y8Var.a(this.f36841a);
                return;
            }
            y8 y8Var2 = new y8(z8.f36996c);
            y8Var2.f36954d = "NTS, can not encode result";
            y8Var2.f36955e = baseResult.getClass().getName();
            y8Var2.a(this.f36841a);
        } catch (Throwable th) {
            y8.a(this.f36841a, th);
        }
    }

    public void onConnectivityTestFinished(Runnable runnable) {
        ((o2) runnable).run();
    }

    public void onConnectivityTestResult(ConnectivityTestResult connectivityTestResult) {
        if (connectivityTestResult != null) {
            a(z8.f37005l, connectivityTestResult);
        }
    }

    public void onLatencyTestResult(LatencyResult latencyResult) {
        if (latencyResult != null) {
            a(z8.f37006m, latencyResult);
        }
    }

    public void onNetworkInfoResult(NetworkInformationResult networkInformationResult) {
        if (networkInformationResult != null) {
            a(z8.f37007n, networkInformationResult);
        }
    }
}
