package org.joda.time.format;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal.connection.RealConnection;
import org.joda.time.Chronology;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadablePartial;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.PreciseDateTimeField;

public class DateTimeFormatterBuilder {
    private ArrayList<Object> iElementPairs = new ArrayList<>();
    private Object iFormatter;

    static class CharacterLiteral implements InternalPrinter, InternalParser {
        private final char iValue;

        CharacterLiteral(char c2) {
            this.iValue = c2;
        }

        public int estimateParsedLength() {
            return 1;
        }

        public int estimatePrintedLength() {
            return 1;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            char upperCase;
            char upperCase2;
            if (i2 >= charSequence.length()) {
                return ~i2;
            }
            char charAt = charSequence.charAt(i2);
            char c2 = this.iValue;
            if (charAt == c2 || (upperCase = Character.toUpperCase(charAt)) == (upperCase2 = Character.toUpperCase(c2)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
                return i2 + 1;
            }
            return ~i2;
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }
    }

    static class FixedNumber extends PaddedNumber {
        protected FixedNumber(DateTimeFieldType dateTimeFieldType, int i2, boolean z2) {
            super(dateTimeFieldType, i2, z2, i2);
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            int i3;
            char charAt;
            int parseInto = super.parseInto(dateTimeParserBucket, charSequence, i2);
            if (parseInto < 0 || parseInto == (i3 = this.iMaxParsedDigits + i2)) {
                return parseInto;
            }
            if (this.iSigned && ((charAt = charSequence.charAt(i2)) == '-' || charAt == '+')) {
                i3++;
            }
            if (parseInto > i3) {
                return ~(i3 + 1);
            }
            if (parseInto < i3) {
                return ~parseInto;
            }
            return parseInto;
        }
    }

    static class Fraction implements InternalPrinter, InternalParser {
        private final DateTimeFieldType iFieldType;
        protected int iMaxDigits;
        protected int iMinDigits;

        protected Fraction(DateTimeFieldType dateTimeFieldType, int i2, int i3) {
            this.iFieldType = dateTimeFieldType;
            i3 = i3 > 18 ? 18 : i3;
            this.iMinDigits = i2;
            this.iMaxDigits = i3;
        }

        private long[] getFractionData(long j2, DateTimeField dateTimeField) {
            long j3;
            long unitMillis = dateTimeField.getDurationField().getUnitMillis();
            int i2 = this.iMaxDigits;
            while (true) {
                switch (i2) {
                    case 1:
                        j3 = 10;
                        break;
                    case 2:
                        j3 = 100;
                        break;
                    case 3:
                        j3 = 1000;
                        break;
                    case 4:
                        j3 = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
                        break;
                    case 5:
                        j3 = 100000;
                        break;
                    case 6:
                        j3 = 1000000;
                        break;
                    case 7:
                        j3 = 10000000;
                        break;
                    case 8:
                        j3 = 100000000;
                        break;
                    case 9:
                        j3 = 1000000000;
                        break;
                    case 10:
                        j3 = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
                        break;
                    case 11:
                        j3 = 100000000000L;
                        break;
                    case 12:
                        j3 = 1000000000000L;
                        break;
                    case 13:
                        j3 = 10000000000000L;
                        break;
                    case 14:
                        j3 = 100000000000000L;
                        break;
                    case 15:
                        j3 = 1000000000000000L;
                        break;
                    case 16:
                        j3 = 10000000000000000L;
                        break;
                    case 17:
                        j3 = 100000000000000000L;
                        break;
                    case 18:
                        j3 = 1000000000000000000L;
                        break;
                    default:
                        j3 = 1;
                        break;
                }
                if ((unitMillis * j3) / j3 == unitMillis) {
                    return new long[]{(j2 * j3) / unitMillis, (long) i2};
                }
                i2--;
            }
        }

        public int estimateParsedLength() {
            return this.iMaxDigits;
        }

        public int estimatePrintedLength() {
            return this.iMaxDigits;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            DateTimeField field = this.iFieldType.getField(dateTimeParserBucket.getChronology());
            int min = Math.min(this.iMaxDigits, charSequence.length() - i2);
            long unitMillis = field.getDurationField().getUnitMillis() * 10;
            long j2 = 0;
            int i3 = 0;
            while (i3 < min) {
                char charAt = charSequence.charAt(i2 + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3++;
                unitMillis /= 10;
                j2 += ((long) (charAt - '0')) * unitMillis;
            }
            long j3 = j2 / 10;
            if (i3 == 0) {
                return ~i2;
            }
            if (j3 > 2147483647L) {
                return ~i2;
            }
            dateTimeParserBucket.saveField((DateTimeField) new PreciseDateTimeField(DateTimeFieldType.millisOfSecond(), MillisDurationField.INSTANCE, field.getDurationField()), (int) j3);
            return i2 + i3;
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            printTo(appendable, j2, chronology);
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            printTo(appendable, readablePartial.getChronology().set(readablePartial, 0), readablePartial.getChronology());
        }

        /* access modifiers changed from: protected */
        public void printTo(Appendable appendable, long j2, Chronology chronology) throws IOException {
            String str;
            DateTimeField field = this.iFieldType.getField(chronology);
            int i2 = this.iMinDigits;
            try {
                long remainder = field.remainder(j2);
                if (remainder == 0) {
                    while (true) {
                        i2--;
                        if (i2 >= 0) {
                            appendable.append('0');
                        } else {
                            return;
                        }
                    }
                } else {
                    long[] fractionData = getFractionData(remainder, field);
                    long j3 = fractionData[0];
                    int i3 = (int) fractionData[1];
                    if ((2147483647L & j3) == j3) {
                        str = Integer.toString((int) j3);
                    } else {
                        str = Long.toString(j3);
                    }
                    int length = str.length();
                    while (length < i3) {
                        appendable.append('0');
                        i2--;
                        i3--;
                    }
                    if (i2 < i3) {
                        while (i2 < i3 && length > 1 && str.charAt(length - 1) == '0') {
                            i3--;
                            length--;
                        }
                        if (length < str.length()) {
                            for (int i4 = 0; i4 < length; i4++) {
                                appendable.append(str.charAt(i4));
                            }
                            return;
                        }
                    }
                    appendable.append(str);
                }
            } catch (RuntimeException unused) {
                DateTimeFormatterBuilder.appendUnknownString(appendable, i2);
            }
        }
    }

    static class MatchingParser implements InternalParser {
        private final int iParsedLengthEstimate;
        private final InternalParser[] iParsers;

        MatchingParser(InternalParser[] internalParserArr) {
            int estimateParsedLength;
            this.iParsers = internalParserArr;
            int length = internalParserArr.length;
            int i2 = 0;
            while (true) {
                length--;
                if (length >= 0) {
                    InternalParser internalParser = internalParserArr[length];
                    if (internalParser != null && (estimateParsedLength = internalParser.estimateParsedLength()) > i2) {
                        i2 = estimateParsedLength;
                    }
                } else {
                    this.iParsedLengthEstimate = i2;
                    return;
                }
            }
        }

        public int estimateParsedLength() {
            return this.iParsedLengthEstimate;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            int i3;
            int i4;
            InternalParser[] internalParserArr = this.iParsers;
            int length = internalParserArr.length;
            Object saveState = dateTimeParserBucket.saveState();
            boolean z2 = false;
            Object obj = null;
            int i5 = i2;
            int i6 = i5;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    break;
                }
                InternalParser internalParser = internalParserArr[i7];
                if (internalParser != null) {
                    int parseInto = internalParser.parseInto(dateTimeParserBucket, charSequence, i2);
                    if (parseInto >= i2) {
                        if (parseInto <= i5) {
                            continue;
                        } else if (parseInto >= charSequence.length() || (i4 = i7 + 1) >= length || internalParserArr[i4] == null) {
                            return parseInto;
                        } else {
                            obj = dateTimeParserBucket.saveState();
                            i5 = parseInto;
                        }
                    } else if (parseInto < 0 && (i3 = ~parseInto) > i6) {
                        i6 = i3;
                    }
                    dateTimeParserBucket.restoreState(saveState);
                    i7++;
                } else if (i5 <= i2) {
                    return i2;
                } else {
                    z2 = true;
                }
            }
            if (i5 <= i2 && (i5 != i2 || !z2)) {
                return ~i6;
            }
            if (obj != null) {
                dateTimeParserBucket.restoreState(obj);
            }
            return i5;
        }
    }

    static abstract class NumberFormatter implements InternalPrinter, InternalParser {
        protected final DateTimeFieldType iFieldType;
        protected final int iMaxParsedDigits;
        protected final boolean iSigned;

        NumberFormatter(DateTimeFieldType dateTimeFieldType, int i2, boolean z2) {
            this.iFieldType = dateTimeFieldType;
            this.iMaxParsedDigits = i2;
            this.iSigned = z2;
        }

        public int estimateParsedLength() {
            return this.iMaxParsedDigits;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            int i3;
            int i4;
            int i5;
            boolean z2;
            boolean z3;
            char charAt;
            CharSequence charSequence2 = charSequence;
            int i6 = i2;
            int min = Math.min(this.iMaxParsedDigits, charSequence.length() - i6);
            int i7 = 0;
            boolean z4 = false;
            boolean z5 = false;
            while (true) {
                if (i7 >= min) {
                    break;
                }
                int i8 = i6 + i7;
                char charAt2 = charSequence2.charAt(i8);
                if (i7 != 0 || ((charAt2 != '-' && charAt2 != '+') || !this.iSigned)) {
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    i7++;
                } else {
                    z2 = true;
                    if (charAt2 == '-') {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (charAt2 != '+') {
                        z2 = false;
                    }
                    int i9 = i7 + 1;
                    if (i9 >= min || (charAt = charSequence2.charAt(i8 + 1)) < '0' || charAt > '9') {
                        boolean z6 = z3;
                        z5 = z2;
                        z4 = z6;
                    } else {
                        min = Math.min(min + 1, charSequence.length() - i6);
                        i7 = i9;
                        boolean z7 = z3;
                        z5 = z2;
                        z4 = z7;
                    }
                }
            }
            boolean z62 = z3;
            z5 = z2;
            z4 = z62;
            if (i7 == 0) {
                return ~i6;
            }
            if (i7 < 9) {
                if (z4 || z5) {
                    i5 = i6 + 1;
                } else {
                    i5 = i6;
                }
                int i10 = i5 + 1;
                try {
                    int charAt3 = charSequence2.charAt(i5) - '0';
                    i3 = i6 + i7;
                    while (i10 < i3) {
                        int charAt4 = (((charAt3 << 3) + (charAt3 << 1)) + charSequence2.charAt(i10)) - 48;
                        i10++;
                        charAt3 = charAt4;
                    }
                    if (z4) {
                        i4 = -charAt3;
                    } else {
                        i4 = charAt3;
                    }
                } catch (StringIndexOutOfBoundsException unused) {
                    return ~i6;
                }
            } else if (z5) {
                int i11 = i6 + 1;
                i3 = i6 + i7;
                i4 = Integer.parseInt(charSequence2.subSequence(i11, i3).toString());
            } else {
                int i12 = i6 + i7;
                i4 = Integer.parseInt(charSequence2.subSequence(i6, i12).toString());
                i3 = i12;
            }
            dateTimeParserBucket.saveField(this.iFieldType, i4);
            return i3;
        }
    }

    static class StringLiteral implements InternalPrinter, InternalParser {
        private final String iValue;

        StringLiteral(String str) {
            this.iValue = str;
        }

        public int estimateParsedLength() {
            return this.iValue.length();
        }

        public int estimatePrintedLength() {
            return this.iValue.length();
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            if (DateTimeFormatterBuilder.csStartsWithIgnoreCase(charSequence, i2, this.iValue)) {
                return i2 + this.iValue.length();
            }
            return ~i2;
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }
    }

    enum TimeZoneId implements InternalPrinter, InternalParser {
        INSTANCE;
        
        private static final List<String> ALL_IDS = null;
        private static final List<String> BASE_GROUPED_IDS = null;
        private static final Map<String, List<String>> GROUPED_IDS = null;
        static final int MAX_LENGTH = 0;
        static final int MAX_PREFIX_LENGTH = 0;

        static {
            BASE_GROUPED_IDS = new ArrayList();
            ArrayList<String> arrayList = new ArrayList<>(DateTimeZone.getAvailableIDs());
            ALL_IDS = arrayList;
            Collections.sort(arrayList);
            GROUPED_IDS = new HashMap();
            int i2 = 0;
            int i3 = 0;
            for (String str : arrayList) {
                int indexOf = str.indexOf(47);
                if (indexOf >= 0) {
                    if (indexOf < str.length()) {
                        indexOf++;
                    }
                    i3 = Math.max(i3, indexOf);
                    String substring = str.substring(0, indexOf + 1);
                    String substring2 = str.substring(indexOf);
                    Map<String, List<String>> map = GROUPED_IDS;
                    if (!map.containsKey(substring)) {
                        map.put(substring, new ArrayList());
                    }
                    map.get(substring).add(substring2);
                } else {
                    BASE_GROUPED_IDS.add(str);
                }
                i2 = Math.max(i2, str.length());
            }
            MAX_LENGTH = i2;
            MAX_PREFIX_LENGTH = i3;
        }

        public int estimateParsedLength() {
            return MAX_LENGTH;
        }

        public int estimatePrintedLength() {
            return MAX_LENGTH;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            String str;
            int i3;
            String str2;
            List<String> list = BASE_GROUPED_IDS;
            int length = charSequence.length();
            int min = Math.min(length, MAX_PREFIX_LENGTH + i2);
            int i4 = i2;
            while (true) {
                if (i4 >= min) {
                    str = "";
                    i3 = i2;
                    break;
                } else if (charSequence.charAt(i4) == '/') {
                    int i5 = i4 + 1;
                    str = charSequence.subSequence(i2, i5).toString();
                    i3 = str.length() + i2;
                    if (i4 < length) {
                        str2 = str + charSequence.charAt(i5);
                    } else {
                        str2 = str;
                    }
                    list = GROUPED_IDS.get(str2);
                    if (list == null) {
                        return ~i2;
                    }
                } else {
                    i4++;
                }
            }
            String str3 = null;
            for (int i6 = 0; i6 < list.size(); i6++) {
                String str4 = list.get(i6);
                if (DateTimeFormatterBuilder.csStartsWith(charSequence, i3, str4) && (str3 == null || str4.length() > str3.length())) {
                    str3 = str4;
                }
            }
            if (str3 == null) {
                return ~i2;
            }
            dateTimeParserBucket.setZone(DateTimeZone.forID(str + str3));
            return i3 + str3.length();
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(dateTimeZone != null ? dateTimeZone.getID() : "");
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }
    }

    static class TimeZoneName implements InternalPrinter, InternalParser {
        static final int LONG_NAME = 0;
        static final int SHORT_NAME = 1;
        private final Map<String, DateTimeZone> iParseLookup;
        private final int iType;

        TimeZoneName(int i2, Map<String, DateTimeZone> map) {
            this.iType = i2;
            this.iParseLookup = map;
        }

        private String print(long j2, DateTimeZone dateTimeZone, Locale locale) {
            if (dateTimeZone == null) {
                return "";
            }
            int i2 = this.iType;
            if (i2 == 0) {
                return dateTimeZone.getName(j2, locale);
            }
            if (i2 != 1) {
                return "";
            }
            return dateTimeZone.getShortName(j2, locale);
        }

        public int estimateParsedLength() {
            return this.iType == 1 ? 4 : 20;
        }

        public int estimatePrintedLength() {
            return this.iType == 1 ? 4 : 20;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            Map<String, DateTimeZone> map = this.iParseLookup;
            if (map == null) {
                map = DateTimeUtils.getDefaultTimeZoneNames();
            }
            String str = null;
            for (String next : map.keySet()) {
                if (DateTimeFormatterBuilder.csStartsWith(charSequence, i2, next) && (str == null || next.length() > str.length())) {
                    str = next;
                }
            }
            if (str == null) {
                return ~i2;
            }
            dateTimeParserBucket.setZone(map.get(str));
            return i2 + str.length();
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(print(j2 - ((long) i2), dateTimeZone, locale));
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }
    }

    static class TimeZoneOffset implements InternalPrinter, InternalParser {
        private final int iMaxFields;
        private final int iMinFields;
        private final boolean iShowSeparators;
        private final String iZeroOffsetParseText;
        private final String iZeroOffsetPrintText;

        TimeZoneOffset(String str, String str2, boolean z2, int i2, int i3) {
            this.iZeroOffsetPrintText = str;
            this.iZeroOffsetParseText = str2;
            this.iShowSeparators = z2;
            if (i2 <= 0 || i3 < i2) {
                throw new IllegalArgumentException();
            }
            if (i2 > 4) {
                i2 = 4;
                i3 = 4;
            }
            this.iMinFields = i2;
            this.iMaxFields = i3;
        }

        private int digitCount(CharSequence charSequence, int i2, int i3) {
            int i4 = 0;
            for (int min = Math.min(charSequence.length() - i2, i3); min > 0; min--) {
                char charAt = charSequence.charAt(i2 + i4);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i4++;
            }
            return i4;
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int estimatePrintedLength() {
            int i2 = this.iMinFields;
            int i3 = (i2 + 1) << 1;
            if (this.iShowSeparators) {
                i3 += i2 - 1;
            }
            String str = this.iZeroOffsetPrintText;
            if (str == null || str.length() <= i3) {
                return i3;
            }
            return this.iZeroOffsetPrintText.length();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
            if (r6 <= '9') goto L_0x0082;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r12, java.lang.CharSequence r13, int r14) {
            /*
                r11 = this;
                int r0 = r13.length()
                int r0 = r0 - r14
                java.lang.String r1 = r11.iZeroOffsetParseText
                r2 = 43
                r3 = 45
                r4 = 0
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                if (r1 == 0) goto L_0x003a
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0027
                if (r0 <= 0) goto L_0x0023
                char r1 = r13.charAt(r14)
                if (r1 == r3) goto L_0x003a
                if (r1 != r2) goto L_0x0023
                goto L_0x003a
            L_0x0023:
                r12.setOffset((java.lang.Integer) r5)
                return r14
            L_0x0027:
                java.lang.String r1 = r11.iZeroOffsetParseText
                boolean r1 = org.joda.time.format.DateTimeFormatterBuilder.csStartsWithIgnoreCase(r13, r14, r1)
                if (r1 == 0) goto L_0x003a
                r12.setOffset((java.lang.Integer) r5)
                java.lang.String r12 = r11.iZeroOffsetParseText
                int r12 = r12.length()
                int r14 = r14 + r12
                return r14
            L_0x003a:
                r1 = 1
                if (r0 > r1) goto L_0x003f
                int r12 = ~r14
                return r12
            L_0x003f:
                char r5 = r13.charAt(r14)
                if (r5 != r3) goto L_0x0047
                r2 = 1
                goto L_0x004a
            L_0x0047:
                if (r5 != r2) goto L_0x0126
                r2 = 0
            L_0x004a:
                int r0 = r0 + -1
                int r14 = r14 + r1
                r3 = 2
                int r5 = r11.digitCount(r13, r14, r3)
                if (r5 >= r3) goto L_0x0056
                int r12 = ~r14
                return r12
            L_0x0056:
                int r5 = org.joda.time.format.FormatUtils.parseTwoDigits(r13, r14)
                r6 = 23
                if (r5 <= r6) goto L_0x0060
                int r12 = ~r14
                return r12
            L_0x0060:
                r6 = 3600000(0x36ee80, float:5.044674E-39)
                int r5 = r5 * r6
                int r0 = r0 + -2
                int r14 = r14 + r3
                if (r0 > 0) goto L_0x006c
                goto L_0x011b
            L_0x006c:
                char r6 = r13.charAt(r14)
                r7 = 58
                r8 = 48
                if (r6 != r7) goto L_0x007c
                int r0 = r0 + -1
                int r14 = r14 + 1
                r4 = 1
                goto L_0x0082
            L_0x007c:
                if (r6 < r8) goto L_0x011b
                r9 = 57
                if (r6 > r9) goto L_0x011b
            L_0x0082:
                int r6 = r11.digitCount(r13, r14, r3)
                if (r6 != 0) goto L_0x008c
                if (r4 != 0) goto L_0x008c
                goto L_0x011b
            L_0x008c:
                if (r6 >= r3) goto L_0x0090
                int r12 = ~r14
                return r12
            L_0x0090:
                int r6 = org.joda.time.format.FormatUtils.parseTwoDigits(r13, r14)
                r9 = 59
                if (r6 <= r9) goto L_0x009a
                int r12 = ~r14
                return r12
            L_0x009a:
                r10 = 60000(0xea60, float:8.4078E-41)
                int r6 = r6 * r10
                int r5 = r5 + r6
                int r0 = r0 + -2
                int r14 = r14 + 2
                if (r0 > 0) goto L_0x00a8
                goto L_0x011b
            L_0x00a8:
                if (r4 == 0) goto L_0x00b6
                char r6 = r13.charAt(r14)
                if (r6 == r7) goto L_0x00b2
                goto L_0x011b
            L_0x00b2:
                int r0 = r0 + -1
                int r14 = r14 + 1
            L_0x00b6:
                int r6 = r11.digitCount(r13, r14, r3)
                if (r6 != 0) goto L_0x00bf
                if (r4 != 0) goto L_0x00bf
                goto L_0x011b
            L_0x00bf:
                if (r6 >= r3) goto L_0x00c3
                int r12 = ~r14
                return r12
            L_0x00c3:
                int r6 = org.joda.time.format.FormatUtils.parseTwoDigits(r13, r14)
                if (r6 <= r9) goto L_0x00cb
                int r12 = ~r14
                return r12
            L_0x00cb:
                int r6 = r6 * 1000
                int r5 = r5 + r6
                int r0 = r0 + -2
                int r14 = r14 + 2
                if (r0 > 0) goto L_0x00d5
                goto L_0x011b
            L_0x00d5:
                if (r4 == 0) goto L_0x00ea
                char r0 = r13.charAt(r14)
                r6 = 46
                if (r0 == r6) goto L_0x00e8
                char r0 = r13.charAt(r14)
                r6 = 44
                if (r0 == r6) goto L_0x00e8
                goto L_0x011b
            L_0x00e8:
                int r14 = r14 + 1
            L_0x00ea:
                r0 = 3
                int r0 = r11.digitCount(r13, r14, r0)
                if (r0 != 0) goto L_0x00f4
                if (r4 != 0) goto L_0x00f4
                goto L_0x011b
            L_0x00f4:
                if (r0 >= r1) goto L_0x00f8
                int r12 = ~r14
                return r12
            L_0x00f8:
                int r4 = r14 + 1
                char r14 = r13.charAt(r14)
                int r14 = r14 - r8
                int r14 = r14 * 100
                int r5 = r5 + r14
                if (r0 <= r1) goto L_0x011a
                int r14 = r4 + 1
                char r1 = r13.charAt(r4)
                int r1 = r1 - r8
                int r1 = r1 * 10
                int r5 = r5 + r1
                if (r0 <= r3) goto L_0x011b
                int r0 = r14 + 1
                char r13 = r13.charAt(r14)
                int r13 = r13 - r8
                int r5 = r5 + r13
                r14 = r0
                goto L_0x011b
            L_0x011a:
                r14 = r4
            L_0x011b:
                if (r2 == 0) goto L_0x011e
                int r5 = -r5
            L_0x011e:
                java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
                r12.setOffset((java.lang.Integer) r13)
                return r14
            L_0x0126:
                int r12 = ~r14
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.TimeZoneOffset.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.CharSequence, int):int");
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            String str;
            if (dateTimeZone != null) {
                if (i2 != 0 || (str = this.iZeroOffsetPrintText) == null) {
                    if (i2 >= 0) {
                        appendable.append('+');
                    } else {
                        appendable.append('-');
                        i2 = -i2;
                    }
                    int i3 = i2 / DateTimeConstants.MILLIS_PER_HOUR;
                    FormatUtils.appendPaddedInteger(appendable, i3, 2);
                    if (this.iMaxFields != 1) {
                        int i4 = i2 - (i3 * DateTimeConstants.MILLIS_PER_HOUR);
                        if (i4 != 0 || this.iMinFields > 1) {
                            int i5 = i4 / DateTimeConstants.MILLIS_PER_MINUTE;
                            if (this.iShowSeparators) {
                                appendable.append(':');
                            }
                            FormatUtils.appendPaddedInteger(appendable, i5, 2);
                            if (this.iMaxFields != 2) {
                                int i6 = i4 - (i5 * DateTimeConstants.MILLIS_PER_MINUTE);
                                if (i6 != 0 || this.iMinFields > 2) {
                                    int i7 = i6 / 1000;
                                    if (this.iShowSeparators) {
                                        appendable.append(':');
                                    }
                                    FormatUtils.appendPaddedInteger(appendable, i7, 2);
                                    if (this.iMaxFields != 3) {
                                        int i8 = i6 - (i7 * 1000);
                                        if (i8 != 0 || this.iMinFields > 3) {
                                            if (this.iShowSeparators) {
                                                appendable.append('.');
                                            }
                                            FormatUtils.appendPaddedInteger(appendable, i8, 3);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                appendable.append(str);
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }
    }

    private DateTimeFormatterBuilder append0(Object obj) {
        this.iFormatter = null;
        this.iElementPairs.add(obj);
        this.iElementPairs.add(obj);
        return this;
    }

    static void appendUnknownString(Appendable appendable, int i2) throws IOException {
        while (true) {
            i2--;
            if (i2 >= 0) {
                appendable.append(65533);
            } else {
                return;
            }
        }
    }

    private void checkParser(DateTimeParser dateTimeParser) {
        if (dateTimeParser == null) {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    private void checkPrinter(DateTimePrinter dateTimePrinter) {
        if (dateTimePrinter == null) {
            throw new IllegalArgumentException("No printer supplied");
        }
    }

    static boolean csStartsWith(CharSequence charSequence, int i2, String str) {
        int length = str.length();
        if (charSequence.length() - i2 < length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (charSequence.charAt(i2 + i3) != str.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    static boolean csStartsWithIgnoreCase(CharSequence charSequence, int i2, String str) {
        char upperCase;
        char upperCase2;
        int length = str.length();
        if (charSequence.length() - i2 < length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = charSequence.charAt(i2 + i3);
            char charAt2 = str.charAt(i3);
            if (charAt != charAt2 && (upperCase = Character.toUpperCase(charAt)) != (upperCase2 = Character.toUpperCase(charAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
        }
        return true;
    }

    private Object getFormatter() {
        Object obj = this.iFormatter;
        if (obj == null) {
            if (this.iElementPairs.size() == 2) {
                Object obj2 = this.iElementPairs.get(0);
                Object obj3 = this.iElementPairs.get(1);
                if (obj2 == null) {
                    obj = obj3;
                } else if (obj2 == obj3 || obj3 == null) {
                    obj = obj2;
                }
            }
            if (obj == null) {
                obj = new Composite(this.iElementPairs);
            }
            this.iFormatter = obj;
        }
        return obj;
    }

    private boolean isFormatter(Object obj) {
        return isPrinter(obj) || isParser(obj);
    }

    private boolean isParser(Object obj) {
        if (!(obj instanceof InternalParser)) {
            return false;
        }
        if (obj instanceof Composite) {
            return ((Composite) obj).isParser();
        }
        return true;
    }

    private boolean isPrinter(Object obj) {
        if (!(obj instanceof InternalPrinter)) {
            return false;
        }
        if (obj instanceof Composite) {
            return ((Composite) obj).isPrinter();
        }
        return true;
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter != null) {
            return append0(dateTimeFormatter.getPrinter0(), dateTimeFormatter.getParser0());
        }
        throw new IllegalArgumentException("No formatter supplied");
    }

    public DateTimeFormatterBuilder appendCenturyOfEra(int i2, int i3) {
        return appendSignedDecimal(DateTimeFieldType.centuryOfEra(), i2, i3);
    }

    public DateTimeFormatterBuilder appendClockhourOfDay(int i2) {
        return appendDecimal(DateTimeFieldType.clockhourOfDay(), i2, 2);
    }

    public DateTimeFormatterBuilder appendClockhourOfHalfday(int i2) {
        return appendDecimal(DateTimeFieldType.clockhourOfHalfday(), i2, 2);
    }

    public DateTimeFormatterBuilder appendDayOfMonth(int i2) {
        return appendDecimal(DateTimeFieldType.dayOfMonth(), i2, 2);
    }

    public DateTimeFormatterBuilder appendDayOfWeek(int i2) {
        return appendDecimal(DateTimeFieldType.dayOfWeek(), i2, 1);
    }

    public DateTimeFormatterBuilder appendDayOfWeekShortText() {
        return appendShortText(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder appendDayOfWeekText() {
        return appendText(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder appendDayOfYear(int i2) {
        return appendDecimal(DateTimeFieldType.dayOfYear(), i2, 3);
    }

    public DateTimeFormatterBuilder appendDecimal(DateTimeFieldType dateTimeFieldType, int i2, int i3) {
        if (dateTimeFieldType != null) {
            if (i3 < i2) {
                i3 = i2;
            }
            if (i2 < 0 || i3 <= 0) {
                throw new IllegalArgumentException();
            } else if (i2 <= 1) {
                return append0(new UnpaddedNumber(dateTimeFieldType, i3, false));
            } else {
                return append0(new PaddedNumber(dateTimeFieldType, i3, false, i2));
            }
        } else {
            throw new IllegalArgumentException("Field type must not be null");
        }
    }

    public DateTimeFormatterBuilder appendEraText() {
        return appendText(DateTimeFieldType.era());
    }

    public DateTimeFormatterBuilder appendFixedDecimal(DateTimeFieldType dateTimeFieldType, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        } else if (i2 > 0) {
            return append0(new FixedNumber(dateTimeFieldType, i2, false));
        } else {
            throw new IllegalArgumentException("Illegal number of digits: " + i2);
        }
    }

    public DateTimeFormatterBuilder appendFixedSignedDecimal(DateTimeFieldType dateTimeFieldType, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        } else if (i2 > 0) {
            return append0(new FixedNumber(dateTimeFieldType, i2, true));
        } else {
            throw new IllegalArgumentException("Illegal number of digits: " + i2);
        }
    }

    public DateTimeFormatterBuilder appendFraction(DateTimeFieldType dateTimeFieldType, int i2, int i3) {
        if (dateTimeFieldType != null) {
            if (i3 < i2) {
                i3 = i2;
            }
            if (i2 >= 0 && i3 > 0) {
                return append0(new Fraction(dateTimeFieldType, i2, i3));
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder appendFractionOfDay(int i2, int i3) {
        return appendFraction(DateTimeFieldType.dayOfYear(), i2, i3);
    }

    public DateTimeFormatterBuilder appendFractionOfHour(int i2, int i3) {
        return appendFraction(DateTimeFieldType.hourOfDay(), i2, i3);
    }

    public DateTimeFormatterBuilder appendFractionOfMinute(int i2, int i3) {
        return appendFraction(DateTimeFieldType.minuteOfDay(), i2, i3);
    }

    public DateTimeFormatterBuilder appendFractionOfSecond(int i2, int i3) {
        return appendFraction(DateTimeFieldType.secondOfDay(), i2, i3);
    }

    public DateTimeFormatterBuilder appendHalfdayOfDayText() {
        return appendText(DateTimeFieldType.halfdayOfDay());
    }

    public DateTimeFormatterBuilder appendHourOfDay(int i2) {
        return appendDecimal(DateTimeFieldType.hourOfDay(), i2, 2);
    }

    public DateTimeFormatterBuilder appendHourOfHalfday(int i2) {
        return appendDecimal(DateTimeFieldType.hourOfHalfday(), i2, 2);
    }

    public DateTimeFormatterBuilder appendLiteral(char c2) {
        return append0(new CharacterLiteral(c2));
    }

    public DateTimeFormatterBuilder appendMillisOfDay(int i2) {
        return appendDecimal(DateTimeFieldType.millisOfDay(), i2, 8);
    }

    public DateTimeFormatterBuilder appendMillisOfSecond(int i2) {
        return appendDecimal(DateTimeFieldType.millisOfSecond(), i2, 3);
    }

    public DateTimeFormatterBuilder appendMinuteOfDay(int i2) {
        return appendDecimal(DateTimeFieldType.minuteOfDay(), i2, 4);
    }

    public DateTimeFormatterBuilder appendMinuteOfHour(int i2) {
        return appendDecimal(DateTimeFieldType.minuteOfHour(), i2, 2);
    }

    public DateTimeFormatterBuilder appendMonthOfYear(int i2) {
        return appendDecimal(DateTimeFieldType.monthOfYear(), i2, 2);
    }

    public DateTimeFormatterBuilder appendMonthOfYearShortText() {
        return appendShortText(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder appendMonthOfYearText() {
        return appendText(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder appendOptional(DateTimeParser dateTimeParser) {
        checkParser(dateTimeParser);
        return append0((InternalPrinter) null, new MatchingParser(new InternalParser[]{DateTimeParserInternalParser.of(dateTimeParser), null}));
    }

    public DateTimeFormatterBuilder appendPattern(String str) {
        DateTimeFormat.appendPatternTo(this, str);
        return this;
    }

    public DateTimeFormatterBuilder appendSecondOfDay(int i2) {
        return appendDecimal(DateTimeFieldType.secondOfDay(), i2, 5);
    }

    public DateTimeFormatterBuilder appendSecondOfMinute(int i2) {
        return appendDecimal(DateTimeFieldType.secondOfMinute(), i2, 2);
    }

    public DateTimeFormatterBuilder appendShortText(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return append0(new TextField(dateTimeFieldType, true));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder appendSignedDecimal(DateTimeFieldType dateTimeFieldType, int i2, int i3) {
        if (dateTimeFieldType != null) {
            if (i3 < i2) {
                i3 = i2;
            }
            if (i2 < 0 || i3 <= 0) {
                throw new IllegalArgumentException();
            } else if (i2 <= 1) {
                return append0(new UnpaddedNumber(dateTimeFieldType, i3, true));
            } else {
                return append0(new PaddedNumber(dateTimeFieldType, i3, true, i2));
            }
        } else {
            throw new IllegalArgumentException("Field type must not be null");
        }
    }

    public DateTimeFormatterBuilder appendText(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return append0(new TextField(dateTimeFieldType, false));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder appendTimeZoneId() {
        TimeZoneId timeZoneId = TimeZoneId.INSTANCE;
        return append0(timeZoneId, timeZoneId);
    }

    public DateTimeFormatterBuilder appendTimeZoneName() {
        return append0(new TimeZoneName(0, (Map<String, DateTimeZone>) null), (InternalParser) null);
    }

    public DateTimeFormatterBuilder appendTimeZoneOffset(String str, boolean z2, int i2, int i3) {
        return append0(new TimeZoneOffset(str, str, z2, i2, i3));
    }

    public DateTimeFormatterBuilder appendTimeZoneShortName() {
        return append0(new TimeZoneName(1, (Map<String, DateTimeZone>) null), (InternalParser) null);
    }

    public DateTimeFormatterBuilder appendTwoDigitWeekyear(int i2) {
        return appendTwoDigitWeekyear(i2, false);
    }

    public DateTimeFormatterBuilder appendTwoDigitYear(int i2) {
        return appendTwoDigitYear(i2, false);
    }

    public DateTimeFormatterBuilder appendWeekOfWeekyear(int i2) {
        return appendDecimal(DateTimeFieldType.weekOfWeekyear(), i2, 2);
    }

    public DateTimeFormatterBuilder appendWeekyear(int i2, int i3) {
        return appendSignedDecimal(DateTimeFieldType.weekyear(), i2, i3);
    }

    public DateTimeFormatterBuilder appendYear(int i2, int i3) {
        return appendSignedDecimal(DateTimeFieldType.year(), i2, i3);
    }

    public DateTimeFormatterBuilder appendYearOfCentury(int i2, int i3) {
        return appendDecimal(DateTimeFieldType.yearOfCentury(), i2, i3);
    }

    public DateTimeFormatterBuilder appendYearOfEra(int i2, int i3) {
        return appendDecimal(DateTimeFieldType.yearOfEra(), i2, i3);
    }

    public boolean canBuildFormatter() {
        return isFormatter(getFormatter());
    }

    public boolean canBuildParser() {
        return isParser(getFormatter());
    }

    public boolean canBuildPrinter() {
        return isPrinter(getFormatter());
    }

    public void clear() {
        this.iFormatter = null;
        this.iElementPairs.clear();
    }

    public DateTimeFormatter toFormatter() {
        InternalPrinter internalPrinter;
        Object formatter = getFormatter();
        InternalParser internalParser = null;
        if (isPrinter(formatter)) {
            internalPrinter = (InternalPrinter) formatter;
        } else {
            internalPrinter = null;
        }
        if (isParser(formatter)) {
            internalParser = (InternalParser) formatter;
        }
        if (internalPrinter != null || internalParser != null) {
            return new DateTimeFormatter(internalPrinter, internalParser);
        }
        throw new UnsupportedOperationException("Both printing and parsing not supported");
    }

    public DateTimeParser toParser() {
        Object formatter = getFormatter();
        if (isParser(formatter)) {
            return InternalParserDateTimeParser.of((InternalParser) formatter);
        }
        throw new UnsupportedOperationException("Parsing is not supported");
    }

    public DateTimePrinter toPrinter() {
        Object formatter = getFormatter();
        if (isPrinter(formatter)) {
            return InternalPrinterDateTimePrinter.of((InternalPrinter) formatter);
        }
        throw new UnsupportedOperationException("Printing is not supported");
    }

    static class TextField implements InternalPrinter, InternalParser {
        private static Map<Locale, Map<DateTimeFieldType, Object[]>> cParseCache = new ConcurrentHashMap();
        private final DateTimeFieldType iFieldType;
        private final boolean iShort;

        TextField(DateTimeFieldType dateTimeFieldType, boolean z2) {
            this.iFieldType = dateTimeFieldType;
            this.iShort = z2;
        }

        private String print(long j2, Chronology chronology, Locale locale) {
            DateTimeField field = this.iFieldType.getField(chronology);
            if (this.iShort) {
                return field.getAsShortText(j2, locale);
            }
            return field.getAsText(j2, locale);
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int estimatePrintedLength() {
            return this.iShort ? 6 : 20;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            int i3;
            Map map;
            Locale locale = dateTimeParserBucket.getLocale();
            Map map2 = cParseCache.get(locale);
            if (map2 == null) {
                map2 = new ConcurrentHashMap();
                cParseCache.put(locale, map2);
            }
            Object[] objArr = (Object[]) map2.get(this.iFieldType);
            if (objArr == null) {
                map = new ConcurrentHashMap(32);
                MutableDateTime.Property property = new MutableDateTime(0, DateTimeZone.UTC).property(this.iFieldType);
                int minimumValueOverall = property.getMinimumValueOverall();
                int maximumValueOverall = property.getMaximumValueOverall();
                if (maximumValueOverall - minimumValueOverall > 32) {
                    return ~i2;
                }
                i3 = property.getMaximumTextLength(locale);
                while (minimumValueOverall <= maximumValueOverall) {
                    property.set(minimumValueOverall);
                    String asShortText = property.getAsShortText(locale);
                    Boolean bool = Boolean.TRUE;
                    map.put(asShortText, bool);
                    map.put(property.getAsShortText(locale).toLowerCase(locale), bool);
                    map.put(property.getAsShortText(locale).toUpperCase(locale), bool);
                    map.put(property.getAsText(locale), bool);
                    map.put(property.getAsText(locale).toLowerCase(locale), bool);
                    map.put(property.getAsText(locale).toUpperCase(locale), bool);
                    minimumValueOverall++;
                }
                if ("en".equals(locale.getLanguage()) && this.iFieldType == DateTimeFieldType.era()) {
                    Boolean bool2 = Boolean.TRUE;
                    map.put("BCE", bool2);
                    map.put("bce", bool2);
                    map.put("CE", bool2);
                    map.put("ce", bool2);
                    i3 = 3;
                }
                map2.put(this.iFieldType, new Object[]{map, Integer.valueOf(i3)});
            } else {
                i3 = ((Integer) objArr[1]).intValue();
                map = (Map) objArr[0];
            }
            for (int min = Math.min(charSequence.length(), i3 + i2); min > i2; min--) {
                String obj = charSequence.subSequence(i2, min).toString();
                if (map.containsKey(obj)) {
                    dateTimeParserBucket.saveField(this.iFieldType, obj, locale);
                    return min;
                }
            }
            return ~i2;
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                appendable.append(print(j2, chronology, locale));
            } catch (RuntimeException unused) {
                appendable.append(65533);
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            try {
                appendable.append(print(readablePartial, locale));
            } catch (RuntimeException unused) {
                appendable.append(65533);
            }
        }

        private String print(ReadablePartial readablePartial, Locale locale) {
            if (!readablePartial.isSupported(this.iFieldType)) {
                return "�";
            }
            DateTimeField field = this.iFieldType.getField(readablePartial.getChronology());
            if (this.iShort) {
                return field.getAsShortText(readablePartial, locale);
            }
            return field.getAsText(readablePartial, locale);
        }
    }

    static class TwoDigitYear implements InternalPrinter, InternalParser {
        private final boolean iLenientParse;
        private final int iPivot;
        private final DateTimeFieldType iType;

        TwoDigitYear(DateTimeFieldType dateTimeFieldType, int i2, boolean z2) {
            this.iType = dateTimeFieldType;
            this.iPivot = i2;
            this.iLenientParse = z2;
        }

        private int getTwoDigitYear(long j2, Chronology chronology) {
            try {
                int i2 = this.iType.getField(chronology).get(j2);
                if (i2 < 0) {
                    i2 = -i2;
                }
                return i2 % 100;
            } catch (RuntimeException unused) {
                return -1;
            }
        }

        public int estimateParsedLength() {
            return this.iLenientParse ? 4 : 2;
        }

        public int estimatePrintedLength() {
            return 2;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int length = charSequence.length() - i2;
            int i7 = 0;
            if (this.iLenientParse) {
                int i8 = 0;
                boolean z2 = false;
                boolean z3 = false;
                while (i8 < length) {
                    char charAt = charSequence.charAt(i2 + i8);
                    if (i8 != 0 || (charAt != '-' && charAt != '+')) {
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i8++;
                    } else {
                        if (charAt == '-') {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            i8++;
                        } else {
                            i2++;
                            length--;
                        }
                        z2 = true;
                    }
                }
                if (i8 == 0) {
                    return ~i2;
                }
                if (z2 || i8 != 2) {
                    if (i8 >= 9) {
                        i5 = i8 + i2;
                        i4 = Integer.parseInt(charSequence.subSequence(i2, i5).toString());
                    } else {
                        if (z3) {
                            i6 = i2 + 1;
                        } else {
                            i6 = i2;
                        }
                        int i9 = i6 + 1;
                        try {
                            int charAt2 = charSequence.charAt(i6) - '0';
                            i5 = i8 + i2;
                            while (i9 < i5) {
                                i9++;
                                charAt2 = (((charAt2 << 3) + (charAt2 << 1)) + charSequence.charAt(i9)) - 48;
                            }
                            if (z3) {
                                i4 = -charAt2;
                            } else {
                                i4 = charAt2;
                            }
                        } catch (StringIndexOutOfBoundsException unused) {
                            return ~i2;
                        }
                    }
                    dateTimeParserBucket.saveField(this.iType, i4);
                    return i5;
                }
            } else if (Math.min(2, length) < 2) {
                return ~i2;
            }
            char charAt3 = charSequence.charAt(i2);
            if (charAt3 < '0' || charAt3 > '9') {
                return ~i2;
            }
            int i10 = charAt3 - '0';
            char charAt4 = charSequence.charAt(i2 + 1);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i2;
            }
            int i11 = (((i10 << 3) + (i10 << 1)) + charAt4) - 48;
            int i12 = this.iPivot;
            if (dateTimeParserBucket.getPivotYear() != null) {
                i12 = dateTimeParserBucket.getPivotYear().intValue();
            }
            int i13 = i12 - 50;
            if (i13 >= 0) {
                i3 = i13 % 100;
            } else {
                i3 = ((i13 + 1) % 100) + 99;
            }
            if (i11 < i3) {
                i7 = 100;
            }
            dateTimeParserBucket.saveField(this.iType, i11 + ((i13 + i7) - i3));
            return i2 + 2;
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            int twoDigitYear = getTwoDigitYear(j2, chronology);
            if (twoDigitYear < 0) {
                appendable.append(65533);
                appendable.append(65533);
                return;
            }
            FormatUtils.appendPaddedInteger(appendable, twoDigitYear, 2);
        }

        private int getTwoDigitYear(ReadablePartial readablePartial) {
            if (!readablePartial.isSupported(this.iType)) {
                return -1;
            }
            try {
                int i2 = readablePartial.get(this.iType);
                if (i2 < 0) {
                    i2 = -i2;
                }
                return i2 % 100;
            } catch (RuntimeException unused) {
                return -1;
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            int twoDigitYear = getTwoDigitYear(readablePartial);
            if (twoDigitYear < 0) {
                appendable.append(65533);
                appendable.append(65533);
                return;
            }
            FormatUtils.appendPaddedInteger(appendable, twoDigitYear, 2);
        }
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        if (str != null) {
            int length = str.length();
            if (length == 0) {
                return this;
            }
            if (length != 1) {
                return append0(new StringLiteral(str));
            }
            return append0(new CharacterLiteral(str.charAt(0)));
        }
        throw new IllegalArgumentException("Literal must not be null");
    }

    public DateTimeFormatterBuilder appendTimeZoneName(Map<String, DateTimeZone> map) {
        TimeZoneName timeZoneName = new TimeZoneName(0, map);
        return append0(timeZoneName, timeZoneName);
    }

    public DateTimeFormatterBuilder appendTimeZoneOffset(String str, String str2, boolean z2, int i2, int i3) {
        return append0(new TimeZoneOffset(str, str2, z2, i2, i3));
    }

    public DateTimeFormatterBuilder appendTimeZoneShortName(Map<String, DateTimeZone> map) {
        TimeZoneName timeZoneName = new TimeZoneName(1, map);
        return append0(timeZoneName, timeZoneName);
    }

    public DateTimeFormatterBuilder appendTwoDigitWeekyear(int i2, boolean z2) {
        return append0(new TwoDigitYear(DateTimeFieldType.weekyear(), i2, z2));
    }

    public DateTimeFormatterBuilder appendTwoDigitYear(int i2, boolean z2) {
        return append0(new TwoDigitYear(DateTimeFieldType.year(), i2, z2));
    }

    static class PaddedNumber extends NumberFormatter {
        protected final int iMinPrintedDigits;

        protected PaddedNumber(DateTimeFieldType dateTimeFieldType, int i2, boolean z2, int i3) {
            super(dateTimeFieldType, i2, z2);
            this.iMinPrintedDigits = i3;
        }

        public int estimatePrintedLength() {
            return this.iMaxParsedDigits;
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.appendPaddedInteger(appendable, this.iFieldType.getField(chronology).get(j2), this.iMinPrintedDigits);
            } catch (RuntimeException unused) {
                DateTimeFormatterBuilder.appendUnknownString(appendable, this.iMinPrintedDigits);
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            if (readablePartial.isSupported(this.iFieldType)) {
                try {
                    FormatUtils.appendPaddedInteger(appendable, readablePartial.get(this.iFieldType), this.iMinPrintedDigits);
                } catch (RuntimeException unused) {
                    DateTimeFormatterBuilder.appendUnknownString(appendable, this.iMinPrintedDigits);
                }
            } else {
                DateTimeFormatterBuilder.appendUnknownString(appendable, this.iMinPrintedDigits);
            }
        }
    }

    static class UnpaddedNumber extends NumberFormatter {
        protected UnpaddedNumber(DateTimeFieldType dateTimeFieldType, int i2, boolean z2) {
            super(dateTimeFieldType, i2, z2);
        }

        public int estimatePrintedLength() {
            return this.iMaxParsedDigits;
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.appendUnpaddedInteger(appendable, this.iFieldType.getField(chronology).get(j2));
            } catch (RuntimeException unused) {
                appendable.append(65533);
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            if (readablePartial.isSupported(this.iFieldType)) {
                try {
                    FormatUtils.appendUnpaddedInteger(appendable, readablePartial.get(this.iFieldType));
                } catch (RuntimeException unused) {
                    appendable.append(65533);
                }
            } else {
                appendable.append(65533);
            }
        }
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter) {
        checkPrinter(dateTimePrinter);
        return append0(DateTimePrinterInternalPrinter.of(dateTimePrinter), (InternalParser) null);
    }

    private DateTimeFormatterBuilder append0(InternalPrinter internalPrinter, InternalParser internalParser) {
        this.iFormatter = null;
        this.iElementPairs.add(internalPrinter);
        this.iElementPairs.add(internalParser);
        return this;
    }

    static class Composite implements InternalPrinter, InternalParser {
        private final int iParsedLengthEstimate;
        private final InternalParser[] iParsers;
        private final int iPrintedLengthEstimate;
        private final InternalPrinter[] iPrinters;

        Composite(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            decompose(list, arrayList, arrayList2);
            if (arrayList.contains((Object) null) || arrayList.isEmpty()) {
                this.iPrinters = null;
                this.iPrintedLengthEstimate = 0;
            } else {
                int size = arrayList.size();
                this.iPrinters = new InternalPrinter[size];
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    InternalPrinter internalPrinter = (InternalPrinter) arrayList.get(i3);
                    i2 += internalPrinter.estimatePrintedLength();
                    this.iPrinters[i3] = internalPrinter;
                }
                this.iPrintedLengthEstimate = i2;
            }
            if (arrayList2.contains((Object) null) || arrayList2.isEmpty()) {
                this.iParsers = null;
                this.iParsedLengthEstimate = 0;
                return;
            }
            int size2 = arrayList2.size();
            this.iParsers = new InternalParser[size2];
            int i4 = 0;
            for (int i5 = 0; i5 < size2; i5++) {
                InternalParser internalParser = (InternalParser) arrayList2.get(i5);
                i4 += internalParser.estimateParsedLength();
                this.iParsers[i5] = internalParser;
            }
            this.iParsedLengthEstimate = i4;
        }

        private void addArrayToList(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object add : objArr) {
                    list.add(add);
                }
            }
        }

        private void decompose(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                Object obj = list.get(i2);
                if (obj instanceof Composite) {
                    addArrayToList(list2, ((Composite) obj).iPrinters);
                } else {
                    list2.add(obj);
                }
                Object obj2 = list.get(i2 + 1);
                if (obj2 instanceof Composite) {
                    addArrayToList(list3, ((Composite) obj2).iParsers);
                } else {
                    list3.add(obj2);
                }
            }
        }

        public int estimateParsedLength() {
            return this.iParsedLengthEstimate;
        }

        public int estimatePrintedLength() {
            return this.iPrintedLengthEstimate;
        }

        /* access modifiers changed from: package-private */
        public boolean isParser() {
            return this.iParsers != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isPrinter() {
            return this.iPrinters != null;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
            InternalParser[] internalParserArr = this.iParsers;
            if (internalParserArr != null) {
                int length = internalParserArr.length;
                for (int i3 = 0; i3 < length && i2 >= 0; i3++) {
                    i2 = internalParserArr[i3].parseInto(dateTimeParserBucket, charSequence, i2);
                }
                return i2;
            }
            throw new UnsupportedOperationException();
        }

        public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            InternalPrinter[] internalPrinterArr = this.iPrinters;
            if (internalPrinterArr != null) {
                Locale locale2 = locale == null ? Locale.getDefault() : locale;
                for (InternalPrinter printTo : internalPrinterArr) {
                    printTo.printTo(appendable, j2, chronology, i2, dateTimeZone, locale2);
                }
                return;
            }
            throw new UnsupportedOperationException();
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            InternalPrinter[] internalPrinterArr = this.iPrinters;
            if (internalPrinterArr != null) {
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                for (InternalPrinter printTo : internalPrinterArr) {
                    printTo.printTo(appendable, readablePartial, locale);
                }
                return;
            }
            throw new UnsupportedOperationException();
        }
    }

    public DateTimeFormatterBuilder append(DateTimeParser dateTimeParser) {
        checkParser(dateTimeParser);
        return append0((InternalPrinter) null, DateTimeParserInternalParser.of(dateTimeParser));
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter, DateTimeParser dateTimeParser) {
        checkPrinter(dateTimePrinter);
        checkParser(dateTimeParser);
        return append0(DateTimePrinterInternalPrinter.of(dateTimePrinter), DateTimeParserInternalParser.of(dateTimeParser));
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter, DateTimeParser[] dateTimeParserArr) {
        if (dateTimePrinter != null) {
            checkPrinter(dateTimePrinter);
        }
        if (dateTimeParserArr != null) {
            int length = dateTimeParserArr.length;
            int i2 = 0;
            if (length != 1) {
                InternalParser[] internalParserArr = new InternalParser[length];
                while (i2 < length - 1) {
                    InternalParser of = DateTimeParserInternalParser.of(dateTimeParserArr[i2]);
                    internalParserArr[i2] = of;
                    if (of != null) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException("Incomplete parser array");
                    }
                }
                internalParserArr[i2] = DateTimeParserInternalParser.of(dateTimeParserArr[i2]);
                return append0(DateTimePrinterInternalPrinter.of(dateTimePrinter), new MatchingParser(internalParserArr));
            } else if (dateTimeParserArr[0] != null) {
                return append0(DateTimePrinterInternalPrinter.of(dateTimePrinter), DateTimeParserInternalParser.of(dateTimeParserArr[0]));
            } else {
                throw new IllegalArgumentException("No parser supplied");
            }
        } else {
            throw new IllegalArgumentException("No parsers supplied");
        }
    }
}
