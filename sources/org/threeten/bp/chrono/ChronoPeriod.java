package org.threeten.bp.chrono;

import java.util.List;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class ChronoPeriod implements TemporalAmount {
    public static ChronoPeriod between(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
        Jdk8Methods.requireNonNull(chronoLocalDate, "startDateInclusive");
        Jdk8Methods.requireNonNull(chronoLocalDate2, "endDateExclusive");
        return chronoLocalDate.until(chronoLocalDate2);
    }

    public abstract Temporal addTo(Temporal temporal);

    public abstract boolean equals(Object obj);

    public abstract long get(TemporalUnit temporalUnit);

    public abstract Chronology getChronology();

    public abstract List<TemporalUnit> getUnits();

    public abstract int hashCode();

    public boolean isNegative() {
        for (TemporalUnit temporalUnit : getUnits()) {
            if (get(temporalUnit) < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isZero() {
        for (TemporalUnit temporalUnit : getUnits()) {
            if (get(temporalUnit) != 0) {
                return false;
            }
        }
        return true;
    }

    public abstract ChronoPeriod minus(TemporalAmount temporalAmount);

    public abstract ChronoPeriod multipliedBy(int i2);

    public ChronoPeriod negated() {
        return multipliedBy(-1);
    }

    public abstract ChronoPeriod normalized();

    public abstract ChronoPeriod plus(TemporalAmount temporalAmount);

    public abstract Temporal subtractFrom(Temporal temporal);

    public abstract String toString();
}
