package com.startapp;

import android.app.Activity;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class db {

    /* renamed from: a  reason: collision with root package name */
    public String f34366a;

    /* renamed from: b  reason: collision with root package name */
    public String f34367b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f34368c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || db.class != obj.getClass()) {
            return false;
        }
        return this.f34366a.equals(((db) obj).f34366a);
    }

    public int hashCode() {
        Object[] objArr = {this.f34366a};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public String toString() {
        return "NameValueObject [name=" + this.f34366a + ", value=" + this.f34367b + ", valueSet=" + this.f34368c + "]";
    }
}
