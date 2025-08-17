package androidx.media3.exoplayer.image;

import androidx.media3.common.Format;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;

public interface ImageDecoder extends Decoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> {

    public interface Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final Factory f6605a = new BitmapFactoryImageDecoder.Factory();

        ImageDecoder a();

        int c(Format format);
    }

    ImageOutputBuffer a() throws ImageDecoderException;

    void f(DecoderInputBuffer decoderInputBuffer) throws ImageDecoderException;
}
