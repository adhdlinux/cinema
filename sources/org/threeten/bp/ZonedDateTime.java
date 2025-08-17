package org.threeten.bp;

import com.facebook.common.time.Clock;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;
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
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

public final class ZonedDateTime extends ChronoZonedDateTime<LocalDate> implements Serializable {
    public static final TemporalQuery<ZonedDateTime> FROM = new TemporalQuery<ZonedDateTime>() {
        public ZonedDateTime queryFrom(TemporalAccessor temporalAccessor) {
            return ZonedDateTime.from(temporalAccessor);
        }
    };
    private static final long serialVersionUID = -6260982410461394882L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    /* renamed from: org.threeten.bp.ZonedDateTime$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZonedDateTime.AnonymousClass2.<clinit>():void");
        }
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = localDateTime;
        this.offset = zoneOffset;
        this.zone = zoneId;
    }

    private static ZonedDateTime create(long j2, int i2, ZoneId zoneId) {
        ZoneOffset offset2 = zoneId.getRules().getOffset(Instant.ofEpochSecond(j2, (long) i2));
        return new ZonedDateTime(LocalDateTime.ofEpochSecond(j2, i2, offset2), offset2, zoneId);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|(3:7|8|9)|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.threeten.bp.ZonedDateTime from(org.threeten.bp.temporal.TemporalAccessor r4) {
        /*
            boolean r0 = r4 instanceof org.threeten.bp.ZonedDateTime
            if (r0 == 0) goto L_0x0007
            org.threeten.bp.ZonedDateTime r4 = (org.threeten.bp.ZonedDateTime) r4
            return r4
        L_0x0007:
            org.threeten.bp.ZoneId r0 = org.threeten.bp.ZoneId.from(r4)     // Catch:{ DateTimeException -> 0x002b }
            org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ DateTimeException -> 0x002b }
            boolean r2 = r4.isSupported(r1)     // Catch:{ DateTimeException -> 0x002b }
            if (r2 == 0) goto L_0x0022
            long r1 = r4.getLong(r1)     // Catch:{ DateTimeException -> 0x0022 }
            org.threeten.bp.temporal.ChronoField r3 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ DateTimeException -> 0x0022 }
            int r3 = r4.get(r3)     // Catch:{ DateTimeException -> 0x0022 }
            org.threeten.bp.ZonedDateTime r4 = create(r1, r3, r0)     // Catch:{ DateTimeException -> 0x0022 }
            return r4
        L_0x0022:
            org.threeten.bp.LocalDateTime r1 = org.threeten.bp.LocalDateTime.from(r4)     // Catch:{ DateTimeException -> 0x002b }
            org.threeten.bp.ZonedDateTime r4 = of(r1, r0)     // Catch:{ DateTimeException -> 0x002b }
            return r4
        L_0x002b:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to obtain ZonedDateTime from TemporalAccessor: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = ", type "
            r1.append(r2)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZonedDateTime.from(org.threeten.bp.temporal.TemporalAccessor):org.threeten.bp.ZonedDateTime");
    }

    public static ZonedDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static ZonedDateTime of(LocalDate localDate, LocalTime localTime, ZoneId zoneId) {
        return of(LocalDateTime.of(localDate, localTime), zoneId);
    }

    public static ZonedDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(instant, "instant");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return create(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    private static ZonedDateTime ofLenient(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(localDateTime, "localDateTime");
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        if (!(zoneId instanceof ZoneOffset) || zoneOffset.equals(zoneId)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    }

    public static ZonedDateTime ofLocal(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(localDateTime, "localDateTime");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        List<ZoneOffset> validOffsets = rules.getValidOffsets(localDateTime);
        if (validOffsets.size() == 1) {
            zoneOffset = validOffsets.get(0);
        } else if (validOffsets.size() == 0) {
            ZoneOffsetTransition transition = rules.getTransition(localDateTime);
            localDateTime = localDateTime.plusSeconds(transition.getDuration().getSeconds());
            zoneOffset = transition.getOffsetAfter();
        } else if (zoneOffset == null || !validOffsets.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) Jdk8Methods.requireNonNull(validOffsets.get(0), "offset");
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    public static ZonedDateTime ofStrict(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(localDateTime, "localDateTime");
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        ZoneRules rules = zoneId.getRules();
        if (rules.isValidOffset(localDateTime, zoneOffset)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        ZoneOffsetTransition transition = rules.getTransition(localDateTime);
        if (transition == null || !transition.isGap()) {
            throw new DateTimeException("ZoneOffset '" + zoneOffset + "' is not valid for LocalDateTime '" + localDateTime + "' in zone '" + zoneId + "'");
        }
        throw new DateTimeException("LocalDateTime '" + localDateTime + "' does not exist in zone '" + zoneId + "' due to a gap in the local time-line, typically caused by daylight savings");
    }

    public static ZonedDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    static ZonedDateTime readExternal(DataInput dataInput) throws IOException {
        return ofLenient(LocalDateTime.readExternal(dataInput), ZoneOffset.readExternal(dataInput), (ZoneId) Ser.read(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private ZonedDateTime resolveInstant(LocalDateTime localDateTime) {
        return ofInstant(localDateTime, this.offset, this.zone);
    }

    private ZonedDateTime resolveLocal(LocalDateTime localDateTime) {
        return ofLocal(localDateTime, this.zone, this.offset);
    }

    private ZonedDateTime resolveOffset(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.offset) || !this.zone.getRules().isValidOffset(this.dateTime, zoneOffset)) {
            return this;
        }
        return new ZonedDateTime(this.dateTime, zoneOffset, this.zone);
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        if (!this.dateTime.equals(zonedDateTime.dateTime) || !this.offset.equals(zonedDateTime.offset) || !this.zone.equals(zonedDateTime.zone)) {
            return false;
        }
        return true;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.get(temporalField);
        }
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i2 == 1) {
            throw new DateTimeException("Field too large for an int: " + temporalField);
        } else if (i2 != 2) {
            return this.dateTime.get(temporalField);
        } else {
            return getOffset().getTotalSeconds();
        }
    }

    public int getDayOfMonth() {
        return this.dateTime.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.dateTime.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.dateTime.getDayOfYear();
    }

    public int getHour() {
        return this.dateTime.getHour();
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i2 == 1) {
            return toEpochSecond();
        }
        if (i2 != 2) {
            return this.dateTime.getLong(temporalField);
        }
        return (long) getOffset().getTotalSeconds();
    }

    public int getMinute() {
        return this.dateTime.getMinute();
    }

    public Month getMonth() {
        return this.dateTime.getMonth();
    }

    public int getMonthValue() {
        return this.dateTime.getMonthValue();
    }

    public int getNano() {
        return this.dateTime.getNano();
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    public ZoneId getZone() {
        return this.zone;
    }

    public int hashCode() {
        return (this.dateTime.hashCode() ^ this.offset.hashCode()) ^ Integer.rotateLeft(this.zone.hashCode(), 3);
    }

    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    public ZonedDateTime minusDays(long j2) {
        return j2 == Long.MIN_VALUE ? plusDays(Clock.MAX_TIME).plusDays(1) : plusDays(-j2);
    }

    public ZonedDateTime minusHours(long j2) {
        return j2 == Long.MIN_VALUE ? plusHours(Clock.MAX_TIME).plusHours(1) : plusHours(-j2);
    }

    public ZonedDateTime minusMinutes(long j2) {
        return j2 == Long.MIN_VALUE ? plusMinutes(Clock.MAX_TIME).plusMinutes(1) : plusMinutes(-j2);
    }

    public ZonedDateTime minusMonths(long j2) {
        return j2 == Long.MIN_VALUE ? plusMonths(Clock.MAX_TIME).plusMonths(1) : plusMonths(-j2);
    }

    public ZonedDateTime minusNanos(long j2) {
        return j2 == Long.MIN_VALUE ? plusNanos(Clock.MAX_TIME).plusNanos(1) : plusNanos(-j2);
    }

    public ZonedDateTime minusSeconds(long j2) {
        return j2 == Long.MIN_VALUE ? plusSeconds(Clock.MAX_TIME).plusSeconds(1) : plusSeconds(-j2);
    }

    public ZonedDateTime minusWeeks(long j2) {
        return j2 == Long.MIN_VALUE ? plusWeeks(Clock.MAX_TIME).plusWeeks(1) : plusWeeks(-j2);
    }

    public ZonedDateTime minusYears(long j2) {
        return j2 == Long.MIN_VALUE ? plusYears(Clock.MAX_TIME).plusYears(1) : plusYears(-j2);
    }

    public ZonedDateTime plusDays(long j2) {
        return resolveLocal(this.dateTime.plusDays(j2));
    }

    public ZonedDateTime plusHours(long j2) {
        return resolveInstant(this.dateTime.plusHours(j2));
    }

    public ZonedDateTime plusMinutes(long j2) {
        return resolveInstant(this.dateTime.plusMinutes(j2));
    }

    public ZonedDateTime plusMonths(long j2) {
        return resolveLocal(this.dateTime.plusMonths(j2));
    }

    public ZonedDateTime plusNanos(long j2) {
        return resolveInstant(this.dateTime.plusNanos(j2));
    }

    public ZonedDateTime plusSeconds(long j2) {
        return resolveInstant(this.dateTime.plusSeconds(j2));
    }

    public ZonedDateTime plusWeeks(long j2) {
        return resolveLocal(this.dateTime.plusWeeks(j2));
    }

    public ZonedDateTime plusYears(long j2) {
        return resolveLocal(this.dateTime.plusYears(j2));
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.localDate()) {
            return toLocalDate();
        }
        return super.query(temporalQuery);
    }

    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        return this.dateTime.range(temporalField);
    }

    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetDateTime toOffsetDateTime() {
        return OffsetDateTime.of(this.dateTime, this.offset);
    }

    public String toString() {
        String str = this.dateTime.toString() + this.offset.toString();
        if (this.offset == this.zone) {
            return str;
        }
        return str + '[' + this.zone.toString() + ']';
    }

    public ZonedDateTime truncatedTo(TemporalUnit temporalUnit) {
        return resolveLocal(this.dateTime.truncatedTo(temporalUnit));
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        ZonedDateTime from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        ZonedDateTime withZoneSameInstant = from.withZoneSameInstant(this.zone);
        if (temporalUnit.isDateBased()) {
            return this.dateTime.until(withZoneSameInstant.dateTime, temporalUnit);
        }
        return toOffsetDateTime().until(withZoneSameInstant.toOffsetDateTime(), temporalUnit);
    }

    public ZonedDateTime withDayOfMonth(int i2) {
        return resolveLocal(this.dateTime.withDayOfMonth(i2));
    }

    public ZonedDateTime withDayOfYear(int i2) {
        return resolveLocal(this.dateTime.withDayOfYear(i2));
    }

    public ZonedDateTime withFixedOffsetZone() {
        if (this.zone.equals(this.offset)) {
            return this;
        }
        LocalDateTime localDateTime = this.dateTime;
        ZoneOffset zoneOffset = this.offset;
        return new ZonedDateTime(localDateTime, zoneOffset, zoneOffset);
    }

    public ZonedDateTime withHour(int i2) {
        return resolveLocal(this.dateTime.withHour(i2));
    }

    public ZonedDateTime withMinute(int i2) {
        return resolveLocal(this.dateTime.withMinute(i2));
    }

    public ZonedDateTime withMonth(int i2) {
        return resolveLocal(this.dateTime.withMonth(i2));
    }

    public ZonedDateTime withNano(int i2) {
        return resolveLocal(this.dateTime.withNano(i2));
    }

    public ZonedDateTime withSecond(int i2) {
        return resolveLocal(this.dateTime.withSecond(i2));
    }

    public ZonedDateTime withYear(int i2) {
        return resolveLocal(this.dateTime.withYear(i2));
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        this.dateTime.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
        this.zone.write(dataOutput);
    }

    public static ZonedDateTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static ZonedDateTime of(LocalDateTime localDateTime, ZoneId zoneId) {
        return ofLocal(localDateTime, zoneId, (ZoneOffset) null);
    }

    public static ZonedDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (ZonedDateTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit.isDateBased() || temporalUnit.isTimeBased()) {
                return true;
            }
            return false;
        } else if (temporalUnit == null || !temporalUnit.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public ZonedDateTime withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(this.dateTime);
        if (transition != null && transition.isOverlap()) {
            ZoneOffset offsetBefore = transition.getOffsetBefore();
            if (!offsetBefore.equals(this.offset)) {
                return new ZonedDateTime(this.dateTime, offsetBefore, this.zone);
            }
        }
        return this;
    }

    public ZonedDateTime withLaterOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(toLocalDateTime());
        if (transition != null) {
            ZoneOffset offsetAfter = transition.getOffsetAfter();
            if (!offsetAfter.equals(this.offset)) {
                return new ZonedDateTime(this.dateTime, offsetAfter, this.zone);
            }
        }
        return this;
    }

    public ZonedDateTime withZoneSameInstant(ZoneId zoneId) {
        Jdk8Methods.requireNonNull(zoneId, "zone");
        if (this.zone.equals(zoneId)) {
            return this;
        }
        return create(this.dateTime.toEpochSecond(this.offset), this.dateTime.getNano(), zoneId);
    }

    public ZonedDateTime withZoneSameLocal(ZoneId zoneId) {
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : ofLocal(this.dateTime, zoneId, this.offset);
    }

    public static ZonedDateTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return ofInstant(clock.instant(), clock.getZone());
    }

    public static ZonedDateTime of(int i2, int i3, int i4, int i5, int i6, int i7, int i8, ZoneId zoneId) {
        return ofLocal(LocalDateTime.of(i2, i3, i4, i5, i6, i7, i8), zoneId, (ZoneOffset) null);
    }

    public static ZonedDateTime ofInstant(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(localDateTime, "localDateTime");
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return create(localDateTime.toEpochSecond(zoneOffset), localDateTime.getNano(), zoneId);
    }

    public ZonedDateTime minus(TemporalAmount temporalAmount) {
        return (ZonedDateTime) temporalAmount.subtractFrom(this);
    }

    public ZonedDateTime plus(TemporalAmount temporalAmount) {
        return (ZonedDateTime) temporalAmount.addTo(this);
    }

    public ZonedDateTime with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return resolveLocal(LocalDateTime.of((LocalDate) temporalAdjuster, this.dateTime.toLocalTime()));
        }
        if (temporalAdjuster instanceof LocalTime) {
            return resolveLocal(LocalDateTime.of(this.dateTime.toLocalDate(), (LocalTime) temporalAdjuster));
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return resolveLocal((LocalDateTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof Instant) {
            Instant instant = (Instant) temporalAdjuster;
            return create(instant.getEpochSecond(), instant.getNano(), this.zone);
        } else if (temporalAdjuster instanceof ZoneOffset) {
            return resolveOffset((ZoneOffset) temporalAdjuster);
        } else {
            return (ZonedDateTime) temporalAdjuster.adjustInto(this);
        }
    }

    public ZonedDateTime minus(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? plus((long) Clock.MAX_TIME, temporalUnit).plus(1, temporalUnit) : plus(-j2, temporalUnit);
    }

    public ZonedDateTime plus(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (ZonedDateTime) temporalUnit.addTo(this, j2);
        }
        if (temporalUnit.isDateBased()) {
            return resolveLocal(this.dateTime.plus(j2, temporalUnit));
        }
        return resolveInstant(this.dateTime.plus(j2, temporalUnit));
    }

    public ZonedDateTime with(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (ZonedDateTime) temporalField.adjustInto(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
        if (i2 == 1) {
            return create(j2, getNano(), this.zone);
        }
        if (i2 != 2) {
            return resolveLocal(this.dateTime.with(temporalField, j2));
        }
        return resolveOffset(ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j2)));
    }
}
