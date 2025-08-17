package com.startapp;

import android.text.TextUtils;
import com.startapp.sdk.common.SDKException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

public class cb extends eb {

    /* renamed from: a  reason: collision with root package name */
    public final Set<db> f34302a = new HashSet();

    public void a(String str, Object obj, boolean z2, boolean z3) throws SDKException {
        if (z2 && obj == null) {
            throw new SDKException("Required value for key: [" + str + "] is missing", (Throwable) null);
        } else if (obj != null && !TextUtils.isEmpty(obj.toString())) {
            try {
                db dbVar = new db();
                dbVar.f34366a = str;
                String obj2 = obj.toString();
                if (z3) {
                    obj2 = URLEncoder.encode(obj2, "UTF-8");
                }
                dbVar.f34367b = obj2;
                if (!this.f34302a.add(dbVar)) {
                    this.f34302a.remove(dbVar);
                    this.f34302a.add(dbVar);
                }
            } catch (UnsupportedEncodingException e2) {
                if (z2) {
                    throw new SDKException("failed encoding value: [" + obj + "]", e2);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('?');
        for (db next : this.f34302a) {
            if (next.f34367b != null) {
                sb.append(next.f34366a);
                sb.append('=');
                sb.append(next.f34367b);
                sb.append('&');
            } else {
                Set<String> set = next.f34368c;
                if (set != null) {
                    for (String append : set) {
                        sb.append(next.f34366a);
                        sb.append('=');
                        sb.append(append);
                        sb.append('&');
                    }
                }
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString().replace("+", "%20");
    }

    public void a(String str, Set<String> set, boolean z2, boolean z3) throws SDKException {
        if (z2 && set == null) {
            throw new SDKException("Required value for key: [" + str + "] is missing", (Throwable) null);
        } else if (set != null) {
            db dbVar = new db();
            dbVar.f34366a = str;
            HashSet hashSet = new HashSet();
            for (String next : set) {
                if (z3) {
                    try {
                        next = URLEncoder.encode(next, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                hashSet.add(next);
            }
            if (!z2 || hashSet.size() != 0) {
                dbVar.f34368c = hashSet;
                if (!this.f34302a.add(dbVar)) {
                    this.f34302a.remove(dbVar);
                    this.f34302a.add(dbVar);
                    return;
                }
                return;
            }
            throw new SDKException("failed encoding value: [" + set + "]", (Throwable) null);
        }
    }
}
