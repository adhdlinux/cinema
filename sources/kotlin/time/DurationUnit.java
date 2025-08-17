package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.enums.EnumEntriesKt;

public enum DurationUnit {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);
    

    /* renamed from: b  reason: collision with root package name */
    private final TimeUnit f40583b;

    static {
        DurationUnit[] a2;
        f40582k = EnumEntriesKt.a(a2);
    }

    private DurationUnit(TimeUnit timeUnit) {
        this.f40583b = timeUnit;
    }

    public final TimeUnit b() {
        return this.f40583b;
    }
}
