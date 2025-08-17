package androidx.media3.decoder.av1;

import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.decoder.VideoDecoderOutputBuffer;

public final /* synthetic */ class a implements DecoderOutputBuffer.Owner {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Gav1Decoder f5100a;

    public /* synthetic */ a(Gav1Decoder gav1Decoder) {
        this.f5100a = gav1Decoder;
    }

    public final void a(DecoderOutputBuffer decoderOutputBuffer) {
        this.f5100a.A((VideoDecoderOutputBuffer) decoderOutputBuffer);
    }
}
