package com.startapp;

public abstract class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final String f34224a = "ae";

    public abstract void a(be beVar);

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Context r12, java.lang.String[] r13, com.startapp.be.a r14, android.os.Bundle r15) {
        /*
            r11 = this;
            r0 = 0
            if (r13 == 0) goto L_0x007b
            int r1 = r13.length
            if (r1 != 0) goto L_0x0007
            goto L_0x007b
        L_0x0007:
            int r1 = r13.length
            r2 = 0
            r3 = 0
        L_0x000a:
            if (r2 >= r1) goto L_0x007a
            r4 = r13[r2]
            java.lang.Class r5 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x002f, all -> 0x0019 }
            java.lang.Class<com.startapp.be> r6 = com.startapp.be.class
            java.lang.Class r5 = r5.asSubclass(r6)     // Catch:{ ClassNotFoundException -> 0x002f, all -> 0x0019 }
            goto L_0x0030
        L_0x0019:
            java.lang.String r5 = f34224a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid class: "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r5, r6)
        L_0x002f:
            r5 = 0
        L_0x0030:
            if (r5 == 0) goto L_0x0077
            r6 = 3
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x0061 }
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r7[r0] = r8     // Catch:{ all -> 0x0061 }
            java.lang.Class<com.startapp.be$a> r8 = com.startapp.be.a.class
            r9 = 1
            r7[r9] = r8     // Catch:{ all -> 0x0061 }
            java.lang.Class<android.os.Bundle> r8 = android.os.Bundle.class
            r10 = 2
            r7[r10] = r8     // Catch:{ all -> 0x0061 }
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r7)     // Catch:{ all -> 0x0061 }
            r5.setAccessible(r9)     // Catch:{ all -> 0x0061 }
            android.content.Context r7 = com.startapp.ia.b(r12)     // Catch:{ all -> 0x0061 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0061 }
            r6[r0] = r7     // Catch:{ all -> 0x0061 }
            r6[r9] = r14     // Catch:{ all -> 0x0061 }
            r6[r10] = r15     // Catch:{ all -> 0x0061 }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ all -> 0x0061 }
            com.startapp.be r5 = (com.startapp.be) r5     // Catch:{ all -> 0x0061 }
            r11.a(r5)     // Catch:{ all -> 0x0061 }
            r3 = 1
            goto L_0x0077
        L_0x0061:
            java.lang.String r5 = f34224a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Could not instantiate "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            android.util.Log.e(r5, r4)
        L_0x0077:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x007a:
            return r3
        L_0x007b:
            java.lang.String r12 = f34224a
            java.lang.String r13 = "Class name is empty"
            android.util.Log.e(r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.ae.a(android.content.Context, java.lang.String[], com.startapp.be$a, android.os.Bundle):boolean");
    }
}
