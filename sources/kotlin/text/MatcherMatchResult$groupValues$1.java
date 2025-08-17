package kotlin.text;

import kotlin.collections.AbstractList;

public final class MatcherMatchResult$groupValues$1 extends AbstractList<String> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult f40537c;

    MatcherMatchResult$groupValues$1(MatcherMatchResult matcherMatchResult) {
        this.f40537c = matcherMatchResult;
    }

    public int a() {
        return this.f40537c.d().groupCount() + 1;
    }

    public /* bridge */ boolean b(String str) {
        return super.contains(str);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return b((String) obj);
    }

    /* renamed from: d */
    public String get(int i2) {
        String group = this.f40537c.d().group(i2);
        return group == null ? "" : group;
    }

    public /* bridge */ int e(String str) {
        return super.indexOf(str);
    }

    public /* bridge */ int g(String str) {
        return super.lastIndexOf(str);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof String)) {
            return -1;
        }
        return e((String) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof String)) {
            return -1;
        }
        return g((String) obj);
    }
}
