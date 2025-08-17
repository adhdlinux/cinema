package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

final class LocaleListCompatWrapper implements LocaleListInterface {

    /* renamed from: c  reason: collision with root package name */
    private static final Locale[] f2618c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Locale f2619d = new Locale("en", "XA");

    /* renamed from: e  reason: collision with root package name */
    private static final Locale f2620e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    private static final Locale f2621f = LocaleListCompat.b("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    private final Locale[] f2622a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2623b;

    LocaleListCompatWrapper(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f2622a = f2618c;
            this.f2623b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < localeArr.length) {
            Locale locale = localeArr[i2];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    c(sb, locale2);
                    if (i2 < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                }
                i2++;
            } else {
                throw new NullPointerException("list[" + i2 + "] is null");
            }
        }
        this.f2622a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f2623b = sb.toString();
    }

    static void c(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append('-');
            sb.append(locale.getCountry());
        }
    }

    public String a() {
        return this.f2623b;
    }

    public Object b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).f2622a;
        if (this.f2622a.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.f2622a;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    public Locale get(int i2) {
        if (i2 >= 0) {
            Locale[] localeArr = this.f2622a;
            if (i2 < localeArr.length) {
                return localeArr[i2];
            }
        }
        return null;
    }

    public int hashCode() {
        int i2 = 1;
        for (Locale hashCode : this.f2622a) {
            i2 = (i2 * 31) + hashCode.hashCode();
        }
        return i2;
    }

    public boolean isEmpty() {
        return this.f2622a.length == 0;
    }

    public int size() {
        return this.f2622a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f2622a;
            if (i2 < localeArr.length) {
                sb.append(localeArr[i2]);
                if (i2 < this.f2622a.length - 1) {
                    sb.append(',');
                }
                i2++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
