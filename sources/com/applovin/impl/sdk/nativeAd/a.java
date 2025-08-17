package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import java.io.File;
import java.util.Collections;

public class a extends com.applovin.impl.sdk.e.a {

    /* renamed from: a  reason: collision with root package name */
    private final e f15572a = new e();

    /* renamed from: c  reason: collision with root package name */
    private final AppLovinNativeAdImpl f15573c;

    /* renamed from: d  reason: collision with root package name */
    private final C0021a f15574d;

    /* renamed from: com.applovin.impl.sdk.nativeAd.a$a  reason: collision with other inner class name */
    public interface C0021a {
        void a(AppLovinNativeAdImpl appLovinNativeAdImpl);
    }

    public a(AppLovinNativeAdImpl appLovinNativeAdImpl, m mVar, C0021a aVar) {
        super("TaskCacheNativeAd", mVar);
        this.f15573c = appLovinNativeAdImpl;
        this.f15574d = aVar;
    }

    private Uri a(Uri uri) {
        String str;
        if (uri == null) {
            return null;
        }
        if (v.a()) {
            a("Attempting to cache resource: " + uri);
        }
        String a2 = this.f15333b.aa() != null ? this.f15333b.aa().a(f(), uri.toString(), this.f15573c.getCachePrefix(), Collections.emptyList(), false, this.f15572a) : this.f15333b.ab().a(f(), uri.toString(), this.f15573c.getCachePrefix(), Collections.emptyList(), false, this.f15572a);
        if (StringUtils.isValidString(a2)) {
            File a3 = this.f15333b.aa() != null ? this.f15333b.aa().a(a2, f()) : this.f15333b.ab().a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    return fromFile;
                }
                if (v.a()) {
                    str = "Unable to extract Uri from image file";
                }
            } else if (v.a()) {
                str = "Unable to retrieve File from cached image filename = " + a2;
            }
            d(str);
        }
        return null;
    }

    public void run() {
        if (v.a()) {
            a("Begin caching ad #" + this.f15573c.getAdIdNumber() + "...");
        }
        Uri a2 = a(this.f15573c.getIconUri());
        if (a2 != null) {
            this.f15573c.setIconUri(a2);
        }
        Uri a3 = a(this.f15573c.getMainImageUri());
        if (a3 != null) {
            this.f15573c.setMainImageUri(a3);
        }
        Uri a4 = a(this.f15573c.getPrivacyIconUri());
        if (a4 != null) {
            this.f15573c.setPrivacyIconUri(a4);
        }
        if (v.a()) {
            a("Finished caching ad #" + this.f15573c.getAdIdNumber());
        }
        this.f15574d.a(this.f15573c);
    }
}
