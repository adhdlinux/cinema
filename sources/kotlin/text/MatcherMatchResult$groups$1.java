package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchGroupCollection {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult f40538b;

    MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f40538b = matcherMatchResult;
    }

    public int a() {
        return this.f40538b.d().groupCount() + 1;
    }

    public /* bridge */ boolean b(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj == null ? true : obj instanceof MatchGroup)) {
            return false;
        }
        return b((MatchGroup) obj);
    }

    public MatchGroup d(int i2) {
        IntRange d2 = RegexKt.h(this.f40538b.d(), i2);
        if (d2.i().intValue() < 0) {
            return null;
        }
        String group = this.f40538b.d().group(i2);
        Intrinsics.e(group, "matchResult.group(index)");
        return new MatchGroup(group, d2);
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<MatchGroup> iterator() {
        return SequencesKt___SequencesKt.k(CollectionsKt___CollectionsKt.y(CollectionsKt__CollectionsKt.g(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }
}
