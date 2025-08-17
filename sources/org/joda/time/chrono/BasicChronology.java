package org.joda.time.chrono;

import com.facebook.common.time.Clock;
import com.google.android.gms.cast.MediaError;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.OffsetDateTimeField;
import org.joda.time.field.PreciseDateTimeField;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.field.RemainderDateTimeField;
import org.joda.time.field.ZeroIsMaxDateTimeField;

abstract class BasicChronology extends AssembledChronology {
    private static final int CACHE_MASK = 1023;
    private static final int CACHE_SIZE = 1024;
    private static final DateTimeField cClockhourOfDayField;
    private static final DateTimeField cClockhourOfHalfdayField;
    /* access modifiers changed from: private */
    public static final DurationField cDaysField;
    private static final DateTimeField cHalfdayOfDayField = new HalfdayField();
    /* access modifiers changed from: private */
    public static final DurationField cHalfdaysField;
    private static final DateTimeField cHourOfDayField;
    private static final DateTimeField cHourOfHalfdayField;
    private static final DurationField cHoursField;
    private static final DurationField cMillisField;
    private static final DateTimeField cMillisOfDayField;
    private static final DateTimeField cMillisOfSecondField;
    private static final DateTimeField cMinuteOfDayField;
    private static final DateTimeField cMinuteOfHourField;
    private static final DurationField cMinutesField;
    private static final DateTimeField cSecondOfDayField;
    private static final DateTimeField cSecondOfMinuteField;
    private static final DurationField cSecondsField;
    private static final DurationField cWeeksField = new PreciseDurationField(DurationFieldType.weeks(), 604800000);
    private static final long serialVersionUID = 8283225332206808863L;
    private final int iMinDaysInFirstWeek;
    private final transient YearInfo[] iYearInfoCache = new YearInfo[1024];

    private static class HalfdayField extends PreciseDateTimeField {
        private static final long serialVersionUID = 581601443656929254L;

        HalfdayField() {
            super(DateTimeFieldType.halfdayOfDay(), BasicChronology.cHalfdaysField, BasicChronology.cDaysField);
        }

        public String getAsText(int i2, Locale locale) {
            return GJLocaleSymbols.forLocale(locale).halfdayValueToText(i2);
        }

        public int getMaximumTextLength(Locale locale) {
            return GJLocaleSymbols.forLocale(locale).getHalfdayMaxTextLength();
        }

        public long set(long j2, String str, Locale locale) {
            return set(j2, GJLocaleSymbols.forLocale(locale).halfdayTextToValue(str));
        }
    }

    private static class YearInfo {
        public final long iFirstDayMillis;
        public final int iYear;

        YearInfo(int i2, long j2) {
            this.iYear = i2;
            this.iFirstDayMillis = j2;
        }
    }

    static {
        DurationField durationField = MillisDurationField.INSTANCE;
        cMillisField = durationField;
        PreciseDurationField preciseDurationField = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        cSecondsField = preciseDurationField;
        PreciseDurationField preciseDurationField2 = new PreciseDurationField(DurationFieldType.minutes(), 60000);
        cMinutesField = preciseDurationField2;
        PreciseDurationField preciseDurationField3 = new PreciseDurationField(DurationFieldType.hours(), 3600000);
        cHoursField = preciseDurationField3;
        PreciseDurationField preciseDurationField4 = new PreciseDurationField(DurationFieldType.halfdays(), 43200000);
        cHalfdaysField = preciseDurationField4;
        PreciseDurationField preciseDurationField5 = new PreciseDurationField(DurationFieldType.days(), SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        cDaysField = preciseDurationField5;
        cMillisOfSecondField = new PreciseDateTimeField(DateTimeFieldType.millisOfSecond(), durationField, preciseDurationField);
        cMillisOfDayField = new PreciseDateTimeField(DateTimeFieldType.millisOfDay(), durationField, preciseDurationField5);
        cSecondOfMinuteField = new PreciseDateTimeField(DateTimeFieldType.secondOfMinute(), preciseDurationField, preciseDurationField2);
        cSecondOfDayField = new PreciseDateTimeField(DateTimeFieldType.secondOfDay(), preciseDurationField, preciseDurationField5);
        cMinuteOfHourField = new PreciseDateTimeField(DateTimeFieldType.minuteOfHour(), preciseDurationField2, preciseDurationField3);
        cMinuteOfDayField = new PreciseDateTimeField(DateTimeFieldType.minuteOfDay(), preciseDurationField2, preciseDurationField5);
        PreciseDateTimeField preciseDateTimeField = new PreciseDateTimeField(DateTimeFieldType.hourOfDay(), preciseDurationField3, preciseDurationField5);
        cHourOfDayField = preciseDateTimeField;
        PreciseDateTimeField preciseDateTimeField2 = new PreciseDateTimeField(DateTimeFieldType.hourOfHalfday(), preciseDurationField3, preciseDurationField4);
        cHourOfHalfdayField = preciseDateTimeField2;
        cClockhourOfDayField = new ZeroIsMaxDateTimeField(preciseDateTimeField, DateTimeFieldType.clockhourOfDay());
        cClockhourOfHalfdayField = new ZeroIsMaxDateTimeField(preciseDateTimeField2, DateTimeFieldType.clockhourOfHalfday());
    }

    BasicChronology(Chronology chronology, Object obj, int i2) {
        super(chronology, obj);
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i2);
        }
        this.iMinDaysInFirstWeek = i2;
    }

    private long getDateTimeMillis0(int i2, int i3, int i4, int i5) {
        long dateMidnightMillis = getDateMidnightMillis(i2, i3, i4);
        if (dateMidnightMillis == Long.MIN_VALUE) {
            dateMidnightMillis = getDateMidnightMillis(i2, i3, i4 + 1);
            i5 -= DateTimeConstants.MILLIS_PER_DAY;
        }
        long j2 = ((long) i5) + dateMidnightMillis;
        int i6 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i6 < 0 && dateMidnightMillis > 0) {
            return Clock.MAX_TIME;
        }
        if (i6 <= 0 || dateMidnightMillis >= 0) {
            return j2;
        }
        return Long.MIN_VALUE;
    }

    private YearInfo getYearInfo(int i2) {
        YearInfo[] yearInfoArr = this.iYearInfoCache;
        int i3 = i2 & CACHE_MASK;
        YearInfo yearInfo = yearInfoArr[i3];
        if (yearInfo != null && yearInfo.iYear == i2) {
            return yearInfo;
        }
        YearInfo yearInfo2 = new YearInfo(i2, calculateFirstDayOfYearMillis(i2));
        this.iYearInfoCache[i3] = yearInfo2;
        return yearInfo2;
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        fields.millis = cMillisField;
        fields.seconds = cSecondsField;
        fields.minutes = cMinutesField;
        fields.hours = cHoursField;
        fields.halfdays = cHalfdaysField;
        fields.days = cDaysField;
        fields.weeks = cWeeksField;
        fields.millisOfSecond = cMillisOfSecondField;
        fields.millisOfDay = cMillisOfDayField;
        fields.secondOfMinute = cSecondOfMinuteField;
        fields.secondOfDay = cSecondOfDayField;
        fields.minuteOfHour = cMinuteOfHourField;
        fields.minuteOfDay = cMinuteOfDayField;
        fields.hourOfDay = cHourOfDayField;
        fields.hourOfHalfday = cHourOfHalfdayField;
        fields.clockhourOfDay = cClockhourOfDayField;
        fields.clockhourOfHalfday = cClockhourOfHalfdayField;
        fields.halfdayOfDay = cHalfdayOfDayField;
        BasicYearDateTimeField basicYearDateTimeField = new BasicYearDateTimeField(this);
        fields.year = basicYearDateTimeField;
        GJYearOfEraDateTimeField gJYearOfEraDateTimeField = new GJYearOfEraDateTimeField(basicYearDateTimeField, this);
        fields.yearOfEra = gJYearOfEraDateTimeField;
        DividedDateTimeField dividedDateTimeField = new DividedDateTimeField((DateTimeField) new OffsetDateTimeField(gJYearOfEraDateTimeField, 99), DateTimeFieldType.centuryOfEra(), 100);
        fields.centuryOfEra = dividedDateTimeField;
        fields.centuries = dividedDateTimeField.getDurationField();
        fields.yearOfCentury = new OffsetDateTimeField(new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra), DateTimeFieldType.yearOfCentury(), 1);
        fields.era = new GJEraDateTimeField(this);
        fields.dayOfWeek = new GJDayOfWeekDateTimeField(this, fields.days);
        fields.dayOfMonth = new BasicDayOfMonthDateTimeField(this, fields.days);
        fields.dayOfYear = new BasicDayOfYearDateTimeField(this, fields.days);
        fields.monthOfYear = new GJMonthOfYearDateTimeField(this);
        fields.weekyear = new BasicWeekyearDateTimeField(this);
        fields.weekOfWeekyear = new BasicWeekOfWeekyearDateTimeField(this, fields.weeks);
        fields.weekyearOfCentury = new OffsetDateTimeField(new RemainderDateTimeField(fields.weekyear, fields.centuries, DateTimeFieldType.weekyearOfCentury(), 100), DateTimeFieldType.weekyearOfCentury(), 1);
        fields.years = fields.year.getDurationField();
        fields.months = fields.monthOfYear.getDurationField();
        fields.weekyears = fields.weekyear.getDurationField();
    }

    /* access modifiers changed from: package-private */
    public abstract long calculateFirstDayOfYearMillis(int i2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BasicChronology basicChronology = (BasicChronology) obj;
        if (getMinimumDaysInFirstWeek() != basicChronology.getMinimumDaysInFirstWeek() || !getZone().equals(basicChronology.getZone())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract long getApproxMillisAtEpochDividedByTwo();

    /* access modifiers changed from: package-private */
    public abstract long getAverageMillisPerMonth();

    /* access modifiers changed from: package-private */
    public abstract long getAverageMillisPerYear();

    /* access modifiers changed from: package-private */
    public abstract long getAverageMillisPerYearDividedByTwo();

    /* access modifiers changed from: package-private */
    public long getDateMidnightMillis(int i2, int i3, int i4) {
        FieldUtils.verifyValueBounds(DateTimeFieldType.year(), i2, getMinYear() - 1, getMaxYear() + 1);
        FieldUtils.verifyValueBounds(DateTimeFieldType.monthOfYear(), i3, 1, getMaxMonth(i2));
        FieldUtils.verifyValueBounds(DateTimeFieldType.dayOfMonth(), i4, 1, getDaysInYearMonth(i2, i3));
        long yearMonthDayMillis = getYearMonthDayMillis(i2, i3, i4);
        int i5 = (yearMonthDayMillis > 0 ? 1 : (yearMonthDayMillis == 0 ? 0 : -1));
        if (i5 < 0 && i2 == getMaxYear() + 1) {
            return Clock.MAX_TIME;
        }
        if (i5 <= 0 || i2 != getMinYear() - 1) {
            return yearMonthDayMillis;
        }
        return Long.MIN_VALUE;
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i2, i3, i4, i5);
        }
        FieldUtils.verifyValueBounds(DateTimeFieldType.millisOfDay(), i5, 0, 86399999);
        return getDateTimeMillis0(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public int getDayOfMonth(long j2) {
        int year = getYear(j2);
        return getDayOfMonth(j2, year, getMonthOfYear(j2, year));
    }

    /* access modifiers changed from: package-private */
    public int getDayOfWeek(long j2) {
        long j3;
        if (j2 >= 0) {
            j3 = j2 / SignalManager.TWENTY_FOUR_HOURS_MILLIS;
        } else {
            j3 = (j2 - 86399999) / SignalManager.TWENTY_FOUR_HOURS_MILLIS;
            if (j3 < -3) {
                return ((int) ((j3 + 4) % 7)) + 7;
            }
        }
        return ((int) ((j3 + 3) % 7)) + 1;
    }

    /* access modifiers changed from: package-private */
    public int getDayOfYear(long j2) {
        return getDayOfYear(j2, getYear(j2));
    }

    /* access modifiers changed from: package-private */
    public int getDaysInMonthMax() {
        return 31;
    }

    /* access modifiers changed from: package-private */
    public abstract int getDaysInMonthMax(int i2);

    /* access modifiers changed from: package-private */
    public int getDaysInMonthMax(long j2) {
        int year = getYear(j2);
        return getDaysInYearMonth(year, getMonthOfYear(j2, year));
    }

    /* access modifiers changed from: package-private */
    public int getDaysInMonthMaxForSet(long j2, int i2) {
        return getDaysInMonthMax(j2);
    }

    /* access modifiers changed from: package-private */
    public int getDaysInYear(int i2) {
        return isLeapYear(i2) ? 366 : 365;
    }

    /* access modifiers changed from: package-private */
    public int getDaysInYearMax() {
        return 366;
    }

    /* access modifiers changed from: package-private */
    public abstract int getDaysInYearMonth(int i2, int i3);

    /* access modifiers changed from: package-private */
    public long getFirstWeekOfYearMillis(int i2) {
        long yearMillis = getYearMillis(i2);
        int dayOfWeek = getDayOfWeek(yearMillis);
        if (dayOfWeek > 8 - this.iMinDaysInFirstWeek) {
            return yearMillis + (((long) (8 - dayOfWeek)) * SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        }
        return yearMillis - (((long) (dayOfWeek - 1)) * SignalManager.TWENTY_FOUR_HOURS_MILLIS);
    }

    /* access modifiers changed from: package-private */
    public int getMaxMonth() {
        return 12;
    }

    /* access modifiers changed from: package-private */
    public int getMaxMonth(int i2) {
        return getMaxMonth();
    }

    /* access modifiers changed from: package-private */
    public abstract int getMaxYear();

    /* access modifiers changed from: package-private */
    public int getMillisOfDay(long j2) {
        if (j2 >= 0) {
            return (int) (j2 % SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        }
        return ((int) ((j2 + 1) % SignalManager.TWENTY_FOUR_HOURS_MILLIS)) + 86399999;
    }

    /* access modifiers changed from: package-private */
    public abstract int getMinYear();

    public int getMinimumDaysInFirstWeek() {
        return this.iMinDaysInFirstWeek;
    }

    /* access modifiers changed from: package-private */
    public int getMonthOfYear(long j2) {
        return getMonthOfYear(j2, getYear(j2));
    }

    /* access modifiers changed from: package-private */
    public abstract int getMonthOfYear(long j2, int i2);

    /* access modifiers changed from: package-private */
    public abstract long getTotalMillisByYearMonth(int i2, int i3);

    /* access modifiers changed from: package-private */
    public int getWeekOfWeekyear(long j2) {
        return getWeekOfWeekyear(j2, getYear(j2));
    }

    /* access modifiers changed from: package-private */
    public int getWeeksInYear(int i2) {
        return (int) ((getFirstWeekOfYearMillis(i2 + 1) - getFirstWeekOfYearMillis(i2)) / 604800000);
    }

    /* access modifiers changed from: package-private */
    public int getWeekyear(long j2) {
        int year = getYear(j2);
        int weekOfWeekyear = getWeekOfWeekyear(j2, year);
        if (weekOfWeekyear == 1) {
            return getYear(j2 + 604800000);
        }
        if (weekOfWeekyear > 51) {
            return getYear(j2 - 1209600000);
        }
        return year;
    }

    /* access modifiers changed from: package-private */
    public int getYear(long j2) {
        long averageMillisPerYearDividedByTwo = getAverageMillisPerYearDividedByTwo();
        long approxMillisAtEpochDividedByTwo = (j2 >> 1) + getApproxMillisAtEpochDividedByTwo();
        if (approxMillisAtEpochDividedByTwo < 0) {
            approxMillisAtEpochDividedByTwo = (approxMillisAtEpochDividedByTwo - averageMillisPerYearDividedByTwo) + 1;
        }
        int i2 = (int) (approxMillisAtEpochDividedByTwo / averageMillisPerYearDividedByTwo);
        long yearMillis = getYearMillis(i2);
        long j3 = j2 - yearMillis;
        if (j3 < 0) {
            return i2 - 1;
        }
        long j4 = 31536000000L;
        if (j3 < 31536000000L) {
            return i2;
        }
        if (isLeapYear(i2)) {
            j4 = 31622400000L;
        }
        if (yearMillis + j4 <= j2) {
            return i2 + 1;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public abstract long getYearDifference(long j2, long j3);

    /* access modifiers changed from: package-private */
    public long getYearMillis(int i2) {
        return getYearInfo(i2).iFirstDayMillis;
    }

    /* access modifiers changed from: package-private */
    public long getYearMonthDayMillis(int i2, int i3, int i4) {
        return getYearMillis(i2) + getTotalMillisByYearMonth(i2, i3) + (((long) (i4 - 1)) * SignalManager.TWENTY_FOUR_HOURS_MILLIS);
    }

    /* access modifiers changed from: package-private */
    public long getYearMonthMillis(int i2, int i3) {
        return getYearMillis(i2) + getTotalMillisByYearMonth(i2, i3);
    }

    public DateTimeZone getZone() {
        Chronology base = getBase();
        if (base != null) {
            return base.getZone();
        }
        return DateTimeZone.UTC;
    }

    public int hashCode() {
        return (getClass().getName().hashCode() * 11) + getZone().hashCode() + getMinimumDaysInFirstWeek();
    }

    /* access modifiers changed from: package-private */
    public boolean isLeapDay(long j2) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isLeapYear(int i2);

    /* access modifiers changed from: package-private */
    public abstract long setYear(long j2, int i2);

    public String toString() {
        StringBuilder sb = new StringBuilder(60);
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        sb.append(name);
        sb.append('[');
        DateTimeZone zone = getZone();
        if (zone != null) {
            sb.append(zone.getID());
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            sb.append(",mdfw=");
            sb.append(getMinimumDaysInFirstWeek());
        }
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int getDayOfYear(long j2, int i2) {
        return ((int) ((j2 - getYearMillis(i2)) / SignalManager.TWENTY_FOUR_HOURS_MILLIS)) + 1;
    }

    /* access modifiers changed from: package-private */
    public int getWeekOfWeekyear(long j2, int i2) {
        long firstWeekOfYearMillis = getFirstWeekOfYearMillis(i2);
        if (j2 < firstWeekOfYearMillis) {
            return getWeeksInYear(i2 - 1);
        }
        if (j2 >= getFirstWeekOfYearMillis(i2 + 1)) {
            return 1;
        }
        return ((int) ((j2 - firstWeekOfYearMillis) / 604800000)) + 1;
    }

    /* access modifiers changed from: package-private */
    public int getDayOfMonth(long j2, int i2) {
        return getDayOfMonth(j2, i2, getMonthOfYear(j2, i2));
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i2, i3, i4, i5, i6, i7, i8);
        }
        FieldUtils.verifyValueBounds(DateTimeFieldType.hourOfDay(), i5, 0, 23);
        FieldUtils.verifyValueBounds(DateTimeFieldType.minuteOfHour(), i6, 0, 59);
        FieldUtils.verifyValueBounds(DateTimeFieldType.secondOfMinute(), i7, 0, 59);
        FieldUtils.verifyValueBounds(DateTimeFieldType.millisOfSecond(), i8, 0, (int) MediaError.DetailedErrorCode.GENERIC);
        return getDateTimeMillis0(i2, i3, i4, (int) ((long) ((i5 * DateTimeConstants.MILLIS_PER_HOUR) + (i6 * DateTimeConstants.MILLIS_PER_MINUTE) + (i7 * 1000) + i8)));
    }

    /* access modifiers changed from: package-private */
    public int getDayOfMonth(long j2, int i2, int i3) {
        return ((int) ((j2 - (getYearMillis(i2) + getTotalMillisByYearMonth(i2, i3))) / SignalManager.TWENTY_FOUR_HOURS_MILLIS)) + 1;
    }
}
