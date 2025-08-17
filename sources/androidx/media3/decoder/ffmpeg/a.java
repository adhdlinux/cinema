package androidx.media3.decoder.ffmpeg;

import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;

public final /* synthetic */ class a implements DecoderOutputBuffer.Owner {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FfmpegAudioDecoder f5112a;

    public /* synthetic */ a(FfmpegAudioDecoder ffmpegAudioDecoder) {
        this.f5112a = ffmpegAudioDecoder;
    }

    public final void a(DecoderOutputBuffer decoderOutputBuffer) {
        this.f5112a.t((SimpleDecoderOutputBuffer) decoderOutputBuffer);
    }
}
