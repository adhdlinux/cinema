package com.vungle.ads.internal.model;

import com.applovin.impl.adview.activity.FullscreenAdService;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

public final class AdPayload$AdUnit$$serializer implements GeneratedSerializer<AdPayload.AdUnit> {
    public static final AdPayload$AdUnit$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AdPayload$AdUnit$$serializer adPayload$AdUnit$$serializer = new AdPayload$AdUnit$$serializer();
        INSTANCE = adPayload$AdUnit$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.AdUnit", adPayload$AdUnit$$serializer, 25);
        pluginGeneratedSerialDescriptor.l("id", true);
        pluginGeneratedSerialDescriptor.l("ad_type", true);
        pluginGeneratedSerialDescriptor.l(FullscreenAdService.DATA_KEY_AD_SOURCE, true);
        pluginGeneratedSerialDescriptor.l("expiry", true);
        pluginGeneratedSerialDescriptor.l("deeplink_url", true);
        pluginGeneratedSerialDescriptor.l("click_coordinates_enabled", true);
        pluginGeneratedSerialDescriptor.l("ad_load_optimization", true);
        pluginGeneratedSerialDescriptor.l("template_heartbeat_check", true);
        pluginGeneratedSerialDescriptor.l("info", true);
        pluginGeneratedSerialDescriptor.l("sleep", true);
        pluginGeneratedSerialDescriptor.l("error_code", true);
        pluginGeneratedSerialDescriptor.l(MRAIDPresenter.TPAT, true);
        pluginGeneratedSerialDescriptor.l("vm_url", true);
        pluginGeneratedSerialDescriptor.l("ad_market_id", true);
        pluginGeneratedSerialDescriptor.l("notification", true);
        pluginGeneratedSerialDescriptor.l("load_ad", true);
        pluginGeneratedSerialDescriptor.l("viewability", true);
        pluginGeneratedSerialDescriptor.l("template_url", true);
        pluginGeneratedSerialDescriptor.l("template_type", true);
        pluginGeneratedSerialDescriptor.l("template_settings", true);
        pluginGeneratedSerialDescriptor.l("creative_id", true);
        pluginGeneratedSerialDescriptor.l("app_id", true);
        pluginGeneratedSerialDescriptor.l("show_close", true);
        pluginGeneratedSerialDescriptor.l("show_close_incentivized", true);
        pluginGeneratedSerialDescriptor.l("ad_size", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$AdUnit$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f41077a;
        IntSerializer intSerializer = IntSerializer.f41006a;
        BooleanSerializer booleanSerializer = BooleanSerializer.f40947a;
        return new KSerializer[]{BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(booleanSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(AdPayload.TpatSerializer.INSTANCE), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(new ArrayListSerializer(stringSerializer)), BuiltinSerializersKt.s(new ArrayListSerializer(stringSerializer)), BuiltinSerializersKt.s(AdPayload$ViewAbility$$serializer.INSTANCE), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(AdPayload$TemplateSettings$$serializer.INSTANCE), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(stringSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(intSerializer), BuiltinSerializersKt.s(AdPayload$AdSizeInfo$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0169, code lost:
        r10 = r10 | r2;
        r15 = r15;
        r14 = r14;
        r6 = r6;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x01ce, code lost:
        r10 = r10 | r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x01e7, code lost:
        r3 = r64;
        r15 = r15;
        r14 = r14;
        r6 = r6;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x01e9, code lost:
        r13 = r49;
        r2 = r50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0488, code lost:
        r3 = r64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0118, code lost:
        r15 = r15;
        r14 = r14;
        r6 = r6;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0118, code lost:
        r15 = r15;
        r14 = r14;
        r6 = r6;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0118, code lost:
        r15 = r15;
        r14 = r14;
        r6 = r6;
        r5 = r5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.AdPayload.AdUnit deserialize(kotlinx.serialization.encoding.Decoder r64) {
        /*
            r63 = this;
            r0 = r64
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r63.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.b(r1)
            boolean r2 = r0.p()
            r13 = 9
            r14 = 7
            r15 = 6
            r3 = 5
            r4 = 3
            r6 = 8
            r5 = 4
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = 0
            if (r2 == 0) goto L_0x00f0
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r9 = r0.n(r1, r9, r2, r10)
            java.lang.Object r8 = r0.n(r1, r8, r2, r10)
            java.lang.Object r7 = r0.n(r1, r7, r2, r10)
            kotlinx.serialization.internal.IntSerializer r11 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r4 = r0.n(r1, r4, r11, r10)
            java.lang.Object r5 = r0.n(r1, r5, r2, r10)
            kotlinx.serialization.internal.BooleanSerializer r12 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            java.lang.Object r3 = r0.n(r1, r3, r12, r10)
            java.lang.Object r15 = r0.n(r1, r15, r12, r10)
            java.lang.Object r12 = r0.n(r1, r14, r12, r10)
            java.lang.Object r6 = r0.n(r1, r6, r2, r10)
            java.lang.Object r13 = r0.n(r1, r13, r11, r10)
            r14 = 10
            java.lang.Object r14 = r0.n(r1, r14, r11, r10)
            r25 = r3
            com.vungle.ads.internal.model.AdPayload$TpatSerializer r3 = com.vungle.ads.internal.model.AdPayload.TpatSerializer.INSTANCE
            r26 = r4
            r4 = 11
            java.lang.Object r3 = r0.n(r1, r4, r3, r10)
            r4 = 12
            java.lang.Object r4 = r0.n(r1, r4, r2, r10)
            r23 = r3
            r3 = 13
            java.lang.Object r3 = r0.n(r1, r3, r2, r10)
            r22 = r3
            kotlinx.serialization.internal.ArrayListSerializer r3 = new kotlinx.serialization.internal.ArrayListSerializer
            r3.<init>(r2)
            r24 = r4
            r4 = 14
            java.lang.Object r3 = r0.n(r1, r4, r3, r10)
            kotlinx.serialization.internal.ArrayListSerializer r4 = new kotlinx.serialization.internal.ArrayListSerializer
            r4.<init>(r2)
            r21 = r3
            r3 = 15
            java.lang.Object r3 = r0.n(r1, r3, r4, r10)
            com.vungle.ads.internal.model.AdPayload$ViewAbility$$serializer r4 = com.vungle.ads.internal.model.AdPayload$ViewAbility$$serializer.INSTANCE
            r20 = r3
            r3 = 16
            java.lang.Object r3 = r0.n(r1, r3, r4, r10)
            r4 = 17
            java.lang.Object r4 = r0.n(r1, r4, r2, r10)
            r18 = r3
            r3 = 18
            java.lang.Object r3 = r0.n(r1, r3, r2, r10)
            r17 = r3
            com.vungle.ads.internal.model.AdPayload$TemplateSettings$$serializer r3 = com.vungle.ads.internal.model.AdPayload$TemplateSettings$$serializer.INSTANCE
            r19 = r4
            r4 = 19
            java.lang.Object r3 = r0.n(r1, r4, r3, r10)
            r4 = 20
            java.lang.Object r4 = r0.n(r1, r4, r2, r10)
            r64 = r3
            r3 = 21
            java.lang.Object r2 = r0.n(r1, r3, r2, r10)
            r3 = 22
            java.lang.Object r3 = r0.n(r1, r3, r11, r10)
            r16 = r2
            r2 = 23
            java.lang.Object r2 = r0.n(r1, r2, r11, r10)
            r11 = 24
            r27 = r2
            com.vungle.ads.internal.model.AdPayload$AdSizeInfo$$serializer r2 = com.vungle.ads.internal.model.AdPayload$AdSizeInfo$$serializer.INSTANCE
            java.lang.Object r2 = r0.n(r1, r11, r2, r10)
            r10 = 33554431(0x1ffffff, float:9.403954E-38)
            r29 = r5
            r33 = r6
            r10 = r14
            r31 = r15
            r14 = r27
            r35 = 33554431(0x1ffffff, float:9.403954E-38)
            r6 = r2
            r15 = r3
            r5 = r4
            r2 = r16
            r3 = r25
            r4 = r64
            goto L_0x04d0
        L_0x00f0:
            r2 = r10
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r11 = r9
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r36 = r15
            r37 = r36
            r38 = r37
            r39 = r38
            r40 = r39
            r41 = r40
            r42 = r41
            r43 = r42
            r44 = r43
            r45 = r44
            r46 = r45
            r47 = r46
            r10 = 0
            r48 = 1
        L_0x0118:
            if (r48 == 0) goto L_0x048c
            r49 = r13
            int r13 = r0.o(r1)
            switch(r13) {
                case -1: goto L_0x0461;
                case 0: goto L_0x042e;
                case 1: goto L_0x03f6;
                case 2: goto L_0x03c0;
                case 3: goto L_0x038c;
                case 4: goto L_0x035a;
                case 5: goto L_0x032a;
                case 6: goto L_0x02fc;
                case 7: goto L_0x02cf;
                case 8: goto L_0x02a3;
                case 9: goto L_0x0279;
                case 10: goto L_0x0251;
                case 11: goto L_0x022d;
                case 12: goto L_0x020d;
                case 13: goto L_0x01ef;
                case 14: goto L_0x01d0;
                case 15: goto L_0x01b6;
                case 16: goto L_0x01a3;
                case 17: goto L_0x0190;
                case 18: goto L_0x017d;
                case 19: goto L_0x016c;
                case 20: goto L_0x015d;
                case 21: goto L_0x0150;
                case 22: goto L_0x0143;
                case 23: goto L_0x0136;
                case 24: goto L_0x0129;
                default: goto L_0x0123;
            }
        L_0x0123:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r13)
            throw r0
        L_0x0129:
            r13 = 24
            r50 = r2
            com.vungle.ads.internal.model.AdPayload$AdSizeInfo$$serializer r2 = com.vungle.ads.internal.model.AdPayload$AdSizeInfo$$serializer.INSTANCE
            java.lang.Object r6 = r0.n(r1, r13, r2, r6)
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x0169
        L_0x0136:
            r50 = r2
            r2 = 23
            kotlinx.serialization.internal.IntSerializer r13 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r14 = r0.n(r1, r2, r13, r14)
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0169
        L_0x0143:
            r50 = r2
            r2 = 22
            kotlinx.serialization.internal.IntSerializer r13 = kotlinx.serialization.internal.IntSerializer.f41006a
            java.lang.Object r15 = r0.n(r1, r2, r13, r15)
            r2 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0169
        L_0x0150:
            r50 = r2
            r2 = 21
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.f41077a
            java.lang.Object r3 = r0.n(r1, r2, r13, r3)
            r2 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x0169
        L_0x015d:
            r50 = r2
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r13 = 20
            java.lang.Object r5 = r0.n(r1, r13, r2, r5)
            r2 = 1048576(0x100000, float:1.469368E-39)
        L_0x0169:
            r10 = r10 | r2
            goto L_0x01e9
        L_0x016c:
            r50 = r2
            r13 = 20
            com.vungle.ads.internal.model.AdPayload$TemplateSettings$$serializer r2 = com.vungle.ads.internal.model.AdPayload$TemplateSettings$$serializer.INSTANCE
            r64 = r3
            r3 = 19
            java.lang.Object r4 = r0.n(r1, r3, r2, r4)
            r2 = 524288(0x80000, float:7.34684E-40)
            goto L_0x01ce
        L_0x017d:
            r50 = r2
            r64 = r3
            r3 = 19
            r13 = 20
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r3 = 18
            java.lang.Object r7 = r0.n(r1, r3, r2, r7)
            r2 = 262144(0x40000, float:3.67342E-40)
            goto L_0x01ce
        L_0x0190:
            r50 = r2
            r64 = r3
            r3 = 18
            r13 = 20
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r3 = 17
            java.lang.Object r8 = r0.n(r1, r3, r2, r8)
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01ce
        L_0x01a3:
            r50 = r2
            r64 = r3
            r3 = 17
            r13 = 20
            com.vungle.ads.internal.model.AdPayload$ViewAbility$$serializer r2 = com.vungle.ads.internal.model.AdPayload$ViewAbility$$serializer.INSTANCE
            r3 = 16
            java.lang.Object r9 = r0.n(r1, r3, r2, r9)
            r2 = 65536(0x10000, float:9.18355E-41)
            goto L_0x01ce
        L_0x01b6:
            r50 = r2
            r64 = r3
            r3 = 16
            r13 = 20
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.f41077a
            r2.<init>(r3)
            r3 = 15
            java.lang.Object r12 = r0.n(r1, r3, r2, r12)
            r2 = 32768(0x8000, float:4.5918E-41)
        L_0x01ce:
            r10 = r10 | r2
            goto L_0x01e7
        L_0x01d0:
            r50 = r2
            r64 = r3
            r3 = 15
            r13 = 20
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.f41077a
            r2.<init>(r3)
            r3 = 14
            java.lang.Object r11 = r0.n(r1, r3, r2, r11)
            r10 = r10 | 16384(0x4000, float:2.2959E-41)
        L_0x01e7:
            r3 = r64
        L_0x01e9:
            r13 = r49
            r2 = r50
            goto L_0x0118
        L_0x01ef:
            r50 = r2
            r64 = r3
            r3 = 14
            r13 = 20
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r22 = r4
            r3 = r50
            r4 = 13
            java.lang.Object r2 = r0.n(r1, r4, r2, r3)
            r10 = r10 | 8192(0x2000, float:1.14794E-41)
            r3 = r64
            r4 = r22
            r13 = r49
            goto L_0x0118
        L_0x020d:
            r64 = r3
            r22 = r4
            r4 = 13
            r13 = 20
            r3 = r2
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r23 = r3
            r4 = r49
            r3 = 12
            java.lang.Object r2 = r0.n(r1, r3, r2, r4)
            r10 = r10 | 4096(0x1000, float:5.74E-42)
            r3 = r64
            r13 = r2
            r4 = r22
            r2 = r23
            goto L_0x0118
        L_0x022d:
            r23 = r2
            r64 = r3
            r22 = r4
            r4 = r49
            r3 = 12
            r13 = 20
            com.vungle.ads.internal.model.AdPayload$TpatSerializer r2 = com.vungle.ads.internal.model.AdPayload.TpatSerializer.INSTANCE
            r24 = r4
            r3 = r47
            r4 = 11
            java.lang.Object r47 = r0.n(r1, r4, r2, r3)
            r10 = r10 | 2048(0x800, float:2.87E-42)
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            goto L_0x0118
        L_0x0251:
            r23 = r2
            r64 = r3
            r22 = r4
            r3 = r47
            r24 = r49
            r4 = 11
            r13 = 20
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.f41006a
            r25 = r3
            r4 = r46
            r3 = 10
            java.lang.Object r46 = r0.n(r1, r3, r2, r4)
            r10 = r10 | 1024(0x400, float:1.435E-42)
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r47 = r25
            goto L_0x0118
        L_0x0279:
            r23 = r2
            r64 = r3
            r22 = r4
            r4 = r46
            r25 = r47
            r24 = r49
            r3 = 10
            r13 = 20
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.f41006a
            r35 = r4
            r3 = r45
            r4 = 9
            java.lang.Object r45 = r0.n(r1, r4, r2, r3)
            r10 = r10 | 512(0x200, float:7.175E-43)
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r46 = r35
            goto L_0x0118
        L_0x02a3:
            r23 = r2
            r64 = r3
            r22 = r4
            r3 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r4 = 9
            r13 = 20
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r34 = r3
            r4 = r44
            r3 = 8
            java.lang.Object r44 = r0.n(r1, r3, r2, r4)
            r10 = r10 | 256(0x100, float:3.59E-43)
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r45 = r34
            goto L_0x0118
        L_0x02cf:
            r23 = r2
            r64 = r3
            r22 = r4
            r4 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r3 = 8
            r13 = 20
            kotlinx.serialization.internal.BooleanSerializer r2 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r33 = r4
            r3 = r43
            r4 = 7
            java.lang.Object r43 = r0.n(r1, r4, r2, r3)
            r10 = r10 | 128(0x80, float:1.794E-43)
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r44 = r33
            goto L_0x0118
        L_0x02fc:
            r23 = r2
            r64 = r3
            r22 = r4
            r3 = r43
            r33 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r4 = 7
            r13 = 20
            kotlinx.serialization.internal.BooleanSerializer r2 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r32 = r3
            r4 = r42
            r3 = 6
            java.lang.Object r42 = r0.n(r1, r3, r2, r4)
            r10 = r10 | 64
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r43 = r32
            goto L_0x0118
        L_0x032a:
            r23 = r2
            r64 = r3
            r22 = r4
            r4 = r42
            r32 = r43
            r33 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r3 = 6
            r13 = 20
            kotlinx.serialization.internal.BooleanSerializer r2 = kotlinx.serialization.internal.BooleanSerializer.f40947a
            r31 = r4
            r3 = r41
            r4 = 5
            java.lang.Object r41 = r0.n(r1, r4, r2, r3)
            r10 = r10 | 32
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r42 = r31
            goto L_0x0118
        L_0x035a:
            r23 = r2
            r64 = r3
            r22 = r4
            r3 = r41
            r31 = r42
            r32 = r43
            r33 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r4 = 5
            r13 = 20
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r30 = r3
            r4 = r40
            r3 = 4
            java.lang.Object r40 = r0.n(r1, r3, r2, r4)
            r10 = r10 | 16
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r41 = r30
            goto L_0x0118
        L_0x038c:
            r23 = r2
            r64 = r3
            r22 = r4
            r4 = r40
            r30 = r41
            r31 = r42
            r32 = r43
            r33 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r3 = 4
            r13 = 20
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.f41006a
            r29 = r4
            r3 = r39
            r4 = 3
            java.lang.Object r39 = r0.n(r1, r4, r2, r3)
            r10 = r10 | 8
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r40 = r29
            goto L_0x0118
        L_0x03c0:
            r23 = r2
            r64 = r3
            r22 = r4
            r3 = r39
            r29 = r40
            r30 = r41
            r31 = r42
            r32 = r43
            r33 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r4 = 3
            r13 = 20
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r28 = r3
            r4 = r38
            r3 = 2
            java.lang.Object r38 = r0.n(r1, r3, r2, r4)
            r10 = r10 | 4
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r39 = r28
            goto L_0x0118
        L_0x03f6:
            r23 = r2
            r64 = r3
            r22 = r4
            r4 = r38
            r28 = r39
            r29 = r40
            r30 = r41
            r31 = r42
            r32 = r43
            r33 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r3 = 2
            r13 = 20
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r27 = r4
            r3 = r37
            r4 = 1
            java.lang.Object r37 = r0.n(r1, r4, r2, r3)
            r10 = r10 | 2
            r3 = r64
            r4 = r22
            r2 = r23
            r13 = r24
            r38 = r27
            goto L_0x0118
        L_0x042e:
            r23 = r2
            r64 = r3
            r22 = r4
            r3 = r37
            r27 = r38
            r28 = r39
            r29 = r40
            r30 = r41
            r31 = r42
            r32 = r43
            r33 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r4 = 1
            r13 = 20
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.f41077a
            r4 = r36
            r13 = 0
            java.lang.Object r36 = r0.n(r1, r13, r2, r4)
            r10 = r10 | 1
            r4 = r22
            r2 = r23
            r13 = r24
            goto L_0x0488
        L_0x0461:
            r23 = r2
            r64 = r3
            r22 = r4
            r4 = r36
            r3 = r37
            r27 = r38
            r28 = r39
            r29 = r40
            r30 = r41
            r31 = r42
            r32 = r43
            r33 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r24 = r49
            r13 = 0
            r4 = r22
            r13 = r24
            r48 = 0
        L_0x0488:
            r3 = r64
            goto L_0x0118
        L_0x048c:
            r23 = r2
            r64 = r3
            r22 = r4
            r24 = r13
            r4 = r36
            r3 = r37
            r27 = r38
            r28 = r39
            r29 = r40
            r30 = r41
            r31 = r42
            r32 = r43
            r33 = r44
            r34 = r45
            r35 = r46
            r25 = r47
            r2 = r64
            r17 = r7
            r19 = r8
            r18 = r9
            r21 = r11
            r20 = r12
            r7 = r27
            r26 = r28
            r12 = r32
            r13 = r34
            r8 = r3
            r9 = r4
            r4 = r22
            r22 = r23
            r23 = r25
            r3 = r30
            r62 = r35
            r35 = r10
            r10 = r62
        L_0x04d0:
            r0.c(r1)
            com.vungle.ads.internal.model.AdPayload$AdUnit r0 = new com.vungle.ads.internal.model.AdPayload$AdUnit
            r34 = r0
            r36 = r9
            java.lang.String r36 = (java.lang.String) r36
            r37 = r8
            java.lang.String r37 = (java.lang.String) r37
            r38 = r7
            java.lang.String r38 = (java.lang.String) r38
            r39 = r26
            java.lang.Integer r39 = (java.lang.Integer) r39
            r40 = r29
            java.lang.String r40 = (java.lang.String) r40
            r41 = r3
            java.lang.Boolean r41 = (java.lang.Boolean) r41
            r42 = r31
            java.lang.Boolean r42 = (java.lang.Boolean) r42
            r43 = r12
            java.lang.Boolean r43 = (java.lang.Boolean) r43
            r44 = r33
            java.lang.String r44 = (java.lang.String) r44
            r45 = r13
            java.lang.Integer r45 = (java.lang.Integer) r45
            r46 = r10
            java.lang.Integer r46 = (java.lang.Integer) r46
            r47 = r23
            java.util.Map r47 = (java.util.Map) r47
            r48 = r24
            java.lang.String r48 = (java.lang.String) r48
            r49 = r22
            java.lang.String r49 = (java.lang.String) r49
            r50 = r21
            java.util.List r50 = (java.util.List) r50
            r51 = r20
            java.util.List r51 = (java.util.List) r51
            r52 = r18
            com.vungle.ads.internal.model.AdPayload$ViewAbility r52 = (com.vungle.ads.internal.model.AdPayload.ViewAbility) r52
            r53 = r19
            java.lang.String r53 = (java.lang.String) r53
            r54 = r17
            java.lang.String r54 = (java.lang.String) r54
            r55 = r4
            com.vungle.ads.internal.model.AdPayload$TemplateSettings r55 = (com.vungle.ads.internal.model.AdPayload.TemplateSettings) r55
            r56 = r5
            java.lang.String r56 = (java.lang.String) r56
            r57 = r2
            java.lang.String r57 = (java.lang.String) r57
            r58 = r15
            java.lang.Integer r58 = (java.lang.Integer) r58
            r59 = r14
            java.lang.Integer r59 = (java.lang.Integer) r59
            r60 = r6
            com.vungle.ads.internal.model.AdPayload$AdSizeInfo r60 = (com.vungle.ads.internal.model.AdPayload.AdSizeInfo) r60
            r61 = 0
            r34.<init>((int) r35, (java.lang.String) r36, (java.lang.String) r37, (java.lang.String) r38, (java.lang.Integer) r39, (java.lang.String) r40, (java.lang.Boolean) r41, (java.lang.Boolean) r42, (java.lang.Boolean) r43, (java.lang.String) r44, (java.lang.Integer) r45, (java.lang.Integer) r46, (java.util.Map) r47, (java.lang.String) r48, (java.lang.String) r49, (java.util.List) r50, (java.util.List) r51, (com.vungle.ads.internal.model.AdPayload.ViewAbility) r52, (java.lang.String) r53, (java.lang.String) r54, (com.vungle.ads.internal.model.AdPayload.TemplateSettings) r55, (java.lang.String) r56, (java.lang.String) r57, (java.lang.Integer) r58, (java.lang.Integer) r59, (com.vungle.ads.internal.model.AdPayload.AdSizeInfo) r60, (kotlinx.serialization.internal.SerializationConstructorMarker) r61)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload$AdUnit$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.AdPayload$AdUnit");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, AdPayload.AdUnit adUnit) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(adUnit, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor2);
        AdPayload.AdUnit.write$Self(adUnit, b2, descriptor2);
        b2.c(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
