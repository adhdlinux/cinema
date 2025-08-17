package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.n.l;

public class NativeBannerAdView {

    public enum Type {
        HEIGHT_100(l.HEIGHT_100),
        HEIGHT_120(l.HEIGHT_120);
        

        /* renamed from: a  reason: collision with root package name */
        private final l f19551a;

        private Type(l lVar) {
            this.f19551a = lVar;
        }

        static Type a(l lVar) {
            if (lVar == l.HEIGHT_100) {
                return HEIGHT_100;
            }
            if (lVar == l.HEIGHT_120) {
                return HEIGHT_120;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public l a() {
            return this.f19551a;
        }

        public int getHeight() {
            return this.f19551a.b();
        }

        public int getValue() {
            return this.f19551a.b();
        }

        public int getWidth() {
            return this.f19551a.a();
        }
    }

    public static View render(Context context, NativeBannerAd nativeBannerAd, Type type) {
        return render(context, nativeBannerAd, type, (NativeAdViewAttributes) null);
    }

    public static View render(Context context, NativeBannerAd nativeBannerAd, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeBannerAd.isNativeConfigEnabled()) {
            nativeAdViewAttributes = nativeBannerAd.getAdViewAttributes();
        } else if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        nativeBannerAd.a(type);
        return new ANGenericTemplateView(context, nativeBannerAd, nativeAdViewAttributes != null ? nativeAdViewAttributes.a() : null);
    }
}
