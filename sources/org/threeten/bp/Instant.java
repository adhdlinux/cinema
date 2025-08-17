package org.threeten.bp;

import com.facebook.common.time.Clock;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.joda.time.DateTimeConstants;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class Instant extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    public static final Instant EPOCH = new Instant(0, 0);
    public static final TemporalQuery<Instant> FROM = new TemporalQuery<Instant>() {
        public Instant queryFrom(TemporalAccessor temporalAccessor) {
            return Instant.from(temporalAccessor);
        }
    };
    public static final Instant MAX = ofEpochSecond(MAX_SECOND, 999999999);
    private static final long MAX_SECOND = 31556889864403199L;
    private static final long MILLIS_PER_SEC = 1000;
    public static final Instant MIN = ofEpochSecond(MIN_SECOND, 0);
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;

    /* renamed from: org.threeten.bp.Instant$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0085 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r4 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r4 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r4 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                org.threeten.bp.temporal.ChronoField[] r4 = org.threeten.bp.temporal.ChronoField.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r4
                org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x007b }
                org.threeten.bp.temporal.ChronoField r4 = org.threeten.bp.temporal.ChronoField.MICRO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x007b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0085 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x008f }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Instant.AnonymousClass2.<clinit>():void");
        }
    }

    private Instant(long j2, int i2) {
        this.seconds = j2;
        this.nanos = i2;
    }

    private static Instant create(long j2, int i2) {
        if ((((long) i2) | j2) == 0) {
            return EPOCH;
        }
        if (j2 >= MIN_SECOND && j2 <= MAX_SECOND) {
            return new Instant(j2, i2);
        }
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    public static Instant from(TemporalAccessor temporalAccessor) {
        try {
            return ofEpochSecond(temporalAccessor.getLong(ChronoField.INSTANT_SECONDS), (long) temporalAccessor.get(ChronoField.NANO_OF_SECOND));
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e2);
        }
    }

    private long nanosUntil(Instant instant) {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(Jdk8Methods.safeSubtract(instant.seconds, this.seconds), 1000000000), (long) (instant.nanos - this.nanos));
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public static Instant ofEpochMilli(long j2) {
        return create(Jdk8Methods.floorDiv(j2, 1000), Jdk8Methods.floorMod(j2, 1000) * NANOS_PER_MILLI);
    }

    public static Instant ofEpochSecond(long j2) {
        return create(j2, 0);
    }

    public static Instant parse(CharSequence charSequence) {
        return (Instant) DateTimeFormatter.ISO_INSTANT.parse(charSequence, FROM);
    }

    static Instant readExternal(DataInput dataInput) throws IOException {
        return ofEpochSecond(dataInput.readLong(), (long) dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long secondsUntil(Instant instant) {
        long safeSubtract = Jdk8Methods.safeSubtract(instant.seconds, this.seconds);
        long j2 = (long) (instant.nanos - this.nanos);
        int i2 = (safeSubtract > 0 ? 1 : (safeSubtract == 0 ? 0 : -1));
        if (i2 > 0 && j2 < 0) {
            return safeSubtract - 1;
        }
        if (i2 >= 0 || j2 <= 0) {
            return safeSubtract;
        }
        return safeSubtract + 1;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, (long) this.nanos);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.ofInstant(this, zoneOffset);
    }

    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.ofInstant(this, zoneId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        if (this.seconds == instant.seconds && this.nanos == instant.nanos) {
            return true;
        }
        return false;
    }

    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(temporalField.getFrom(this), temporalField);
        }
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i2 == 1) {
            return this.nanos;
        }
        if (i2 == 2) {
            return this.nanos / 1000;
        }
        if (i2 == 3) {
            return this.nanos / NANOS_PER_MILLI;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    public long getLong(TemporalField temporalField) {
        int i2;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i3 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i3 == 1) {
            i2 = this.nanos;
        } else if (i3 == 2) {
            i2 = this.nanos / 1000;
        } else if (i3 == 3) {
            i2 = this.nanos / NANOS_PER_MILLI;
        } else if (i3 == 4) {
            return this.seconds;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return (long) i2;
    }

    public int getNano() {
        return this.nanos;
    }

    public int hashCode() {
        long j2 = this.seconds;
        return ((int) (j2 ^ (j2 >>> 32))) + (this.nanos * 51);
    }

    public boolean isAfter(Instant instant) {
        return compareTo(instant) > 0;
    }

    public boolean isBefore(Instant instant) {
        return compareTo(instant) < 0;
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.NANO_OF_SECOND || temporalField == ChronoField.MICRO_OF_SECOND || temporalField == ChronoField.MILLI_OF_SECOND) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public Instant minusMillis(long j2) {
        if (j2 == Long.MIN_VALUE) {
            return plusMillis(Clock.MAX_TIME).plusMillis(1);
        }
        return plusMillis(-j2);
    }

    public Instant minusNanos(long j2) {
        if (j2 == Long.MIN_VALUE) {
            return plusNanos(Clock.MAX_TIME).plusNanos(1);
        }
        return plusNanos(-j2);
    }

    public Instant minusSeconds(long j2) {
        if (j2 == Long.MIN_VALUE) {
            return plusSeconds(Clock.MAX_TIME).plusSeconds(1);
        }
        return plusSeconds(-j2);
    }

    public Instant plusMillis(long j2) {
        return plus(j2 / 1000, (j2 % 1000) * 1000000);
    }

    public Instant plusNanos(long j2) {
        return plus(0, j2);
    }

    public Instant plusSeconds(long j2) {
        return plus(j2, 0);
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    public long toEpochMilli() {
        long j2 = this.seconds;
        if (j2 >= 0) {
            return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(j2, 1000), (long) (this.nanos / NANOS_PER_MILLI));
        }
        return Jdk8Methods.safeSubtract(Jdk8Methods.safeMultiply(j2 + 1, 1000), 1000 - ((long) (this.nanos / NANOS_PER_MILLI)));
    }

    public String toString() {
        return DateTimeFormatter.ISO_INSTANT.format(this);
    }

    public Instant truncatedTo(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.NANOS) {
            return this;
        }
        Duration duration = temporalUnit.getDuration();
        if (duration.getSeconds() <= 86400) {
            long nanos2 = duration.toNanos();
            if (86400000000000L % nanos2 == 0) {
                long j2 = ((this.seconds % 86400) * 1000000000) + ((long) this.nanos);
                return plusNanos((Jdk8Methods.floorDiv(j2, nanos2) * nanos2) - j2);
            }
            throw new DateTimeException("Unit must divide into a standard day without remainder");
        }
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Instant from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return nanosUntil(from);
            case 2:
                return nanosUntil(from) / 1000;
            case 3:
                return Jdk8Methods.safeSubtract(from.toEpochMilli(), toEpochMilli());
            case 4:
                return secondsUntil(from);
            case 5:
                return secondsUntil(from) / 60;
            case 6:
                return secondsUntil(from) / 3600;
            case 7:
                return secondsUntil(from) / 43200;
            case 8:
                return secondsUntil(from) / 86400;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    public static Instant now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return clock.instant();
    }

    public static Instant ofEpochSecond(long j2, long j3) {
        return create(Jdk8Methods.safeAdd(j2, Jdk8Methods.floorDiv(j3, 1000000000)), Jdk8Methods.floorMod(j3, 1000000000));
    }

    public int compareTo(Instant instant) {
        int compareLongs = Jdk8Methods.compareLongs(this.seconds, instant.seconds);
        if (compareLongs != 0) {
            return compareLongs;
        }
        return this.nanos - instant.nanos;
    }

    public Instant minus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.subtractFrom(this);
    }

    public Instant plus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.addTo(this);
    }

    public Instant with(TemporalAdjuster temporalAdjuster) {
        return (Instant) temporalAdjuster.adjustInto(this);
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit.isTimeBased() || temporalUnit == ChronoUnit.DAYS) {
                return true;
            }
            return false;
        } else if (temporalUnit == null || !temporalUnit.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public Instant minus(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? plus((long) Clock.MAX_TIME, temporalUnit).plus(1, temporalUnit) : plus(-j2, temporalUnit);
    }

    public Instant plus(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.addTo(this, j2);
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusNanos(j2);
            case 2:
                return plus(j2 / 1000000, (j2 % 1000000) * 1000);
            case 3:
                return plusMillis(j2);
            case 4:
                return plusSeconds(j2);
            case 5:
                return plusSeconds(Jdk8Methods.safeMultiply(j2, 60));
            case 6:
                return plusSeconds(Jdk8Methods.safeMultiply(j2, (int) DateTimeConstants.SECONDS_PER_HOUR));
            case 7:
                return plusSeconds(Jdk8Methods.safeMultiply(j2, 43200));
            case 8:
                return plusSeconds(Jdk8Methods.safeMultiply(j2, (int) DateTimeConstants.SECONDS_PER_DAY));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public Instant with(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (Instant) temporalField.adjustInto(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j2);
        int i2 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
        if (i2 == 1) {
            return j2 != ((long) this.nanos) ? create(this.seconds, (int) j2) : this;
        }
        if (i2 == 2) {
            int i3 = ((int) j2) * 1000;
            return i3 != this.nanos ? create(this.seconds, i3) : this;
        } else if (i2 == 3) {
            int i4 = ((int) j2) * NANOS_PER_MILLI;
            return i4 != this.nanos ? create(this.seconds, i4) : this;
        } else if (i2 == 4) {
            return j2 != this.seconds ? create(j2, this.nanos) : this;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    private Instant plus(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return ofEpochSecond(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(this.seconds, j2), j3 / 1000000000), ((long) this.nanos) + (j3 % 1000000000));
    }
}
