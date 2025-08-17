package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import com.facebook.ads.AdError;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.util.Util;

public final class DrmUtil {

    private static final class Api18 {
        private Api18() {
        }

        public static boolean a(Throwable th) {
            return th instanceof DeniedByServerException;
        }

        public static boolean b(Throwable th) {
            return th instanceof NotProvisionedException;
        }
    }

    private static final class Api21 {
        private Api21() {
        }

        public static boolean a(Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }

        public static int b(Throwable th) {
            return Util.W(Util.X(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
    }

    private static final class Api23 {
        private Api23() {
        }

        public static boolean a(Throwable th) {
            return th instanceof MediaDrmResetException;
        }
    }

    private DrmUtil() {
    }

    public static int a(Exception exc, int i2) {
        int i3 = Util.f28808a;
        if (i3 >= 21 && Api21.a(exc)) {
            return Api21.b(exc);
        }
        if (i3 >= 23 && Api23.a(exc)) {
            return 6006;
        }
        if (i3 >= 18 && Api18.b(exc)) {
            return AdError.ICONVIEW_MISSING_ERROR_CODE;
        }
        if (i3 >= 18 && Api18.a(exc)) {
            return 6007;
        }
        if (exc instanceof UnsupportedDrmException) {
            return AdError.MEDIAVIEW_MISSING_ERROR_CODE;
        }
        if (exc instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
        }
        if (exc instanceof KeysExpiredException) {
            return 6008;
        }
        if (i2 == 1) {
            return 6006;
        }
        if (i2 == 2) {
            return 6004;
        }
        if (i2 == 3) {
            return AdError.ICONVIEW_MISSING_ERROR_CODE;
        }
        throw new IllegalArgumentException();
    }
}
