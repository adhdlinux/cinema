package org.joda.time.format;

import java.io.IOException;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

interface InternalPrinter {
    int estimatePrintedLength();

    void printTo(Appendable appendable, long j2, Chronology chronology, int i2, DateTimeZone dateTimeZone, Locale locale) throws IOException;

    void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException;
}
