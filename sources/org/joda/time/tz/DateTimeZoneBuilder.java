package org.joda.time.tz;

import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;

public class DateTimeZoneBuilder {
    private final ArrayList<RuleSet> iRuleSets = new ArrayList<>(10);

    private static final class DSTZone extends DateTimeZone {
        private static final long serialVersionUID = 6941492635554961361L;
        final Recurrence iEndRecurrence;
        final int iStandardOffset;
        final Recurrence iStartRecurrence;

        DSTZone(String str, int i2, Recurrence recurrence, Recurrence recurrence2) {
            super(str);
            this.iStandardOffset = i2;
            this.iStartRecurrence = recurrence;
            this.iEndRecurrence = recurrence2;
        }

        private Recurrence findMatchingRecurrence(long j2) {
            long j3;
            int i2 = this.iStandardOffset;
            Recurrence recurrence = this.iStartRecurrence;
            Recurrence recurrence2 = this.iEndRecurrence;
            try {
                j3 = recurrence.next(j2, i2, recurrence2.getSaveMillis());
            } catch (ArithmeticException | IllegalArgumentException unused) {
                j3 = j2;
            }
            try {
                j2 = recurrence2.next(j2, i2, recurrence.getSaveMillis());
            } catch (ArithmeticException | IllegalArgumentException unused2) {
            }
            if (j3 > j2) {
                return recurrence;
            }
            return recurrence2;
        }

        static DSTZone readFrom(DataInput dataInput, String str) throws IOException {
            return new DSTZone(str, (int) DateTimeZoneBuilder.readMillis(dataInput), Recurrence.readFrom(dataInput), Recurrence.readFrom(dataInput));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DSTZone)) {
                return false;
            }
            DSTZone dSTZone = (DSTZone) obj;
            if (!getID().equals(dSTZone.getID()) || this.iStandardOffset != dSTZone.iStandardOffset || !this.iStartRecurrence.equals(dSTZone.iStartRecurrence) || !this.iEndRecurrence.equals(dSTZone.iEndRecurrence)) {
                return false;
            }
            return true;
        }

        public String getNameKey(long j2) {
            return findMatchingRecurrence(j2).getNameKey();
        }

        public int getOffset(long j2) {
            return this.iStandardOffset + findMatchingRecurrence(j2).getSaveMillis();
        }

        public int getStandardOffset(long j2) {
            return this.iStandardOffset;
        }

        public boolean isFixed() {
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            if (r5 < 0) goto L_0x0018;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long nextTransition(long r9) {
            /*
                r8 = this;
                int r0 = r8.iStandardOffset
                org.joda.time.tz.DateTimeZoneBuilder$Recurrence r1 = r8.iStartRecurrence
                org.joda.time.tz.DateTimeZoneBuilder$Recurrence r2 = r8.iEndRecurrence
                r3 = 0
                int r5 = r2.getSaveMillis()     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0018 }
                long r5 = r1.next(r9, r0, r5)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0018 }
                int r7 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x0019
                int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r7 >= 0) goto L_0x0019
            L_0x0018:
                r5 = r9
            L_0x0019:
                int r1 = r1.getSaveMillis()     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002c }
                long r0 = r2.next(r9, r0, r1)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002c }
                int r2 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x002a
                int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r2 >= 0) goto L_0x002a
                goto L_0x002d
            L_0x002a:
                r9 = r0
                goto L_0x002d
            L_0x002c:
            L_0x002d:
                int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r0 <= 0) goto L_0x0032
                r5 = r9
            L_0x0032:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder.DSTZone.nextTransition(long):long");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            if (r7 > 0) goto L_0x001b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0035  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long previousTransition(long r11) {
            /*
                r10 = this;
                r0 = 1
                long r11 = r11 + r0
                int r2 = r10.iStandardOffset
                org.joda.time.tz.DateTimeZoneBuilder$Recurrence r3 = r10.iStartRecurrence
                org.joda.time.tz.DateTimeZoneBuilder$Recurrence r4 = r10.iEndRecurrence
                r5 = 0
                int r7 = r4.getSaveMillis()     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x001b }
                long r7 = r3.previous(r11, r2, r7)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x001b }
                int r9 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r9 >= 0) goto L_0x001c
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 <= 0) goto L_0x001c
            L_0x001b:
                r7 = r11
            L_0x001c:
                int r3 = r3.getSaveMillis()     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002f }
                long r2 = r4.previous(r11, r2, r3)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002f }
                int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r4 >= 0) goto L_0x002d
                int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r4 <= 0) goto L_0x002d
                goto L_0x0030
            L_0x002d:
                r11 = r2
                goto L_0x0030
            L_0x002f:
            L_0x0030:
                int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r2 <= 0) goto L_0x0035
                goto L_0x0036
            L_0x0035:
                r7 = r11
            L_0x0036:
                long r7 = r7 - r0
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder.DSTZone.previousTransition(long):long");
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iStandardOffset);
            this.iStartRecurrence.writeTo(dataOutput);
            this.iEndRecurrence.writeTo(dataOutput);
        }
    }

    private static final class OfYear {
        final boolean iAdvance;
        final int iDayOfMonth;
        final int iDayOfWeek;
        final int iMillisOfDay;
        final char iMode;
        final int iMonthOfYear;

        OfYear(char c2, int i2, int i3, int i4, boolean z2, int i5) {
            if (c2 == 'u' || c2 == 'w' || c2 == 's') {
                this.iMode = c2;
                this.iMonthOfYear = i2;
                this.iDayOfMonth = i3;
                this.iDayOfWeek = i4;
                this.iAdvance = z2;
                this.iMillisOfDay = i5;
                return;
            }
            throw new IllegalArgumentException("Unknown mode: " + c2);
        }

        static OfYear readFrom(DataInput dataInput) throws IOException {
            return new OfYear((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) DateTimeZoneBuilder.readMillis(dataInput));
        }

        private long setDayOfMonth(Chronology chronology, long j2) {
            if (this.iDayOfMonth >= 0) {
                return chronology.dayOfMonth().set(j2, this.iDayOfMonth);
            }
            return chronology.dayOfMonth().add(chronology.monthOfYear().add(chronology.dayOfMonth().set(j2, 1), 1), this.iDayOfMonth);
        }

        private long setDayOfMonthNext(Chronology chronology, long j2) {
            try {
                return setDayOfMonth(chronology, j2);
            } catch (IllegalArgumentException e2) {
                if (this.iMonthOfYear == 2 && this.iDayOfMonth == 29) {
                    while (!chronology.year().isLeap(j2)) {
                        j2 = chronology.year().add(j2, 1);
                    }
                    return setDayOfMonth(chronology, j2);
                }
                throw e2;
            }
        }

        private long setDayOfMonthPrevious(Chronology chronology, long j2) {
            try {
                return setDayOfMonth(chronology, j2);
            } catch (IllegalArgumentException e2) {
                if (this.iMonthOfYear == 2 && this.iDayOfMonth == 29) {
                    while (!chronology.year().isLeap(j2)) {
                        j2 = chronology.year().add(j2, -1);
                    }
                    return setDayOfMonth(chronology, j2);
                }
                throw e2;
            }
        }

        private long setDayOfWeek(Chronology chronology, long j2) {
            int i2 = this.iDayOfWeek - chronology.dayOfWeek().get(j2);
            if (i2 == 0) {
                return j2;
            }
            if (this.iAdvance) {
                if (i2 < 0) {
                    i2 += 7;
                }
            } else if (i2 > 0) {
                i2 -= 7;
            }
            return chronology.dayOfWeek().add(j2, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfYear)) {
                return false;
            }
            OfYear ofYear = (OfYear) obj;
            if (this.iMode == ofYear.iMode && this.iMonthOfYear == ofYear.iMonthOfYear && this.iDayOfMonth == ofYear.iDayOfMonth && this.iDayOfWeek == ofYear.iDayOfWeek && this.iAdvance == ofYear.iAdvance && this.iMillisOfDay == ofYear.iMillisOfDay) {
                return true;
            }
            return false;
        }

        public long next(long j2, int i2, int i3) {
            char c2 = this.iMode;
            if (c2 == 'w') {
                i2 += i3;
            } else if (c2 != 's') {
                i2 = 0;
            }
            long j3 = (long) i2;
            long j4 = j2 + j3;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long dayOfMonthNext = setDayOfMonthNext(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j4, this.iMonthOfYear), 0), this.iMillisOfDay));
            if (this.iDayOfWeek != 0) {
                dayOfMonthNext = setDayOfWeek(instanceUTC, dayOfMonthNext);
                if (dayOfMonthNext <= j4) {
                    dayOfMonthNext = setDayOfWeek(instanceUTC, setDayOfMonthNext(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(dayOfMonthNext, 1), this.iMonthOfYear)));
                }
            } else if (dayOfMonthNext <= j4) {
                dayOfMonthNext = setDayOfMonthNext(instanceUTC, instanceUTC.year().add(dayOfMonthNext, 1));
            }
            return dayOfMonthNext - j3;
        }

        public long previous(long j2, int i2, int i3) {
            char c2 = this.iMode;
            if (c2 == 'w') {
                i2 += i3;
            } else if (c2 != 's') {
                i2 = 0;
            }
            long j3 = (long) i2;
            long j4 = j2 + j3;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long dayOfMonthPrevious = setDayOfMonthPrevious(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j4, this.iMonthOfYear), 0), this.iMillisOfDay));
            if (this.iDayOfWeek != 0) {
                dayOfMonthPrevious = setDayOfWeek(instanceUTC, dayOfMonthPrevious);
                if (dayOfMonthPrevious >= j4) {
                    dayOfMonthPrevious = setDayOfWeek(instanceUTC, setDayOfMonthPrevious(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(dayOfMonthPrevious, -1), this.iMonthOfYear)));
                }
            } else if (dayOfMonthPrevious >= j4) {
                dayOfMonthPrevious = setDayOfMonthPrevious(instanceUTC, instanceUTC.year().add(dayOfMonthPrevious, -1));
            }
            return dayOfMonthPrevious - j3;
        }

        public long setInstant(int i2, int i3, int i4) {
            char c2 = this.iMode;
            if (c2 == 'w') {
                i3 += i4;
            } else if (c2 != 's') {
                i3 = 0;
            }
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long dayOfMonth = setDayOfMonth(instanceUTC, instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(instanceUTC.year().set(0, i2), this.iMonthOfYear), this.iMillisOfDay));
            if (this.iDayOfWeek != 0) {
                dayOfMonth = setDayOfWeek(instanceUTC, dayOfMonth);
            }
            return dayOfMonth - ((long) i3);
        }

        public String toString() {
            return "[OfYear]\nMode: " + this.iMode + 10 + "MonthOfYear: " + this.iMonthOfYear + 10 + "DayOfMonth: " + this.iDayOfMonth + 10 + "DayOfWeek: " + this.iDayOfWeek + 10 + "AdvanceDayOfWeek: " + this.iAdvance + 10 + "MillisOfDay: " + this.iMillisOfDay + 10;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(this.iMode);
            dataOutput.writeByte(this.iMonthOfYear);
            dataOutput.writeByte(this.iDayOfMonth);
            dataOutput.writeByte(this.iDayOfWeek);
            dataOutput.writeBoolean(this.iAdvance);
            DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iMillisOfDay);
        }
    }

    private static final class PrecalculatedZone extends DateTimeZone {
        private static final long serialVersionUID = 7811976468055766265L;
        private final String[] iNameKeys;
        private final int[] iStandardOffsets;
        private final DSTZone iTailZone;
        private final long[] iTransitions;
        private final int[] iWallOffsets;

        private PrecalculatedZone(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, DSTZone dSTZone) {
            super(str);
            this.iTransitions = jArr;
            this.iWallOffsets = iArr;
            this.iStandardOffsets = iArr2;
            this.iNameKeys = strArr;
            this.iTailZone = dSTZone;
        }

        static PrecalculatedZone create(String str, boolean z2, ArrayList<Transition> arrayList, DSTZone dSTZone) {
            DSTZone dSTZone2;
            String str2;
            DSTZone dSTZone3;
            String str3 = str;
            DSTZone dSTZone4 = dSTZone;
            int size = arrayList.size();
            if (size != 0) {
                long[] jArr = new long[size];
                int[] iArr = new int[size];
                int[] iArr2 = new int[size];
                String[] strArr = new String[size];
                int i2 = 0;
                Transition transition = null;
                int i3 = 0;
                while (i3 < size) {
                    Transition transition2 = arrayList.get(i3);
                    if (transition2.isTransitionFrom(transition)) {
                        jArr[i3] = transition2.getMillis();
                        iArr[i3] = transition2.getWallOffset();
                        iArr2[i3] = transition2.getStandardOffset();
                        strArr[i3] = transition2.getNameKey();
                        i3++;
                        transition = transition2;
                    } else {
                        throw new IllegalArgumentException(str3);
                    }
                }
                String[] strArr2 = new String[5];
                String[][] zoneStrings = new DateFormatSymbols(Locale.ENGLISH).getZoneStrings();
                for (String[] strArr3 : zoneStrings) {
                    if (strArr3 != null && strArr3.length == 5 && str3.equals(strArr3[0])) {
                        strArr2 = strArr3;
                    }
                }
                ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
                while (i2 < size - 1) {
                    String str4 = strArr[i2];
                    int i4 = i2 + 1;
                    String str5 = strArr[i4];
                    long j2 = (long) iArr[i2];
                    long j3 = (long) iArr[i4];
                    String[] strArr4 = strArr;
                    String[] strArr5 = strArr2;
                    long j4 = (long) iArr2[i2];
                    int[] iArr3 = iArr;
                    int[] iArr4 = iArr2;
                    long j5 = (long) iArr2[i4];
                    int i5 = size;
                    String str6 = str5;
                    Period period = new Period(jArr[i2], jArr[i4], PeriodType.yearMonthDay(), (Chronology) instanceUTC);
                    int i6 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                    if (i6 != 0 && j4 == j5 && str4.equals(str6) && period.getYears() == 0 && period.getMonths() > 4 && period.getMonths() < 8 && str4.equals(strArr5[2]) && str4.equals(strArr5[4])) {
                        if (ZoneInfoLogger.verbose()) {
                            System.out.println("Fixing duplicate name key - " + str6);
                            System.out.println("     - " + new DateTime(jArr[i2], (Chronology) instanceUTC) + " - " + new DateTime(jArr[i4], (Chronology) instanceUTC));
                        }
                        if (i6 > 0) {
                            strArr4[i2] = (str4 + "-Summer").intern();
                        } else if (i6 < 0) {
                            strArr4[i4] = (str6 + "-Summer").intern();
                            i2 = i4;
                        }
                    }
                    i2++;
                    String str7 = str;
                    strArr2 = strArr5;
                    dSTZone4 = dSTZone;
                    strArr = strArr4;
                    iArr = iArr3;
                    iArr2 = iArr4;
                    size = i5;
                }
                DSTZone dSTZone5 = dSTZone4;
                int[] iArr5 = iArr;
                int[] iArr6 = iArr2;
                String[] strArr6 = strArr;
                if (dSTZone5 == null || !dSTZone5.iStartRecurrence.getNameKey().equals(dSTZone5.iEndRecurrence.getNameKey())) {
                    dSTZone2 = dSTZone5;
                } else {
                    if (ZoneInfoLogger.verbose()) {
                        System.out.println("Fixing duplicate recurrent name key - " + dSTZone5.iStartRecurrence.getNameKey());
                    }
                    if (dSTZone5.iStartRecurrence.getSaveMillis() > 0) {
                        dSTZone3 = new DSTZone(dSTZone.getID(), dSTZone5.iStandardOffset, dSTZone5.iStartRecurrence.renameAppend("-Summer"), dSTZone5.iEndRecurrence);
                    } else {
                        dSTZone3 = new DSTZone(dSTZone.getID(), dSTZone5.iStandardOffset, dSTZone5.iStartRecurrence, dSTZone5.iEndRecurrence.renameAppend("-Summer"));
                    }
                    dSTZone2 = dSTZone3;
                }
                if (z2) {
                    str2 = str;
                } else {
                    str2 = "";
                }
                return new PrecalculatedZone(str2, jArr, iArr5, iArr6, strArr6, dSTZone2);
            }
            throw new IllegalArgumentException();
        }

        static PrecalculatedZone readFrom(DataInput dataInput, String str) throws IOException {
            DSTZone dSTZone;
            int i2;
            int readUnsignedShort = dataInput.readUnsignedShort();
            String[] strArr = new String[readUnsignedShort];
            for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                strArr[i3] = dataInput.readUTF();
            }
            int readInt = dataInput.readInt();
            long[] jArr = new long[readInt];
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            String[] strArr2 = new String[readInt];
            for (int i4 = 0; i4 < readInt; i4++) {
                jArr[i4] = DateTimeZoneBuilder.readMillis(dataInput);
                iArr[i4] = (int) DateTimeZoneBuilder.readMillis(dataInput);
                iArr2[i4] = (int) DateTimeZoneBuilder.readMillis(dataInput);
                if (readUnsignedShort < 256) {
                    try {
                        i2 = dataInput.readUnsignedByte();
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw new IOException("Invalid encoding");
                    }
                } else {
                    i2 = dataInput.readUnsignedShort();
                }
                strArr2[i4] = strArr[i2];
            }
            if (dataInput.readBoolean()) {
                dSTZone = DSTZone.readFrom(dataInput, str);
            } else {
                dSTZone = null;
            }
            return new PrecalculatedZone(str, jArr, iArr, iArr2, strArr2, dSTZone);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrecalculatedZone)) {
                return false;
            }
            PrecalculatedZone precalculatedZone = (PrecalculatedZone) obj;
            if (getID().equals(precalculatedZone.getID()) && Arrays.equals(this.iTransitions, precalculatedZone.iTransitions) && Arrays.equals(this.iNameKeys, precalculatedZone.iNameKeys) && Arrays.equals(this.iWallOffsets, precalculatedZone.iWallOffsets) && Arrays.equals(this.iStandardOffsets, precalculatedZone.iStandardOffsets)) {
                DSTZone dSTZone = this.iTailZone;
                DSTZone dSTZone2 = precalculatedZone.iTailZone;
                if (dSTZone == null) {
                    if (dSTZone2 == null) {
                        return true;
                    }
                } else if (dSTZone.equals(dSTZone2)) {
                    return true;
                }
            }
            return false;
        }

        public String getNameKey(long j2) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch >= 0) {
                return this.iNameKeys[binarySearch];
            }
            int i2 = ~binarySearch;
            if (i2 >= jArr.length) {
                DSTZone dSTZone = this.iTailZone;
                if (dSTZone == null) {
                    return this.iNameKeys[i2 - 1];
                }
                return dSTZone.getNameKey(j2);
            } else if (i2 > 0) {
                return this.iNameKeys[i2 - 1];
            } else {
                return "UTC";
            }
        }

        public int getOffset(long j2) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch >= 0) {
                return this.iWallOffsets[binarySearch];
            }
            int i2 = ~binarySearch;
            if (i2 >= jArr.length) {
                DSTZone dSTZone = this.iTailZone;
                if (dSTZone == null) {
                    return this.iWallOffsets[i2 - 1];
                }
                return dSTZone.getOffset(j2);
            } else if (i2 > 0) {
                return this.iWallOffsets[i2 - 1];
            } else {
                return 0;
            }
        }

        public int getStandardOffset(long j2) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch >= 0) {
                return this.iStandardOffsets[binarySearch];
            }
            int i2 = ~binarySearch;
            if (i2 >= jArr.length) {
                DSTZone dSTZone = this.iTailZone;
                if (dSTZone == null) {
                    return this.iStandardOffsets[i2 - 1];
                }
                return dSTZone.getStandardOffset(j2);
            } else if (i2 > 0) {
                return this.iStandardOffsets[i2 - 1];
            } else {
                return 0;
            }
        }

        public boolean isCachable() {
            if (this.iTailZone != null) {
                return true;
            }
            long[] jArr = this.iTransitions;
            if (jArr.length <= 1) {
                return false;
            }
            double d2 = 0.0d;
            int i2 = 0;
            for (int i3 = 1; i3 < jArr.length; i3++) {
                long j2 = jArr[i3] - jArr[i3 - 1];
                if (j2 < 63158400000L) {
                    d2 += (double) j2;
                    i2++;
                }
            }
            if (i2 <= 0 || (d2 / ((double) i2)) / 8.64E7d < 25.0d) {
                return false;
            }
            return true;
        }

        public boolean isFixed() {
            return false;
        }

        public long nextTransition(long j2) {
            int i2;
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch >= 0) {
                i2 = binarySearch + 1;
            } else {
                i2 = ~binarySearch;
            }
            if (i2 < jArr.length) {
                return jArr[i2];
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone == null) {
                return j2;
            }
            long j3 = jArr[jArr.length - 1];
            if (j2 < j3) {
                j2 = j3;
            }
            return dSTZone.nextTransition(j2);
        }

        public long previousTransition(long j2) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch < 0) {
                int i2 = ~binarySearch;
                if (i2 < jArr.length) {
                    if (i2 > 0) {
                        long j3 = jArr[i2 - 1];
                        if (j3 > Long.MIN_VALUE) {
                            return j3 - 1;
                        }
                    }
                    return j2;
                }
                DSTZone dSTZone = this.iTailZone;
                if (dSTZone != null) {
                    long previousTransition = dSTZone.previousTransition(j2);
                    if (previousTransition < j2) {
                        return previousTransition;
                    }
                }
                long j4 = jArr[i2 - 1];
                if (j4 > Long.MIN_VALUE) {
                    return j4 - 1;
                }
                return j2;
            } else if (j2 > Long.MIN_VALUE) {
                return j2 - 1;
            } else {
                return j2;
            }
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            int length = this.iTransitions.length;
            HashSet<String> hashSet = new HashSet<>();
            boolean z2 = false;
            for (int i2 = 0; i2 < length; i2++) {
                hashSet.add(this.iNameKeys[i2]);
            }
            int size = hashSet.size();
            if (size <= 65535) {
                String[] strArr = new String[size];
                int i3 = 0;
                for (String str : hashSet) {
                    strArr[i3] = str;
                    i3++;
                }
                dataOutput.writeShort(size);
                for (int i4 = 0; i4 < size; i4++) {
                    dataOutput.writeUTF(strArr[i4]);
                }
                dataOutput.writeInt(length);
                for (int i5 = 0; i5 < length; i5++) {
                    DateTimeZoneBuilder.writeMillis(dataOutput, this.iTransitions[i5]);
                    DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iWallOffsets[i5]);
                    DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iStandardOffsets[i5]);
                    String str2 = this.iNameKeys[i5];
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size) {
                            break;
                        } else if (!strArr[i6].equals(str2)) {
                            i6++;
                        } else if (size < 256) {
                            dataOutput.writeByte(i6);
                        } else {
                            dataOutput.writeShort(i6);
                        }
                    }
                }
                if (this.iTailZone != null) {
                    z2 = true;
                }
                dataOutput.writeBoolean(z2);
                DSTZone dSTZone = this.iTailZone;
                if (dSTZone != null) {
                    dSTZone.writeTo(dataOutput);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("String pool is too large");
        }
    }

    private static final class Recurrence {
        final String iNameKey;
        final OfYear iOfYear;
        final int iSaveMillis;

        Recurrence(OfYear ofYear, String str, int i2) {
            this.iOfYear = ofYear;
            this.iNameKey = str;
            this.iSaveMillis = i2;
        }

        static Recurrence readFrom(DataInput dataInput) throws IOException {
            return new Recurrence(OfYear.readFrom(dataInput), dataInput.readUTF(), (int) DateTimeZoneBuilder.readMillis(dataInput));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Recurrence)) {
                return false;
            }
            Recurrence recurrence = (Recurrence) obj;
            if (this.iSaveMillis != recurrence.iSaveMillis || !this.iNameKey.equals(recurrence.iNameKey) || !this.iOfYear.equals(recurrence.iOfYear)) {
                return false;
            }
            return true;
        }

        public String getNameKey() {
            return this.iNameKey;
        }

        public OfYear getOfYear() {
            return this.iOfYear;
        }

        public int getSaveMillis() {
            return this.iSaveMillis;
        }

        public long next(long j2, int i2, int i3) {
            return this.iOfYear.next(j2, i2, i3);
        }

        public long previous(long j2, int i2, int i3) {
            return this.iOfYear.previous(j2, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public Recurrence rename(String str) {
            return new Recurrence(this.iOfYear, str, this.iSaveMillis);
        }

        /* access modifiers changed from: package-private */
        public Recurrence renameAppend(String str) {
            return rename((this.iNameKey + str).intern());
        }

        public String toString() {
            return this.iOfYear + " named " + this.iNameKey + " at " + this.iSaveMillis;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            this.iOfYear.writeTo(dataOutput);
            dataOutput.writeUTF(this.iNameKey);
            DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iSaveMillis);
        }
    }

    private static final class Rule {
        final int iFromYear;
        final Recurrence iRecurrence;
        final int iToYear;

        Rule(Recurrence recurrence, int i2, int i3) {
            this.iRecurrence = recurrence;
            this.iFromYear = i2;
            this.iToYear = i3;
        }

        public int getFromYear() {
            return this.iFromYear;
        }

        public String getNameKey() {
            return this.iRecurrence.getNameKey();
        }

        public OfYear getOfYear() {
            return this.iRecurrence.getOfYear();
        }

        public int getSaveMillis() {
            return this.iRecurrence.getSaveMillis();
        }

        public int getToYear() {
            return this.iToYear;
        }

        public long next(long j2, int i2, int i3) {
            int i4;
            long j3;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            int i5 = i2 + i3;
            if (j2 == Long.MIN_VALUE) {
                i4 = Integer.MIN_VALUE;
            } else {
                i4 = instanceUTC.year().get(((long) i5) + j2);
            }
            if (i4 < this.iFromYear) {
                j3 = (instanceUTC.year().set(0, this.iFromYear) - ((long) i5)) - 1;
            } else {
                j3 = j2;
            }
            long next = this.iRecurrence.next(j3, i2, i3);
            if (next <= j2 || instanceUTC.year().get(((long) i5) + next) <= this.iToYear) {
                return next;
            }
            return j2;
        }

        public String toString() {
            return this.iFromYear + " to " + this.iToYear + " using " + this.iRecurrence;
        }
    }

    private boolean addTransition(ArrayList<Transition> arrayList, Transition transition) {
        int size = arrayList.size();
        if (size == 0) {
            arrayList.add(transition);
            return true;
        }
        int i2 = size - 1;
        Transition transition2 = arrayList.get(i2);
        int i3 = 0;
        if (!transition.isTransitionFrom(transition2)) {
            return false;
        }
        if (size >= 2) {
            i3 = arrayList.get(size - 2).getWallOffset();
        }
        if (transition.getMillis() + ((long) transition2.getWallOffset()) == transition2.getMillis() + ((long) i3)) {
            return addTransition(arrayList, transition.withMillis(arrayList.remove(i2).getMillis()));
        }
        arrayList.add(transition);
        return true;
    }

    private static DateTimeZone buildFixedZone(String str, String str2, int i2, int i3) {
        if (!"UTC".equals(str) || !str.equals(str2) || i2 != 0 || i3 != 0) {
            return new FixedDateTimeZone(str, str2, i2, i3);
        }
        return DateTimeZone.UTC;
    }

    private RuleSet getLastRuleSet() {
        if (this.iRuleSets.size() == 0) {
            addCutover(Integer.MIN_VALUE, 'w', 1, 1, 0, false, 0);
        }
        ArrayList<RuleSet> arrayList = this.iRuleSets;
        return arrayList.get(arrayList.size() - 1);
    }

    public static DateTimeZone readFrom(InputStream inputStream, String str) throws IOException {
        if (inputStream instanceof DataInput) {
            return readFrom((DataInput) inputStream, str);
        }
        return readFrom((DataInput) new DataInputStream(inputStream), str);
    }

    static long readMillis(DataInput dataInput) throws IOException {
        long readUnsignedByte;
        long j2;
        int readUnsignedByte2 = dataInput.readUnsignedByte();
        int i2 = readUnsignedByte2 >> 6;
        if (i2 == 1) {
            readUnsignedByte = (long) (dataInput.readUnsignedByte() | ((readUnsignedByte2 << 26) >> 2) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8));
            j2 = 60000;
        } else if (i2 == 2) {
            readUnsignedByte = ((((long) readUnsignedByte2) << 58) >> 26) | ((long) (dataInput.readUnsignedByte() << 24)) | ((long) (dataInput.readUnsignedByte() << 16)) | ((long) (dataInput.readUnsignedByte() << 8)) | ((long) dataInput.readUnsignedByte());
            j2 = 1000;
        } else if (i2 == 3) {
            return dataInput.readLong();
        } else {
            readUnsignedByte = (long) ((readUnsignedByte2 << 26) >> 26);
            j2 = 1800000;
        }
        return readUnsignedByte * j2;
    }

    static void writeMillis(DataOutput dataOutput, long j2) throws IOException {
        int i2;
        if (j2 % 1800000 == 0) {
            long j3 = j2 / 1800000;
            if (((j3 << 58) >> 58) == j3) {
                dataOutput.writeByte((int) (j3 & 63));
                return;
            }
        }
        if (j2 % 60000 == 0) {
            long j4 = j2 / 60000;
            if (((j4 << 34) >> 34) == j4) {
                dataOutput.writeInt(1073741824 | ((int) (1073741823 & j4)));
                return;
            }
        }
        if (j2 % 1000 == 0) {
            long j5 = j2 / 1000;
            if (((j5 << 26) >> 26) == j5) {
                dataOutput.writeByte(((int) ((j5 >> 32) & 63)) | 128);
                dataOutput.writeInt((int) (-1 & j5));
                return;
            }
        }
        if (j2 < 0) {
            i2 = JfifUtil.MARKER_FIRST_BYTE;
        } else {
            i2 = JfifUtil.MARKER_SOFn;
        }
        dataOutput.writeByte(i2);
        dataOutput.writeLong(j2);
    }

    public DateTimeZoneBuilder addCutover(int i2, char c2, int i3, int i4, int i5, boolean z2, int i6) {
        if (this.iRuleSets.size() > 0) {
            OfYear ofYear = new OfYear(c2, i3, i4, i5, z2, i6);
            ArrayList<RuleSet> arrayList = this.iRuleSets;
            arrayList.get(arrayList.size() - 1).setUpperLimit(i2, ofYear);
        }
        this.iRuleSets.add(new RuleSet());
        return this;
    }

    public DateTimeZoneBuilder addRecurringSavings(String str, int i2, int i3, int i4, char c2, int i5, int i6, int i7, boolean z2, int i8) {
        if (i3 <= i4) {
            String str2 = str;
            int i9 = i2;
            getLastRuleSet().addRule(new Rule(new Recurrence(new OfYear(c2, i5, i6, i7, z2, i8), str, i2), i3, i4));
        }
        return this;
    }

    public DateTimeZoneBuilder setFixedSavings(String str, int i2) {
        getLastRuleSet().setFixedSavings(str, i2);
        return this;
    }

    public DateTimeZoneBuilder setStandardOffset(int i2) {
        getLastRuleSet().setStandardOffset(i2);
        return this;
    }

    public DateTimeZone toDateTimeZone(String str, boolean z2) {
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            int size = this.iRuleSets.size();
            DSTZone dSTZone = null;
            long j2 = Long.MIN_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                RuleSet ruleSet = this.iRuleSets.get(i2);
                Transition firstTransition = ruleSet.firstTransition(j2);
                if (firstTransition != null) {
                    addTransition(arrayList, firstTransition);
                    long millis = firstTransition.getMillis();
                    int saveMillis = firstTransition.getSaveMillis();
                    RuleSet ruleSet2 = new RuleSet(ruleSet);
                    while (true) {
                        Transition nextTransition = ruleSet2.nextTransition(millis, saveMillis);
                        if (nextTransition == null || (addTransition(arrayList, nextTransition) && dSTZone != null)) {
                            j2 = ruleSet2.getUpperLimit(saveMillis);
                        } else {
                            long millis2 = nextTransition.getMillis();
                            int saveMillis2 = nextTransition.getSaveMillis();
                            if (dSTZone == null && i2 == size - 1) {
                                dSTZone = ruleSet2.buildTailZone(str);
                            }
                            saveMillis = saveMillis2;
                            millis = millis2;
                        }
                    }
                    j2 = ruleSet2.getUpperLimit(saveMillis);
                }
            }
            if (arrayList.size() == 0) {
                if (dSTZone != null) {
                    return dSTZone;
                }
                return buildFixedZone(str, "UTC", 0, 0);
            } else if (arrayList.size() == 1 && dSTZone == null) {
                Transition transition = (Transition) arrayList.get(0);
                return buildFixedZone(str, transition.getNameKey(), transition.getWallOffset(), transition.getStandardOffset());
            } else {
                PrecalculatedZone create = PrecalculatedZone.create(str, z2, arrayList, dSTZone);
                if (create.isCachable()) {
                    return CachedDateTimeZone.forZone(create);
                }
                return create;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void writeTo(String str, OutputStream outputStream) throws IOException {
        if (outputStream instanceof DataOutput) {
            writeTo(str, (DataOutput) outputStream);
            return;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        writeTo(str, (DataOutput) dataOutputStream);
        dataOutputStream.flush();
    }

    private static final class RuleSet {
        private static final int YEAR_LIMIT = (ISOChronology.getInstanceUTC().year().get(DateTimeUtils.currentTimeMillis()) + 100);
        private String iInitialNameKey;
        private int iInitialSaveMillis;
        private ArrayList<Rule> iRules;
        private int iStandardOffset;
        private OfYear iUpperOfYear;
        private int iUpperYear;

        RuleSet() {
            this.iRules = new ArrayList<>(10);
            this.iUpperYear = Integer.MAX_VALUE;
        }

        public void addRule(Rule rule) {
            if (!this.iRules.contains(rule)) {
                this.iRules.add(rule);
            }
        }

        public DSTZone buildTailZone(String str) {
            if (this.iRules.size() != 2) {
                return null;
            }
            Rule rule = this.iRules.get(0);
            Rule rule2 = this.iRules.get(1);
            if (rule.getToYear() == Integer.MAX_VALUE && rule2.getToYear() == Integer.MAX_VALUE) {
                return new DSTZone(str, this.iStandardOffset, rule.iRecurrence, rule2.iRecurrence);
            }
            return null;
        }

        public Transition firstTransition(long j2) {
            String str = this.iInitialNameKey;
            if (str != null) {
                int i2 = this.iStandardOffset;
                return new Transition(j2, str, i2 + this.iInitialSaveMillis, i2);
            }
            ArrayList<Rule> arrayList = new ArrayList<>(this.iRules);
            long j3 = Long.MIN_VALUE;
            int i3 = 0;
            Transition transition = null;
            while (true) {
                Transition nextTransition = nextTransition(j3, i3);
                if (nextTransition == null) {
                    break;
                }
                long millis = nextTransition.getMillis();
                int i4 = (millis > j2 ? 1 : (millis == j2 ? 0 : -1));
                if (i4 == 0) {
                    transition = new Transition(j2, nextTransition);
                    break;
                } else if (i4 > 0) {
                    if (transition == null) {
                        Iterator<Rule> it2 = arrayList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Rule next = it2.next();
                            if (next.getSaveMillis() == 0) {
                                transition = new Transition(j2, next, this.iStandardOffset);
                                break;
                            }
                        }
                    }
                    if (transition == null) {
                        String nameKey = nextTransition.getNameKey();
                        int i5 = this.iStandardOffset;
                        transition = new Transition(j2, nameKey, i5, i5);
                    }
                } else {
                    transition = new Transition(j2, nextTransition);
                    i3 = nextTransition.getSaveMillis();
                    j3 = millis;
                }
            }
            this.iRules = arrayList;
            return transition;
        }

        public int getStandardOffset() {
            return this.iStandardOffset;
        }

        public long getUpperLimit(int i2) {
            int i3 = this.iUpperYear;
            if (i3 == Integer.MAX_VALUE) {
                return Clock.MAX_TIME;
            }
            return this.iUpperOfYear.setInstant(i3, this.iStandardOffset, i2);
        }

        public Transition nextTransition(long j2, int i2) {
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            Iterator<Rule> it2 = this.iRules.iterator();
            long j3 = Clock.MAX_TIME;
            Rule rule = null;
            while (it2.hasNext()) {
                Rule next = it2.next();
                long next2 = next.next(j2, this.iStandardOffset, i2);
                if (next2 <= j2) {
                    it2.remove();
                } else if (next2 <= j3) {
                    rule = next;
                    j3 = next2;
                }
            }
            if (rule == null || instanceUTC.year().get(j3) >= YEAR_LIMIT) {
                return null;
            }
            int i3 = this.iUpperYear;
            if (i3 >= Integer.MAX_VALUE || j3 < this.iUpperOfYear.setInstant(i3, this.iStandardOffset, i2)) {
                return new Transition(j3, rule, this.iStandardOffset);
            }
            return null;
        }

        public void setFixedSavings(String str, int i2) {
            this.iInitialNameKey = str;
            this.iInitialSaveMillis = i2;
        }

        public void setStandardOffset(int i2) {
            this.iStandardOffset = i2;
        }

        public void setUpperLimit(int i2, OfYear ofYear) {
            this.iUpperYear = i2;
            this.iUpperOfYear = ofYear;
        }

        public String toString() {
            return this.iInitialNameKey + " initial: " + this.iInitialSaveMillis + " std: " + this.iStandardOffset + " upper: " + this.iUpperYear + " " + this.iUpperOfYear + " " + this.iRules;
        }

        RuleSet(RuleSet ruleSet) {
            this.iStandardOffset = ruleSet.iStandardOffset;
            this.iRules = new ArrayList<>(ruleSet.iRules);
            this.iInitialNameKey = ruleSet.iInitialNameKey;
            this.iInitialSaveMillis = ruleSet.iInitialSaveMillis;
            this.iUpperYear = ruleSet.iUpperYear;
            this.iUpperOfYear = ruleSet.iUpperOfYear;
        }
    }

    public static DateTimeZone readFrom(DataInput dataInput, String str) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 67) {
            return CachedDateTimeZone.forZone(PrecalculatedZone.readFrom(dataInput, str));
        }
        if (readUnsignedByte == 70) {
            FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone(str, dataInput.readUTF(), (int) readMillis(dataInput), (int) readMillis(dataInput));
            DateTimeZone dateTimeZone = DateTimeZone.UTC;
            return fixedDateTimeZone.equals(dateTimeZone) ? dateTimeZone : fixedDateTimeZone;
        } else if (readUnsignedByte == 80) {
            return PrecalculatedZone.readFrom(dataInput, str);
        } else {
            throw new IOException("Invalid encoding");
        }
    }

    private static final class Transition {
        private final long iMillis;
        private final String iNameKey;
        private final int iStandardOffset;
        private final int iWallOffset;

        Transition(long j2, Transition transition) {
            this.iMillis = j2;
            this.iNameKey = transition.iNameKey;
            this.iWallOffset = transition.iWallOffset;
            this.iStandardOffset = transition.iStandardOffset;
        }

        public long getMillis() {
            return this.iMillis;
        }

        public String getNameKey() {
            return this.iNameKey;
        }

        public int getSaveMillis() {
            return this.iWallOffset - this.iStandardOffset;
        }

        public int getStandardOffset() {
            return this.iStandardOffset;
        }

        public int getWallOffset() {
            return this.iWallOffset;
        }

        public boolean isTransitionFrom(Transition transition) {
            if (transition == null) {
                return true;
            }
            return this.iMillis > transition.iMillis && !(this.iWallOffset == transition.iWallOffset && this.iStandardOffset == transition.iStandardOffset && this.iNameKey.equals(transition.iNameKey));
        }

        public String toString() {
            return new DateTime(this.iMillis, DateTimeZone.UTC) + " " + this.iStandardOffset + " " + this.iWallOffset;
        }

        public Transition withMillis(long j2) {
            return new Transition(j2, this.iNameKey, this.iWallOffset, this.iStandardOffset);
        }

        Transition(long j2, Rule rule, int i2) {
            this.iMillis = j2;
            this.iNameKey = rule.getNameKey();
            this.iWallOffset = rule.getSaveMillis() + i2;
            this.iStandardOffset = i2;
        }

        Transition(long j2, String str, int i2, int i3) {
            this.iMillis = j2;
            this.iNameKey = str;
            this.iWallOffset = i2;
            this.iStandardOffset = i3;
        }
    }

    public void writeTo(String str, DataOutput dataOutput) throws IOException {
        DateTimeZone dateTimeZone = toDateTimeZone(str, false);
        if (dateTimeZone instanceof FixedDateTimeZone) {
            dataOutput.writeByte(70);
            dataOutput.writeUTF(dateTimeZone.getNameKey(0));
            writeMillis(dataOutput, (long) dateTimeZone.getOffset(0));
            writeMillis(dataOutput, (long) dateTimeZone.getStandardOffset(0));
            return;
        }
        if (dateTimeZone instanceof CachedDateTimeZone) {
            dataOutput.writeByte(67);
            dateTimeZone = ((CachedDateTimeZone) dateTimeZone).getUncachedZone();
        } else {
            dataOutput.writeByte(80);
        }
        ((PrecalculatedZone) dateTimeZone).writeTo(dataOutput);
    }
}
