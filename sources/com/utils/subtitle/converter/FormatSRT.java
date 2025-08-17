package com.utils.subtitle.converter;

import java.util.ArrayList;

public class FormatSRT implements TimedTextFileFormat {
    private String[] c(Caption caption) {
        String[] split = caption.f37720d.split("<br />");
        for (int i2 = 0; i2 < split.length; i2++) {
            split[i2] = split[i2].replaceAll("\\<.*?\\>", "");
        }
        return split;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:39|40) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|13) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.f37742j += r6 + " expected at line " + r5;
        r1.f37742j += "\n skipping to next line\n\n";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006d, code lost:
        r6 = r6 + 1;
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0140, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r1.f37742j += "unexpected end of file, maybe last caption is not complete.\n\n";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0158, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x015b, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x009e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0142 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.utils.subtitle.converter.TimedTextObject a(java.lang.String r12, java.io.InputStream r13, java.lang.String r14) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "hh:mm:ss,ms"
            com.utils.subtitle.converter.TimedTextObject r1 = new com.utils.subtitle.converter.TimedTextObject
            r1.<init>()
            com.utils.subtitle.converter.Caption r2 = new com.utils.subtitle.converter.Caption
            r2.<init>()
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            r3.<init>(r13, r14)
            java.io.BufferedReader r14 = new java.io.BufferedReader
            r14.<init>(r3)
            r1.f37737e = r12
            java.lang.String r12 = r14.readLine()
            r3 = 1
            r4 = 0
            r5 = 0
            r6 = 1
        L_0x0020:
            if (r12 == 0) goto L_0x015c
            java.lang.String r12 = r12.trim()     // Catch:{ NullPointerException -> 0x0142 }
            int r5 = r5 + r3
            boolean r7 = r12.isEmpty()     // Catch:{ NullPointerException -> 0x0142 }
            if (r7 != 0) goto L_0x013a
            int r7 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x003d }
            if (r7 != r6) goto L_0x0037
            int r6 = r6 + 1
            r7 = 1
            goto L_0x0070
        L_0x0037:
            java.lang.Exception r7 = new java.lang.Exception     // Catch:{ Exception -> 0x003d }
            r7.<init>()     // Catch:{ Exception -> 0x003d }
            throw r7     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0142 }
            r7.<init>()     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r8 = r1.f37742j     // Catch:{ NullPointerException -> 0x0142 }
            r7.append(r8)     // Catch:{ NullPointerException -> 0x0142 }
            r7.append(r6)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r8 = " expected at line "
            r7.append(r8)     // Catch:{ NullPointerException -> 0x0142 }
            r7.append(r5)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r7 = r7.toString()     // Catch:{ NullPointerException -> 0x0142 }
            r1.f37742j = r7     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0142 }
            r7.<init>()     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r8 = r1.f37742j     // Catch:{ NullPointerException -> 0x0142 }
            r7.append(r8)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r8 = "\n skipping to next line\n\n"
            r7.append(r8)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r7 = r7.toString()     // Catch:{ NullPointerException -> 0x0142 }
            r1.f37742j = r7     // Catch:{ NullPointerException -> 0x0142 }
            int r6 = r6 + 1
            r7 = 0
        L_0x0070:
            if (r7 == 0) goto L_0x00b7
            int r5 = r5 + 1
            java.lang.String r8 = r14.readLine()     // Catch:{ Exception -> 0x009e }
            java.lang.String r12 = r8.trim()     // Catch:{ Exception -> 0x009e }
            r8 = 12
            java.lang.String r9 = r12.substring(r4, r8)     // Catch:{ Exception -> 0x009e }
            int r10 = r12.length()     // Catch:{ Exception -> 0x009e }
            int r10 = r10 - r8
            int r8 = r12.length()     // Catch:{ Exception -> 0x009e }
            java.lang.String r8 = r12.substring(r10, r8)     // Catch:{ Exception -> 0x009e }
            com.utils.subtitle.converter.Time r10 = new com.utils.subtitle.converter.Time     // Catch:{ Exception -> 0x009e }
            r10.<init>(r0, r9)     // Catch:{ Exception -> 0x009e }
            r2.f37718b = r10     // Catch:{ Exception -> 0x009e }
            com.utils.subtitle.converter.Time r9 = new com.utils.subtitle.converter.Time     // Catch:{ Exception -> 0x009e }
            r9.<init>(r0, r8)     // Catch:{ Exception -> 0x009e }
            r2.f37719c = r9     // Catch:{ Exception -> 0x009e }
            goto L_0x00b7
        L_0x009e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0142 }
            r7.<init>()     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r8 = r1.f37742j     // Catch:{ NullPointerException -> 0x0142 }
            r7.append(r8)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r8 = "incorrect time format at line "
            r7.append(r8)     // Catch:{ NullPointerException -> 0x0142 }
            r7.append(r5)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r7 = r7.toString()     // Catch:{ NullPointerException -> 0x0142 }
            r1.f37742j = r7     // Catch:{ NullPointerException -> 0x0142 }
            r7 = 0
        L_0x00b7:
            if (r7 == 0) goto L_0x0123
            int r5 = r5 + 1
            java.lang.String r12 = r14.readLine()     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r12 = r12.trim()     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r7 = ""
        L_0x00c5:
            boolean r8 = r12.isEmpty()     // Catch:{ NullPointerException -> 0x0142 }
            if (r8 != 0) goto L_0x00ea
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0142 }
            r8.<init>()     // Catch:{ NullPointerException -> 0x0142 }
            r8.append(r7)     // Catch:{ NullPointerException -> 0x0142 }
            r8.append(r12)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r12 = "<br />"
            r8.append(r12)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r7 = r8.toString()     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r12 = r14.readLine()     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r12 = r12.trim()     // Catch:{ NullPointerException -> 0x0142 }
            int r5 = r5 + 1
            goto L_0x00c5
        L_0x00ea:
            r2.f37720d = r7     // Catch:{ NullPointerException -> 0x0142 }
            com.utils.subtitle.converter.Time r7 = r2.f37718b     // Catch:{ NullPointerException -> 0x0142 }
            int r7 = r7.f37732a     // Catch:{ NullPointerException -> 0x0142 }
        L_0x00f0:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r8 = r1.f37741i     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ NullPointerException -> 0x0142 }
            boolean r8 = r8.containsKey(r9)     // Catch:{ NullPointerException -> 0x0142 }
            if (r8 == 0) goto L_0x00ff
            int r7 = r7 + 1
            goto L_0x00f0
        L_0x00ff:
            com.utils.subtitle.converter.Time r8 = r2.f37718b     // Catch:{ NullPointerException -> 0x0142 }
            int r8 = r8.f37732a     // Catch:{ NullPointerException -> 0x0142 }
            if (r7 == r8) goto L_0x011a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0142 }
            r8.<init>()     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r9 = r1.f37742j     // Catch:{ NullPointerException -> 0x0142 }
            r8.append(r9)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r9 = "caption with same start time found...\n\n"
            r8.append(r9)     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r8 = r8.toString()     // Catch:{ NullPointerException -> 0x0142 }
            r1.f37742j = r8     // Catch:{ NullPointerException -> 0x0142 }
        L_0x011a:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r8 = r1.f37741i     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ NullPointerException -> 0x0142 }
            r8.put(r7, r2)     // Catch:{ NullPointerException -> 0x0142 }
        L_0x0123:
            boolean r12 = r12.isEmpty()     // Catch:{ NullPointerException -> 0x0142 }
            if (r12 != 0) goto L_0x0134
            java.lang.String r12 = r14.readLine()     // Catch:{ NullPointerException -> 0x0142 }
            java.lang.String r12 = r12.trim()     // Catch:{ NullPointerException -> 0x0142 }
            int r5 = r5 + 1
            goto L_0x0123
        L_0x0134:
            com.utils.subtitle.converter.Caption r12 = new com.utils.subtitle.converter.Caption     // Catch:{ NullPointerException -> 0x0142 }
            r12.<init>()     // Catch:{ NullPointerException -> 0x0142 }
            r2 = r12
        L_0x013a:
            java.lang.String r12 = r14.readLine()     // Catch:{ NullPointerException -> 0x0142 }
            goto L_0x0020
        L_0x0140:
            r12 = move-exception
            goto L_0x0158
        L_0x0142:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0140 }
            r12.<init>()     // Catch:{ all -> 0x0140 }
            java.lang.String r14 = r1.f37742j     // Catch:{ all -> 0x0140 }
            r12.append(r14)     // Catch:{ all -> 0x0140 }
            java.lang.String r14 = "unexpected end of file, maybe last caption is not complete.\n\n"
            r12.append(r14)     // Catch:{ all -> 0x0140 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0140 }
            r1.f37742j = r12     // Catch:{ all -> 0x0140 }
            goto L_0x015c
        L_0x0158:
            r13.close()
            throw r12
        L_0x015c:
            r13.close()
            r1.f37745m = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.converter.FormatSRT.a(java.lang.String, java.io.InputStream, java.lang.String):com.utils.subtitle.converter.TimedTextObject");
    }

    /* renamed from: d */
    public String[] b(TimedTextObject timedTextObject) {
        if (!timedTextObject.f37745m) {
            return null;
        }
        ArrayList arrayList = new ArrayList(timedTextObject.f37741i.size() * 5);
        int i2 = 1;
        int i3 = 0;
        for (Caption next : timedTextObject.f37741i.values()) {
            int i4 = i3 + 1;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            int i5 = i2 + 1;
            sb.append(i2);
            arrayList.add(i3, sb.toString());
            int i6 = timedTextObject.f37744l;
            if (i6 != 0) {
                next.f37718b.f37732a += i6;
                next.f37719c.f37732a += i6;
            }
            int i7 = i4 + 1;
            arrayList.add(i4, next.f37718b.a("hh:mm:ss,ms") + " --> " + next.f37719c.a("hh:mm:ss,ms"));
            int i8 = timedTextObject.f37744l;
            if (i8 != 0) {
                next.f37718b.f37732a -= i8;
                next.f37719c.f37732a -= i8;
            }
            String[] c2 = c(next);
            for (int i9 = 0; i9 < c2.length; i9++) {
                arrayList.add(i7, "" + c2[i9]);
                i7++;
            }
            i3 = i7 + 1;
            arrayList.add(i7, "");
            i2 = i5;
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = (String) arrayList.get(i10);
        }
        return strArr;
    }
}
