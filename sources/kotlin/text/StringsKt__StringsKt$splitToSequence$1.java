package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements Function1<IntRange, String> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ CharSequence f40565f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        super(1);
        this.f40565f = charSequence;
    }

    /* renamed from: a */
    public final String invoke(IntRange intRange) {
        Intrinsics.f(intRange, "it");
        return StringsKt__StringsKt.C0(this.f40565f, intRange);
    }
}
