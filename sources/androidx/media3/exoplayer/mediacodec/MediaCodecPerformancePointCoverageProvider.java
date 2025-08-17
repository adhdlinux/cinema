package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import com.unity3d.services.core.device.MimeTypes;
import java.util.List;

final class MediaCodecPerformancePointCoverageProvider {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f6698a;

    private static final class Api29 {
        private Api29() {
        }

        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
            List a2 = videoCapabilities.getSupportedPerformancePoints();
            if (a2 == null || a2.isEmpty()) {
                return 0;
            }
            int b2 = b(a2, new MediaCodecInfo.VideoCapabilities.PerformancePoint(i2, i3, (int) d2));
            if (b2 == 1 && MediaCodecPerformancePointCoverageProvider.f6698a == null) {
                Boolean unused = MediaCodecPerformancePointCoverageProvider.f6698a = Boolean.valueOf(c());
                if (MediaCodecPerformancePointCoverageProvider.f6698a.booleanValue()) {
                    return 0;
                }
            }
            return b2;
        }

        private static int b(List<MediaCodecInfo.VideoCapabilities.PerformancePoint> list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }

        private static boolean c() {
            List a2;
            if (Util.f4714a >= 35) {
                return false;
            }
            try {
                Format K = new Format.Builder().o0(MimeTypes.VIDEO_H264).K();
                if (K.f4015n != null) {
                    List<MediaCodecInfo> v2 = MediaCodecUtil.v(MediaCodecSelector.f6742a, K, false, false);
                    int i2 = 0;
                    while (i2 < v2.size()) {
                        if (v2.get(i2).f6690d == null || v2.get(i2).f6690d.getVideoCapabilities() == null || (a2 = v2.get(i2).f6690d.getVideoCapabilities().getSupportedPerformancePoints()) == null || a2.isEmpty()) {
                            i2++;
                        } else if (b(a2, new MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60)) == 1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            } catch (MediaCodecUtil.DecoderQueryException unused) {
            }
            return true;
        }
    }

    private MediaCodecPerformancePointCoverageProvider() {
    }

    public static int c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        if (Util.f4714a < 29) {
            return 0;
        }
        Boolean bool = f6698a;
        if (bool == null || !bool.booleanValue()) {
            return Api29.a(videoCapabilities, i2, i3, d2);
        }
        return 0;
    }
}
