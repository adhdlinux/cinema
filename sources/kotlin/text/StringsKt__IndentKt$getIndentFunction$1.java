package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class StringsKt__IndentKt$getIndentFunction$1 extends Lambda implements Function1<String, String> {

    /* renamed from: f  reason: collision with root package name */
    public static final StringsKt__IndentKt$getIndentFunction$1 f40559f = new StringsKt__IndentKt$getIndentFunction$1();

    StringsKt__IndentKt$getIndentFunction$1() {
        super(1);
    }

    /* renamed from: b */
    public final String invoke(String str) {
        Intrinsics.f(str, "line");
        return str;
    }
}
