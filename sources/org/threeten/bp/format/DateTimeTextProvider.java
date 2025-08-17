package org.threeten.bp.format;

import androidx.media3.exoplayer.mediacodec.f;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.temporal.TemporalField;

public abstract class DateTimeTextProvider {
    /* access modifiers changed from: private */
    public static final AtomicReference<DateTimeTextProvider> MUTABLE_PROVIDER = new AtomicReference<>();

    static class ProviderSingleton {
        static final DateTimeTextProvider PROVIDER = initialize();

        ProviderSingleton() {
        }

        static DateTimeTextProvider initialize() {
            f.a(DateTimeTextProvider.MUTABLE_PROVIDER, (Object) null, new SimpleDateTimeTextProvider());
            return (DateTimeTextProvider) DateTimeTextProvider.MUTABLE_PROVIDER.get();
        }
    }

    static DateTimeTextProvider getInstance() {
        return ProviderSingleton.PROVIDER;
    }

    public static void setInitializer(DateTimeTextProvider dateTimeTextProvider) {
        if (!f.a(MUTABLE_PROVIDER, (Object) null, dateTimeTextProvider)) {
            throw new IllegalStateException("Provider was already set, possibly with a default during initialization");
        }
    }

    public abstract String getText(TemporalField temporalField, long j2, TextStyle textStyle, Locale locale);

    public abstract Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField temporalField, TextStyle textStyle, Locale locale);
}
