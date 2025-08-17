package androidx.media3.common;

import android.net.Uri;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.List;
import java.util.Map;

public final class FileTypes {
    private FileTypes() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r24) {
        /*
            r0 = -1
            if (r24 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = androidx.media3.common.MimeTypes.t(r24)
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = 21
            r4 = 20
            r5 = 19
            r6 = 18
            r7 = 17
            r8 = 16
            r9 = 15
            r10 = 14
            r11 = 13
            r12 = 12
            r13 = 11
            r14 = 10
            r15 = 9
            r16 = 8
            r17 = 7
            r18 = 6
            r19 = 5
            r20 = 4
            r21 = 3
            r22 = 1
            r23 = 0
            switch(r2) {
                case -2123537834: goto L_0x01da;
                case -1662384011: goto L_0x01ce;
                case -1662384007: goto L_0x01c2;
                case -1662095187: goto L_0x01b6;
                case -1606874997: goto L_0x01aa;
                case -1487656890: goto L_0x019e;
                case -1487464693: goto L_0x0192;
                case -1487464690: goto L_0x0186;
                case -1487394660: goto L_0x0178;
                case -1487018032: goto L_0x016a;
                case -1248337486: goto L_0x015c;
                case -1079884372: goto L_0x014e;
                case -1004728940: goto L_0x0140;
                case -879272239: goto L_0x0132;
                case -879258763: goto L_0x0124;
                case -387023398: goto L_0x0116;
                case -43467528: goto L_0x0108;
                case 13915911: goto L_0x00fa;
                case 187078296: goto L_0x00ec;
                case 187078297: goto L_0x00de;
                case 187078669: goto L_0x00d0;
                case 187090232: goto L_0x00c2;
                case 187091926: goto L_0x00b4;
                case 187099443: goto L_0x00a7;
                case 1331848029: goto L_0x009a;
                case 1503095341: goto L_0x008d;
                case 1504578661: goto L_0x0080;
                case 1504619009: goto L_0x0073;
                case 1504824762: goto L_0x0066;
                case 1504831518: goto L_0x0059;
                case 1505118770: goto L_0x004c;
                case 2039520277: goto L_0x003f;
                default: goto L_0x003c;
            }
        L_0x003c:
            r1 = -1
            goto L_0x01e5
        L_0x003f:
            java.lang.String r2 = "video/x-matroska"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0048
            goto L_0x003c
        L_0x0048:
            r1 = 31
            goto L_0x01e5
        L_0x004c:
            java.lang.String r2 = "audio/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0055
            goto L_0x003c
        L_0x0055:
            r1 = 30
            goto L_0x01e5
        L_0x0059:
            java.lang.String r2 = "audio/mpeg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0062
            goto L_0x003c
        L_0x0062:
            r1 = 29
            goto L_0x01e5
        L_0x0066:
            java.lang.String r2 = "audio/midi"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x006f
            goto L_0x003c
        L_0x006f:
            r1 = 28
            goto L_0x01e5
        L_0x0073:
            java.lang.String r2 = "audio/flac"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x007c
            goto L_0x003c
        L_0x007c:
            r1 = 27
            goto L_0x01e5
        L_0x0080:
            java.lang.String r2 = "audio/eac3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0089
            goto L_0x003c
        L_0x0089:
            r1 = 26
            goto L_0x01e5
        L_0x008d:
            java.lang.String r2 = "audio/3gpp"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0096
            goto L_0x003c
        L_0x0096:
            r1 = 25
            goto L_0x01e5
        L_0x009a:
            java.lang.String r2 = "video/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00a3
            goto L_0x003c
        L_0x00a3:
            r1 = 24
            goto L_0x01e5
        L_0x00a7:
            java.lang.String r2 = "audio/wav"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00b0
            goto L_0x003c
        L_0x00b0:
            r1 = 23
            goto L_0x01e5
        L_0x00b4:
            java.lang.String r2 = "audio/ogg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00be
            goto L_0x003c
        L_0x00be:
            r1 = 22
            goto L_0x01e5
        L_0x00c2:
            java.lang.String r2 = "audio/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00cc
            goto L_0x003c
        L_0x00cc:
            r1 = 21
            goto L_0x01e5
        L_0x00d0:
            java.lang.String r2 = "audio/amr"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00da
            goto L_0x003c
        L_0x00da:
            r1 = 20
            goto L_0x01e5
        L_0x00de:
            java.lang.String r2 = "audio/ac4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00e8
            goto L_0x003c
        L_0x00e8:
            r1 = 19
            goto L_0x01e5
        L_0x00ec:
            java.lang.String r2 = "audio/ac3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00f6
            goto L_0x003c
        L_0x00f6:
            r1 = 18
            goto L_0x01e5
        L_0x00fa:
            java.lang.String r2 = "video/x-flv"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0104
            goto L_0x003c
        L_0x0104:
            r1 = 17
            goto L_0x01e5
        L_0x0108:
            java.lang.String r2 = "application/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0112
            goto L_0x003c
        L_0x0112:
            r1 = 16
            goto L_0x01e5
        L_0x0116:
            java.lang.String r2 = "audio/x-matroska"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0120
            goto L_0x003c
        L_0x0120:
            r1 = 15
            goto L_0x01e5
        L_0x0124:
            java.lang.String r2 = "image/png"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x012e
            goto L_0x003c
        L_0x012e:
            r1 = 14
            goto L_0x01e5
        L_0x0132:
            java.lang.String r2 = "image/bmp"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x013c
            goto L_0x003c
        L_0x013c:
            r1 = 13
            goto L_0x01e5
        L_0x0140:
            java.lang.String r2 = "text/vtt"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x014a
            goto L_0x003c
        L_0x014a:
            r1 = 12
            goto L_0x01e5
        L_0x014e:
            java.lang.String r2 = "video/x-msvideo"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0158
            goto L_0x003c
        L_0x0158:
            r1 = 11
            goto L_0x01e5
        L_0x015c:
            java.lang.String r2 = "application/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0166
            goto L_0x003c
        L_0x0166:
            r1 = 10
            goto L_0x01e5
        L_0x016a:
            java.lang.String r2 = "image/webp"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0174
            goto L_0x003c
        L_0x0174:
            r1 = 9
            goto L_0x01e5
        L_0x0178:
            java.lang.String r2 = "image/jpeg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0182
            goto L_0x003c
        L_0x0182:
            r1 = 8
            goto L_0x01e5
        L_0x0186:
            java.lang.String r2 = "image/heif"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0190
            goto L_0x003c
        L_0x0190:
            r1 = 7
            goto L_0x01e5
        L_0x0192:
            java.lang.String r2 = "image/heic"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x019c
            goto L_0x003c
        L_0x019c:
            r1 = 6
            goto L_0x01e5
        L_0x019e:
            java.lang.String r2 = "image/avif"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01a8
            goto L_0x003c
        L_0x01a8:
            r1 = 5
            goto L_0x01e5
        L_0x01aa:
            java.lang.String r2 = "audio/amr-wb"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01b4
            goto L_0x003c
        L_0x01b4:
            r1 = 4
            goto L_0x01e5
        L_0x01b6:
            java.lang.String r2 = "video/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01c0
            goto L_0x003c
        L_0x01c0:
            r1 = 3
            goto L_0x01e5
        L_0x01c2:
            java.lang.String r2 = "video/mp2t"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01cc
            goto L_0x003c
        L_0x01cc:
            r1 = 2
            goto L_0x01e5
        L_0x01ce:
            java.lang.String r2 = "video/mp2p"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01d8
            goto L_0x003c
        L_0x01d8:
            r1 = 1
            goto L_0x01e5
        L_0x01da:
            java.lang.String r2 = "audio/eac3-joc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01e4
            goto L_0x003c
        L_0x01e4:
            r1 = 0
        L_0x01e5:
            switch(r1) {
                case 0: goto L_0x01fd;
                case 1: goto L_0x01fc;
                case 2: goto L_0x01fb;
                case 3: goto L_0x01fa;
                case 4: goto L_0x01f9;
                case 5: goto L_0x01f8;
                case 6: goto L_0x01f7;
                case 7: goto L_0x01f7;
                case 8: goto L_0x01f6;
                case 9: goto L_0x01f5;
                case 10: goto L_0x01f4;
                case 11: goto L_0x01f3;
                case 12: goto L_0x01f2;
                case 13: goto L_0x01f1;
                case 14: goto L_0x01f0;
                case 15: goto L_0x01fa;
                case 16: goto L_0x01fa;
                case 17: goto L_0x01ef;
                case 18: goto L_0x01fd;
                case 19: goto L_0x01ee;
                case 20: goto L_0x01f9;
                case 21: goto L_0x01f4;
                case 22: goto L_0x01ed;
                case 23: goto L_0x01ec;
                case 24: goto L_0x01f4;
                case 25: goto L_0x01f9;
                case 26: goto L_0x01fd;
                case 27: goto L_0x01eb;
                case 28: goto L_0x01ea;
                case 29: goto L_0x01e9;
                case 30: goto L_0x01fa;
                case 31: goto L_0x01fa;
                default: goto L_0x01e8;
            }
        L_0x01e8:
            return r0
        L_0x01e9:
            return r17
        L_0x01ea:
            return r9
        L_0x01eb:
            return r20
        L_0x01ec:
            return r12
        L_0x01ed:
            return r15
        L_0x01ee:
            return r22
        L_0x01ef:
            return r19
        L_0x01f0:
            return r7
        L_0x01f1:
            return r5
        L_0x01f2:
            return r11
        L_0x01f3:
            return r8
        L_0x01f4:
            return r16
        L_0x01f5:
            return r6
        L_0x01f6:
            return r10
        L_0x01f7:
            return r4
        L_0x01f8:
            return r3
        L_0x01f9:
            return r21
        L_0x01fa:
            return r18
        L_0x01fb:
            return r13
        L_0x01fc:
            return r14
        L_0x01fd:
            return r23
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.FileTypes.a(java.lang.String):int");
    }

    public static int b(Map<String, List<String>> map) {
        String str;
        List list = map.get(TraktV2.HEADER_CONTENT_TYPE);
        if (list == null || list.isEmpty()) {
            str = null;
        } else {
            str = (String) list.get(0);
        }
        return a(str);
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        if (lastPathSegment.endsWith(".png")) {
            return 17;
        }
        if (lastPathSegment.endsWith(".webp")) {
            return 18;
        }
        if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            return 19;
        }
        if (lastPathSegment.endsWith(".heic") || lastPathSegment.endsWith(".heif")) {
            return 20;
        }
        if (lastPathSegment.endsWith(".avif")) {
            return 21;
        }
        return -1;
    }
}
