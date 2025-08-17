package org.threeten.bp.chrono;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

final class ChronoZonedDateTimeImpl<D extends ChronoLocalDate> extends ChronoZonedDateTime<D> implements Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    private final ChronoLocalDateTimeImpl<D> dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    /* renamed from: org.threeten.bp.chrono.ChronoZonedDateTimeImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$threeten$bp$temporal$ChronoField = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$threeten$bp$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoZonedDateTimeImpl.AnonymousClass1.<clinit>():void");
        }
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = (ChronoLocalDateTimeImpl) Jdk8Methods.requireNonNull(chronoLocalDateTimeImpl, "dateTime");
        this.offset = (ZoneOffset) Jdk8Methods.requireNonNull(zoneOffset, "offset");
        this.zone = (ZoneId) Jdk8Methods.requireNonNull(zoneId, "zone");
    }

    private ChronoZonedDateTimeImpl<D> create(Instant instant, ZoneId zoneId) {
        return ofInstant(toLocalDate().getChronology(), instant, zoneId);
    }

    static <R extends ChronoLocalDate> ChronoZonedDateTime<R> ofBest(ChronoLocalDateTimeImpl<R> chronoLocalDateTimeImpl, ZoneId zoneId, ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(chronoLocalDateTimeImpl, "localDateTime");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        LocalDateTime from = LocalDateTime.from(chronoLocalDateTimeImpl);
        List<ZoneOffset> validOffsets = rules.getValidOffsets(from);
        if (validOffsets.size() == 1) {
            zoneOffset = validOffsets.get(0);
        } else if (validOffsets.size() == 0) {
            ZoneOffsetTransition transition = rules.getTransition(from);
            chronoLocalDateTimeImpl = chronoLocalDateTimeImpl.plusSeconds(transition.getDuration().getSeconds());
            zoneOffset = transition.getOffsetAfter();
        } else if (zoneOffset == null || !validOffsets.contains(zoneOffset)) {
            zoneOffset = validOffsets.get(0);
        }
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, zoneOffset, zoneId);
    }

    static <R extends ChronoLocalDate> ChronoZonedDateTimeImpl<R> ofInstant(Chronology chronology, Instant instant, ZoneId zoneId) {
        ZoneOffset offset2 = zoneId.getRules().getOffset(instant);
        Jdk8Methods.requireNonNull(offset2, "offset");
        return new ChronoZonedDateTimeImpl<>((ChronoLocalDateTimeImpl) chronology.localDateTime(LocalDateTime.ofEpochSecond(instant.getEpochSecond(), instant.getNano(), offset2)), offset2, zoneId);
    }

    static ChronoZonedDateTime<?> readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        return ((ChronoLocalDateTime) objectInput.readObject()).atZone((ZoneOffset) objectInput.readObject()).withZoneSameLocal((ZoneId) objectInput.readObject());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 13, this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoZonedDateTime) || compareTo((ChronoZonedDateTime<?>) (ChronoZonedDateTime) obj) != 0) {
            return false;
        }
        return true;
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public ZoneId getZone() {
        return this.zone;
    }

    public int hashCode() {
        return (toLocalDateTime().hashCode() ^ getOffset().hashCode()) ^ Integer.rotateLeft(getZone().hashCode(), 3);
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit.isDateBased() || temporalUnit.isTimeBased()) {
                return true;
            }
            return false;
        } else if (temporalUnit == null || !temporalUnit.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public ChronoLocalDateTime<D> toLocalDateTime() {
        return this.dateTime;
    }

    public String toString() {
        String str = toLocalDateTime().toString() + getOffset().toString();
        if (getOffset() == getZone()) {
            return str;
        }
        return str + '[' + getZone().toString() + ']';
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoZonedDateTime<?> zonedDateTime = toLocalDate().getChronology().zonedDateTime(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, zonedDateTime);
        }
        return this.dateTime.until(zonedDateTime.withZoneSameInstant(this.offset).toLocalDateTime(), temporalUnit);
    }

    public ChronoZonedDateTime<D> withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(LocalDateTime.from(this));
        if (transition != null && transition.isOverlap()) {
            ZoneOffset offsetBefore = transition.getOffsetBefore();
            if (!offsetBefore.equals(this.offset)) {
                return new ChronoZonedDateTimeImpl(this.dateTime, offsetBefore, this.zone);
            }
        }
        return this;
    }

    public ChronoZonedDateTime<D> withLaterOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(LocalDateTime.from(this));
        if (transition != null) {
            ZoneOffset offsetAfter = transition.getOffsetAfter();
            if (!offsetAfter.equals(getOffset())) {
                return new ChronoZonedDateTimeImpl(this.dateTime, offsetAfter, this.zone);
            }
        }
        return this;
    }

    public ChronoZonedDateTime<D> withZoneSameInstant(ZoneId zoneId) {
        Jdk8Methods.requireNonNull(zoneId, "zone");
        if (this.zone.equals(zoneId)) {
            return this;
        }
        return create(this.dateTime.toInstant(this.offset), zoneId);
    }

    public ChronoZonedDateTime<D> withZoneSameLocal(ZoneId zoneId) {
        return ofBest(this.dateTime, zoneId, this.offset);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.dateTime);
        objectOutput.writeObject(this.offset);
        objectOutput.writeObject(this.zone);
    }

    public ChronoZonedDateTime<D> plus(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return with((TemporalAdjuster) this.dateTime.plus(j2, temporalUnit));
        }
        return toLocalDate().getChronology().ensureChronoZonedDateTime(temporalUnit.addTo(this, j2));
    }

    public ChronoZonedDateTime<D> with(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return toLocalDate().getChronology().ensureChronoZonedDateTime(temporalField.adjustInto(this, j2));
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i2 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
        if (i2 == 1) {
            return plus(j2 - toEpochSecond(), (TemporalUnit) ChronoUnit.SECONDS);
        }
        if (i2 != 2) {
            return ofBest(this.dateTime.with(temporalField, j2), this.zone, this.offset);
        }
        return create(this.dateTime.toInstant(ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j2))), this.zone);
    }

    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }
}
