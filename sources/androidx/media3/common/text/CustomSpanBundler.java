package androidx.media3.common.text;

import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.ArrayList;

final class CustomSpanBundler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4597a = Util.B0(0);

    /* renamed from: b  reason: collision with root package name */
    private static final String f4598b = Util.B0(1);

    /* renamed from: c  reason: collision with root package name */
    private static final String f4599c = Util.B0(2);

    /* renamed from: d  reason: collision with root package name */
    private static final String f4600d = Util.B0(3);

    /* renamed from: e  reason: collision with root package name */
    private static final String f4601e = Util.B0(4);

    private CustomSpanBundler() {
    }

    public static ArrayList<Bundle> a(Spanned spanned) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        for (RubySpan rubySpan : (RubySpan[]) spanned.getSpans(0, spanned.length(), RubySpan.class)) {
            arrayList.add(b(spanned, rubySpan, 1, rubySpan.b()));
        }
        for (TextEmphasisSpan textEmphasisSpan : (TextEmphasisSpan[]) spanned.getSpans(0, spanned.length(), TextEmphasisSpan.class)) {
            arrayList.add(b(spanned, textEmphasisSpan, 2, textEmphasisSpan.b()));
        }
        for (HorizontalTextInVerticalContextSpan b2 : (HorizontalTextInVerticalContextSpan[]) spanned.getSpans(0, spanned.length(), HorizontalTextInVerticalContextSpan.class)) {
            arrayList.add(b(spanned, b2, 3, (Bundle) null));
        }
        return arrayList;
    }

    private static Bundle b(Spanned spanned, Object obj, int i2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f4597a, spanned.getSpanStart(obj));
        bundle2.putInt(f4598b, spanned.getSpanEnd(obj));
        bundle2.putInt(f4599c, spanned.getSpanFlags(obj));
        bundle2.putInt(f4600d, i2);
        if (bundle != null) {
            bundle2.putBundle(f4601e, bundle);
        }
        return bundle2;
    }

    public static void c(Bundle bundle, Spannable spannable) {
        int i2 = bundle.getInt(f4597a);
        int i3 = bundle.getInt(f4598b);
        int i4 = bundle.getInt(f4599c);
        int i5 = bundle.getInt(f4600d, -1);
        Bundle bundle2 = bundle.getBundle(f4601e);
        if (i5 == 1) {
            spannable.setSpan(RubySpan.a((Bundle) Assertions.f(bundle2)), i2, i3, i4);
        } else if (i5 == 2) {
            spannable.setSpan(TextEmphasisSpan.a((Bundle) Assertions.f(bundle2)), i2, i3, i4);
        } else if (i5 == 3) {
            spannable.setSpan(new HorizontalTextInVerticalContextSpan(), i2, i3, i4);
        }
    }
}
