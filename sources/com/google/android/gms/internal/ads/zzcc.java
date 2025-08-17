package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzcc {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayList zzb = new ArrayList();
    private static final Pattern zzc = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(java.lang.String r7, java.lang.String r8) {
        /*
            int r0 = r7.hashCode()
            r1 = 7
            r2 = 9
            r3 = 5
            r4 = 6
            r5 = 8
            r6 = 0
            switch(r0) {
                case -2123537834: goto L_0x0085;
                case -1365340241: goto L_0x007a;
                case -1095064472: goto L_0x0070;
                case -53558318: goto L_0x0066;
                case 187078296: goto L_0x005c;
                case 187078297: goto L_0x0052;
                case 550520934: goto L_0x0047;
                case 1504578661: goto L_0x003d;
                case 1504831518: goto L_0x0033;
                case 1504891608: goto L_0x0028;
                case 1505942594: goto L_0x001d;
                case 1556697186: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x008f
        L_0x0011:
            java.lang.String r0 = "audio/true-hd"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 10
            goto L_0x0090
        L_0x001d:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 7
            goto L_0x0090
        L_0x0028:
            java.lang.String r0 = "audio/opus"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 11
            goto L_0x0090
        L_0x0033:
            java.lang.String r0 = "audio/mpeg"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 0
            goto L_0x0090
        L_0x003d:
            java.lang.String r0 = "audio/eac3"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 3
            goto L_0x0090
        L_0x0047:
            java.lang.String r0 = "audio/vnd.dts.uhd;profile=p2"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 9
            goto L_0x0090
        L_0x0052:
            java.lang.String r0 = "audio/ac4"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 5
            goto L_0x0090
        L_0x005c:
            java.lang.String r0 = "audio/ac3"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 2
            goto L_0x0090
        L_0x0066:
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 1
            goto L_0x0090
        L_0x0070:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 6
            goto L_0x0090
        L_0x007a:
            java.lang.String r0 = "audio/vnd.dts.hd;profile=lbr"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 8
            goto L_0x0090
        L_0x0085:
            java.lang.String r0 = "audio/eac3-joc"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008f
            r7 = 4
            goto L_0x0090
        L_0x008f:
            r7 = -1
        L_0x0090:
            switch(r7) {
                case 0: goto L_0x00b6;
                case 1: goto L_0x00a7;
                case 2: goto L_0x00a6;
                case 3: goto L_0x00a5;
                case 4: goto L_0x00a2;
                case 5: goto L_0x009f;
                case 6: goto L_0x009e;
                case 7: goto L_0x009d;
                case 8: goto L_0x009d;
                case 9: goto L_0x009a;
                case 10: goto L_0x0097;
                case 11: goto L_0x0094;
                default: goto L_0x0093;
            }
        L_0x0093:
            return r6
        L_0x0094:
            r7 = 20
            return r7
        L_0x0097:
            r7 = 14
            return r7
        L_0x009a:
            r7 = 30
            return r7
        L_0x009d:
            return r5
        L_0x009e:
            return r1
        L_0x009f:
            r7 = 17
            return r7
        L_0x00a2:
            r7 = 18
            return r7
        L_0x00a5:
            return r4
        L_0x00a6:
            return r3
        L_0x00a7:
            if (r8 != 0) goto L_0x00aa
            return r6
        L_0x00aa:
            com.google.android.gms.internal.ads.zzcb r7 = zzc(r8)
            if (r7 != 0) goto L_0x00b1
            return r6
        L_0x00b1:
            int r7 = r7.zza()
            return r7
        L_0x00b6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcc.zza(java.lang.String, java.lang.String):int");
    }

    public static int zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zzf(str)) {
            return 1;
        }
        if (zzg(str)) {
            return 2;
        }
        if ("text".equals(zzh(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if ("image".equals(zzh(str))) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        int size = zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = ((zzca) zzb.get(i2)).zza;
            if (str.equals((Object) null)) {
                return 0;
            }
        }
        return -1;
    }

    static zzcb zzc(String str) {
        int i2;
        Matcher matcher = zzc.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        group.getClass();
        String group2 = matcher.group(2);
        try {
            int parseInt = Integer.parseInt(group, 16);
            if (group2 != null) {
                i2 = Integer.parseInt(group2);
            } else {
                i2 = 0;
            }
            return new zzcb(parseInt, i2);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String zzd(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return MimeTypes.VIDEO_H264;
        }
        if (i2 == 35) {
            return MimeTypes.VIDEO_H265;
        }
        if (i2 == 64) {
            return "audio/mp4a-latm";
        }
        if (i2 == 163) {
            return "video/wvc1";
        }
        if (i2 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i2 == 165) {
            return "audio/ac3";
        }
        if (i2 == 166) {
            return "audio/eac3";
        }
        switch (i2) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i2) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zze(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r3.hashCode()
            r2 = 1
            switch(r1) {
                case -2123537834: goto L_0x0075;
                case -432837260: goto L_0x006b;
                case -432837259: goto L_0x0061;
                case -53558318: goto L_0x0056;
                case 187078296: goto L_0x004c;
                case 187094639: goto L_0x0042;
                case 1504578661: goto L_0x0037;
                case 1504619009: goto L_0x002d;
                case 1504831518: goto L_0x0023;
                case 1903231877: goto L_0x0019;
                case 1903589369: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0080
        L_0x000e:
            java.lang.String r1 = "audio/g711-mlaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 5
            goto L_0x0081
        L_0x0019:
            java.lang.String r1 = "audio/g711-alaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 4
            goto L_0x0081
        L_0x0023:
            java.lang.String r1 = "audio/mpeg"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 0
            goto L_0x0081
        L_0x002d:
            java.lang.String r1 = "audio/flac"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 6
            goto L_0x0081
        L_0x0037:
            java.lang.String r1 = "audio/eac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 8
            goto L_0x0081
        L_0x0042:
            java.lang.String r1 = "audio/raw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 3
            goto L_0x0081
        L_0x004c:
            java.lang.String r1 = "audio/ac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 7
            goto L_0x0081
        L_0x0056:
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 10
            goto L_0x0081
        L_0x0061:
            java.lang.String r1 = "audio/mpeg-L2"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 2
            goto L_0x0081
        L_0x006b:
            java.lang.String r1 = "audio/mpeg-L1"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 1
            goto L_0x0081
        L_0x0075:
            java.lang.String r1 = "audio/eac3-joc"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            r3 = 9
            goto L_0x0081
        L_0x0080:
            r3 = -1
        L_0x0081:
            switch(r3) {
                case 0: goto L_0x009b;
                case 1: goto L_0x009b;
                case 2: goto L_0x009b;
                case 3: goto L_0x009b;
                case 4: goto L_0x009b;
                case 5: goto L_0x009b;
                case 6: goto L_0x009b;
                case 7: goto L_0x009b;
                case 8: goto L_0x009b;
                case 9: goto L_0x009b;
                case 10: goto L_0x0085;
                default: goto L_0x0084;
            }
        L_0x0084:
            return r0
        L_0x0085:
            if (r4 != 0) goto L_0x0088
            return r0
        L_0x0088:
            com.google.android.gms.internal.ads.zzcb r3 = zzc(r4)
            if (r3 != 0) goto L_0x008f
            return r0
        L_0x008f:
            int r3 = r3.zza()
            if (r3 == 0) goto L_0x009a
            r4 = 16
            if (r3 == r4) goto L_0x009a
            return r2
        L_0x009a:
            return r0
        L_0x009b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcc.zze(java.lang.String, java.lang.String):boolean");
    }

    public static boolean zzf(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(zzh(str));
    }

    public static boolean zzg(String str) {
        return MimeTypes.BASE_TYPE_VIDEO.equals(zzh(str));
    }

    private static String zzh(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }
}
