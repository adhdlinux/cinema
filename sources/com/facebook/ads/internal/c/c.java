package com.facebook.ads.internal.c;

public class c {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f20059a;

        /* renamed from: b  reason: collision with root package name */
        public String f20060b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f20061c;

        public a(String str, String str2, boolean z2) {
            this.f20059a = str;
            this.f20060b = str2;
            this.f20061c = z2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:19|20|(1:22)|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = new com.facebook.ads.internal.c.c.a((java.lang.String) null, (java.lang.String) null, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        if (r11 != null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.ads.internal.c.c.a a(android.content.ContentResolver r11) {
        /*
            java.lang.String r0 = "limit_tracking"
            java.lang.String r1 = "androidid"
            java.lang.String r2 = "aid"
            r3 = 0
            r4 = 0
            java.lang.String[] r7 = new java.lang.String[]{r2, r1, r0}     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            java.lang.String r5 = "content://com.facebook.katana.provider.AttributionIdProvider"
            android.net.Uri r6 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r8 = 0
            r9 = 0
            r10 = 0
            r5 = r11
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            if (r11 == 0) goto L_0x004c
            boolean r5 = r11.moveToFirst()     // Catch:{ Exception -> 0x005a }
            if (r5 != 0) goto L_0x0023
            goto L_0x004c
        L_0x0023:
            int r2 = r11.getColumnIndex(r2)     // Catch:{ Exception -> 0x005a }
            java.lang.String r2 = r11.getString(r2)     // Catch:{ Exception -> 0x005a }
            int r1 = r11.getColumnIndex(r1)     // Catch:{ Exception -> 0x005a }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ Exception -> 0x005a }
            int r0 = r11.getColumnIndex(r0)     // Catch:{ Exception -> 0x005a }
            java.lang.String r0 = r11.getString(r0)     // Catch:{ Exception -> 0x005a }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x005a }
            com.facebook.ads.internal.c.c$a r5 = new com.facebook.ads.internal.c.c$a     // Catch:{ Exception -> 0x005a }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x005a }
            r5.<init>(r2, r1, r0)     // Catch:{ Exception -> 0x005a }
            r11.close()
            return r5
        L_0x004c:
            com.facebook.ads.internal.c.c$a r0 = new com.facebook.ads.internal.c.c$a     // Catch:{ Exception -> 0x005a }
            r0.<init>(r4, r4, r3)     // Catch:{ Exception -> 0x005a }
            if (r11 == 0) goto L_0x0056
            r11.close()
        L_0x0056:
            return r0
        L_0x0057:
            r0 = move-exception
            goto L_0x0067
        L_0x0059:
            r11 = r4
        L_0x005a:
            com.facebook.ads.internal.c.c$a r0 = new com.facebook.ads.internal.c.c$a     // Catch:{ all -> 0x0065 }
            r0.<init>(r4, r4, r3)     // Catch:{ all -> 0x0065 }
            if (r11 == 0) goto L_0x0064
            r11.close()
        L_0x0064:
            return r0
        L_0x0065:
            r0 = move-exception
            r4 = r11
        L_0x0067:
            if (r4 == 0) goto L_0x006c
            r4.close()
        L_0x006c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.c.c.a(android.content.ContentResolver):com.facebook.ads.internal.c.c$a");
    }
}
