package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class StringsKt__IndentKt$getIndentFunction$2 extends Lambda implements Function1<String, String> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f40560f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__IndentKt$getIndentFunction$2(String str) {
        super(1);
        this.f40560f = str;
    }

    /* renamed from: b */
    public final String invoke(String str) {
        Intrinsics.f(str, "line");
        return this.f40560f + str;
    }
}
