package kotlin.text;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

final class MatcherMatchResult implements MatchResult {

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f40533a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f40534b;

    /* renamed from: c  reason: collision with root package name */
    private final MatchGroupCollection f40535c = new MatcherMatchResult$groups$1(this);

    /* renamed from: d  reason: collision with root package name */
    private List<String> f40536d;

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        Intrinsics.f(matcher, "matcher");
        Intrinsics.f(charSequence, "input");
        this.f40533a = matcher;
        this.f40534b = charSequence;
    }

    /* access modifiers changed from: private */
    public final MatchResult d() {
        return this.f40533a;
    }

    public List<String> a() {
        if (this.f40536d == null) {
            this.f40536d = new MatcherMatchResult$groupValues$1(this);
        }
        List<String> list = this.f40536d;
        Intrinsics.c(list);
        return list;
    }

    public IntRange b() {
        return RegexKt.g(d());
    }

    public String getValue() {
        String group = d().group();
        Intrinsics.e(group, "matchResult.group()");
        return group;
    }

    public MatchResult next() {
        int i2;
        int end = d().end();
        if (d().end() == d().start()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i3 = end + i2;
        if (i3 > this.f40534b.length()) {
            return null;
        }
        Matcher matcher = this.f40533a.pattern().matcher(this.f40534b);
        Intrinsics.e(matcher, "matcher.pattern().matcher(input)");
        return RegexKt.e(matcher, i3, this.f40534b);
    }
}
