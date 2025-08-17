package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.util.Util;

public final class DownloadNotificationHelper {

    /* renamed from: a  reason: collision with root package name */
    private final NotificationCompat.Builder f27877a;

    private static final class Api31 {
        private Api31() {
        }

        @SuppressLint({"WrongConstant"})
        public static void a(NotificationCompat.Builder builder) {
            builder.p(1);
        }
    }

    public DownloadNotificationHelper(Context context, String str) {
        this.f27877a = new NotificationCompat.Builder(context.getApplicationContext(), str);
    }

    private Notification a(Context context, int i2, PendingIntent pendingIntent, String str, int i3, int i4, int i5, boolean z2, boolean z3, boolean z4) {
        String str2;
        this.f27877a.y(i2);
        NotificationCompat.Builder builder = this.f27877a;
        NotificationCompat.BigTextStyle bigTextStyle = null;
        if (i3 == 0) {
            str2 = null;
        } else {
            str2 = context.getResources().getString(i3);
        }
        builder.m(str2);
        this.f27877a.k(pendingIntent);
        NotificationCompat.Builder builder2 = this.f27877a;
        if (str != null) {
            bigTextStyle = new NotificationCompat.BigTextStyle().h(str);
        }
        builder2.z(bigTextStyle);
        this.f27877a.v(i4, i5, z2);
        this.f27877a.s(z3);
        this.f27877a.w(z4);
        if (Util.f28808a >= 31) {
            Api31.a(this.f27877a);
        }
        return this.f27877a.c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Notification b(android.content.Context r22, int r23, android.app.PendingIntent r24, java.lang.String r25, java.util.List<com.google.android.exoplayer2.offline.Download> r26, int r27) {
        /*
            r21 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 1
        L_0x000a:
            int r10 = r26.size()
            if (r3 >= r10) goto L_0x004a
            r10 = r26
            java.lang.Object r11 = r10.get(r3)
            com.google.android.exoplayer2.offline.Download r11 = (com.google.android.exoplayer2.offline.Download) r11
            int r12 = r11.f25520b
            if (r12 == 0) goto L_0x0046
            r13 = 2
            if (r12 == r13) goto L_0x0028
            r13 = 5
            if (r12 == r13) goto L_0x0026
            r13 = 7
            if (r12 == r13) goto L_0x0028
            goto L_0x0047
        L_0x0026:
            r7 = 1
            goto L_0x0047
        L_0x0028:
            float r4 = r11.b()
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r12 == 0) goto L_0x0034
            float r0 = r0 + r4
            r9 = 0
        L_0x0034:
            long r11 = r11.a()
            r13 = 0
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x0040
            r4 = 1
            goto L_0x0041
        L_0x0040:
            r4 = 0
        L_0x0041:
            r6 = r6 | r4
            int r8 = r8 + 1
            r4 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 1
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x000a
        L_0x004a:
            if (r4 == 0) goto L_0x0051
            int r3 = com.google.android.exoplayer2.core.R$string.f23930a
        L_0x004e:
            r15 = r3
            r3 = 1
            goto L_0x006f
        L_0x0051:
            if (r5 == 0) goto L_0x0068
            if (r27 == 0) goto L_0x0068
            r3 = r27 & 2
            if (r3 == 0) goto L_0x005e
            int r3 = com.google.android.exoplayer2.core.R$string.exo_download_paused_for_wifi
        L_0x005b:
            r15 = r3
            r3 = 0
            goto L_0x006f
        L_0x005e:
            r3 = r27 & 1
            if (r3 == 0) goto L_0x0065
            int r3 = com.google.android.exoplayer2.core.R$string.exo_download_paused_for_network
            goto L_0x005b
        L_0x0065:
            int r3 = com.google.android.exoplayer2.core.R$string.exo_download_paused
            goto L_0x005b
        L_0x0068:
            if (r7 == 0) goto L_0x006d
            int r3 = com.google.android.exoplayer2.core.R$string.f23931e
            goto L_0x004e
        L_0x006d:
            r3 = 1
            r15 = 0
        L_0x006f:
            if (r3 == 0) goto L_0x008b
            r3 = 100
            if (r4 == 0) goto L_0x0084
            float r4 = (float) r8
            float r0 = r0 / r4
            int r0 = (int) r0
            if (r9 == 0) goto L_0x007d
            if (r6 == 0) goto L_0x007d
            r1 = 1
        L_0x007d:
            r17 = r0
            r18 = r1
            r16 = 100
            goto L_0x0091
        L_0x0084:
            r16 = 100
            r17 = 0
            r18 = 1
            goto L_0x0091
        L_0x008b:
            r16 = 0
            r17 = 0
            r18 = 0
        L_0x0091:
            r19 = 1
            r20 = 0
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            android.app.Notification r0 = r10.a(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DownloadNotificationHelper.b(android.content.Context, int, android.app.PendingIntent, java.lang.String, java.util.List, int):android.app.Notification");
    }
}
