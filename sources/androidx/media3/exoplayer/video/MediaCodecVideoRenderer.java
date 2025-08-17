package androidx.media3.exoplayer.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.VideoSink;
import com.applovin.mediation.MaxErrorCode;
import com.facebook.common.time.Clock;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.nio.ByteBuffer;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.joda.time.DateTimeConstants;

public class MediaCodecVideoRenderer extends MediaCodecRenderer implements VideoFrameReleaseControl.FrameTimingEvaluator {
    private static final int[] w1 = {1920, 1600, DateTimeConstants.MINUTES_PER_DAY, 1280, 960, 854, 640, 540, 480};
    private static boolean x1;
    private static boolean y1;
    private final Context P0;
    private final VideoSinkProvider Q0;
    private final boolean R0;
    private final VideoRendererEventListener.EventDispatcher S0;
    private final int T0;
    private final boolean U0;
    private final VideoFrameReleaseControl V0;
    private final VideoFrameReleaseControl.FrameReleaseInfo W0;
    private CodecMaxValues X0;
    private boolean Y0;
    private boolean Z0;

    /* renamed from: a1  reason: collision with root package name */
    private VideoSink f7656a1;

    /* renamed from: b1  reason: collision with root package name */
    private boolean f7657b1;

    /* renamed from: c1  reason: collision with root package name */
    private List<Effect> f7658c1;
    /* access modifiers changed from: private */

    /* renamed from: d1  reason: collision with root package name */
    public Surface f7659d1;

    /* renamed from: e1  reason: collision with root package name */
    private PlaceholderSurface f7660e1;

    /* renamed from: f1  reason: collision with root package name */
    private Size f7661f1;

    /* renamed from: g1  reason: collision with root package name */
    private boolean f7662g1;

    /* renamed from: h1  reason: collision with root package name */
    private int f7663h1;

    /* renamed from: i1  reason: collision with root package name */
    private long f7664i1;

    /* renamed from: j1  reason: collision with root package name */
    private int f7665j1;

    /* renamed from: k1  reason: collision with root package name */
    private int f7666k1;

    /* renamed from: l1  reason: collision with root package name */
    private int f7667l1;

    /* renamed from: m1  reason: collision with root package name */
    private long f7668m1;

    /* renamed from: n1  reason: collision with root package name */
    private int f7669n1;

    /* renamed from: o1  reason: collision with root package name */
    private long f7670o1;

    /* renamed from: p1  reason: collision with root package name */
    private VideoSize f7671p1;

    /* renamed from: q1  reason: collision with root package name */
    private VideoSize f7672q1;

    /* renamed from: r1  reason: collision with root package name */
    private int f7673r1;

    /* renamed from: s1  reason: collision with root package name */
    private boolean f7674s1;
    private int t1;
    OnFrameRenderedListenerV23 u1;
    private VideoFrameMetadataListener v1;

    private static final class Api26 {
        private Api26() {
        }

        public static boolean a(Context context) {
            Display display;
            DisplayManager displayManager = (DisplayManager) context.getSystemService(ViewProps.DISPLAY);
            if (displayManager != null) {
                display = displayManager.getDisplay(0);
            } else {
                display = null;
            }
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i2 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i2 == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    protected static final class CodecMaxValues {

        /* renamed from: a  reason: collision with root package name */
        public final int f7676a;

        /* renamed from: b  reason: collision with root package name */
        public final int f7677b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7678c;

        public CodecMaxValues(int i2, int i3, int i4) {
            this.f7676a = i2;
            this.f7677b = i3;
            this.f7678c = i4;
        }
    }

    private final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f7679b;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler B = Util.B(this);
            this.f7679b = B;
            mediaCodecAdapter.o(this, B);
        }

        private void b(long j2) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this == mediaCodecVideoRenderer.u1 && mediaCodecVideoRenderer.A0() != null) {
                if (j2 == Clock.MAX_TIME) {
                    MediaCodecVideoRenderer.this.r2();
                    return;
                }
                try {
                    MediaCodecVideoRenderer.this.q2(j2);
                } catch (ExoPlaybackException e2) {
                    MediaCodecVideoRenderer.this.A1(e2);
                }
            }
        }

        public void a(MediaCodecAdapter mediaCodecAdapter, long j2, long j3) {
            if (Util.f4714a < 30) {
                this.f7679b.sendMessageAtFrontOfQueue(Message.obtain(this.f7679b, 0, (int) (j2 >> 32), (int) j2));
                return;
            }
            b(j2);
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(Util.q1(message.arg1, message.arg2));
            return true;
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j2, boolean z2, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2) {
        this(context, factory, mediaCodecSelector, j2, z2, handler, videoRendererEventListener, i2, 30.0f);
    }

    private boolean F2(MediaCodecInfo mediaCodecInfo) {
        if (Util.f4714a < 23 || this.f7674s1 || R1(mediaCodecInfo.f6687a) || (mediaCodecInfo.f6693g && !PlaceholderSurface.c(this.P0))) {
            return false;
        }
        return true;
    }

    private void H2() {
        MediaCodecAdapter A0 = A0();
        if (A0 != null && Util.f4714a >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.f7673r1));
            A0.b(bundle);
        }
    }

    private static boolean Q1() {
        return Util.f4714a >= 21;
    }

    private static void S1(MediaFormat mediaFormat, int i2) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i2);
    }

    private static boolean T1() {
        return "NVIDIA".equals(Util.f4716c);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x0848, code lost:
        if (r0.equals("PGN528") == false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x08ae, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean V1() {
        /*
            int r0 = androidx.media3.common.util.Util.f4714a
            r1 = 7
            r2 = 6
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = -1
            r8 = 0
            r9 = 1
            r10 = 28
            if (r0 > r10) goto L_0x007a
            java.lang.String r11 = androidx.media3.common.util.Util.f4715b
            r11.hashCode()
            int r12 = r11.hashCode()
            switch(r12) {
                case -1339091551: goto L_0x006b;
                case -1220081023: goto L_0x0060;
                case -1220066608: goto L_0x0055;
                case -1012436106: goto L_0x004a;
                case -760312546: goto L_0x003f;
                case -64886864: goto L_0x0034;
                case 3415681: goto L_0x0029;
                case 825323514: goto L_0x001e;
                default: goto L_0x001b;
            }
        L_0x001b:
            r11 = -1
            goto L_0x0075
        L_0x001e:
            java.lang.String r12 = "machuca"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0027
            goto L_0x001b
        L_0x0027:
            r11 = 7
            goto L_0x0075
        L_0x0029:
            java.lang.String r12 = "once"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0032
            goto L_0x001b
        L_0x0032:
            r11 = 6
            goto L_0x0075
        L_0x0034:
            java.lang.String r12 = "magnolia"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x003d
            goto L_0x001b
        L_0x003d:
            r11 = 5
            goto L_0x0075
        L_0x003f:
            java.lang.String r12 = "aquaman"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0048
            goto L_0x001b
        L_0x0048:
            r11 = 4
            goto L_0x0075
        L_0x004a:
            java.lang.String r12 = "oneday"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0053
            goto L_0x001b
        L_0x0053:
            r11 = 3
            goto L_0x0075
        L_0x0055:
            java.lang.String r12 = "dangalUHD"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x005e
            goto L_0x001b
        L_0x005e:
            r11 = 2
            goto L_0x0075
        L_0x0060:
            java.lang.String r12 = "dangalFHD"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0069
            goto L_0x001b
        L_0x0069:
            r11 = 1
            goto L_0x0075
        L_0x006b:
            java.lang.String r12 = "dangal"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0074
            goto L_0x001b
        L_0x0074:
            r11 = 0
        L_0x0075:
            switch(r11) {
                case 0: goto L_0x0079;
                case 1: goto L_0x0079;
                case 2: goto L_0x0079;
                case 3: goto L_0x0079;
                case 4: goto L_0x0079;
                case 5: goto L_0x0079;
                case 6: goto L_0x0079;
                case 7: goto L_0x0079;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x007a
        L_0x0079:
            return r9
        L_0x007a:
            r11 = 27
            if (r0 > r11) goto L_0x0089
            java.lang.String r12 = "HWEML"
            java.lang.String r13 = androidx.media3.common.util.Util.f4715b
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x0089
            return r9
        L_0x0089:
            java.lang.String r12 = androidx.media3.common.util.Util.f4717d
            r12.hashCode()
            int r13 = r12.hashCode()
            r14 = 8
            switch(r13) {
                case -349662828: goto L_0x00f4;
                case -321033677: goto L_0x00e9;
                case 2006354: goto L_0x00de;
                case 2006367: goto L_0x00d3;
                case 2006371: goto L_0x00c8;
                case 1785421873: goto L_0x00bd;
                case 1785421876: goto L_0x00b2;
                case 1798172390: goto L_0x00a7;
                case 2119412532: goto L_0x009a;
                default: goto L_0x0097;
            }
        L_0x0097:
            r13 = -1
            goto L_0x00fe
        L_0x009a:
            java.lang.String r13 = "AFTEUFF014"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00a3
            goto L_0x0097
        L_0x00a3:
            r13 = 8
            goto L_0x00fe
        L_0x00a7:
            java.lang.String r13 = "AFTSO001"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00b0
            goto L_0x0097
        L_0x00b0:
            r13 = 7
            goto L_0x00fe
        L_0x00b2:
            java.lang.String r13 = "AFTEU014"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00bb
            goto L_0x0097
        L_0x00bb:
            r13 = 6
            goto L_0x00fe
        L_0x00bd:
            java.lang.String r13 = "AFTEU011"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00c6
            goto L_0x0097
        L_0x00c6:
            r13 = 5
            goto L_0x00fe
        L_0x00c8:
            java.lang.String r13 = "AFTR"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00d1
            goto L_0x0097
        L_0x00d1:
            r13 = 4
            goto L_0x00fe
        L_0x00d3:
            java.lang.String r13 = "AFTN"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00dc
            goto L_0x0097
        L_0x00dc:
            r13 = 3
            goto L_0x00fe
        L_0x00de:
            java.lang.String r13 = "AFTA"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00e7
            goto L_0x0097
        L_0x00e7:
            r13 = 2
            goto L_0x00fe
        L_0x00e9:
            java.lang.String r13 = "AFTKMST12"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00f2
            goto L_0x0097
        L_0x00f2:
            r13 = 1
            goto L_0x00fe
        L_0x00f4:
            java.lang.String r13 = "AFTJMST12"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00fd
            goto L_0x0097
        L_0x00fd:
            r13 = 0
        L_0x00fe:
            switch(r13) {
                case 0: goto L_0x08b0;
                case 1: goto L_0x08b0;
                case 2: goto L_0x08b0;
                case 3: goto L_0x08b0;
                case 4: goto L_0x08b0;
                case 5: goto L_0x08b0;
                case 6: goto L_0x08b0;
                case 7: goto L_0x08b0;
                case 8: goto L_0x08b0;
                default: goto L_0x0101;
            }
        L_0x0101:
            r13 = 26
            if (r0 > r13) goto L_0x08af
            java.lang.String r0 = androidx.media3.common.util.Util.f4715b
            r0.hashCode()
            int r15 = r0.hashCode()
            switch(r15) {
                case -2144781245: goto L_0x0894;
                case -2144781185: goto L_0x0888;
                case -2144781160: goto L_0x087c;
                case -2097309513: goto L_0x0870;
                case -2022874474: goto L_0x0864;
                case -1978993182: goto L_0x0858;
                case -1978990237: goto L_0x084c;
                case -1936688988: goto L_0x0842;
                case -1936688066: goto L_0x0835;
                case -1936688065: goto L_0x0827;
                case -1931988508: goto L_0x0819;
                case -1885099851: goto L_0x080b;
                case -1696512866: goto L_0x07fd;
                case -1680025915: goto L_0x07ef;
                case -1615810839: goto L_0x07e1;
                case -1600724499: goto L_0x07d3;
                case -1554255044: goto L_0x07c5;
                case -1481772737: goto L_0x07b7;
                case -1481772730: goto L_0x07a9;
                case -1481772729: goto L_0x079b;
                case -1320080169: goto L_0x078d;
                case -1217592143: goto L_0x077f;
                case -1180384755: goto L_0x0771;
                case -1139198265: goto L_0x0763;
                case -1052835013: goto L_0x0755;
                case -993250464: goto L_0x0747;
                case -993250458: goto L_0x0739;
                case -965403638: goto L_0x072b;
                case -958336948: goto L_0x071d;
                case -879245230: goto L_0x070f;
                case -842500323: goto L_0x0701;
                case -821392978: goto L_0x06f3;
                case -797483286: goto L_0x06e5;
                case -794946968: goto L_0x06d7;
                case -788334647: goto L_0x06c9;
                case -782144577: goto L_0x06bb;
                case -575125681: goto L_0x06ad;
                case -521118391: goto L_0x069f;
                case -430914369: goto L_0x0691;
                case -290434366: goto L_0x0683;
                case -282781963: goto L_0x0675;
                case -277133239: goto L_0x0667;
                case -173639913: goto L_0x0659;
                case -56598463: goto L_0x064b;
                case 2126: goto L_0x063d;
                case 2564: goto L_0x062f;
                case 2715: goto L_0x0621;
                case 2719: goto L_0x0613;
                case 3091: goto L_0x0605;
                case 3483: goto L_0x05f7;
                case 73405: goto L_0x05e9;
                case 75537: goto L_0x05db;
                case 75739: goto L_0x05cd;
                case 76779: goto L_0x05bf;
                case 78669: goto L_0x05b1;
                case 79305: goto L_0x05a3;
                case 80618: goto L_0x0595;
                case 88274: goto L_0x0587;
                case 98846: goto L_0x0579;
                case 98848: goto L_0x056b;
                case 99329: goto L_0x055d;
                case 101481: goto L_0x054f;
                case 1513190: goto L_0x0541;
                case 1514184: goto L_0x0533;
                case 1514185: goto L_0x0525;
                case 2133089: goto L_0x0517;
                case 2133091: goto L_0x0509;
                case 2133120: goto L_0x04fb;
                case 2133151: goto L_0x04ed;
                case 2133182: goto L_0x04df;
                case 2133184: goto L_0x04d1;
                case 2436959: goto L_0x04c3;
                case 2463773: goto L_0x04b5;
                case 2464648: goto L_0x04a7;
                case 2689555: goto L_0x0499;
                case 3154429: goto L_0x048b;
                case 3284551: goto L_0x047d;
                case 3351335: goto L_0x046f;
                case 3386211: goto L_0x0461;
                case 41325051: goto L_0x0453;
                case 51349633: goto L_0x0445;
                case 51350594: goto L_0x0437;
                case 55178625: goto L_0x0429;
                case 61542055: goto L_0x041b;
                case 65355429: goto L_0x040d;
                case 66214468: goto L_0x03ff;
                case 66214470: goto L_0x03f1;
                case 66214473: goto L_0x03e3;
                case 66215429: goto L_0x03d5;
                case 66215431: goto L_0x03c7;
                case 66215433: goto L_0x03b9;
                case 66216390: goto L_0x03ab;
                case 76402249: goto L_0x039d;
                case 76404105: goto L_0x038f;
                case 76404911: goto L_0x0381;
                case 80963634: goto L_0x0373;
                case 82882791: goto L_0x0365;
                case 98715550: goto L_0x0357;
                case 101370885: goto L_0x0349;
                case 102844228: goto L_0x033b;
                case 165221241: goto L_0x032d;
                case 182191441: goto L_0x031f;
                case 245388979: goto L_0x0311;
                case 287431619: goto L_0x0303;
                case 307593612: goto L_0x02f5;
                case 308517133: goto L_0x02e7;
                case 316215098: goto L_0x02d9;
                case 316215116: goto L_0x02cb;
                case 316246811: goto L_0x02bd;
                case 316246818: goto L_0x02af;
                case 407160593: goto L_0x02a1;
                case 507412548: goto L_0x0293;
                case 793982701: goto L_0x0285;
                case 794038622: goto L_0x0277;
                case 794040393: goto L_0x0269;
                case 835649806: goto L_0x025b;
                case 917340916: goto L_0x024d;
                case 958008161: goto L_0x023f;
                case 1060579533: goto L_0x0231;
                case 1150207623: goto L_0x0223;
                case 1176899427: goto L_0x0215;
                case 1280332038: goto L_0x0207;
                case 1306947716: goto L_0x01f9;
                case 1349174697: goto L_0x01eb;
                case 1522194893: goto L_0x01dd;
                case 1691543273: goto L_0x01cf;
                case 1691544261: goto L_0x01c1;
                case 1709443163: goto L_0x01b3;
                case 1865889110: goto L_0x01a5;
                case 1906253259: goto L_0x0197;
                case 1977196784: goto L_0x0189;
                case 2006372676: goto L_0x017c;
                case 2019281702: goto L_0x016f;
                case 2029784656: goto L_0x0162;
                case 2030379515: goto L_0x0155;
                case 2033393791: goto L_0x0148;
                case 2047190025: goto L_0x013b;
                case 2047252157: goto L_0x012e;
                case 2048319463: goto L_0x0121;
                case 2048855701: goto L_0x0114;
                default: goto L_0x0111;
            }
        L_0x0111:
            r1 = -1
            goto L_0x089f
        L_0x0114:
            java.lang.String r1 = "HWWAS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x011d
            goto L_0x0111
        L_0x011d:
            r1 = 139(0x8b, float:1.95E-43)
            goto L_0x089f
        L_0x0121:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012a
            goto L_0x0111
        L_0x012a:
            r1 = 138(0x8a, float:1.93E-43)
            goto L_0x089f
        L_0x012e:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0137
            goto L_0x0111
        L_0x0137:
            r1 = 137(0x89, float:1.92E-43)
            goto L_0x089f
        L_0x013b:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0144
            goto L_0x0111
        L_0x0144:
            r1 = 136(0x88, float:1.9E-43)
            goto L_0x089f
        L_0x0148:
            java.lang.String r1 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0151
            goto L_0x0111
        L_0x0151:
            r1 = 135(0x87, float:1.89E-43)
            goto L_0x089f
        L_0x0155:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x015e
            goto L_0x0111
        L_0x015e:
            r1 = 134(0x86, float:1.88E-43)
            goto L_0x089f
        L_0x0162:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x016b
            goto L_0x0111
        L_0x016b:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x089f
        L_0x016f:
            java.lang.String r1 = "DM-01K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0178
            goto L_0x0111
        L_0x0178:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x089f
        L_0x017c:
            java.lang.String r1 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0185
            goto L_0x0111
        L_0x0185:
            r1 = 131(0x83, float:1.84E-43)
            goto L_0x089f
        L_0x0189:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0193
            goto L_0x0111
        L_0x0193:
            r1 = 130(0x82, float:1.82E-43)
            goto L_0x089f
        L_0x0197:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01a1
            goto L_0x0111
        L_0x01a1:
            r1 = 129(0x81, float:1.81E-43)
            goto L_0x089f
        L_0x01a5:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01af
            goto L_0x0111
        L_0x01af:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x089f
        L_0x01b3:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01bd
            goto L_0x0111
        L_0x01bd:
            r1 = 127(0x7f, float:1.78E-43)
            goto L_0x089f
        L_0x01c1:
            java.lang.String r1 = "CPH1715"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01cb
            goto L_0x0111
        L_0x01cb:
            r1 = 126(0x7e, float:1.77E-43)
            goto L_0x089f
        L_0x01cf:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01d9
            goto L_0x0111
        L_0x01d9:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x089f
        L_0x01dd:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01e7
            goto L_0x0111
        L_0x01e7:
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x089f
        L_0x01eb:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01f5
            goto L_0x0111
        L_0x01f5:
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x089f
        L_0x01f9:
            java.lang.String r1 = "EverStar_S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0203
            goto L_0x0111
        L_0x0203:
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x089f
        L_0x0207:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0211
            goto L_0x0111
        L_0x0211:
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x089f
        L_0x0215:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x021f
            goto L_0x0111
        L_0x021f:
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x089f
        L_0x0223:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x022d
            goto L_0x0111
        L_0x022d:
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x089f
        L_0x0231:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x023b
            goto L_0x0111
        L_0x023b:
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x089f
        L_0x023f:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0249
            goto L_0x0111
        L_0x0249:
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x089f
        L_0x024d:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0257
            goto L_0x0111
        L_0x0257:
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x089f
        L_0x025b:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0265
            goto L_0x0111
        L_0x0265:
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x089f
        L_0x0269:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0273
            goto L_0x0111
        L_0x0273:
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x089f
        L_0x0277:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0281
            goto L_0x0111
        L_0x0281:
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x089f
        L_0x0285:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x028f
            goto L_0x0111
        L_0x028f:
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x089f
        L_0x0293:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x029d
            goto L_0x0111
        L_0x029d:
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x089f
        L_0x02a1:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02ab
            goto L_0x0111
        L_0x02ab:
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x089f
        L_0x02af:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02b9
            goto L_0x0111
        L_0x02b9:
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x089f
        L_0x02bd:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c7
            goto L_0x0111
        L_0x02c7:
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x089f
        L_0x02cb:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02d5
            goto L_0x0111
        L_0x02d5:
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x089f
        L_0x02d9:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02e3
            goto L_0x0111
        L_0x02e3:
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x089f
        L_0x02e7:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02f1
            goto L_0x0111
        L_0x02f1:
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x089f
        L_0x02f5:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02ff
            goto L_0x0111
        L_0x02ff:
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x089f
        L_0x0303:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x030d
            goto L_0x0111
        L_0x030d:
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x089f
        L_0x0311:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x031b
            goto L_0x0111
        L_0x031b:
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x089f
        L_0x031f:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0329
            goto L_0x0111
        L_0x0329:
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x089f
        L_0x032d:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0337
            goto L_0x0111
        L_0x0337:
            r1 = 100
            goto L_0x089f
        L_0x033b:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0345
            goto L_0x0111
        L_0x0345:
            r1 = 99
            goto L_0x089f
        L_0x0349:
            java.lang.String r1 = "l5460"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0353
            goto L_0x0111
        L_0x0353:
            r1 = 98
            goto L_0x089f
        L_0x0357:
            java.lang.String r1 = "i9031"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0361
            goto L_0x0111
        L_0x0361:
            r1 = 97
            goto L_0x089f
        L_0x0365:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x036f
            goto L_0x0111
        L_0x036f:
            r1 = 96
            goto L_0x089f
        L_0x0373:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x037d
            goto L_0x0111
        L_0x037d:
            r1 = 95
            goto L_0x089f
        L_0x0381:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x038b
            goto L_0x0111
        L_0x038b:
            r1 = 94
            goto L_0x089f
        L_0x038f:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0399
            goto L_0x0111
        L_0x0399:
            r1 = 93
            goto L_0x089f
        L_0x039d:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03a7
            goto L_0x0111
        L_0x03a7:
            r1 = 92
            goto L_0x089f
        L_0x03ab:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03b5
            goto L_0x0111
        L_0x03b5:
            r1 = 91
            goto L_0x089f
        L_0x03b9:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03c3
            goto L_0x0111
        L_0x03c3:
            r1 = 90
            goto L_0x089f
        L_0x03c7:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03d1
            goto L_0x0111
        L_0x03d1:
            r1 = 89
            goto L_0x089f
        L_0x03d5:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03df
            goto L_0x0111
        L_0x03df:
            r1 = 88
            goto L_0x089f
        L_0x03e3:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ed
            goto L_0x0111
        L_0x03ed:
            r1 = 87
            goto L_0x089f
        L_0x03f1:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03fb
            goto L_0x0111
        L_0x03fb:
            r1 = 86
            goto L_0x089f
        L_0x03ff:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0409
            goto L_0x0111
        L_0x0409:
            r1 = 85
            goto L_0x089f
        L_0x040d:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0417
            goto L_0x0111
        L_0x0417:
            r1 = 84
            goto L_0x089f
        L_0x041b:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0425
            goto L_0x0111
        L_0x0425:
            r1 = 83
            goto L_0x089f
        L_0x0429:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0433
            goto L_0x0111
        L_0x0433:
            r1 = 82
            goto L_0x089f
        L_0x0437:
            java.lang.String r1 = "602LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0441
            goto L_0x0111
        L_0x0441:
            r1 = 81
            goto L_0x089f
        L_0x0445:
            java.lang.String r1 = "601LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x044f
            goto L_0x0111
        L_0x044f:
            r1 = 80
            goto L_0x089f
        L_0x0453:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x045d
            goto L_0x0111
        L_0x045d:
            r1 = 79
            goto L_0x089f
        L_0x0461:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x046b
            goto L_0x0111
        L_0x046b:
            r1 = 78
            goto L_0x089f
        L_0x046f:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0479
            goto L_0x0111
        L_0x0479:
            r1 = 77
            goto L_0x089f
        L_0x047d:
            java.lang.String r1 = "kate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0487
            goto L_0x0111
        L_0x0487:
            r1 = 76
            goto L_0x089f
        L_0x048b:
            java.lang.String r1 = "fugu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0495
            goto L_0x0111
        L_0x0495:
            r1 = 75
            goto L_0x089f
        L_0x0499:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04a3
            goto L_0x0111
        L_0x04a3:
            r1 = 74
            goto L_0x089f
        L_0x04a7:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04b1
            goto L_0x0111
        L_0x04b1:
            r1 = 73
            goto L_0x089f
        L_0x04b5:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04bf
            goto L_0x0111
        L_0x04bf:
            r1 = 72
            goto L_0x089f
        L_0x04c3:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04cd
            goto L_0x0111
        L_0x04cd:
            r1 = 71
            goto L_0x089f
        L_0x04d1:
            java.lang.String r1 = "F04J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04db
            goto L_0x0111
        L_0x04db:
            r1 = 70
            goto L_0x089f
        L_0x04df:
            java.lang.String r1 = "F04H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04e9
            goto L_0x0111
        L_0x04e9:
            r1 = 69
            goto L_0x089f
        L_0x04ed:
            java.lang.String r1 = "F03H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04f7
            goto L_0x0111
        L_0x04f7:
            r1 = 68
            goto L_0x089f
        L_0x04fb:
            java.lang.String r1 = "F02H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0505
            goto L_0x0111
        L_0x0505:
            r1 = 67
            goto L_0x089f
        L_0x0509:
            java.lang.String r1 = "F01J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0513
            goto L_0x0111
        L_0x0513:
            r1 = 66
            goto L_0x089f
        L_0x0517:
            java.lang.String r1 = "F01H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0521
            goto L_0x0111
        L_0x0521:
            r1 = 65
            goto L_0x089f
        L_0x0525:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x052f
            goto L_0x0111
        L_0x052f:
            r1 = 64
            goto L_0x089f
        L_0x0533:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x053d
            goto L_0x0111
        L_0x053d:
            r1 = 63
            goto L_0x089f
        L_0x0541:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x054b
            goto L_0x0111
        L_0x054b:
            r1 = 62
            goto L_0x089f
        L_0x054f:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0559
            goto L_0x0111
        L_0x0559:
            r1 = 61
            goto L_0x089f
        L_0x055d:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0567
            goto L_0x0111
        L_0x0567:
            r1 = 60
            goto L_0x089f
        L_0x056b:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0575
            goto L_0x0111
        L_0x0575:
            r1 = 59
            goto L_0x089f
        L_0x0579:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0583
            goto L_0x0111
        L_0x0583:
            r1 = 58
            goto L_0x089f
        L_0x0587:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0591
            goto L_0x0111
        L_0x0591:
            r1 = 57
            goto L_0x089f
        L_0x0595:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x059f
            goto L_0x0111
        L_0x059f:
            r1 = 56
            goto L_0x089f
        L_0x05a3:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ad
            goto L_0x0111
        L_0x05ad:
            r1 = 55
            goto L_0x089f
        L_0x05b1:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05bb
            goto L_0x0111
        L_0x05bb:
            r1 = 54
            goto L_0x089f
        L_0x05bf:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05c9
            goto L_0x0111
        L_0x05c9:
            r1 = 53
            goto L_0x089f
        L_0x05cd:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05d7
            goto L_0x0111
        L_0x05d7:
            r1 = 52
            goto L_0x089f
        L_0x05db:
            java.lang.String r1 = "M04"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05e5
            goto L_0x0111
        L_0x05e5:
            r1 = 51
            goto L_0x089f
        L_0x05e9:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05f3
            goto L_0x0111
        L_0x05f3:
            r1 = 50
            goto L_0x089f
        L_0x05f7:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0601
            goto L_0x0111
        L_0x0601:
            r1 = 49
            goto L_0x089f
        L_0x0605:
            java.lang.String r1 = "b5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x060f
            goto L_0x0111
        L_0x060f:
            r1 = 48
            goto L_0x089f
        L_0x0613:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x061d
            goto L_0x0111
        L_0x061d:
            r1 = 47
            goto L_0x089f
        L_0x0621:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x062b
            goto L_0x0111
        L_0x062b:
            r1 = 46
            goto L_0x089f
        L_0x062f:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0639
            goto L_0x0111
        L_0x0639:
            r1 = 45
            goto L_0x089f
        L_0x063d:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0647
            goto L_0x0111
        L_0x0647:
            r1 = 44
            goto L_0x089f
        L_0x064b:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0655
            goto L_0x0111
        L_0x0655:
            r1 = 43
            goto L_0x089f
        L_0x0659:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0663
            goto L_0x0111
        L_0x0663:
            r1 = 42
            goto L_0x089f
        L_0x0667:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0671
            goto L_0x0111
        L_0x0671:
            r1 = 41
            goto L_0x089f
        L_0x0675:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x067f
            goto L_0x0111
        L_0x067f:
            r1 = 40
            goto L_0x089f
        L_0x0683:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x068d
            goto L_0x0111
        L_0x068d:
            r1 = 39
            goto L_0x089f
        L_0x0691:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x069b
            goto L_0x0111
        L_0x069b:
            r1 = 38
            goto L_0x089f
        L_0x069f:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06a9
            goto L_0x0111
        L_0x06a9:
            r1 = 37
            goto L_0x089f
        L_0x06ad:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06b7
            goto L_0x0111
        L_0x06b7:
            r1 = 36
            goto L_0x089f
        L_0x06bb:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06c5
            goto L_0x0111
        L_0x06c5:
            r1 = 35
            goto L_0x089f
        L_0x06c9:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06d3
            goto L_0x0111
        L_0x06d3:
            r1 = 34
            goto L_0x089f
        L_0x06d7:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06e1
            goto L_0x0111
        L_0x06e1:
            r1 = 33
            goto L_0x089f
        L_0x06e5:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06ef
            goto L_0x0111
        L_0x06ef:
            r1 = 32
            goto L_0x089f
        L_0x06f3:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06fd
            goto L_0x0111
        L_0x06fd:
            r1 = 31
            goto L_0x089f
        L_0x0701:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x070b
            goto L_0x0111
        L_0x070b:
            r1 = 30
            goto L_0x089f
        L_0x070f:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0719
            goto L_0x0111
        L_0x0719:
            r1 = 29
            goto L_0x089f
        L_0x071d:
            java.lang.String r1 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0727
            goto L_0x0111
        L_0x0727:
            r1 = 28
            goto L_0x089f
        L_0x072b:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0735
            goto L_0x0111
        L_0x0735:
            r1 = 27
            goto L_0x089f
        L_0x0739:
            java.lang.String r1 = "A10-70L"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0743
            goto L_0x0111
        L_0x0743:
            r1 = 26
            goto L_0x089f
        L_0x0747:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0751
            goto L_0x0111
        L_0x0751:
            r1 = 25
            goto L_0x089f
        L_0x0755:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x075f
            goto L_0x0111
        L_0x075f:
            r1 = 24
            goto L_0x089f
        L_0x0763:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x076d
            goto L_0x0111
        L_0x076d:
            r1 = 23
            goto L_0x089f
        L_0x0771:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x077b
            goto L_0x0111
        L_0x077b:
            r1 = 22
            goto L_0x089f
        L_0x077f:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0789
            goto L_0x0111
        L_0x0789:
            r1 = 21
            goto L_0x089f
        L_0x078d:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0797
            goto L_0x0111
        L_0x0797:
            r1 = 20
            goto L_0x089f
        L_0x079b:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07a5
            goto L_0x0111
        L_0x07a5:
            r1 = 19
            goto L_0x089f
        L_0x07a9:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07b3
            goto L_0x0111
        L_0x07b3:
            r1 = 18
            goto L_0x089f
        L_0x07b7:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07c1
            goto L_0x0111
        L_0x07c1:
            r1 = 17
            goto L_0x089f
        L_0x07c5:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07cf
            goto L_0x0111
        L_0x07cf:
            r1 = 16
            goto L_0x089f
        L_0x07d3:
            java.lang.String r1 = "pacificrim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07dd
            goto L_0x0111
        L_0x07dd:
            r1 = 15
            goto L_0x089f
        L_0x07e1:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07eb
            goto L_0x0111
        L_0x07eb:
            r1 = 14
            goto L_0x089f
        L_0x07ef:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07f9
            goto L_0x0111
        L_0x07f9:
            r1 = 13
            goto L_0x089f
        L_0x07fd:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0807
            goto L_0x0111
        L_0x0807:
            r1 = 12
            goto L_0x089f
        L_0x080b:
            java.lang.String r1 = "RAIJIN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0815
            goto L_0x0111
        L_0x0815:
            r1 = 11
            goto L_0x089f
        L_0x0819:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0823
            goto L_0x0111
        L_0x0823:
            r1 = 10
            goto L_0x089f
        L_0x0827:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0831
            goto L_0x0111
        L_0x0831:
            r1 = 9
            goto L_0x089f
        L_0x0835:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x083f
            goto L_0x0111
        L_0x083f:
            r1 = 8
            goto L_0x089f
        L_0x0842:
            java.lang.String r2 = "PGN528"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x089f
            goto L_0x0111
        L_0x084c:
            java.lang.String r1 = "NX573J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0856
            goto L_0x0111
        L_0x0856:
            r1 = 6
            goto L_0x089f
        L_0x0858:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0862
            goto L_0x0111
        L_0x0862:
            r1 = 5
            goto L_0x089f
        L_0x0864:
            java.lang.String r1 = "CP8676_I02"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x086e
            goto L_0x0111
        L_0x086e:
            r1 = 4
            goto L_0x089f
        L_0x0870:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x087a
            goto L_0x0111
        L_0x087a:
            r1 = 3
            goto L_0x089f
        L_0x087c:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0886
            goto L_0x0111
        L_0x0886:
            r1 = 2
            goto L_0x089f
        L_0x0888:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0892
            goto L_0x0111
        L_0x0892:
            r1 = 1
            goto L_0x089f
        L_0x0894:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x089e
            goto L_0x0111
        L_0x089e:
            r1 = 0
        L_0x089f:
            switch(r1) {
                case 0: goto L_0x08ae;
                case 1: goto L_0x08ae;
                case 2: goto L_0x08ae;
                case 3: goto L_0x08ae;
                case 4: goto L_0x08ae;
                case 5: goto L_0x08ae;
                case 6: goto L_0x08ae;
                case 7: goto L_0x08ae;
                case 8: goto L_0x08ae;
                case 9: goto L_0x08ae;
                case 10: goto L_0x08ae;
                case 11: goto L_0x08ae;
                case 12: goto L_0x08ae;
                case 13: goto L_0x08ae;
                case 14: goto L_0x08ae;
                case 15: goto L_0x08ae;
                case 16: goto L_0x08ae;
                case 17: goto L_0x08ae;
                case 18: goto L_0x08ae;
                case 19: goto L_0x08ae;
                case 20: goto L_0x08ae;
                case 21: goto L_0x08ae;
                case 22: goto L_0x08ae;
                case 23: goto L_0x08ae;
                case 24: goto L_0x08ae;
                case 25: goto L_0x08ae;
                case 26: goto L_0x08ae;
                case 27: goto L_0x08ae;
                case 28: goto L_0x08ae;
                case 29: goto L_0x08ae;
                case 30: goto L_0x08ae;
                case 31: goto L_0x08ae;
                case 32: goto L_0x08ae;
                case 33: goto L_0x08ae;
                case 34: goto L_0x08ae;
                case 35: goto L_0x08ae;
                case 36: goto L_0x08ae;
                case 37: goto L_0x08ae;
                case 38: goto L_0x08ae;
                case 39: goto L_0x08ae;
                case 40: goto L_0x08ae;
                case 41: goto L_0x08ae;
                case 42: goto L_0x08ae;
                case 43: goto L_0x08ae;
                case 44: goto L_0x08ae;
                case 45: goto L_0x08ae;
                case 46: goto L_0x08ae;
                case 47: goto L_0x08ae;
                case 48: goto L_0x08ae;
                case 49: goto L_0x08ae;
                case 50: goto L_0x08ae;
                case 51: goto L_0x08ae;
                case 52: goto L_0x08ae;
                case 53: goto L_0x08ae;
                case 54: goto L_0x08ae;
                case 55: goto L_0x08ae;
                case 56: goto L_0x08ae;
                case 57: goto L_0x08ae;
                case 58: goto L_0x08ae;
                case 59: goto L_0x08ae;
                case 60: goto L_0x08ae;
                case 61: goto L_0x08ae;
                case 62: goto L_0x08ae;
                case 63: goto L_0x08ae;
                case 64: goto L_0x08ae;
                case 65: goto L_0x08ae;
                case 66: goto L_0x08ae;
                case 67: goto L_0x08ae;
                case 68: goto L_0x08ae;
                case 69: goto L_0x08ae;
                case 70: goto L_0x08ae;
                case 71: goto L_0x08ae;
                case 72: goto L_0x08ae;
                case 73: goto L_0x08ae;
                case 74: goto L_0x08ae;
                case 75: goto L_0x08ae;
                case 76: goto L_0x08ae;
                case 77: goto L_0x08ae;
                case 78: goto L_0x08ae;
                case 79: goto L_0x08ae;
                case 80: goto L_0x08ae;
                case 81: goto L_0x08ae;
                case 82: goto L_0x08ae;
                case 83: goto L_0x08ae;
                case 84: goto L_0x08ae;
                case 85: goto L_0x08ae;
                case 86: goto L_0x08ae;
                case 87: goto L_0x08ae;
                case 88: goto L_0x08ae;
                case 89: goto L_0x08ae;
                case 90: goto L_0x08ae;
                case 91: goto L_0x08ae;
                case 92: goto L_0x08ae;
                case 93: goto L_0x08ae;
                case 94: goto L_0x08ae;
                case 95: goto L_0x08ae;
                case 96: goto L_0x08ae;
                case 97: goto L_0x08ae;
                case 98: goto L_0x08ae;
                case 99: goto L_0x08ae;
                case 100: goto L_0x08ae;
                case 101: goto L_0x08ae;
                case 102: goto L_0x08ae;
                case 103: goto L_0x08ae;
                case 104: goto L_0x08ae;
                case 105: goto L_0x08ae;
                case 106: goto L_0x08ae;
                case 107: goto L_0x08ae;
                case 108: goto L_0x08ae;
                case 109: goto L_0x08ae;
                case 110: goto L_0x08ae;
                case 111: goto L_0x08ae;
                case 112: goto L_0x08ae;
                case 113: goto L_0x08ae;
                case 114: goto L_0x08ae;
                case 115: goto L_0x08ae;
                case 116: goto L_0x08ae;
                case 117: goto L_0x08ae;
                case 118: goto L_0x08ae;
                case 119: goto L_0x08ae;
                case 120: goto L_0x08ae;
                case 121: goto L_0x08ae;
                case 122: goto L_0x08ae;
                case 123: goto L_0x08ae;
                case 124: goto L_0x08ae;
                case 125: goto L_0x08ae;
                case 126: goto L_0x08ae;
                case 127: goto L_0x08ae;
                case 128: goto L_0x08ae;
                case 129: goto L_0x08ae;
                case 130: goto L_0x08ae;
                case 131: goto L_0x08ae;
                case 132: goto L_0x08ae;
                case 133: goto L_0x08ae;
                case 134: goto L_0x08ae;
                case 135: goto L_0x08ae;
                case 136: goto L_0x08ae;
                case 137: goto L_0x08ae;
                case 138: goto L_0x08ae;
                case 139: goto L_0x08ae;
                default: goto L_0x08a2;
            }
        L_0x08a2:
            r12.hashCode()
            java.lang.String r0 = "JSN-L21"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x08ae
            goto L_0x08af
        L_0x08ae:
            return r9
        L_0x08af:
            return r8
        L_0x08b0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.V1():boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        if (r3.equals("video/av01") == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        r10 = ((java.lang.Integer) r10.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int X1(androidx.media3.exoplayer.mediacodec.MediaCodecInfo r9, androidx.media3.common.Format r10) {
        /*
            int r0 = r10.f4021t
            int r1 = r10.f4022u
            r2 = -1
            if (r0 == r2) goto L_0x00eb
            if (r1 != r2) goto L_0x000b
            goto L_0x00eb
        L_0x000b:
            java.lang.String r3 = r10.f4015n
            java.lang.Object r3 = androidx.media3.common.util.Assertions.f(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "video/avc"
            java.lang.String r6 = "video/hevc"
            r7 = 1
            r8 = 2
            if (r4 == 0) goto L_0x003a
            android.util.Pair r10 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.r(r10)
            if (r10 == 0) goto L_0x0039
            java.lang.Object r10 = r10.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r10 == r3) goto L_0x0037
            if (r10 == r7) goto L_0x0037
            if (r10 != r8) goto L_0x0039
        L_0x0037:
            r3 = r5
            goto L_0x003a
        L_0x0039:
            r3 = r6
        L_0x003a:
            r3.hashCode()
            int r10 = r3.hashCode()
            r4 = 4
            switch(r10) {
                case -1664118616: goto L_0x0083;
                case -1662735862: goto L_0x007a;
                case -1662541442: goto L_0x0071;
                case 1187890754: goto L_0x0066;
                case 1331836730: goto L_0x005d;
                case 1599127256: goto L_0x0052;
                case 1599127257: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            r7 = -1
            goto L_0x008d
        L_0x0047:
            java.lang.String r10 = "video/x-vnd.on2.vp9"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x0050
            goto L_0x0045
        L_0x0050:
            r7 = 6
            goto L_0x008d
        L_0x0052:
            java.lang.String r10 = "video/x-vnd.on2.vp8"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x005b
            goto L_0x0045
        L_0x005b:
            r7 = 5
            goto L_0x008d
        L_0x005d:
            boolean r10 = r3.equals(r5)
            if (r10 != 0) goto L_0x0064
            goto L_0x0045
        L_0x0064:
            r7 = 4
            goto L_0x008d
        L_0x0066:
            java.lang.String r10 = "video/mp4v-es"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x006f
            goto L_0x0045
        L_0x006f:
            r7 = 3
            goto L_0x008d
        L_0x0071:
            boolean r10 = r3.equals(r6)
            if (r10 != 0) goto L_0x0078
            goto L_0x0045
        L_0x0078:
            r7 = 2
            goto L_0x008d
        L_0x007a:
            java.lang.String r10 = "video/av01"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x008d
            goto L_0x0045
        L_0x0083:
            java.lang.String r10 = "video/3gpp"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x008c
            goto L_0x0045
        L_0x008c:
            r7 = 0
        L_0x008d:
            switch(r7) {
                case 0: goto L_0x00e4;
                case 1: goto L_0x00e4;
                case 2: goto L_0x00d7;
                case 3: goto L_0x00e4;
                case 4: goto L_0x0098;
                case 5: goto L_0x00e4;
                case 6: goto L_0x0091;
                default: goto L_0x0090;
            }
        L_0x0090:
            return r2
        L_0x0091:
            int r0 = r0 * r1
            int r9 = c2(r0, r4)
            return r9
        L_0x0098:
            java.lang.String r10 = androidx.media3.common.util.Util.f4717d
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r3 = r3.equals(r10)
            if (r3 != 0) goto L_0x00d6
            java.lang.String r3 = "Amazon"
            java.lang.String r4 = androidx.media3.common.util.Util.f4716c
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00c1
            java.lang.String r3 = "KFSOWI"
            boolean r3 = r3.equals(r10)
            if (r3 != 0) goto L_0x00d6
            java.lang.String r3 = "AFTS"
            boolean r10 = r3.equals(r10)
            if (r10 == 0) goto L_0x00c1
            boolean r9 = r9.f6693g
            if (r9 == 0) goto L_0x00c1
            goto L_0x00d6
        L_0x00c1:
            r9 = 16
            int r10 = androidx.media3.common.util.Util.k(r0, r9)
            int r0 = androidx.media3.common.util.Util.k(r1, r9)
            int r10 = r10 * r0
            int r10 = r10 * 16
            int r10 = r10 * 16
            int r9 = c2(r10, r8)
            return r9
        L_0x00d6:
            return r2
        L_0x00d7:
            int r0 = r0 * r1
            int r9 = c2(r0, r8)
            r10 = 2097152(0x200000, float:2.938736E-39)
            int r9 = java.lang.Math.max(r10, r9)
            return r9
        L_0x00e4:
            int r0 = r0 * r1
            int r9 = c2(r0, r8)
            return r9
        L_0x00eb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.X1(androidx.media3.exoplayer.mediacodec.MediaCodecInfo, androidx.media3.common.Format):int");
    }

    private static Point Y1(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5 = format.f4022u;
        int i6 = format.f4021t;
        if (i5 > i6) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i2 = i5;
        } else {
            i2 = i6;
        }
        if (z2) {
            i5 = i6;
        }
        float f2 = ((float) i5) / ((float) i2);
        for (int i7 : w1) {
            int i8 = (int) (((float) i7) * f2);
            if (i7 <= i2 || i8 <= i5) {
                break;
            }
            if (Util.f4714a >= 21) {
                if (z2) {
                    i4 = i8;
                } else {
                    i4 = i7;
                }
                if (!z2) {
                    i7 = i8;
                }
                Point b2 = mediaCodecInfo.b(i4, i7);
                float f3 = format.f4023v;
                if (b2 != null && mediaCodecInfo.u(b2.x, b2.y, (double) f3)) {
                    return b2;
                }
            } else {
                try {
                    int k2 = Util.k(i7, 16) * 16;
                    int k3 = Util.k(i8, 16) * 16;
                    if (k2 * k3 <= MediaCodecUtil.P()) {
                        if (z2) {
                            i3 = k3;
                        } else {
                            i3 = k2;
                        }
                        if (!z2) {
                            k2 = k3;
                        }
                        return new Point(i3, k2);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    private static List<MediaCodecInfo> a2(Context context, MediaCodecSelector mediaCodecSelector, Format format, boolean z2, boolean z3) throws MediaCodecUtil.DecoderQueryException {
        String str = format.f4015n;
        if (str == null) {
            return ImmutableList.r();
        }
        if (Util.f4714a >= 26 && "video/dolby-vision".equals(str) && !Api26.a(context)) {
            List<MediaCodecInfo> n2 = MediaCodecUtil.n(mediaCodecSelector, format, z2, z3);
            if (!n2.isEmpty()) {
                return n2;
            }
        }
        return MediaCodecUtil.v(mediaCodecSelector, format, z2, z3);
    }

    protected static int b2(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.f4016o == -1) {
            return X1(mediaCodecInfo, format);
        }
        int size = format.f4018q.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += format.f4018q.get(i3).length;
        }
        return format.f4016o + i2;
    }

    private static int c2(int i2, int i3) {
        return (i2 * 3) / (i3 * 2);
    }

    private void f2() {
        if (this.f7665j1 > 0) {
            long elapsedRealtime = G().elapsedRealtime();
            this.S0.n(this.f7665j1, elapsedRealtime - this.f7664i1);
            this.f7665j1 = 0;
            this.f7664i1 = elapsedRealtime;
        }
    }

    private void g2() {
        if (this.V0.i() && this.f7659d1 != null) {
            p2();
        }
    }

    private void h2() {
        int i2 = this.f7669n1;
        if (i2 != 0) {
            this.S0.B(this.f7668m1, i2);
            this.f7668m1 = 0;
            this.f7669n1 = 0;
        }
    }

    private void i2(VideoSize videoSize) {
        if (!videoSize.equals(VideoSize.f4483e) && !videoSize.equals(this.f7672q1)) {
            this.f7672q1 = videoSize;
            this.S0.D(videoSize);
        }
    }

    private boolean j2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2, Format format) {
        long g2 = this.W0.g();
        long f2 = this.W0.f();
        if (Util.f4714a >= 21) {
            if (!E2() || g2 != this.f7670o1) {
                o2(j2, g2, format);
                w2(mediaCodecAdapter, i2, j2, g2);
            } else {
                G2(mediaCodecAdapter, i2, j2);
            }
            J2(f2);
            this.f7670o1 = g2;
            return true;
        } else if (f2 >= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            return false;
        } else {
            if (f2 > 11000) {
                try {
                    Thread.sleep((f2 - NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            o2(j2, g2, format);
            u2(mediaCodecAdapter, i2, j2);
            J2(f2);
            return true;
        }
    }

    private void k2() {
        Surface surface = this.f7659d1;
        if (surface != null && this.f7662g1) {
            this.S0.A(surface);
        }
    }

    private void l2() {
        VideoSize videoSize = this.f7672q1;
        if (videoSize != null) {
            this.S0.D(videoSize);
        }
    }

    private void m2(MediaFormat mediaFormat) {
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null && !videoSink.l()) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
    }

    private void n2() {
        int i2;
        MediaCodecAdapter A0;
        if (this.f7674s1 && (i2 = Util.f4714a) >= 23 && (A0 = A0()) != null) {
            this.u1 = new OnFrameRenderedListenerV23(A0);
            if (i2 >= 33) {
                Bundle bundle = new Bundle();
                bundle.putInt("tunnel-peek", 1);
                A0.b(bundle);
            }
        }
    }

    private void o2(long j2, long j3, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.v1;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.e(j2, j3, format, F0());
        }
    }

    /* access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    public void p2() {
        this.S0.A(this.f7659d1);
        this.f7662g1 = true;
    }

    /* access modifiers changed from: private */
    public void r2() {
        z1();
    }

    private void t2() {
        Surface surface = this.f7659d1;
        PlaceholderSurface placeholderSurface = this.f7660e1;
        if (surface == placeholderSurface) {
            this.f7659d1 = null;
        }
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.f7660e1 = null;
        }
    }

    private void v2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2, long j3) {
        if (Util.f4714a >= 21) {
            w2(mediaCodecAdapter, i2, j2, j3);
        } else {
            u2(mediaCodecAdapter, i2, j2);
        }
    }

    private static void x2(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.b(bundle);
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void y2(java.lang.Object r6) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof android.view.Surface
            r1 = 0
            if (r0 == 0) goto L_0x0008
            android.view.Surface r6 = (android.view.Surface) r6
            goto L_0x0009
        L_0x0008:
            r6 = r1
        L_0x0009:
            if (r6 != 0) goto L_0x0027
            androidx.media3.exoplayer.video.PlaceholderSurface r0 = r5.f7660e1
            if (r0 == 0) goto L_0x0011
            r6 = r0
            goto L_0x0027
        L_0x0011:
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = r5.C0()
            if (r0 == 0) goto L_0x0027
            boolean r2 = r5.F2(r0)
            if (r2 == 0) goto L_0x0027
            android.content.Context r6 = r5.P0
            boolean r0 = r0.f6693g
            androidx.media3.exoplayer.video.PlaceholderSurface r6 = androidx.media3.exoplayer.video.PlaceholderSurface.d(r6, r0)
            r5.f7660e1 = r6
        L_0x0027:
            android.view.Surface r0 = r5.f7659d1
            if (r0 == r6) goto L_0x007d
            r5.f7659d1 = r6
            androidx.media3.exoplayer.video.VideoSink r0 = r5.f7656a1
            if (r0 != 0) goto L_0x0036
            androidx.media3.exoplayer.video.VideoFrameReleaseControl r0 = r5.V0
            r0.q(r6)
        L_0x0036:
            r0 = 0
            r5.f7662g1 = r0
            int r0 = r5.getState()
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r2 = r5.A0()
            if (r2 == 0) goto L_0x005d
            androidx.media3.exoplayer.video.VideoSink r3 = r5.f7656a1
            if (r3 != 0) goto L_0x005d
            int r3 = androidx.media3.common.util.Util.f4714a
            r4 = 23
            if (r3 < r4) goto L_0x0057
            if (r6 == 0) goto L_0x0057
            boolean r3 = r5.Y0
            if (r3 != 0) goto L_0x0057
            r5.z2(r2, r6)
            goto L_0x005d
        L_0x0057:
            r5.r1()
            r5.a1()
        L_0x005d:
            if (r6 == 0) goto L_0x0070
            androidx.media3.exoplayer.video.PlaceholderSurface r2 = r5.f7660e1
            if (r6 == r2) goto L_0x0070
            r5.l2()
            r6 = 2
            if (r0 != r6) goto L_0x0079
            androidx.media3.exoplayer.video.VideoFrameReleaseControl r6 = r5.V0
            r0 = 1
            r6.e(r0)
            goto L_0x0079
        L_0x0070:
            r5.f7672q1 = r1
            androidx.media3.exoplayer.video.VideoSink r6 = r5.f7656a1
            if (r6 == 0) goto L_0x0079
            r6.s()
        L_0x0079:
            r5.n2()
            goto L_0x0089
        L_0x007d:
            if (r6 == 0) goto L_0x0089
            androidx.media3.exoplayer.video.PlaceholderSurface r0 = r5.f7660e1
            if (r6 == r0) goto L_0x0089
            r5.l2()
            r5.k2()
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.y2(java.lang.Object):void");
    }

    public void A2(List<Effect> list) {
        this.f7658c1 = list;
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.i(list);
        }
    }

    /* access modifiers changed from: protected */
    public int B0(DecoderInputBuffer decoderInputBuffer) {
        return (Util.f4714a < 34 || !this.f7674s1 || decoderInputBuffer.f5069f >= K()) ? 0 : 32;
    }

    /* access modifiers changed from: protected */
    public boolean B2(long j2, long j3, boolean z2) {
        return j2 < -500000 && !z2;
    }

    /* access modifiers changed from: protected */
    public boolean C2(long j2, long j3, boolean z2) {
        return j2 < -30000 && !z2;
    }

    public boolean D(long j2, long j3, boolean z2) {
        return C2(j2, j3, z2);
    }

    /* access modifiers changed from: protected */
    public boolean D0() {
        return this.f7674s1 && Util.f4714a < 23;
    }

    /* access modifiers changed from: protected */
    public boolean D1(MediaCodecInfo mediaCodecInfo) {
        return this.f7659d1 != null || F2(mediaCodecInfo);
    }

    /* access modifiers changed from: protected */
    public boolean D2(long j2, long j3) {
        return j2 < -30000 && j3 > 100000;
    }

    /* access modifiers changed from: protected */
    public float E0(float f2, Format format, Format[] formatArr) {
        float f3 = -1.0f;
        for (Format format2 : formatArr) {
            float f4 = format2.f4023v;
            if (f4 != -1.0f) {
                f3 = Math.max(f3, f4);
            }
        }
        if (f3 == -1.0f) {
            return -1.0f;
        }
        return f3 * f2;
    }

    /* access modifiers changed from: protected */
    public boolean E2() {
        return true;
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> G0(MediaCodecSelector mediaCodecSelector, Format format, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.w(a2(this.P0, mediaCodecSelector, format, z2, this.f7674s1), format);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int G1(androidx.media3.exoplayer.mediacodec.MediaCodecSelector r11, androidx.media3.common.Format r12) throws androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r10 = this;
            java.lang.String r0 = r12.f4015n
            boolean r0 = androidx.media3.common.MimeTypes.s(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            int r11 = e.x.a(r1)
            return r11
        L_0x000e:
            androidx.media3.common.DrmInitData r0 = r12.f4019r
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            android.content.Context r3 = r10.P0
            java.util.List r3 = a2(r3, r11, r12, r0, r1)
            if (r0 == 0) goto L_0x002a
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x002a
            android.content.Context r3 = r10.P0
            java.util.List r3 = a2(r3, r11, r12, r1, r1)
        L_0x002a:
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0035
            int r11 = e.x.a(r2)
            return r11
        L_0x0035:
            boolean r4 = androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.H1(r12)
            if (r4 != 0) goto L_0x0041
            r11 = 2
            int r11 = e.x.a(r11)
            return r11
        L_0x0041:
            java.lang.Object r4 = r3.get(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r4 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r4
            boolean r5 = r4.m(r12)
            if (r5 != 0) goto L_0x0067
            r6 = 1
        L_0x004e:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x0067
            java.lang.Object r7 = r3.get(r6)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r7 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r7
            boolean r8 = r7.m(r12)
            if (r8 == 0) goto L_0x0064
            r4 = r7
            r3 = 0
            r5 = 1
            goto L_0x0068
        L_0x0064:
            int r6 = r6 + 1
            goto L_0x004e
        L_0x0067:
            r3 = 1
        L_0x0068:
            if (r5 == 0) goto L_0x006c
            r6 = 4
            goto L_0x006d
        L_0x006c:
            r6 = 3
        L_0x006d:
            boolean r7 = r4.p(r12)
            if (r7 == 0) goto L_0x0076
            r7 = 16
            goto L_0x0078
        L_0x0076:
            r7 = 8
        L_0x0078:
            boolean r4 = r4.f6694h
            if (r4 == 0) goto L_0x007f
            r4 = 64
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            if (r3 == 0) goto L_0x0085
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            int r8 = androidx.media3.common.util.Util.f4714a
            r9 = 26
            if (r8 < r9) goto L_0x00a0
            java.lang.String r8 = "video/dolby-vision"
            java.lang.String r9 = r12.f4015n
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00a0
            android.content.Context r8 = r10.P0
            boolean r8 = androidx.media3.exoplayer.video.MediaCodecVideoRenderer.Api26.a(r8)
            if (r8 != 0) goto L_0x00a0
            r3 = 256(0x100, float:3.59E-43)
        L_0x00a0:
            if (r5 == 0) goto L_0x00c6
            android.content.Context r5 = r10.P0
            java.util.List r11 = a2(r5, r11, r12, r0, r2)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x00c6
            java.util.List r11 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.w(r11, r12)
            java.lang.Object r11 = r11.get(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r11 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r11
            boolean r0 = r11.m(r12)
            if (r0 == 0) goto L_0x00c6
            boolean r11 = r11.p(r12)
            if (r11 == 0) goto L_0x00c6
            r1 = 32
        L_0x00c6:
            int r11 = e.x.d(r6, r7, r1, r4, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.G1(androidx.media3.exoplayer.mediacodec.MediaCodecSelector, androidx.media3.common.Format):int");
    }

    /* access modifiers changed from: protected */
    public void G2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        TraceUtil.a("skipVideoBuffer");
        mediaCodecAdapter.l(i2, false);
        TraceUtil.b();
        this.K0.f5155f++;
    }

    /* access modifiers changed from: protected */
    public void I2(int i2, int i3) {
        DecoderCounters decoderCounters = this.K0;
        decoderCounters.f5157h += i2;
        int i4 = i2 + i3;
        decoderCounters.f5156g += i4;
        this.f7665j1 += i4;
        int i5 = this.f7666k1 + i4;
        this.f7666k1 = i5;
        decoderCounters.f5158i = Math.max(i5, decoderCounters.f5158i);
        int i6 = this.T0;
        if (i6 > 0 && this.f7665j1 >= i6) {
            f2();
        }
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Configuration J0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f2) {
        int i2;
        Surface surface;
        PlaceholderSurface placeholderSurface = this.f7660e1;
        if (!(placeholderSurface == null || placeholderSurface.f7683b == mediaCodecInfo.f6693g)) {
            t2();
        }
        String str = mediaCodecInfo.f6689c;
        CodecMaxValues Z1 = Z1(mediaCodecInfo, format, M());
        this.X0 = Z1;
        boolean z2 = this.U0;
        if (this.f7674s1) {
            i2 = this.t1;
        } else {
            i2 = 0;
        }
        MediaFormat d2 = d2(format, str, Z1, f2, z2, i2);
        if (this.f7659d1 == null) {
            if (F2(mediaCodecInfo)) {
                if (this.f7660e1 == null) {
                    this.f7660e1 = PlaceholderSurface.d(this.P0, mediaCodecInfo.f6693g);
                }
                this.f7659d1 = this.f7660e1;
            } else {
                throw new IllegalStateException();
            }
        }
        m2(d2);
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            surface = videoSink.b();
        } else {
            surface = this.f7659d1;
        }
        return MediaCodecAdapter.Configuration.b(mediaCodecInfo, d2, format, surface, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public void J2(long j2) {
        this.K0.a(j2);
        this.f7668m1 += j2;
        this.f7669n1++;
    }

    /* access modifiers changed from: protected */
    public void O() {
        this.f7672q1 = null;
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.r();
        } else {
            this.V0.g();
        }
        n2();
        this.f7662g1 = false;
        this.u1 = null;
        try {
            super.O();
        } finally {
            this.S0.m(this.K0);
            this.S0.D(VideoSize.f4483e);
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(29)
    public void O0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.Z0) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.f(decoderInputBuffer.f5070g);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s2 = byteBuffer.getShort();
                short s3 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 != -75 || s2 != 60 || s3 != 1 || b3 != 4) {
                    return;
                }
                if (b4 == 0 || b4 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    x2((MediaCodecAdapter) Assertions.f(A0()), bArr);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void P(boolean z2, boolean z3) throws ExoPlaybackException {
        boolean z4;
        super.P(z2, z3);
        boolean z5 = H().f5509b;
        if (!z5 || this.t1 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.h(z4);
        if (this.f7674s1 != z5) {
            this.f7674s1 = z5;
            r1();
        }
        this.S0.o(this.K0);
        if (!this.f7657b1) {
            if ((this.f7658c1 != null || !this.R0) && this.f7656a1 == null) {
                VideoSinkProvider videoSinkProvider = this.Q0;
                if (videoSinkProvider == null) {
                    videoSinkProvider = new CompositingVideoSinkProvider.Builder(this.P0, this.V0).f(G()).e();
                }
                this.f7656a1 = videoSinkProvider.b();
            }
            this.f7657b1 = true;
        }
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.v(new VideoSink.Listener() {
                public void a(VideoSink videoSink) {
                    Assertions.j(MediaCodecVideoRenderer.this.f7659d1);
                    MediaCodecVideoRenderer.this.p2();
                }

                public void b(VideoSink videoSink, VideoSize videoSize) {
                }

                public void c(VideoSink videoSink) {
                    MediaCodecVideoRenderer.this.I2(0, 1);
                }
            }, MoreExecutors.a());
            VideoFrameMetadataListener videoFrameMetadataListener = this.v1;
            if (videoFrameMetadataListener != null) {
                this.f7656a1.d(videoFrameMetadataListener);
            }
            if (this.f7659d1 != null && !this.f7661f1.equals(Size.f4698c)) {
                this.f7656a1.p(this.f7659d1, this.f7661f1);
            }
            this.f7656a1.setPlaybackSpeed(M0());
            List<Effect> list = this.f7658c1;
            if (list != null) {
                this.f7656a1.i(list);
            }
            this.f7656a1.n(z3);
            return;
        }
        this.V0.o(G());
        this.V0.h(z3);
    }

    /* access modifiers changed from: protected */
    public void Q() {
        super.Q();
    }

    /* access modifiers changed from: protected */
    public void R(long j2, boolean z2) throws ExoPlaybackException {
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.u(true);
            this.f7656a1.k(K0(), W1());
        }
        super.R(j2, z2);
        if (this.f7656a1 == null) {
            this.V0.m();
        }
        if (z2) {
            this.V0.e(false);
        }
        n2();
        this.f7666k1 = 0;
    }

    /* access modifiers changed from: protected */
    public boolean R1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!x1) {
                y1 = V1();
                x1 = true;
            }
        }
        return y1;
    }

    /* access modifiers changed from: protected */
    public void S() {
        super.S();
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null && this.R0) {
            videoSink.release();
        }
    }

    /* access modifiers changed from: protected */
    public void U() {
        try {
            super.U();
        } finally {
            this.f7657b1 = false;
            if (this.f7660e1 != null) {
                t2();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void U1(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        TraceUtil.a("dropVideoBuffer");
        mediaCodecAdapter.l(i2, false);
        TraceUtil.b();
        I2(0, 1);
    }

    /* access modifiers changed from: protected */
    public void V() {
        super.V();
        this.f7665j1 = 0;
        this.f7664i1 = G().elapsedRealtime();
        this.f7668m1 = 0;
        this.f7669n1 = 0;
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.o();
        } else {
            this.V0.k();
        }
    }

    /* access modifiers changed from: protected */
    public void W() {
        f2();
        h2();
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.g();
        } else {
            this.V0.l();
        }
        super.W();
    }

    /* access modifiers changed from: protected */
    public long W1() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues Z1(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        boolean z2;
        int X1;
        int i2 = format.f4021t;
        int i3 = format.f4022u;
        int b2 = b2(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(b2 == -1 || (X1 = X1(mediaCodecInfo, format)) == -1)) {
                b2 = Math.min((int) (((float) b2) * 1.5f), X1);
            }
            return new CodecMaxValues(i2, i3, b2);
        }
        int length = formatArr.length;
        boolean z3 = false;
        for (int i4 = 0; i4 < length; i4++) {
            Format format2 = formatArr[i4];
            if (format.A != null && format2.A == null) {
                format2 = format2.a().P(format.A).K();
            }
            if (mediaCodecInfo.e(format, format2).f5165d != 0) {
                int i5 = format2.f4021t;
                if (i5 == -1 || format2.f4022u == -1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 |= z2;
                i2 = Math.max(i2, i5);
                i3 = Math.max(i3, format2.f4022u);
                b2 = Math.max(b2, b2(mediaCodecInfo, format2));
            }
        }
        if (z3) {
            Log.h("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i2 + "x" + i3);
            Point Y1 = Y1(mediaCodecInfo, format);
            if (Y1 != null) {
                i2 = Math.max(i2, Y1.x);
                i3 = Math.max(i3, Y1.y);
                b2 = Math.max(b2, X1(mediaCodecInfo, format.a().v0(i2).Y(i3).K()));
                Log.h("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i2 + "x" + i3);
            }
        }
        return new CodecMaxValues(i2, i3, b2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f7656a1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r1 = this;
            boolean r0 = super.a()
            if (r0 == 0) goto L_0x0012
            androidx.media3.exoplayer.video.VideoSink r0 = r1.f7656a1
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0012
        L_0x0010:
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.a():boolean");
    }

    /* access modifiers changed from: protected */
    public void c1(Exception exc) {
        Log.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.S0.C(exc);
    }

    /* access modifiers changed from: protected */
    public void d1(String str, MediaCodecAdapter.Configuration configuration, long j2, long j3) {
        this.S0.k(str, j2, j3);
        this.Y0 = R1(str);
        this.Z0 = ((MediaCodecInfo) Assertions.f(C0())).n();
        n2();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat d2(Format format, String str, CodecMaxValues codecMaxValues, float f2, boolean z2, int i2) {
        Pair<Integer, Integer> r2;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.f4021t);
        mediaFormat.setInteger("height", format.f4022u);
        MediaFormatUtil.e(mediaFormat, format.f4018q);
        MediaFormatUtil.c(mediaFormat, "frame-rate", format.f4023v);
        MediaFormatUtil.d(mediaFormat, "rotation-degrees", format.f4024w);
        MediaFormatUtil.b(mediaFormat, format.A);
        if ("video/dolby-vision".equals(format.f4015n) && (r2 = MediaCodecUtil.r(format)) != null) {
            MediaFormatUtil.d(mediaFormat, Scopes.PROFILE, ((Integer) r2.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.f7676a);
        mediaFormat.setInteger("max-height", codecMaxValues.f7677b);
        MediaFormatUtil.d(mediaFormat, "max-input-size", codecMaxValues.f7678c);
        int i3 = Util.f4714a;
        if (i3 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (z2) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i2 != 0) {
            S1(mediaFormat, i2);
        }
        if (i3 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.f7673r1));
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public void e1(String str) {
        this.S0.l(str);
    }

    /* access modifiers changed from: protected */
    public boolean e2(long j2, boolean z2) throws ExoPlaybackException {
        int b02 = b0(j2);
        if (b02 == 0) {
            return false;
        }
        if (z2) {
            DecoderCounters decoderCounters = this.K0;
            decoderCounters.f5153d += b02;
            decoderCounters.f5155f += this.f7667l1;
        } else {
            this.K0.f5159j++;
            I2(b02, this.f7667l1);
        }
        x0();
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.u(false);
        }
        return true;
    }

    public void f(long j2, long j3) throws ExoPlaybackException {
        super.f(j2, j3);
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            try {
                videoSink.f(j2, j3);
            } catch (VideoSink.VideoSinkException e2) {
                throw E(e2, e2.f7760b, 7001);
            }
        }
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation f0(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i2;
        DecoderReuseEvaluation e2 = mediaCodecInfo.e(format, format2);
        int i3 = e2.f5166e;
        CodecMaxValues codecMaxValues = (CodecMaxValues) Assertions.f(this.X0);
        if (format2.f4021t > codecMaxValues.f7676a || format2.f4022u > codecMaxValues.f7677b) {
            i3 |= UserVerificationMethods.USER_VERIFY_HANDPRINT;
        }
        if (b2(mediaCodecInfo, format2) > codecMaxValues.f7678c) {
            i3 |= 64;
        }
        int i4 = i3;
        String str = mediaCodecInfo.f6687a;
        if (i4 != 0) {
            i2 = 0;
        } else {
            i2 = e2.f5165d;
        }
        return new DecoderReuseEvaluation(str, format, format2, i2, i4);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation f1(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation f12 = super.f1(formatHolder);
        this.S0.p((Format) Assertions.f(formatHolder.f5385b), f12);
        return f12;
    }

    /* access modifiers changed from: protected */
    public void g1(Format format, MediaFormat mediaFormat) {
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        MediaCodecAdapter A0 = A0();
        if (A0 != null) {
            A0.d(this.f7663h1);
        }
        int i6 = 0;
        if (this.f7674s1) {
            i2 = format.f4021t;
            i3 = format.f4022u;
        } else {
            Assertions.f(mediaFormat);
            if (!mediaFormat.containsKey("crop-right") || !mediaFormat.containsKey("crop-left") || !mediaFormat.containsKey("crop-bottom") || !mediaFormat.containsKey("crop-top")) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                i4 = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                i4 = mediaFormat.getInteger("width");
            }
            if (z2) {
                i5 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                i5 = mediaFormat.getInteger("height");
            }
            int i7 = i4;
            i3 = i5;
            i2 = i7;
        }
        float f2 = format.f4025x;
        if (Q1()) {
            int i8 = format.f4024w;
            if (i8 == 90 || i8 == 270) {
                f2 = 1.0f / f2;
                int i9 = i3;
                i3 = i2;
                i2 = i9;
            }
        } else if (this.f7656a1 == null) {
            i6 = format.f4024w;
        }
        this.f7671p1 = new VideoSize(i2, i3, i6, f2);
        if (this.f7656a1 != null) {
            s2();
            this.f7656a1.j(1, format.a().v0(i2).Y(i3).n0(i6).k0(f2).K());
            return;
        }
        this.V0.p(format.f4023v);
    }

    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public void h() {
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.h();
        } else {
            this.V0.a();
        }
    }

    /* access modifiers changed from: protected */
    public void i1(long j2) {
        super.i1(j2);
        if (!this.f7674s1) {
            this.f7667l1--;
        }
    }

    public boolean isReady() {
        boolean z2;
        PlaceholderSurface placeholderSurface;
        VideoSink videoSink;
        if (!super.isReady() || ((videoSink = this.f7656a1) != null && !videoSink.isReady())) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || (((placeholderSurface = this.f7660e1) == null || this.f7659d1 != placeholderSurface) && A0() != null && !this.f7674s1)) {
            return this.V0.d(z2);
        }
        return true;
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 1) {
            y2(obj);
        } else if (i2 == 7) {
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) Assertions.f(obj);
            this.v1 = videoFrameMetadataListener;
            VideoSink videoSink = this.f7656a1;
            if (videoSink != null) {
                videoSink.d(videoFrameMetadataListener);
            }
        } else if (i2 == 10) {
            int intValue = ((Integer) Assertions.f(obj)).intValue();
            if (this.t1 != intValue) {
                this.t1 = intValue;
                if (this.f7674s1) {
                    r1();
                }
            }
        } else if (i2 == 16) {
            this.f7673r1 = ((Integer) Assertions.f(obj)).intValue();
            H2();
        } else if (i2 == 4) {
            this.f7663h1 = ((Integer) Assertions.f(obj)).intValue();
            MediaCodecAdapter A0 = A0();
            if (A0 != null) {
                A0.d(this.f7663h1);
            }
        } else if (i2 == 5) {
            this.V0.n(((Integer) Assertions.f(obj)).intValue());
        } else if (i2 == 13) {
            A2((List) Assertions.f(obj));
        } else if (i2 != 14) {
            super.j(i2, obj);
        } else {
            Size size = (Size) Assertions.f(obj);
            if (size.b() != 0 && size.a() != 0) {
                this.f7661f1 = size;
                VideoSink videoSink2 = this.f7656a1;
                if (videoSink2 != null) {
                    videoSink2.p((Surface) Assertions.j(this.f7659d1), size);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void j1() {
        super.j1();
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.k(K0(), W1());
        } else {
            this.V0.j();
        }
        n2();
    }

    /* access modifiers changed from: protected */
    public void k1(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z2 = this.f7674s1;
        if (!z2) {
            this.f7667l1++;
        }
        if (Util.f4714a < 23 && z2) {
            q2(decoderInputBuffer.f5069f);
        }
    }

    /* access modifiers changed from: protected */
    public void l1(Format format) throws ExoPlaybackException {
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null && !videoSink.isInitialized()) {
            try {
                this.f7656a1.m(format);
            } catch (VideoSink.VideoSinkException e2) {
                throw E(e2, format, 7000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean n1(long j2, long j3, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z2, boolean z3, Format format) throws ExoPlaybackException {
        MediaCodecAdapter mediaCodecAdapter2 = mediaCodecAdapter;
        int i5 = i2;
        boolean z4 = z3;
        Assertions.f(mediaCodecAdapter);
        long K0 = j4 - K0();
        int c2 = this.V0.c(j4, j2, j3, L0(), z3, this.W0);
        if (c2 == 4) {
            return false;
        }
        if (!z2 || z4) {
            long j5 = K0;
            if (this.f7659d1 != this.f7660e1 || this.f7656a1 != null) {
                VideoSink videoSink = this.f7656a1;
                if (videoSink != null) {
                    try {
                        videoSink.f(j2, j3);
                        long e2 = this.f7656a1.e(j4 + W1(), z4);
                        if (e2 == -9223372036854775807L) {
                            return false;
                        }
                        v2(mediaCodecAdapter, i2, j5, e2);
                        return true;
                    } catch (VideoSink.VideoSinkException e3) {
                        VideoSink.VideoSinkException videoSinkException = e3;
                        throw E(videoSinkException, videoSinkException.f7760b, 7001);
                    }
                } else if (c2 == 0) {
                    long nanoTime = G().nanoTime();
                    o2(j5, nanoTime, format);
                    v2(mediaCodecAdapter, i2, j5, nanoTime);
                    J2(this.W0.f());
                    return true;
                } else if (c2 == 1) {
                    return j2((MediaCodecAdapter) Assertions.j(mediaCodecAdapter), i2, j5, format);
                } else {
                    if (c2 == 2) {
                        U1(mediaCodecAdapter2, i5, j5);
                        J2(this.W0.f());
                        return true;
                    } else if (c2 == 3) {
                        G2(mediaCodecAdapter2, i5, j5);
                        J2(this.W0.f());
                        return true;
                    } else if (c2 == 5) {
                        return false;
                    } else {
                        throw new IllegalStateException(String.valueOf(c2));
                    }
                }
            } else if (this.W0.f() >= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                return false;
            } else {
                G2(mediaCodecAdapter2, i5, j5);
                J2(this.W0.f());
                return true;
            }
        } else {
            G2(mediaCodecAdapter2, i5, K0);
            return true;
        }
    }

    public void o(float f2, float f3) throws ExoPlaybackException {
        super.o(f2, f3);
        VideoSink videoSink = this.f7656a1;
        if (videoSink != null) {
            videoSink.setPlaybackSpeed(f2);
        } else {
            this.V0.r(f2);
        }
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException o0(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.f7659d1);
    }

    /* access modifiers changed from: protected */
    public void q2(long j2) throws ExoPlaybackException {
        K1(j2);
        i2(this.f7671p1);
        this.K0.f5154e++;
        g2();
        i1(j2);
    }

    /* access modifiers changed from: protected */
    public void s2() {
    }

    /* access modifiers changed from: protected */
    public void t1() {
        super.t1();
        this.f7667l1 = 0;
    }

    /* access modifiers changed from: protected */
    public void u2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        TraceUtil.a("releaseOutputBuffer");
        mediaCodecAdapter.l(i2, true);
        TraceUtil.b();
        this.K0.f5154e++;
        this.f7666k1 = 0;
        if (this.f7656a1 == null) {
            i2(this.f7671p1);
            g2();
        }
    }

    /* access modifiers changed from: protected */
    public void w2(MediaCodecAdapter mediaCodecAdapter, int i2, long j2, long j3) {
        TraceUtil.a("releaseOutputBuffer");
        mediaCodecAdapter.i(i2, j3);
        TraceUtil.b();
        this.K0.f5154e++;
        this.f7666k1 = 0;
        if (this.f7656a1 == null) {
            i2(this.f7671p1);
            g2();
        }
    }

    public boolean y(long j2, long j3) {
        return D2(j2, j3);
    }

    public boolean z(long j2, long j3, long j4, boolean z2, boolean z3) throws ExoPlaybackException {
        if (!B2(j2, j4, z2) || !e2(j3, z3)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void z2(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.f(surface);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j2, boolean z2, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2, float f2) {
        this(context, factory, mediaCodecSelector, j2, z2, handler, videoRendererEventListener, i2, f2, (VideoSinkProvider) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j2, boolean z2, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2, float f2, VideoSinkProvider videoSinkProvider) {
        super(2, factory, mediaCodecSelector, z2, f2);
        VideoSinkProvider videoSinkProvider2 = videoSinkProvider;
        Context applicationContext = context.getApplicationContext();
        this.P0 = applicationContext;
        this.T0 = i2;
        this.Q0 = videoSinkProvider2;
        Handler handler2 = handler;
        this.S0 = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.R0 = videoSinkProvider2 == null;
        if (videoSinkProvider2 == null) {
            long j3 = j2;
            this.V0 = new VideoFrameReleaseControl(applicationContext, this, j2);
        } else {
            this.V0 = videoSinkProvider.a();
        }
        this.W0 = new VideoFrameReleaseControl.FrameReleaseInfo();
        this.U0 = T1();
        this.f7661f1 = Size.f4698c;
        this.f7663h1 = 1;
        this.f7671p1 = VideoSize.f4483e;
        this.t1 = 0;
        this.f7672q1 = null;
        this.f7673r1 = MaxErrorCode.NETWORK_ERROR;
    }
}
