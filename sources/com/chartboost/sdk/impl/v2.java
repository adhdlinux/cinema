package com.chartboost.sdk.impl;

import android.os.Build;
import com.chartboost.sdk.internal.Networking.NetworkHelper;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class v2 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18816a = new a((DefaultConstructorMarker) null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SSLSocketFactory a() {
            SSLContext sSLContext;
            if (Build.VERSION.SDK_INT >= 29) {
                sSLContext = SSLContext.getInstance("TLSv1.3");
            } else {
                sSLContext = SSLContext.getInstance("TLSv1.2");
            }
            if (NetworkHelper.a()) {
                sSLContext.init((KeyManager[]) null, (TrustManager[]) new X509TrustManager[]{la.f()}, (SecureRandom) null);
            } else {
                sSLContext.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            }
            sSLContext.createSSLEngine();
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            Intrinsics.e(socketFactory, "sslContext.socketFactory");
            return socketFactory;
        }

        public a() {
        }
    }

    public static final SSLSocketFactory a() {
        return f18816a.a();
    }
}
