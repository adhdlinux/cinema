package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzs;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.vungle.ads.internal.Constants;
import java.util.List;
import org.json.JSONObject;

public final class zzezn {
    public final String zzA;
    public final zzbwp zzB;
    public final String zzC;
    public final JSONObject zzD;
    public final JSONObject zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final String zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final int zzR;
    public final int zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final String zzV;
    public final zzfal zzW;
    public final boolean zzX;
    public final boolean zzY;
    public final int zzZ;
    public final List zza;
    public final String zzaa;
    public final int zzab;
    public final String zzac;
    public final boolean zzad;
    public final zzbrz zzae;
    public final zzs zzaf;
    public final String zzag;
    public final boolean zzah;
    public final JSONObject zzai;
    public final boolean zzaj;
    public final JSONObject zzak;
    public final boolean zzal;
    public final String zzam;
    public final boolean zzan;
    public final String zzao;
    public final String zzap;
    public final String zzaq;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final List zze;
    public final int zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final List zzj;
    public final String zzk;
    public final String zzl;
    public final zzbvg zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final List zzq;
    public final int zzr;
    public final List zzs;
    public final zzezs zzt;
    public final List zzu;
    public final List zzv;
    public final JSONObject zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x06a6, code lost:
        r10 = r77;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0811, code lost:
        r10 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0813, code lost:
        r9 = r75;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzezn(android.util.JsonReader r77) throws java.lang.IllegalStateException, java.io.IOException, org.json.JSONException, java.lang.NumberFormatException {
        /*
            r76 = this;
            r0 = r76
            r76.<init>()
            java.util.List r1 = java.util.Collections.emptyList()
            java.util.List r2 = java.util.Collections.emptyList()
            java.util.List r3 = java.util.Collections.emptyList()
            java.util.List r4 = java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r7 = java.util.Collections.emptyList()
            java.util.List r8 = java.util.Collections.emptyList()
            java.util.List r9 = java.util.Collections.emptyList()
            java.util.List r10 = java.util.Collections.emptyList()
            java.util.List r11 = java.util.Collections.emptyList()
            java.util.List r12 = java.util.Collections.emptyList()
            java.util.List r13 = java.util.Collections.emptyList()
            java.util.List r14 = java.util.Collections.emptyList()
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            org.json.JSONObject r16 = new org.json.JSONObject
            r16.<init>()
            org.json.JSONObject r17 = new org.json.JSONObject
            r17.<init>()
            org.json.JSONObject r18 = new org.json.JSONObject
            r18.<init>()
            org.json.JSONObject r19 = new org.json.JSONObject
            r19.<init>()
            org.json.JSONObject r20 = new org.json.JSONObject
            r20.<init>()
            com.google.android.gms.internal.ads.zzfsc r21 = com.google.android.gms.internal.ads.zzfsc.zzl()
            r77.beginObject()
            java.lang.String r22 = ""
            r23 = 0
            r24 = 0
            r25 = -1
            r26 = r16
            r27 = r17
            r28 = r18
            r29 = r19
            r30 = r20
            r31 = r21
            r37 = r22
            r38 = r37
            r39 = r38
            r40 = r39
            r41 = r40
            r52 = r41
            r56 = r52
            r58 = r56
            r60 = r58
            r62 = r60
            r63 = r62
            r64 = r63
            r65 = r64
            r66 = r65
            r71 = r66
            r72 = r71
            r73 = r72
            r19 = r24
            r32 = r19
            r33 = r32
            r34 = r33
            r35 = r34
            r36 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = -1
            r50 = 0
            r51 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r57 = -1
            r59 = 0
            r61 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r70 = 0
            r21 = r11
            r20 = r12
            r18 = r13
            r17 = r14
            r16 = r15
            r11 = r73
            r12 = r11
            r15 = r35
            r13 = 0
            r14 = 0
        L_0x00dd:
            boolean r24 = r77.hasNext()
            if (r24 == 0) goto L_0x0817
            java.lang.String r24 = r77.nextName()
            if (r24 != 0) goto L_0x00ec
            r74 = r22
            goto L_0x00ee
        L_0x00ec:
            r74 = r24
        L_0x00ee:
            int r24 = r74.hashCode()
            switch(r24) {
                case -2138196627: goto L_0x05c8;
                case -1980587809: goto L_0x05b7;
                case -1965512151: goto L_0x05a6;
                case -1871425831: goto L_0x0595;
                case -1812055556: goto L_0x0584;
                case -1776946669: goto L_0x0573;
                case -1662989631: goto L_0x0561;
                case -1620470467: goto L_0x054f;
                case -1550155393: goto L_0x053d;
                case -1440104884: goto L_0x052b;
                case -1439500848: goto L_0x0519;
                case -1428969291: goto L_0x0507;
                case -1406227629: goto L_0x04f5;
                case -1403779768: goto L_0x04e3;
                case -1375413093: goto L_0x04d1;
                case -1360811658: goto L_0x04bf;
                case -1306015996: goto L_0x04ad;
                case -1303332046: goto L_0x049b;
                case -1289032093: goto L_0x0489;
                case -1240082064: goto L_0x0477;
                case -1234181075: goto L_0x0465;
                case -1168140544: goto L_0x0453;
                case -1152230954: goto L_0x0442;
                case -1146534047: goto L_0x0430;
                case -1115838944: goto L_0x041e;
                case -1081936678: goto L_0x040c;
                case -1078050970: goto L_0x03fa;
                case -1051269058: goto L_0x03e8;
                case -982608540: goto L_0x03d6;
                case -972056451: goto L_0x03c4;
                case -776859333: goto L_0x03b3;
                case -544216775: goto L_0x03a1;
                case -437057161: goto L_0x0390;
                case -404433734: goto L_0x037e;
                case -404326515: goto L_0x036c;
                case -397704715: goto L_0x035a;
                case -388807511: goto L_0x0348;
                case -369773488: goto L_0x0336;
                case -213449460: goto L_0x0324;
                case -213424028: goto L_0x0312;
                case -180214626: goto L_0x0300;
                case -154616268: goto L_0x02ee;
                case -29338502: goto L_0x02dc;
                case 3107: goto L_0x02ca;
                case 3355: goto L_0x02b8;
                case 3076010: goto L_0x02a6;
                case 37109963: goto L_0x0294;
                case 63195984: goto L_0x0282;
                case 107433883: goto L_0x0270;
                case 230323073: goto L_0x025f;
                case 418392395: goto L_0x024d;
                case 549176928: goto L_0x023b;
                case 597473788: goto L_0x0229;
                case 754887508: goto L_0x0217;
                case 791122864: goto L_0x0206;
                case 1010584092: goto L_0x01f4;
                case 1100650276: goto L_0x01e2;
                case 1141602460: goto L_0x01d0;
                case 1186014765: goto L_0x01be;
                case 1321720943: goto L_0x01ac;
                case 1437255331: goto L_0x019a;
                case 1637553475: goto L_0x0188;
                case 1638957285: goto L_0x0177;
                case 1686319423: goto L_0x0165;
                case 1688341040: goto L_0x0154;
                case 1799285870: goto L_0x0142;
                case 1839650832: goto L_0x0131;
                case 1875425491: goto L_0x011f;
                case 2068142375: goto L_0x010d;
                case 2072888499: goto L_0x00fb;
                default: goto L_0x00f5;
            }
        L_0x00f5:
            r75 = r9
            r24 = r10
            goto L_0x05d9
        L_0x00fb:
            r24 = r10
            java.lang.String r10 = "manual_tracking_urls"
            r75 = r9
            r9 = r74
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 15
            goto L_0x05da
        L_0x010d:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "rule_line_external_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 52
            goto L_0x05da
        L_0x011f:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_analytics_logging_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 42
            goto L_0x05da
        L_0x0131:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "renderers"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 0
            goto L_0x05da
        L_0x0142:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "use_third_party_container_height"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 48
            goto L_0x05da
        L_0x0154:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "video_reward_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 7
            goto L_0x05da
        L_0x0165:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_network_class_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 55
            goto L_0x05da
        L_0x0177:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "video_start_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 6
            goto L_0x05da
        L_0x0188:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "bid_response"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 40
            goto L_0x05da
        L_0x019a:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_source_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 58
            goto L_0x05da
        L_0x01ac:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "allow_pub_owned_ad_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 31
            goto L_0x05da
        L_0x01be:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "cache_hit_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 66
            goto L_0x05da
        L_0x01d0:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "adapter_response_info_key"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 56
            goto L_0x05da
        L_0x01e2:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "rewards"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 11
            goto L_0x05da
        L_0x01f4:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "transaction_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 9
            goto L_0x05da
        L_0x0206:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 5
            goto L_0x05da
        L_0x0217:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "container_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 17
            goto L_0x05da
        L_0x0229:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "debug_dialog_string"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 27
            goto L_0x05da
        L_0x023b:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "presentation_error_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 16
            goto L_0x05da
        L_0x024d:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_closable_area_disabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 36
            goto L_0x05da
        L_0x025f:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_load_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 4
            goto L_0x05da
        L_0x0270:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "qdata"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 24
            goto L_0x05da
        L_0x0282:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "render_test_label"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 33
            goto L_0x05da
        L_0x0294:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "request_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 68
            goto L_0x05da
        L_0x02a6:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "data"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 22
            goto L_0x05da
        L_0x02b8:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 23
            goto L_0x05da
        L_0x02ca:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 18
            goto L_0x05da
        L_0x02dc:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "allow_custom_click_gesture"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 32
            goto L_0x05da
        L_0x02ee:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_offline_ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 61
            goto L_0x05da
        L_0x0300:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "native_required_asset_viewability"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 63
            goto L_0x05da
        L_0x0312:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "watermark"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 46
            goto L_0x05da
        L_0x0324:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "force_disable_hardware_acceleration"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 65
            goto L_0x05da
        L_0x0336:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_close_button_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 50
            goto L_0x05da
        L_0x0348:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "content_url"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 64
            goto L_0x05da
        L_0x035a:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_close_time_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 45
            goto L_0x05da
        L_0x036c:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "render_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 38
            goto L_0x05da
        L_0x037e:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "rtb_native_required_assets"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 62
            goto L_0x05da
        L_0x0390:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "imp_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 3
            goto L_0x05da
        L_0x03a1:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "safe_browsing"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 26
            goto L_0x05da
        L_0x03b3:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "click_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 2
            goto L_0x05da
        L_0x03c4:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_source_instance_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 60
            goto L_0x05da
        L_0x03d6:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "valid_from_timestamp"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 10
            goto L_0x05da
        L_0x03e8:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "active_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 25
            goto L_0x05da
        L_0x03fa:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "video_complete_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 8
            goto L_0x05da
        L_0x040c:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "allocation_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 21
            goto L_0x05da
        L_0x041e:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "fill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 12
            goto L_0x05da
        L_0x0430:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_scroll_aware"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 43
            goto L_0x05da
        L_0x0442:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 1
            goto L_0x05da
        L_0x0453:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "presentation_error_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 14
            goto L_0x05da
        L_0x0465:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "allow_pub_rendered_attribution"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 30
            goto L_0x05da
        L_0x0477:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_event_value"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 51
            goto L_0x05da
        L_0x0489:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "extras"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 29
            goto L_0x05da
        L_0x049b:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "test_mode_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 34
            goto L_0x05da
        L_0x04ad:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "adapters"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 20
            goto L_0x05da
        L_0x04bf:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 19
            goto L_0x05da
        L_0x04d1:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_cover"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 54
            goto L_0x05da
        L_0x04e3:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "showable_impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 44
            goto L_0x05da
        L_0x04f5:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "buffer_click_url_as_ready_to_ping"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 67
            goto L_0x05da
        L_0x0507:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "enable_omid"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 39
            goto L_0x05da
        L_0x0519:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "orientation"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 37
            goto L_0x05da
        L_0x052b:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_custom_close_blocked"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 35
            goto L_0x05da
        L_0x053d:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "nofill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 13
            goto L_0x05da
        L_0x054f:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "backend_query_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 47
            goto L_0x05da
        L_0x0561:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_interscroller"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 53
            goto L_0x05da
        L_0x0573:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_source_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 57
            goto L_0x05da
        L_0x0584:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "play_prewarm_options"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 49
            goto L_0x05da
        L_0x0595:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "recursive_server_response_data"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 69
            goto L_0x05da
        L_0x05a6:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "omid_settings"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 41
            goto L_0x05da
        L_0x05b7:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "debug_signals"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 28
            goto L_0x05da
        L_0x05c8:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_source_instance_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05d9
            r9 = 59
            goto L_0x05da
        L_0x05d9:
            r9 = -1
        L_0x05da:
            switch(r9) {
                case 0: goto L_0x080b;
                case 1: goto L_0x0800;
                case 2: goto L_0x07f9;
                case 3: goto L_0x07f2;
                case 4: goto L_0x07eb;
                case 5: goto L_0x07e0;
                case 6: goto L_0x07d9;
                case 7: goto L_0x07d2;
                case 8: goto L_0x07cb;
                case 9: goto L_0x07c4;
                case 10: goto L_0x07bd;
                case 11: goto L_0x07b2;
                case 12: goto L_0x07aa;
                case 13: goto L_0x07a0;
                case 14: goto L_0x0797;
                case 15: goto L_0x078f;
                case 16: goto L_0x0787;
                case 17: goto L_0x077f;
                case 18: goto L_0x0774;
                case 19: goto L_0x076e;
                case 20: goto L_0x0768;
                case 21: goto L_0x0762;
                case 22: goto L_0x075c;
                case 23: goto L_0x0756;
                case 24: goto L_0x0750;
                case 25: goto L_0x0746;
                case 26: goto L_0x073c;
                case 27: goto L_0x0736;
                case 28: goto L_0x0730;
                case 29: goto L_0x072a;
                case 30: goto L_0x0724;
                case 31: goto L_0x071e;
                case 32: goto L_0x0718;
                case 33: goto L_0x0712;
                case 34: goto L_0x070c;
                case 35: goto L_0x0706;
                case 36: goto L_0x0700;
                case 37: goto L_0x06f6;
                case 38: goto L_0x06f0;
                case 39: goto L_0x06ea;
                case 40: goto L_0x06e4;
                case 41: goto L_0x06de;
                case 42: goto L_0x06d8;
                case 43: goto L_0x06d2;
                case 44: goto L_0x06cc;
                case 45: goto L_0x06c6;
                case 46: goto L_0x06c0;
                case 47: goto L_0x06ba;
                case 48: goto L_0x06b4;
                case 49: goto L_0x06aa;
                case 50: goto L_0x06a3;
                case 51: goto L_0x0699;
                case 52: goto L_0x0693;
                case 53: goto L_0x068d;
                case 54: goto L_0x0687;
                case 55: goto L_0x0681;
                case 56: goto L_0x067b;
                case 57: goto L_0x0663;
                case 58: goto L_0x064b;
                case 59: goto L_0x0633;
                case 60: goto L_0x061a;
                case 61: goto L_0x0614;
                case 62: goto L_0x060e;
                case 63: goto L_0x0608;
                case 64: goto L_0x0602;
                case 65: goto L_0x05fc;
                case 66: goto L_0x05f6;
                case 67: goto L_0x05f0;
                case 68: goto L_0x05ea;
                case 69: goto L_0x05e4;
                default: goto L_0x05dd;
            }
        L_0x05dd:
            r10 = r77
            r77.skipValue()
            goto L_0x0811
        L_0x05e4:
            java.lang.String r72 = r77.nextString()
            goto L_0x0811
        L_0x05ea:
            java.lang.String r71 = r77.nextString()
            goto L_0x0811
        L_0x05f0:
            boolean r70 = r77.nextBoolean()
            goto L_0x0811
        L_0x05f6:
            java.util.List r31 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x05fc:
            boolean r69 = r77.nextBoolean()
            goto L_0x0811
        L_0x0602:
            java.lang.String r35 = r77.nextString()
            goto L_0x0811
        L_0x0608:
            boolean r68 = r77.nextBoolean()
            goto L_0x0811
        L_0x060e:
            org.json.JSONObject r30 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            goto L_0x0811
        L_0x0614:
            boolean r67 = r77.nextBoolean()
            goto L_0x0811
        L_0x061a:
            com.google.android.gms.internal.ads.zzbbe r9 = com.google.android.gms.internal.ads.zzbbm.zzgB
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x062e
            java.lang.String r66 = r77.nextString()
            goto L_0x0811
        L_0x062e:
            r77.skipValue()
            goto L_0x06a6
        L_0x0633:
            com.google.android.gms.internal.ads.zzbbe r9 = com.google.android.gms.internal.ads.zzbbm.zzgB
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0647
            java.lang.String r65 = r77.nextString()
            goto L_0x0811
        L_0x0647:
            r77.skipValue()
            goto L_0x06a6
        L_0x064b:
            com.google.android.gms.internal.ads.zzbbe r9 = com.google.android.gms.internal.ads.zzbbm.zzgB
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x065f
            java.lang.String r64 = r77.nextString()
            goto L_0x0811
        L_0x065f:
            r77.skipValue()
            goto L_0x06a6
        L_0x0663:
            com.google.android.gms.internal.ads.zzbbe r9 = com.google.android.gms.internal.ads.zzbbm.zzgB
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0677
            java.lang.String r63 = r77.nextString()
            goto L_0x0811
        L_0x0677:
            r77.skipValue()
            goto L_0x06a6
        L_0x067b:
            java.lang.String r73 = r77.nextString()
            goto L_0x0811
        L_0x0681:
            java.lang.String r62 = r77.nextString()
            goto L_0x0811
        L_0x0687:
            org.json.JSONObject r29 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            goto L_0x0811
        L_0x068d:
            boolean r61 = r77.nextBoolean()
            goto L_0x0811
        L_0x0693:
            java.lang.String r60 = r77.nextString()
            goto L_0x0811
        L_0x0699:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            com.google.android.gms.ads.internal.client.zzs r34 = com.google.android.gms.ads.internal.client.zzs.zza(r9)
            goto L_0x0811
        L_0x06a3:
            r77.nextBoolean()
        L_0x06a6:
            r10 = r77
            goto L_0x0811
        L_0x06aa:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            com.google.android.gms.internal.ads.zzbrz r33 = com.google.android.gms.internal.ads.zzbrz.zza(r9)
            goto L_0x0811
        L_0x06b4:
            boolean r59 = r77.nextBoolean()
            goto L_0x0811
        L_0x06ba:
            java.lang.String r58 = r77.nextString()
            goto L_0x0811
        L_0x06c0:
            java.lang.String r56 = r77.nextString()
            goto L_0x0811
        L_0x06c6:
            int r57 = r77.nextInt()
            goto L_0x0811
        L_0x06cc:
            int r55 = r77.nextInt()
            goto L_0x0811
        L_0x06d2:
            boolean r54 = r77.nextBoolean()
            goto L_0x0811
        L_0x06d8:
            boolean r53 = r77.nextBoolean()
            goto L_0x0811
        L_0x06de:
            org.json.JSONObject r28 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            goto L_0x0811
        L_0x06e4:
            java.lang.String r52 = r77.nextString()
            goto L_0x0811
        L_0x06ea:
            boolean r51 = r77.nextBoolean()
            goto L_0x0811
        L_0x06f0:
            int r50 = r77.nextInt()
            goto L_0x0811
        L_0x06f6:
            java.lang.String r9 = r77.nextString()
            int r49 = zzd(r9)
            goto L_0x0811
        L_0x0700:
            boolean r48 = r77.nextBoolean()
            goto L_0x0811
        L_0x0706:
            boolean r47 = r77.nextBoolean()
            goto L_0x0811
        L_0x070c:
            boolean r46 = r77.nextBoolean()
            goto L_0x0811
        L_0x0712:
            boolean r45 = r77.nextBoolean()
            goto L_0x0811
        L_0x0718:
            boolean r44 = r77.nextBoolean()
            goto L_0x0811
        L_0x071e:
            boolean r43 = r77.nextBoolean()
            goto L_0x0811
        L_0x0724:
            boolean r42 = r77.nextBoolean()
            goto L_0x0811
        L_0x072a:
            org.json.JSONObject r27 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            goto L_0x0811
        L_0x0730:
            org.json.JSONObject r26 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            goto L_0x0811
        L_0x0736:
            java.lang.String r41 = r77.nextString()
            goto L_0x0811
        L_0x073c:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            com.google.android.gms.internal.ads.zzbwp r32 = com.google.android.gms.internal.ads.zzbwp.zza(r9)
            goto L_0x0811
        L_0x0746:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            java.lang.String r40 = r9.toString()
            goto L_0x0811
        L_0x0750:
            java.lang.String r39 = r77.nextString()
            goto L_0x0811
        L_0x0756:
            java.lang.String r38 = r77.nextString()
            goto L_0x0811
        L_0x075c:
            org.json.JSONObject r16 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            goto L_0x0811
        L_0x0762:
            java.lang.String r37 = r77.nextString()
            goto L_0x0811
        L_0x0768:
            java.util.List r18 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x076e:
            java.util.List r17 = com.google.android.gms.internal.ads.zzezo.zza(r77)
            goto L_0x0811
        L_0x0774:
            com.google.android.gms.internal.ads.zzezs r9 = new com.google.android.gms.internal.ads.zzezs
            r10 = r77
            r9.<init>(r10)
            r19 = r9
            goto L_0x0811
        L_0x077f:
            r10 = r77
            java.util.List r20 = com.google.android.gms.internal.ads.zzezo.zza(r77)
            goto L_0x0811
        L_0x0787:
            r10 = r77
            int r36 = r77.nextInt()
            goto L_0x0811
        L_0x078f:
            r10 = r77
            java.util.List r21 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x0797:
            r10 = r77
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            r10 = r9
            goto L_0x0813
        L_0x07a0:
            r10 = r77
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            r10 = r24
            goto L_0x00dd
        L_0x07aa:
            r10 = r77
            java.util.List r8 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x07b2:
            r10 = r77
            org.json.JSONArray r9 = com.google.android.gms.ads.internal.util.zzbu.zze(r77)
            com.google.android.gms.internal.ads.zzbvg r15 = com.google.android.gms.internal.ads.zzbvg.zza(r9)
            goto L_0x0811
        L_0x07bd:
            r10 = r77
            java.lang.String r11 = r77.nextString()
            goto L_0x0811
        L_0x07c4:
            r10 = r77
            java.lang.String r12 = r77.nextString()
            goto L_0x0811
        L_0x07cb:
            r10 = r77
            java.util.List r7 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x07d2:
            r10 = r77
            java.util.List r6 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x07d9:
            r10 = r77
            java.util.List r5 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x07e0:
            r10 = r77
            int r9 = r77.nextInt()
            int r14 = zzc(r9)
            goto L_0x0811
        L_0x07eb:
            r10 = r77
            java.util.List r4 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x07f2:
            r10 = r77
            java.util.List r3 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x07f9:
            r10 = r77
            java.util.List r2 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0811
        L_0x0800:
            r10 = r77
            java.lang.String r9 = r77.nextString()
            int r13 = zzb(r9)
            goto L_0x0811
        L_0x080b:
            r10 = r77
            java.util.List r1 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
        L_0x0811:
            r10 = r24
        L_0x0813:
            r9 = r75
            goto L_0x00dd
        L_0x0817:
            r75 = r9
            r24 = r10
            r10 = r77
            r77.endObject()
            r0.zza = r1
            r0.zzb = r13
            r0.zzc = r2
            r0.zzd = r3
            r0.zzg = r4
            r0.zzf = r14
            r0.zzh = r5
            r0.zzi = r6
            r0.zzj = r7
            r0.zzk = r12
            r0.zzl = r11
            r0.zzm = r15
            r0.zzn = r8
            r0.zzo = r9
            r9 = r24
            r0.zzp = r9
            r11 = r21
            r0.zzq = r11
            r1 = r36
            r0.zzr = r1
            r12 = r20
            r0.zzs = r12
            r9 = r19
            r0.zzt = r9
            r13 = r18
            r0.zzu = r13
            r14 = r17
            r0.zzv = r14
            r1 = r37
            r0.zzx = r1
            r15 = r16
            r0.zzw = r15
            r1 = r38
            r0.zzy = r1
            r1 = r39
            r0.zzz = r1
            r1 = r40
            r0.zzA = r1
            r1 = r32
            r0.zzB = r1
            r1 = r41
            r0.zzC = r1
            r1 = r26
            r0.zzD = r1
            r1 = r27
            r0.zzE = r1
            r1 = r42
            r0.zzK = r1
            r1 = r43
            r0.zzL = r1
            r1 = r44
            r0.zzM = r1
            r1 = r45
            r0.zzN = r1
            r1 = r46
            r0.zzO = r1
            r1 = r47
            r0.zzP = r1
            r1 = r48
            r0.zzQ = r1
            r1 = r49
            r0.zzR = r1
            r1 = r50
            r0.zzS = r1
            r1 = r51
            r0.zzU = r1
            r1 = r52
            r0.zzV = r1
            com.google.android.gms.internal.ads.zzfal r1 = new com.google.android.gms.internal.ads.zzfal
            r2 = r28
            r1.<init>(r2)
            r0.zzW = r1
            r1 = r53
            r0.zzX = r1
            r1 = r54
            r0.zzY = r1
            r1 = r55
            r0.zzZ = r1
            r1 = r56
            r0.zzaa = r1
            r1 = r57
            r0.zzab = r1
            r1 = r58
            r0.zzac = r1
            r1 = r59
            r0.zzad = r1
            r1 = r33
            r0.zzae = r1
            r1 = r34
            r0.zzaf = r1
            r1 = r60
            r0.zzag = r1
            r1 = r61
            r0.zzah = r1
            r1 = r29
            r0.zzai = r1
            r1 = r62
            r0.zzF = r1
            r1 = r63
            r0.zzG = r1
            r1 = r64
            r0.zzH = r1
            r1 = r65
            r0.zzI = r1
            r1 = r66
            r0.zzJ = r1
            r1 = r67
            r0.zzaj = r1
            r1 = r30
            r0.zzak = r1
            r1 = r68
            r0.zzal = r1
            r1 = r35
            r0.zzam = r1
            r1 = r69
            r0.zzan = r1
            r1 = r31
            r0.zze = r1
            r1 = r70
            r0.zzT = r1
            r1 = r71
            r0.zzao = r1
            r1 = r72
            r0.zzap = r1
            r1 = r73
            r0.zzaq = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzezn.<init>(android.util.JsonReader):void");
    }

    public static String zza(int i2) {
        switch (i2) {
            case 1:
                return AdPreferences.TYPE_BANNER;
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzb(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if (Constants.PLACEMENT_TYPE_INTERSTITIAL.equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if ("native".equals(str)) {
            return 4;
        }
        if (Constants.PLACEMENT_TYPE_REWARDED.equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        if ("rewarded_interstitial".equals(str)) {
            return 7;
        }
        return 0;
    }

    private static int zzc(int i2) {
        if (i2 == 0 || i2 == 1) {
            return i2;
        }
        return 0;
    }

    private static final int zzd(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            return 7;
        }
        return -1;
    }
}
