package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.ads.internal.c.a;

public class ParcelUtils {
    private ParcelUtils() {
    }

    public static <T extends VersionedParcelable> T a(Parcelable parcelable) {
        if (parcelable instanceof ParcelImpl) {
            return ((ParcelImpl) parcelable).b();
        }
        throw new IllegalArgumentException("Invalid parcel");
    }

    public static <T extends VersionedParcelable> T b(Bundle bundle, String str) {
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable(str);
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(ParcelUtils.class.getClassLoader());
            return a(bundle2.getParcelable(a.f20042a));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static void c(Bundle bundle, String str, VersionedParcelable versionedParcelable) {
        if (versionedParcelable != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(a.f20042a, d(versionedParcelable));
            bundle.putParcelable(str, bundle2);
        }
    }

    public static Parcelable d(VersionedParcelable versionedParcelable) {
        return new ParcelImpl(versionedParcelable);
    }
}
