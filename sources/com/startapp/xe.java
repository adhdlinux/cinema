package com.startapp;

import android.app.Activity;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class xe extends ze {

    /* renamed from: a  reason: collision with root package name */
    public final List<z8> f36931a;

    public xe(List<z8> list) {
        this.f36931a = list;
    }

    public boolean a(Object obj) {
        if (obj instanceof h9) {
            return this.f36931a.contains(((h9) obj).f34627h0.f36951a);
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xe.class != obj.getClass()) {
            return false;
        }
        return lb.a(this.f36931a, ((xe) obj).f36931a);
    }

    public int hashCode() {
        Object[] objArr = {this.f36931a};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
