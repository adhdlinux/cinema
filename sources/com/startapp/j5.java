package com.startapp;

import android.content.Context;
import android.util.Base64;
import com.startapp.b6;
import com.startapp.h5;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.cache.CachedVideoAd;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public class j5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34733a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34734b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b6.b f34735c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h5.a f34736d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m5 f34737e;

    public j5(m5 m5Var, Context context, String str, b6.b bVar, h5.a aVar) {
        this.f34737e = m5Var;
        this.f34733a = context;
        this.f34734b = str;
        this.f34735c = bVar;
        this.f34736d = aVar;
    }

    public void run() {
        String str;
        m5 m5Var = this.f34737e;
        Context context = this.f34733a;
        String str2 = this.f34734b;
        b6.b bVar = this.f34735c;
        h5.a aVar = this.f34736d;
        if (m5Var.f34900b == null) {
            LinkedList<CachedVideoAd> linkedList = (LinkedList) ra.a(context, "CachedAds", LinkedList.class);
            m5Var.f34900b = linkedList;
            if (linkedList == null) {
                m5Var.f34900b = new LinkedList<>();
            }
            if (m5Var.a(AdsCommonMetaData.f36186h.G().b())) {
                ra.b(context, "CachedAds", m5Var.f34900b);
            }
        }
        try {
            URL url = new URL(str2);
            String str3 = url.getHost() + url.getPath().replace("/", "_");
            try {
                String substring = str3.substring(0, str3.lastIndexOf(46));
                str = new String(Base64.encodeToString(MessageDigest.getInstance("MD5").digest(substring.getBytes()), 0)).replaceAll("[^a-zA-Z0-9]+", "_") + str3.substring(str3.lastIndexOf(46));
            } catch (NoSuchAlgorithmException e2) {
                y8.a(context, (Throwable) e2);
                str = str3;
            }
            new b6(context, url, str, new k5(m5Var, bVar, new CachedVideoAd(str), context), new l5(m5Var, aVar)).a();
        } catch (MalformedURLException e3) {
            if (bVar != null) {
                bVar.a((String) null);
            }
            y8.a(context, (Throwable) e3);
        }
    }
}
