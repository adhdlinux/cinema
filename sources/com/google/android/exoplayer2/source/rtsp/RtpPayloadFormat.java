package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableMap;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Map;

public final class RtpPayloadFormat {

    /* renamed from: a  reason: collision with root package name */
    public final int f26785a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26786b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f26787c;

    /* renamed from: d  reason: collision with root package name */
    public final ImmutableMap<String, String> f26788d;

    /* renamed from: e  reason: collision with root package name */
    public final String f26789e;

    public RtpPayloadFormat(Format format, int i2, int i3, Map<String, String> map, String str) {
        this.f26785a = i2;
        this.f26786b = i3;
        this.f26787c = format;
        this.f26788d = ImmutableMap.d(map);
        this.f26789e = str;
    }

    public static String a(String str) {
        String f2 = Ascii.f(str);
        f2.hashCode();
        char c2 = 65535;
        switch (f2.hashCode()) {
            case -1922091719:
                if (f2.equals("MPEG4-GENERIC")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2412:
                if (f2.equals("L8")) {
                    c2 = 1;
                    break;
                }
                break;
            case 64593:
                if (f2.equals("AC3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 64934:
                if (f2.equals("AMR")) {
                    c2 = 3;
                    break;
                }
                break;
            case 74609:
                if (f2.equals("L16")) {
                    c2 = 4;
                    break;
                }
                break;
            case 85182:
                if (f2.equals("VP8")) {
                    c2 = 5;
                    break;
                }
                break;
            case 85183:
                if (f2.equals("VP9")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2194728:
                if (f2.equals("H264")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2194729:
                if (f2.equals("H265")) {
                    c2 = 8;
                    break;
                }
                break;
            case 2433087:
                if (f2.equals("OPUS")) {
                    c2 = 9;
                    break;
                }
                break;
            case 2450119:
                if (f2.equals("PCMA")) {
                    c2 = 10;
                    break;
                }
                break;
            case 2450139:
                if (f2.equals("PCMU")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1061166827:
                if (f2.equals("MP4A-LATM")) {
                    c2 = 12;
                    break;
                }
                break;
            case 1934494802:
                if (f2.equals("AMR-WB")) {
                    c2 = 13;
                    break;
                }
                break;
            case 1959269366:
                if (f2.equals("MP4V-ES")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2137188397:
                if (f2.equals("H263-1998")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2137209252:
                if (f2.equals("H263-2000")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 12:
                return "audio/mp4a-latm";
            case 1:
            case 4:
                return "audio/raw";
            case 2:
                return "audio/ac3";
            case 3:
                return "audio/3gpp";
            case 5:
                return "video/x-vnd.on2.vp8";
            case 6:
                return "video/x-vnd.on2.vp9";
            case 7:
                return MimeTypes.VIDEO_H264;
            case 8:
                return MimeTypes.VIDEO_H265;
            case 9:
                return "audio/opus";
            case 10:
                return "audio/g711-alaw";
            case 11:
                return "audio/g711-mlaw";
            case 13:
                return "audio/amr-wb";
            case 14:
                return "video/mp4v-es";
            case 15:
            case 16:
                return "video/3gpp";
            default:
                throw new IllegalArgumentException(str);
        }
    }

    public static int b(String str) {
        boolean z2;
        if (str.equals("L8") || str.equals("L16")) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (str.equals("L8")) {
            return 3;
        }
        return 268435456;
    }

    static boolean c(MediaDescription mediaDescription) {
        String f2 = Ascii.f(mediaDescription.f26722j.f26733b);
        f2.hashCode();
        char c2 = 65535;
        switch (f2.hashCode()) {
            case -1922091719:
                if (f2.equals("MPEG4-GENERIC")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2412:
                if (f2.equals("L8")) {
                    c2 = 1;
                    break;
                }
                break;
            case 64593:
                if (f2.equals("AC3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 64934:
                if (f2.equals("AMR")) {
                    c2 = 3;
                    break;
                }
                break;
            case 74609:
                if (f2.equals("L16")) {
                    c2 = 4;
                    break;
                }
                break;
            case 85182:
                if (f2.equals("VP8")) {
                    c2 = 5;
                    break;
                }
                break;
            case 85183:
                if (f2.equals("VP9")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2194728:
                if (f2.equals("H264")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2194729:
                if (f2.equals("H265")) {
                    c2 = 8;
                    break;
                }
                break;
            case 2433087:
                if (f2.equals("OPUS")) {
                    c2 = 9;
                    break;
                }
                break;
            case 2450119:
                if (f2.equals("PCMA")) {
                    c2 = 10;
                    break;
                }
                break;
            case 2450139:
                if (f2.equals("PCMU")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1061166827:
                if (f2.equals("MP4A-LATM")) {
                    c2 = 12;
                    break;
                }
                break;
            case 1934494802:
                if (f2.equals("AMR-WB")) {
                    c2 = 13;
                    break;
                }
                break;
            case 1959269366:
                if (f2.equals("MP4V-ES")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2137188397:
                if (f2.equals("H263-1998")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2137209252:
                if (f2.equals("H263-2000")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RtpPayloadFormat.class != obj.getClass()) {
            return false;
        }
        RtpPayloadFormat rtpPayloadFormat = (RtpPayloadFormat) obj;
        if (this.f26785a != rtpPayloadFormat.f26785a || this.f26786b != rtpPayloadFormat.f26786b || !this.f26787c.equals(rtpPayloadFormat.f26787c) || !this.f26788d.equals(rtpPayloadFormat.f26788d) || !this.f26789e.equals(rtpPayloadFormat.f26789e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((217 + this.f26785a) * 31) + this.f26786b) * 31) + this.f26787c.hashCode()) * 31) + this.f26788d.hashCode()) * 31) + this.f26789e.hashCode();
    }
}
