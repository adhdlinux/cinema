package org.threeten.bp.jdk8;

import com.facebook.common.time.Clock;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class DefaultInterfaceTemporal extends DefaultInterfaceTemporalAccessor implements Temporal {
    public Temporal minus(TemporalAmount temporalAmount) {
        return temporalAmount.subtractFrom(this);
    }

    public Temporal plus(TemporalAmount temporalAmount) {
        return temporalAmount.addTo(this);
    }

    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster.adjustInto(this);
    }

    public Temporal minus(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? plus(Clock.MAX_TIME, temporalUnit).plus(1, temporalUnit) : plus(-j2, temporalUnit);
    }
}
