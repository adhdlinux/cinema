package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class StringsKt___StringsKt$windowed$1 extends Lambda implements Function1<CharSequence, String> {

    /* renamed from: f  reason: collision with root package name */
    public static final StringsKt___StringsKt$windowed$1 f40566f = new StringsKt___StringsKt$windowed$1();

    StringsKt___StringsKt$windowed$1() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(CharSequence charSequence) {
        Intrinsics.f(charSequence, "it");
        return charSequence.toString();
    }
}
