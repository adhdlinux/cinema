package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

public final class RubySpan implements LanguageFeatureSpan {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4602c = Util.B0(0);

    /* renamed from: d  reason: collision with root package name */
    private static final String f4603d = Util.B0(1);

    /* renamed from: a  reason: collision with root package name */
    public final String f4604a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4605b;

    public RubySpan(String str, int i2) {
        this.f4604a = str;
        this.f4605b = i2;
    }

    public static RubySpan a(Bundle bundle) {
        return new RubySpan((String) Assertions.f(bundle.getString(f4602c)), bundle.getInt(f4603d));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(f4602c, this.f4604a);
        bundle.putInt(f4603d, this.f4605b);
        return bundle;
    }
}
