package org.threeten.bp.temporal;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class TemporalAdjusters {

    private static final class DayOfWeekInMonth implements TemporalAdjuster {
        private final int dowValue;
        private final int ordinal;

        public Temporal adjustInto(Temporal temporal) {
            if (this.ordinal >= 0) {
                Temporal with = temporal.with(ChronoField.DAY_OF_MONTH, 1);
                return with.plus(((long) (((this.dowValue - with.get(ChronoField.DAY_OF_WEEK)) + 7) % 7)) + ((((long) this.ordinal) - 1) * 7), ChronoUnit.DAYS);
            }
            ChronoField chronoField = ChronoField.DAY_OF_MONTH;
            Temporal with2 = temporal.with(chronoField, temporal.range(chronoField).getMaximum());
            long j2 = (long) (this.dowValue - with2.get(ChronoField.DAY_OF_WEEK));
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i2 == 0) {
                j2 = 0;
            } else if (i2 > 0) {
                j2 -= 7;
            }
            return with2.plus(j2 - ((((long) (-this.ordinal)) - 1) * 7), ChronoUnit.DAYS);
        }

        private DayOfWeekInMonth(int i2, DayOfWeek dayOfWeek) {
            this.ordinal = i2;
            this.dowValue = dayOfWeek.getValue();
        }
    }

    private static class Impl implements TemporalAdjuster {
        /* access modifiers changed from: private */
        public static final Impl FIRST_DAY_OF_MONTH = new Impl(0);
        /* access modifiers changed from: private */
        public static final Impl FIRST_DAY_OF_NEXT_MONTH = new Impl(2);
        /* access modifiers changed from: private */
        public static final Impl FIRST_DAY_OF_NEXT_YEAR = new Impl(5);
        /* access modifiers changed from: private */
        public static final Impl FIRST_DAY_OF_YEAR = new Impl(3);
        /* access modifiers changed from: private */
        public static final Impl LAST_DAY_OF_MONTH = new Impl(1);
        /* access modifiers changed from: private */
        public static final Impl LAST_DAY_OF_YEAR = new Impl(4);
        private final int ordinal;

        private Impl(int i2) {
            this.ordinal = i2;
        }

        public Temporal adjustInto(Temporal temporal) {
            int i2 = this.ordinal;
            if (i2 == 0) {
                return temporal.with(ChronoField.DAY_OF_MONTH, 1);
            }
            if (i2 == 1) {
                ChronoField chronoField = ChronoField.DAY_OF_MONTH;
                return temporal.with(chronoField, temporal.range(chronoField).getMaximum());
            } else if (i2 == 2) {
                return temporal.with(ChronoField.DAY_OF_MONTH, 1).plus(1, ChronoUnit.MONTHS);
            } else {
                if (i2 == 3) {
                    return temporal.with(ChronoField.DAY_OF_YEAR, 1);
                }
                if (i2 == 4) {
                    ChronoField chronoField2 = ChronoField.DAY_OF_YEAR;
                    return temporal.with(chronoField2, temporal.range(chronoField2).getMaximum());
                } else if (i2 == 5) {
                    return temporal.with(ChronoField.DAY_OF_YEAR, 1).plus(1, ChronoUnit.YEARS);
                } else {
                    throw new IllegalStateException("Unreachable");
                }
            }
        }
    }

    private static final class RelativeDayOfWeek implements TemporalAdjuster {
        private final int dowValue;
        private final int relative;

        public Temporal adjustInto(Temporal temporal) {
            int i2;
            int i3;
            int i4 = temporal.get(ChronoField.DAY_OF_WEEK);
            int i5 = this.relative;
            if (i5 < 2 && i4 == this.dowValue) {
                return temporal;
            }
            if ((i5 & 1) == 0) {
                int i6 = i4 - this.dowValue;
                if (i6 >= 0) {
                    i3 = 7 - i6;
                } else {
                    i3 = -i6;
                }
                return temporal.plus((long) i3, ChronoUnit.DAYS);
            }
            int i7 = this.dowValue - i4;
            if (i7 >= 0) {
                i2 = 7 - i7;
            } else {
                i2 = -i7;
            }
            return temporal.minus((long) i2, ChronoUnit.DAYS);
        }

        private RelativeDayOfWeek(int i2, DayOfWeek dayOfWeek) {
            Jdk8Methods.requireNonNull(dayOfWeek, "dayOfWeek");
            this.relative = i2;
            this.dowValue = dayOfWeek.getValue();
        }
    }

    private TemporalAdjusters() {
    }

    public static TemporalAdjuster dayOfWeekInMonth(int i2, DayOfWeek dayOfWeek) {
        Jdk8Methods.requireNonNull(dayOfWeek, "dayOfWeek");
        return new DayOfWeekInMonth(i2, dayOfWeek);
    }

    public static TemporalAdjuster firstDayOfMonth() {
        return Impl.FIRST_DAY_OF_MONTH;
    }

    public static TemporalAdjuster firstDayOfNextMonth() {
        return Impl.FIRST_DAY_OF_NEXT_MONTH;
    }

    public static TemporalAdjuster firstDayOfNextYear() {
        return Impl.FIRST_DAY_OF_NEXT_YEAR;
    }

    public static TemporalAdjuster firstDayOfYear() {
        return Impl.FIRST_DAY_OF_YEAR;
    }

    public static TemporalAdjuster firstInMonth(DayOfWeek dayOfWeek) {
        Jdk8Methods.requireNonNull(dayOfWeek, "dayOfWeek");
        return new DayOfWeekInMonth(1, dayOfWeek);
    }

    public static TemporalAdjuster lastDayOfMonth() {
        return Impl.LAST_DAY_OF_MONTH;
    }

    public static TemporalAdjuster lastDayOfYear() {
        return Impl.LAST_DAY_OF_YEAR;
    }

    public static TemporalAdjuster lastInMonth(DayOfWeek dayOfWeek) {
        Jdk8Methods.requireNonNull(dayOfWeek, "dayOfWeek");
        return new DayOfWeekInMonth(-1, dayOfWeek);
    }

    public static TemporalAdjuster next(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(2, dayOfWeek);
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(0, dayOfWeek);
    }

    public static TemporalAdjuster previous(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(3, dayOfWeek);
    }

    public static TemporalAdjuster previousOrSame(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(1, dayOfWeek);
    }
}
