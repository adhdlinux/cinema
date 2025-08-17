package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.BitmapUtil;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.exoplayer.image.ImageDecoder;
import e.x;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BitmapFactoryImageDecoder extends SimpleDecoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> implements ImageDecoder {

    /* renamed from: o  reason: collision with root package name */
    private final BitmapDecoder f6602o;

    public interface BitmapDecoder {
        Bitmap a(byte[] bArr, int i2) throws ImageDecoderException;
    }

    public static final class Factory implements ImageDecoder.Factory {

        /* renamed from: b  reason: collision with root package name */
        private final BitmapDecoder f6604b = new a();

        public int c(Format format) {
            String str = format.f4015n;
            if (str == null || !MimeTypes.p(str)) {
                return x.a(0);
            }
            if (Util.D0(format.f4015n)) {
                return x.a(4);
            }
            return x.a(1);
        }

        /* renamed from: d */
        public BitmapFactoryImageDecoder a() {
            return new BitmapFactoryImageDecoder(this.f6604b);
        }
    }

    /* access modifiers changed from: private */
    public static Bitmap B(byte[] bArr, int i2) throws ImageDecoderException {
        try {
            return BitmapUtil.a(bArr, i2, (BitmapFactory.Options) null);
        } catch (ParserException e2) {
            throw new ImageDecoderException("Could not decode image data with BitmapFactory. (data.length = " + bArr.length + ", input length = " + i2 + ")", e2);
        } catch (IOException e3) {
            throw new ImageDecoderException((Throwable) e3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public ImageDecoderException k(Throwable th) {
        return new ImageDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public ImageDecoderException l(DecoderInputBuffer decoderInputBuffer, ImageOutputBuffer imageOutputBuffer, boolean z2) {
        boolean z3;
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.f(decoderInputBuffer.f5067d);
            Assertions.h(byteBuffer.hasArray());
            if (byteBuffer.arrayOffset() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.a(z3);
            imageOutputBuffer.f6607b = this.f6602o.a(byteBuffer.array(), byteBuffer.remaining());
            imageOutputBuffer.timeUs = decoderInputBuffer.f5069f;
            return null;
        } catch (ImageDecoderException e2) {
            return e2;
        }
    }

    public /* bridge */ /* synthetic */ ImageOutputBuffer a() throws ImageDecoderException {
        return (ImageOutputBuffer) super.a();
    }

    public String getName() {
        return "BitmapFactoryImageDecoder";
    }

    /* access modifiers changed from: protected */
    public DecoderInputBuffer i() {
        return new DecoderInputBuffer(1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public ImageOutputBuffer j() {
        return new ImageOutputBuffer() {
            public void release() {
                BitmapFactoryImageDecoder.this.t(this);
            }
        };
    }

    private BitmapFactoryImageDecoder(BitmapDecoder bitmapDecoder) {
        super(new DecoderInputBuffer[1], new ImageOutputBuffer[1]);
        this.f6602o = bitmapDecoder;
    }
}
