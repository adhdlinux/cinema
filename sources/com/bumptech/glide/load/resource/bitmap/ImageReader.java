package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

interface ImageReader {

    public static final class InputStreamImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStreamRewinder f16863a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayPool f16864b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f16865c;

        InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.f16864b = (ArrayPool) Preconditions.d(arrayPool);
            this.f16865c = (List) Preconditions.d(list);
            this.f16863a = new InputStreamRewinder(inputStream, arrayPool);
        }

        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f16863a.a(), (Rect) null, options);
        }

        public void b() {
            this.f16863a.c();
        }

        public int c() throws IOException {
            return ImageHeaderParserUtils.b(this.f16865c, this.f16863a.a(), this.f16864b);
        }

        public ImageHeaderParser.ImageType d() throws IOException {
            return ImageHeaderParserUtils.e(this.f16865c, this.f16863a.a(), this.f16864b);
        }
    }

    public static final class ParcelFileDescriptorImageReader implements ImageReader {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayPool f16866a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ImageHeaderParser> f16867b;

        /* renamed from: c  reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f16868c;

        ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.f16866a = (ArrayPool) Preconditions.d(arrayPool);
            this.f16867b = (List) Preconditions.d(list);
            this.f16868c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f16868c.a().getFileDescriptor(), (Rect) null, options);
        }

        public void b() {
        }

        public int c() throws IOException {
            return ImageHeaderParserUtils.a(this.f16867b, this.f16868c, this.f16866a);
        }

        public ImageHeaderParser.ImageType d() throws IOException {
            return ImageHeaderParserUtils.d(this.f16867b, this.f16868c, this.f16866a);
        }
    }

    Bitmap a(BitmapFactory.Options options) throws IOException;

    void b();

    int c() throws IOException;

    ImageHeaderParser.ImageType d() throws IOException;
}
