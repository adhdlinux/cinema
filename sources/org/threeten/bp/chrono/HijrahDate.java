package org.threeten.bp.chrono;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class HijrahDate extends ChronoDateImpl<HijrahDate> {
    private static final Long[] ADJUSTED_CYCLES = new Long[MAX_ADJUSTED_CYCLE];
    private static final HashMap<Integer, Integer[]> ADJUSTED_CYCLE_YEARS = new HashMap<>();
    private static final Integer[] ADJUSTED_LEAST_MAX_VALUES = new Integer[LEAST_MAX_VALUES.length];
    private static final Integer[] ADJUSTED_MAX_VALUES = new Integer[MAX_VALUES.length];
    private static final Integer[] ADJUSTED_MIN_VALUES = new Integer[MIN_VALUES.length];
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_DAYS = new HashMap<>();
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_LENGTHS = new HashMap<>();
    private static final int[] CYCLEYEAR_START_DATE = {0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
    private static final String DEFAULT_CONFIG_FILENAME = "hijrah_deviation.cfg";
    private static final String DEFAULT_CONFIG_PATH;
    private static final Integer[] DEFAULT_CYCLE_YEARS = new Integer[CYCLEYEAR_START_DATE.length];
    private static final Integer[] DEFAULT_LEAP_MONTH_DAYS = new Integer[LEAP_NUM_DAYS.length];
    private static final Integer[] DEFAULT_LEAP_MONTH_LENGTHS = new Integer[LEAP_MONTH_LENGTH.length];
    private static final Integer[] DEFAULT_MONTH_DAYS;
    private static final Integer[] DEFAULT_MONTH_LENGTHS = new Integer[MONTH_LENGTH.length];
    private static final char FILE_SEP;
    private static final int HIJRAH_JAN_1_1_GREGORIAN_DAY = -492148;
    private static final int[] LEAP_MONTH_LENGTH = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
    private static final int[] LEAP_NUM_DAYS = {0, 30, 59, 89, 118, 148, 177, Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE, 236, 266, 295, 325};
    private static final int[] LEAST_MAX_VALUES = {1, MAX_VALUE_OF_ERA, 11, 51, 5, 29, 354};
    private static final int MAX_ADJUSTED_CYCLE = 334;
    private static final int[] MAX_VALUES = {1, MAX_VALUE_OF_ERA, 11, 52, 6, 30, 355};
    public static final int MAX_VALUE_OF_ERA = 9999;
    private static final int[] MIN_VALUES = {0, 1, 0, 1, 0, 1, 1};
    public static final int MIN_VALUE_OF_ERA = 1;
    private static final int[] MONTH_LENGTH = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
    private static final int[] NUM_DAYS;
    private static final String PATH_SEP = File.pathSeparator;
    private static final int POSITION_DAY_OF_MONTH = 5;
    private static final int POSITION_DAY_OF_YEAR = 6;
    private static final long serialVersionUID = -5207853542612002020L;
    private final transient int dayOfMonth;
    private final transient DayOfWeek dayOfWeek;
    private final transient int dayOfYear;
    private final transient HijrahEra era;
    private final long gregorianEpochDay;
    private final transient boolean isLeapYear;
    private final transient int monthOfYear;
    private final transient int yearOfEra;

    /* renamed from: org.threeten.bp.chrono.HijrahDate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x006c }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.HijrahDate.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        int[] iArr = {0, 30, 59, 89, 118, 148, 177, Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE, 236, 266, 295, 325};
        NUM_DAYS = iArr;
        char c2 = File.separatorChar;
        FILE_SEP = c2;
        DEFAULT_CONFIG_PATH = "org" + c2 + "threeten" + c2 + "bp" + c2 + "chrono";
        DEFAULT_MONTH_DAYS = new Integer[iArr.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr2 = NUM_DAYS;
            if (i3 >= iArr2.length) {
                break;
            }
            DEFAULT_MONTH_DAYS[i3] = Integer.valueOf(iArr2[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            int[] iArr3 = LEAP_NUM_DAYS;
            if (i4 >= iArr3.length) {
                break;
            }
            DEFAULT_LEAP_MONTH_DAYS[i4] = Integer.valueOf(iArr3[i4]);
            i4++;
        }
        int i5 = 0;
        while (true) {
            int[] iArr4 = MONTH_LENGTH;
            if (i5 >= iArr4.length) {
                break;
            }
            DEFAULT_MONTH_LENGTHS[i5] = Integer.valueOf(iArr4[i5]);
            i5++;
        }
        int i6 = 0;
        while (true) {
            int[] iArr5 = LEAP_MONTH_LENGTH;
            if (i6 >= iArr5.length) {
                break;
            }
            DEFAULT_LEAP_MONTH_LENGTHS[i6] = Integer.valueOf(iArr5[i6]);
            i6++;
        }
        int i7 = 0;
        while (true) {
            int[] iArr6 = CYCLEYEAR_START_DATE;
            if (i7 >= iArr6.length) {
                break;
            }
            DEFAULT_CYCLE_YEARS[i7] = Integer.valueOf(iArr6[i7]);
            i7++;
        }
        int i8 = 0;
        while (true) {
            Long[] lArr = ADJUSTED_CYCLES;
            if (i8 >= lArr.length) {
                break;
            }
            lArr[i8] = Long.valueOf((long) (i8 * 10631));
            i8++;
        }
        int i9 = 0;
        while (true) {
            int[] iArr7 = MIN_VALUES;
            if (i9 >= iArr7.length) {
                break;
            }
            ADJUSTED_MIN_VALUES[i9] = Integer.valueOf(iArr7[i9]);
            i9++;
        }
        int i10 = 0;
        while (true) {
            int[] iArr8 = LEAST_MAX_VALUES;
            if (i10 >= iArr8.length) {
                break;
            }
            ADJUSTED_LEAST_MAX_VALUES[i10] = Integer.valueOf(iArr8[i10]);
            i10++;
        }
        while (true) {
            int[] iArr9 = MAX_VALUES;
            if (i2 < iArr9.length) {
                ADJUSTED_MAX_VALUES[i2] = Integer.valueOf(iArr9[i2]);
                i2++;
            } else {
                try {
                    readDeviationConfig();
                    return;
                } catch (IOException | ParseException unused) {
                    return;
                }
            }
        }
    }

    private HijrahDate(long j2) {
        int[] hijrahDateInfo = getHijrahDateInfo(j2);
        checkValidYearOfEra(hijrahDateInfo[1]);
        checkValidMonth(hijrahDateInfo[2]);
        checkValidDayOfMonth(hijrahDateInfo[3]);
        checkValidDayOfYear(hijrahDateInfo[4]);
        this.era = HijrahEra.of(hijrahDateInfo[0]);
        int i2 = hijrahDateInfo[1];
        this.yearOfEra = i2;
        this.monthOfYear = hijrahDateInfo[2];
        this.dayOfMonth = hijrahDateInfo[3];
        this.dayOfYear = hijrahDateInfo[4];
        this.dayOfWeek = DayOfWeek.of(hijrahDateInfo[5]);
        this.gregorianEpochDay = j2;
        this.isLeapYear = isLeapYear((long) i2);
    }

    private static void addDeviationAsHijrah(int i2, int i3, int i4, int i5, int i6) {
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        int i11 = i6;
        if (i7 < 1) {
            throw new IllegalArgumentException("startYear < 1");
        } else if (i9 < 1) {
            throw new IllegalArgumentException("endYear < 1");
        } else if (i8 < 0 || i8 > 11) {
            throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
        } else if (i10 < 0 || i10 > 11) {
            throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
        } else if (i9 > 9999) {
            throw new IllegalArgumentException("endYear > 9999");
        } else if (i9 < i7) {
            throw new IllegalArgumentException("startYear > endYear");
        } else if (i9 != i7 || i10 >= i8) {
            boolean isLeapYear2 = isLeapYear((long) i7);
            Integer[] numArr = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i2));
            if (numArr == null) {
                if (!isLeapYear2) {
                    numArr = new Integer[NUM_DAYS.length];
                    int i12 = 0;
                    while (true) {
                        int[] iArr = NUM_DAYS;
                        if (i12 >= iArr.length) {
                            break;
                        }
                        numArr[i12] = Integer.valueOf(iArr[i12]);
                        i12++;
                    }
                } else {
                    numArr = new Integer[LEAP_NUM_DAYS.length];
                    int i13 = 0;
                    while (true) {
                        int[] iArr2 = LEAP_NUM_DAYS;
                        if (i13 >= iArr2.length) {
                            break;
                        }
                        numArr[i13] = Integer.valueOf(iArr2[i13]);
                        i13++;
                    }
                }
            }
            Integer[] numArr2 = new Integer[numArr.length];
            for (int i14 = 0; i14 < 12; i14++) {
                if (i14 > i8) {
                    numArr2[i14] = Integer.valueOf(numArr[i14].intValue() - i11);
                } else {
                    numArr2[i14] = Integer.valueOf(numArr[i14].intValue());
                }
            }
            ADJUSTED_MONTH_DAYS.put(Integer.valueOf(i2), numArr2);
            Integer[] numArr3 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i2));
            if (numArr3 == null) {
                if (!isLeapYear2) {
                    numArr3 = new Integer[MONTH_LENGTH.length];
                    int i15 = 0;
                    while (true) {
                        int[] iArr3 = MONTH_LENGTH;
                        if (i15 >= iArr3.length) {
                            break;
                        }
                        numArr3[i15] = Integer.valueOf(iArr3[i15]);
                        i15++;
                    }
                } else {
                    numArr3 = new Integer[LEAP_MONTH_LENGTH.length];
                    int i16 = 0;
                    while (true) {
                        int[] iArr4 = LEAP_MONTH_LENGTH;
                        if (i16 >= iArr4.length) {
                            break;
                        }
                        numArr3[i16] = Integer.valueOf(iArr4[i16]);
                        i16++;
                    }
                }
            }
            Integer[] numArr4 = new Integer[numArr3.length];
            for (int i17 = 0; i17 < 12; i17++) {
                if (i17 == i8) {
                    numArr4[i17] = Integer.valueOf(numArr3[i17].intValue() - i11);
                } else {
                    numArr4[i17] = Integer.valueOf(numArr3[i17].intValue());
                }
            }
            ADJUSTED_MONTH_LENGTHS.put(Integer.valueOf(i2), numArr4);
            if (i7 != i9) {
                int i18 = i7 - 1;
                int i19 = i18 / 30;
                int i20 = i18 % 30;
                Integer[] numArr5 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i19));
                if (numArr5 == null) {
                    int length = CYCLEYEAR_START_DATE.length;
                    Integer[] numArr6 = new Integer[length];
                    for (int i21 = 0; i21 < length; i21++) {
                        numArr6[i21] = Integer.valueOf(CYCLEYEAR_START_DATE[i21]);
                    }
                    numArr5 = numArr6;
                }
                for (int i22 = i20 + 1; i22 < CYCLEYEAR_START_DATE.length; i22++) {
                    numArr5[i22] = Integer.valueOf(numArr5[i22].intValue() - i11);
                }
                ADJUSTED_CYCLE_YEARS.put(Integer.valueOf(i19), numArr5);
                int i23 = i9 - 1;
                int i24 = i23 / 30;
                if (i19 != i24) {
                    int i25 = i19 + 1;
                    while (true) {
                        Long[] lArr = ADJUSTED_CYCLES;
                        if (i25 >= lArr.length) {
                            break;
                        }
                        lArr[i25] = Long.valueOf(lArr[i25].longValue() - ((long) i11));
                        i25++;
                    }
                    int i26 = i24 + 1;
                    while (true) {
                        Long[] lArr2 = ADJUSTED_CYCLES;
                        if (i26 >= lArr2.length) {
                            break;
                        }
                        lArr2[i26] = Long.valueOf(lArr2[i26].longValue() + ((long) i11));
                        i26++;
                        i24 = i24;
                    }
                }
                int i27 = i24;
                int i28 = i23 % 30;
                Integer[] numArr7 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i27));
                if (numArr7 == null) {
                    int length2 = CYCLEYEAR_START_DATE.length;
                    Integer[] numArr8 = new Integer[length2];
                    for (int i29 = 0; i29 < length2; i29++) {
                        numArr8[i29] = Integer.valueOf(CYCLEYEAR_START_DATE[i29]);
                    }
                    numArr7 = numArr8;
                }
                for (int i30 = i28 + 1; i30 < CYCLEYEAR_START_DATE.length; i30++) {
                    numArr7[i30] = Integer.valueOf(numArr7[i30].intValue() + i11);
                }
                ADJUSTED_CYCLE_YEARS.put(Integer.valueOf(i27), numArr7);
            }
            boolean isLeapYear3 = isLeapYear((long) i9);
            Integer[] numArr9 = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i4));
            if (numArr9 == null) {
                if (!isLeapYear3) {
                    numArr9 = new Integer[NUM_DAYS.length];
                    int i31 = 0;
                    while (true) {
                        int[] iArr5 = NUM_DAYS;
                        if (i31 >= iArr5.length) {
                            break;
                        }
                        numArr9[i31] = Integer.valueOf(iArr5[i31]);
                        i31++;
                    }
                } else {
                    numArr9 = new Integer[LEAP_NUM_DAYS.length];
                    int i32 = 0;
                    while (true) {
                        int[] iArr6 = LEAP_NUM_DAYS;
                        if (i32 >= iArr6.length) {
                            break;
                        }
                        numArr9[i32] = Integer.valueOf(iArr6[i32]);
                        i32++;
                    }
                }
            }
            Integer[] numArr10 = new Integer[numArr9.length];
            for (int i33 = 0; i33 < 12; i33++) {
                if (i33 > i10) {
                    numArr10[i33] = Integer.valueOf(numArr9[i33].intValue() + i11);
                } else {
                    numArr10[i33] = Integer.valueOf(numArr9[i33].intValue());
                }
            }
            ADJUSTED_MONTH_DAYS.put(Integer.valueOf(i4), numArr10);
            Integer[] numArr11 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i4));
            if (numArr11 == null) {
                if (!isLeapYear3) {
                    numArr11 = new Integer[MONTH_LENGTH.length];
                    int i34 = 0;
                    while (true) {
                        int[] iArr7 = MONTH_LENGTH;
                        if (i34 >= iArr7.length) {
                            break;
                        }
                        numArr11[i34] = Integer.valueOf(iArr7[i34]);
                        i34++;
                    }
                } else {
                    numArr11 = new Integer[LEAP_MONTH_LENGTH.length];
                    int i35 = 0;
                    while (true) {
                        int[] iArr8 = LEAP_MONTH_LENGTH;
                        if (i35 >= iArr8.length) {
                            break;
                        }
                        numArr11[i35] = Integer.valueOf(iArr8[i35]);
                        i35++;
                    }
                }
            }
            Integer[] numArr12 = new Integer[numArr11.length];
            for (int i36 = 0; i36 < 12; i36++) {
                if (i36 == i10) {
                    numArr12[i36] = Integer.valueOf(numArr11[i36].intValue() + i11);
                } else {
                    numArr12[i36] = Integer.valueOf(numArr11[i36].intValue());
                }
            }
            HashMap<Integer, Integer[]> hashMap = ADJUSTED_MONTH_LENGTHS;
            hashMap.put(Integer.valueOf(i4), numArr12);
            Integer[] numArr13 = hashMap.get(Integer.valueOf(i2));
            Integer[] numArr14 = hashMap.get(Integer.valueOf(i4));
            HashMap<Integer, Integer[]> hashMap2 = ADJUSTED_MONTH_DAYS;
            int intValue = numArr13[i8].intValue();
            int intValue2 = numArr14[i10].intValue();
            int intValue3 = hashMap2.get(Integer.valueOf(i2))[11].intValue() + numArr13[11].intValue();
            int intValue4 = hashMap2.get(Integer.valueOf(i4))[11].intValue() + numArr14[11].intValue();
            Integer[] numArr15 = ADJUSTED_MAX_VALUES;
            int intValue5 = numArr15[5].intValue();
            Integer[] numArr16 = ADJUSTED_LEAST_MAX_VALUES;
            int intValue6 = numArr16[5].intValue();
            if (intValue5 < intValue) {
                intValue5 = intValue;
            }
            if (intValue5 < intValue2) {
                intValue5 = intValue2;
            }
            numArr15[5] = Integer.valueOf(intValue5);
            if (intValue6 <= intValue) {
                intValue = intValue6;
            }
            if (intValue <= intValue2) {
                intValue2 = intValue;
            }
            numArr16[5] = Integer.valueOf(intValue2);
            int intValue7 = numArr15[6].intValue();
            int intValue8 = numArr16[6].intValue();
            if (intValue7 < intValue3) {
                intValue7 = intValue3;
            }
            if (intValue7 < intValue4) {
                intValue7 = intValue4;
            }
            numArr15[6] = Integer.valueOf(intValue7);
            if (intValue8 <= intValue3) {
                intValue3 = intValue8;
            }
            if (intValue3 <= intValue4) {
                intValue4 = intValue3;
            }
            numArr16[6] = Integer.valueOf(intValue4);
        } else {
            throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
        }
    }

    private static void checkValidDayOfMonth(int i2) {
        if (i2 < 1 || i2 > getMaximumDayOfMonth()) {
            throw new DateTimeException("Invalid day of month of Hijrah date, day " + i2 + " greater than " + getMaximumDayOfMonth() + " or less than 1");
        }
    }

    private static void checkValidDayOfYear(int i2) {
        if (i2 < 1 || i2 > getMaximumDayOfYear()) {
            throw new DateTimeException("Invalid day of year of Hijrah date");
        }
    }

    private static void checkValidMonth(int i2) {
        if (i2 < 1 || i2 > 12) {
            throw new DateTimeException("Invalid month of Hijrah date");
        }
    }

    private static void checkValidYearOfEra(int i2) {
        if (i2 < 1 || i2 > 9999) {
            throw new DateTimeException("Invalid year of Hijrah Era");
        }
    }

    public static HijrahDate from(TemporalAccessor temporalAccessor) {
        return HijrahChronology.INSTANCE.date(temporalAccessor);
    }

    private static Integer[] getAdjustedCycle(int i2) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr == null) {
            return DEFAULT_CYCLE_YEARS;
        }
        return numArr;
    }

    private static Integer[] getAdjustedMonthDays(int i2) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            return numArr;
        }
        if (isLeapYear((long) i2)) {
            return DEFAULT_LEAP_MONTH_DAYS;
        }
        return DEFAULT_MONTH_DAYS;
    }

    private static Integer[] getAdjustedMonthLength(int i2) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            return numArr;
        }
        if (isLeapYear((long) i2)) {
            return DEFAULT_LEAP_MONTH_LENGTHS;
        }
        return DEFAULT_MONTH_LENGTHS;
    }

    private static InputStream getConfigFileInputStream() throws IOException {
        ZipFile zipFile;
        String property = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (property == null) {
            property = DEFAULT_CONFIG_FILENAME;
        }
        String property2 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        if (property2 != null) {
            if (property2.length() != 0 || !property2.endsWith(System.getProperty("file.separator"))) {
                property2 = property2 + System.getProperty("file.separator");
            }
            File file = new File(property2 + FILE_SEP + property);
            if (!file.exists()) {
                return null;
            }
            try {
                return new FileInputStream(file);
            } catch (IOException e2) {
                throw e2;
            }
        } else {
            StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), PATH_SEP);
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                File file2 = new File(nextToken);
                if (file2.exists()) {
                    if (file2.isDirectory()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(nextToken);
                        char c2 = FILE_SEP;
                        sb.append(c2);
                        String str = DEFAULT_CONFIG_PATH;
                        sb.append(str);
                        if (new File(sb.toString(), property).exists()) {
                            try {
                                return new FileInputStream(nextToken + c2 + str + c2 + property);
                            } catch (IOException e3) {
                                throw e3;
                            }
                        }
                    } else {
                        try {
                            zipFile = new ZipFile(file2);
                        } catch (IOException unused) {
                            zipFile = null;
                        }
                        if (zipFile != null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(DEFAULT_CONFIG_PATH);
                            char c3 = FILE_SEP;
                            sb2.append(c3);
                            sb2.append(property);
                            String sb3 = sb2.toString();
                            ZipEntry entry = zipFile.getEntry(sb3);
                            if (entry == null) {
                                if (c3 == '/') {
                                    sb3 = sb3.replace('/', '\\');
                                } else if (c3 == '\\') {
                                    sb3 = sb3.replace('\\', '/');
                                }
                                entry = zipFile.getEntry(sb3);
                            }
                            if (entry != null) {
                                try {
                                    return zipFile.getInputStream(entry);
                                } catch (IOException e4) {
                                    throw e4;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return null;
        }
    }

    private static int getCycleNumber(long j2) {
        Long[] lArr = ADJUSTED_CYCLES;
        int i2 = 0;
        while (i2 < lArr.length) {
            try {
                if (j2 < lArr[i2].longValue()) {
                    return i2 - 1;
                }
                i2++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                return ((int) j2) / 10631;
            }
        }
        return ((int) j2) / 10631;
    }

    private static int getDayOfCycle(long j2, int i2) {
        Long l2;
        try {
            l2 = ADJUSTED_CYCLES[i2];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l2 = null;
        }
        if (l2 == null) {
            l2 = Long.valueOf((long) (i2 * 10631));
        }
        return (int) (j2 - l2.longValue());
    }

    private static int getDayOfMonth(int i2, int i3, int i4) {
        int intValue;
        Integer[] adjustedMonthDays = getAdjustedMonthDays(i4);
        if (i2 < 0) {
            if (isLeapYear((long) i4)) {
                i2 += 355;
            } else {
                i2 += 354;
            }
            if (i3 <= 0) {
                return i2;
            }
            intValue = adjustedMonthDays[i3].intValue();
        } else if (i3 <= 0) {
            return i2;
        } else {
            intValue = adjustedMonthDays[i3].intValue();
        }
        return i2 - intValue;
    }

    private static int getDayOfYear(int i2, int i3, int i4) {
        Integer[] adjustedCycle = getAdjustedCycle(i2);
        if (i3 > 0) {
            return i3 - adjustedCycle[i4].intValue();
        }
        return adjustedCycle[i4].intValue() + i3;
    }

    private static long getGregorianEpochDay(int i2, int i3, int i4) {
        return yearToGregorianEpochDay(i2) + ((long) getMonthDays(i3 - 1, i2)) + ((long) i4);
    }

    private static int[] getHijrahDateInfo(long j2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j3 = j2 - -492148;
        if (j3 >= 0) {
            int cycleNumber = getCycleNumber(j3);
            int dayOfCycle = getDayOfCycle(j3, cycleNumber);
            int yearInCycle = getYearInCycle(cycleNumber, (long) dayOfCycle);
            i5 = getDayOfYear(cycleNumber, dayOfCycle, yearInCycle);
            i6 = (cycleNumber * 30) + yearInCycle + 1;
            i4 = getMonthOfYear(i5, i6);
            i3 = getDayOfMonth(i5, i4, i6) + 1;
            i2 = HijrahEra.AH.getValue();
        } else {
            int i9 = (int) j3;
            int i10 = i9 / 10631;
            int i11 = i9 % 10631;
            if (i11 == 0) {
                i10++;
                i11 = -10631;
            }
            int yearInCycle2 = getYearInCycle(i10, (long) i11);
            int dayOfYear2 = getDayOfYear(i10, i11, yearInCycle2);
            int i12 = 1 - ((i10 * 30) - yearInCycle2);
            if (isLeapYear((long) i12)) {
                i8 = dayOfYear2 + 355;
            } else {
                i8 = dayOfYear2 + 354;
            }
            i4 = getMonthOfYear(i8, i12);
            i3 = getDayOfMonth(i8, i4, i12) + 1;
            i2 = HijrahEra.BEFORE_AH.getValue();
            int i13 = i12;
            i5 = i8;
            i6 = i13;
        }
        int i14 = (int) ((j3 + 5) % 7);
        if (i14 <= 0) {
            i7 = 7;
        } else {
            i7 = 0;
        }
        return new int[]{i2, i6, i4 + 1, i3, i5 + 1, i14 + i7};
    }

    static int getMaximumDayOfMonth() {
        return ADJUSTED_MAX_VALUES[5].intValue();
    }

    static int getMaximumDayOfYear() {
        return ADJUSTED_MAX_VALUES[6].intValue();
    }

    private static int getMonthDays(int i2, int i3) {
        return getAdjustedMonthDays(i3)[i2].intValue();
    }

    static int getMonthLength(int i2, int i3) {
        return getAdjustedMonthLength(i3)[i2].intValue();
    }

    private static int getMonthOfYear(int i2, int i3) {
        int i4;
        Integer[] adjustedMonthDays = getAdjustedMonthDays(i3);
        int i5 = 0;
        if (i2 >= 0) {
            while (i5 < adjustedMonthDays.length) {
                if (i2 < adjustedMonthDays[i5].intValue()) {
                    return i5 - 1;
                }
                i5++;
            }
            return 11;
        }
        if (isLeapYear((long) i3)) {
            i4 = i2 + 355;
        } else {
            i4 = i2 + 354;
        }
        while (i5 < adjustedMonthDays.length) {
            if (i4 < adjustedMonthDays[i5].intValue()) {
                return i5 - 1;
            }
            i5++;
        }
        return 11;
    }

    static int getSmallestMaximumDayOfMonth() {
        return ADJUSTED_LEAST_MAX_VALUES[5].intValue();
    }

    static int getSmallestMaximumDayOfYear() {
        return ADJUSTED_LEAST_MAX_VALUES[6].intValue();
    }

    private static int getYearInCycle(int i2, long j2) {
        Integer[] adjustedCycle = getAdjustedCycle(i2);
        int i3 = 0;
        int i4 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i4 == 0) {
            return 0;
        }
        if (i4 > 0) {
            while (i3 < adjustedCycle.length) {
                if (j2 < ((long) adjustedCycle[i3].intValue())) {
                    return i3 - 1;
                }
                i3++;
            }
            return 29;
        }
        long j3 = -j2;
        while (i3 < adjustedCycle.length) {
            if (j3 <= ((long) adjustedCycle[i3].intValue())) {
                return i3 - 1;
            }
            i3++;
        }
        return 29;
    }

    static int getYearLength(int i2) {
        Integer[] numArr;
        int i3 = i2 - 1;
        int i4 = i3 / 30;
        try {
            numArr = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i4));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            int i5 = i3 % 30;
            if (i5 != 29) {
                return numArr[i5 + 1].intValue() - numArr[i5].intValue();
            }
            Long[] lArr = ADJUSTED_CYCLES;
            return (lArr[i4 + 1].intValue() - lArr[i4].intValue()) - numArr[i5].intValue();
        } else if (isLeapYear((long) i2)) {
            return 355;
        } else {
            return 354;
        }
    }

    public static HijrahDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static HijrahDate of(int i2, int i3, int i4) {
        if (i2 >= 1) {
            return of(HijrahEra.AH, i2, i3, i4);
        }
        return of(HijrahEra.BEFORE_AH, 1 - i2, i3, i4);
    }

    static HijrahDate ofEpochDay(long j2) {
        return new HijrahDate(j2);
    }

    private static void parseLine(String str, int i2) throws ParseException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(58);
            if (indexOf != -1) {
                try {
                    int parseInt = Integer.parseInt(nextToken.substring(indexOf + 1, nextToken.length()));
                    int indexOf2 = nextToken.indexOf(45);
                    if (indexOf2 != -1) {
                        String substring = nextToken.substring(0, indexOf2);
                        String substring2 = nextToken.substring(indexOf2 + 1, indexOf);
                        int indexOf3 = substring.indexOf(47);
                        int indexOf4 = substring2.indexOf(47);
                        if (indexOf3 != -1) {
                            String substring3 = substring.substring(0, indexOf3);
                            String substring4 = substring.substring(indexOf3 + 1, substring.length());
                            try {
                                int parseInt2 = Integer.parseInt(substring3);
                                try {
                                    int parseInt3 = Integer.parseInt(substring4);
                                    if (indexOf4 != -1) {
                                        String substring5 = substring2.substring(0, indexOf4);
                                        String substring6 = substring2.substring(indexOf4 + 1, substring2.length());
                                        try {
                                            int parseInt4 = Integer.parseInt(substring5);
                                            try {
                                                int parseInt5 = Integer.parseInt(substring6);
                                                if (parseInt2 == -1 || parseInt3 == -1 || parseInt4 == -1 || parseInt5 == -1) {
                                                    throw new ParseException("Unknown error at line " + i2 + ".", i2);
                                                }
                                                addDeviationAsHijrah(parseInt2, parseInt3, parseInt4, parseInt5, parseInt);
                                            } catch (NumberFormatException unused) {
                                                throw new ParseException("End month is not properly set at line " + i2 + ".", i2);
                                            }
                                        } catch (NumberFormatException unused2) {
                                            throw new ParseException("End year is not properly set at line " + i2 + ".", i2);
                                        }
                                    } else {
                                        throw new ParseException("End year/month has incorrect format at line " + i2 + ".", i2);
                                    }
                                } catch (NumberFormatException unused3) {
                                    throw new ParseException("Start month is not properly set at line " + i2 + ".", i2);
                                }
                            } catch (NumberFormatException unused4) {
                                throw new ParseException("Start year is not properly set at line " + i2 + ".", i2);
                            }
                        } else {
                            throw new ParseException("Start year/month has incorrect format at line " + i2 + ".", i2);
                        }
                    } else {
                        throw new ParseException("Start and end year/month has incorrect format at line " + i2 + ".", i2);
                    }
                } catch (NumberFormatException unused5) {
                    throw new ParseException("Offset is not properly set at line " + i2 + ".", i2);
                }
            } else {
                throw new ParseException("Offset has incorrect format at line " + i2 + ".", i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void readDeviationConfig() throws java.io.IOException, java.text.ParseException {
        /*
            java.io.InputStream r0 = getConfigFileInputStream()
            if (r0 == 0) goto L_0x0030
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0029 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0029 }
            r3.<init>(r0)     // Catch:{ all -> 0x0029 }
            r2.<init>(r3)     // Catch:{ all -> 0x0029 }
            r0 = 0
        L_0x0012:
            java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0022
            int r0 = r0 + 1
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0026 }
            parseLine(r1, r0)     // Catch:{ all -> 0x0026 }
            goto L_0x0012
        L_0x0022:
            r2.close()
            goto L_0x0030
        L_0x0026:
            r0 = move-exception
            r1 = r2
            goto L_0x002a
        L_0x0029:
            r0 = move-exception
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            throw r0
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.HijrahDate.readDeviationConfig():void");
    }

    static ChronoLocalDate readExternal(DataInput dataInput) throws IOException {
        return HijrahChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    private Object readResolve() {
        return new HijrahDate(this.gregorianEpochDay);
    }

    private static HijrahDate resolvePreviousValid(int i2, int i3, int i4) {
        int monthDays = getMonthDays(i3 - 1, i2);
        if (i4 > monthDays) {
            i4 = monthDays;
        }
        return of(i2, i3, i4);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    private static long yearToGregorianEpochDay(int i2) {
        Long l2;
        int i3 = i2 - 1;
        int i4 = i3 / 30;
        int i5 = i3 % 30;
        int intValue = getAdjustedCycle(i4)[Math.abs(i5)].intValue();
        if (i5 < 0) {
            intValue = -intValue;
        }
        try {
            l2 = ADJUSTED_CYCLES[i4];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l2 = null;
        }
        if (l2 == null) {
            l2 = Long.valueOf((long) (i4 * 10631));
        }
        return ((l2.longValue() + ((long) intValue)) - 492148) - 1;
    }

    public final ChronoLocalDateTime<HijrahDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    public long getLong(TemporalField temporalField) {
        int i2;
        int i3;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        switch (AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                i2 = this.dayOfMonth;
                break;
            case 2:
                i2 = this.dayOfYear;
                break;
            case 3:
                i3 = (this.dayOfMonth - 1) / 7;
                break;
            case 4:
                i2 = this.yearOfEra;
                break;
            case 5:
                i2 = this.dayOfWeek.getValue();
                break;
            case 6:
                i3 = (this.dayOfMonth - 1) % 7;
                break;
            case 7:
                i3 = (this.dayOfYear - 1) % 7;
                break;
            case 8:
                return toEpochDay();
            case 9:
                i3 = (this.dayOfYear - 1) / 7;
                break;
            case 10:
                i2 = this.monthOfYear;
                break;
            case 11:
                i2 = this.yearOfEra;
                break;
            case 12:
                i2 = this.era.getValue();
                break;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        i2 = i3 + 1;
        return (long) i2;
    }

    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    public int lengthOfMonth() {
        return getMonthLength(this.monthOfYear - 1, this.yearOfEra);
    }

    public int lengthOfYear() {
        return getYearLength(this.yearOfEra);
    }

    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (isSupported(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i2 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i2 == 1) {
                return ValueRange.of(1, (long) lengthOfMonth());
            }
            if (i2 == 2) {
                return ValueRange.of(1, (long) lengthOfYear());
            }
            if (i2 == 3) {
                return ValueRange.of(1, 5);
            }
            if (i2 != 4) {
                return getChronology().range(chronoField);
            }
            return ValueRange.of(1, 1000);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long toEpochDay() {
        return getGregorianEpochDay(this.yearOfEra, this.monthOfYear, this.dayOfMonth);
    }

    public /* bridge */ /* synthetic */ long until(Temporal temporal, TemporalUnit temporalUnit) {
        return super.until(temporal, temporalUnit);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    static boolean isLeapYear(long j2) {
        if (j2 <= 0) {
            j2 = -j2;
        }
        return ((j2 * 11) + 14) % 30 < 11;
    }

    public static HijrahDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public HijrahChronology getChronology() {
        return HijrahChronology.INSTANCE;
    }

    public HijrahEra getEra() {
        return this.era;
    }

    /* access modifiers changed from: package-private */
    public HijrahDate plusDays(long j2) {
        return new HijrahDate(this.gregorianEpochDay + j2);
    }

    /* access modifiers changed from: package-private */
    public HijrahDate plusMonths(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.monthOfYear - 1) + ((int) j2);
        int i3 = i2 / 12;
        int i4 = i2 % 12;
        while (i4 < 0) {
            i4 += 12;
            i3 = Jdk8Methods.safeSubtract(i3, 1);
        }
        return of(this.era, Jdk8Methods.safeAdd(this.yearOfEra, i3), i4 + 1, this.dayOfMonth);
    }

    /* access modifiers changed from: package-private */
    public HijrahDate plusYears(long j2) {
        if (j2 == 0) {
            return this;
        }
        return of(this.era, Jdk8Methods.safeAdd(this.yearOfEra, (int) j2), this.monthOfYear, this.dayOfMonth);
    }

    public /* bridge */ /* synthetic */ ChronoPeriod until(ChronoLocalDate chronoLocalDate) {
        return super.until(chronoLocalDate);
    }

    public static HijrahDate now(Clock clock) {
        return HijrahChronology.INSTANCE.dateNow(clock);
    }

    static HijrahDate of(HijrahEra hijrahEra, int i2, int i3, int i4) {
        Jdk8Methods.requireNonNull(hijrahEra, "era");
        checkValidYearOfEra(i2);
        checkValidMonth(i3);
        checkValidDayOfMonth(i4);
        return new HijrahDate(getGregorianEpochDay(hijrahEra.prolepticYear(i2), i3, i4));
    }

    public HijrahDate minus(TemporalAmount temporalAmount) {
        return (HijrahDate) super.minus(temporalAmount);
    }

    public HijrahDate with(TemporalAdjuster temporalAdjuster) {
        return (HijrahDate) super.with(temporalAdjuster);
    }

    public HijrahDate minus(long j2, TemporalUnit temporalUnit) {
        return (HijrahDate) super.minus(j2, temporalUnit);
    }

    public HijrahDate plus(TemporalAmount temporalAmount) {
        return (HijrahDate) super.plus(temporalAmount);
    }

    public HijrahDate with(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (HijrahDate) temporalField.adjustInto(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j2);
        int i2 = (int) j2;
        switch (AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()]) {
            case 1:
                return resolvePreviousValid(this.yearOfEra, this.monthOfYear, i2);
            case 2:
                int i3 = i2 - 1;
                return resolvePreviousValid(this.yearOfEra, (i3 / 30) + 1, (i3 % 30) + 1);
            case 3:
                return plusDays((j2 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                if (this.yearOfEra < 1) {
                    i2 = 1 - i2;
                }
                return resolvePreviousValid(i2, this.monthOfYear, this.dayOfMonth);
            case 5:
                return plusDays(j2 - ((long) this.dayOfWeek.getValue()));
            case 6:
                return plusDays(j2 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return plusDays(j2 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return new HijrahDate((long) i2);
            case 9:
                return plusDays((j2 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 10:
                return resolvePreviousValid(this.yearOfEra, i2, this.dayOfMonth);
            case 11:
                return resolvePreviousValid(i2, this.monthOfYear, this.dayOfMonth);
            case 12:
                return resolvePreviousValid(1 - this.yearOfEra, this.monthOfYear, this.dayOfMonth);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public HijrahDate plus(long j2, TemporalUnit temporalUnit) {
        return (HijrahDate) super.plus(j2, temporalUnit);
    }

    static HijrahDate of(LocalDate localDate) {
        return new HijrahDate(localDate.toEpochDay());
    }
}
