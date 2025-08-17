package com.startapp;

import android.app.Activity;
import android.content.Context;
import com.startapp.ic;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.common.advertisingid.AdvertisingIdResolver;
import com.uwetrottmann.thetvdb.TheTvdb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class w8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36819a;

    /* renamed from: b  reason: collision with root package name */
    public final AdvertisingIdResolver f36820b;

    /* renamed from: c  reason: collision with root package name */
    public final id f36821c;

    /* renamed from: d  reason: collision with root package name */
    public final r9 f36822d;

    /* renamed from: e  reason: collision with root package name */
    public final ua<x8> f36823e;

    public w8(Context context, AdvertisingIdResolver advertisingIdResolver, id idVar, r9 r9Var, ua<x8> uaVar) {
        this.f36819a = context;
        this.f36820b = advertisingIdResolver;
        this.f36821c = idVar;
        this.f36822d = r9Var;
        this.f36823e = uaVar;
    }

    public final ic.a a(String str, q6 q6Var, sa<String, Void> saVar) {
        Map<String, String> map;
        if (q6Var != null) {
            map = a();
            try {
                cb cbVar = new cb();
                q6Var.a((eb) cbVar);
                String cbVar2 = cbVar.toString();
                if (!str.contains("?") || !cbVar2.startsWith("?")) {
                    str = str + cbVar2;
                } else {
                    str = str + "&" + cbVar2.substring(1);
                }
            } catch (SDKException e2) {
                y8.a(this.f36819a, (Throwable) e2);
                return null;
            }
        } else {
            map = null;
        }
        String a2 = ic.a(this.f36819a);
        boolean z2 = b().f36925b;
        long currentTimeMillis = System.currentTimeMillis();
        r9 r9Var = this.f36822d;
        r9Var.getClass();
        u9 u9Var = new u9(r9Var);
        try {
            ic.a a3 = ic.a(str, map, a2, z2);
            u9Var.a("GET", str, (SDKException) null);
            a3.f34703d = currentTimeMillis;
            a3.f34704e = u9Var.f36661b;
            a3.f34705f = lb.a();
            return a3;
        } catch (SDKException e3) {
            u9Var.a("GET", str, e3);
            if (saVar != null) {
                saVar.a(e3.getMessage());
            }
        } catch (Throwable th) {
            y8.a(this.f36819a, th);
        }
        return null;
    }

    public final x8 b() {
        x8 call = this.f36823e.call();
        if (call != null) {
            return call;
        }
        return x8.f36924a;
    }

    public final String a(String str, q6 q6Var, byte[] bArr, boolean z2, sa<String, Void> saVar) {
        Map<String, String> map;
        if (bArr != null) {
            map = null;
        } else if (q6Var != null) {
            Map<String, String> a2 = a();
            try {
                ab abVar = new ab();
                q6Var.a((eb) abVar);
                byte[] bytes = abVar.f34212a.toString().getBytes();
                if (b().f36925b) {
                    try {
                        Map<Activity, Integer> map2 = lb.f34876a;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.close();
                        bytes = byteArrayOutputStream.toByteArray();
                        z2 = true;
                    } catch (IOException e2) {
                        y8.a(this.f36819a, (Throwable) e2);
                    }
                }
                Map<String, String> map3 = a2;
                bArr = bytes;
                map = map3;
            } catch (SDKException e3) {
                y8.a(this.f36819a, (Throwable) e3);
                return null;
            }
        } else {
            map = null;
            bArr = null;
        }
        String a3 = ic.a(this.f36819a);
        r9 r9Var = this.f36822d;
        r9Var.getClass();
        u9 u9Var = new u9(r9Var);
        try {
            String a4 = ic.a(str, bArr, map, a3, z2);
            u9Var.a("POST", str, (SDKException) null);
            return a4 != null ? a4 : "";
        } catch (SDKException e4) {
            u9Var.a("POST", str, e4);
            if (saVar != null) {
                saVar.a(e4.getMessage());
            }
        } catch (Throwable th) {
            y8.a(this.f36819a, th);
        }
        return null;
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        if (!b().f36926c) {
            String str = null;
            try {
                str = URLEncoder.encode(this.f36820b.a().f36967b, "UTF-8");
            } catch (Throwable th) {
                y8.a(this.f36819a, th);
            }
            hashMap.put("device-id", str);
        }
        hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, ((hd) this.f36821c.b()).f34647d);
        return hashMap;
    }
}
