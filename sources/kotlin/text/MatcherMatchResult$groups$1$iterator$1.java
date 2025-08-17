package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements Function1<Integer, MatchGroup> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult$groups$1 f40539f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatcherMatchResult$groups$1$iterator$1(MatcherMatchResult$groups$1 matcherMatchResult$groups$1) {
        super(1);
        this.f40539f = matcherMatchResult$groups$1;
    }

    public final MatchGroup a(int i2) {
        return this.f40539f.d(i2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a(((Number) obj).intValue());
    }
}
