package kotlin.jvm.internal;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KTypeProjection;

final class TypeReference$asString$args$1 extends Lambda implements Function1<KTypeProjection, CharSequence> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ TypeReference f40441f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeReference$asString$args$1(TypeReference typeReference) {
        super(1);
        this.f40441f = typeReference;
    }

    /* renamed from: a */
    public final CharSequence invoke(KTypeProjection kTypeProjection) {
        Intrinsics.f(kTypeProjection, "it");
        return this.f40441f.g(kTypeProjection);
    }
}
