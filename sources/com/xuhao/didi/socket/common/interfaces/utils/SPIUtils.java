package com.xuhao.didi.socket.common.interfaces.utils;

public class SPIUtils {
    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class, java.lang.Class<E>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> E load(java.lang.Class<E> r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0009
            java.lang.String r4 = "load null clz error!"
            com.xuhao.didi.core.utils.SLog.e(r4)
            return r0
        L_0x0009:
            java.lang.ClassLoader r1 = r4.getClassLoader()
            java.util.ServiceLoader r1 = java.util.ServiceLoader.load(r4, r1)
            java.util.Iterator r1 = r1.iterator()
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0045
            java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x0020 }
            return r4
        L_0x0020:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "load "
            r2.append(r3)
            java.lang.String r4 = r4.getSimpleName()
            r2.append(r4)
            java.lang.String r4 = " error! "
            r2.append(r4)
            java.lang.String r4 = r1.getMessage()
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            com.xuhao.didi.core.utils.SLog.e(r4)
        L_0x0045:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xuhao.didi.socket.common.interfaces.utils.SPIUtils.load(java.lang.Class):java.lang.Object");
    }
}
