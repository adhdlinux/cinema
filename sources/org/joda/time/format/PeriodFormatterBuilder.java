package org.joda.time.format;

import com.facebook.common.time.Clock;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.joda.time.DurationFieldType;
import org.joda.time.PeriodType;
import org.joda.time.ReadWritablePeriod;
import org.joda.time.ReadablePeriod;

public class PeriodFormatterBuilder {
    private static final int DAYS = 3;
    private static final int HOURS = 4;
    private static final int MAX_FIELD = 9;
    private static final int MILLIS = 7;
    private static final int MINUTES = 5;
    private static final int MONTHS = 1;
    /* access modifiers changed from: private */
    public static final ConcurrentMap<String, Pattern> PATTERNS = new ConcurrentHashMap();
    private static final int PRINT_ZERO_ALWAYS = 4;
    private static final int PRINT_ZERO_IF_SUPPORTED = 3;
    private static final int PRINT_ZERO_NEVER = 5;
    private static final int PRINT_ZERO_RARELY_FIRST = 1;
    private static final int PRINT_ZERO_RARELY_LAST = 2;
    private static final int SECONDS = 6;
    private static final int SECONDS_MILLIS = 8;
    private static final int SECONDS_OPTIONAL_MILLIS = 9;
    private static final int WEEKS = 2;
    private static final int YEARS = 0;
    private List<Object> iElementPairs;
    private FieldFormatter[] iFieldFormatters;
    private int iMaxParsedDigits;
    private int iMinPrintedDigits;
    private boolean iNotParser;
    private boolean iNotPrinter;
    private PeriodFieldAffix iPrefix;
    private int iPrintZeroSetting;
    private boolean iRejectSignedValues;

    static abstract class IgnorableAffix implements PeriodFieldAffix {
        private volatile String[] iOtherAffixes;

        IgnorableAffix() {
        }

        public void finish(Set<PeriodFieldAffix> set) {
            if (this.iOtherAffixes == null) {
                int i2 = Integer.MAX_VALUE;
                String str = null;
                for (String str2 : getAffixes()) {
                    if (str2.length() < i2) {
                        i2 = str2.length();
                        str = str2;
                    }
                }
                HashSet hashSet = new HashSet();
                for (PeriodFieldAffix next : set) {
                    if (next != null) {
                        for (String str3 : next.getAffixes()) {
                            if (str3.length() > i2 || (str3.equalsIgnoreCase(str) && !str3.equals(str))) {
                                hashSet.add(str3);
                            }
                        }
                    }
                }
                this.iOtherAffixes = (String[]) hashSet.toArray(new String[hashSet.size()]);
            }
        }

        /* access modifiers changed from: protected */
        public boolean matchesOtherAffix(int i2, String str, int i3) {
            if (this.iOtherAffixes != null) {
                for (String str2 : this.iOtherAffixes) {
                    int length = str2.length();
                    if (i2 < length && str.regionMatches(true, i3, str2, 0, length)) {
                        return true;
                    }
                    if (i2 == length && str.regionMatches(false, i3, str2, 0, length)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class Literal implements PeriodPrinter, PeriodParser {
        static final Literal EMPTY = new Literal("");
        private final String iText;

        Literal(String str) {
            this.iText = str;
        }

        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            return this.iText.length();
        }

        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i2, Locale locale) {
            return 0;
        }

        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i2, Locale locale) {
            String str2 = this.iText;
            if (str.regionMatches(true, i2, str2, 0, str2.length())) {
                return i2 + this.iText.length();
            }
            return ~i2;
        }

        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            stringBuffer.append(this.iText);
        }

        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            writer.write(this.iText);
        }
    }

    interface PeriodFieldAffix {
        int calculatePrintedLength(int i2);

        void finish(Set<PeriodFieldAffix> set);

        String[] getAffixes();

        int parse(String str, int i2);

        void printTo(Writer writer, int i2) throws IOException;

        void printTo(StringBuffer stringBuffer, int i2);

        int scan(String str, int i2);
    }

    static class PluralAffix extends IgnorableAffix {
        private final String iPluralText;
        private final String iSingularText;

        PluralAffix(String str, String str2) {
            this.iSingularText = str;
            this.iPluralText = str2;
        }

        public int calculatePrintedLength(int i2) {
            return (i2 == 1 ? this.iSingularText : this.iPluralText).length();
        }

        public String[] getAffixes() {
            return new String[]{this.iSingularText, this.iPluralText};
        }

        public int parse(String str, int i2) {
            String str2;
            int length;
            String str3 = this.iPluralText;
            String str4 = this.iSingularText;
            if (str3.length() < str4.length()) {
                str2 = str3;
                str3 = str4;
            } else {
                str2 = str4;
            }
            if (!str.regionMatches(true, i2, str3, 0, str3.length()) || matchesOtherAffix(str3.length(), str, i2)) {
                if (!str.regionMatches(true, i2, str2, 0, str2.length()) || matchesOtherAffix(str2.length(), str, i2)) {
                    return ~i2;
                }
                length = str2.length();
            } else {
                length = str3.length();
            }
            return i2 + length;
        }

        public void printTo(StringBuffer stringBuffer, int i2) {
            stringBuffer.append(i2 == 1 ? this.iSingularText : this.iPluralText);
        }

        public int scan(String str, int i2) {
            String str2;
            String str3;
            String str4 = str;
            String str5 = this.iPluralText;
            String str6 = this.iSingularText;
            if (str5.length() < str6.length()) {
                str2 = str5;
                str3 = str6;
            } else {
                str3 = str5;
                str2 = str6;
            }
            int length = str3.length();
            int length2 = str2.length();
            int length3 = str.length();
            for (int i3 = i2; i3 < length3; i3++) {
                if (str.regionMatches(true, i3, str3, 0, length) && !matchesOtherAffix(str3.length(), str, i3)) {
                    return i3;
                }
                if (str.regionMatches(true, i3, str2, 0, length2) && !matchesOtherAffix(str2.length(), str, i3)) {
                    return i3;
                }
            }
            return ~i2;
        }

        public void printTo(Writer writer, int i2) throws IOException {
            writer.write(i2 == 1 ? this.iSingularText : this.iPluralText);
        }
    }

    static class RegExAffix extends IgnorableAffix {
        private static final Comparator<String> LENGTH_DESC_COMPARATOR = new Comparator<String>() {
            public int compare(String str, String str2) {
                return str2.length() - str.length();
            }
        };
        private final Pattern[] iPatterns;
        private final String[] iSuffixes;
        private final String[] iSuffixesSortedDescByLength;

        RegExAffix(String[] strArr, String[] strArr2) {
            this.iSuffixes = (String[]) strArr2.clone();
            this.iPatterns = new Pattern[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                Pattern pattern = (Pattern) PeriodFormatterBuilder.PATTERNS.get(strArr[i2]);
                if (pattern == null) {
                    pattern = Pattern.compile(strArr[i2]);
                    PeriodFormatterBuilder.PATTERNS.putIfAbsent(strArr[i2], pattern);
                }
                this.iPatterns[i2] = pattern;
            }
            String[] strArr3 = (String[]) this.iSuffixes.clone();
            this.iSuffixesSortedDescByLength = strArr3;
            Arrays.sort(strArr3, LENGTH_DESC_COMPARATOR);
        }

        private int selectSuffixIndex(int i2) {
            String valueOf = String.valueOf(i2);
            int i3 = 0;
            while (true) {
                Pattern[] patternArr = this.iPatterns;
                if (i3 >= patternArr.length) {
                    return patternArr.length - 1;
                }
                if (patternArr[i3].matcher(valueOf).matches()) {
                    return i3;
                }
                i3++;
            }
        }

        public int calculatePrintedLength(int i2) {
            return this.iSuffixes[selectSuffixIndex(i2)].length();
        }

        public String[] getAffixes() {
            return (String[]) this.iSuffixes.clone();
        }

        public int parse(String str, int i2) {
            for (String str2 : this.iSuffixesSortedDescByLength) {
                if (str.regionMatches(true, i2, str2, 0, str2.length()) && !matchesOtherAffix(str2.length(), str, i2)) {
                    return i2 + str2.length();
                }
            }
            return ~i2;
        }

        public void printTo(StringBuffer stringBuffer, int i2) {
            stringBuffer.append(this.iSuffixes[selectSuffixIndex(i2)]);
        }

        public int scan(String str, int i2) {
            int length = str.length();
            for (int i3 = i2; i3 < length; i3++) {
                for (String str2 : this.iSuffixesSortedDescByLength) {
                    if (str.regionMatches(true, i3, str2, 0, str2.length()) && !matchesOtherAffix(str2.length(), str, i3)) {
                        return i3;
                    }
                }
            }
            return ~i2;
        }

        public void printTo(Writer writer, int i2) throws IOException {
            writer.write(this.iSuffixes[selectSuffixIndex(i2)]);
        }
    }

    static class SimpleAffix extends IgnorableAffix {
        private final String iText;

        SimpleAffix(String str) {
            this.iText = str;
        }

        public int calculatePrintedLength(int i2) {
            return this.iText.length();
        }

        public String[] getAffixes() {
            return new String[]{this.iText};
        }

        public int parse(String str, int i2) {
            String str2 = this.iText;
            int length = str2.length();
            if (!str.regionMatches(true, i2, str2, 0, length) || matchesOtherAffix(length, str, i2)) {
                return ~i2;
            }
            return i2 + length;
        }

        public void printTo(StringBuffer stringBuffer, int i2) {
            stringBuffer.append(this.iText);
        }

        public int scan(String str, int i2) {
            String str2 = this.iText;
            int length = str2.length();
            int length2 = str.length();
            int i3 = i2;
            while (i3 < length2) {
                if (str.regionMatches(true, i3, str2, 0, length) && !matchesOtherAffix(length, str, i3)) {
                    return i3;
                }
                switch (str.charAt(i3)) {
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        i3++;
                }
                return ~i2;
            }
            return ~i2;
        }

        public void printTo(Writer writer, int i2) throws IOException {
            writer.write(this.iText);
        }
    }

    public PeriodFormatterBuilder() {
        clear();
    }

    private PeriodFormatterBuilder append0(PeriodPrinter periodPrinter, PeriodParser periodParser) {
        boolean z2;
        this.iElementPairs.add(periodPrinter);
        this.iElementPairs.add(periodParser);
        boolean z3 = this.iNotPrinter;
        boolean z4 = true;
        if (periodPrinter == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.iNotPrinter = z2 | z3;
        boolean z5 = this.iNotParser;
        if (periodParser != null) {
            z4 = false;
        }
        this.iNotParser = z5 | z4;
        return this;
    }

    private void appendField(int i2) {
        appendField(i2, this.iMinPrintedDigits);
    }

    private void clearPrefix() throws IllegalStateException {
        if (this.iPrefix == null) {
            this.iPrefix = null;
            return;
        }
        throw new IllegalStateException("Prefix not followed by field");
    }

    private static Object[] createComposite(List<Object> list) {
        int size = list.size();
        if (size == 0) {
            Literal literal = Literal.EMPTY;
            return new Object[]{literal, literal};
        } else if (size != 1) {
            Composite composite = new Composite(list);
            return new Object[]{composite, composite};
        } else {
            return new Object[]{list.get(0), list.get(1)};
        }
    }

    public PeriodFormatterBuilder append(PeriodFormatter periodFormatter) {
        if (periodFormatter != null) {
            clearPrefix();
            append0(periodFormatter.getPrinter(), periodFormatter.getParser());
            return this;
        }
        throw new IllegalArgumentException("No formatter supplied");
    }

    public PeriodFormatterBuilder appendDays() {
        appendField(3);
        return this;
    }

    public PeriodFormatterBuilder appendHours() {
        appendField(4);
        return this;
    }

    public PeriodFormatterBuilder appendLiteral(String str) {
        if (str != null) {
            clearPrefix();
            Literal literal = new Literal(str);
            append0(literal, literal);
            return this;
        }
        throw new IllegalArgumentException("Literal must not be null");
    }

    public PeriodFormatterBuilder appendMillis() {
        appendField(7);
        return this;
    }

    public PeriodFormatterBuilder appendMillis3Digit() {
        appendField(7, 3);
        return this;
    }

    public PeriodFormatterBuilder appendMinutes() {
        appendField(5);
        return this;
    }

    public PeriodFormatterBuilder appendMonths() {
        appendField(1);
        return this;
    }

    public PeriodFormatterBuilder appendPrefix(String str) {
        if (str != null) {
            return appendPrefix((PeriodFieldAffix) new SimpleAffix(str));
        }
        throw new IllegalArgumentException();
    }

    public PeriodFormatterBuilder appendSeconds() {
        appendField(6);
        return this;
    }

    public PeriodFormatterBuilder appendSecondsWithMillis() {
        appendField(8);
        return this;
    }

    public PeriodFormatterBuilder appendSecondsWithOptionalMillis() {
        appendField(9);
        return this;
    }

    public PeriodFormatterBuilder appendSeparator(String str) {
        return appendSeparator(str, str, (String[]) null, true, true);
    }

    public PeriodFormatterBuilder appendSeparatorIfFieldsAfter(String str) {
        return appendSeparator(str, str, (String[]) null, false, true);
    }

    public PeriodFormatterBuilder appendSeparatorIfFieldsBefore(String str) {
        return appendSeparator(str, str, (String[]) null, true, false);
    }

    public PeriodFormatterBuilder appendSuffix(String str) {
        if (str != null) {
            return appendSuffix((PeriodFieldAffix) new SimpleAffix(str));
        }
        throw new IllegalArgumentException();
    }

    public PeriodFormatterBuilder appendWeeks() {
        appendField(2);
        return this;
    }

    public PeriodFormatterBuilder appendYears() {
        appendField(0);
        return this;
    }

    public void clear() {
        this.iMinPrintedDigits = 1;
        this.iPrintZeroSetting = 2;
        this.iMaxParsedDigits = 10;
        this.iRejectSignedValues = false;
        this.iPrefix = null;
        List<Object> list = this.iElementPairs;
        if (list == null) {
            this.iElementPairs = new ArrayList();
        } else {
            list.clear();
        }
        this.iNotPrinter = false;
        this.iNotParser = false;
        this.iFieldFormatters = new FieldFormatter[10];
    }

    public PeriodFormatterBuilder maximumParsedDigits(int i2) {
        this.iMaxParsedDigits = i2;
        return this;
    }

    public PeriodFormatterBuilder minimumPrintedDigits(int i2) {
        this.iMinPrintedDigits = i2;
        return this;
    }

    public PeriodFormatterBuilder printZeroAlways() {
        this.iPrintZeroSetting = 4;
        return this;
    }

    public PeriodFormatterBuilder printZeroIfSupported() {
        this.iPrintZeroSetting = 3;
        return this;
    }

    public PeriodFormatterBuilder printZeroNever() {
        this.iPrintZeroSetting = 5;
        return this;
    }

    public PeriodFormatterBuilder printZeroRarelyFirst() {
        this.iPrintZeroSetting = 1;
        return this;
    }

    public PeriodFormatterBuilder printZeroRarelyLast() {
        this.iPrintZeroSetting = 2;
        return this;
    }

    public PeriodFormatterBuilder rejectSignedValues(boolean z2) {
        this.iRejectSignedValues = z2;
        return this;
    }

    public PeriodFormatter toFormatter() {
        PeriodFormatter formatter = toFormatter(this.iElementPairs, this.iNotPrinter, this.iNotParser);
        for (FieldFormatter fieldFormatter : this.iFieldFormatters) {
            if (fieldFormatter != null) {
                fieldFormatter.finish(this.iFieldFormatters);
            }
        }
        this.iFieldFormatters = (FieldFormatter[]) this.iFieldFormatters.clone();
        return formatter;
    }

    public PeriodParser toParser() {
        if (this.iNotParser) {
            return null;
        }
        return toFormatter().getParser();
    }

    public PeriodPrinter toPrinter() {
        if (this.iNotPrinter) {
            return null;
        }
        return toFormatter().getPrinter();
    }

    static class CompositeAffix extends IgnorableAffix {
        private final PeriodFieldAffix iLeft;
        private final String[] iLeftRightCombinations;
        private final PeriodFieldAffix iRight;

        CompositeAffix(PeriodFieldAffix periodFieldAffix, PeriodFieldAffix periodFieldAffix2) {
            this.iLeft = periodFieldAffix;
            this.iRight = periodFieldAffix2;
            HashSet hashSet = new HashSet();
            for (String str : periodFieldAffix.getAffixes()) {
                for (String str2 : this.iRight.getAffixes()) {
                    hashSet.add(str + str2);
                }
            }
            this.iLeftRightCombinations = (String[]) hashSet.toArray(new String[hashSet.size()]);
        }

        public int calculatePrintedLength(int i2) {
            return this.iLeft.calculatePrintedLength(i2) + this.iRight.calculatePrintedLength(i2);
        }

        public String[] getAffixes() {
            return (String[]) this.iLeftRightCombinations.clone();
        }

        public int parse(String str, int i2) {
            int parse = this.iLeft.parse(str, i2);
            if (parse < 0 || (parse = this.iRight.parse(str, parse)) < 0 || !matchesOtherAffix(parse(str, parse) - parse, str, i2)) {
                return parse;
            }
            return ~i2;
        }

        public void printTo(StringBuffer stringBuffer, int i2) {
            this.iLeft.printTo(stringBuffer, i2);
            this.iRight.printTo(stringBuffer, i2);
        }

        public int scan(String str, int i2) {
            int scan;
            int scan2 = this.iLeft.scan(str, i2);
            if (scan2 < 0 || ((scan = this.iRight.scan(str, this.iLeft.parse(str, scan2))) >= 0 && matchesOtherAffix(this.iRight.parse(str, scan) - scan2, str, i2))) {
                return ~i2;
            }
            if (scan2 > 0) {
                return scan2;
            }
            return scan;
        }

        public void printTo(Writer writer, int i2) throws IOException {
            this.iLeft.printTo(writer, i2);
            this.iRight.printTo(writer, i2);
        }
    }

    private void appendField(int i2, int i3) {
        FieldFormatter fieldFormatter = new FieldFormatter(i3, this.iPrintZeroSetting, this.iMaxParsedDigits, this.iRejectSignedValues, i2, this.iFieldFormatters, this.iPrefix, (PeriodFieldAffix) null);
        append0(fieldFormatter, fieldFormatter);
        this.iFieldFormatters[i2] = fieldFormatter;
        this.iPrefix = null;
    }

    public PeriodFormatterBuilder appendSeparator(String str, String str2) {
        return appendSeparator(str, str2, (String[]) null, true, true);
    }

    static class Composite implements PeriodPrinter, PeriodParser {
        private final PeriodParser[] iParsers;
        private final PeriodPrinter[] iPrinters;

        Composite(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            decompose(list, arrayList, arrayList2);
            if (arrayList.size() <= 0) {
                this.iPrinters = null;
            } else {
                this.iPrinters = (PeriodPrinter[]) arrayList.toArray(new PeriodPrinter[arrayList.size()]);
            }
            if (arrayList2.size() <= 0) {
                this.iParsers = null;
            } else {
                this.iParsers = (PeriodParser[]) arrayList2.toArray(new PeriodParser[arrayList2.size()]);
            }
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
                if (obj instanceof PeriodPrinter) {
                    if (obj instanceof Composite) {
                        addArrayToList(list2, ((Composite) obj).iPrinters);
                    } else {
                        list2.add(obj);
                    }
                }
                Object obj2 = list.get(i2 + 1);
                if (obj2 instanceof PeriodParser) {
                    if (obj2 instanceof Composite) {
                        addArrayToList(list3, ((Composite) obj2).iParsers);
                    } else {
                        list3.add(obj2);
                    }
                }
            }
        }

        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            PeriodPrinter[] periodPrinterArr = this.iPrinters;
            int length = periodPrinterArr.length;
            int i2 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i2;
                }
                i2 += periodPrinterArr[length].calculatePrintedLength(readablePeriod, locale);
            }
        }

        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i2, Locale locale) {
            PeriodPrinter[] periodPrinterArr = this.iPrinters;
            int length = periodPrinterArr.length;
            int i3 = 0;
            while (i3 < i2) {
                length--;
                if (length < 0) {
                    break;
                }
                i3 += periodPrinterArr[length].countFieldsToPrint(readablePeriod, Integer.MAX_VALUE, locale);
            }
            return i3;
        }

        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i2, Locale locale) {
            PeriodParser[] periodParserArr = this.iParsers;
            if (periodParserArr != null) {
                int length = periodParserArr.length;
                for (int i3 = 0; i3 < length && i2 >= 0; i3++) {
                    i2 = periodParserArr[i3].parseInto(readWritablePeriod, str, i2, locale);
                }
                return i2;
            }
            throw new UnsupportedOperationException();
        }

        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            for (PeriodPrinter printTo : this.iPrinters) {
                printTo.printTo(stringBuffer, readablePeriod, locale);
            }
        }

        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            for (PeriodPrinter printTo : this.iPrinters) {
                printTo.printTo(writer, readablePeriod, locale);
            }
        }
    }

    public PeriodFormatterBuilder appendPrefix(String str, String str2) {
        if (str != null && str2 != null) {
            return appendPrefix((PeriodFieldAffix) new PluralAffix(str, str2));
        }
        throw new IllegalArgumentException();
    }

    public PeriodFormatterBuilder appendSeparator(String str, String str2, String[] strArr) {
        return appendSeparator(str, str2, strArr, true, true);
    }

    public PeriodFormatterBuilder appendSuffix(String str, String str2) {
        if (str != null && str2 != null) {
            return appendSuffix((PeriodFieldAffix) new PluralAffix(str, str2));
        }
        throw new IllegalArgumentException();
    }

    private PeriodFormatterBuilder appendSeparator(String str, String str2, String[] strArr, boolean z2, boolean z3) {
        Separator separator;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        clearPrefix();
        List<Object> list = this.iElementPairs;
        if (list.size() == 0) {
            if (z3 && !z2) {
                Literal literal = Literal.EMPTY;
                Separator separator2 = new Separator(str, str2, strArr, literal, literal, z2, z3);
                append0(separator2, separator2);
            }
            return this;
        }
        int size = list.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                separator = null;
                break;
            } else if (list.get(i2) instanceof Separator) {
                separator = (Separator) list.get(i2);
                list = list.subList(i2 + 1, list.size());
                break;
            } else {
                size = i2 - 1;
            }
        }
        List<Object> list2 = list;
        if (separator == null || list2.size() != 0) {
            Object[] createComposite = createComposite(list2);
            list2.clear();
            Separator separator3 = new Separator(str, str2, strArr, (PeriodPrinter) createComposite[0], (PeriodParser) createComposite[1], z2, z3);
            list2.add(separator3);
            list2.add(separator3);
            return this;
        }
        throw new IllegalStateException("Cannot have two adjacent separators");
    }

    public PeriodFormatterBuilder append(PeriodPrinter periodPrinter, PeriodParser periodParser) {
        if (periodPrinter == null && periodParser == null) {
            throw new IllegalArgumentException("No printer or parser supplied");
        }
        clearPrefix();
        append0(periodPrinter, periodParser);
        return this;
    }

    private static PeriodFormatter toFormatter(List<Object> list, boolean z2, boolean z3) {
        if (!z2 || !z3) {
            int size = list.size();
            if (size >= 2 && (list.get(0) instanceof Separator)) {
                Separator separator = (Separator) list.get(0);
                if (separator.iAfterParser == null && separator.iAfterPrinter == null) {
                    PeriodFormatter formatter = toFormatter(list.subList(2, size), z2, z3);
                    Separator finish = separator.finish(formatter.getPrinter(), formatter.getParser());
                    return new PeriodFormatter(finish, finish);
                }
            }
            Object[] createComposite = createComposite(list);
            if (z2) {
                return new PeriodFormatter((PeriodPrinter) null, (PeriodParser) createComposite[1]);
            }
            if (z3) {
                return new PeriodFormatter((PeriodPrinter) createComposite[0], (PeriodParser) null);
            }
            return new PeriodFormatter((PeriodPrinter) createComposite[0], (PeriodParser) createComposite[1]);
        }
        throw new IllegalStateException("Builder has created neither a printer nor a parser");
    }

    public PeriodFormatterBuilder appendPrefix(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length >= 1 && strArr.length == strArr2.length) {
            return appendPrefix((PeriodFieldAffix) new RegExAffix(strArr, strArr2));
        }
        throw new IllegalArgumentException();
    }

    public PeriodFormatterBuilder appendSuffix(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length >= 1 && strArr.length == strArr2.length) {
            return appendSuffix((PeriodFieldAffix) new RegExAffix(strArr, strArr2));
        }
        throw new IllegalArgumentException();
    }

    private PeriodFormatterBuilder appendPrefix(PeriodFieldAffix periodFieldAffix) {
        if (periodFieldAffix != null) {
            PeriodFieldAffix periodFieldAffix2 = this.iPrefix;
            if (periodFieldAffix2 != null) {
                periodFieldAffix = new CompositeAffix(periodFieldAffix2, periodFieldAffix);
            }
            this.iPrefix = periodFieldAffix;
            return this;
        }
        throw new IllegalArgumentException();
    }

    private PeriodFormatterBuilder appendSuffix(PeriodFieldAffix periodFieldAffix) {
        Object obj;
        Object obj2;
        if (this.iElementPairs.size() > 0) {
            List<Object> list = this.iElementPairs;
            obj2 = list.get(list.size() - 2);
            List<Object> list2 = this.iElementPairs;
            obj = list2.get(list2.size() - 1);
        } else {
            obj2 = null;
            obj = null;
        }
        if (obj2 == null || obj == null || obj2 != obj || !(obj2 instanceof FieldFormatter)) {
            throw new IllegalStateException("No field to apply suffix to");
        }
        clearPrefix();
        FieldFormatter fieldFormatter = new FieldFormatter((FieldFormatter) obj2, periodFieldAffix);
        List<Object> list3 = this.iElementPairs;
        list3.set(list3.size() - 2, fieldFormatter);
        List<Object> list4 = this.iElementPairs;
        list4.set(list4.size() - 1, fieldFormatter);
        this.iFieldFormatters[fieldFormatter.getFieldType()] = fieldFormatter;
        return this;
    }

    static class FieldFormatter implements PeriodPrinter, PeriodParser {
        private final FieldFormatter[] iFieldFormatters;
        private final int iFieldType;
        private final int iMaxParsedDigits;
        private final int iMinPrintedDigits;
        private final PeriodFieldAffix iPrefix;
        private final int iPrintZeroSetting;
        private final boolean iRejectSignedValues;
        private final PeriodFieldAffix iSuffix;

        FieldFormatter(int i2, int i3, int i4, boolean z2, int i5, FieldFormatter[] fieldFormatterArr, PeriodFieldAffix periodFieldAffix, PeriodFieldAffix periodFieldAffix2) {
            this.iMinPrintedDigits = i2;
            this.iPrintZeroSetting = i3;
            this.iMaxParsedDigits = i4;
            this.iRejectSignedValues = z2;
            this.iFieldType = i5;
            this.iFieldFormatters = fieldFormatterArr;
            this.iPrefix = periodFieldAffix;
            this.iSuffix = periodFieldAffix2;
        }

        private int parseInt(String str, int i2, int i3) {
            if (i3 >= 10) {
                return Integer.parseInt(str.substring(i2, i3 + i2));
            }
            boolean z2 = false;
            if (i3 <= 0) {
                return 0;
            }
            int i4 = i2 + 1;
            char charAt = str.charAt(i2);
            int i5 = i3 - 1;
            if (charAt == '-') {
                i5--;
                if (i5 < 0) {
                    return 0;
                }
                char charAt2 = str.charAt(i4);
                i4++;
                charAt = charAt2;
                z2 = true;
            }
            int i6 = charAt - '0';
            while (true) {
                int i7 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                i4++;
                i6 = (((i6 << 3) + (i6 << 1)) + str.charAt(i4)) - 48;
                i5 = i7;
            }
            if (z2) {
                return -i6;
            }
            return i6;
        }

        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            int i2;
            long fieldValue = getFieldValue(readablePeriod);
            if (fieldValue == Clock.MAX_TIME) {
                return 0;
            }
            int max = Math.max(FormatUtils.calculateDigitCount(fieldValue), this.iMinPrintedDigits);
            if (this.iFieldType >= 8) {
                if (fieldValue < 0) {
                    i2 = 5;
                } else {
                    i2 = 4;
                }
                max = Math.max(max, i2) + 1;
                if (this.iFieldType == 9 && Math.abs(fieldValue) % 1000 == 0) {
                    max -= 4;
                }
                fieldValue /= 1000;
            }
            int i3 = (int) fieldValue;
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                max += periodFieldAffix.calculatePrintedLength(i3);
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            if (periodFieldAffix2 != null) {
                return max + periodFieldAffix2.calculatePrintedLength(i3);
            }
            return max;
        }

        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i2, Locale locale) {
            if (i2 <= 0) {
                return 0;
            }
            return (this.iPrintZeroSetting == 4 || getFieldValue(readablePeriod) != Clock.MAX_TIME) ? 1 : 0;
        }

        public void finish(FieldFormatter[] fieldFormatterArr) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (FieldFormatter fieldFormatter : fieldFormatterArr) {
                if (fieldFormatter != null && !equals(fieldFormatter)) {
                    hashSet.add(fieldFormatter.iPrefix);
                    hashSet2.add(fieldFormatter.iSuffix);
                }
            }
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                periodFieldAffix.finish(hashSet);
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            if (periodFieldAffix2 != null) {
                periodFieldAffix2.finish(hashSet2);
            }
        }

        /* access modifiers changed from: package-private */
        public int getFieldType() {
            return this.iFieldType;
        }

        /* access modifiers changed from: package-private */
        public long getFieldValue(ReadablePeriod readablePeriod) {
            PeriodType periodType;
            long j2;
            int i2;
            if (this.iPrintZeroSetting == 4) {
                periodType = null;
            } else {
                periodType = readablePeriod.getPeriodType();
            }
            if (periodType != null && !isSupported(periodType, this.iFieldType)) {
                return Clock.MAX_TIME;
            }
            switch (this.iFieldType) {
                case 0:
                    i2 = readablePeriod.get(DurationFieldType.years());
                    break;
                case 1:
                    i2 = readablePeriod.get(DurationFieldType.months());
                    break;
                case 2:
                    i2 = readablePeriod.get(DurationFieldType.weeks());
                    break;
                case 3:
                    i2 = readablePeriod.get(DurationFieldType.days());
                    break;
                case 4:
                    i2 = readablePeriod.get(DurationFieldType.hours());
                    break;
                case 5:
                    i2 = readablePeriod.get(DurationFieldType.minutes());
                    break;
                case 6:
                    i2 = readablePeriod.get(DurationFieldType.seconds());
                    break;
                case 7:
                    i2 = readablePeriod.get(DurationFieldType.millis());
                    break;
                case 8:
                case 9:
                    j2 = (((long) readablePeriod.get(DurationFieldType.seconds())) * 1000) + ((long) readablePeriod.get(DurationFieldType.millis()));
                    break;
                default:
                    return Clock.MAX_TIME;
            }
            j2 = (long) i2;
            if (j2 == 0) {
                int i3 = this.iPrintZeroSetting;
                if (i3 == 1) {
                    if (isZero(readablePeriod)) {
                        FieldFormatter[] fieldFormatterArr = this.iFieldFormatters;
                        int i4 = this.iFieldType;
                        if (fieldFormatterArr[i4] == this) {
                            int min = Math.min(i4, 8);
                            while (true) {
                                min--;
                                if (min >= 0 && min <= 9) {
                                    if (!isSupported(periodType, min) || this.iFieldFormatters[min] == null) {
                                    }
                                }
                            }
                        }
                    }
                    return Clock.MAX_TIME;
                } else if (i3 == 2) {
                    if (isZero(readablePeriod)) {
                        FieldFormatter[] fieldFormatterArr2 = this.iFieldFormatters;
                        int i5 = this.iFieldType;
                        if (fieldFormatterArr2[i5] == this) {
                            for (int i6 = i5 + 1; i6 <= 9; i6++) {
                                if (isSupported(periodType, i6) && this.iFieldFormatters[i6] != null) {
                                    return Clock.MAX_TIME;
                                }
                            }
                        }
                    }
                    return Clock.MAX_TIME;
                } else if (i3 != 5) {
                    return j2;
                } else {
                    return Clock.MAX_TIME;
                }
            }
            return j2;
        }

        /* access modifiers changed from: package-private */
        public boolean isSupported(PeriodType periodType, int i2) {
            switch (i2) {
                case 0:
                    return periodType.isSupported(DurationFieldType.years());
                case 1:
                    return periodType.isSupported(DurationFieldType.months());
                case 2:
                    return periodType.isSupported(DurationFieldType.weeks());
                case 3:
                    return periodType.isSupported(DurationFieldType.days());
                case 4:
                    return periodType.isSupported(DurationFieldType.hours());
                case 5:
                    return periodType.isSupported(DurationFieldType.minutes());
                case 6:
                    return periodType.isSupported(DurationFieldType.seconds());
                case 7:
                    return periodType.isSupported(DurationFieldType.millis());
                case 8:
                case 9:
                    if (periodType.isSupported(DurationFieldType.seconds()) || periodType.isSupported(DurationFieldType.millis())) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isZero(ReadablePeriod readablePeriod) {
            int size = readablePeriod.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (readablePeriod.getValue(i2) != 0) {
                    return false;
                }
            }
            return true;
        }

        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i2, Locale locale) {
            boolean z2;
            int i3;
            int i4;
            PeriodFieldAffix periodFieldAffix;
            int i5;
            char charAt;
            ReadWritablePeriod readWritablePeriod2 = readWritablePeriod;
            String str2 = str;
            int i6 = i2;
            if (this.iPrintZeroSetting == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (i6 < str.length()) {
                PeriodFieldAffix periodFieldAffix2 = this.iPrefix;
                if (periodFieldAffix2 != null) {
                    i6 = periodFieldAffix2.parse(str2, i6);
                    if (i6 >= 0) {
                        z2 = true;
                    } else if (!z2) {
                        return ~i6;
                    } else {
                        return i6;
                    }
                }
                PeriodFieldAffix periodFieldAffix3 = this.iSuffix;
                int i7 = -1;
                if (periodFieldAffix3 == null || z2) {
                    i3 = -1;
                } else {
                    i3 = periodFieldAffix3.scan(str2, i6);
                    if (i3 >= 0) {
                        z2 = true;
                    } else if (!z2) {
                        return ~i3;
                    } else {
                        return i3;
                    }
                }
                if (!z2 && !isSupported(readWritablePeriod.getPeriodType(), this.iFieldType)) {
                    return i6;
                }
                if (i3 > 0) {
                    i4 = Math.min(this.iMaxParsedDigits, i3 - i6);
                } else {
                    i4 = Math.min(this.iMaxParsedDigits, str.length() - i6);
                }
                int i8 = 0;
                boolean z3 = false;
                boolean z4 = false;
                while (i8 < i4) {
                    int i9 = i6 + i8;
                    char charAt2 = str2.charAt(i9);
                    if (i8 == 0 && ((charAt2 == '-' || charAt2 == '+') && !this.iRejectSignedValues)) {
                        if (charAt2 == '-') {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        int i10 = i8 + 1;
                        if (i10 >= i4 || (charAt = str2.charAt(i9 + 1)) < '0' || charAt > '9') {
                            break;
                        }
                        if (z4) {
                            i8 = i10;
                        } else {
                            i6++;
                        }
                        i4 = Math.min(i4 + 1, str.length() - i6);
                    } else {
                        if (charAt2 < '0' || charAt2 > '9') {
                            if ((charAt2 != '.' && charAt2 != ',') || (((i5 = this.iFieldType) != 8 && i5 != 9) || i7 >= 0)) {
                                break;
                            }
                            i4 = Math.min(i4 + 1, str.length() - i6);
                            i7 = i9 + 1;
                        } else {
                            z3 = true;
                        }
                        i8++;
                    }
                }
                if (!z3) {
                    return ~i6;
                }
                if (i3 >= 0 && i6 + i8 != i3) {
                    return i6;
                }
                int i11 = this.iFieldType;
                if (i11 != 8 && i11 != 9) {
                    setFieldValue(readWritablePeriod2, i11, parseInt(str2, i6, i8));
                } else if (i7 < 0) {
                    setFieldValue(readWritablePeriod2, 6, parseInt(str2, i6, i8));
                    setFieldValue(readWritablePeriod2, 7, 0);
                } else {
                    int i12 = 0;
                    int parseInt = parseInt(str2, i6, (i7 - i6) - 1);
                    setFieldValue(readWritablePeriod2, 6, parseInt);
                    int i13 = (i6 + i8) - i7;
                    if (i13 > 0) {
                        if (i13 >= 3) {
                            i12 = parseInt(str2, i7, 3);
                        } else {
                            int parseInt2 = parseInt(str2, i7, i13);
                            if (i13 == 1) {
                                i12 = parseInt2 * 100;
                            } else {
                                i12 = parseInt2 * 10;
                            }
                        }
                        if (z4 || parseInt < 0) {
                            i12 = -i12;
                        }
                    }
                    setFieldValue(readWritablePeriod2, 7, i12);
                }
                int i14 = i6 + i8;
                if (i14 < 0 || (periodFieldAffix = this.iSuffix) == null) {
                    return i14;
                }
                return periodFieldAffix.parse(str2, i14);
            } else if (z2) {
                return ~i6;
            } else {
                return i6;
            }
        }

        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            long fieldValue = getFieldValue(readablePeriod);
            if (fieldValue != Clock.MAX_TIME) {
                int i2 = (int) fieldValue;
                if (this.iFieldType >= 8) {
                    i2 = (int) (fieldValue / 1000);
                }
                PeriodFieldAffix periodFieldAffix = this.iPrefix;
                if (periodFieldAffix != null) {
                    periodFieldAffix.printTo(stringBuffer, i2);
                }
                int length = stringBuffer.length();
                int i3 = this.iMinPrintedDigits;
                if (i3 <= 1) {
                    FormatUtils.appendUnpaddedInteger(stringBuffer, i2);
                } else {
                    FormatUtils.appendPaddedInteger(stringBuffer, i2, i3);
                }
                if (this.iFieldType >= 8) {
                    int abs = (int) (Math.abs(fieldValue) % 1000);
                    if (this.iFieldType == 8 || abs > 0) {
                        if (fieldValue < 0 && fieldValue > -1000) {
                            stringBuffer.insert(length, '-');
                        }
                        stringBuffer.append('.');
                        FormatUtils.appendPaddedInteger(stringBuffer, abs, 3);
                    }
                }
                PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
                if (periodFieldAffix2 != null) {
                    periodFieldAffix2.printTo(stringBuffer, i2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setFieldValue(ReadWritablePeriod readWritablePeriod, int i2, int i3) {
            switch (i2) {
                case 0:
                    readWritablePeriod.setYears(i3);
                    return;
                case 1:
                    readWritablePeriod.setMonths(i3);
                    return;
                case 2:
                    readWritablePeriod.setWeeks(i3);
                    return;
                case 3:
                    readWritablePeriod.setDays(i3);
                    return;
                case 4:
                    readWritablePeriod.setHours(i3);
                    return;
                case 5:
                    readWritablePeriod.setMinutes(i3);
                    return;
                case 6:
                    readWritablePeriod.setSeconds(i3);
                    return;
                case 7:
                    readWritablePeriod.setMillis(i3);
                    return;
                default:
                    return;
            }
        }

        FieldFormatter(FieldFormatter fieldFormatter, PeriodFieldAffix periodFieldAffix) {
            this.iMinPrintedDigits = fieldFormatter.iMinPrintedDigits;
            this.iPrintZeroSetting = fieldFormatter.iPrintZeroSetting;
            this.iMaxParsedDigits = fieldFormatter.iMaxParsedDigits;
            this.iRejectSignedValues = fieldFormatter.iRejectSignedValues;
            this.iFieldType = fieldFormatter.iFieldType;
            this.iFieldFormatters = fieldFormatter.iFieldFormatters;
            this.iPrefix = fieldFormatter.iPrefix;
            PeriodFieldAffix periodFieldAffix2 = fieldFormatter.iSuffix;
            this.iSuffix = periodFieldAffix2 != null ? new CompositeAffix(periodFieldAffix2, periodFieldAffix) : periodFieldAffix;
        }

        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            long fieldValue = getFieldValue(readablePeriod);
            if (fieldValue != Clock.MAX_TIME) {
                int i2 = (int) fieldValue;
                if (this.iFieldType >= 8) {
                    i2 = (int) (fieldValue / 1000);
                }
                PeriodFieldAffix periodFieldAffix = this.iPrefix;
                if (periodFieldAffix != null) {
                    periodFieldAffix.printTo(writer, i2);
                }
                int i3 = this.iMinPrintedDigits;
                if (i3 <= 1) {
                    FormatUtils.writeUnpaddedInteger(writer, i2);
                } else {
                    FormatUtils.writePaddedInteger(writer, i2, i3);
                }
                if (this.iFieldType >= 8) {
                    int abs = (int) (Math.abs(fieldValue) % 1000);
                    if (this.iFieldType == 8 || abs > 0) {
                        writer.write(46);
                        FormatUtils.writePaddedInteger(writer, abs, 3);
                    }
                }
                PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
                if (periodFieldAffix2 != null) {
                    periodFieldAffix2.printTo(writer, i2);
                }
            }
        }
    }

    static class Separator implements PeriodPrinter, PeriodParser {
        /* access modifiers changed from: private */
        public volatile PeriodParser iAfterParser;
        /* access modifiers changed from: private */
        public volatile PeriodPrinter iAfterPrinter;
        private final PeriodParser iBeforeParser;
        private final PeriodPrinter iBeforePrinter;
        private final String iFinalText;
        private final String[] iParsedForms;
        private final String iText;
        private final boolean iUseAfter;
        private final boolean iUseBefore;

        Separator(String str, String str2, String[] strArr, PeriodPrinter periodPrinter, PeriodParser periodParser, boolean z2, boolean z3) {
            this.iText = str;
            this.iFinalText = str2;
            if ((str2 == null || str.equals(str2)) && (strArr == null || strArr.length == 0)) {
                this.iParsedForms = new String[]{str};
            } else {
                TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                treeSet.add(str);
                treeSet.add(str2);
                if (strArr != null) {
                    int length = strArr.length;
                    while (true) {
                        length--;
                        if (length < 0) {
                            break;
                        }
                        treeSet.add(strArr[length]);
                    }
                }
                ArrayList arrayList = new ArrayList(treeSet);
                Collections.reverse(arrayList);
                this.iParsedForms = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            this.iBeforePrinter = periodPrinter;
            this.iBeforeParser = periodParser;
            this.iUseBefore = z2;
            this.iUseAfter = z3;
        }

        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            int i2;
            String str;
            PeriodPrinter periodPrinter = this.iBeforePrinter;
            PeriodPrinter periodPrinter2 = this.iAfterPrinter;
            int calculatePrintedLength = periodPrinter.calculatePrintedLength(readablePeriod, locale) + periodPrinter2.calculatePrintedLength(readablePeriod, locale);
            if (this.iUseBefore) {
                if (periodPrinter.countFieldsToPrint(readablePeriod, 1, locale) <= 0) {
                    return calculatePrintedLength;
                }
                if (this.iUseAfter) {
                    int countFieldsToPrint = periodPrinter2.countFieldsToPrint(readablePeriod, 2, locale);
                    if (countFieldsToPrint <= 0) {
                        return calculatePrintedLength;
                    }
                    if (countFieldsToPrint > 1) {
                        str = this.iText;
                    } else {
                        str = this.iFinalText;
                    }
                    i2 = str.length();
                } else {
                    i2 = this.iText.length();
                }
            } else if (!this.iUseAfter || periodPrinter2.countFieldsToPrint(readablePeriod, 1, locale) <= 0) {
                return calculatePrintedLength;
            } else {
                i2 = this.iText.length();
            }
            return calculatePrintedLength + i2;
        }

        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i2, Locale locale) {
            int countFieldsToPrint = this.iBeforePrinter.countFieldsToPrint(readablePeriod, i2, locale);
            if (countFieldsToPrint < i2) {
                return countFieldsToPrint + this.iAfterPrinter.countFieldsToPrint(readablePeriod, i2, locale);
            }
            return countFieldsToPrint;
        }

        /* access modifiers changed from: package-private */
        public Separator finish(PeriodPrinter periodPrinter, PeriodParser periodParser) {
            this.iAfterPrinter = periodPrinter;
            this.iAfterParser = periodParser;
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0045  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(org.joda.time.ReadWritablePeriod r12, java.lang.String r13, int r14, java.util.Locale r15) {
            /*
                r11 = this;
                org.joda.time.format.PeriodParser r0 = r11.iBeforeParser
                int r0 = r0.parseInto(r12, r13, r14, r15)
                if (r0 >= 0) goto L_0x0009
                return r0
            L_0x0009:
                r7 = 0
                if (r0 <= r14) goto L_0x003b
                java.lang.String[] r14 = r11.iParsedForms
                int r8 = r14.length
                r9 = 0
            L_0x0010:
                if (r9 >= r8) goto L_0x003b
                r10 = r14[r9]
                if (r10 == 0) goto L_0x002f
                int r1 = r10.length()
                if (r1 == 0) goto L_0x002f
                r2 = 1
                r5 = 0
                int r6 = r10.length()
                r1 = r13
                r3 = r0
                r4 = r10
                boolean r1 = r1.regionMatches(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L_0x002c
                goto L_0x002f
            L_0x002c:
                int r9 = r9 + 1
                goto L_0x0010
            L_0x002f:
                if (r10 != 0) goto L_0x0032
                goto L_0x0036
            L_0x0032:
                int r7 = r10.length()
            L_0x0036:
                int r0 = r0 + r7
                r14 = 1
                r14 = r7
                r7 = 1
                goto L_0x003c
            L_0x003b:
                r14 = -1
            L_0x003c:
                org.joda.time.format.PeriodParser r1 = r11.iAfterParser
                int r12 = r1.parseInto(r12, r13, r0, r15)
                if (r12 >= 0) goto L_0x0045
                return r12
            L_0x0045:
                if (r7 == 0) goto L_0x004d
                if (r12 != r0) goto L_0x004d
                if (r14 <= 0) goto L_0x004d
                int r12 = ~r0
                return r12
            L_0x004d:
                if (r12 <= r0) goto L_0x0056
                if (r7 != 0) goto L_0x0056
                boolean r13 = r11.iUseBefore
                if (r13 != 0) goto L_0x0056
                int r12 = ~r0
            L_0x0056:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.PeriodFormatterBuilder.Separator.parseInto(org.joda.time.ReadWritablePeriod, java.lang.String, int, java.util.Locale):int");
        }

        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            PeriodPrinter periodPrinter = this.iBeforePrinter;
            PeriodPrinter periodPrinter2 = this.iAfterPrinter;
            periodPrinter.printTo(stringBuffer, readablePeriod, locale);
            if (this.iUseBefore) {
                if (periodPrinter.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                    if (this.iUseAfter) {
                        int countFieldsToPrint = periodPrinter2.countFieldsToPrint(readablePeriod, 2, locale);
                        if (countFieldsToPrint > 0) {
                            stringBuffer.append(countFieldsToPrint > 1 ? this.iText : this.iFinalText);
                        }
                    } else {
                        stringBuffer.append(this.iText);
                    }
                }
            } else if (this.iUseAfter && periodPrinter2.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                stringBuffer.append(this.iText);
            }
            periodPrinter2.printTo(stringBuffer, readablePeriod, locale);
        }

        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            PeriodPrinter periodPrinter = this.iBeforePrinter;
            PeriodPrinter periodPrinter2 = this.iAfterPrinter;
            periodPrinter.printTo(writer, readablePeriod, locale);
            if (this.iUseBefore) {
                if (periodPrinter.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                    if (this.iUseAfter) {
                        int countFieldsToPrint = periodPrinter2.countFieldsToPrint(readablePeriod, 2, locale);
                        if (countFieldsToPrint > 0) {
                            writer.write(countFieldsToPrint > 1 ? this.iText : this.iFinalText);
                        }
                    } else {
                        writer.write(this.iText);
                    }
                }
            } else if (this.iUseAfter && periodPrinter2.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                writer.write(this.iText);
            }
            periodPrinter2.printTo(writer, readablePeriod, locale);
        }
    }
}
