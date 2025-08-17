package org.joda.time;

import androidx.media3.exoplayer.mediacodec.f;
import com.facebook.common.time.Clock;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.FormatUtils;
import org.joda.time.tz.DefaultNameProvider;
import org.joda.time.tz.FixedDateTimeZone;
import org.joda.time.tz.NameProvider;
import org.joda.time.tz.Provider;

public abstract class DateTimeZone implements Serializable {
    private static final int MAX_MILLIS = 86399999;
    public static final DateTimeZone UTC = UTCDateTimeZone.INSTANCE;
    private static final AtomicReference<DateTimeZone> cDefault = new AtomicReference<>();
    private static final AtomicReference<NameProvider> cNameProvider = new AtomicReference<>();
    private static final AtomicReference<Provider> cProvider = new AtomicReference<>();
    private static final long serialVersionUID = 5546345482340108586L;
    private final String iID;

    static final class LazyInit {
        static final Map<String, String> CONVERSION_MAP = buildMap();
        static final DateTimeFormatter OFFSET_FORMATTER = buildFormatter();

        LazyInit() {
        }

        private static DateTimeFormatter buildFormatter() {
            return new DateTimeFormatterBuilder().appendTimeZoneOffset((String) null, true, 2, 4).toFormatter().withChronology(new BaseChronology() {
                private static final long serialVersionUID = -3128740902654445468L;

                public DateTimeZone getZone() {
                    return null;
                }

                public String toString() {
                    return getClass().getName();
                }

                public Chronology withUTC() {
                    return this;
                }

                public Chronology withZone(DateTimeZone dateTimeZone) {
                    return this;
                }
            });
        }

        private static Map<String, String> buildMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("GMT", "UTC");
            hashMap.put("WET", "WET");
            hashMap.put("CET", "CET");
            hashMap.put("MET", "CET");
            hashMap.put("ECT", "CET");
            hashMap.put("EET", "EET");
            hashMap.put("MIT", "Pacific/Apia");
            hashMap.put("HST", "Pacific/Honolulu");
            hashMap.put("AST", "America/Anchorage");
            hashMap.put("PST", "America/Los_Angeles");
            hashMap.put("MST", "America/Denver");
            hashMap.put("PNT", "America/Phoenix");
            hashMap.put("CST", "America/Chicago");
            hashMap.put("EST", "America/New_York");
            hashMap.put("IET", "America/Indiana/Indianapolis");
            hashMap.put("PRT", "America/Puerto_Rico");
            hashMap.put("CNT", "America/St_Johns");
            hashMap.put("AGT", "America/Argentina/Buenos_Aires");
            hashMap.put("BET", "America/Sao_Paulo");
            hashMap.put("ART", "Africa/Cairo");
            hashMap.put("CAT", "Africa/Harare");
            hashMap.put("EAT", "Africa/Addis_Ababa");
            hashMap.put("NET", "Asia/Yerevan");
            hashMap.put("PLT", "Asia/Karachi");
            hashMap.put("IST", "Asia/Kolkata");
            hashMap.put("BST", "Asia/Dhaka");
            hashMap.put("VST", "Asia/Ho_Chi_Minh");
            hashMap.put("CTT", "Asia/Shanghai");
            hashMap.put("JST", "Asia/Tokyo");
            hashMap.put("ACT", "Australia/Darwin");
            hashMap.put("AET", "Australia/Sydney");
            hashMap.put("SST", "Pacific/Guadalcanal");
            hashMap.put("NST", "Pacific/Auckland");
            return Collections.unmodifiableMap(hashMap);
        }
    }

    private static final class Stub implements Serializable {
        private static final long serialVersionUID = -6471952376487863581L;
        private transient String iID;

        Stub(String str) {
            this.iID = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this.iID = objectInputStream.readUTF();
        }

        private Object readResolve() throws ObjectStreamException {
            return DateTimeZone.forID(this.iID);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeUTF(this.iID);
        }
    }

    protected DateTimeZone(String str) {
        if (str != null) {
            this.iID = str;
            return;
        }
        throw new IllegalArgumentException("Id must not be null");
    }

    private static String convertToAsciiNumber(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i2 = 0; i2 < sb.length(); i2++) {
            int digit = Character.digit(sb.charAt(i2), 10);
            if (digit >= 0) {
                sb.setCharAt(i2, (char) (digit + 48));
            }
        }
        return sb.toString();
    }

    private static DateTimeZone fixedOffsetZone(String str, int i2) {
        if (i2 == 0) {
            return UTC;
        }
        return new FixedDateTimeZone(str, (String) null, i2, i2);
    }

    @FromString
    public static DateTimeZone forID(String str) {
        if (str == null) {
            return getDefault();
        }
        if (str.equals("UTC")) {
            return UTC;
        }
        DateTimeZone zone = getProvider().getZone(str);
        if (zone != null) {
            return zone;
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            int parseOffset = parseOffset(str);
            if (((long) parseOffset) == 0) {
                return UTC;
            }
            return fixedOffsetZone(printOffset(parseOffset), parseOffset);
        }
        throw new IllegalArgumentException("The datetime zone id '" + str + "' is not recognised");
    }

    public static DateTimeZone forOffsetHours(int i2) throws IllegalArgumentException {
        return forOffsetHoursMinutes(i2, 0);
    }

    public static DateTimeZone forOffsetHoursMinutes(int i2, int i3) throws IllegalArgumentException {
        int i4;
        if (i2 == 0 && i3 == 0) {
            return UTC;
        }
        if (i2 < -23 || i2 > 23) {
            throw new IllegalArgumentException("Hours out of range: " + i2);
        } else if (i3 < -59 || i3 > 59) {
            throw new IllegalArgumentException("Minutes out of range: " + i3);
        } else if (i2 <= 0 || i3 >= 0) {
            int i5 = i2 * 60;
            if (i5 < 0) {
                try {
                    i4 = i5 - Math.abs(i3);
                } catch (ArithmeticException unused) {
                    throw new IllegalArgumentException("Offset is too large");
                }
            } else {
                i4 = i5 + i3;
            }
            return forOffsetMillis(FieldUtils.safeMultiply(i4, (int) DateTimeConstants.MILLIS_PER_MINUTE));
        } else {
            throw new IllegalArgumentException("Positive hours must not have negative minutes: " + i3);
        }
    }

    public static DateTimeZone forOffsetMillis(int i2) {
        if (i2 >= -86399999 && i2 <= MAX_MILLIS) {
            return fixedOffsetZone(printOffset(i2), i2);
        }
        throw new IllegalArgumentException("Millis out of range: " + i2);
    }

    public static DateTimeZone forTimeZone(TimeZone timeZone) {
        DateTimeZone dateTimeZone;
        char charAt;
        if (timeZone == null) {
            return getDefault();
        }
        String id = timeZone.getID();
        if (id == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
        } else if (id.equals("UTC")) {
            return UTC;
        } else {
            String convertedId = getConvertedId(id);
            Provider provider = getProvider();
            if (convertedId != null) {
                dateTimeZone = provider.getZone(convertedId);
            } else {
                dateTimeZone = null;
            }
            if (dateTimeZone == null) {
                dateTimeZone = provider.getZone(id);
            }
            if (dateTimeZone != null) {
                return dateTimeZone;
            }
            if (convertedId != null || (!id.startsWith("GMT+") && !id.startsWith("GMT-"))) {
                throw new IllegalArgumentException("The datetime zone id '" + id + "' is not recognised");
            }
            String substring = id.substring(3);
            if (substring.length() > 2 && (charAt = substring.charAt(1)) > '9' && Character.isDigit(charAt)) {
                substring = convertToAsciiNumber(substring);
            }
            int parseOffset = parseOffset(substring);
            if (((long) parseOffset) == 0) {
                return UTC;
            }
            return fixedOffsetZone(printOffset(parseOffset), parseOffset);
        }
    }

    public static Set<String> getAvailableIDs() {
        return getProvider().getAvailableIDs();
    }

    private static String getConvertedId(String str) {
        return LazyInit.CONVERSION_MAP.get(str);
    }

    public static DateTimeZone getDefault() {
        DateTimeZone dateTimeZone = cDefault.get();
        if (dateTimeZone != null) {
            return dateTimeZone;
        }
        try {
            String property = System.getProperty("user.timezone");
            if (property != null) {
                dateTimeZone = forID(property);
            }
        } catch (RuntimeException unused) {
        }
        if (dateTimeZone == null) {
            try {
                dateTimeZone = forTimeZone(TimeZone.getDefault());
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (dateTimeZone == null) {
            dateTimeZone = UTC;
        }
        AtomicReference<DateTimeZone> atomicReference = cDefault;
        if (!f.a(atomicReference, (Object) null, dateTimeZone)) {
            return atomicReference.get();
        }
        return dateTimeZone;
    }

    private static NameProvider getDefaultNameProvider() {
        NameProvider nameProvider = null;
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
            if (property != null) {
                nameProvider = (NameProvider) Class.forName(property).newInstance();
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        } catch (SecurityException unused) {
        }
        if (nameProvider == null) {
            return new DefaultNameProvider();
        }
        return nameProvider;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.joda.time.tz.Provider getDefaultProvider() {
        /*
            java.lang.String r0 = "org.joda.time.DateTimeZone.Provider"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x001e }
            if (r0 == 0) goto L_0x001e
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0017 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0017 }
            org.joda.time.tz.Provider r0 = (org.joda.time.tz.Provider) r0     // Catch:{ Exception -> 0x0017 }
            org.joda.time.tz.Provider r0 = validateProvider(r0)     // Catch:{ Exception -> 0x0017 }
            return r0
        L_0x0017:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ SecurityException -> 0x001e }
            r1.<init>(r0)     // Catch:{ SecurityException -> 0x001e }
            throw r1     // Catch:{ SecurityException -> 0x001e }
        L_0x001e:
            java.lang.String r0 = "org.joda.time.DateTimeZone.Folder"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x003c }
            if (r0 == 0) goto L_0x003c
            org.joda.time.tz.ZoneInfoProvider r1 = new org.joda.time.tz.ZoneInfoProvider     // Catch:{ Exception -> 0x0035 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0035 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0035 }
            r1.<init>((java.io.File) r2)     // Catch:{ Exception -> 0x0035 }
            org.joda.time.tz.Provider r0 = validateProvider(r1)     // Catch:{ Exception -> 0x0035 }
            return r0
        L_0x0035:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ SecurityException -> 0x003c }
            r1.<init>(r0)     // Catch:{ SecurityException -> 0x003c }
            throw r1     // Catch:{ SecurityException -> 0x003c }
        L_0x003c:
            org.joda.time.tz.ZoneInfoProvider r0 = new org.joda.time.tz.ZoneInfoProvider     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = "org/joda/time/tz/data"
            r0.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x0048 }
            org.joda.time.tz.Provider r0 = validateProvider(r0)     // Catch:{ Exception -> 0x0048 }
            return r0
        L_0x0048:
            r0 = move-exception
            r0.printStackTrace()
            org.joda.time.tz.UTCProvider r0 = new org.joda.time.tz.UTCProvider
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.getDefaultProvider():org.joda.time.tz.Provider");
    }

    public static NameProvider getNameProvider() {
        AtomicReference<NameProvider> atomicReference = cNameProvider;
        NameProvider nameProvider = atomicReference.get();
        if (nameProvider != null) {
            return nameProvider;
        }
        NameProvider defaultNameProvider = getDefaultNameProvider();
        if (!f.a(atomicReference, (Object) null, defaultNameProvider)) {
            return atomicReference.get();
        }
        return defaultNameProvider;
    }

    public static Provider getProvider() {
        AtomicReference<Provider> atomicReference = cProvider;
        Provider provider = atomicReference.get();
        if (provider != null) {
            return provider;
        }
        Provider defaultProvider = getDefaultProvider();
        if (!f.a(atomicReference, (Object) null, defaultProvider)) {
            return atomicReference.get();
        }
        return defaultProvider;
    }

    private static int parseOffset(String str) {
        return -((int) LazyInit.OFFSET_FORMATTER.parseMillis(str));
    }

    private static String printOffset(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i2 = -i2;
        }
        int i3 = i2 / DateTimeConstants.MILLIS_PER_HOUR;
        FormatUtils.appendPaddedInteger(stringBuffer, i3, 2);
        int i4 = i2 - (i3 * DateTimeConstants.MILLIS_PER_HOUR);
        int i5 = i4 / DateTimeConstants.MILLIS_PER_MINUTE;
        stringBuffer.append(':');
        FormatUtils.appendPaddedInteger(stringBuffer, i5, 2);
        int i6 = i4 - (i5 * DateTimeConstants.MILLIS_PER_MINUTE);
        if (i6 == 0) {
            return stringBuffer.toString();
        }
        int i7 = i6 / 1000;
        stringBuffer.append(':');
        FormatUtils.appendPaddedInteger(stringBuffer, i7, 2);
        int i8 = i6 - (i7 * 1000);
        if (i8 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        FormatUtils.appendPaddedInteger(stringBuffer, i8, 3);
        return stringBuffer.toString();
    }

    public static void setDefault(DateTimeZone dateTimeZone) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setDefault"));
        }
        if (dateTimeZone != null) {
            cDefault.set(dateTimeZone);
            return;
        }
        throw new IllegalArgumentException("The datetime zone must not be null");
    }

    public static void setNameProvider(NameProvider nameProvider) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setNameProvider"));
        }
        if (nameProvider == null) {
            nameProvider = getDefaultNameProvider();
        }
        cNameProvider.set(nameProvider);
    }

    public static void setProvider(Provider provider) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setProvider"));
        }
        if (provider == null) {
            provider = getDefaultProvider();
        } else {
            validateProvider(provider);
        }
        cProvider.set(provider);
    }

    private static Provider validateProvider(Provider provider) {
        Set<String> availableIDs = provider.getAvailableIDs();
        if (availableIDs == null || availableIDs.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        } else if (!availableIDs.contains("UTC")) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        } else if (UTC.equals(provider.getZone("UTC"))) {
            return provider;
        } else {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        }
    }

    public long adjustOffset(long j2, boolean z2) {
        long j3 = j2 - 10800000;
        long offset = (long) getOffset(j3);
        long offset2 = (long) getOffset(10800000 + j2);
        if (offset <= offset2) {
            return j2;
        }
        long j4 = offset - offset2;
        long nextTransition = nextTransition(j3);
        long j5 = nextTransition - j4;
        long j6 = nextTransition + j4;
        if (j2 < j5 || j2 >= j6) {
            return j2;
        }
        if (j2 - j5 >= j4) {
            if (z2) {
                return j2;
            }
            return j2 - j4;
        } else if (z2) {
            return j2 + j4;
        } else {
            return j2;
        }
    }

    public long convertLocalToUTC(long j2, boolean z2, long j3) {
        int offset = getOffset(j3);
        long j4 = j2 - ((long) offset);
        if (getOffset(j4) == offset) {
            return j4;
        }
        return convertLocalToUTC(j2, z2);
    }

    public long convertUTCToLocal(long j2) {
        long offset = (long) getOffset(j2);
        long j3 = j2 + offset;
        if ((j2 ^ j3) >= 0 || (j2 ^ offset) < 0) {
            return j3;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public abstract boolean equals(Object obj);

    @ToString
    public final String getID() {
        return this.iID;
    }

    public long getMillisKeepLocal(DateTimeZone dateTimeZone, long j2) {
        if (dateTimeZone == null) {
            dateTimeZone = getDefault();
        }
        DateTimeZone dateTimeZone2 = dateTimeZone;
        if (dateTimeZone2 == this) {
            return j2;
        }
        return dateTimeZone2.convertLocalToUTC(convertUTCToLocal(j2), false, j2);
    }

    public final String getName(long j2) {
        return getName(j2, (Locale) null);
    }

    public abstract String getNameKey(long j2);

    public abstract int getOffset(long j2);

    public final int getOffset(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return getOffset(DateTimeUtils.currentTimeMillis());
        }
        return getOffset(readableInstant.getMillis());
    }

    public int getOffsetFromLocal(long j2) {
        int offset = getOffset(j2);
        long j3 = j2 - ((long) offset);
        int offset2 = getOffset(j3);
        if (offset != offset2) {
            if (offset - offset2 < 0) {
                long nextTransition = nextTransition(j3);
                long j4 = Clock.MAX_TIME;
                if (nextTransition == j3) {
                    nextTransition = Long.MAX_VALUE;
                }
                long j5 = j2 - ((long) offset2);
                long nextTransition2 = nextTransition(j5);
                if (nextTransition2 != j5) {
                    j4 = nextTransition2;
                }
                if (nextTransition != j4) {
                    return offset;
                }
            }
        } else if (offset >= 0) {
            long previousTransition = previousTransition(j3);
            if (previousTransition < j3) {
                int offset3 = getOffset(previousTransition);
                if (j3 - previousTransition <= ((long) (offset3 - offset))) {
                    return offset3;
                }
            }
        }
        return offset2;
    }

    public final String getShortName(long j2) {
        return getShortName(j2, (Locale) null);
    }

    public abstract int getStandardOffset(long j2);

    public int hashCode() {
        return getID().hashCode() + 57;
    }

    public abstract boolean isFixed();

    public boolean isLocalDateTimeGap(LocalDateTime localDateTime) {
        if (isFixed()) {
            return false;
        }
        try {
            localDateTime.toDateTime(this);
            return false;
        } catch (IllegalInstantException unused) {
            return true;
        }
    }

    public boolean isStandardOffset(long j2) {
        return getOffset(j2) == getStandardOffset(j2);
    }

    public abstract long nextTransition(long j2);

    public abstract long previousTransition(long j2);

    public String toString() {
        return getID();
    }

    public TimeZone toTimeZone() {
        return TimeZone.getTimeZone(this.iID);
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        return new Stub(this.iID);
    }

    public String getName(long j2, Locale locale) {
        String str;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j2);
        if (nameKey == null) {
            return this.iID;
        }
        NameProvider nameProvider = getNameProvider();
        if (nameProvider instanceof DefaultNameProvider) {
            str = ((DefaultNameProvider) nameProvider).getName(locale, this.iID, nameKey, isStandardOffset(j2));
        } else {
            str = nameProvider.getName(locale, this.iID, nameKey);
        }
        if (str != null) {
            return str;
        }
        return printOffset(getOffset(j2));
    }

    public String getShortName(long j2, Locale locale) {
        String str;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j2);
        if (nameKey == null) {
            return this.iID;
        }
        NameProvider nameProvider = getNameProvider();
        if (nameProvider instanceof DefaultNameProvider) {
            str = ((DefaultNameProvider) nameProvider).getShortName(locale, this.iID, nameKey, isStandardOffset(j2));
        } else {
            str = nameProvider.getShortName(locale, this.iID, nameKey);
        }
        if (str != null) {
            return str;
        }
        return printOffset(getOffset(j2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long convertLocalToUTC(long r12, boolean r14) {
        /*
            r11 = this;
            int r0 = r11.getOffset((long) r12)
            long r1 = (long) r0
            long r1 = r12 - r1
            int r3 = r11.getOffset((long) r1)
            if (r0 == r3) goto L_0x003d
            if (r14 != 0) goto L_0x0011
            if (r0 >= 0) goto L_0x003d
        L_0x0011:
            long r4 = r11.nextTransition(r1)
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r8 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x001f
            r4 = r6
        L_0x001f:
            long r1 = (long) r3
            long r1 = r12 - r1
            long r8 = r11.nextTransition(r1)
            int r10 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r10 != 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r6 = r8
        L_0x002c:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x003d
            if (r14 != 0) goto L_0x0033
            goto L_0x003e
        L_0x0033:
            org.joda.time.IllegalInstantException r14 = new org.joda.time.IllegalInstantException
            java.lang.String r0 = r11.getID()
            r14.<init>(r12, r0)
            throw r14
        L_0x003d:
            r0 = r3
        L_0x003e:
            long r0 = (long) r0
            long r2 = r12 - r0
            long r4 = r12 ^ r2
            r6 = 0
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 >= 0) goto L_0x0057
            long r12 = r12 ^ r0
            int r14 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r14 < 0) goto L_0x004f
            goto L_0x0057
        L_0x004f:
            java.lang.ArithmeticException r12 = new java.lang.ArithmeticException
            java.lang.String r13 = "Subtracting time zone offset caused overflow"
            r12.<init>(r13)
            throw r12
        L_0x0057:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.convertLocalToUTC(long, boolean):long");
    }
}
