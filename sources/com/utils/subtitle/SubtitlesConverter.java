package com.utils.subtitle;

public class SubtitlesConverter {
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b5 A[SYNTHETIC, Splitter:B:52:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c7 A[SYNTHETIC, Splitter:B:62:0x00c7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r5, com.utils.subtitle.converter.TimedTextFileFormat r6) {
        /*
            java.lang.String r0 = ".ass"
            boolean r0 = r5.contains(r0)
            if (r0 == 0) goto L_0x000e
            com.utils.subtitle.converter.FormatASS r0 = new com.utils.subtitle.converter.FormatASS
            r0.<init>()
            goto L_0x003d
        L_0x000e:
            java.lang.String r0 = ".scc"
            boolean r0 = r5.contains(r0)
            if (r0 == 0) goto L_0x001c
            com.utils.subtitle.converter.FormatSCC r0 = new com.utils.subtitle.converter.FormatSCC
            r0.<init>()
            goto L_0x003d
        L_0x001c:
            java.lang.String r0 = ".ssa"
            boolean r0 = r5.contains(r0)
            if (r0 == 0) goto L_0x002a
            com.utils.subtitle.converter.FormatASS r0 = new com.utils.subtitle.converter.FormatASS
            r0.<init>()
            goto L_0x003d
        L_0x002a:
            java.lang.String r0 = ".ttml"
            boolean r0 = r5.contains(r0)
            if (r0 == 0) goto L_0x0038
            com.utils.subtitle.converter.FormatSCC r0 = new com.utils.subtitle.converter.FormatSCC
            r0.<init>()
            goto L_0x003d
        L_0x0038:
            com.utils.subtitle.converter.FormatSRT r0 = new com.utils.subtitle.converter.FormatSRT
            r0.<init>()
        L_0x003d:
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r2 = r1.exists()
            r3 = 0
            if (r2 != 0) goto L_0x004a
            return r3
        L_0x004a:
            java.lang.String r5 = com.utils.Utils.z(r5)
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r4 = 26
            if (r2 < r4) goto L_0x0060
            java.nio.file.Path r2 = r1.toPath()     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r4 = 0
            java.nio.file.OpenOption[] r4 = new java.nio.file.OpenOption[r4]     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            java.io.InputStream r2 = java.nio.file.Files.newInputStream(r2, r4)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            goto L_0x0065
        L_0x0060:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00ad, all -> 0x00aa }
        L_0x0065:
            com.utils.UnicodeBOMInputStream r4 = new com.utils.UnicodeBOMInputStream     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            com.utils.subtitle.converter.TimedTextObject r5 = r0.a(r1, r4, r5)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "Cinema HD"
            r5.f37736d = r0     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r5 = r6.b(r5)     // Catch:{ Exception -> 0x00a2 }
            boolean r6 = r5 instanceof java.lang.String[]     // Catch:{ Exception -> 0x00a2 }
            if (r6 == 0) goto L_0x0094
            java.lang.String r6 = "\n"
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r5 = android.text.TextUtils.join(r6, r5)     // Catch:{ Exception -> 0x00a2 }
            if (r2 == 0) goto L_0x0093
            r2.close()     // Catch:{ IOException -> 0x008f }
            r4.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0093
        L_0x008f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0093:
            return r5
        L_0x0094:
            if (r2 == 0) goto L_0x00a1
            r2.close()     // Catch:{ IOException -> 0x009d }
            r4.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a1
        L_0x009d:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00a1:
            return r3
        L_0x00a2:
            r5 = move-exception
            goto L_0x00b0
        L_0x00a4:
            r5 = move-exception
            r4 = r3
            goto L_0x00c4
        L_0x00a7:
            r5 = move-exception
            r4 = r3
            goto L_0x00b0
        L_0x00aa:
            r5 = move-exception
            r4 = r3
            goto L_0x00c5
        L_0x00ad:
            r5 = move-exception
            r2 = r3
            r4 = r2
        L_0x00b0:
            r5.printStackTrace()     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x00c2
            r2.close()     // Catch:{ IOException -> 0x00be }
            if (r4 == 0) goto L_0x00c2
            r4.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x00be:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00c2:
            return r3
        L_0x00c3:
            r5 = move-exception
        L_0x00c4:
            r3 = r2
        L_0x00c5:
            if (r3 == 0) goto L_0x00d4
            r3.close()     // Catch:{ IOException -> 0x00d0 }
            if (r4 == 0) goto L_0x00d4
            r4.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00d4:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.SubtitlesConverter.a(java.lang.String, com.utils.subtitle.converter.TimedTextFileFormat):java.lang.String");
    }
}
