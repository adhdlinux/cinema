package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

class InternalPrinterDateTimePrinter implements DateTimePrinter, InternalPrinter {
    private final InternalPrinter underlying;

    private InternalPrinterDateTimePrinter(InternalPrinter internalPrinter) {
        this.underlying = internalPrinter;
    }

    static DateTimePrinter of(InternalPrinter internalPrinter) {
        if (internalPrinter instanceof DateTimePrinterInternalPrinter) {
            return ((DateTimePrinterInternalPrinter) internalPrinter).getUnderlying();
        }
        if (internalPrinter instanceof DateTimePrinter) {
            return (DateTimePrinter) internalPrinter;
        }
        if (internalPrinter == null) {
            return null;
        }
        return new InternalPrinterDateTimePrinter(internalPrinter);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternalPrinterDateTimePrinter) {
            return this.underlying.equals(((InternalPrinterDateTimePrinter) obj).underlying);
        }
        return false;
    }

    public int estimatePrintedLength() {
        return this.underlying.estimatePrintedLength();
    }

    public void printTo(StringBuffer stringBuffer, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) {
        try {
            this.underlying.printTo(stringBuffer, j2, chronology, i2, dateTimeZone, locale);
        } catch (IOException unused) {
        }
    }

    public void printTo(Writer writer, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
        this.underlying.printTo(writer, j2, chronology, i2, dateTimeZone, locale);
    }

    public void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException {
        this.underlying.printTo(appendable, j2, chronology, i2, dateTimeZone, locale);
    }

    public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
        try {
            this.underlying.printTo(stringBuffer, readablePartial, locale);
        } catch (IOException unused) {
        }
    }

    public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
        this.underlying.printTo(writer, readablePartial, locale);
    }

    public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        this.underlying.printTo(appendable, readablePartial, locale);
    }
}
