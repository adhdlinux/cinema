package com.vungle.ads.internal.signals;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.UnclosedAd$$serializer;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class SessionData$$serializer implements GeneratedSerializer<SessionData> {
    public static final SessionData$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        SessionData$$serializer sessionData$$serializer = new SessionData$$serializer();
        INSTANCE = sessionData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.signals.SessionData", sessionData$$serializer, 7);
        pluginGeneratedSerialDescriptor.l("103", false);
        pluginGeneratedSerialDescriptor.l("101", true);
        pluginGeneratedSerialDescriptor.l("100", true);
        pluginGeneratedSerialDescriptor.l("106", true);
        pluginGeneratedSerialDescriptor.l("102", true);
        pluginGeneratedSerialDescriptor.l("104", true);
        pluginGeneratedSerialDescriptor.l("105", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SessionData$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.f41006a;
        LongSerializer longSerializer = LongSerializer.f41017a;
        return new KSerializer[]{intSerializer, StringSerializer.f41077a, longSerializer, new ArrayListSerializer(SignaledAd$$serializer.INSTANCE), longSerializer, intSerializer, new ArrayListSerializer(UnclosedAd$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.signals.SessionData deserialize(kotlinx.serialization.encoding.Decoder r24) {
        /*
            r23 = this;
            r0 = r24
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r23.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r3 = 6
            r4 = 5
            r5 = 3
            r6 = 4
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = 0
            if (r2 == 0) goto L_0x0054
            int r2 = r0.i(r1, r9)
            java.lang.String r8 = r0.m(r1, r8)
            long r11 = r0.f(r1, r7)
            kotlinx.serialization.internal.ArrayListSerializer r7 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.signals.SignaledAd$$serializer r9 = com.vungle.ads.internal.signals.SignaledAd$$serializer.INSTANCE
            r7.<init>(r9)
            java.lang.Object r5 = r0.y(r1, r5, r7, r10)
            long r6 = r0.f(r1, r6)
            int r4 = r0.i(r1, r4)
            kotlinx.serialization.internal.ArrayListSerializer r9 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.UnclosedAd$$serializer r13 = com.vungle.ads.internal.model.UnclosedAd$$serializer.INSTANCE
            r9.<init>(r13)
            java.lang.Object r3 = r0.y(r1, r3, r9, r10)
            r9 = 127(0x7f, float:1.78E-43)
            r18 = r4
            r16 = r6
            r13 = r11
            r10 = 127(0x7f, float:1.78E-43)
            r11 = r2
            r12 = r8
            goto L_0x00c5
        L_0x0054:
            r11 = 0
            r9 = r10
            r14 = r9
            r15 = r14
            r16 = r11
            r2 = 0
            r10 = 0
            r13 = 0
            r18 = 1
        L_0x0060:
            if (r18 == 0) goto L_0x00b8
            int r8 = r0.o(r1)
            switch(r8) {
                case -1: goto L_0x00b4;
                case 0: goto L_0x00a9;
                case 1: goto L_0x00a1;
                case 2: goto L_0x009a;
                case 3: goto L_0x008b;
                case 4: goto L_0x0084;
                case 5: goto L_0x007d;
                case 6: goto L_0x006f;
                default: goto L_0x0069;
            }
        L_0x0069:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r8)
            throw r0
        L_0x006f:
            kotlinx.serialization.internal.ArrayListSerializer r8 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.UnclosedAd$$serializer r7 = com.vungle.ads.internal.model.UnclosedAd$$serializer.INSTANCE
            r8.<init>(r7)
            java.lang.Object r9 = r0.y(r1, r3, r8, r9)
            r13 = r13 | 64
            goto L_0x0098
        L_0x007d:
            int r10 = r0.i(r1, r4)
            r13 = r13 | 32
            goto L_0x0098
        L_0x0084:
            long r11 = r0.f(r1, r6)
            r13 = r13 | 16
            goto L_0x0098
        L_0x008b:
            kotlinx.serialization.internal.ArrayListSerializer r7 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.signals.SignaledAd$$serializer r8 = com.vungle.ads.internal.signals.SignaledAd$$serializer.INSTANCE
            r7.<init>(r8)
            java.lang.Object r15 = r0.y(r1, r5, r7, r15)
            r13 = r13 | 8
        L_0x0098:
            r7 = 2
            goto L_0x00b6
        L_0x009a:
            long r16 = r0.f(r1, r7)
            r13 = r13 | 4
            goto L_0x00b6
        L_0x00a1:
            r8 = 1
            java.lang.String r14 = r0.m(r1, r8)
            r13 = r13 | 2
            goto L_0x0060
        L_0x00a9:
            r2 = 0
            r8 = 1
            int r19 = r0.i(r1, r2)
            r13 = r13 | 1
            r2 = r19
            goto L_0x0060
        L_0x00b4:
            r18 = 0
        L_0x00b6:
            r8 = 1
            goto L_0x0060
        L_0x00b8:
            r3 = r9
            r18 = r10
            r10 = r13
            r5 = r15
            r21 = r11
            r11 = r2
            r12 = r14
            r13 = r16
            r16 = r21
        L_0x00c5:
            r0.c(r1)
            com.vungle.ads.internal.signals.SessionData r0 = new com.vungle.ads.internal.signals.SessionData
            r15 = r5
            java.util.List r15 = (java.util.List) r15
            r19 = r3
            java.util.List r19 = (java.util.List) r19
            r20 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r15, r16, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.signals.SessionData$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.signals.SessionData");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, SessionData sessionData) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(sessionData, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        SessionData.write$Self(sessionData, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
