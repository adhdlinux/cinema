package kotlin.text;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

public final class MatchGroup {

    /* renamed from: a  reason: collision with root package name */
    private final String f40531a;

    /* renamed from: b  reason: collision with root package name */
    private final IntRange f40532b;

    public MatchGroup(String str, IntRange intRange) {
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        Intrinsics.f(intRange, "range");
        this.f40531a = str;
        this.f40532b = intRange;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return Intrinsics.a(this.f40531a, matchGroup.f40531a) && Intrinsics.a(this.f40532b, matchGroup.f40532b);
    }

    public int hashCode() {
        return (this.f40531a.hashCode() * 31) + this.f40532b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f40531a + ", range=" + this.f40532b + ')';
    }
}
