package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2578a = versionedParcel.p(iconCompat.f2578a, 1);
        iconCompat.f2580c = versionedParcel.j(iconCompat.f2580c, 2);
        iconCompat.f2581d = versionedParcel.r(iconCompat.f2581d, 3);
        iconCompat.f2582e = versionedParcel.p(iconCompat.f2582e, 4);
        iconCompat.f2583f = versionedParcel.p(iconCompat.f2583f, 5);
        iconCompat.f2584g = (ColorStateList) versionedParcel.r(iconCompat.f2584g, 6);
        iconCompat.f2586i = versionedParcel.t(iconCompat.f2586i, 7);
        iconCompat.f2587j = versionedParcel.t(iconCompat.f2587j, 8);
        iconCompat.n();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.o(versionedParcel.f());
        int i2 = iconCompat.f2578a;
        if (-1 != i2) {
            versionedParcel.F(i2, 1);
        }
        byte[] bArr = iconCompat.f2580c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2581d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i3 = iconCompat.f2582e;
        if (i3 != 0) {
            versionedParcel.F(i3, 4);
        }
        int i4 = iconCompat.f2583f;
        if (i4 != 0) {
            versionedParcel.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f2584g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f2586i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f2587j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
