package androidx.media3.decoder.av1;

import android.os.Handler;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.video.DecoderVideoRenderer;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import e.x;

public class Libgav1VideoRenderer extends DecoderVideoRenderer {

    /* renamed from: d0  reason: collision with root package name */
    private static final int f5095d0 = (((Util.k(1280, 64) * Util.k(720, 64)) * 6144) / 2);

    /* renamed from: e0  reason: collision with root package name */
    public static final /* synthetic */ int f5096e0 = 0;
    private final int Z;

    /* renamed from: a0  reason: collision with root package name */
    private final int f5097a0;

    /* renamed from: b0  reason: collision with root package name */
    private final int f5098b0;

    /* renamed from: c0  reason: collision with root package name */
    private Gav1Decoder f5099c0;

    public Libgav1VideoRenderer(long j2, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2) {
        this(j2, handler, videoRendererEventListener, i2, 0, 4, 4);
    }

    /* access modifiers changed from: protected */
    public void C0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws Gav1DecoderException {
        Gav1Decoder gav1Decoder = this.f5099c0;
        if (gav1Decoder != null) {
            gav1Decoder.B(videoDecoderOutputBuffer, surface);
            videoDecoderOutputBuffer.release();
            return;
        }
        throw new Gav1DecoderException("Failed to render output buffer to surface: decoder is not initialized.");
    }

    /* access modifiers changed from: protected */
    public void E0(int i2) {
        Gav1Decoder gav1Decoder = this.f5099c0;
        if (gav1Decoder != null) {
            gav1Decoder.C(i2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: O0 */
    public final Gav1Decoder d0(Format format, CryptoConfig cryptoConfig) throws Gav1DecoderException {
        TraceUtil.a("createGav1Decoder");
        int i2 = format.f4016o;
        if (i2 == -1) {
            i2 = f5095d0;
        }
        Gav1Decoder gav1Decoder = new Gav1Decoder(this.Z, this.f5097a0, i2, this.f5098b0);
        this.f5099c0 = gav1Decoder;
        TraceUtil.b();
        return gav1Decoder;
    }

    public final int c(Format format) {
        if (!"video/av01".equalsIgnoreCase(format.f4015n) || !Gav1Library.a()) {
            return x.a(0);
        }
        if (format.K != 0) {
            return x.a(2);
        }
        return x.b(4, 16, 0);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation c0(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 3, 0);
    }

    public String getName() {
        return "Libgav1VideoRenderer";
    }

    public Libgav1VideoRenderer(long j2, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2, int i3, int i4, int i5) {
        super(j2, handler, videoRendererEventListener, i2);
        this.f5098b0 = i3;
        this.Z = i4;
        this.f5097a0 = i5;
    }
}
