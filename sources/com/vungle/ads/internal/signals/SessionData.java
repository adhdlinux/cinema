package com.vungle.ads.internal.signals;

import com.vungle.ads.internal.model.UnclosedAd;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Serializable
public final class SessionData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int sessionCount;
    private long sessionCreationTime;
    private int sessionDepthCounter;
    private long sessionDuration;
    private final String sessionId;
    private List<SignaledAd> signaledAd;
    private List<UnclosedAd> unclosedAd;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SessionData> serializer() {
            return SessionData$$serializer.INSTANCE;
        }
    }

    public SessionData(int i2) {
        this.sessionCount = i2;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.e(uuid, "randomUUID().toString()");
        this.sessionId = uuid;
        this.sessionCreationTime = System.currentTimeMillis() / 1000;
        this.signaledAd = new ArrayList();
        this.unclosedAd = new ArrayList();
    }

    public static /* synthetic */ SessionData copy$default(SessionData sessionData, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = sessionData.sessionCount;
        }
        return sessionData.copy(i2);
    }

    public static /* synthetic */ void getSessionCount$annotations() {
    }

    public static /* synthetic */ void getSessionCreationTime$annotations() {
    }

    public static /* synthetic */ void getSessionDepthCounter$annotations() {
    }

    public static /* synthetic */ void getSessionDuration$annotations() {
    }

    public static /* synthetic */ void getSessionId$annotations() {
    }

    public static /* synthetic */ void getSignaledAd$annotations() {
    }

    public static /* synthetic */ void getUnclosedAd$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void write$Self(com.vungle.ads.internal.signals.SessionData r9, kotlinx.serialization.encoding.CompositeEncoder r10, kotlinx.serialization.descriptors.SerialDescriptor r11) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            java.lang.String r0 = "serialDesc"
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            int r0 = r9.sessionCount
            r1 = 0
            r10.w(r11, r1, r0)
            r0 = 1
            boolean r2 = r10.z(r11, r0)
            if (r2 == 0) goto L_0x001e
        L_0x001c:
            r2 = 1
            goto L_0x0035
        L_0x001e:
            java.lang.String r2 = r9.sessionId
            java.util.UUID r3 = java.util.UUID.randomUUID()
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.e(r3, r4)
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r3)
            if (r2 != 0) goto L_0x0034
            goto L_0x001c
        L_0x0034:
            r2 = 0
        L_0x0035:
            if (r2 == 0) goto L_0x003c
            java.lang.String r2 = r9.sessionId
            r10.y(r11, r0, r2)
        L_0x003c:
            r2 = 2
            boolean r3 = r10.z(r11, r2)
            if (r3 == 0) goto L_0x0045
        L_0x0043:
            r3 = 1
            goto L_0x0054
        L_0x0045:
            long r3 = r9.sessionCreationTime
            long r5 = java.lang.System.currentTimeMillis()
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0053
            goto L_0x0043
        L_0x0053:
            r3 = 0
        L_0x0054:
            if (r3 == 0) goto L_0x005b
            long r3 = r9.sessionCreationTime
            r10.F(r11, r2, r3)
        L_0x005b:
            r2 = 3
            boolean r3 = r10.z(r11, r2)
            if (r3 == 0) goto L_0x0064
        L_0x0062:
            r3 = 1
            goto L_0x0073
        L_0x0064:
            java.util.List<com.vungle.ads.internal.signals.SignaledAd> r3 = r9.signaledAd
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r3, r4)
            if (r3 != 0) goto L_0x0072
            goto L_0x0062
        L_0x0072:
            r3 = 0
        L_0x0073:
            if (r3 == 0) goto L_0x0081
            kotlinx.serialization.internal.ArrayListSerializer r3 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.signals.SignaledAd$$serializer r4 = com.vungle.ads.internal.signals.SignaledAd$$serializer.INSTANCE
            r3.<init>(r4)
            java.util.List<com.vungle.ads.internal.signals.SignaledAd> r4 = r9.signaledAd
            r10.C(r11, r2, r3, r4)
        L_0x0081:
            r2 = 4
            boolean r3 = r10.z(r11, r2)
            if (r3 == 0) goto L_0x008a
        L_0x0088:
            r3 = 1
            goto L_0x0094
        L_0x008a:
            long r3 = r9.sessionDuration
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0093
            goto L_0x0088
        L_0x0093:
            r3 = 0
        L_0x0094:
            if (r3 == 0) goto L_0x009b
            long r3 = r9.sessionDuration
            r10.F(r11, r2, r3)
        L_0x009b:
            r2 = 5
            boolean r3 = r10.z(r11, r2)
            if (r3 == 0) goto L_0x00a4
        L_0x00a2:
            r3 = 1
            goto L_0x00aa
        L_0x00a4:
            int r3 = r9.sessionDepthCounter
            if (r3 == 0) goto L_0x00a9
            goto L_0x00a2
        L_0x00a9:
            r3 = 0
        L_0x00aa:
            if (r3 == 0) goto L_0x00b1
            int r3 = r9.sessionDepthCounter
            r10.w(r11, r2, r3)
        L_0x00b1:
            r2 = 6
            boolean r3 = r10.z(r11, r2)
            if (r3 == 0) goto L_0x00ba
        L_0x00b8:
            r1 = 1
            goto L_0x00c8
        L_0x00ba:
            java.util.List<com.vungle.ads.internal.model.UnclosedAd> r3 = r9.unclosedAd
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r3, r4)
            if (r3 != 0) goto L_0x00c8
            goto L_0x00b8
        L_0x00c8:
            if (r1 == 0) goto L_0x00d6
            kotlinx.serialization.internal.ArrayListSerializer r0 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.UnclosedAd$$serializer r1 = com.vungle.ads.internal.model.UnclosedAd$$serializer.INSTANCE
            r0.<init>(r1)
            java.util.List<com.vungle.ads.internal.model.UnclosedAd> r9 = r9.unclosedAd
            r10.C(r11, r2, r0, r9)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.signals.SessionData.write$Self(com.vungle.ads.internal.signals.SessionData, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final int component1() {
        return this.sessionCount;
    }

    public final SessionData copy(int i2) {
        return new SessionData(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SessionData) && this.sessionCount == ((SessionData) obj).sessionCount;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }

    public final long getSessionCreationTime() {
        return this.sessionCreationTime;
    }

    public final int getSessionDepthCounter() {
        return this.sessionDepthCounter;
    }

    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<SignaledAd> getSignaledAd() {
        return this.signaledAd;
    }

    public final List<UnclosedAd> getUnclosedAd() {
        return this.unclosedAd;
    }

    public int hashCode() {
        return this.sessionCount;
    }

    public final void setSessionCreationTime(long j2) {
        this.sessionCreationTime = j2;
    }

    public final void setSessionDepthCounter(int i2) {
        this.sessionDepthCounter = i2;
    }

    public final void setSessionDuration(long j2) {
        this.sessionDuration = j2;
    }

    public final void setSignaledAd(List<SignaledAd> list) {
        Intrinsics.f(list, "<set-?>");
        this.signaledAd = list;
    }

    public final void setUnclosedAd(List<UnclosedAd> list) {
        Intrinsics.f(list, "<set-?>");
        this.unclosedAd = list;
    }

    public String toString() {
        return "SessionData(sessionCount=" + this.sessionCount + ')';
    }

    public /* synthetic */ SessionData(int i2, int i3, String str, long j2, List list, long j3, int i4, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i2 & 1)) {
            PluginExceptionsKt.a(i2, 1, SessionData$$serializer.INSTANCE.getDescriptor());
        }
        this.sessionCount = i3;
        if ((i2 & 2) == 0) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.e(uuid, "randomUUID().toString()");
            this.sessionId = uuid;
        } else {
            this.sessionId = str;
        }
        if ((i2 & 4) == 0) {
            this.sessionCreationTime = System.currentTimeMillis() / 1000;
        } else {
            this.sessionCreationTime = j2;
        }
        if ((i2 & 8) == 0) {
            this.signaledAd = new ArrayList();
        } else {
            this.signaledAd = list;
        }
        if ((i2 & 16) == 0) {
            this.sessionDuration = 0;
        } else {
            this.sessionDuration = j3;
        }
        if ((i2 & 32) == 0) {
            this.sessionDepthCounter = 0;
        } else {
            this.sessionDepthCounter = i4;
        }
        if ((i2 & 64) == 0) {
            this.unclosedAd = new ArrayList();
        } else {
            this.unclosedAd = list2;
        }
    }
}
