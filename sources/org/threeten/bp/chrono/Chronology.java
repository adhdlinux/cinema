package org.threeten.bp.chrono;

import com.facebook.hermes.intl.Constants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public abstract class Chronology implements Comparable<Chronology> {
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_ID = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_TYPE = new ConcurrentHashMap<>();
    public static final TemporalQuery<Chronology> FROM = new TemporalQuery<Chronology>() {
        public Chronology queryFrom(TemporalAccessor temporalAccessor) {
            return Chronology.from(temporalAccessor);
        }
    };
    private static final Method LOCALE_METHOD;

    static {
        Method method;
        try {
            method = Locale.class.getMethod("getUnicodeLocaleType", new Class[]{String.class});
        } catch (Throwable unused) {
            method = null;
        }
        LOCALE_METHOD = method;
    }

    protected Chronology() {
    }

    public static Chronology from(TemporalAccessor temporalAccessor) {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology != null) {
            return chronology;
        }
        return IsoChronology.INSTANCE;
    }

    public static Set<Chronology> getAvailableChronologies() {
        init();
        return new HashSet(CHRONOS_BY_ID.values());
    }

    private static void init() {
        ConcurrentHashMap<String, Chronology> concurrentHashMap = CHRONOS_BY_ID;
        if (concurrentHashMap.isEmpty()) {
            register(IsoChronology.INSTANCE);
            register(ThaiBuddhistChronology.INSTANCE);
            register(MinguoChronology.INSTANCE);
            register(JapaneseChronology.INSTANCE);
            HijrahChronology hijrahChronology = HijrahChronology.INSTANCE;
            register(hijrahChronology);
            concurrentHashMap.putIfAbsent("Hijrah", hijrahChronology);
            CHRONOS_BY_TYPE.putIfAbsent("islamic", hijrahChronology);
            Class<Chronology> cls = Chronology.class;
            Iterator<S> it2 = ServiceLoader.load(cls, cls.getClassLoader()).iterator();
            while (it2.hasNext()) {
                Chronology chronology = (Chronology) it2.next();
                CHRONOS_BY_ID.putIfAbsent(chronology.getId(), chronology);
                String calendarType = chronology.getCalendarType();
                if (calendarType != null) {
                    CHRONOS_BY_TYPE.putIfAbsent(calendarType, chronology);
                }
            }
        }
    }

    public static Chronology of(String str) {
        init();
        Chronology chronology = CHRONOS_BY_ID.get(str);
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = CHRONOS_BY_TYPE.get(str);
        if (chronology2 != null) {
            return chronology2;
        }
        throw new DateTimeException("Unknown chronology: " + str);
    }

    public static Chronology ofLocale(Locale locale) {
        String str;
        init();
        Jdk8Methods.requireNonNull(locale, Constants.LOCALE);
        Method method = LOCALE_METHOD;
        if (method != null) {
            try {
                str = (String) method.invoke(locale, new Object[]{"ca"});
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        } else {
            if (locale.equals(JapaneseChronology.LOCALE)) {
                str = "japanese";
            }
            str = "iso";
        }
        if (str == null || "iso".equals(str) || "iso8601".equals(str)) {
            return IsoChronology.INSTANCE;
        }
        Chronology chronology = CHRONOS_BY_TYPE.get(str);
        if (chronology != null) {
            return chronology;
        }
        throw new DateTimeException("Unknown calendar system: " + str);
    }

    static Chronology readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readUTF());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static void register(Chronology chronology) {
        CHRONOS_BY_ID.putIfAbsent(chronology.getId(), chronology);
        String calendarType = chronology.getCalendarType();
        if (calendarType != null) {
            CHRONOS_BY_TYPE.putIfAbsent(calendarType, chronology);
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 11, this);
    }

    public abstract ChronoLocalDate date(int i2, int i3, int i4);

    public ChronoLocalDate date(Era era, int i2, int i3, int i4) {
        return date(prolepticYear(era, i2), i3, i4);
    }

    public abstract ChronoLocalDate date(TemporalAccessor temporalAccessor);

    public abstract ChronoLocalDate dateEpochDay(long j2);

    public ChronoLocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    public abstract ChronoLocalDate dateYearDay(int i2, int i3);

    public ChronoLocalDate dateYearDay(Era era, int i2, int i3) {
        return dateYearDay(prolepticYear(era, i2), i3);
    }

    /* access modifiers changed from: package-private */
    public <D extends ChronoLocalDate> D ensureChronoLocalDate(Temporal temporal) {
        D d2 = (ChronoLocalDate) temporal;
        if (equals(d2.getChronology())) {
            return d2;
        }
        throw new ClassCastException("Chrono mismatch, expected: " + getId() + ", actual: " + d2.getChronology().getId());
    }

    /* access modifiers changed from: package-private */
    public <D extends ChronoLocalDate> ChronoLocalDateTimeImpl<D> ensureChronoLocalDateTime(Temporal temporal) {
        ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) temporal;
        if (equals(chronoLocalDateTimeImpl.toLocalDate().getChronology())) {
            return chronoLocalDateTimeImpl;
        }
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + chronoLocalDateTimeImpl.toLocalDate().getChronology().getId());
    }

    /* access modifiers changed from: package-private */
    public <D extends ChronoLocalDate> ChronoZonedDateTimeImpl<D> ensureChronoZonedDateTime(Temporal temporal) {
        ChronoZonedDateTimeImpl<D> chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) temporal;
        if (equals(chronoZonedDateTimeImpl.toLocalDate().getChronology())) {
            return chronoZonedDateTimeImpl;
        }
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + chronoZonedDateTimeImpl.toLocalDate().getChronology().getId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Chronology) || compareTo((Chronology) obj) != 0) {
            return false;
        }
        return true;
    }

    public abstract Era eraOf(int i2);

    public abstract List<Era> eras();

    public abstract String getCalendarType();

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendChronologyText(textStyle).toFormatter(locale).format(new DefaultInterfaceTemporalAccessor() {
            public long getLong(TemporalField temporalField) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }

            public boolean isSupported(TemporalField temporalField) {
                return false;
            }

            public <R> R query(TemporalQuery<R> temporalQuery) {
                if (temporalQuery == TemporalQueries.chronology()) {
                    return Chronology.this;
                }
                return super.query(temporalQuery);
            }
        });
    }

    public abstract String getId();

    public int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    public abstract boolean isLeapYear(long j2);

    public ChronoLocalDateTime<?> localDateTime(TemporalAccessor temporalAccessor) {
        try {
            return date(temporalAccessor).atTime(LocalTime.from(temporalAccessor));
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e2);
        }
    }

    public ChronoPeriod period(int i2, int i3, int i4) {
        return new ChronoPeriodImpl(this, i2, i3, i4);
    }

    public abstract int prolepticYear(Era era, int i2);

    public abstract ValueRange range(ChronoField chronoField);

    public abstract ChronoLocalDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle);

    public String toString() {
        return getId();
    }

    /* access modifiers changed from: package-private */
    public void updateResolveMap(Map<TemporalField, Long> map, ChronoField chronoField, long j2) {
        Long l2 = map.get(chronoField);
        if (l2 == null || l2.longValue() == j2) {
            map.put(chronoField, Long.valueOf(j2));
            return;
        }
        throw new DateTimeException("Invalid state, field: " + chronoField + " " + l2 + " conflicts with " + chronoField + " " + j2);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(getId());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        return org.threeten.bp.chrono.ChronoZonedDateTimeImpl.ofBest(ensureChronoLocalDateTime(localDateTime(r5)), r0, (org.threeten.bp.ZoneOffset) null);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.chrono.ChronoZonedDateTime<?> zonedDateTime(org.threeten.bp.temporal.TemporalAccessor r5) {
        /*
            r4 = this;
            org.threeten.bp.ZoneId r0 = org.threeten.bp.ZoneId.from(r5)     // Catch:{ DateTimeException -> 0x001b }
            org.threeten.bp.Instant r1 = org.threeten.bp.Instant.from(r5)     // Catch:{ DateTimeException -> 0x000d }
            org.threeten.bp.chrono.ChronoZonedDateTime r5 = r4.zonedDateTime(r1, r0)     // Catch:{ DateTimeException -> 0x000d }
            return r5
        L_0x000d:
            org.threeten.bp.chrono.ChronoLocalDateTime r1 = r4.localDateTime(r5)     // Catch:{ DateTimeException -> 0x001b }
            org.threeten.bp.chrono.ChronoLocalDateTimeImpl r1 = r4.ensureChronoLocalDateTime(r1)     // Catch:{ DateTimeException -> 0x001b }
            r2 = 0
            org.threeten.bp.chrono.ChronoZonedDateTime r5 = org.threeten.bp.chrono.ChronoZonedDateTimeImpl.ofBest(r1, r0, r2)     // Catch:{ DateTimeException -> 0x001b }
            return r5
        L_0x001b:
            r0 = move-exception
            org.threeten.bp.DateTimeException r1 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unable to obtain ChronoZonedDateTime from TemporalAccessor: "
            r2.append(r3)
            java.lang.Class r5 = r5.getClass()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.Chronology.zonedDateTime(org.threeten.bp.temporal.TemporalAccessor):org.threeten.bp.chrono.ChronoZonedDateTime");
    }

    public int compareTo(Chronology chronology) {
        return getId().compareTo(chronology.getId());
    }

    public ChronoLocalDate dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    public ChronoLocalDate dateNow(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return date(LocalDate.now(clock));
    }

    public ChronoZonedDateTime<?> zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }
}
