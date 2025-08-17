package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;

public class DefaultTrackNameProvider implements TrackNameProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f27876a;

    public DefaultTrackNameProvider(Resources resources) {
        this.f27876a = (Resources) Assertions.e(resources);
    }

    private String b(Format format) {
        int i2 = format.f23084z;
        if (i2 == -1 || i2 < 1) {
            return "";
        }
        if (i2 == 1) {
            return this.f27876a.getString(R$string.f28017q);
        }
        if (i2 == 2) {
            return this.f27876a.getString(R$string.f28026z);
        }
        if (i2 == 6 || i2 == 7) {
            return this.f27876a.getString(R$string.B);
        }
        if (i2 != 8) {
            return this.f27876a.getString(R$string.A);
        }
        return this.f27876a.getString(R$string.C);
    }

    private String c(Format format) {
        int i2 = format.f23067i;
        if (i2 == -1) {
            return "";
        }
        return this.f27876a.getString(R$string.f28016p, new Object[]{Float.valueOf(((float) i2) / 1000000.0f)});
    }

    private String d(Format format) {
        return TextUtils.isEmpty(format.f23061c) ? "" : format.f23061c;
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
        String str = format.f23062d;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        if (Util.f28808a >= 21) {
            locale = Locale.forLanguageTag(str);
        } else {
            locale = new Locale(str);
        }
        Locale R = Util.R();
        String displayName = locale.getDisplayName(R);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, offsetByCodePoints).toUpperCase(R) + displayName.substring(offsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    private String g(Format format) {
        int i2 = format.f23076r;
        int i3 = format.f23077s;
        if (i2 == -1 || i3 == -1) {
            return "";
        }
        return this.f27876a.getString(R$string.f28018r, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    private String h(Format format) {
        String str;
        if ((format.f23064f & 2) != 0) {
            str = this.f27876a.getString(R$string.f28019s);
        } else {
            str = "";
        }
        if ((format.f23064f & 4) != 0) {
            str = j(str, this.f27876a.getString(R$string.f28022v));
        }
        if ((format.f23064f & 8) != 0) {
            str = j(str, this.f27876a.getString(R$string.f28021u));
        }
        if ((format.f23064f & 1088) == 0) {
            return str;
        }
        return j(str, this.f27876a.getString(R$string.f28020t));
    }

    private static int i(Format format) {
        int k2 = MimeTypes.k(format.f23071m);
        if (k2 != -1) {
            return k2;
        }
        if (MimeTypes.n(format.f23068j) != null) {
            return 2;
        }
        if (MimeTypes.c(format.f23068j) != null) {
            return 1;
        }
        if (format.f23076r != -1 || format.f23077s != -1) {
            return 2;
        }
        if (format.f23084z == -1 && format.A == -1) {
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
                    str = this.f27876a.getString(R$string.f28015o, new Object[]{str, str2});
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
        if (str.length() == 0) {
            return this.f27876a.getString(R$string.D);
        }
        return str;
    }
}
