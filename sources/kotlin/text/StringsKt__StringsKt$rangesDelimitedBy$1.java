package kotlin.text;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class StringsKt__StringsKt$rangesDelimitedBy$1 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ char[] f40561f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f40562g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$rangesDelimitedBy$1(char[] cArr, boolean z2) {
        super(2);
        this.f40561f = cArr;
        this.f40562g = z2;
    }

    public final Pair<Integer, Integer> a(CharSequence charSequence, int i2) {
        Intrinsics.f(charSequence, "$this$$receiver");
        int X = StringsKt__StringsKt.X(charSequence, this.f40561f, i2, this.f40562g);
        if (X < 0) {
            return null;
        }
        return TuplesKt.a(Integer.valueOf(X), 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a((CharSequence) obj, ((Number) obj2).intValue());
    }
}
