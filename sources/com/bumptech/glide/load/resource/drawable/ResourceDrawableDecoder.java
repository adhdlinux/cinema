package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.facebook.common.util.UriUtil;
import java.util.List;

public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16905a;

    public ResourceDrawableDecoder(Context context) {
        this.f16905a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        if (str.equals(this.f16905a.getPackageName())) {
            return this.f16905a;
        }
        try {
            return this.f16905a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f16905a.getPackageName())) {
                return this.f16905a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }

    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    /* renamed from: c */
    public Resource<Drawable> b(Uri uri, int i2, int i3, Options options) {
        Context d2 = d(uri, uri.getAuthority());
        return NonOwnedDrawableResource.c(DrawableDecoderCompat.b(this.f16905a, d2, g(d2, uri)));
    }

    /* renamed from: h */
    public boolean a(Uri uri, Options options) {
        return uri.getScheme().equals(UriUtil.QUALIFIED_RESOURCE_SCHEME);
    }
}
