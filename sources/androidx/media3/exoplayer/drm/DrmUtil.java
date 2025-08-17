package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import com.facebook.ads.AdError;

public final class DrmUtil {

    private static final class Api21 {
        private Api21() {
        }

        public static boolean a(Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }

        public static int b(Throwable th) {
            return Util.Y(Util.Z(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
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

    public static int a(Throwable th, int i2) {
        int i3 = Util.f4714a;
        if (i3 >= 21 && Api21.a(th)) {
            return Api21.b(th);
        }
        if (i3 >= 23 && Api23.a(th)) {
            return 6006;
        }
        if ((th instanceof NotProvisionedException) || b(th)) {
            return AdError.ICONVIEW_MISSING_ERROR_CODE;
        }
        if (th instanceof DeniedByServerException) {
            return 6007;
        }
        if (th instanceof UnsupportedDrmException) {
            return AdError.MEDIAVIEW_MISSING_ERROR_CODE;
        }
        if (th instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
        }
        if (th instanceof KeysExpiredException) {
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

    public static boolean b(Throwable th) {
        if (Util.f4714a != 34 || !(th instanceof NoSuchMethodError) || th.getMessage() == null || !th.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(")) {
            return false;
        }
        return true;
    }

    public static boolean c(Throwable th) {
        if (Util.f4714a != 34 || !(th instanceof NoSuchMethodError) || th.getMessage() == null || !th.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(")) {
            return false;
        }
        return true;
    }
}
