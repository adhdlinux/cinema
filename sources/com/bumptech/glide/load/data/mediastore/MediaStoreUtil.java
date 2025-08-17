package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.unity3d.services.core.device.MimeTypes;

public final class MediaStoreUtil {
    private MediaStoreUtil() {
    }

    public static boolean a(Uri uri) {
        return b(uri) && !e(uri);
    }

    public static boolean b(Uri uri) {
        if (uri == null || !"content".equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            return false;
        }
        return true;
    }

    public static boolean c(Uri uri) {
        return b(uri) && e(uri);
    }

    public static boolean d(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains(MimeTypes.BASE_TYPE_VIDEO);
    }
}
