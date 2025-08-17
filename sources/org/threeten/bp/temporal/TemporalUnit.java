package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

public interface TemporalUnit {
    <R extends Temporal> R addTo(R r2, long j2);

    long between(Temporal temporal, Temporal temporal2);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(Temporal temporal);

    boolean isTimeBased();

    String toString();
}
