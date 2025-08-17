package kotlin.text;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class Regex$findAll$1 extends Lambda implements Function0<MatchResult> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Regex f40542f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ CharSequence f40543g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ int f40544h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Regex$findAll$1(Regex regex, CharSequence charSequence, int i2) {
        super(0);
        this.f40542f = regex;
        this.f40543g = charSequence;
        this.f40544h = i2;
    }

    /* renamed from: b */
    public final MatchResult invoke() {
        return this.f40542f.b(this.f40543g, this.f40544h);
    }
}
