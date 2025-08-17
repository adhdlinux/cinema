package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.ranges.IntRange;

public final class RegexKt {
    /* access modifiers changed from: private */
    public static final MatchResult e(Matcher matcher, int i2, CharSequence charSequence) {
        if (!matcher.find(i2)) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final MatchResult f(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final IntRange g(MatchResult matchResult) {
        return RangesKt___RangesKt.j(matchResult.start(), matchResult.end());
    }

    /* access modifiers changed from: private */
    public static final IntRange h(MatchResult matchResult, int i2) {
        return RangesKt___RangesKt.j(matchResult.start(i2), matchResult.end(i2));
    }
}
