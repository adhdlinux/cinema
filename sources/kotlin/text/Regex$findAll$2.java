package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {

    /* renamed from: c  reason: collision with root package name */
    public static final Regex$findAll$2 f40545c = new Regex$findAll$2();

    Regex$findAll$2() {
        super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    /* renamed from: a */
    public final MatchResult invoke(MatchResult matchResult) {
        Intrinsics.f(matchResult, "p0");
        return matchResult.next();
    }
}
