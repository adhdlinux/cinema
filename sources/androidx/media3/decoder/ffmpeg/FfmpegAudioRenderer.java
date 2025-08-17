package androidx.media3.decoder.ffmpeg;

import android.os.Handler;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DecoderAudioRenderer;
import androidx.media3.exoplayer.audio.DefaultAudioSink;

public final class FfmpegAudioRenderer extends DecoderAudioRenderer<FfmpegAudioDecoder> {
    public FfmpegAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    private boolean A0(Format format) {
        if (!B0(format, 2)) {
            return true;
        }
        if (l0(Util.h0(4, format.B, format.C)) != 2) {
            return false;
        }
        return !"audio/ac3".equals(format.f4015n);
    }

    private boolean B0(Format format, int i2) {
        return v0(Util.h0(i2, format.B, format.C));
    }

    public String getName() {
        return "FfmpegAudioRenderer";
    }

    public int p() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public int w0(Format format) {
        String str = (String) Assertions.f(format.f4015n);
        if (!FfmpegLibrary.d() || !MimeTypes.o(str)) {
            return 0;
        }
        if (!FfmpegLibrary.e(str)) {
            return 1;
        }
        if (!B0(format, 2) && !B0(format, 4)) {
            return 1;
        }
        if (format.K != 0) {
            return 2;
        }
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y0 */
    public FfmpegAudioDecoder f0(Format format, CryptoConfig cryptoConfig) throws FfmpegDecoderException {
        int i2;
        TraceUtil.a("createFfmpegAudioDecoder");
        int i3 = format.f4016o;
        if (i3 != -1) {
            i2 = i3;
        } else {
            i2 = 5760;
        }
        FfmpegAudioDecoder ffmpegAudioDecoder = new FfmpegAudioDecoder(format, 16, 16, i2, A0(format));
        TraceUtil.b();
        return ffmpegAudioDecoder;
    }

    /* access modifiers changed from: protected */
    /* renamed from: z0 */
    public Format k0(FfmpegAudioDecoder ffmpegAudioDecoder) {
        Assertions.f(ffmpegAudioDecoder);
        return new Format.Builder().o0("audio/raw").N(ffmpegAudioDecoder.C()).p0(ffmpegAudioDecoder.F()).i0(ffmpegAudioDecoder.D()).K();
    }

    public FfmpegAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioSink) new DefaultAudioSink.Builder().l(audioProcessorArr).i());
    }

    public FfmpegAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(handler, audioRendererEventListener, audioSink);
    }
}
