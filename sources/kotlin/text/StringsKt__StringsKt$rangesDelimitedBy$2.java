package kotlin.text;

import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ List<String> f40563f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f40564g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$rangesDelimitedBy$2(List<String> list, boolean z2) {
        super(2);
        this.f40563f = list;
        this.f40564g = z2;
    }

    public final Pair<Integer, Integer> a(CharSequence charSequence, int i2) {
        Intrinsics.f(charSequence, "$this$$receiver");
        Pair H = StringsKt__StringsKt.O(charSequence, this.f40563f, i2, this.f40564g, false);
        if (H != null) {
            return TuplesKt.a(H.c(), Integer.valueOf(((String) H.d()).length()));
        }
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a((CharSequence) obj, ((Number) obj2).intValue());
    }
}
