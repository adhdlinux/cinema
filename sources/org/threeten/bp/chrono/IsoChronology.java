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
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

public final class IsoChronology extends Chronology implements Serializable {
    public static final IsoChronology INSTANCE = new IsoChronology();
    private static final long serialVersionUID = -1440403870442975015L;

    private IsoChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public List<Era> eras() {
        return Arrays.asList(IsoEra.values());
    }

    public String getCalendarType() {
        return "iso8601";
    }

    public String getId() {
        return "ISO";
    }

    public boolean isLeapYear(long j2) {
        return (3 & j2) == 0 && (j2 % 100 != 0 || j2 % 400 == 0);
    }

    public int prolepticYear(Era era, int i2) {
        if (!(era instanceof IsoEra)) {
            throw new ClassCastException("Era must be IsoEra");
        } else if (era == IsoEra.CE) {
            return i2;
        } else {
            return 1 - i2;
        }
    }

    public ValueRange range(ChronoField chronoField) {
        return chronoField.range();
    }

    public LocalDate dateEpochDay(long j2) {
        return LocalDate.ofEpochDay(j2);
    }

    public IsoEra eraOf(int i2) {
        return IsoEra.of(i2);
    }

    public LocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        return LocalDateTime.from(temporalAccessor);
    }

    public LocalDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return LocalDate.ofEpochDay(map.remove(chronoField).longValue());
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
                int safeToInt = Jdk8Methods.safeToInt(map.remove(chronoField7).longValue());
                int safeToInt2 = Jdk8Methods.safeToInt(map.remove(chronoField8).longValue());
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return LocalDate.of(checkValidIntValue, 1, 1).plusMonths((long) Jdk8Methods.safeSubtract(safeToInt, 1)).plusDays((long) Jdk8Methods.safeSubtract(safeToInt2, 1));
                } else if (resolverStyle != ResolverStyle.SMART) {
                    return LocalDate.of(checkValidIntValue, safeToInt, safeToInt2);
                } else {
                    chronoField8.checkValidValue((long) safeToInt2);
                    if (safeToInt == 4 || safeToInt == 6 || safeToInt == 9 || safeToInt == 11) {
                        safeToInt2 = Math.min(safeToInt2, 30);
                    } else if (safeToInt == 2) {
                        safeToInt2 = Math.min(safeToInt2, Month.FEBRUARY.length(Year.isLeap((long) checkValidIntValue)));
                    }
                    return LocalDate.of(checkValidIntValue, safeToInt, safeToInt2);
                }
            } else {
                ChronoField chronoField9 = ChronoField.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey(chronoField9)) {
                    ChronoField chronoField10 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey(chronoField10)) {
                        int checkValidIntValue2 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            return LocalDate.of(checkValidIntValue2, 1, 1).plusMonths(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1)).plusWeeks(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField10).longValue(), 1));
                        }
                        int checkValidIntValue3 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                        LocalDate plusDays = LocalDate.of(checkValidIntValue2, checkValidIntValue3, 1).plusDays((long) (((chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1) * 7) + (chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()) - 1)));
                        if (resolverStyle != ResolverStyle.STRICT || plusDays.get(chronoField7) == checkValidIntValue3) {
                            return plusDays;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                    ChronoField chronoField11 = ChronoField.DAY_OF_WEEK;
                    if (map.containsKey(chronoField11)) {
                        int checkValidIntValue4 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            return LocalDate.of(checkValidIntValue4, 1, 1).plusMonths(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1)).plusWeeks(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField11).longValue(), 1));
                        }
                        int checkValidIntValue5 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                        LocalDate with = LocalDate.of(checkValidIntValue4, checkValidIntValue5, 1).plusWeeks((long) (chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1)).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()))));
                        if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField7) == checkValidIntValue5) {
                            return with;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                }
            }
        }
        ChronoField chronoField12 = ChronoField.DAY_OF_YEAR;
        if (map.containsKey(chronoField12)) {
            int checkValidIntValue6 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle != ResolverStyle.LENIENT) {
                return LocalDate.ofYearDay(checkValidIntValue6, chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()));
            }
            return LocalDate.ofYearDay(checkValidIntValue6, 1).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField12).longValue(), 1));
        }
        ChronoField chronoField13 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(chronoField13)) {
            return null;
        }
        ChronoField chronoField14 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(chronoField14)) {
            int checkValidIntValue7 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return LocalDate.of(checkValidIntValue7, 1, 1).plusWeeks(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField14).longValue(), 1));
            }
            LocalDate plusDays2 = LocalDate.of(checkValidIntValue7, 1, 1).plusDays((long) (((chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1) * 7) + (chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()) - 1)));
            if (resolverStyle != ResolverStyle.STRICT || plusDays2.get(chronoField6) == checkValidIntValue7) {
                return plusDays2;
            }
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        }
        ChronoField chronoField15 = ChronoField.DAY_OF_WEEK;
        if (!map.containsKey(chronoField15)) {
            return null;
        }
        int checkValidIntValue8 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
        if (resolverStyle == ResolverStyle.LENIENT) {
            return LocalDate.of(checkValidIntValue8, 1, 1).plusWeeks(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField15).longValue(), 1));
        }
        LocalDate with2 = LocalDate.of(checkValidIntValue8, 1, 1).plusWeeks((long) (chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1)).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField15.checkValidIntValue(map.remove(chronoField15).longValue()))));
        if (resolverStyle != ResolverStyle.STRICT || with2.get(chronoField6) == checkValidIntValue8) {
            return with2;
        }
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    }

    public LocalDate dateYearDay(Era era, int i2, int i3) {
        return dateYearDay(prolepticYear(era, i2), i3);
    }

    public ZonedDateTime zonedDateTime(TemporalAccessor temporalAccessor) {
        return ZonedDateTime.from(temporalAccessor);
    }

    public LocalDate date(Era era, int i2, int i3, int i4) {
        return date(prolepticYear(era, i2), i3, i4);
    }

    public LocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    public LocalDate dateYearDay(int i2, int i3) {
        return LocalDate.ofYearDay(i2, i3);
    }

    public ZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(instant, zoneId);
    }

    public LocalDate date(int i2, int i3, int i4) {
        return LocalDate.of(i2, i3, i4);
    }

    public LocalDate dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    public LocalDate date(TemporalAccessor temporalAccessor) {
        return LocalDate.from(temporalAccessor);
    }

    public LocalDate dateNow(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return date((TemporalAccessor) LocalDate.now(clock));
    }
}
