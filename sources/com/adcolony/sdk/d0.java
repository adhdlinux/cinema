package com.adcolony.sdk;

import java.net.URL;

class d0 {

    /* renamed from: a  reason: collision with root package name */
    private URL f13106a;

    d0(URL url) {
        this.f13106a = url;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.DataOutputStream} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            java.net.URL r2 = r6.f13106a     // Catch:{ IOException -> 0x0070, all -> 0x006c }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x0070, all -> 0x006c }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x0070, all -> 0x006c }
            java.lang.String r3 = "POST"
            r2.setRequestMethod(r3)     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
            java.lang.String r3 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r2.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json"
            r2.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
            r3 = 1
            r2.setDoInput(r3)     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
            java.io.OutputStream r5 = r2.getOutputStream()     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x005f, all -> 0x005d }
            r5.<init>(r4)     // Catch:{ IOException -> 0x005f, all -> 0x005d }
            java.nio.charset.Charset r0 = com.adcolony.sdk.h.f13158a     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            byte[] r7 = r7.getBytes(r0)     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            r5.write(r7)     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            r5.close()     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            int r7 = r2.getResponseCode()     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            r4.close()
            java.io.InputStream r0 = r2.getInputStream()
            if (r0 == 0) goto L_0x004f
            java.io.InputStream r0 = r2.getInputStream()
            r0.close()
        L_0x004f:
            r2.disconnect()
            return r7
        L_0x0053:
            r7 = move-exception
            r1 = 1
            goto L_0x0076
        L_0x0056:
            r7 = move-exception
            r1 = 1
            goto L_0x006a
        L_0x0059:
            r7 = move-exception
            goto L_0x0076
        L_0x005b:
            r7 = move-exception
            goto L_0x006a
        L_0x005d:
            r7 = move-exception
            goto L_0x0077
        L_0x005f:
            r7 = move-exception
            r5 = r0
            goto L_0x006a
        L_0x0062:
            r7 = move-exception
            r4 = r0
            r5 = r4
            r0 = r2
            goto L_0x0075
        L_0x0067:
            r7 = move-exception
            r4 = r0
            r5 = r4
        L_0x006a:
            r0 = r2
            goto L_0x0073
        L_0x006c:
            r7 = move-exception
            r4 = r0
            r5 = r4
            goto L_0x0075
        L_0x0070:
            r7 = move-exception
            r4 = r0
            r5 = r4
        L_0x0073:
            throw r7     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r7 = move-exception
        L_0x0075:
            r2 = r0
        L_0x0076:
            r0 = r5
        L_0x0077:
            if (r0 == 0) goto L_0x007e
            if (r1 != 0) goto L_0x007e
            r0.close()
        L_0x007e:
            if (r4 == 0) goto L_0x0083
            r4.close()
        L_0x0083:
            if (r2 == 0) goto L_0x0095
            java.io.InputStream r0 = r2.getInputStream()
            if (r0 == 0) goto L_0x0092
            java.io.InputStream r0 = r2.getInputStream()
            r0.close()
        L_0x0092:
            r2.disconnect()
        L_0x0095:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.d0.a(java.lang.String):int");
    }
}
