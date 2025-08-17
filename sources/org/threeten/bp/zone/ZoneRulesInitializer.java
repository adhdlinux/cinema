package org.threeten.bp.zone;

import androidx.media3.exoplayer.mediacodec.f;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ZoneRulesInitializer {
    public static final ZoneRulesInitializer DO_NOTHING = new DoNothingZoneRulesInitializer();
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean(false);
    private static final AtomicReference<ZoneRulesInitializer> INITIALIZER = new AtomicReference<>();

    static class DoNothingZoneRulesInitializer extends ZoneRulesInitializer {
        DoNothingZoneRulesInitializer() {
        }

        /* access modifiers changed from: protected */
        public void initializeProviders() {
        }
    }

    static class ServiceLoaderZoneRulesInitializer extends ZoneRulesInitializer {
        ServiceLoaderZoneRulesInitializer() {
        }

        /* access modifiers changed from: protected */
        public void initializeProviders() {
            Class<ZoneRulesProvider> cls = ZoneRulesProvider.class;
            Iterator<S> it2 = ServiceLoader.load(cls, cls.getClassLoader()).iterator();
            while (it2.hasNext()) {
                try {
                    ZoneRulesProvider.registerProvider((ZoneRulesProvider) it2.next());
                } catch (ServiceConfigurationError e2) {
                    if (!(e2.getCause() instanceof SecurityException)) {
                        throw e2;
                    }
                }
            }
        }
    }

    static void initialize() {
        if (!INITIALIZED.getAndSet(true)) {
            AtomicReference<ZoneRulesInitializer> atomicReference = INITIALIZER;
            f.a(atomicReference, (Object) null, new ServiceLoaderZoneRulesInitializer());
            atomicReference.get().initializeProviders();
            return;
        }
        throw new IllegalStateException("Already initialized");
    }

    public static void setInitializer(ZoneRulesInitializer zoneRulesInitializer) {
        if (INITIALIZED.get()) {
            throw new IllegalStateException("Already initialized");
        } else if (!f.a(INITIALIZER, (Object) null, zoneRulesInitializer)) {
            throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void initializeProviders();
}
