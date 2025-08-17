package com.chartboost.sdk.impl;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class f8 {
    public HttpsURLConnection a(l2 l2Var) {
        return (HttpsURLConnection) new URL(l2Var.e()).openConnection();
    }
}
