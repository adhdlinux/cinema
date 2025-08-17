package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.util.Util;

public final class TextEmphasisSpan implements LanguageFeatureSpan {

    /* renamed from: d  reason: collision with root package name */
    private static final String f4606d = Util.B0(0);

    /* renamed from: e  reason: collision with root package name */
    private static final String f4607e = Util.B0(1);

    /* renamed from: f  reason: collision with root package name */
    private static final String f4608f = Util.B0(2);

    /* renamed from: a  reason: collision with root package name */
    public int f4609a;

    /* renamed from: b  reason: collision with root package name */
    public int f4610b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4611c;

    public TextEmphasisSpan(int i2, int i3, int i4) {
        this.f4609a = i2;
        this.f4610b = i3;
        this.f4611c = i4;
    }

    public static TextEmphasisSpan a(Bundle bundle) {
        return new TextEmphasisSpan(bundle.getInt(f4606d), bundle.getInt(f4607e), bundle.getInt(f4608f));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f4606d, this.f4609a);
        bundle.putInt(f4607e, this.f4610b);
        bundle.putInt(f4608f, this.f4611c);
        return bundle;
    }
}
