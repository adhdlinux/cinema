package com.startapp;

import android.app.Activity;
import java.util.Arrays;
import java.util.Map;

public class we extends ze {

    /* renamed from: a  reason: collision with root package name */
    public final z8 f36842a;

    /* renamed from: b  reason: collision with root package name */
    public final String f36843b;

    public we(z8 z8Var, String str) {
        this.f36842a = z8Var;
        this.f36843b = str;
    }

    public boolean a(Object obj) {
        if (!(obj instanceof h9)) {
            return false;
        }
        z8 z8Var = this.f36842a;
        y8 y8Var = ((h9) obj).f34627h0;
        if (z8Var != y8Var.f36951a) {
            return false;
        }
        String str = this.f36843b;
        if (str == null || str.equals(y8Var.f36954d)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || we.class != obj.getClass()) {
            return false;
        }
        we weVar = (we) obj;
        if (!lb.a(this.f36842a, weVar.f36842a) || !lb.a(this.f36843b, weVar.f36843b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.f36842a, this.f36843b};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
