package com.original.tase.helper;

public class GkPluginsHelper {

    private static class GkLink {

        /* renamed from: a  reason: collision with root package name */
        private String f33835a;

        /* renamed from: b  reason: collision with root package name */
        private String f33836b;

        private GkLink() {
        }

        public String a() {
            return this.f33835a;
        }

        public String b() {
            return this.f33836b;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008d A[Catch:{ all -> 0x00ab, all -> 0x00b2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> a(java.lang.String r7) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
            com.google.gson.JsonParser r2 = new com.google.gson.JsonParser     // Catch:{ all -> 0x00b2 }
            r2.<init>()     // Catch:{ all -> 0x00b2 }
            com.google.gson.JsonElement r7 = r2.a(r7)     // Catch:{ all -> 0x00b2 }
            if (r7 == 0) goto L_0x00b1
            boolean r2 = r7.i()     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x00b1
            com.google.gson.JsonObject r7 = r7.c()     // Catch:{ all -> 0x00ab }
            java.lang.String r2 = "link"
            com.google.gson.JsonElement r7 = r7.m(r2)     // Catch:{ all -> 0x00ab }
            if (r7 == 0) goto L_0x00aa
            boolean r2 = r7.h()     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x002b
            goto L_0x00aa
        L_0x002b:
            boolean r2 = r7.g()     // Catch:{ all -> 0x00ab }
            java.lang.String r3 = "HQ"
            if (r2 == 0) goto L_0x009d
            com.google.gson.JsonArray r7 = r7.b()     // Catch:{ all -> 0x00ab }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00ab }
        L_0x003b:
            boolean r2 = r7.hasNext()     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x00aa
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ all -> 0x00ab }
            r2.<init>()     // Catch:{ all -> 0x00ab }
            java.lang.Object r4 = r7.next()     // Catch:{ all -> 0x00ab }
            com.google.gson.JsonElement r4 = (com.google.gson.JsonElement) r4     // Catch:{ all -> 0x00ab }
            java.lang.Class<com.original.tase.helper.GkPluginsHelper$GkLink> r5 = com.original.tase.helper.GkPluginsHelper.GkLink.class
            java.lang.Object r2 = r2.h(r4, r5)     // Catch:{ all -> 0x00ab }
            com.original.tase.helper.GkPluginsHelper$GkLink r2 = (com.original.tase.helper.GkPluginsHelper.GkLink) r2     // Catch:{ all -> 0x00ab }
            java.lang.String r4 = r2.b()     // Catch:{ all -> 0x00ab }
            if (r4 == 0) goto L_0x003b
            java.lang.String r4 = r2.b()     // Catch:{ all -> 0x00ab }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x00ab }
            if (r4 != 0) goto L_0x003b
            java.lang.String r4 = r2.b()     // Catch:{ all -> 0x00ab }
            java.lang.String r5 = r2.a()     // Catch:{ all -> 0x00ab }
            if (r5 == 0) goto L_0x0086
            java.lang.String r5 = r2.a()     // Catch:{ all -> 0x00ab }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x00ab }
            if (r5 == 0) goto L_0x0079
            goto L_0x0086
        L_0x0079:
            java.lang.String r2 = r2.a()     // Catch:{ all -> 0x00ab }
            java.lang.String r5 = "P"
            java.lang.String r6 = "p"
            java.lang.String r2 = r2.replace(r5, r6)     // Catch:{ all -> 0x00ab }
            goto L_0x0087
        L_0x0086:
            r2 = 0
        L_0x0087:
            boolean r5 = r2.isEmpty()     // Catch:{ all -> 0x00ab }
            if (r5 == 0) goto L_0x0099
            boolean r2 = com.original.tase.helper.GoogleVideoHelper.n(r4)     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x0098
            java.lang.String r2 = com.original.tase.helper.GoogleVideoHelper.h(r4)     // Catch:{ all -> 0x00ab }
            goto L_0x0099
        L_0x0098:
            r2 = r3
        L_0x0099:
            r0.put(r4, r2)     // Catch:{ all -> 0x00ab }
            goto L_0x003b
        L_0x009d:
            java.lang.String r2 = r7.e()     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x00aa
            java.lang.String r7 = r7.e()     // Catch:{ all -> 0x00ab }
            r0.put(r7, r3)     // Catch:{ all -> 0x00ab }
        L_0x00aa:
            return r0
        L_0x00ab:
            r7 = move-exception
            boolean[] r2 = new boolean[r1]     // Catch:{ all -> 0x00b2 }
            com.original.tase.Logger.d(r7, r2)     // Catch:{ all -> 0x00b2 }
        L_0x00b1:
            return r0
        L_0x00b2:
            r7 = move-exception
            boolean[] r1 = new boolean[r1]
            com.original.tase.Logger.d(r7, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.GkPluginsHelper.a(java.lang.String):java.util.HashMap");
    }
}
