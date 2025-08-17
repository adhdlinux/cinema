package org.threeten.bp.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

final class DateTimeBuilder extends DefaultInterfaceTemporalAccessor implements Cloneable {
    Chronology chrono;
    ChronoLocalDate date;
    Period excessDays;
    final Map<TemporalField, Long> fieldValues = new HashMap();
    boolean leapSecond;
    LocalTime time;
    ZoneId zone;

    public DateTimeBuilder() {
    }

    private void checkDate(LocalDate localDate) {
        if (localDate != null) {
            addObject((ChronoLocalDate) localDate);
            for (TemporalField next : this.fieldValues.keySet()) {
                if ((next instanceof ChronoField) && next.isDateBased()) {
                    try {
                        long j2 = localDate.getLong(next);
                        Long l2 = this.fieldValues.get(next);
                        if (j2 != l2.longValue()) {
                            throw new DateTimeException("Conflict found: Field " + next + " " + j2 + " differs from " + next + " " + l2 + " derived from " + localDate);
                        }
                    } catch (DateTimeException unused) {
                        continue;
                    }
                }
            }
        }
    }

    private void crossCheck() {
        LocalTime localTime;
        if (this.fieldValues.size() > 0) {
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null && (localTime = this.time) != null) {
                crossCheck(chronoLocalDate.atTime(localTime));
            } else if (chronoLocalDate != null) {
                crossCheck(chronoLocalDate);
            } else {
                LocalTime localTime2 = this.time;
                if (localTime2 != null) {
                    crossCheck(localTime2);
                }
            }
        }
    }

    private Long getFieldValue0(TemporalField temporalField) {
        return this.fieldValues.get(temporalField);
    }

    private void mergeDate(ResolverStyle resolverStyle) {
        if (this.chrono instanceof IsoChronology) {
            checkDate(IsoChronology.INSTANCE.resolveDate(this.fieldValues, resolverStyle));
            return;
        }
        Map<TemporalField, Long> map = this.fieldValues;
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            checkDate(LocalDate.ofEpochDay(this.fieldValues.remove(chronoField).longValue()));
        }
    }

    private void mergeInstantFields() {
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS)) {
            ZoneId zoneId = this.zone;
            if (zoneId != null) {
                mergeInstantFields0(zoneId);
                return;
            }
            Long l2 = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
            if (l2 != null) {
                mergeInstantFields0(ZoneOffset.ofTotalSeconds(l2.intValue()));
            }
        }
    }

    private void mergeInstantFields0(ZoneId zoneId) {
        Map<TemporalField, Long> map = this.fieldValues;
        ChronoField chronoField = ChronoField.INSTANT_SECONDS;
        ChronoZonedDateTime zonedDateTime = this.chrono.zonedDateTime(Instant.ofEpochSecond(map.remove(chronoField).longValue()), zoneId);
        if (this.date == null) {
            addObject(zonedDateTime.toLocalDate());
        } else {
            resolveMakeChanges((TemporalField) chronoField, zonedDateTime.toLocalDate());
        }
        addFieldValue(ChronoField.SECOND_OF_DAY, (long) zonedDateTime.toLocalTime().toSecondOfDay());
    }

    private void mergeTime(ResolverStyle resolverStyle) {
        Map<TemporalField, Long> map = this.fieldValues;
        ChronoField chronoField = ChronoField.CLOCK_HOUR_OF_DAY;
        long j2 = 0;
        if (map.containsKey(chronoField)) {
            long longValue = this.fieldValues.remove(chronoField).longValue();
            if (!(resolverStyle == ResolverStyle.LENIENT || (resolverStyle == ResolverStyle.SMART && longValue == 0))) {
                chronoField.checkValidValue(longValue);
            }
            ChronoField chronoField2 = ChronoField.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            addFieldValue(chronoField2, longValue);
        }
        Map<TemporalField, Long> map2 = this.fieldValues;
        ChronoField chronoField3 = ChronoField.CLOCK_HOUR_OF_AMPM;
        if (map2.containsKey(chronoField3)) {
            long longValue2 = this.fieldValues.remove(chronoField3).longValue();
            if (!(resolverStyle == ResolverStyle.LENIENT || (resolverStyle == ResolverStyle.SMART && longValue2 == 0))) {
                chronoField3.checkValidValue(longValue2);
            }
            ChronoField chronoField4 = ChronoField.HOUR_OF_AMPM;
            if (longValue2 != 12) {
                j2 = longValue2;
            }
            addFieldValue(chronoField4, j2);
        }
        ResolverStyle resolverStyle2 = ResolverStyle.LENIENT;
        if (resolverStyle != resolverStyle2) {
            Map<TemporalField, Long> map3 = this.fieldValues;
            ChronoField chronoField5 = ChronoField.AMPM_OF_DAY;
            if (map3.containsKey(chronoField5)) {
                chronoField5.checkValidValue(this.fieldValues.get(chronoField5).longValue());
            }
            Map<TemporalField, Long> map4 = this.fieldValues;
            ChronoField chronoField6 = ChronoField.HOUR_OF_AMPM;
            if (map4.containsKey(chronoField6)) {
                chronoField6.checkValidValue(this.fieldValues.get(chronoField6).longValue());
            }
        }
        Map<TemporalField, Long> map5 = this.fieldValues;
        ChronoField chronoField7 = ChronoField.AMPM_OF_DAY;
        if (map5.containsKey(chronoField7)) {
            Map<TemporalField, Long> map6 = this.fieldValues;
            ChronoField chronoField8 = ChronoField.HOUR_OF_AMPM;
            if (map6.containsKey(chronoField8)) {
                addFieldValue(ChronoField.HOUR_OF_DAY, (this.fieldValues.remove(chronoField7).longValue() * 12) + this.fieldValues.remove(chronoField8).longValue());
            }
        }
        Map<TemporalField, Long> map7 = this.fieldValues;
        ChronoField chronoField9 = ChronoField.NANO_OF_DAY;
        if (map7.containsKey(chronoField9)) {
            long longValue3 = this.fieldValues.remove(chronoField9).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField9.checkValidValue(longValue3);
            }
            addFieldValue(ChronoField.SECOND_OF_DAY, longValue3 / 1000000000);
            addFieldValue(ChronoField.NANO_OF_SECOND, longValue3 % 1000000000);
        }
        Map<TemporalField, Long> map8 = this.fieldValues;
        ChronoField chronoField10 = ChronoField.MICRO_OF_DAY;
        if (map8.containsKey(chronoField10)) {
            long longValue4 = this.fieldValues.remove(chronoField10).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField10.checkValidValue(longValue4);
            }
            addFieldValue(ChronoField.SECOND_OF_DAY, longValue4 / 1000000);
            addFieldValue(ChronoField.MICRO_OF_SECOND, longValue4 % 1000000);
        }
        Map<TemporalField, Long> map9 = this.fieldValues;
        ChronoField chronoField11 = ChronoField.MILLI_OF_DAY;
        if (map9.containsKey(chronoField11)) {
            long longValue5 = this.fieldValues.remove(chronoField11).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField11.checkValidValue(longValue5);
            }
            addFieldValue(ChronoField.SECOND_OF_DAY, longValue5 / 1000);
            addFieldValue(ChronoField.MILLI_OF_SECOND, longValue5 % 1000);
        }
        Map<TemporalField, Long> map10 = this.fieldValues;
        ChronoField chronoField12 = ChronoField.SECOND_OF_DAY;
        if (map10.containsKey(chronoField12)) {
            long longValue6 = this.fieldValues.remove(chronoField12).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField12.checkValidValue(longValue6);
            }
            addFieldValue(ChronoField.HOUR_OF_DAY, longValue6 / 3600);
            addFieldValue(ChronoField.MINUTE_OF_HOUR, (longValue6 / 60) % 60);
            addFieldValue(ChronoField.SECOND_OF_MINUTE, longValue6 % 60);
        }
        Map<TemporalField, Long> map11 = this.fieldValues;
        ChronoField chronoField13 = ChronoField.MINUTE_OF_DAY;
        if (map11.containsKey(chronoField13)) {
            long longValue7 = this.fieldValues.remove(chronoField13).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField13.checkValidValue(longValue7);
            }
            addFieldValue(ChronoField.HOUR_OF_DAY, longValue7 / 60);
            addFieldValue(ChronoField.MINUTE_OF_HOUR, longValue7 % 60);
        }
        if (resolverStyle != resolverStyle2) {
            Map<TemporalField, Long> map12 = this.fieldValues;
            ChronoField chronoField14 = ChronoField.MILLI_OF_SECOND;
            if (map12.containsKey(chronoField14)) {
                chronoField14.checkValidValue(this.fieldValues.get(chronoField14).longValue());
            }
            Map<TemporalField, Long> map13 = this.fieldValues;
            ChronoField chronoField15 = ChronoField.MICRO_OF_SECOND;
            if (map13.containsKey(chronoField15)) {
                chronoField15.checkValidValue(this.fieldValues.get(chronoField15).longValue());
            }
        }
        Map<TemporalField, Long> map14 = this.fieldValues;
        ChronoField chronoField16 = ChronoField.MILLI_OF_SECOND;
        if (map14.containsKey(chronoField16)) {
            Map<TemporalField, Long> map15 = this.fieldValues;
            ChronoField chronoField17 = ChronoField.MICRO_OF_SECOND;
            if (map15.containsKey(chronoField17)) {
                addFieldValue(chronoField17, (this.fieldValues.remove(chronoField16).longValue() * 1000) + (this.fieldValues.get(chronoField17).longValue() % 1000));
            }
        }
        Map<TemporalField, Long> map16 = this.fieldValues;
        ChronoField chronoField18 = ChronoField.MICRO_OF_SECOND;
        if (map16.containsKey(chronoField18)) {
            Map<TemporalField, Long> map17 = this.fieldValues;
            ChronoField chronoField19 = ChronoField.NANO_OF_SECOND;
            if (map17.containsKey(chronoField19)) {
                addFieldValue(chronoField18, this.fieldValues.get(chronoField19).longValue() / 1000);
                this.fieldValues.remove(chronoField18);
            }
        }
        if (this.fieldValues.containsKey(chronoField16)) {
            Map<TemporalField, Long> map18 = this.fieldValues;
            ChronoField chronoField20 = ChronoField.NANO_OF_SECOND;
            if (map18.containsKey(chronoField20)) {
                addFieldValue(chronoField16, this.fieldValues.get(chronoField20).longValue() / 1000000);
                this.fieldValues.remove(chronoField16);
            }
        }
        if (this.fieldValues.containsKey(chronoField18)) {
            addFieldValue(ChronoField.NANO_OF_SECOND, this.fieldValues.remove(chronoField18).longValue() * 1000);
        } else if (this.fieldValues.containsKey(chronoField16)) {
            addFieldValue(ChronoField.NANO_OF_SECOND, this.fieldValues.remove(chronoField16).longValue() * 1000000);
        }
    }

    private DateTimeBuilder putFieldValue0(TemporalField temporalField, long j2) {
        this.fieldValues.put(temporalField, Long.valueOf(j2));
        return this;
    }

    private boolean resolveFields(ResolverStyle resolverStyle) {
        int i2 = 0;
        loop0:
        while (i2 < 100) {
            for (Map.Entry<TemporalField, Long> key : this.fieldValues.entrySet()) {
                TemporalField temporalField = (TemporalField) key.getKey();
                Object resolve = temporalField.resolve(this.fieldValues, this, resolverStyle);
                if (resolve != null) {
                    if (resolve instanceof ChronoZonedDateTime) {
                        ChronoZonedDateTime chronoZonedDateTime = (ChronoZonedDateTime) resolve;
                        ZoneId zoneId = this.zone;
                        if (zoneId == null) {
                            this.zone = chronoZonedDateTime.getZone();
                        } else if (!zoneId.equals(chronoZonedDateTime.getZone())) {
                            throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.zone);
                        }
                        resolve = chronoZonedDateTime.toLocalDateTime();
                    }
                    if (resolve instanceof ChronoLocalDate) {
                        resolveMakeChanges(temporalField, (ChronoLocalDate) resolve);
                    } else if (resolve instanceof LocalTime) {
                        resolveMakeChanges(temporalField, (LocalTime) resolve);
                    } else if (resolve instanceof ChronoLocalDateTime) {
                        ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) resolve;
                        resolveMakeChanges(temporalField, chronoLocalDateTime.toLocalDate());
                        resolveMakeChanges(temporalField, chronoLocalDateTime.toLocalTime());
                    } else {
                        throw new DateTimeException("Unknown type: " + resolve.getClass().getName());
                    }
                } else if (!this.fieldValues.containsKey(temporalField)) {
                }
                i2++;
            }
        }
        if (i2 == 100) {
            throw new DateTimeException("Badly written field");
        } else if (i2 > 0) {
            return true;
        } else {
            return false;
        }
    }

    private void resolveFractional() {
        if (this.time != null) {
            return;
        }
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS) || this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY) || this.fieldValues.containsKey(ChronoField.SECOND_OF_MINUTE)) {
            Map<TemporalField, Long> map = this.fieldValues;
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            if (map.containsKey(chronoField)) {
                long longValue = this.fieldValues.get(chronoField).longValue();
                this.fieldValues.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(longValue / 1000));
                this.fieldValues.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(longValue / 1000000));
                return;
            }
            this.fieldValues.put(chronoField, 0L);
            this.fieldValues.put(ChronoField.MICRO_OF_SECOND, 0L);
            this.fieldValues.put(ChronoField.MILLI_OF_SECOND, 0L);
        }
    }

    private void resolveInstant() {
        if (this.date != null && this.time != null) {
            Long l2 = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
            if (l2 != null) {
                ChronoZonedDateTime<?> atZone = this.date.atTime(this.time).atZone(ZoneOffset.ofTotalSeconds(l2.intValue()));
                ChronoField chronoField = ChronoField.INSTANT_SECONDS;
                this.fieldValues.put(chronoField, Long.valueOf(atZone.getLong(chronoField)));
            } else if (this.zone != null) {
                ChronoZonedDateTime<?> atZone2 = this.date.atTime(this.time).atZone(this.zone);
                ChronoField chronoField2 = ChronoField.INSTANT_SECONDS;
                this.fieldValues.put(chronoField2, Long.valueOf(atZone2.getLong(chronoField2)));
            }
        }
    }

    private void resolveMakeChanges(TemporalField temporalField, ChronoLocalDate chronoLocalDate) {
        if (this.chrono.equals(chronoLocalDate.getChronology())) {
            long epochDay = chronoLocalDate.toEpochDay();
            Long put = this.fieldValues.put(ChronoField.EPOCH_DAY, Long.valueOf(epochDay));
            if (put != null && put.longValue() != epochDay) {
                throw new DateTimeException("Conflict found: " + LocalDate.ofEpochDay(put.longValue()) + " differs from " + LocalDate.ofEpochDay(epochDay) + " while resolving  " + temporalField);
            }
            return;
        }
        throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.chrono);
    }

    private void resolveTimeInferZeroes(ResolverStyle resolverStyle) {
        ResolverStyle resolverStyle2 = resolverStyle;
        Map<TemporalField, Long> map = this.fieldValues;
        ChronoField chronoField = ChronoField.HOUR_OF_DAY;
        Long l2 = map.get(chronoField);
        Map<TemporalField, Long> map2 = this.fieldValues;
        ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
        Long l3 = map2.get(chronoField2);
        Map<TemporalField, Long> map3 = this.fieldValues;
        ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
        Long l4 = map3.get(chronoField3);
        Map<TemporalField, Long> map4 = this.fieldValues;
        ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
        Long l5 = map4.get(chronoField4);
        if (l2 != null) {
            if (l3 == null && (l4 != null || l5 != null)) {
                return;
            }
            if (l3 == null || l4 != null || l5 == null) {
                if (resolverStyle2 != ResolverStyle.LENIENT) {
                    if (resolverStyle2 == ResolverStyle.SMART && l2.longValue() == 24 && ((l3 == null || l3.longValue() == 0) && ((l4 == null || l4.longValue() == 0) && (l5 == null || l5.longValue() == 0)))) {
                        l2 = 0L;
                        this.excessDays = Period.ofDays(1);
                    }
                    int checkValidIntValue = chronoField.checkValidIntValue(l2.longValue());
                    if (l3 != null) {
                        int checkValidIntValue2 = chronoField2.checkValidIntValue(l3.longValue());
                        if (l4 != null) {
                            int checkValidIntValue3 = chronoField3.checkValidIntValue(l4.longValue());
                            if (l5 != null) {
                                addObject(LocalTime.of(checkValidIntValue, checkValidIntValue2, checkValidIntValue3, chronoField4.checkValidIntValue(l5.longValue())));
                            } else {
                                addObject(LocalTime.of(checkValidIntValue, checkValidIntValue2, checkValidIntValue3));
                            }
                        } else if (l5 == null) {
                            addObject(LocalTime.of(checkValidIntValue, checkValidIntValue2));
                        }
                    } else if (l4 == null && l5 == null) {
                        addObject(LocalTime.of(checkValidIntValue, 0));
                    }
                } else {
                    long longValue = l2.longValue();
                    if (l3 == null) {
                        int safeToInt = Jdk8Methods.safeToInt(Jdk8Methods.floorDiv(longValue, 24));
                        addObject(LocalTime.of((int) ((long) Jdk8Methods.floorMod(longValue, 24)), 0));
                        this.excessDays = Period.ofDays(safeToInt);
                    } else if (l4 != null) {
                        if (l5 == null) {
                            l5 = 0L;
                        }
                        long safeAdd = Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(longValue, 3600000000000L), Jdk8Methods.safeMultiply(l3.longValue(), 60000000000L)), Jdk8Methods.safeMultiply(l4.longValue(), 1000000000)), l5.longValue());
                        addObject(LocalTime.ofNanoOfDay(Jdk8Methods.floorMod(safeAdd, 86400000000000L)));
                        this.excessDays = Period.ofDays((int) Jdk8Methods.floorDiv(safeAdd, 86400000000000L));
                    } else {
                        long safeAdd2 = Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(longValue, 3600), Jdk8Methods.safeMultiply(l3.longValue(), 60));
                        addObject(LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(safeAdd2, 86400)));
                        this.excessDays = Period.ofDays((int) Jdk8Methods.floorDiv(safeAdd2, 86400));
                    }
                }
                this.fieldValues.remove(chronoField);
                this.fieldValues.remove(chronoField2);
                this.fieldValues.remove(chronoField3);
                this.fieldValues.remove(chronoField4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public DateTimeBuilder addFieldValue(TemporalField temporalField, long j2) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Long fieldValue0 = getFieldValue0(temporalField);
        if (fieldValue0 == null || fieldValue0.longValue() == j2) {
            return putFieldValue0(temporalField, j2);
        }
        throw new DateTimeException("Conflict found: " + temporalField + " " + fieldValue0 + " differs from " + temporalField + " " + j2 + ": " + this);
    }

    /* access modifiers changed from: package-private */
    public void addObject(ChronoLocalDate chronoLocalDate) {
        this.date = chronoLocalDate;
    }

    public <R> R build(TemporalQuery<R> temporalQuery) {
        return temporalQuery.queryFrom(this);
    }

    public long getLong(TemporalField temporalField) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Long fieldValue0 = getFieldValue0(temporalField);
        if (fieldValue0 != null) {
            return fieldValue0.longValue();
        }
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null && chronoLocalDate.isSupported(temporalField)) {
            return this.date.getLong(temporalField);
        }
        LocalTime localTime = this.time;
        if (localTime != null && localTime.isSupported(temporalField)) {
            return this.time.getLong(temporalField);
        }
        throw new DateTimeException("Field not found: " + temporalField);
    }

    public boolean isSupported(TemporalField temporalField) {
        ChronoLocalDate chronoLocalDate;
        LocalTime localTime;
        if (temporalField == null) {
            return false;
        }
        if (this.fieldValues.containsKey(temporalField) || (((chronoLocalDate = this.date) != null && chronoLocalDate.isSupported(temporalField)) || ((localTime = this.time) != null && localTime.isSupported(temporalField)))) {
            return true;
        }
        return false;
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId()) {
            return this.zone;
        }
        if (temporalQuery == TemporalQueries.chronology()) {
            return this.chrono;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null) {
                return LocalDate.from(chronoLocalDate);
            }
            return null;
        } else if (temporalQuery == TemporalQueries.localTime()) {
            return this.time;
        } else {
            if (temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset()) {
                return temporalQuery.queryFrom(this);
            }
            if (temporalQuery == TemporalQueries.precision()) {
                return null;
            }
            return temporalQuery.queryFrom(this);
        }
    }

    public DateTimeBuilder resolve(ResolverStyle resolverStyle, Set<TemporalField> set) {
        ChronoLocalDate chronoLocalDate;
        if (set != null) {
            this.fieldValues.keySet().retainAll(set);
        }
        mergeInstantFields();
        mergeDate(resolverStyle);
        mergeTime(resolverStyle);
        if (resolveFields(resolverStyle)) {
            mergeInstantFields();
            mergeDate(resolverStyle);
            mergeTime(resolverStyle);
        }
        resolveTimeInferZeroes(resolverStyle);
        crossCheck();
        Period period = this.excessDays;
        if (!(period == null || period.isZero() || (chronoLocalDate = this.date) == null || this.time == null)) {
            this.date = chronoLocalDate.plus((TemporalAmount) this.excessDays);
            this.excessDays = Period.ZERO;
        }
        resolveFractional();
        resolveInstant();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("DateTimeBuilder[");
        if (this.fieldValues.size() > 0) {
            sb.append("fields=");
            sb.append(this.fieldValues);
        }
        sb.append(", ");
        sb.append(this.chrono);
        sb.append(", ");
        sb.append(this.zone);
        sb.append(", ");
        sb.append(this.date);
        sb.append(", ");
        sb.append(this.time);
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void addObject(LocalTime localTime) {
        this.time = localTime;
    }

    public DateTimeBuilder(TemporalField temporalField, long j2) {
        addFieldValue(temporalField, j2);
    }

    private void crossCheck(TemporalAccessor temporalAccessor) {
        Iterator<Map.Entry<TemporalField, Long>> it2 = this.fieldValues.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            TemporalField temporalField = (TemporalField) next.getKey();
            long longValue = ((Long) next.getValue()).longValue();
            if (temporalAccessor.isSupported(temporalField)) {
                try {
                    long j2 = temporalAccessor.getLong(temporalField);
                    if (j2 == longValue) {
                        it2.remove();
                    } else {
                        throw new DateTimeException("Cross check failed: " + temporalField + " " + j2 + " vs " + temporalField + " " + longValue);
                    }
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    private void resolveMakeChanges(TemporalField temporalField, LocalTime localTime) {
        long nanoOfDay = localTime.toNanoOfDay();
        Long put = this.fieldValues.put(ChronoField.NANO_OF_DAY, Long.valueOf(nanoOfDay));
        if (put != null && put.longValue() != nanoOfDay) {
            throw new DateTimeException("Conflict found: " + LocalTime.ofNanoOfDay(put.longValue()) + " differs from " + localTime + " while resolving  " + temporalField);
        }
    }
}
