package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class ChronoLocalDate extends DefaultInterfaceTemporal implements TemporalAdjuster, Comparable<ChronoLocalDate> {
    private static final Comparator<ChronoLocalDate> DATE_COMPARATOR = new Comparator<ChronoLocalDate>() {
        public int compare(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
            return Jdk8Methods.compareLongs(chronoLocalDate.toEpochDay(), chronoLocalDate2.toEpochDay());
        }
    };

    public static ChronoLocalDate from(TemporalAccessor temporalAccessor) {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        if (temporalAccessor instanceof ChronoLocalDate) {
            return (ChronoLocalDate) temporalAccessor;
        }
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology != null) {
            return chronology.date(temporalAccessor);
        }
        throw new DateTimeException("No Chronology found to create ChronoLocalDate: " + temporalAccessor.getClass());
    }

    public static Comparator<ChronoLocalDate> timeLineOrder() {
        return DATE_COMPARATOR;
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public ChronoLocalDateTime<?> atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.of(this, localTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoLocalDate) || compareTo((ChronoLocalDate) obj) != 0) {
            return false;
        }
        return true;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public abstract Chronology getChronology();

    public Era getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    public int hashCode() {
        long epochDay = toEpochDay();
        return getChronology().hashCode() ^ ((int) (epochDay ^ (epochDay >>> 32)));
    }

    public boolean isAfter(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() > chronoLocalDate.toEpochDay();
    }

    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() < chronoLocalDate.toEpochDay();
    }

    public boolean isEqual(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() == chronoLocalDate.toEpochDay();
    }

    public boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isDateBased();
        }
        return temporalField != null && temporalField.isSupportedBy(this);
    }

    public abstract int lengthOfMonth();

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public abstract ChronoLocalDate plus(long j2, TemporalUnit temporalUnit);

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return getChronology();
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            return LocalDate.ofEpochDay(toEpochDay());
        }
        if (temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return super.query(temporalQuery);
    }

    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    public String toString() {
        String str;
        long j2 = getLong(ChronoField.YEAR_OF_ERA);
        long j3 = getLong(ChronoField.MONTH_OF_YEAR);
        long j4 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(getChronology().toString());
        sb.append(" ");
        sb.append(getEra());
        sb.append(" ");
        sb.append(j2);
        String str2 = "-0";
        if (j3 < 10) {
            str = str2;
        } else {
            str = "-";
        }
        sb.append(str);
        sb.append(j3);
        if (j4 >= 10) {
            str2 = "-";
        }
        sb.append(str2);
        sb.append(j4);
        return sb.toString();
    }

    public abstract ChronoPeriod until(ChronoLocalDate chronoLocalDate);

    public abstract ChronoLocalDate with(TemporalField temporalField, long j2);

    public int compareTo(ChronoLocalDate chronoLocalDate) {
        int compareLongs = Jdk8Methods.compareLongs(toEpochDay(), chronoLocalDate.toEpochDay());
        return compareLongs == 0 ? getChronology().compareTo(chronoLocalDate.getChronology()) : compareLongs;
    }

    public ChronoLocalDate minus(TemporalAmount temporalAmount) {
        return getChronology().ensureChronoLocalDate(super.minus(temporalAmount));
    }

    public ChronoLocalDate plus(TemporalAmount temporalAmount) {
        return getChronology().ensureChronoLocalDate(super.plus(temporalAmount));
    }

    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return getChronology().ensureChronoLocalDate(super.with(temporalAdjuster));
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return temporalUnit.isDateBased();
        }
        return temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    public ChronoLocalDate minus(long j2, TemporalUnit temporalUnit) {
        return getChronology().ensureChronoLocalDate(super.minus(j2, temporalUnit));
    }
}
