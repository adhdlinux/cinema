package org.threeten.bp;

import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.common.time.Clock;
import com.google.android.gms.ads.RequestConfiguration;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.joda.time.DateTimeConstants;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(1000000000);
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    public static final Duration ZERO = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;

    /* renamed from: org.threeten.bp.Duration$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Duration.AnonymousClass1.<clinit>():void");
        }
    }

    private Duration(long j2, int i2) {
        this.seconds = j2;
        this.nanos = i2;
    }

    public static Duration between(Temporal temporal, Temporal temporal2) {
        ChronoUnit chronoUnit = ChronoUnit.SECONDS;
        long until = temporal.until(temporal2, chronoUnit);
        ChronoField chronoField = ChronoField.NANO_OF_SECOND;
        long j2 = 0;
        if (temporal.isSupported(chronoField) && temporal2.isSupported(chronoField)) {
            try {
                long j3 = temporal.getLong(chronoField);
                long j4 = temporal2.getLong(chronoField) - j3;
                int i2 = (until > 0 ? 1 : (until == 0 ? 0 : -1));
                if (i2 > 0 && j4 < 0) {
                    j4 += 1000000000;
                } else if (i2 < 0 && j4 > 0) {
                    j4 -= 1000000000;
                } else if (i2 == 0 && j4 != 0) {
                    try {
                        until = temporal.until(temporal2.with(chronoField, j3), chronoUnit);
                    } catch (ArithmeticException | DateTimeException unused) {
                    }
                }
                j2 = j4;
            } catch (ArithmeticException | DateTimeException unused2) {
            }
        }
        return ofSeconds(until, j2);
    }

    private static Duration create(boolean z2, long j2, long j3, long j4, long j5, int i2) {
        long safeAdd = Jdk8Methods.safeAdd(j2, Jdk8Methods.safeAdd(j3, Jdk8Methods.safeAdd(j4, j5)));
        if (z2) {
            return ofSeconds(safeAdd, (long) i2).negated();
        }
        return ofSeconds(safeAdd, (long) i2);
    }

    public static Duration from(TemporalAmount temporalAmount) {
        Jdk8Methods.requireNonNull(temporalAmount, AppLovinEventParameters.REVENUE_AMOUNT);
        Duration duration = ZERO;
        for (TemporalUnit next : temporalAmount.getUnits()) {
            duration = duration.plus(temporalAmount.get(next), next);
        }
        return duration;
    }

    public static Duration of(long j2, TemporalUnit temporalUnit) {
        return ZERO.plus(j2, temporalUnit);
    }

    public static Duration ofDays(long j2) {
        return create(Jdk8Methods.safeMultiply(j2, (int) DateTimeConstants.SECONDS_PER_DAY), 0);
    }

    public static Duration ofHours(long j2) {
        return create(Jdk8Methods.safeMultiply(j2, (int) DateTimeConstants.SECONDS_PER_HOUR), 0);
    }

    public static Duration ofMillis(long j2) {
        long j3 = j2 / 1000;
        int i2 = (int) (j2 % 1000);
        if (i2 < 0) {
            i2 += 1000;
            j3--;
        }
        return create(j3, i2 * NANOS_PER_MILLI);
    }

    public static Duration ofMinutes(long j2) {
        return create(Jdk8Methods.safeMultiply(j2, 60), 0);
    }

    public static Duration ofNanos(long j2) {
        long j3 = j2 / 1000000000;
        int i2 = (int) (j2 % 1000000000);
        if (i2 < 0) {
            i2 += 1000000000;
            j3--;
        }
        return create(j3, i2);
    }

    public static Duration ofSeconds(long j2) {
        return create(j2, 0);
    }

    public static Duration parse(CharSequence charSequence) {
        boolean z2;
        CharSequence charSequence2 = charSequence;
        Jdk8Methods.requireNonNull(charSequence2, "text");
        Matcher matcher = PATTERN.matcher(charSequence2);
        if (matcher.matches() && !RequestConfiguration.MAX_AD_CONTENT_RATING_T.equals(matcher.group(3))) {
            int i2 = 1;
            boolean equals = "-".equals(matcher.group(1));
            String group = matcher.group(2);
            String group2 = matcher.group(4);
            String group3 = matcher.group(5);
            String group4 = matcher.group(6);
            String group5 = matcher.group(7);
            if (!(group == null && group2 == null && group3 == null && group4 == null)) {
                long parseNumber = parseNumber(charSequence2, group, DateTimeConstants.SECONDS_PER_DAY, "days");
                long parseNumber2 = parseNumber(charSequence2, group2, DateTimeConstants.SECONDS_PER_HOUR, "hours");
                long parseNumber3 = parseNumber(charSequence2, group3, 60, "minutes");
                long parseNumber4 = parseNumber(charSequence2, group4, 1, "seconds");
                if (group4 == null || group4.charAt(0) != '-') {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    i2 = -1;
                }
                try {
                    return create(equals, parseNumber, parseNumber2, parseNumber3, parseNumber4, parseFraction(charSequence2, group5, i2));
                } catch (ArithmeticException e2) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", charSequence2, 0).initCause(e2));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Duration", charSequence2, 0);
    }

    private static int parseFraction(CharSequence charSequence, String str, int i2) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            return Integer.parseInt((str + "000000000").substring(0, 9)) * i2;
        } catch (NumberFormatException e2) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e2));
        } catch (ArithmeticException e3) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e3));
        }
    }

    private static long parseNumber(CharSequence charSequence, String str, int i2, String str2) {
        if (str == null) {
            return 0;
        }
        try {
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
            return Jdk8Methods.safeMultiply(Long.parseLong(str), i2);
        } catch (NumberFormatException e2) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + str2, charSequence, 0).initCause(e2));
        } catch (ArithmeticException e3) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + str2, charSequence, 0).initCause(e3));
        }
    }

    static Duration readExternal(DataInput dataInput) throws IOException {
        return ofSeconds(dataInput.readLong(), (long) dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private BigDecimal toSeconds() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf((long) this.nanos, 9));
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public Duration abs() {
        return isNegative() ? negated() : this;
    }

    public Temporal addTo(Temporal temporal) {
        long j2 = this.seconds;
        if (j2 != 0) {
            temporal = temporal.plus(j2, ChronoUnit.SECONDS);
        }
        int i2 = this.nanos;
        if (i2 != 0) {
            return temporal.plus((long) i2, ChronoUnit.NANOS);
        }
        return temporal;
    }

    public Duration dividedBy(long j2) {
        if (j2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        } else if (j2 == 1) {
            return this;
        } else {
            return create(toSeconds().divide(BigDecimal.valueOf(j2), RoundingMode.DOWN));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        if (this.seconds == duration.seconds && this.nanos == duration.nanos) {
            return true;
        }
        return false;
    }

    public long get(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.SECONDS) {
            return this.seconds;
        }
        if (temporalUnit == ChronoUnit.NANOS) {
            return (long) this.nanos;
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.SECONDS, ChronoUnit.NANOS}));
    }

    public int hashCode() {
        long j2 = this.seconds;
        return ((int) (j2 ^ (j2 >>> 32))) + (this.nanos * 51);
    }

    public boolean isNegative() {
        return this.seconds < 0;
    }

    public boolean isZero() {
        return (this.seconds | ((long) this.nanos)) == 0;
    }

    public Duration minus(Duration duration) {
        long seconds2 = duration.getSeconds();
        int nano = duration.getNano();
        if (seconds2 == Long.MIN_VALUE) {
            return plus((long) Clock.MAX_TIME, (long) (-nano)).plus(1, 0);
        }
        return plus(-seconds2, (long) (-nano));
    }

    public Duration minusDays(long j2) {
        return j2 == Long.MIN_VALUE ? plusDays(Clock.MAX_TIME).plusDays(1) : plusDays(-j2);
    }

    public Duration minusHours(long j2) {
        return j2 == Long.MIN_VALUE ? plusHours(Clock.MAX_TIME).plusHours(1) : plusHours(-j2);
    }

    public Duration minusMillis(long j2) {
        return j2 == Long.MIN_VALUE ? plusMillis(Clock.MAX_TIME).plusMillis(1) : plusMillis(-j2);
    }

    public Duration minusMinutes(long j2) {
        return j2 == Long.MIN_VALUE ? plusMinutes(Clock.MAX_TIME).plusMinutes(1) : plusMinutes(-j2);
    }

    public Duration minusNanos(long j2) {
        return j2 == Long.MIN_VALUE ? plusNanos(Clock.MAX_TIME).plusNanos(1) : plusNanos(-j2);
    }

    public Duration minusSeconds(long j2) {
        return j2 == Long.MIN_VALUE ? plusSeconds(Clock.MAX_TIME).plusSeconds(1) : plusSeconds(-j2);
    }

    public Duration multipliedBy(long j2) {
        if (j2 == 0) {
            return ZERO;
        }
        if (j2 == 1) {
            return this;
        }
        return create(toSeconds().multiply(BigDecimal.valueOf(j2)));
    }

    public Duration negated() {
        return multipliedBy(-1);
    }

    public Duration plus(Duration duration) {
        return plus(duration.getSeconds(), (long) duration.getNano());
    }

    public Duration plusDays(long j2) {
        return plus(Jdk8Methods.safeMultiply(j2, (int) DateTimeConstants.SECONDS_PER_DAY), 0);
    }

    public Duration plusHours(long j2) {
        return plus(Jdk8Methods.safeMultiply(j2, (int) DateTimeConstants.SECONDS_PER_HOUR), 0);
    }

    public Duration plusMillis(long j2) {
        return plus(j2 / 1000, (j2 % 1000) * 1000000);
    }

    public Duration plusMinutes(long j2) {
        return plus(Jdk8Methods.safeMultiply(j2, 60), 0);
    }

    public Duration plusNanos(long j2) {
        return plus(0, j2);
    }

    public Duration plusSeconds(long j2) {
        return plus(j2, 0);
    }

    public Temporal subtractFrom(Temporal temporal) {
        long j2 = this.seconds;
        if (j2 != 0) {
            temporal = temporal.minus(j2, ChronoUnit.SECONDS);
        }
        int i2 = this.nanos;
        if (i2 != 0) {
            return temporal.minus((long) i2, ChronoUnit.NANOS);
        }
        return temporal;
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toDaysPart() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public int toHoursPart() {
        return (int) (toHours() % 24);
    }

    public long toMillis() {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(this.seconds, 1000), (long) (this.nanos / NANOS_PER_MILLI));
    }

    public int toMillisPart() {
        return this.nanos / NANOS_PER_MILLI;
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public int toMinutesPart() {
        return (int) (toMinutes() % 60);
    }

    public long toNanos() {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(this.seconds, 1000000000), (long) this.nanos);
    }

    public int toNanosPart() {
        return this.nanos;
    }

    public int toSecondsPart() {
        return (int) (this.seconds % 60);
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j2 = this.seconds;
        long j3 = j2 / 3600;
        int i2 = (int) ((j2 % 3600) / 60);
        int i3 = (int) (j2 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j3 != 0) {
            sb.append(j3);
            sb.append('H');
        }
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        if (i3 == 0 && this.nanos == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i3 >= 0 || this.nanos <= 0) {
            sb.append(i3);
        } else if (i3 == -1) {
            sb.append("-0");
        } else {
            sb.append(i3 + 1);
        }
        if (this.nanos > 0) {
            int length = sb.length();
            if (i3 < 0) {
                sb.append(2000000000 - this.nanos);
            } else {
                sb.append(this.nanos + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    public Duration withNanos(int i2) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue((long) i2);
        return create(this.seconds, i2);
    }

    public Duration withSeconds(long j2) {
        return create(j2, this.nanos);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    public static Duration ofSeconds(long j2, long j3) {
        return create(Jdk8Methods.safeAdd(j2, Jdk8Methods.floorDiv(j3, 1000000000)), Jdk8Methods.floorMod(j3, 1000000000));
    }

    public int compareTo(Duration duration) {
        int compareLongs = Jdk8Methods.compareLongs(this.seconds, duration.seconds);
        if (compareLongs != 0) {
            return compareLongs;
        }
        return this.nanos - duration.nanos;
    }

    public Duration plus(long j2, TemporalUnit temporalUnit) {
        Jdk8Methods.requireNonNull(temporalUnit, "unit");
        if (temporalUnit == ChronoUnit.DAYS) {
            return plus(Jdk8Methods.safeMultiply(j2, (int) DateTimeConstants.SECONDS_PER_DAY), 0);
        }
        if (temporalUnit.isDurationEstimated()) {
            throw new DateTimeException("Unit must not have an estimated duration");
        } else if (j2 == 0) {
            return this;
        } else {
            if (temporalUnit instanceof ChronoUnit) {
                int i2 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()];
                if (i2 == 1) {
                    return plusNanos(j2);
                }
                if (i2 == 2) {
                    return plusSeconds((j2 / 1000000000) * 1000).plusNanos((j2 % 1000000000) * 1000);
                }
                if (i2 == 3) {
                    return plusMillis(j2);
                }
                if (i2 != 4) {
                    return plusSeconds(Jdk8Methods.safeMultiply(temporalUnit.getDuration().seconds, j2));
                }
                return plusSeconds(j2);
            }
            Duration multipliedBy = temporalUnit.getDuration().multipliedBy(j2);
            return plusSeconds(multipliedBy.getSeconds()).plusNanos((long) multipliedBy.getNano());
        }
    }

    private static Duration create(long j2, int i2) {
        if ((((long) i2) | j2) == 0) {
            return ZERO;
        }
        return new Duration(j2, i2);
    }

    public Duration minus(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? plus((long) Clock.MAX_TIME, temporalUnit).plus(1, temporalUnit) : plus(-j2, temporalUnit);
    }

    private static Duration create(BigDecimal bigDecimal) {
        BigInteger bigIntegerExact = bigDecimal.movePointRight(9).toBigIntegerExact();
        BigInteger[] divideAndRemainder = bigIntegerExact.divideAndRemainder(BI_NANOS_PER_SECOND);
        if (divideAndRemainder[0].bitLength() <= 63) {
            return ofSeconds(divideAndRemainder[0].longValue(), (long) divideAndRemainder[1].intValue());
        }
        throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
    }

    private Duration plus(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return ofSeconds(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(this.seconds, j2), j3 / 1000000000), ((long) this.nanos) + (j3 % 1000000000));
    }
}
