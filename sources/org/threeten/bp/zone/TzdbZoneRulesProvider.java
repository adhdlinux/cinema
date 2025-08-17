package org.threeten.bp.zone;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class TzdbZoneRulesProvider extends ZoneRulesProvider {
    private Set<String> loadedUrls = new CopyOnWriteArraySet();
    private List<String> regionIds;
    private final ConcurrentNavigableMap<String, Version> versions = new ConcurrentSkipListMap();

    static class Version {
        private final String[] regionArray;
        private final AtomicReferenceArray<Object> ruleData;
        private final short[] ruleIndices;
        /* access modifiers changed from: private */
        public final String versionId;

        Version(String str, String[] strArr, short[] sArr, AtomicReferenceArray<Object> atomicReferenceArray) {
            this.ruleData = atomicReferenceArray;
            this.versionId = str;
            this.regionArray = strArr;
            this.ruleIndices = sArr;
        }

        /* access modifiers changed from: package-private */
        public ZoneRules createRule(short s2) throws Exception {
            Object obj = this.ruleData.get(s2);
            if (obj instanceof byte[]) {
                obj = Ser.read(new DataInputStream(new ByteArrayInputStream((byte[]) obj)));
                this.ruleData.set(s2, obj);
            }
            return (ZoneRules) obj;
        }

        /* access modifiers changed from: package-private */
        public ZoneRules getRules(String str) {
            int binarySearch = Arrays.binarySearch(this.regionArray, str);
            if (binarySearch < 0) {
                return null;
            }
            try {
                return createRule(this.ruleIndices[binarySearch]);
            } catch (Exception e2) {
                throw new ZoneRulesException("Invalid binary time-zone data: TZDB:" + str + ", version: " + this.versionId, e2);
            }
        }

        public String toString() {
            return this.versionId;
        }
    }

    public TzdbZoneRulesProvider() {
        if (!load(ZoneRulesProvider.class.getClassLoader())) {
            throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
        }
    }

    private boolean load(ClassLoader classLoader) {
        URL url = null;
        try {
            Enumeration<URL> resources = classLoader.getResources("org/threeten/bp/TZDB.dat");
            boolean z2 = false;
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                try {
                    z2 |= load(nextElement);
                    URL url2 = nextElement;
                } catch (Exception e2) {
                    e = e2;
                    url = nextElement;
                    throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + url, e);
                }
            }
            return z2;
        } catch (Exception e3) {
            e = e3;
            throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + url, e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Iterable<org.threeten.bp.zone.TzdbZoneRulesProvider.Version> loadData(java.io.InputStream r13) throws java.io.IOException, java.io.StreamCorruptedException {
        /*
            r12 = this;
            java.io.DataInputStream r0 = new java.io.DataInputStream
            r0.<init>(r13)
            byte r13 = r0.readByte()
            r1 = 1
            java.lang.String r2 = "File format not recognised"
            if (r13 != r1) goto L_0x0099
            java.lang.String r13 = r0.readUTF()
            java.lang.String r1 = "TZDB"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x0093
            short r13 = r0.readShort()
            java.lang.String[] r1 = new java.lang.String[r13]
            r2 = 0
            r3 = 0
        L_0x0022:
            if (r3 >= r13) goto L_0x002d
            java.lang.String r4 = r0.readUTF()
            r1[r3] = r4
            int r3 = r3 + 1
            goto L_0x0022
        L_0x002d:
            short r3 = r0.readShort()
            java.lang.String[] r4 = new java.lang.String[r3]
            r5 = 0
        L_0x0034:
            if (r5 >= r3) goto L_0x003f
            java.lang.String r6 = r0.readUTF()
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x0034
        L_0x003f:
            java.util.List r3 = java.util.Arrays.asList(r4)
            r12.regionIds = r3
            short r3 = r0.readShort()
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r6 = 0
        L_0x004c:
            if (r6 >= r3) goto L_0x005c
            short r7 = r0.readShort()
            byte[] r7 = new byte[r7]
            r0.readFully(r7)
            r5[r6] = r7
            int r6 = r6 + 1
            goto L_0x004c
        L_0x005c:
            java.util.concurrent.atomic.AtomicReferenceArray r3 = new java.util.concurrent.atomic.AtomicReferenceArray
            r3.<init>(r5)
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>(r13)
            r6 = 0
        L_0x0067:
            if (r6 >= r13) goto L_0x0092
            short r7 = r0.readShort()
            java.lang.String[] r8 = new java.lang.String[r7]
            short[] r9 = new short[r7]
            r10 = 0
        L_0x0072:
            if (r10 >= r7) goto L_0x0085
            short r11 = r0.readShort()
            r11 = r4[r11]
            r8[r10] = r11
            short r11 = r0.readShort()
            r9[r10] = r11
            int r10 = r10 + 1
            goto L_0x0072
        L_0x0085:
            org.threeten.bp.zone.TzdbZoneRulesProvider$Version r7 = new org.threeten.bp.zone.TzdbZoneRulesProvider$Version
            r10 = r1[r6]
            r7.<init>(r10, r8, r9, r3)
            r5.add(r7)
            int r6 = r6 + 1
            goto L_0x0067
        L_0x0092:
            return r5
        L_0x0093:
            java.io.StreamCorruptedException r13 = new java.io.StreamCorruptedException
            r13.<init>(r2)
            throw r13
        L_0x0099:
            java.io.StreamCorruptedException r13 = new java.io.StreamCorruptedException
            r13.<init>(r2)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.TzdbZoneRulesProvider.loadData(java.io.InputStream):java.lang.Iterable");
    }

    /* access modifiers changed from: protected */
    public ZoneRules provideRules(String str, boolean z2) {
        Jdk8Methods.requireNonNull(str, "zoneId");
        ZoneRules rules = this.versions.lastEntry().getValue().getRules(str);
        if (rules != null) {
            return rules;
        }
        throw new ZoneRulesException("Unknown time-zone ID: " + str);
    }

    /* access modifiers changed from: protected */
    public NavigableMap<String, ZoneRules> provideVersions(String str) {
        TreeMap treeMap = new TreeMap();
        for (Version next : this.versions.values()) {
            ZoneRules rules = next.getRules(str);
            if (rules != null) {
                treeMap.put(next.versionId, rules);
            }
        }
        return treeMap;
    }

    /* access modifiers changed from: protected */
    public Set<String> provideZoneIds() {
        return new HashSet(this.regionIds);
    }

    public String toString() {
        return "TZDB";
    }

    public TzdbZoneRulesProvider(URL url) {
        try {
            if (!load(url)) {
                throw new ZoneRulesException("No time-zone rules found: " + url);
            }
        } catch (Exception e2) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + url, e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean load(java.net.URL r3) throws java.lang.ClassNotFoundException, java.io.IOException, org.threeten.bp.zone.ZoneRulesException {
        /*
            r2 = this;
            java.util.Set<java.lang.String> r0 = r2.loadedUrls
            java.lang.String r1 = r3.toExternalForm()
            boolean r0 = r0.add(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0026
            java.io.InputStream r3 = r3.openStream()     // Catch:{ all -> 0x001e }
            boolean r0 = r2.load((java.io.InputStream) r3)     // Catch:{ all -> 0x001c }
            r1 = r1 | r0
            if (r3 == 0) goto L_0x0026
            r3.close()
            goto L_0x0026
        L_0x001c:
            r0 = move-exception
            goto L_0x0020
        L_0x001e:
            r0 = move-exception
            r3 = 0
        L_0x0020:
            if (r3 == 0) goto L_0x0025
            r3.close()
        L_0x0025:
            throw r0
        L_0x0026:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.TzdbZoneRulesProvider.load(java.net.URL):boolean");
    }

    private boolean load(InputStream inputStream) throws IOException, StreamCorruptedException {
        boolean z2 = false;
        for (Version next : loadData(inputStream)) {
            Version putIfAbsent = this.versions.putIfAbsent(next.versionId, next);
            if (putIfAbsent == null || putIfAbsent.versionId.equals(next.versionId)) {
                z2 = true;
            } else {
                throw new ZoneRulesException("Data already loaded for TZDB time-zone rules version: " + next.versionId);
            }
        }
        return z2;
    }

    public TzdbZoneRulesProvider(InputStream inputStream) {
        try {
            load(inputStream);
        } catch (Exception e2) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules", e2);
        }
    }
}
