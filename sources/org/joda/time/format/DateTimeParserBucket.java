package org.joda.time.format;

import java.util.Arrays;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;

public class DateTimeParserBucket {
    private final Chronology iChrono;
    private final Integer iDefaultPivotYear;
    private final int iDefaultYear;
    private final DateTimeZone iDefaultZone;
    private final Locale iLocale;
    private final long iMillis;
    /* access modifiers changed from: private */
    public Integer iOffset;
    private Integer iPivotYear;
    /* access modifiers changed from: private */
    public SavedField[] iSavedFields;
    /* access modifiers changed from: private */
    public int iSavedFieldsCount;
    /* access modifiers changed from: private */
    public boolean iSavedFieldsShared;
    private Object iSavedState;
    /* access modifiers changed from: private */
    public DateTimeZone iZone;

    static class SavedField implements Comparable<SavedField> {
        DateTimeField iField;
        Locale iLocale;
        String iText;
        int iValue;

        SavedField() {
        }

        /* access modifiers changed from: package-private */
        public void init(DateTimeField dateTimeField, int i2) {
            this.iField = dateTimeField;
            this.iValue = i2;
            this.iText = null;
            this.iLocale = null;
        }

        /* access modifiers changed from: package-private */
        public long set(long j2, boolean z2) {
            long j3;
            String str = this.iText;
            if (str == null) {
                j3 = this.iField.setExtended(j2, this.iValue);
            } else {
                j3 = this.iField.set(j2, str, this.iLocale);
            }
            if (z2) {
                return this.iField.roundFloor(j3);
            }
            return j3;
        }

        public int compareTo(SavedField savedField) {
            DateTimeField dateTimeField = savedField.iField;
            int compareReverse = DateTimeParserBucket.compareReverse(this.iField.getRangeDurationField(), dateTimeField.getRangeDurationField());
            if (compareReverse != 0) {
                return compareReverse;
            }
            return DateTimeParserBucket.compareReverse(this.iField.getDurationField(), dateTimeField.getDurationField());
        }

        /* access modifiers changed from: package-private */
        public void init(DateTimeField dateTimeField, String str, Locale locale) {
            this.iField = dateTimeField;
            this.iValue = 0;
            this.iText = str;
            this.iLocale = locale;
        }
    }

    class SavedState {
        final Integer iOffset;
        final SavedField[] iSavedFields;
        final int iSavedFieldsCount;
        final DateTimeZone iZone;

        SavedState() {
            this.iZone = DateTimeParserBucket.this.iZone;
            this.iOffset = DateTimeParserBucket.this.iOffset;
            this.iSavedFields = DateTimeParserBucket.this.iSavedFields;
            this.iSavedFieldsCount = DateTimeParserBucket.this.iSavedFieldsCount;
        }

        /* access modifiers changed from: package-private */
        public boolean restoreState(DateTimeParserBucket dateTimeParserBucket) {
            if (dateTimeParserBucket != DateTimeParserBucket.this) {
                return false;
            }
            DateTimeZone unused = dateTimeParserBucket.iZone = this.iZone;
            Integer unused2 = dateTimeParserBucket.iOffset = this.iOffset;
            SavedField[] unused3 = dateTimeParserBucket.iSavedFields = this.iSavedFields;
            if (this.iSavedFieldsCount < dateTimeParserBucket.iSavedFieldsCount) {
                boolean unused4 = dateTimeParserBucket.iSavedFieldsShared = true;
            }
            int unused5 = dateTimeParserBucket.iSavedFieldsCount = this.iSavedFieldsCount;
            return true;
        }
    }

    @Deprecated
    public DateTimeParserBucket(long j2, Chronology chronology, Locale locale) {
        this(j2, chronology, locale, (Integer) null, 2000);
    }

    static int compareReverse(DurationField durationField, DurationField durationField2) {
        if (durationField == null || !durationField.isSupported()) {
            if (durationField2 == null || !durationField2.isSupported()) {
                return 0;
            }
            return -1;
        } else if (durationField2 == null || !durationField2.isSupported()) {
            return 1;
        } else {
            return -durationField.compareTo(durationField2);
        }
    }

    private SavedField obtainSaveField() {
        int i2;
        SavedField[] savedFieldArr = this.iSavedFields;
        int i3 = this.iSavedFieldsCount;
        if (i3 == savedFieldArr.length || this.iSavedFieldsShared) {
            if (i3 == savedFieldArr.length) {
                i2 = i3 * 2;
            } else {
                i2 = savedFieldArr.length;
            }
            SavedField[] savedFieldArr2 = new SavedField[i2];
            System.arraycopy(savedFieldArr, 0, savedFieldArr2, 0, i3);
            this.iSavedFields = savedFieldArr2;
            this.iSavedFieldsShared = false;
            savedFieldArr = savedFieldArr2;
        }
        this.iSavedState = null;
        SavedField savedField = savedFieldArr[i3];
        if (savedField == null) {
            savedField = new SavedField();
            savedFieldArr[i3] = savedField;
        }
        this.iSavedFieldsCount = i3 + 1;
        return savedField;
    }

    private static void sort(SavedField[] savedFieldArr, int i2) {
        if (i2 > 10) {
            Arrays.sort(savedFieldArr, 0, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = i3; i4 > 0; i4--) {
                int i5 = i4 - 1;
                if (savedFieldArr[i5].compareTo(savedFieldArr[i4]) <= 0) {
                    break;
                }
                SavedField savedField = savedFieldArr[i4];
                savedFieldArr[i4] = savedFieldArr[i5];
                savedFieldArr[i5] = savedField;
            }
        }
    }

    public long computeMillis() {
        return computeMillis(false, (CharSequence) null);
    }

    /* access modifiers changed from: package-private */
    public long doParseMillis(InternalParser internalParser, CharSequence charSequence) {
        int parseInto = internalParser.parseInto(this, charSequence, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= charSequence.length()) {
            return computeMillis(true, charSequence);
        }
        throw new IllegalArgumentException(FormatUtils.createErrorMessage(charSequence.toString(), parseInto));
    }

    public Chronology getChronology() {
        return this.iChrono;
    }

    public Locale getLocale() {
        return this.iLocale;
    }

    @Deprecated
    public int getOffset() {
        Integer num = this.iOffset;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public Integer getOffsetInteger() {
        return this.iOffset;
    }

    public Integer getPivotYear() {
        return this.iPivotYear;
    }

    public DateTimeZone getZone() {
        return this.iZone;
    }

    public long parseMillis(DateTimeParser dateTimeParser, CharSequence charSequence) {
        reset();
        return doParseMillis(DateTimeParserInternalParser.of(dateTimeParser), charSequence);
    }

    public void reset() {
        this.iZone = this.iDefaultZone;
        this.iOffset = null;
        this.iPivotYear = this.iDefaultPivotYear;
        this.iSavedFieldsCount = 0;
        this.iSavedFieldsShared = false;
        this.iSavedState = null;
    }

    public boolean restoreState(Object obj) {
        if (!(obj instanceof SavedState) || !((SavedState) obj).restoreState(this)) {
            return false;
        }
        this.iSavedState = obj;
        return true;
    }

    public void saveField(DateTimeField dateTimeField, int i2) {
        obtainSaveField().init(dateTimeField, i2);
    }

    public Object saveState() {
        if (this.iSavedState == null) {
            this.iSavedState = new SavedState();
        }
        return this.iSavedState;
    }

    @Deprecated
    public void setOffset(int i2) {
        this.iSavedState = null;
        this.iOffset = Integer.valueOf(i2);
    }

    @Deprecated
    public void setPivotYear(Integer num) {
        this.iPivotYear = num;
    }

    public void setZone(DateTimeZone dateTimeZone) {
        this.iSavedState = null;
        this.iZone = dateTimeZone;
    }

    @Deprecated
    public DateTimeParserBucket(long j2, Chronology chronology, Locale locale, Integer num) {
        this(j2, chronology, locale, num, 2000);
    }

    public long computeMillis(boolean z2) {
        return computeMillis(z2, (CharSequence) null);
    }

    public void saveField(DateTimeFieldType dateTimeFieldType, int i2) {
        obtainSaveField().init(dateTimeFieldType.getField(this.iChrono), i2);
    }

    public DateTimeParserBucket(long j2, Chronology chronology, Locale locale, Integer num, int i2) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        this.iMillis = j2;
        DateTimeZone zone = chronology2.getZone();
        this.iDefaultZone = zone;
        this.iChrono = chronology2.withUTC();
        this.iLocale = locale == null ? Locale.getDefault() : locale;
        this.iDefaultYear = i2;
        this.iDefaultPivotYear = num;
        this.iZone = zone;
        this.iPivotYear = num;
        this.iSavedFields = new SavedField[8];
    }

    public long computeMillis(boolean z2, String str) {
        return computeMillis(z2, (CharSequence) str);
    }

    public void saveField(DateTimeFieldType dateTimeFieldType, String str, Locale locale) {
        obtainSaveField().init(dateTimeFieldType.getField(this.iChrono), str, locale);
    }

    public void setOffset(Integer num) {
        this.iSavedState = null;
        this.iOffset = num;
    }

    public long computeMillis(boolean z2, CharSequence charSequence) {
        SavedField[] savedFieldArr = this.iSavedFields;
        int i2 = this.iSavedFieldsCount;
        if (this.iSavedFieldsShared) {
            savedFieldArr = (SavedField[]) savedFieldArr.clone();
            this.iSavedFields = savedFieldArr;
            this.iSavedFieldsShared = false;
        }
        sort(savedFieldArr, i2);
        if (i2 > 0) {
            DurationField field = DurationFieldType.months().getField(this.iChrono);
            DurationField field2 = DurationFieldType.days().getField(this.iChrono);
            DurationField durationField = savedFieldArr[0].iField.getDurationField();
            if (compareReverse(durationField, field) >= 0 && compareReverse(durationField, field2) <= 0) {
                saveField(DateTimeFieldType.year(), this.iDefaultYear);
                return computeMillis(z2, charSequence);
            }
        }
        long j2 = this.iMillis;
        int i3 = 0;
        while (i3 < i2) {
            try {
                j2 = savedFieldArr[i3].set(j2, z2);
                i3++;
            } catch (IllegalFieldValueException e2) {
                if (charSequence != null) {
                    e2.prependMessage("Cannot parse \"" + charSequence + '\"');
                }
                throw e2;
            }
        }
        if (z2) {
            int i4 = 0;
            while (i4 < i2) {
                j2 = savedFieldArr[i4].set(j2, i4 == i2 + -1);
                i4++;
            }
        }
        Integer num = this.iOffset;
        if (num != null) {
            return j2 - ((long) num.intValue());
        }
        DateTimeZone dateTimeZone = this.iZone;
        if (dateTimeZone == null) {
            return j2;
        }
        int offsetFromLocal = dateTimeZone.getOffsetFromLocal(j2);
        long j3 = j2 - ((long) offsetFromLocal);
        if (offsetFromLocal == this.iZone.getOffset(j3)) {
            return j3;
        }
        String str = "Illegal instant due to time zone offset transition (" + this.iZone + ')';
        if (charSequence != null) {
            str = "Cannot parse \"" + charSequence + "\": " + str;
        }
        throw new IllegalInstantException(str);
    }
}
