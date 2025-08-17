package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.source.rtsp.RtspMessageUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;
import q0.b;

final class RtspClient implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final SessionInfoListener f26794b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final PlaybackEventListener f26795c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f26796d;

    /* renamed from: e  reason: collision with root package name */
    private final SocketFactory f26797e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f26798f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<RtspMediaPeriod.RtpLoadInfo> f26799g = new ArrayDeque<>();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<RtspRequest> f26800h = new SparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final MessageSender f26801i = new MessageSender();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Uri f26802j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public RtspMessageChannel f26803k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public RtspMessageUtil.RtspAuthUserInfo f26804l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f26805m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public KeepAliveMonitor f26806n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public RtspAuthenticationInfo f26807o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f26808p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f26809q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f26810r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f26811s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public long f26812t;

    private final class KeepAliveMonitor implements Runnable, Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f26813b = Util.w();

        /* renamed from: c  reason: collision with root package name */
        private final long f26814c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f26815d;

        public KeepAliveMonitor(long j2) {
            this.f26814c = j2;
        }

        public void a() {
            if (!this.f26815d) {
                this.f26815d = true;
                this.f26813b.postDelayed(this, this.f26814c);
            }
        }

        public void close() {
            this.f26815d = false;
            this.f26813b.removeCallbacks(this);
        }

        public void run() {
            RtspClient.this.f26801i.e(RtspClient.this.f26802j, RtspClient.this.f26805m);
            this.f26813b.postDelayed(this, this.f26814c);
        }
    }

    private final class MessageListener implements RtspMessageChannel.MessageListener {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f26817a = Util.w();

        public MessageListener() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void h(List<String> list) {
            RtspClient.this.G0(list);
            if (RtspMessageUtil.e(list)) {
                g(list);
            } else {
                f(list);
            }
        }

        private void f(List<String> list) {
            RtspClient.this.f26801i.d(Integer.parseInt((String) Assertions.e(RtspMessageUtil.k(list).f26918c.d("CSeq"))));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            r1 = com.google.common.collect.ImmutableList.r();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0212, code lost:
            r9 = e;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x01d7 */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0212 A[ExcHandler: IllegalArgumentException (e java.lang.IllegalArgumentException), Splitter:B:4:0x0030] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void g(java.util.List<java.lang.String> r9) {
            /*
                r8 = this;
                com.google.android.exoplayer2.source.rtsp.RtspResponse r9 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.l(r9)
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r0 = r9.f26921b
                java.lang.String r1 = "CSeq"
                java.lang.String r0 = r0.d(r1)
                java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.e(r0)
                java.lang.String r0 = (java.lang.String) r0
                int r0 = java.lang.Integer.parseInt(r0)
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this
                android.util.SparseArray r1 = r1.f26800h
                java.lang.Object r1 = r1.get(r0)
                com.google.android.exoplayer2.source.rtsp.RtspRequest r1 = (com.google.android.exoplayer2.source.rtsp.RtspRequest) r1
                if (r1 != 0) goto L_0x0025
                return
            L_0x0025:
                com.google.android.exoplayer2.source.rtsp.RtspClient r2 = com.google.android.exoplayer2.source.rtsp.RtspClient.this
                android.util.SparseArray r2 = r2.f26800h
                r2.remove(r0)
                int r0 = r1.f26917b
                int r2 = r9.f26920a     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3 = 200(0xc8, float:2.8E-43)
                java.lang.String r4 = "Transport"
                r5 = 0
                if (r2 == r3) goto L_0x017c
                r3 = 401(0x191, float:5.62E-43)
                r6 = 0
                java.lang.String r7 = " "
                if (r2 == r3) goto L_0x0100
                r3 = 461(0x1cd, float:6.46E-43)
                if (r2 == r3) goto L_0x00bf
                r1 = 301(0x12d, float:4.22E-43)
                if (r2 == r1) goto L_0x006f
                r1 = 302(0x12e, float:4.23E-43)
                if (r2 == r1) goto L_0x006f
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException r2 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3.<init>()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r0 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.t(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3.append(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3.append(r7)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                int r9 = r9.f26920a     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3.append(r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r9 = r3.toString()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r2.<init>((java.lang.String) r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r1.D0(r2)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                return
            L_0x006f:
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                int r0 = r0.f26808p     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r1 = -1
                if (r0 == r1) goto L_0x007d
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                int unused = r0.f26808p = r6     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
            L_0x007d:
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r9 = r9.f26921b     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r0 = "Location"
                java.lang.String r9 = r9.d(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                if (r9 != 0) goto L_0x0093
                com.google.android.exoplayer2.source.rtsp.RtspClient r9 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient$SessionInfoListener r9 = r9.f26794b     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r0 = "Redirection without new location."
                r9.b(r0, r5)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                goto L_0x00be
            L_0x0093:
                android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                android.net.Uri r1 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.p(r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                android.net.Uri unused = r0.f26802j = r1     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspMessageUtil$RtspAuthUserInfo r9 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.n(r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.RtspAuthUserInfo unused = r0.f26804l = r9     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r9 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient$MessageSender r9 = r9.f26801i     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                android.net.Uri r0 = r0.f26802j     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r1 = r1.f26805m     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r9.c(r0, r1)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
            L_0x00be:
                return
            L_0x00bf:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r2.<init>()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r3 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.t(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r2.append(r3)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r2.append(r7)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                int r9 = r9.f26920a     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r2.append(r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r9 = r2.toString()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r1 = r1.f26918c     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r1 = r1.d(r4)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.e(r1)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r2 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3 = 10
                if (r0 != r3) goto L_0x00f7
                java.lang.String r0 = "TCP"
                boolean r0 = r1.contains(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                if (r0 != 0) goto L_0x00f7
                com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspUdpUnsupportedTransportException r0 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspUdpUnsupportedTransportException     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r0.<init>(r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                goto L_0x00fc
            L_0x00f7:
                com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException r0 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r0.<init>((java.lang.String) r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
            L_0x00fc:
                r2.D0(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                return
            L_0x0100:
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspMessageUtil$RtspAuthUserInfo r1 = r1.f26804l     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                if (r1 == 0) goto L_0x0159
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                boolean r1 = r1.f26810r     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                if (r1 != 0) goto L_0x0159
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r9 = r9.f26921b     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r0 = "WWW-Authenticate"
                com.google.common.collect.ImmutableList r9 = r9.e(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                boolean r0 = r9.isEmpty()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                if (r0 != 0) goto L_0x0152
            L_0x011e:
                int r0 = r9.size()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                if (r6 >= r0) goto L_0x0142
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.Object r1 = r9.get(r6)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspAuthenticationInfo r1 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.o(r1)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspAuthenticationInfo unused = r0.f26807o = r1     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspAuthenticationInfo r0 = r0.f26807o     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                int r0 = r0.f26790a     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r1 = 2
                if (r0 != r1) goto L_0x013f
                goto L_0x0142
            L_0x013f:
                int r6 = r6 + 1
                goto L_0x011e
            L_0x0142:
                com.google.android.exoplayer2.source.rtsp.RtspClient r9 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient$MessageSender r9 = r9.f26801i     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r9.b()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspClient r9 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r0 = 1
                boolean unused = r9.f26810r = r0     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                return
            L_0x0152:
                java.lang.String r9 = "Missing WWW-Authenticate header in a 401 response."
                com.google.android.exoplayer2.ParserException r9 = com.google.android.exoplayer2.ParserException.c(r9, r5)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                throw r9     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
            L_0x0159:
                com.google.android.exoplayer2.source.rtsp.RtspClient r1 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException r2 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3.<init>()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r0 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.t(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3.append(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3.append(r7)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                int r9 = r9.f26920a     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r3.append(r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r9 = r3.toString()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r2.<init>((java.lang.String) r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r1.D0(r2)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                return
            L_0x017c:
                switch(r0) {
                    case 1: goto L_0x021f;
                    case 2: goto L_0x01ff;
                    case 3: goto L_0x021f;
                    case 4: goto L_0x01ea;
                    case 5: goto L_0x01e6;
                    case 6: goto L_0x01ac;
                    case 7: goto L_0x021f;
                    case 8: goto L_0x021f;
                    case 9: goto L_0x021f;
                    case 10: goto L_0x0183;
                    case 11: goto L_0x021f;
                    case 12: goto L_0x021f;
                    default: goto L_0x017f;
                }     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
            L_0x017f:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                goto L_0x020e
            L_0x0183:
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r0 = r9.f26921b     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r1 = "Session"
                java.lang.String r0 = r0.d(r1)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r1 = r9.f26921b     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r1 = r1.d(r4)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                if (r0 == 0) goto L_0x01a5
                if (r1 == 0) goto L_0x01a5
                com.google.android.exoplayer2.source.rtsp.RtspMessageUtil$RtspSessionHeader r0 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.m(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspSetupResponse r2 = new com.google.android.exoplayer2.source.rtsp.RtspSetupResponse     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                int r9 = r9.f26920a     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r2.<init>(r9, r0, r1)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r8.m(r2)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                goto L_0x021f
            L_0x01a5:
                java.lang.String r9 = "Missing mandatory session or transport header"
                com.google.android.exoplayer2.ParserException r9 = com.google.android.exoplayer2.ParserException.c(r9, r5)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                throw r9     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
            L_0x01ac:
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r0 = r9.f26921b     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r1 = "Range"
                java.lang.String r0 = r0.d(r1)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                if (r0 != 0) goto L_0x01b9
                com.google.android.exoplayer2.source.rtsp.RtspSessionTiming r0 = com.google.android.exoplayer2.source.rtsp.RtspSessionTiming.f26923c     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                goto L_0x01bd
            L_0x01b9:
                com.google.android.exoplayer2.source.rtsp.RtspSessionTiming r0 = com.google.android.exoplayer2.source.rtsp.RtspSessionTiming.d(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
            L_0x01bd:
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r1 = r9.f26921b     // Catch:{ ParserException -> 0x01d7, IllegalArgumentException -> 0x0212 }
                java.lang.String r2 = "RTP-Info"
                java.lang.String r1 = r1.d(r2)     // Catch:{ ParserException -> 0x01d7, IllegalArgumentException -> 0x0212 }
                if (r1 != 0) goto L_0x01cc
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.r()     // Catch:{ ParserException -> 0x01d7, IllegalArgumentException -> 0x0212 }
                goto L_0x01db
            L_0x01cc:
                com.google.android.exoplayer2.source.rtsp.RtspClient r2 = com.google.android.exoplayer2.source.rtsp.RtspClient.this     // Catch:{ ParserException -> 0x01d7, IllegalArgumentException -> 0x0212 }
                android.net.Uri r2 = r2.f26802j     // Catch:{ ParserException -> 0x01d7, IllegalArgumentException -> 0x0212 }
                com.google.common.collect.ImmutableList r1 = com.google.android.exoplayer2.source.rtsp.RtspTrackTiming.a(r1, r2)     // Catch:{ ParserException -> 0x01d7, IllegalArgumentException -> 0x0212 }
                goto L_0x01db
            L_0x01d7:
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.r()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
            L_0x01db:
                com.google.android.exoplayer2.source.rtsp.RtspPlayResponse r2 = new com.google.android.exoplayer2.source.rtsp.RtspPlayResponse     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                int r9 = r9.f26920a     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r2.<init>(r9, r0, r1)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r8.l(r2)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                goto L_0x021f
            L_0x01e6:
                r8.k()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                goto L_0x021f
            L_0x01ea:
                com.google.android.exoplayer2.source.rtsp.RtspOptionsResponse r0 = new com.google.android.exoplayer2.source.rtsp.RtspOptionsResponse     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.RtspHeaders r9 = r9.f26921b     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r1 = "Public"
                java.lang.String r9 = r9.d(r1)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.common.collect.ImmutableList r9 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.j(r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r0.<init>(r2, r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r8.j(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                goto L_0x021f
            L_0x01ff:
                com.google.android.exoplayer2.source.rtsp.RtspDescribeResponse r0 = new com.google.android.exoplayer2.source.rtsp.RtspDescribeResponse     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                java.lang.String r9 = r9.f26922c     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                com.google.android.exoplayer2.source.rtsp.SessionDescription r9 = com.google.android.exoplayer2.source.rtsp.SessionDescriptionParser.b(r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r0.<init>(r2, r9)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                r8.i(r0)     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                goto L_0x021f
            L_0x020e:
                r9.<init>()     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
                throw r9     // Catch:{ ParserException -> 0x0214, IllegalArgumentException -> 0x0212 }
            L_0x0212:
                r9 = move-exception
                goto L_0x0215
            L_0x0214:
                r9 = move-exception
            L_0x0215:
                com.google.android.exoplayer2.source.rtsp.RtspClient r0 = com.google.android.exoplayer2.source.rtsp.RtspClient.this
                com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException r1 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$RtspPlaybackException
                r1.<init>((java.lang.Throwable) r9)
                r0.D0(r1)
            L_0x021f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspClient.MessageListener.g(java.util.List):void");
        }

        private void i(RtspDescribeResponse rtspDescribeResponse) {
            RtspSessionTiming rtspSessionTiming = RtspSessionTiming.f26923c;
            String str = rtspDescribeResponse.f26823b.f26933a.get("range");
            if (str != null) {
                try {
                    rtspSessionTiming = RtspSessionTiming.d(str);
                } catch (ParserException e2) {
                    RtspClient.this.f26794b.b("SDP format error.", e2);
                    return;
                }
            }
            ImmutableList H = RtspClient.B0(rtspDescribeResponse.f26823b, RtspClient.this.f26802j);
            if (H.isEmpty()) {
                RtspClient.this.f26794b.b("No playable track.", (Throwable) null);
                return;
            }
            RtspClient.this.f26794b.g(rtspSessionTiming, H);
            boolean unused = RtspClient.this.f26809q = true;
        }

        private void j(RtspOptionsResponse rtspOptionsResponse) {
            if (RtspClient.this.f26806n == null) {
                if (RtspClient.K0(rtspOptionsResponse.f26912b)) {
                    RtspClient.this.f26801i.c(RtspClient.this.f26802j, RtspClient.this.f26805m);
                } else {
                    RtspClient.this.f26794b.b("DESCRIBE not supported.", (Throwable) null);
                }
            }
        }

        private void k() {
            boolean z2;
            if (RtspClient.this.f26808p == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            int unused = RtspClient.this.f26808p = 1;
            boolean unused2 = RtspClient.this.f26811s = false;
            if (RtspClient.this.f26812t != -9223372036854775807L) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.N0(Util.i1(rtspClient.f26812t));
            }
        }

        private void l(RtspPlayResponse rtspPlayResponse) {
            boolean z2 = true;
            if (RtspClient.this.f26808p != 1) {
                z2 = false;
            }
            Assertions.g(z2);
            int unused = RtspClient.this.f26808p = 2;
            if (RtspClient.this.f26806n == null) {
                RtspClient rtspClient = RtspClient.this;
                KeepAliveMonitor unused2 = rtspClient.f26806n = new KeepAliveMonitor(NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
                RtspClient.this.f26806n.a();
            }
            long unused3 = RtspClient.this.f26812t = -9223372036854775807L;
            RtspClient.this.f26795c.f(Util.F0(rtspPlayResponse.f26914b.f26925a), rtspPlayResponse.f26915c);
        }

        private void m(RtspSetupResponse rtspSetupResponse) {
            boolean z2;
            if (RtspClient.this.f26808p != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            int unused = RtspClient.this.f26808p = 1;
            String unused2 = RtspClient.this.f26805m = rtspSetupResponse.f26928b.f26909a;
            RtspClient.this.C0();
        }

        public /* synthetic */ void a(Exception exc) {
            b.a(this, exc);
        }

        public /* synthetic */ void b(List list, Exception exc) {
            b.b(this, list, exc);
        }

        public void c(List<String> list) {
            this.f26817a.post(new c(this, list));
        }
    }

    private final class MessageSender {

        /* renamed from: a  reason: collision with root package name */
        private int f26819a;

        /* renamed from: b  reason: collision with root package name */
        private RtspRequest f26820b;

        private MessageSender() {
        }

        private RtspRequest a(int i2, String str, Map<String, String> map, Uri uri) {
            String t02 = RtspClient.this.f26796d;
            int i3 = this.f26819a;
            this.f26819a = i3 + 1;
            RtspHeaders.Builder builder = new RtspHeaders.Builder(t02, str, i3);
            if (RtspClient.this.f26807o != null) {
                Assertions.i(RtspClient.this.f26804l);
                try {
                    builder.b("Authorization", RtspClient.this.f26807o.a(RtspClient.this.f26804l, uri, i2));
                } catch (ParserException e2) {
                    RtspClient.this.D0(new RtspMediaSource.RtspPlaybackException((Throwable) e2));
                }
            }
            builder.d(map);
            return new RtspRequest(uri, i2, builder.e(), "");
        }

        private void h(RtspRequest rtspRequest) {
            boolean z2;
            int parseInt = Integer.parseInt((String) Assertions.e(rtspRequest.f26918c.d("CSeq")));
            if (RtspClient.this.f26800h.get(parseInt) == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            RtspClient.this.f26800h.append(parseInt, rtspRequest);
            ImmutableList<String> q2 = RtspMessageUtil.q(rtspRequest);
            RtspClient.this.G0(q2);
            RtspClient.this.f26803k.s(q2);
            this.f26820b = rtspRequest;
        }

        private void i(RtspResponse rtspResponse) {
            ImmutableList<String> r2 = RtspMessageUtil.r(rtspResponse);
            RtspClient.this.G0(r2);
            RtspClient.this.f26803k.s(r2);
        }

        public void b() {
            Assertions.i(this.f26820b);
            ImmutableListMultimap<String, String> b2 = this.f26820b.f26918c.b();
            HashMap hashMap = new HashMap();
            for (String next : b2.keySet()) {
                if (!next.equals("CSeq") && !next.equals("User-Agent") && !next.equals("Session") && !next.equals("Authorization")) {
                    hashMap.put(next, (String) Iterables.d(b2.get(next)));
                }
            }
            h(a(this.f26820b.f26917b, RtspClient.this.f26805m, hashMap, this.f26820b.f26916a));
        }

        public void c(Uri uri, String str) {
            h(a(2, str, ImmutableMap.k(), uri));
        }

        public void d(int i2) {
            i(new RtspResponse(405, new RtspHeaders.Builder(RtspClient.this.f26796d, RtspClient.this.f26805m, i2).e()));
            this.f26819a = Math.max(this.f26819a, i2 + 1);
        }

        public void e(Uri uri, String str) {
            h(a(4, str, ImmutableMap.k(), uri));
        }

        public void f(Uri uri, String str) {
            boolean z2;
            if (RtspClient.this.f26808p == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            h(a(5, str, ImmutableMap.k(), uri));
            boolean unused = RtspClient.this.f26811s = true;
        }

        public void g(Uri uri, long j2, String str) {
            boolean z2 = true;
            if (!(RtspClient.this.f26808p == 1 || RtspClient.this.f26808p == 2)) {
                z2 = false;
            }
            Assertions.g(z2);
            h(a(6, str, ImmutableMap.l("Range", RtspSessionTiming.b(j2)), uri));
        }

        public void j(Uri uri, String str, String str2) {
            int unused = RtspClient.this.f26808p = 0;
            h(a(10, str2, ImmutableMap.l("Transport", str), uri));
        }

        public void k(Uri uri, String str) {
            if (RtspClient.this.f26808p != -1 && RtspClient.this.f26808p != 0) {
                int unused = RtspClient.this.f26808p = 0;
                h(a(12, str, ImmutableMap.k(), uri));
            }
        }
    }

    public interface PlaybackEventListener {
        void c(RtspMediaSource.RtspPlaybackException rtspPlaybackException);

        void e();

        void f(long j2, ImmutableList<RtspTrackTiming> immutableList);
    }

    public interface SessionInfoListener {
        void b(String str, Throwable th);

        void g(RtspSessionTiming rtspSessionTiming, ImmutableList<RtspMediaTrack> immutableList);
    }

    public RtspClient(SessionInfoListener sessionInfoListener, PlaybackEventListener playbackEventListener, String str, Uri uri, SocketFactory socketFactory, boolean z2) {
        this.f26794b = sessionInfoListener;
        this.f26795c = playbackEventListener;
        this.f26796d = str;
        this.f26797e = socketFactory;
        this.f26798f = z2;
        this.f26802j = RtspMessageUtil.p(uri);
        this.f26803k = new RtspMessageChannel(new MessageListener());
        this.f26804l = RtspMessageUtil.n(uri);
        this.f26812t = -9223372036854775807L;
        this.f26808p = -1;
    }

    /* access modifiers changed from: private */
    public static ImmutableList<RtspMediaTrack> B0(SessionDescription sessionDescription, Uri uri) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i2 = 0; i2 < sessionDescription.f26934b.size(); i2++) {
            MediaDescription mediaDescription = sessionDescription.f26934b.get(i2);
            if (RtpPayloadFormat.c(mediaDescription)) {
                builder.d(new RtspMediaTrack(mediaDescription, uri));
            }
        }
        return builder.k();
    }

    /* access modifiers changed from: private */
    public void C0() {
        RtspMediaPeriod.RtpLoadInfo pollFirst = this.f26799g.pollFirst();
        if (pollFirst == null) {
            this.f26795c.e();
        } else {
            this.f26801i.j(pollFirst.c(), pollFirst.d(), this.f26805m);
        }
    }

    /* access modifiers changed from: private */
    public void D0(Throwable th) {
        RtspMediaSource.RtspPlaybackException rtspPlaybackException;
        if (th instanceof RtspMediaSource.RtspPlaybackException) {
            rtspPlaybackException = (RtspMediaSource.RtspPlaybackException) th;
        } else {
            rtspPlaybackException = new RtspMediaSource.RtspPlaybackException(th);
        }
        if (this.f26809q) {
            this.f26795c.c(rtspPlaybackException);
        } else {
            this.f26794b.b(Strings.d(th.getMessage()), th);
        }
    }

    private Socket E0(Uri uri) throws IOException {
        boolean z2;
        int i2;
        if (uri.getHost() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (uri.getPort() > 0) {
            i2 = uri.getPort();
        } else {
            i2 = 554;
        }
        return this.f26797e.createSocket((String) Assertions.e(uri.getHost()), i2);
    }

    /* access modifiers changed from: private */
    public void G0(List<String> list) {
        if (this.f26798f) {
            Log.b("RtspClient", Joiner.on(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).join((Iterable<? extends Object>) list));
        }
    }

    /* access modifiers changed from: private */
    public static boolean K0(List<Integer> list) {
        return list.isEmpty() || list.contains(2);
    }

    public int F0() {
        return this.f26808p;
    }

    public void H0(int i2, RtspMessageChannel.InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.f26803k.q(i2, interleavedBinaryDataListener);
    }

    public void I0() {
        try {
            close();
            RtspMessageChannel rtspMessageChannel = new RtspMessageChannel(new MessageListener());
            this.f26803k = rtspMessageChannel;
            rtspMessageChannel.k(E0(this.f26802j));
            this.f26805m = null;
            this.f26810r = false;
            this.f26807o = null;
        } catch (IOException e2) {
            this.f26795c.c(new RtspMediaSource.RtspPlaybackException((Throwable) e2));
        }
    }

    public void J0(long j2) {
        if (this.f26808p == 2 && !this.f26811s) {
            this.f26801i.f(this.f26802j, (String) Assertions.e(this.f26805m));
        }
        this.f26812t = j2;
    }

    public void L0(List<RtspMediaPeriod.RtpLoadInfo> list) {
        this.f26799g.addAll(list);
        C0();
    }

    public void M0() throws IOException {
        try {
            this.f26803k.k(E0(this.f26802j));
            this.f26801i.e(this.f26802j, this.f26805m);
        } catch (IOException e2) {
            Util.n(this.f26803k);
            throw e2;
        }
    }

    public void N0(long j2) {
        this.f26801i.g(this.f26802j, j2, (String) Assertions.e(this.f26805m));
    }

    public void close() throws IOException {
        KeepAliveMonitor keepAliveMonitor = this.f26806n;
        if (keepAliveMonitor != null) {
            keepAliveMonitor.close();
            this.f26806n = null;
            this.f26801i.k(this.f26802j, (String) Assertions.e(this.f26805m));
        }
        this.f26803k.close();
    }
}
