package com.startapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import java.util.Map;

public class ye extends ze {

    /* renamed from: a  reason: collision with root package name */
    public final String f36971a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f36972b;

    public ye(String str, Map<String, String> map) {
        this.f36971a = str;
        this.f36972b = map;
    }

    public boolean a(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (pair.first != this) {
            return false;
        }
        Object obj2 = pair.second;
        if (!(obj2 instanceof Intent)) {
            return false;
        }
        Intent intent = (Intent) obj2;
        if (!this.f36971a.equals(intent.getAction())) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        for (Map.Entry next : this.f36972b.entrySet()) {
            if (!((String) next.getValue()).equals(String.valueOf(extras.get((String) next.getKey())))) {
                return false;
            }
        }
        return true;
    }
}
