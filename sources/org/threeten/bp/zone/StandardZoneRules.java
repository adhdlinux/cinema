package org.threeten.bp.zone;

import com.facebook.common.time.Clock;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;

final class StandardZoneRules extends ZoneRules implements Serializable {
    private static final int LAST_CACHED_YEAR = 2100;
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache = new ConcurrentHashMap();
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final ZoneOffset[] wallOffsets;

    StandardZoneRules(ZoneOffset zoneOffset, ZoneOffset zoneOffset2, List<ZoneOffsetTransition> list, List<ZoneOffsetTransition> list2, List<ZoneOffsetTransitionRule> list3) {
        this.standardTransitions = new long[list.size()];
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[(list.size() + 1)];
        this.standardOffsets = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        int i2 = 0;
        while (i2 < list.size()) {
            this.standardTransitions[i2] = list.get(i2).toEpochSecond();
            int i3 = i2 + 1;
            this.standardOffsets[i3] = list.get(i2).getOffsetAfter();
            i2 = i3;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(zoneOffset2);
        for (ZoneOffsetTransition next : list2) {
            if (next.isGap()) {
                arrayList.add(next.getDateTimeBefore());
                arrayList.add(next.getDateTimeAfter());
            } else {
                arrayList.add(next.getDateTimeAfter());
                arrayList.add(next.getDateTimeBefore());
            }
            arrayList2.add(next.getOffsetAfter());
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        this.wallOffsets = (ZoneOffset[]) arrayList2.toArray(new ZoneOffset[arrayList2.size()]);
        this.savingsInstantTransitions = new long[list2.size()];
        for (int i4 = 0; i4 < list2.size(); i4++) {
            this.savingsInstantTransitions[i4] = list2.get(i4).getInstant().getEpochSecond();
        }
        if (list3.size() <= 15) {
            this.lastRules = (ZoneOffsetTransitionRule[]) list3.toArray(new ZoneOffsetTransitionRule[list3.size()]);
            return;
        }
        throw new IllegalArgumentException("Too many transition rules");
    }

    private Object findOffsetInfo(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        LocalDateTime dateTimeBefore = zoneOffsetTransition.getDateTimeBefore();
        if (zoneOffsetTransition.isGap()) {
            if (localDateTime.isBefore(dateTimeBefore)) {
                return zoneOffsetTransition.getOffsetBefore();
            }
            if (localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter())) {
                return zoneOffsetTransition;
            }
            return zoneOffsetTransition.getOffsetAfter();
        } else if (!localDateTime.isBefore(dateTimeBefore)) {
            return zoneOffsetTransition.getOffsetAfter();
        } else {
            if (localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter())) {
                return zoneOffsetTransition.getOffsetBefore();
            }
            return zoneOffsetTransition;
        }
    }

    private ZoneOffsetTransition[] findTransitionArray(int i2) {
        Integer valueOf = Integer.valueOf(i2);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = this.lastRulesCache.get(valueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.lastRules;
        ZoneOffsetTransition[] zoneOffsetTransitionArr2 = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
        for (int i3 = 0; i3 < zoneOffsetTransitionRuleArr.length; i3++) {
            zoneOffsetTransitionArr2[i3] = zoneOffsetTransitionRuleArr[i3].createTransition(i2);
        }
        if (i2 < 2100) {
            this.lastRulesCache.putIfAbsent(valueOf, zoneOffsetTransitionArr2);
        }
        return zoneOffsetTransitionArr2;
    }

    private int findYear(long j2, ZoneOffset zoneOffset) {
        return LocalDate.ofEpochDay(Jdk8Methods.floorDiv(j2 + ((long) zoneOffset.getTotalSeconds()), 86400)).getYear();
    }

    private Object getOffsetInfo(LocalDateTime localDateTime) {
        int i2 = 0;
        if (this.lastRules.length > 0) {
            LocalDateTime[] localDateTimeArr = this.savingsLocalTransitions;
            if (localDateTimeArr.length == 0 || localDateTime.isAfter(localDateTimeArr[localDateTimeArr.length - 1])) {
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(localDateTime.getYear());
                int length = findTransitionArray.length;
                Object obj = null;
                while (i2 < length) {
                    ZoneOffsetTransition zoneOffsetTransition = findTransitionArray[i2];
                    Object findOffsetInfo = findOffsetInfo(localDateTime, zoneOffsetTransition);
                    if ((findOffsetInfo instanceof ZoneOffsetTransition) || findOffsetInfo.equals(zoneOffsetTransition.getOffsetBefore())) {
                        return findOffsetInfo;
                    }
                    i2++;
                    obj = findOffsetInfo;
                }
                return obj;
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsLocalTransitions, localDateTime);
        if (binarySearch == -1) {
            return this.wallOffsets[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            LocalDateTime[] localDateTimeArr2 = this.savingsLocalTransitions;
            if (binarySearch < localDateTimeArr2.length - 1) {
                int i3 = binarySearch + 1;
                if (localDateTimeArr2[binarySearch].equals(localDateTimeArr2[i3])) {
                    binarySearch = i3;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.wallOffsets[(binarySearch / 2) + 1];
        }
        LocalDateTime[] localDateTimeArr3 = this.savingsLocalTransitions;
        LocalDateTime localDateTime2 = localDateTimeArr3[binarySearch];
        LocalDateTime localDateTime3 = localDateTimeArr3[binarySearch + 1];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        int i4 = binarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr[i4];
        ZoneOffset zoneOffset2 = zoneOffsetArr[i4 + 1];
        if (zoneOffset2.getTotalSeconds() > zoneOffset.getTotalSeconds()) {
            return new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2);
        }
        return new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
    }

    static StandardZoneRules readExternal(DataInput dataInput) throws IOException, ClassNotFoundException {
        int readInt = dataInput.readInt();
        long[] jArr = new long[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            jArr[i2] = Ser.readEpochSec(dataInput);
        }
        int i3 = readInt + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            zoneOffsetArr[i4] = Ser.readOffset(dataInput);
        }
        int readInt2 = dataInput.readInt();
        long[] jArr2 = new long[readInt2];
        for (int i5 = 0; i5 < readInt2; i5++) {
            jArr2[i5] = Ser.readEpochSec(dataInput);
        }
        int i6 = readInt2 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            zoneOffsetArr2[i7] = Ser.readOffset(dataInput);
        }
        int readByte = dataInput.readByte();
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = new ZoneOffsetTransitionRule[readByte];
        for (int i8 = 0; i8 < readByte; i8++) {
            zoneOffsetTransitionRuleArr[i8] = ZoneOffsetTransitionRule.readExternal(dataInput);
        }
        return new StandardZoneRules(jArr, zoneOffsetArr, jArr2, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StandardZoneRules) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            if (!Arrays.equals(this.standardTransitions, standardZoneRules.standardTransitions) || !Arrays.equals(this.standardOffsets, standardZoneRules.standardOffsets) || !Arrays.equals(this.savingsInstantTransitions, standardZoneRules.savingsInstantTransitions) || !Arrays.equals(this.wallOffsets, standardZoneRules.wallOffsets) || !Arrays.equals(this.lastRules, standardZoneRules.lastRules)) {
                return false;
            }
            return true;
        }
        if ((obj instanceof ZoneRules.Fixed) && isFixedOffset()) {
            Instant instant = Instant.EPOCH;
            if (getOffset(instant).equals(((ZoneRules.Fixed) obj).getOffset(instant))) {
                return true;
            }
        }
        return false;
    }

    public Duration getDaylightSavings(Instant instant) {
        return Duration.ofSeconds((long) (getOffset(instant).getTotalSeconds() - getStandardOffset(instant).getTotalSeconds()));
    }

    public ZoneOffset getOffset(Instant instant) {
        long epochSecond = instant.getEpochSecond();
        if (this.lastRules.length > 0) {
            long[] jArr = this.savingsInstantTransitions;
            if (jArr.length == 0 || epochSecond > jArr[jArr.length - 1]) {
                ZoneOffset[] zoneOffsetArr = this.wallOffsets;
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear(epochSecond, zoneOffsetArr[zoneOffsetArr.length - 1]));
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int i2 = 0; i2 < findTransitionArray.length; i2++) {
                    zoneOffsetTransition = findTransitionArray[i2];
                    if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                        return zoneOffsetTransition.getOffsetBefore();
                    }
                }
                return zoneOffsetTransition.getOffsetAfter();
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.wallOffsets[binarySearch + 1];
    }

    public ZoneOffset getStandardOffset(Instant instant) {
        int binarySearch = Arrays.binarySearch(this.standardTransitions, instant.getEpochSecond());
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.standardOffsets[binarySearch + 1];
    }

    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) offsetInfo;
        }
        return null;
    }

    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return Collections.unmodifiableList(Arrays.asList(this.lastRules));
    }

    public List<ZoneOffsetTransition> getTransitions() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            long[] jArr = this.savingsInstantTransitions;
            if (i2 >= jArr.length) {
                return Collections.unmodifiableList(arrayList);
            }
            long j2 = jArr[i2];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            ZoneOffset zoneOffset = zoneOffsetArr[i2];
            i2++;
            arrayList.add(new ZoneOffsetTransition(j2, zoneOffset, zoneOffsetArr[i2]));
        }
    }

    public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) offsetInfo).getValidOffsets();
        }
        return Collections.singletonList((ZoneOffset) offsetInfo);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    public boolean isDaylightSavings(Instant instant) {
        return !getStandardOffset(instant).equals(getOffset(instant));
    }

    public boolean isFixedOffset() {
        return this.savingsInstantTransitions.length == 0 && this.lastRules.length == 0 && this.wallOffsets[0].equals(this.standardOffsets[0]);
    }

    public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return getValidOffsets(localDateTime).contains(zoneOffset);
    }

    public ZoneOffsetTransition nextTransition(Instant instant) {
        int i2;
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSecond = instant.getEpochSecond();
        long[] jArr = this.savingsInstantTransitions;
        if (epochSecond < jArr[jArr.length - 1]) {
            int binarySearch = Arrays.binarySearch(jArr, epochSecond);
            if (binarySearch < 0) {
                i2 = (-binarySearch) - 1;
            } else {
                i2 = binarySearch + 1;
            }
            long j2 = this.savingsInstantTransitions[i2];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            return new ZoneOffsetTransition(j2, zoneOffsetArr[i2], zoneOffsetArr[i2 + 1]);
        } else if (this.lastRules.length == 0) {
            return null;
        } else {
            ZoneOffset[] zoneOffsetArr2 = this.wallOffsets;
            int findYear = findYear(epochSecond, zoneOffsetArr2[zoneOffsetArr2.length - 1]);
            for (ZoneOffsetTransition zoneOffsetTransition : findTransitionArray(findYear)) {
                if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                    return zoneOffsetTransition;
                }
            }
            if (findYear < 999999999) {
                return findTransitionArray(findYear + 1)[0];
            }
            return null;
        }
    }

    public ZoneOffsetTransition previousTransition(Instant instant) {
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSecond = instant.getEpochSecond();
        if (instant.getNano() > 0 && epochSecond < Clock.MAX_TIME) {
            epochSecond++;
        }
        long[] jArr = this.savingsInstantTransitions;
        long j2 = jArr[jArr.length - 1];
        if (this.lastRules.length > 0 && epochSecond > j2) {
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
            int findYear = findYear(epochSecond, zoneOffset);
            ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear);
            for (int length = findTransitionArray.length - 1; length >= 0; length--) {
                if (epochSecond > findTransitionArray[length].toEpochSecond()) {
                    return findTransitionArray[length];
                }
            }
            int i2 = findYear - 1;
            if (i2 > findYear(j2, zoneOffset)) {
                ZoneOffsetTransition[] findTransitionArray2 = findTransitionArray(i2);
                return findTransitionArray2[findTransitionArray2.length - 1];
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        if (binarySearch <= 0) {
            return null;
        }
        int i3 = binarySearch - 1;
        long j3 = this.savingsInstantTransitions[i3];
        ZoneOffset[] zoneOffsetArr2 = this.wallOffsets;
        return new ZoneOffsetTransition(j3, zoneOffsetArr2[i3], zoneOffsetArr2[binarySearch]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StandardZoneRules[currentStandardOffset=");
        ZoneOffset[] zoneOffsetArr = this.standardOffsets;
        sb.append(zoneOffsetArr[zoneOffsetArr.length - 1]);
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.standardTransitions.length);
        for (long writeEpochSec : this.standardTransitions) {
            Ser.writeEpochSec(writeEpochSec, dataOutput);
        }
        for (ZoneOffset writeOffset : this.standardOffsets) {
            Ser.writeOffset(writeOffset, dataOutput);
        }
        dataOutput.writeInt(this.savingsInstantTransitions.length);
        for (long writeEpochSec2 : this.savingsInstantTransitions) {
            Ser.writeEpochSec(writeEpochSec2, dataOutput);
        }
        for (ZoneOffset writeOffset2 : this.wallOffsets) {
            Ser.writeOffset(writeOffset2, dataOutput);
        }
        dataOutput.writeByte(this.lastRules.length);
        for (ZoneOffsetTransitionRule writeExternal : this.lastRules) {
            writeExternal.writeExternal(dataOutput);
        }
    }

    public ZoneOffset getOffset(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) offsetInfo).getOffsetBefore();
        }
        return (ZoneOffset) offsetInfo;
    }

    private StandardZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        this.standardTransitions = jArr;
        this.standardOffsets = zoneOffsetArr;
        this.savingsInstantTransitions = jArr2;
        this.wallOffsets = zoneOffsetArr2;
        this.lastRules = zoneOffsetTransitionRuleArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jArr2.length) {
            int i3 = i2 + 1;
            ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[i2], zoneOffsetArr2[i2], zoneOffsetArr2[i3]);
            if (zoneOffsetTransition.isGap()) {
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
            } else {
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
            }
            i2 = i3;
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
    }
}
