package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
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

public final class HijrahChronology extends Chronology implements Serializable {
    private static final HashMap<String, String[]> ERA_FULL_NAMES;
    private static final HashMap<String, String[]> ERA_NARROW_NAMES;
    private static final HashMap<String, String[]> ERA_SHORT_NAMES;
    private static final String FALLBACK_LANGUAGE = "en";
    public static final HijrahChronology INSTANCE = new HijrahChronology();
    private static final long serialVersionUID = 3127340209035924785L;

    static {
        HashMap<String, String[]> hashMap = new HashMap<>();
        ERA_NARROW_NAMES = hashMap;
        HashMap<String, String[]> hashMap2 = new HashMap<>();
        ERA_SHORT_NAMES = hashMap2;
        HashMap<String, String[]> hashMap3 = new HashMap<>();
        ERA_FULL_NAMES = hashMap3;
        hashMap.put(FALLBACK_LANGUAGE, new String[]{"BH", "HE"});
        hashMap2.put(FALLBACK_LANGUAGE, new String[]{"B.H.", "H.E."});
        hashMap3.put(FALLBACK_LANGUAGE, new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private HijrahChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public List<Era> eras() {
        return Arrays.asList(HijrahEra.values());
    }

    public String getCalendarType() {
        return "islamic-umalqura";
    }

    public String getId() {
        return "Hijrah-umalqura";
    }

    public boolean isLeapYear(long j2) {
        return HijrahDate.isLeapYear(j2);
    }

    public ChronoLocalDateTime<HijrahDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    public int prolepticYear(Era era, int i2) {
        if (!(era instanceof HijrahEra)) {
            throw new ClassCastException("Era must be HijrahEra");
        } else if (era == HijrahEra.AH) {
            return i2;
        } else {
            return 1 - i2;
        }
    }

    public ValueRange range(ChronoField chronoField) {
        return chronoField.range();
    }

    public ChronoZonedDateTime<HijrahDate> zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }

    public HijrahDate dateEpochDay(long j2) {
        return HijrahDate.of(LocalDate.ofEpochDay(j2));
    }

    public HijrahEra eraOf(int i2) {
        if (i2 == 0) {
            return HijrahEra.BEFORE_AH;
        }
        if (i2 == 1) {
            return HijrahEra.AH;
        }
        throw new DateTimeException("invalid Hijrah era");
    }

    public HijrahDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
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
                    HijrahDate plus = date(checkValidIntValue4, checkValidIntValue5, 1).plus((long) (((chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1) * 7) + (chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()) - 1)), (TemporalUnit) ChronoUnit.DAYS);
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
                    HijrahDate with = date(checkValidIntValue6, checkValidIntValue7, 1).plus((long) (chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1), (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()))));
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
            HijrahDate plusDays = date(checkValidIntValue9, 1, 1).plusDays((long) (((chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1) * 7) + (chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()) - 1)));
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
        HijrahDate with2 = date(checkValidIntValue10, 1, 1).plus((long) (chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1), (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField15.checkValidIntValue(map.remove(chronoField15).longValue()))));
        if (resolverStyle != ResolverStyle.STRICT || with2.get(chronoField6) == checkValidIntValue10) {
            return with2;
        }
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    }

    public ChronoZonedDateTime<HijrahDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    public HijrahDate dateYearDay(Era era, int i2, int i3) {
        return (HijrahDate) super.dateYearDay(era, i2, i3);
    }

    public HijrahDate date(Era era, int i2, int i3, int i4) {
        return (HijrahDate) super.date(era, i2, i3, i4);
    }

    public HijrahDate dateNow() {
        return (HijrahDate) super.dateNow();
    }

    public HijrahDate dateYearDay(int i2, int i3) {
        return HijrahDate.of(i2, 1, 1).plusDays((long) (i3 - 1));
    }

    public HijrahDate date(int i2, int i3, int i4) {
        return HijrahDate.of(i2, i3, i4);
    }

    public HijrahDate dateNow(ZoneId zoneId) {
        return (HijrahDate) super.dateNow(zoneId);
    }

    public HijrahDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof HijrahDate) {
            return (HijrahDate) temporalAccessor;
        }
        return HijrahDate.ofEpochDay(temporalAccessor.getLong(ChronoField.EPOCH_DAY));
    }

    public HijrahDate dateNow(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return (HijrahDate) super.dateNow(clock);
    }
}
