package org.threeten.bp.zone;

import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.jdk8.Jdk8Methods;

public abstract class ZoneRulesProvider {
    private static final CopyOnWriteArrayList<ZoneRulesProvider> PROVIDERS = new CopyOnWriteArrayList<>();
    private static final ConcurrentMap<String, ZoneRulesProvider> ZONES = new ConcurrentHashMap(512, 0.75f, 2);

    static {
        ZoneRulesInitializer.initialize();
    }

    protected ZoneRulesProvider() {
    }

    public static Set<String> getAvailableZoneIds() {
        return Collections.unmodifiableSet(ZONES.keySet());
    }

    private static ZoneRulesProvider getProvider(String str) {
        ConcurrentMap<String, ZoneRulesProvider> concurrentMap = ZONES;
        ZoneRulesProvider zoneRulesProvider = concurrentMap.get(str);
        if (zoneRulesProvider != null) {
            return zoneRulesProvider;
        }
        if (concurrentMap.isEmpty()) {
            throw new ZoneRulesException("No time-zone data files registered");
        }
        throw new ZoneRulesException("Unknown time-zone ID: " + str);
    }

    public static ZoneRules getRules(String str, boolean z2) {
        Jdk8Methods.requireNonNull(str, "zoneId");
        return getProvider(str).provideRules(str, z2);
    }

    public static NavigableMap<String, ZoneRules> getVersions(String str) {
        Jdk8Methods.requireNonNull(str, "zoneId");
        return getProvider(str).provideVersions(str);
    }

    public static boolean refresh() {
        Iterator<ZoneRulesProvider> it2 = PROVIDERS.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            z2 |= it2.next().provideRefresh();
        }
        return z2;
    }

    public static void registerProvider(ZoneRulesProvider zoneRulesProvider) {
        Jdk8Methods.requireNonNull(zoneRulesProvider, "provider");
        registerProvider0(zoneRulesProvider);
        PROVIDERS.add(zoneRulesProvider);
    }

    private static void registerProvider0(ZoneRulesProvider zoneRulesProvider) {
        for (String next : zoneRulesProvider.provideZoneIds()) {
            Jdk8Methods.requireNonNull(next, "zoneId");
            if (ZONES.putIfAbsent(next, zoneRulesProvider) != null) {
                throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + next + ", currently loading from provider: " + zoneRulesProvider);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean provideRefresh() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract ZoneRules provideRules(String str, boolean z2);

    /* access modifiers changed from: protected */
    public abstract NavigableMap<String, ZoneRules> provideVersions(String str);

    /* access modifiers changed from: protected */
    public abstract Set<String> provideZoneIds();
}
