package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class LocaleListPlatformWrapper implements LocaleListInterface {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f2624a;

    LocaleListPlatformWrapper(Object obj) {
        this.f2624a = (LocaleList) obj;
    }

    public String a() {
        return this.f2624a.toLanguageTags();
    }

    public Object b() {
        return this.f2624a;
    }

    public boolean equals(Object obj) {
        return this.f2624a.equals(((LocaleListInterface) obj).b());
    }

    public Locale get(int i2) {
        return this.f2624a.get(i2);
    }

    public int hashCode() {
        return this.f2624a.hashCode();
    }

    public boolean isEmpty() {
        return this.f2624a.isEmpty();
    }

    public int size() {
        return this.f2624a.size();
    }

    public String toString() {
        return this.f2624a.toString();
    }
}
