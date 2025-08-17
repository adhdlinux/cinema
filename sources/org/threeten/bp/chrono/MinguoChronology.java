package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

public final class MinguoChronology extends Chronology implements Serializable {
    public static final MinguoChronology INSTANCE = new MinguoChronology();
    static final int YEARS_DIFFERENCE = 1911;
    private static final long serialVersionUID = 1039765215346859963L;

    /* renamed from: org.threeten.bp.chrono.MinguoChronology$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.MinguoChronology.AnonymousClass1.<clinit>():void");
        }
    }

    private MinguoChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public List<Era> eras() {
        return Arrays.asList(MinguoEra.values());
    }

    public String getCalendarType() {
        return "roc";
    }

    public String getId() {
        return "Minguo";
    }

    public boolean isLeapYear(long j2) {
        return IsoChronology.INSTANCE.isLeapYear(j2 + 1911);
    }

    public ChronoLocalDateTime<MinguoDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    public int prolepticYear(Era era, int i2) {
        if (!(era instanceof MinguoEra)) {
            throw new ClassCastException("Era must be MinguoEra");
        } else if (era == MinguoEra.ROC) {
            return i2;
        } else {
            return 1 - i2;
        }
    }

    public ValueRange range(ChronoField chronoField) {
        int i2 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
        if (i2 == 1) {
            ValueRange range = ChronoField.PROLEPTIC_MONTH.range();
            return ValueRange.of(range.getMinimum() - 22932, range.getMaximum() - 22932);
        } else if (i2 == 2) {
            ValueRange range2 = ChronoField.YEAR.range();
            return ValueRange.of(1, range2.getMaximum() - 1911, (-range2.getMinimum()) + 1 + 1911);
        } else if (i2 != 3) {
            return chronoField.range();
        } else {
            ValueRange range3 = ChronoField.YEAR.range();
            return ValueRange.of(range3.getMinimum() - 1911, range3.getMaximum() - 1911);
        }
    }

    public ChronoZonedDateTime<MinguoDate> zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }

    public MinguoDate dateEpochDay(long j2) {
        return new MinguoDate(LocalDate.ofEpochDay(j2));
    }

    public MinguoEra eraOf(int i2) {
        return MinguoEra.of(i2);
    }

    public MinguoDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return dateEpochDay(map.remove(chronoField).longValue());
        }
        ChronoField chronoField2 = ChronoField.PROLEPTIC_MONTH;
        Long remove = map.remove(chronoField2);
        if (remove != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField2.checkValidValue(remove.longValue());
            }
            updateResolveMap(map, ChronoField.MONTH_OF_YEAR, (long) (Jdk8Methods.floorMod(remove.longValue(), 12) + 1));
            updateResolveMap(map, ChronoField.YEAR, Jdk8Methods.floorDiv(remove.longValue(), 12));
        }
        ChronoField chronoField3 = ChronoField.YEAR_OF_ERA;
        Long remove2 = map.remove(chronoField3);
        if (remove2 != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField3.checkValidValue(remove2.longValue());
            }
            Long remove3 = map.remove(ChronoField.ERA);
            if (remove3 == null) {
                ChronoField chronoField4 = ChronoField.YEAR;
                Long l2 = map.get(chronoField4);
                if (resolverStyle != ResolverStyle.STRICT) {
                    updateResolveMap(map, chronoField4, (l2 == null || l2.longValue() > 0) ? remove2.longValue() : Jdk8Methods.safeSubtract(1, remove2.longValue()));
                } else if (l2 != null) {
                    updateResolveMap(map, chronoField4, l2.longValue() > 0 ? remove2.longValue() : Jdk8Methods.safeSubtract(1, remove2.longValue()));
                } else {
                    map.put(chronoField3, remove2);
                }
            } else if (remove3.longValue() == 1) {
                updateResolveMap(map, ChronoField.YEAR, remove2.longValue());
            } else if (remove3.longValue() == 0) {
                updateResolveMap(map, ChronoField.YEAR, Jdk8Methods.safeSubtract(1, remove2.longValue()));
            } else {
                throw new DateTimeException("Invalid value for era: " + remove3);
            }
        } else {
            ChronoField chronoField5 = ChronoField.ERA;
            if (map.containsKey(chronoField5)) {
                chronoField5.checkValidValue(map.get(chronoField5).longValue());
            }
        }
        ChronoField chronoField6 = ChronoField.YEAR;
        if (!map.containsKey(chronoField6)) {
            return null;
        }
        ChronoField chronoField7 = ChronoField.MONTH_OF_YEAR;
        if (map.containsKey(chronoField7)) {
            ChronoField chronoField8 = ChronoField.DAY_OF_MONTH;
            if (map.containsKey(chronoField8)) {
                int checkValidIntValue = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return date(checkValidIntValue, 1, 1).plusMonths(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField8).longValue(), 1));
                }
                int checkValidIntValue2 = range(chronoField7).checkValidIntValue(map.remove(chronoField7).longValue(), chronoField7);
                int checkValidIntValue3 = range(chronoField8).checkValidIntValue(map.remove(chronoField8).longValue(), chronoField8);
                if (resolverStyle == ResolverStyle.SMART && checkValidIntValue3 > 28) {
                    checkValidIntValue3 = Math.min(checkValidIntValue3, date(checkValidIntValue, checkValidIntValue2, 1).lengthOfMonth());
                }
                return date(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
            }
            ChronoField chronoField9 = ChronoField.ALIGNED_WEEK_OF_MONTH;
            if (map.containsKey(chronoField9)) {
                ChronoField chronoField10 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                if (map.containsKey(chronoField10)) {
                    int checkValidIntValue4 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue4, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1), (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField10).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    int checkValidIntValue5 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    MinguoDate plus = date(checkValidIntValue4, checkValidIntValue5, 1).plus((long) (((chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1) * 7) + (chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()) - 1)), (TemporalUnit) ChronoUnit.DAYS);
                    if (resolverStyle != ResolverStyle.STRICT || plus.get(chronoField7) == checkValidIntValue5) {
                        return plus;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
                ChronoField chronoField11 = ChronoField.DAY_OF_WEEK;
                if (map.containsKey(chronoField11)) {
                    int checkValidIntValue6 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(checkValidIntValue6, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1), (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField11).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    int checkValidIntValue7 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    MinguoDate with = date(checkValidIntValue6, checkValidIntValue7, 1).plus((long) (chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1), (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField7) == checkValidIntValue7) {
                        return with;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        ChronoField chronoField12 = ChronoField.DAY_OF_YEAR;
        if (map.containsKey(chronoField12)) {
            int checkValidIntValue8 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle != ResolverStyle.LENIENT) {
                return dateYearDay(checkValidIntValue8, chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()));
            }
            return dateYearDay(checkValidIntValue8, 1).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField12).longValue(), 1));
        }
        ChronoField chronoField13 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(chronoField13)) {
            return null;
        }
        ChronoField chronoField14 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(chronoField14)) {
            int checkValidIntValue9 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return date(checkValidIntValue9, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField14).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
            }
            MinguoDate plusDays = date(checkValidIntValue9, 1, 1).plusDays((long) (((chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1) * 7) + (chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()) - 1)));
            if (resolverStyle != ResolverStyle.STRICT || plusDays.get(chronoField6) == checkValidIntValue9) {
                return plusDays;
            }
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        }
        ChronoField chronoField15 = ChronoField.DAY_OF_WEEK;
        if (!map.containsKey(chronoField15)) {
            return null;
        }
        int checkValidIntValue10 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
        if (resolverStyle == ResolverStyle.LENIENT) {
            return date(checkValidIntValue10, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField15).longValue(), 1), (TemporalUnit) ChronoUnit.DAYS);
        }
        MinguoDate with2 = date(checkValidIntValue10, 1, 1).plus((long) (chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1), (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField15.checkValidIntValue(map.remove(chronoField15).longValue()))));
        if (resolverStyle != ResolverStyle.STRICT || with2.get(chronoField6) == checkValidIntValue10) {
            return with2;
        }
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    }

    public ChronoZonedDateTime<MinguoDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    public MinguoDate dateYearDay(Era era, int i2, int i3) {
        return (MinguoDate) super.dateYearDay(era, i2, i3);
    }

    public MinguoDate date(Era era, int i2, int i3, int i4) {
        return (MinguoDate) super.date(era, i2, i3, i4);
    }

    public MinguoDate dateNow() {
        return (MinguoDate) super.dateNow();
    }

    public MinguoDate dateYearDay(int i2, int i3) {
        return new MinguoDate(LocalDate.ofYearDay(i2 + YEARS_DIFFERENCE, i3));
    }

    public MinguoDate date(int i2, int i3, int i4) {
        return new MinguoDate(LocalDate.of(i2 + YEARS_DIFFERENCE, i3, i4));
    }

    public MinguoDate dateNow(ZoneId zoneId) {
        return (MinguoDate) super.dateNow(zoneId);
    }

    public MinguoDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MinguoDate) {
            return (MinguoDate) temporalAccessor;
        }
        return new MinguoDate(LocalDate.from(temporalAccessor));
    }

    public MinguoDate dateNow(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return (MinguoDate) super.dateNow(clock);
    }
}
