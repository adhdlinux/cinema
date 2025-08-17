package org.threeten.bp;

import com.facebook.common.time.Clock;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Comparator;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.IsoChronology;
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
import org.threeten.bp.temporal.ValueRange;

public final class OffsetDateTime extends DefaultInterfaceTemporal implements TemporalAdjuster, Comparable<OffsetDateTime>, Serializable {
    public static final TemporalQuery<OffsetDateTime> FROM = new TemporalQuery<OffsetDateTime>() {
        public OffsetDateTime queryFrom(TemporalAccessor temporalAccessor) {
            return OffsetDateTime.from(temporalAccessor);
        }
    };
    private static final Comparator<OffsetDateTime> INSTANT_COMPARATOR = new Comparator<OffsetDateTime>() {
        public int compare(OffsetDateTime offsetDateTime, OffsetDateTime offsetDateTime2) {
            int compareLongs = Jdk8Methods.compareLongs(offsetDateTime.toEpochSecond(), offsetDateTime2.toEpochSecond());
            return compareLongs == 0 ? Jdk8Methods.compareLongs((long) offsetDateTime.getNano(), (long) offsetDateTime2.getNano()) : compareLongs;
        }
    };
    public static final OffsetDateTime MAX = LocalDateTime.MAX.atOffset(ZoneOffset.MIN);
    public static final OffsetDateTime MIN = LocalDateTime.MIN.atOffset(ZoneOffset.MAX);
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;

    /* renamed from: org.threeten.bp.OffsetDateTime$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
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
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.OffsetDateTime.AnonymousClass3.<clinit>():void");
        }
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.dateTime = (LocalDateTime) Jdk8Methods.requireNonNull(localDateTime, "dateTime");
        this.offset = (ZoneOffset) Jdk8Methods.requireNonNull(zoneOffset, "offset");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return ofInstant(org.threeten.bp.Instant.from(r3), r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.threeten.bp.OffsetDateTime from(org.threeten.bp.temporal.TemporalAccessor r3) {
        /*
            boolean r0 = r3 instanceof org.threeten.bp.OffsetDateTime
            if (r0 == 0) goto L_0x0007
            org.threeten.bp.OffsetDateTime r3 = (org.threeten.bp.OffsetDateTime) r3
            return r3
        L_0x0007:
            org.threeten.bp.ZoneOffset r0 = org.threeten.bp.ZoneOffset.from(r3)     // Catch:{ DateTimeException -> 0x001d }
            org.threeten.bp.LocalDateTime r1 = org.threeten.bp.LocalDateTime.from(r3)     // Catch:{ DateTimeException -> 0x0014 }
            org.threeten.bp.OffsetDateTime r3 = of(r1, r0)     // Catch:{ DateTimeException -> 0x0014 }
            return r3
        L_0x0014:
            org.threeten.bp.Instant r1 = org.threeten.bp.Instant.from(r3)     // Catch:{ DateTimeException -> 0x001d }
            org.threeten.bp.OffsetDateTime r3 = ofInstant(r1, r0)     // Catch:{ DateTimeException -> 0x001d }
            return r3
        L_0x001d:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to obtain OffsetDateTime from TemporalAccessor: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = ", type "
            r1.append(r2)
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.OffsetDateTime.from(org.threeten.bp.temporal.TemporalAccessor):org.threeten.bp.OffsetDateTime");
    }

    public static OffsetDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetDateTime of(LocalDate localDate, LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(LocalDateTime.of(localDate, localTime), zoneOffset);
    }

    public static OffsetDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(instant, "instant");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        ZoneOffset offset2 = zoneId.getRules().getOffset(instant);
        return new OffsetDateTime(LocalDateTime.ofEpochSecond(instant.getEpochSecond(), instant.getNano(), offset2), offset2);
    }

    public static OffsetDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    static OffsetDateTime readExternal(DataInput dataInput) throws IOException {
        return of(LocalDateTime.readExternal(dataInput), ZoneOffset.readExternal(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Comparator<OffsetDateTime> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, (long) getOffset().getTotalSeconds());
    }

    public ZonedDateTime atZoneSameInstant(ZoneId zoneId) {
        return ZonedDateTime.ofInstant(this.dateTime, this.offset, zoneId);
    }

    public ZonedDateTime atZoneSimilarLocal(ZoneId zoneId) {
        return ZonedDateTime.ofLocal(this.dateTime, zoneId, this.offset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        if (!this.dateTime.equals(offsetDateTime.dateTime) || !this.offset.equals(offsetDateTime.offset)) {
            return false;
        }
        return true;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.get(temporalField);
        }
        int i2 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
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
        int i2 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
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

    public int hashCode() {
        return this.dateTime.hashCode() ^ this.offset.hashCode();
    }

    public boolean isAfter(OffsetDateTime offsetDateTime) {
        int i2 = (toEpochSecond() > offsetDateTime.toEpochSecond() ? 1 : (toEpochSecond() == offsetDateTime.toEpochSecond() ? 0 : -1));
        if (i2 > 0 || (i2 == 0 && toLocalTime().getNano() > offsetDateTime.toLocalTime().getNano())) {
            return true;
        }
        return false;
    }

    public boolean isBefore(OffsetDateTime offsetDateTime) {
        int i2 = (toEpochSecond() > offsetDateTime.toEpochSecond() ? 1 : (toEpochSecond() == offsetDateTime.toEpochSecond() ? 0 : -1));
        if (i2 < 0 || (i2 == 0 && toLocalTime().getNano() < offsetDateTime.toLocalTime().getNano())) {
            return true;
        }
        return false;
    }

    public boolean isEqual(OffsetDateTime offsetDateTime) {
        if (toEpochSecond() == offsetDateTime.toEpochSecond() && toLocalTime().getNano() == offsetDateTime.toLocalTime().getNano()) {
            return true;
        }
        return false;
    }

    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    public OffsetDateTime minusDays(long j2) {
        return j2 == Long.MIN_VALUE ? plusDays(Clock.MAX_TIME).plusDays(1) : plusDays(-j2);
    }

    public OffsetDateTime minusHours(long j2) {
        return j2 == Long.MIN_VALUE ? plusHours(Clock.MAX_TIME).plusHours(1) : plusHours(-j2);
    }

    public OffsetDateTime minusMinutes(long j2) {
        return j2 == Long.MIN_VALUE ? plusMinutes(Clock.MAX_TIME).plusMinutes(1) : plusMinutes(-j2);
    }

    public OffsetDateTime minusMonths(long j2) {
        return j2 == Long.MIN_VALUE ? plusMonths(Clock.MAX_TIME).plusMonths(1) : plusMonths(-j2);
    }

    public OffsetDateTime minusNanos(long j2) {
        return j2 == Long.MIN_VALUE ? plusNanos(Clock.MAX_TIME).plusNanos(1) : plusNanos(-j2);
    }

    public OffsetDateTime minusSeconds(long j2) {
        return j2 == Long.MIN_VALUE ? plusSeconds(Clock.MAX_TIME).plusSeconds(1) : plusSeconds(-j2);
    }

    public OffsetDateTime minusWeeks(long j2) {
        return j2 == Long.MIN_VALUE ? plusWeeks(Clock.MAX_TIME).plusWeeks(1) : plusWeeks(-j2);
    }

    public OffsetDateTime minusYears(long j2) {
        return j2 == Long.MIN_VALUE ? plusYears(Clock.MAX_TIME).plusYears(1) : plusYears(-j2);
    }

    public OffsetDateTime plusDays(long j2) {
        return with(this.dateTime.plusDays(j2), this.offset);
    }

    public OffsetDateTime plusHours(long j2) {
        return with(this.dateTime.plusHours(j2), this.offset);
    }

    public OffsetDateTime plusMinutes(long j2) {
        return with(this.dateTime.plusMinutes(j2), this.offset);
    }

    public OffsetDateTime plusMonths(long j2) {
        return with(this.dateTime.plusMonths(j2), this.offset);
    }

    public OffsetDateTime plusNanos(long j2) {
        return with(this.dateTime.plusNanos(j2), this.offset);
    }

    public OffsetDateTime plusSeconds(long j2) {
        return with(this.dateTime.plusSeconds(j2), this.offset);
    }

    public OffsetDateTime plusWeeks(long j2) {
        return with(this.dateTime.plusWeeks(j2), this.offset);
    }

    public OffsetDateTime plusYears(long j2) {
        return with(this.dateTime.plusYears(j2), this.offset);
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) {
            return getOffset();
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            return toLocalDate();
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return toLocalTime();
        }
        if (temporalQuery == TemporalQueries.zoneId()) {
            return null;
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

    public long toEpochSecond() {
        return this.dateTime.toEpochSecond(this.offset);
    }

    public Instant toInstant() {
        return this.dateTime.toInstant(this.offset);
    }

    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetTime toOffsetTime() {
        return OffsetTime.of(this.dateTime.toLocalTime(), this.offset);
    }

    public String toString() {
        return this.dateTime.toString() + this.offset.toString();
    }

    public ZonedDateTime toZonedDateTime() {
        return ZonedDateTime.of(this.dateTime, this.offset);
    }

    public OffsetDateTime truncatedTo(TemporalUnit temporalUnit) {
        return with(this.dateTime.truncatedTo(temporalUnit), this.offset);
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        OffsetDateTime from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        return this.dateTime.until(from.withOffsetSameInstant(this.offset).dateTime, temporalUnit);
    }

    public OffsetDateTime withDayOfMonth(int i2) {
        return with(this.dateTime.withDayOfMonth(i2), this.offset);
    }

    public OffsetDateTime withDayOfYear(int i2) {
        return with(this.dateTime.withDayOfYear(i2), this.offset);
    }

    public OffsetDateTime withHour(int i2) {
        return with(this.dateTime.withHour(i2), this.offset);
    }

    public OffsetDateTime withMinute(int i2) {
        return with(this.dateTime.withMinute(i2), this.offset);
    }

    public OffsetDateTime withMonth(int i2) {
        return with(this.dateTime.withMonth(i2), this.offset);
    }

    public OffsetDateTime withNano(int i2) {
        return with(this.dateTime.withNano(i2), this.offset);
    }

    public OffsetDateTime withOffsetSameInstant(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.offset)) {
            return this;
        }
        return new OffsetDateTime(this.dateTime.plusSeconds((long) (zoneOffset.getTotalSeconds() - this.offset.getTotalSeconds())), zoneOffset);
    }

    public OffsetDateTime withOffsetSameLocal(ZoneOffset zoneOffset) {
        return with(this.dateTime, zoneOffset);
    }

    public OffsetDateTime withSecond(int i2) {
        return with(this.dateTime.withSecond(i2), this.offset);
    }

    public OffsetDateTime withYear(int i2) {
        return with(this.dateTime.withYear(i2), this.offset);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        this.dateTime.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
    }

    public static OffsetDateTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static OffsetDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (OffsetDateTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    public int compareTo(OffsetDateTime offsetDateTime) {
        if (getOffset().equals(offsetDateTime.getOffset())) {
            return toLocalDateTime().compareTo((ChronoLocalDateTime<?>) offsetDateTime.toLocalDateTime());
        }
        int compareLongs = Jdk8Methods.compareLongs(toEpochSecond(), offsetDateTime.toEpochSecond());
        if (compareLongs != 0) {
            return compareLongs;
        }
        int nano = toLocalTime().getNano() - offsetDateTime.toLocalTime().getNano();
        return nano == 0 ? toLocalDateTime().compareTo((ChronoLocalDateTime<?>) offsetDateTime.toLocalDateTime()) : nano;
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

    public static OffsetDateTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        return ofInstant(instant, clock.getZone().getRules().getOffset(instant));
    }

    public static OffsetDateTime of(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    private OffsetDateTime with(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        if (this.dateTime != localDateTime || !this.offset.equals(zoneOffset)) {
            return new OffsetDateTime(localDateTime, zoneOffset);
        }
        return this;
    }

    public OffsetDateTime minus(TemporalAmount temporalAmount) {
        return (OffsetDateTime) temporalAmount.subtractFrom(this);
    }

    public OffsetDateTime plus(TemporalAmount temporalAmount) {
        return (OffsetDateTime) temporalAmount.addTo(this);
    }

    public static OffsetDateTime of(int i2, int i3, int i4, int i5, int i6, int i7, int i8, ZoneOffset zoneOffset) {
        return new OffsetDateTime(LocalDateTime.of(i2, i3, i4, i5, i6, i7, i8), zoneOffset);
    }

    public OffsetDateTime minus(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? plus((long) Clock.MAX_TIME, temporalUnit).plus(1, temporalUnit) : plus(-j2, temporalUnit);
    }

    public OffsetDateTime plus(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return with(this.dateTime.plus(j2, temporalUnit), this.offset);
        }
        return (OffsetDateTime) temporalUnit.addTo(this, j2);
    }

    public OffsetDateTime with(TemporalAdjuster temporalAdjuster) {
        if ((temporalAdjuster instanceof LocalDate) || (temporalAdjuster instanceof LocalTime) || (temporalAdjuster instanceof LocalDateTime)) {
            return with(this.dateTime.with(temporalAdjuster), this.offset);
        }
        if (temporalAdjuster instanceof Instant) {
            return ofInstant((Instant) temporalAdjuster, this.offset);
        }
        if (temporalAdjuster instanceof ZoneOffset) {
            return with(this.dateTime, (ZoneOffset) temporalAdjuster);
        }
        if (temporalAdjuster instanceof OffsetDateTime) {
            return (OffsetDateTime) temporalAdjuster;
        }
        return (OffsetDateTime) temporalAdjuster.adjustInto(this);
    }

    public OffsetDateTime with(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (OffsetDateTime) temporalField.adjustInto(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i2 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
        if (i2 == 1) {
            return ofInstant(Instant.ofEpochSecond(j2, (long) getNano()), this.offset);
        }
        if (i2 != 2) {
            return with(this.dateTime.with(temporalField, j2), this.offset);
        }
        return with(this.dateTime, ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j2)));
    }
}
