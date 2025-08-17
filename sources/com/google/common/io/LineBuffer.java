package com.google.common.io;

import java.io.IOException;

abstract class LineBuffer {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f30689a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private boolean f30690b;

    LineBuffer() {
    }

    private boolean c(boolean z2) throws IOException {
        String str;
        if (this.f30690b) {
            if (z2) {
                str = "\r\n";
            } else {
                str = "\r";
            }
        } else if (z2) {
            str = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
        } else {
            str = "";
        }
        d(this.f30689a.toString(), str);
        this.f30689a = new StringBuilder();
        this.f30690b = false;
        return z2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r6.f30690b
            r1 = 0
            r2 = 10
            r3 = 1
            if (r0 == 0) goto L_0x001a
            if (r9 <= 0) goto L_0x001a
            char r0 = r7[r8]
            if (r0 != r2) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            boolean r0 = r6.c(r0)
            if (r0 == 0) goto L_0x001a
            int r0 = r8 + 1
            goto L_0x001b
        L_0x001a:
            r0 = r8
        L_0x001b:
            int r8 = r8 + r9
            r9 = r0
        L_0x001d:
            if (r0 >= r8) goto L_0x0052
            char r4 = r7[r0]
            if (r4 == r2) goto L_0x0044
            r5 = 13
            if (r4 == r5) goto L_0x0028
            goto L_0x0050
        L_0x0028:
            java.lang.StringBuilder r4 = r6.f30689a
            int r5 = r0 - r9
            r4.append(r7, r9, r5)
            r6.f30690b = r3
            int r9 = r0 + 1
            if (r9 >= r8) goto L_0x004e
            char r4 = r7[r9]
            if (r4 != r2) goto L_0x003b
            r4 = 1
            goto L_0x003c
        L_0x003b:
            r4 = 0
        L_0x003c:
            boolean r4 = r6.c(r4)
            if (r4 == 0) goto L_0x004e
            r0 = r9
            goto L_0x004e
        L_0x0044:
            java.lang.StringBuilder r4 = r6.f30689a
            int r5 = r0 - r9
            r4.append(r7, r9, r5)
            r6.c(r3)
        L_0x004e:
            int r9 = r0 + 1
        L_0x0050:
            int r0 = r0 + r3
            goto L_0x001d
        L_0x0052:
            java.lang.StringBuilder r0 = r6.f30689a
            int r8 = r8 - r9
            r0.append(r7, r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.LineBuffer.a(char[], int, int):void");
    }

    /* access modifiers changed from: protected */
    public void b() throws IOException {
        if (this.f30690b || this.f30689a.length() > 0) {
            c(false);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void d(String str, String str2) throws IOException;
}
