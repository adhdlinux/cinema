package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.n.l;

public class NativeAdView {

    public enum Type {
        HEIGHT_300(l.HEIGHT_300),
        HEIGHT_400(l.HEIGHT_400);
        

        /* renamed from: a  reason: collision with root package name */
        private final l f19533a;

        private Type(l lVar) {
            this.f19533a = lVar;
        }

        static Type a(l lVar) {
            if (lVar == l.HEIGHT_300) {
                return HEIGHT_300;
            }
            if (lVar == l.HEIGHT_400) {
                return HEIGHT_400;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public l a() {
            return this.f19533a;
        }

        public int getHeight() {
            return this.f19533a.b();
        }

        public int getValue() {
            return this.f19533a.b();
        }

        public int getWidth() {
            return this.f19533a.a();
        }
    }

    public static View render(Context context, NativeAd nativeAd, Type type) {
        return render(context, nativeAd, type, (NativeAdViewAttributes) null);
    }

    public static View render(Context context, NativeAd nativeAd, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAd.isNativeConfigEnabled()) {
            nativeAdViewAttributes = nativeAd.getAdViewAttributes();
        } else if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        nativeAd.a(type);
        return new ANGenericTemplateView(context, nativeAd, nativeAdViewAttributes != null ? nativeAdViewAttributes.a() : null);
    }
}
