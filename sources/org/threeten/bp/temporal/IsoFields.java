package org.threeten.bp.temporal;

import com.facebook.hermes.intl.Constants;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class IsoFields {
    public static final TemporalField DAY_OF_QUARTER = Field.DAY_OF_QUARTER;
    public static final TemporalField QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
    public static final TemporalUnit QUARTER_YEARS = Unit.QUARTER_YEARS;
    public static final TemporalField WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
    public static final TemporalUnit WEEK_BASED_YEARS = Unit.WEEK_BASED_YEARS;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: org.threeten.bp.temporal.IsoFields$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.temporal.IsoFields$Unit[] r0 = org.threeten.bp.temporal.IsoFields.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit = r0
                org.threeten.bp.temporal.IsoFields$Unit r1 = org.threeten.bp.temporal.IsoFields.Unit.WEEK_BASED_YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.IsoFields$Unit r1 = org.threeten.bp.temporal.IsoFields.Unit.QUARTER_YEARS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.temporal.IsoFields.AnonymousClass1.<clinit>():void");
        }
    }

    private enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));
        
        private final Duration duration;
        private final String name;

        private Unit(String str, Duration duration2) {
            this.name = str;
            this.duration = duration2;
        }

        public <R extends Temporal> R addTo(R r2, long j2) {
            int i2 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[ordinal()];
            if (i2 == 1) {
                TemporalField temporalField = IsoFields.WEEK_BASED_YEAR;
                return r2.with(temporalField, Jdk8Methods.safeAdd((long) r2.get(temporalField), j2));
            } else if (i2 == 2) {
                return r2.plus(j2 / 256, ChronoUnit.YEARS).plus((j2 % 256) * 3, ChronoUnit.MONTHS);
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        public long between(Temporal temporal, Temporal temporal2) {
            int i2 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[ordinal()];
            if (i2 == 1) {
                TemporalField temporalField = IsoFields.WEEK_BASED_YEAR;
                return Jdk8Methods.safeSubtract(temporal2.getLong(temporalField), temporal.getLong(temporalField));
            } else if (i2 == 2) {
                return temporal.until(temporal2, ChronoUnit.MONTHS) / 3;
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        public Duration getDuration() {
            return this.duration;
        }

        public boolean isDateBased() {
            return true;
        }

        public boolean isDurationEstimated() {
            return true;
        }

        public boolean isSupportedBy(Temporal temporal) {
            return temporal.isSupported(ChronoField.EPOCH_DAY);
        }

        public boolean isTimeBased() {
            return false;
        }

        public String toString() {
            return this.name;
        }
    }

    private IsoFields() {
        throw new AssertionError("Not instantiable");
    }

    private enum Field implements TemporalField {
        DAY_OF_QUARTER {
            public <R extends Temporal> R adjustInto(R r2, long j2) {
                long from = getFrom(r2);
                range().checkValidValue(j2, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return r2.with(chronoField, r2.getLong(chronoField) + (j2 - from));
            }

            public TemporalUnit getBaseUnit() {
                return ChronoUnit.DAYS;
            }

            public long getFrom(TemporalAccessor temporalAccessor) {
                int i2;
                if (temporalAccessor.isSupported(this)) {
                    int i3 = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
                    int i4 = temporalAccessor.get(ChronoField.MONTH_OF_YEAR);
                    long j2 = temporalAccessor.getLong(ChronoField.YEAR);
                    int[] access$200 = Field.QUARTER_DAYS;
                    int i5 = (i4 - 1) / 3;
                    if (IsoChronology.INSTANCE.isLeapYear(j2)) {
                        i2 = 4;
                    } else {
                        i2 = 0;
                    }
                    return (long) (i3 - access$200[i5 + i2]);
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
            }

            public TemporalUnit getRangeUnit() {
                return IsoFields.QUARTER_YEARS;
            }

            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR) || !temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) || !temporalAccessor.isSupported(ChronoField.YEAR) || !Field.isIso(temporalAccessor)) {
                    return false;
                }
                return true;
            }

            public ValueRange range() {
                return ValueRange.of(1, 90, 92);
            }

            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    long j2 = temporalAccessor.getLong(Field.QUARTER_OF_YEAR);
                    if (j2 == 1) {
                        if (IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR))) {
                            return ValueRange.of(1, 91);
                        }
                        return ValueRange.of(1, 90);
                    } else if (j2 == 2) {
                        return ValueRange.of(1, 91);
                    } else {
                        if (j2 == 3 || j2 == 4) {
                            return ValueRange.of(1, 92);
                        }
                        return range();
                    }
                } else {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
            }

            public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate localDate;
                ChronoField chronoField = ChronoField.YEAR;
                Long l2 = map.get(chronoField);
                Field field = Field.QUARTER_OF_YEAR;
                Long l3 = map.get(field);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int checkValidIntValue = chronoField.checkValidIntValue(l2.longValue());
                long longValue = map.get(Field.DAY_OF_QUARTER).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    localDate = LocalDate.of(checkValidIntValue, 1, 1).plusMonths(Jdk8Methods.safeMultiply(Jdk8Methods.safeSubtract(l3.longValue(), 1), 3)).plusDays(Jdk8Methods.safeSubtract(longValue, 1));
                } else {
                    int checkValidIntValue2 = field.range().checkValidIntValue(l3.longValue(), field);
                    if (resolverStyle == ResolverStyle.STRICT) {
                        int i2 = 91;
                        if (checkValidIntValue2 == 1) {
                            if (!IsoChronology.INSTANCE.isLeapYear((long) checkValidIntValue)) {
                                i2 = 90;
                            }
                        } else if (checkValidIntValue2 != 2) {
                            i2 = 92;
                        }
                        ValueRange.of(1, (long) i2).checkValidValue(longValue, this);
                    } else {
                        range().checkValidValue(longValue, this);
                    }
                    localDate = LocalDate.of(checkValidIntValue, ((checkValidIntValue2 - 1) * 3) + 1, 1).plusDays(longValue - 1);
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(field);
                return localDate;
            }

            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR {
            public <R extends Temporal> R adjustInto(R r2, long j2) {
                long from = getFrom(r2);
                range().checkValidValue(j2, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return r2.with(chronoField, r2.getLong(chronoField) + ((j2 - from) * 3));
            }

            public TemporalUnit getBaseUnit() {
                return IsoFields.QUARTER_YEARS;
            }

            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return (temporalAccessor.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            public TemporalUnit getRangeUnit() {
                return ChronoUnit.YEARS;
            }

            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && Field.isIso(temporalAccessor);
            }

            public ValueRange range() {
                return ValueRange.of(1, 4);
            }

            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                return range();
            }

            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            public <R extends Temporal> R adjustInto(R r2, long j2) {
                range().checkValidValue(j2, this);
                return r2.plus(Jdk8Methods.safeSubtract(j2, getFrom(r2)), ChronoUnit.WEEKS);
            }

            public TemporalUnit getBaseUnit() {
                return ChronoUnit.WEEKS;
            }

            public String getDisplayName(Locale locale) {
                Jdk8Methods.requireNonNull(locale, Constants.LOCALE);
                return "Week";
            }

            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return (long) Field.getWeek(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            public TemporalUnit getRangeUnit() {
                return IsoFields.WEEK_BASED_YEARS;
            }

            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(temporalAccessor);
            }

            public ValueRange range() {
                return ValueRange.of(1, 52, 53);
            }

            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return Field.getWeekRange(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                Field field;
                LocalDate localDate;
                long j2;
                Map<TemporalField, Long> map2 = map;
                ResolverStyle resolverStyle2 = resolverStyle;
                Field field2 = Field.WEEK_BASED_YEAR;
                Long l2 = map2.get(field2);
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                Long l3 = map2.get(chronoField);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int checkValidIntValue = field2.range().checkValidIntValue(l2.longValue(), field2);
                long longValue = map2.get(Field.WEEK_OF_WEEK_BASED_YEAR).longValue();
                if (resolverStyle2 == ResolverStyle.LENIENT) {
                    long longValue2 = l3.longValue();
                    if (longValue2 > 7) {
                        long j3 = longValue2 - 1;
                        j2 = j3 / 7;
                        longValue2 = (j3 % 7) + 1;
                    } else if (longValue2 < 1) {
                        j2 = (longValue2 / 7) - 1;
                        longValue2 = (longValue2 % 7) + 7;
                    } else {
                        j2 = 0;
                    }
                    field = field2;
                    localDate = LocalDate.of(checkValidIntValue, 1, 4).plusWeeks(longValue - 1).plusWeeks(j2).with((TemporalField) chronoField, longValue2);
                } else {
                    field = field2;
                    int checkValidIntValue2 = chronoField.checkValidIntValue(l3.longValue());
                    if (resolverStyle2 == ResolverStyle.STRICT) {
                        Field.getWeekRange(LocalDate.of(checkValidIntValue, 1, 4)).checkValidValue(longValue, this);
                    } else {
                        range().checkValidValue(longValue, this);
                    }
                    localDate = LocalDate.of(checkValidIntValue, 1, 4).plusWeeks(longValue - 1).with((TemporalField) chronoField, (long) checkValidIntValue2);
                }
                map2.remove(this);
                map2.remove(field);
                map2.remove(chronoField);
                return localDate;
            }

            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR {
            public <R extends Temporal> R adjustInto(R r2, long j2) {
                if (isSupportedBy(r2)) {
                    int checkValidIntValue = range().checkValidIntValue(j2, Field.WEEK_BASED_YEAR);
                    LocalDate from = LocalDate.from(r2);
                    ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                    int i2 = from.get(chronoField);
                    int access$400 = Field.getWeek(from);
                    if (access$400 == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                        access$400 = 52;
                    }
                    LocalDate of = LocalDate.of(checkValidIntValue, 1, 4);
                    return r2.with(of.plusDays((long) ((i2 - of.get(chronoField)) + ((access$400 - 1) * 7))));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            public TemporalUnit getBaseUnit() {
                return IsoFields.WEEK_BASED_YEARS;
            }

            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return (long) Field.getWeekBasedYear(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            public TemporalUnit getRangeUnit() {
                return ChronoUnit.FOREVER;
            }

            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(temporalAccessor);
            }

            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                return ChronoField.YEAR.range();
            }

            public String toString() {
                return "WeekBasedYear";
            }
        };
        
        /* access modifiers changed from: private */
        public static final int[] QUARTER_DAYS = null;

        static {
            QUARTER_DAYS = new int[]{0, 90, 181, 273, 0, 91, 182, TiffUtil.TIFF_TAG_ORIENTATION};
        }

        /* access modifiers changed from: private */
        public static int getWeek(LocalDate localDate) {
            boolean z2;
            int ordinal = localDate.getDayOfWeek().ordinal();
            int dayOfYear = localDate.getDayOfYear() - 1;
            int i2 = (3 - ordinal) + dayOfYear;
            int i3 = (i2 - ((i2 / 7) * 7)) - 3;
            if (i3 < -3) {
                i3 += 7;
            }
            if (dayOfYear < i3) {
                return (int) getWeekRange(localDate.withDayOfYear(RotationOptions.ROTATE_180).minusYears(1)).getMaximum();
            }
            int i4 = ((dayOfYear - i3) / 7) + 1;
            if (i4 == 53) {
                if (i3 == -3 || (i3 == -2 && localDate.isLeapYear())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    return 1;
                }
            }
            return i4;
        }

        /* access modifiers changed from: private */
        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                if (dayOfYear - localDate.getDayOfWeek().ordinal() < -2) {
                    return year - 1;
                }
                return year;
            } else if (dayOfYear < 363) {
                return year;
            } else {
                if (((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0) {
                    return year + 1;
                }
                return year;
            }
        }

        /* access modifiers changed from: private */
        public static ValueRange getWeekRange(LocalDate localDate) {
            return ValueRange.of(1, (long) getWeekRange(getWeekBasedYear(localDate)));
        }

        /* access modifiers changed from: private */
        public static boolean isIso(TemporalAccessor temporalAccessor) {
            return Chronology.from(temporalAccessor).equals(IsoChronology.INSTANCE);
        }

        public String getDisplayName(Locale locale) {
            Jdk8Methods.requireNonNull(locale, Constants.LOCALE);
            return toString();
        }

        public boolean isDateBased() {
            return true;
        }

        public boolean isTimeBased() {
            return false;
        }

        public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return null;
        }

        /* access modifiers changed from: private */
        public static int getWeekRange(int i2) {
            LocalDate of = LocalDate.of(i2, 1, 1);
            if (of.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (of.getDayOfWeek() != DayOfWeek.WEDNESDAY || !of.isLeapYear()) ? 52 : 53;
            }
            return 53;
        }
    }
}
