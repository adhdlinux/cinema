package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.util.Range;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzch {
    private static final Map zza = new HashMap();
    private static List zzb;
    private static final Object zzc = new Object();

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static java.util.List zza(java.lang.String r13) {
        /*
            java.lang.Object r0 = zzc
            monitor-enter(r0)
            java.util.Map r1 = zza     // Catch:{ all -> 0x012c }
            boolean r2 = r1.containsKey(r13)     // Catch:{ all -> 0x012c }
            if (r2 == 0) goto L_0x0013
            java.lang.Object r13 = r1.get(r13)     // Catch:{ all -> 0x012c }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x012c }
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            return r13
        L_0x0013:
            monitor-enter(r0)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.util.List r1 = zzb     // Catch:{ all -> 0x0105 }
            r2 = 0
            if (r1 == 0) goto L_0x001b
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            goto L_0x002b
        L_0x001b:
            android.media.MediaCodecList r1 = new android.media.MediaCodecList     // Catch:{ all -> 0x0105 }
            r1.<init>(r2)     // Catch:{ all -> 0x0105 }
            android.media.MediaCodecInfo[] r1 = r1.getCodecInfos()     // Catch:{ all -> 0x0105 }
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch:{ all -> 0x0105 }
            zzb = r1     // Catch:{ all -> 0x0105 }
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
        L_0x002b:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r1.<init>()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.util.List r3 = zzb     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
        L_0x0036:
            boolean r4 = r3.hasNext()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            if (r4 == 0) goto L_0x00fe
            java.lang.Object r4 = r3.next()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            android.media.MediaCodecInfo r4 = (android.media.MediaCodecInfo) r4     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            boolean r5 = r4.isEncoder()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            if (r5 != 0) goto L_0x0036
            java.lang.String[] r5 = r4.getSupportedTypes()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            boolean r5 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            if (r5 == 0) goto L_0x0036
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.String r6 = "codecName"
            java.lang.String r7 = r4.getName()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r5.put(r6, r7)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            android.media.MediaCodecInfo$CodecCapabilities r4 = r4.getCapabilitiesForType(r13)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r6.<init>()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            android.media.MediaCodecInfo$CodecProfileLevel[] r7 = r4.profileLevels     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            int r8 = r7.length     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r9 = 0
        L_0x0071:
            if (r9 >= r8) goto L_0x008f
            r10 = r7[r9]     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r11 = 2
            java.lang.Integer[] r11 = new java.lang.Integer[r11]     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            int r12 = r10.profile     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r11[r2] = r12     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            int r10 = r10.level     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r12 = 1
            r11[r12] = r10     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r6.add(r11)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            int r9 = r9 + 1
            goto L_0x0071
        L_0x008f:
            java.lang.String r7 = "profileLevels"
            r5.put(r7, r6)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            android.media.MediaCodecInfo$VideoCapabilities r7 = r4.getVideoCapabilities()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.String r8 = "bitRatesBps"
            android.util.Range r9 = r7.getBitrateRange()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.Integer[] r9 = zzb(r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r5.put(r8, r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.String r8 = "widthAlignment"
            int r9 = r7.getWidthAlignment()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r5.put(r8, r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.String r8 = "heightAlignment"
            int r9 = r7.getHeightAlignment()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r5.put(r8, r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.String r8 = "frameRates"
            android.util.Range r9 = r7.getSupportedFrameRates()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.Integer[] r9 = zzb(r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r5.put(r8, r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.String r8 = "widths"
            android.util.Range r9 = r7.getSupportedWidths()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.Integer[] r9 = zzb(r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r5.put(r8, r9)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.String r8 = "heights"
            android.util.Range r7 = r7.getSupportedHeights()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.Integer[] r7 = zzb(r7)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r5.put(r8, r7)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r7 = 23
            if (r6 < r7) goto L_0x00f9
            java.lang.String r6 = "instancesLimit"
            int r4 = r4.getMaxSupportedInstances()     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r5.put(r6, r4)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
        L_0x00f9:
            r1.add(r5)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            goto L_0x0036
        L_0x00fe:
            java.util.Map r2 = zza     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            r2.put(r13, r1)     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            return r1
        L_0x0105:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            throw r1     // Catch:{ RuntimeException -> 0x010a, LinkageError -> 0x0108 }
        L_0x0108:
            r1 = move-exception
            goto L_0x010b
        L_0x010a:
            r1 = move-exception
        L_0x010b:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x012c }
            r2.<init>()     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "error"
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x012c }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ all -> 0x012c }
            r2.put(r3, r1)     // Catch:{ all -> 0x012c }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x012c }
            r1.<init>()     // Catch:{ all -> 0x012c }
            r1.add(r2)     // Catch:{ all -> 0x012c }
            java.util.Map r2 = zza     // Catch:{ all -> 0x012c }
            r2.put(r13, r1)     // Catch:{ all -> 0x012c }
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            return r1
        L_0x012c:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x012c }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzch.zza(java.lang.String):java.util.List");
    }

    @TargetApi(21)
    private static Integer[] zzb(Range range) {
        return new Integer[]{(Integer) range.getLower(), (Integer) range.getUpper()};
    }
}
