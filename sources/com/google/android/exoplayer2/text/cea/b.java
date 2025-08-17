package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder;

public final /* synthetic */ class b implements DecoderOutputBuffer.Owner {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CeaDecoder f27363a;

    public /* synthetic */ b(CeaDecoder ceaDecoder) {
        this.f27363a = ceaDecoder;
    }

    public final void a(DecoderOutputBuffer decoderOutputBuffer) {
        this.f27363a.n((CeaDecoder.CeaOutputBuffer) decoderOutputBuffer);
    }
}
