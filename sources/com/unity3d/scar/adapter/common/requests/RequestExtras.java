package com.unity3d.scar.adapter.common.requests;

import android.os.Bundle;

public class RequestExtras {

    /* renamed from: b  reason: collision with root package name */
    public static String f37050b = "query_info_type";

    /* renamed from: c  reason: collision with root package name */
    public static String f37051c = "requester_type_5";

    /* renamed from: d  reason: collision with root package name */
    public static String f37052d = "UnityScar";

    /* renamed from: a  reason: collision with root package name */
    private String f37053a;

    public RequestExtras(String str) {
        this.f37053a = f37052d + str;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString(f37050b, f37051c);
        return bundle;
    }

    public String b() {
        return this.f37053a;
    }
}
