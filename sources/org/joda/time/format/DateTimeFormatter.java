package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadWritableInstant;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

public class DateTimeFormatter {
    private final Chronology iChrono;
    private final int iDefaultYear;
    private final Locale iLocale;
    private final boolean iOffsetParsed;
    private final InternalParser iParser;
    private final Integer iPivotYear;
    private final InternalPrinter iPrinter;
    private final DateTimeZone iZone;

    public DateTimeFormatter(DateTimePrinter dateTimePrinter, DateTimeParser dateTimeParser) {
        this(DateTimePrinterInternalPrinter.of(dateTimePrinter), DateTimeParserInternalParser.of(dateTimeParser));
    }

    private InternalParser requireParser() {
        InternalParser internalParser = this.iParser;
        if (internalParser != null) {
            return internalParser;
        }
        throw new UnsupportedOperationException("Parsing not supported");
    }

    private InternalPrinter requirePrinter() {
        InternalPrinter internalPrinter = this.iPrinter;
        if (internalPrinter != null) {
            return internalPrinter;
        }
        throw new UnsupportedOperationException("Printing not supported");
    }

    private Chronology selectChronology(Chronology chronology) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        Chronology chronology3 = this.iChrono;
        if (chronology3 != null) {
            chronology2 = chronology3;
        }
        DateTimeZone dateTimeZone = this.iZone;
        if (dateTimeZone != null) {
            return chronology2.withZone(dateTimeZone);
        }
        return chronology2;
    }

    @Deprecated
    public Chronology getChronolgy() {
        return this.iChrono;
    }

    public Chronology getChronology() {
        return this.iChrono;
    }

    public int getDefaultYear() {
        return this.iDefaultYear;
    }

    public Locale getLocale() {
        return this.iLocale;
    }

    public DateTimeParser getParser() {
        return InternalParserDateTimeParser.of(this.iParser);
    }

    /* access modifiers changed from: package-private */
    public InternalParser getParser0() {
        return this.iParser;
    }

    public Integer getPivotYear() {
        return this.iPivotYear;
    }

    public DateTimePrinter getPrinter() {
        return InternalPrinterDateTimePrinter.of(this.iPrinter);
    }

    /* access modifiers changed from: package-private */
    public InternalPrinter getPrinter0() {
        return this.iPrinter;
    }

    public DateTimeZone getZone() {
        return this.iZone;
    }

    public boolean isOffsetParsed() {
        return this.iOffsetParsed;
    }

    public boolean isParser() {
        return this.iParser != null;
    }

    public boolean isPrinter() {
        return this.iPrinter != null;
    }

    public DateTime parseDateTime(String str) {
        InternalParser requireParser = requireParser();
        Chronology selectChronology = selectChronology((Chronology) null);
        DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(0, selectChronology, this.iLocale, this.iPivotYear, this.iDefaultYear);
        int parseInto = requireParser.parseInto(dateTimeParserBucket, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            long computeMillis = dateTimeParserBucket.computeMillis(true, str);
            if (this.iOffsetParsed && dateTimeParserBucket.getOffsetInteger() != null) {
                selectChronology = selectChronology.withZone(DateTimeZone.forOffsetMillis(dateTimeParserBucket.getOffsetInteger().intValue()));
            } else if (dateTimeParserBucket.getZone() != null) {
                selectChronology = selectChronology.withZone(dateTimeParserBucket.getZone());
            }
            DateTime dateTime = new DateTime(computeMillis, selectChronology);
            DateTimeZone dateTimeZone = this.iZone;
            if (dateTimeZone != null) {
                return dateTime.withZone(dateTimeZone);
            }
            return dateTime;
        }
        throw new IllegalArgumentException(FormatUtils.createErrorMessage(str, parseInto));
    }

    public int parseInto(ReadWritableInstant readWritableInstant, String str, int i2) {
        InternalParser requireParser = requireParser();
        if (readWritableInstant != null) {
            long millis = readWritableInstant.getMillis();
            Chronology chronology = readWritableInstant.getChronology();
            int i3 = DateTimeUtils.getChronology(chronology).year().get(millis);
            long offset = millis + ((long) chronology.getZone().getOffset(millis));
            Chronology selectChronology = selectChronology(chronology);
            DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(offset, selectChronology, this.iLocale, this.iPivotYear, i3);
            int parseInto = requireParser.parseInto(dateTimeParserBucket, str, i2);
            readWritableInstant.setMillis(dateTimeParserBucket.computeMillis(false, str));
            if (this.iOffsetParsed && dateTimeParserBucket.getOffsetInteger() != null) {
                selectChronology = selectChronology.withZone(DateTimeZone.forOffsetMillis(dateTimeParserBucket.getOffsetInteger().intValue()));
            } else if (dateTimeParserBucket.getZone() != null) {
                selectChronology = selectChronology.withZone(dateTimeParserBucket.getZone());
            }
            readWritableInstant.setChronology(selectChronology);
            DateTimeZone dateTimeZone = this.iZone;
            if (dateTimeZone != null) {
                readWritableInstant.setZone(dateTimeZone);
            }
            return parseInto;
        }
        throw new IllegalArgumentException("Instant must not be null");
    }

    public LocalDate parseLocalDate(String str) {
        return parseLocalDateTime(str).toLocalDate();
    }

    public LocalDateTime parseLocalDateTime(String str) {
        InternalParser requireParser = requireParser();
        Chronology withUTC = selectChronology((Chronology) null).withUTC();
        DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(0, withUTC, this.iLocale, this.iPivotYear, this.iDefaultYear);
        int parseInto = requireParser.parseInto(dateTimeParserBucket, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            long computeMillis = dateTimeParserBucket.computeMillis(true, str);
            if (dateTimeParserBucket.getOffsetInteger() != null) {
                withUTC = withUTC.withZone(DateTimeZone.forOffsetMillis(dateTimeParserBucket.getOffsetInteger().intValue()));
            } else if (dateTimeParserBucket.getZone() != null) {
                withUTC = withUTC.withZone(dateTimeParserBucket.getZone());
            }
            return new LocalDateTime(computeMillis, withUTC);
        }
        throw new IllegalArgumentException(FormatUtils.createErrorMessage(str, parseInto));
    }

    public LocalTime parseLocalTime(String str) {
        return parseLocalDateTime(str).toLocalTime();
    }

    public long parseMillis(String str) {
        return new DateTimeParserBucket(0, selectChronology(this.iChrono), this.iLocale, this.iPivotYear, this.iDefaultYear).doParseMillis(requireParser(), str);
    }

    public MutableDateTime parseMutableDateTime(String str) {
        InternalParser requireParser = requireParser();
        Chronology selectChronology = selectChronology((Chronology) null);
        DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(0, selectChronology, this.iLocale, this.iPivotYear, this.iDefaultYear);
        int parseInto = requireParser.parseInto(dateTimeParserBucket, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            long computeMillis = dateTimeParserBucket.computeMillis(true, str);
            if (this.iOffsetParsed && dateTimeParserBucket.getOffsetInteger() != null) {
                selectChronology = selectChronology.withZone(DateTimeZone.forOffsetMillis(dateTimeParserBucket.getOffsetInteger().intValue()));
            } else if (dateTimeParserBucket.getZone() != null) {
                selectChronology = selectChronology.withZone(dateTimeParserBucket.getZone());
            }
            MutableDateTime mutableDateTime = new MutableDateTime(computeMillis, selectChronology);
            DateTimeZone dateTimeZone = this.iZone;
            if (dateTimeZone != null) {
                mutableDateTime.setZone(dateTimeZone);
            }
            return mutableDateTime;
        }
        throw new IllegalArgumentException(FormatUtils.createErrorMessage(str, parseInto));
    }

    public String print(ReadableInstant readableInstant) {
        StringBuilder sb = new StringBuilder(requirePrinter().estimatePrintedLength());
        try {
            printTo((Appendable) sb, readableInstant);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public void printTo(StringBuffer stringBuffer, ReadableInstant readableInstant) {
        try {
            printTo((Appendable) stringBuffer, readableInstant);
        } catch (IOException unused) {
        }
    }

    public DateTimeFormatter withChronology(Chronology chronology) {
        if (this.iChrono == chronology) {
            return this;
        }
        return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, this.iOffsetParsed, chronology, this.iZone, this.iPivotYear, this.iDefaultYear);
    }

    public DateTimeFormatter withDefaultYear(int i2) {
        return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, this.iOffsetParsed, this.iChrono, this.iZone, this.iPivotYear, i2);
    }

    public DateTimeFormatter withLocale(Locale locale) {
        if (locale == getLocale() || (locale != null && locale.equals(getLocale()))) {
            return this;
        }
        return new DateTimeFormatter(this.iPrinter, this.iParser, locale, this.iOffsetParsed, this.iChrono, this.iZone, this.iPivotYear, this.iDefaultYear);
    }

    public DateTimeFormatter withOffsetParsed() {
        if (this.iOffsetParsed) {
            return this;
        }
        return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, true, this.iChrono, (DateTimeZone) null, this.iPivotYear, this.iDefaultYear);
    }

    public DateTimeFormatter withPivotYear(Integer num) {
        Integer num2 = this.iPivotYear;
        if (num2 == num || (num2 != null && num2.equals(num))) {
            return this;
        }
        return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, this.iOffsetParsed, this.iChrono, this.iZone, num, this.iDefaultYear);
    }

    public DateTimeFormatter withZone(DateTimeZone dateTimeZone) {
        if (this.iZone == dateTimeZone) {
            return this;
        }
        return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, false, this.iChrono, dateTimeZone, this.iPivotYear, this.iDefaultYear);
    }

    public DateTimeFormatter withZoneUTC() {
        return withZone(DateTimeZone.UTC);
    }

    DateTimeFormatter(InternalPrinter internalPrinter, InternalParser internalParser) {
        this.iPrinter = internalPrinter;
        this.iParser = internalParser;
        this.iLocale = null;
        this.iOffsetParsed = false;
        this.iChrono = null;
        this.iZone = null;
        this.iPivotYear = null;
        this.iDefaultYear = 2000;
    }

    public void printTo(StringBuilder sb, ReadableInstant readableInstant) {
        try {
            printTo((Appendable) sb, readableInstant);
        } catch (IOException unused) {
        }
    }

    public void printTo(Writer writer, ReadableInstant readableInstant) throws IOException {
        printTo((Appendable) writer, readableInstant);
    }

    public DateTimeFormatter withPivotYear(int i2) {
        return withPivotYear(Integer.valueOf(i2));
    }

    public String print(long j2) {
        StringBuilder sb = new StringBuilder(requirePrinter().estimatePrintedLength());
        try {
            printTo((Appendable) sb, j2);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public void printTo(Appendable appendable, ReadableInstant readableInstant) throws IOException {
        printTo(appendable, DateTimeUtils.getInstantMillis(readableInstant), DateTimeUtils.getInstantChronology(readableInstant));
    }

    public String print(ReadablePartial readablePartial) {
        StringBuilder sb = new StringBuilder(requirePrinter().estimatePrintedLength());
        try {
            printTo((Appendable) sb, readablePartial);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public void printTo(StringBuffer stringBuffer, long j2) {
        try {
            printTo((Appendable) stringBuffer, j2);
        } catch (IOException unused) {
        }
    }

    public void printTo(StringBuilder sb, long j2) {
        try {
            printTo((Appendable) sb, j2);
        } catch (IOException unused) {
        }
    }

    public void printTo(Writer writer, long j2) throws IOException {
        printTo((Appendable) writer, j2);
    }

    public void printTo(Appendable appendable, long j2) throws IOException {
        printTo(appendable, j2, (Chronology) null);
    }

    private DateTimeFormatter(InternalPrinter internalPrinter, InternalParser internalParser, Locale locale, boolean z2, Chronology chronology, DateTimeZone dateTimeZone, Integer num, int i2) {
        this.iPrinter = internalPrinter;
        this.iParser = internalParser;
        this.iLocale = locale;
        this.iOffsetParsed = z2;
        this.iChrono = chronology;
        this.iZone = dateTimeZone;
        this.iPivotYear = num;
        this.iDefaultYear = i2;
    }

    public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial) {
        try {
            printTo((Appendable) stringBuffer, readablePartial);
        } catch (IOException unused) {
        }
    }

    public void printTo(StringBuilder sb, ReadablePartial readablePartial) {
        try {
            printTo((Appendable) sb, readablePartial);
        } catch (IOException unused) {
        }
    }

    public void printTo(Writer writer, ReadablePartial readablePartial) throws IOException {
        printTo((Appendable) writer, readablePartial);
    }

    public void printTo(Appendable appendable, ReadablePartial readablePartial) throws IOException {
        InternalPrinter requirePrinter = requirePrinter();
        if (readablePartial != null) {
            requirePrinter.printTo(appendable, readablePartial, this.iLocale);
            return;
        }
        throw new IllegalArgumentException("The partial must not be null");
    }

    private void printTo(Appendable appendable, long j2, Chronology chronology) throws IOException {
        long j3 = j2;
        InternalPrinter requirePrinter = requirePrinter();
        Chronology selectChronology = selectChronology(chronology);
        DateTimeZone zone = selectChronology.getZone();
        int offset = zone.getOffset(j3);
        long j4 = (long) offset;
        long j5 = j3 + j4;
        if ((j3 ^ j5) < 0 && (j4 ^ j3) >= 0) {
            zone = DateTimeZone.UTC;
            offset = 0;
            j5 = j3;
        }
        InternalPrinter internalPrinter = requirePrinter;
        Appendable appendable2 = appendable;
        long j6 = j5;
        internalPrinter.printTo(appendable2, j6, selectChronology.withUTC(), offset, zone, this.iLocale);
    }
}
