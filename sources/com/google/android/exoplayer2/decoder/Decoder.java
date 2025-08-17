package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.DecoderException;

public interface Decoder<I, O, E extends DecoderException> {
    O a() throws DecoderException;

    void c(I i2) throws DecoderException;

    I d() throws DecoderException;

    void flush();

    void release();
}
