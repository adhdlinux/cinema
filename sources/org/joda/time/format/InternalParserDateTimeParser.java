package org.joda.time.format;

class InternalParserDateTimeParser implements DateTimeParser, InternalParser {
    private final InternalParser underlying;

    private InternalParserDateTimeParser(InternalParser internalParser) {
        this.underlying = internalParser;
    }

    static DateTimeParser of(InternalParser internalParser) {
        if (internalParser instanceof DateTimeParserInternalParser) {
            return ((DateTimeParserInternalParser) internalParser).getUnderlying();
        }
        if (internalParser instanceof DateTimeParser) {
            return (DateTimeParser) internalParser;
        }
        if (internalParser == null) {
            return null;
        }
        return new InternalParserDateTimeParser(internalParser);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternalParserDateTimeParser) {
            return this.underlying.equals(((InternalParserDateTimeParser) obj).underlying);
        }
        return false;
    }

    public int estimateParsedLength() {
        return this.underlying.estimateParsedLength();
    }

    public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i2) {
        return this.underlying.parseInto(dateTimeParserBucket, charSequence, i2);
    }

    public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i2) {
        return this.underlying.parseInto(dateTimeParserBucket, str, i2);
    }
}
