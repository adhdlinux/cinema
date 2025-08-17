package androidx.media3.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Locale;

public class DefaultTrackNameProvider implements TrackNameProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f9798a;

    public DefaultTrackNameProvider(Resources resources) {
        this.f9798a = (Resources) Assertions.f(resources);
    }

    private String b(Format format) {
        int i2 = format.B;
        if (i2 == -1 || i2 < 1) {
            return "";
        }
        if (i2 == 1) {
            return this.f9798a.getString(R$string.f10044q);
        }
        if (i2 == 2) {
            return this.f9798a.getString(R$string.f10053z);
        }
        if (i2 == 6 || i2 == 7) {
            return this.f9798a.getString(R$string.B);
        }
        if (i2 != 8) {
            return this.f9798a.getString(R$string.A);
        }
        return this.f9798a.getString(R$string.C);
    }

    private String c(Format format) {
        int i2 = format.f4010i;
        if (i2 == -1) {
            return "";
        }
        return this.f9798a.getString(R$string.f10043p, new Object[]{Float.valueOf(((float) i2) / 1000000.0f)});
    }

    private String d(Format format) {
        return TextUtils.isEmpty(format.f4003b) ? "" : format.f4003b;
    }

    private String e(Format format) {
        String j2 = j(f(format), h(format));
        if (TextUtils.isEmpty(j2)) {
            return d(format);
        }
        return j2;
    }

    private String f(Format format) {
        Locale locale;
        String str = format.f4005d;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        if (Util.f4714a >= 21) {
            locale = Locale.forLanguageTag(str);
        } else {
            locale = new Locale(str);
        }
        Locale V = Util.V();
        String displayName = locale.getDisplayName(V);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, offsetByCodePoints).toUpperCase(V) + displayName.substring(offsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    private String g(Format format) {
        int i2 = format.f4021t;
        int i3 = format.f4022u;
        if (i2 == -1 || i3 == -1) {
            return "";
        }
        return this.f9798a.getString(R$string.f10045r, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    private String h(Format format) {
        String str;
        if ((format.f4007f & 2) != 0) {
            str = this.f9798a.getString(R$string.f10046s);
        } else {
            str = "";
        }
        if ((format.f4007f & 4) != 0) {
            str = j(str, this.f9798a.getString(R$string.f10049v));
        }
        if ((format.f4007f & 8) != 0) {
            str = j(str, this.f9798a.getString(R$string.f10048u));
        }
        if ((format.f4007f & 1088) == 0) {
            return str;
        }
        return j(str, this.f9798a.getString(R$string.f10047t));
    }

    private static int i(Format format) {
        int k2 = MimeTypes.k(format.f4015n);
        if (k2 != -1) {
            return k2;
        }
        if (MimeTypes.n(format.f4011j) != null) {
            return 2;
        }
        if (MimeTypes.c(format.f4011j) != null) {
            return 1;
        }
        if (format.f4021t != -1 || format.f4022u != -1) {
            return 2;
        }
        if (format.B == -1 && format.C == -1) {
            return -1;
        }
        return 1;
    }

    private String j(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.f9798a.getString(R$string.f10042o, new Object[]{str, str2});
                }
            }
        }
        return str;
    }

    public String a(Format format) {
        String str;
        int i2 = i(format);
        if (i2 == 2) {
            str = j(h(format), g(format), c(format));
        } else if (i2 == 1) {
            str = j(e(format), b(format), c(format));
        } else {
            str = e(format);
        }
        if (str.length() != 0) {
            return str;
        }
        String str2 = format.f4005d;
        if (str2 == null || str2.trim().isEmpty()) {
            return this.f9798a.getString(R$string.D);
        }
        return this.f9798a.getString(R$string.exo_track_unknown_name, new Object[]{str2});
    }
}
