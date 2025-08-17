package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

final class ChronoPeriodImpl extends ChronoPeriod implements Serializable {
    private static final long serialVersionUID = 275618735781L;
    private final Chronology chronology;
    private final int days;
    private final int months;
    private final int years;

    public ChronoPeriodImpl(Chronology chronology2, int i2, int i3, int i4) {
        this.chronology = chronology2;
        this.years = i2;
        this.months = i3;
        this.days = i4;
    }

    public Temporal addTo(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        Chronology chronology2 = (Chronology) temporal.query(TemporalQueries.chronology());
        if (chronology2 == null || this.chronology.equals(chronology2)) {
            int i2 = this.years;
            if (i2 != 0) {
                temporal = temporal.plus((long) i2, ChronoUnit.YEARS);
            }
            int i3 = this.months;
            if (i3 != 0) {
                temporal = temporal.plus((long) i3, ChronoUnit.MONTHS);
            }
            int i4 = this.days;
            if (i4 != 0) {
                return temporal.plus((long) i4, ChronoUnit.DAYS);
            }
            return temporal;
        }
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + chronology2.getId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoPeriodImpl)) {
            return false;
        }
        ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) obj;
        if (this.years == chronoPeriodImpl.years && this.months == chronoPeriodImpl.months && this.days == chronoPeriodImpl.days && this.chronology.equals(chronoPeriodImpl.chronology)) {
            return true;
        }
        return false;
    }

    public long get(TemporalUnit temporalUnit) {
        int i2;
        if (temporalUnit == ChronoUnit.YEARS) {
            i2 = this.years;
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            i2 = this.months;
        } else if (temporalUnit == ChronoUnit.DAYS) {
            i2 = this.days;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return (long) i2;
    }

    public Chronology getChronology() {
        return this.chronology;
    }

    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new TemporalUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public int hashCode() {
        return this.chronology.hashCode() + Integer.rotateLeft(this.years, 16) + Integer.rotateLeft(this.months, 8) + this.days;
    }

    public ChronoPeriod minus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) temporalAmount;
            if (chronoPeriodImpl.getChronology().equals(getChronology())) {
                return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeSubtract(this.years, chronoPeriodImpl.years), Jdk8Methods.safeSubtract(this.months, chronoPeriodImpl.months), Jdk8Methods.safeSubtract(this.days, chronoPeriodImpl.days));
            }
        }
        throw new DateTimeException("Unable to subtract amount: " + temporalAmount);
    }

    public ChronoPeriod multipliedBy(int i2) {
        return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeMultiply(this.years, i2), Jdk8Methods.safeMultiply(this.months, i2), Jdk8Methods.safeMultiply(this.days, i2));
    }

    public ChronoPeriod normalized() {
        Chronology chronology2 = this.chronology;
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        if (!chronology2.range(chronoField).isFixed()) {
            return this;
        }
        long maximum = (this.chronology.range(chronoField).getMaximum() - this.chronology.range(chronoField).getMinimum()) + 1;
        long j2 = (((long) this.years) * maximum) + ((long) this.months);
        return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeToInt(j2 / maximum), Jdk8Methods.safeToInt(j2 % maximum), this.days);
    }

    public ChronoPeriod plus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) temporalAmount;
            if (chronoPeriodImpl.getChronology().equals(getChronology())) {
                return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeAdd(this.years, chronoPeriodImpl.years), Jdk8Methods.safeAdd(this.months, chronoPeriodImpl.months), Jdk8Methods.safeAdd(this.days, chronoPeriodImpl.days));
            }
        }
        throw new DateTimeException("Unable to add amount: " + temporalAmount);
    }

    public Temporal subtractFrom(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        Chronology chronology2 = (Chronology) temporal.query(TemporalQueries.chronology());
        if (chronology2 == null || this.chronology.equals(chronology2)) {
            int i2 = this.years;
            if (i2 != 0) {
                temporal = temporal.minus((long) i2, ChronoUnit.YEARS);
            }
            int i3 = this.months;
            if (i3 != 0) {
                temporal = temporal.minus((long) i3, ChronoUnit.MONTHS);
            }
            int i4 = this.days;
            if (i4 != 0) {
                return temporal.minus((long) i4, ChronoUnit.DAYS);
            }
            return temporal;
        }
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + chronology2.getId());
    }

    public String toString() {
        if (isZero()) {
            return this.chronology + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.chronology);
        sb.append(' ');
        sb.append('P');
        int i2 = this.years;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('Y');
        }
        int i3 = this.months;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        int i4 = this.days;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('D');
        }
        return sb.toString();
    }
}
