package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {

    /* renamed from: f  reason: collision with root package name */
    public static final Option<DecodeFormat> f16838f = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f16289d);

    /* renamed from: g  reason: collision with root package name */
    public static final Option<PreferredColorSpace> f16839g = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final Option<DownsampleStrategy> f16840h = DownsampleStrategy.f16833h;

    /* renamed from: i  reason: collision with root package name */
    public static final Option<Boolean> f16841i;

    /* renamed from: j  reason: collision with root package name */
    public static final Option<Boolean> f16842j;

    /* renamed from: k  reason: collision with root package name */
    private static final Set<String> f16843k = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: l  reason: collision with root package name */
    private static final DecodeCallbacks f16844l = new DecodeCallbacks() {
        public void a(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void b() {
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f16845m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: n  reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f16846n = Util.e(0);

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f16847a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f16848b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f16849c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f16850d;

    /* renamed from: e  reason: collision with root package name */
    private final HardwareConfigState f16851e = HardwareConfigState.a();

    public interface DecodeCallbacks {
        void a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f16841i = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f16842j = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f16850d = list;
        this.f16848b = (DisplayMetrics) Preconditions.d(displayMetrics);
        this.f16847a = (BitmapPool) Preconditions.d(bitmapPool);
        this.f16849c = (ArrayPool) Preconditions.d(arrayPool);
    }

    private static int a(double d2) {
        int l2 = l(d2);
        int x2 = x(((double) l2) * d2);
        return x((d2 / ((double) (((float) x2) / ((float) l2)))) * ((double) x2));
    }

    private void b(ImageReader imageReader, DecodeFormat decodeFormat, boolean z2, boolean z3, BitmapFactory.Options options, int i2, int i3) {
        boolean z4;
        Bitmap.Config config;
        if (!this.f16851e.e(i2, i3, options, z2, z3)) {
            if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                try {
                    z4 = imageReader.d().hasAlpha();
                } catch (IOException e2) {
                    if (Log.isLoggable("Downsampler", 3)) {
                        Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                    }
                    z4 = false;
                }
                if (z4) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                options.inPreferredConfig = config;
                if (config == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                    return;
                }
                return;
            }
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        double d2;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        int i16 = i6;
        BitmapFactory.Options options2 = options;
        if (i13 <= 0 || i14 <= 0) {
            String str = "Downsampler";
            String str2 = "x";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to determine dimensions for: " + imageType2 + " with target [" + i15 + str2 + i16 + "]");
                return;
            }
            return;
        }
        if (r(i2)) {
            i7 = i13;
            i8 = i14;
        } else {
            i8 = i13;
            i7 = i14;
        }
        float b2 = downsampleStrategy2.b(i8, i7, i15, i16);
        if (b2 > 0.0f) {
            DownsampleStrategy.SampleSizeRounding a2 = downsampleStrategy2.a(i8, i7, i15, i16);
            if (a2 != null) {
                float f2 = (float) i8;
                float f3 = (float) i7;
                int x2 = i8 / x((double) (b2 * f2));
                int x3 = i7 / x((double) (b2 * f3));
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                if (a2 == sampleSizeRounding) {
                    i9 = Math.max(x2, x3);
                } else {
                    i9 = Math.min(x2, x3);
                }
                int i17 = Build.VERSION.SDK_INT;
                String str3 = "x";
                String str4 = "Downsampler";
                if (i17 > 23 || !f16843k.contains(options2.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(i9));
                    if (a2 == sampleSizeRounding && ((float) max) < 1.0f / b2) {
                        max <<= 1;
                    }
                    i10 = max;
                } else {
                    i10 = 1;
                }
                options2.inSampleSize = i10;
                if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                    float min = (float) Math.min(i10, 8);
                    i11 = (int) Math.ceil((double) (f2 / min));
                    i12 = (int) Math.ceil((double) (f3 / min));
                    int i18 = i10 / 8;
                    if (i18 > 0) {
                        i11 /= i18;
                        i12 /= i18;
                    }
                } else {
                    if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                        float f4 = (float) i10;
                        i11 = (int) Math.floor((double) (f2 / f4));
                        d2 = Math.floor((double) (f3 / f4));
                    } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                        if (i17 >= 24) {
                            float f5 = (float) i10;
                            i11 = Math.round(f2 / f5);
                            i12 = Math.round(f3 / f5);
                        } else {
                            float f6 = (float) i10;
                            i11 = (int) Math.floor((double) (f2 / f6));
                            d2 = Math.floor((double) (f3 / f6));
                        }
                    } else if (i8 % i10 == 0 && i7 % i10 == 0) {
                        i11 = i8 / i10;
                        i12 = i7 / i10;
                    } else {
                        int[] m2 = m(imageReader, options2, decodeCallbacks, bitmapPool);
                        i11 = m2[0];
                        i12 = m2[1];
                    }
                    i12 = (int) d2;
                }
                double b3 = (double) downsampleStrategy2.b(i11, i12, i15, i16);
                options2.inTargetDensity = a(b3);
                options2.inDensity = l(b3);
                if (s(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                String str5 = str4;
                if (Log.isLoggable(str5, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculate scaling, source: [");
                    sb.append(i3);
                    String str6 = str3;
                    sb.append(str6);
                    sb.append(i4);
                    sb.append("], degreesToRotate: ");
                    sb.append(i2);
                    sb.append(", target: [");
                    sb.append(i15);
                    sb.append(str6);
                    sb.append(i16);
                    sb.append("], power of two scaled: [");
                    sb.append(i11);
                    sb.append(str6);
                    sb.append(i12);
                    sb.append("], exact scale factor: ");
                    sb.append(b2);
                    sb.append(", power of 2 sample size: ");
                    sb.append(i10);
                    sb.append(", adjusted scale factor: ");
                    sb.append(b3);
                    sb.append(", target density: ");
                    sb.append(options2.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options2.inDensity);
                    Log.v(str5, sb.toString());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        int i19 = i13;
        String str7 = "x";
        throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + downsampleStrategy2 + ", source: [" + i19 + str7 + i14 + "], target: [" + i15 + str7 + i16 + "]");
    }

    private Resource<Bitmap> e(ImageReader imageReader, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        boolean z2;
        Options options2 = options;
        byte[] bArr = (byte[]) this.f16849c.c(65536, byte[].class);
        BitmapFactory.Options k2 = k();
        k2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.c(f16838f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.c(f16839g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.c(DownsampleStrategy.f16833h);
        boolean booleanValue = ((Boolean) options2.c(f16841i)).booleanValue();
        Option option = f16842j;
        if (options2.c(option) == null || !((Boolean) options2.c(option)).booleanValue()) {
            z2 = false;
        } else {
            z2 = true;
        }
        try {
            return BitmapResource.c(h(imageReader, k2, downsampleStrategy, decodeFormat, preferredColorSpace, z2, i2, i3, booleanValue, decodeCallbacks), this.f16847a);
        } finally {
            v(k2);
            this.f16849c.put(bArr);
        }
    }

    private Bitmap h(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z2, int i2, int i3, boolean z3, DecodeCallbacks decodeCallbacks) throws IOException {
        boolean z4;
        int i4;
        int i5;
        int i6;
        String str;
        int i7;
        ColorSpace.Named named;
        int i8;
        int i9;
        float f2;
        BitmapFactory.Options options2 = options;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long b2 = LogTime.b();
        int[] m2 = m(imageReader, options2, decodeCallbacks2, this.f16847a);
        boolean z5 = false;
        int i10 = m2[0];
        int i11 = m2[1];
        String str2 = options2.outMimeType;
        if (i10 == -1 || i11 == -1) {
            z4 = false;
        } else {
            z4 = z2;
        }
        int c2 = imageReader.c();
        int g2 = TransformationUtils.g(c2);
        boolean j2 = TransformationUtils.j(c2);
        int i12 = i2;
        if (i12 == Integer.MIN_VALUE) {
            i5 = i3;
            if (r(g2)) {
                i4 = i11;
            } else {
                i4 = i10;
            }
        } else {
            i5 = i3;
            i4 = i12;
        }
        if (i5 != Integer.MIN_VALUE) {
            i6 = i5;
        } else if (r(g2)) {
            i6 = i10;
        } else {
            i6 = i11;
        }
        ImageHeaderParser.ImageType d2 = imageReader.d();
        ImageHeaderParser.ImageType imageType = d2;
        c(d2, imageReader, decodeCallbacks, this.f16847a, downsampleStrategy, g2, i10, i11, i4, i6, options);
        int i13 = c2;
        String str3 = str2;
        int i14 = i11;
        int i15 = i10;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        BitmapFactory.Options options3 = options2;
        b(imageReader, decodeFormat, z4, j2, options, i4, i6);
        int i16 = Build.VERSION.SDK_INT;
        int i17 = options3.inSampleSize;
        if (z(imageType)) {
            if (i15 < 0 || i14 < 0 || !z3) {
                if (s(options)) {
                    f2 = ((float) options3.inTargetDensity) / ((float) options3.inDensity);
                } else {
                    f2 = 1.0f;
                }
                int i18 = options3.inSampleSize;
                float f3 = (float) i18;
                i9 = Math.round(((float) ((int) Math.ceil((double) (((float) i15) / f3)))) * f2);
                i8 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f3)))) * f2);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Calculated target [" + i9 + "x" + i8 + "] for source [" + i15 + "x" + i14 + "], sampleSize: " + i18 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f2);
                }
            } else {
                str = "Downsampler";
                i9 = i4;
                i8 = i6;
            }
            if (i9 > 0 && i8 > 0) {
                y(options3, this.f16847a, i9, i8);
            }
        } else {
            str = "Downsampler";
        }
        if (i16 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && options.outColorSpace != null && options.outColorSpace.isWideGamut()) {
                z5 = true;
            }
            if (z5) {
                named = ColorSpace.Named.DISPLAY_P3;
            } else {
                named = ColorSpace.Named.SRGB;
            }
            options3.inPreferredColorSpace = ColorSpace.get(named);
        } else if (i16 >= 26) {
            options3.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap i19 = i(imageReader, options3, decodeCallbacks3, this.f16847a);
        decodeCallbacks3.a(this.f16847a, i19);
        if (Log.isLoggable(str, 2)) {
            i7 = i13;
            t(i15, i14, str3, options, i19, i2, i3, b2);
        } else {
            i7 = i13;
        }
        if (i19 == null) {
            return null;
        }
        i19.setDensity(this.f16848b.densityDpi);
        Bitmap k2 = TransformationUtils.k(this.f16847a, i19, i7);
        if (i19.equals(k2)) {
            return k2;
        }
        this.f16847a.c(i19);
        return k2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap i(com.bumptech.glide.load.resource.bitmap.ImageReader r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto L_0x000c
            r7.b()
            r5.b()
        L_0x000c:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.f()
            r4.lock()
            android.graphics.Bitmap r5 = r5.a(r6)     // Catch:{ IllegalArgumentException -> 0x0027 }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.f()
            r6.unlock()
            return r5
        L_0x0025:
            r5 = move-exception
            goto L_0x0050
        L_0x0027:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch:{ all -> 0x0025 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0025 }
        L_0x0038:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x004f
            r8.c(r0)     // Catch:{ IOException -> 0x004e }
            r0 = 0
            r6.inBitmap = r0     // Catch:{ IOException -> 0x004e }
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch:{ IOException -> 0x004e }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.f()
            r6.unlock()
            return r5
        L_0x004e:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x004f:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0050:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.f()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.i(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = f16846n;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    private static int l(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int[] m(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        i(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean s(android.graphics.BitmapFactory.Options r1) {
        /*
            int r0 = r1.inTargetDensity
            if (r0 <= 0) goto L_0x000c
            int r1 = r1.inDensity
            if (r1 <= 0) goto L_0x000c
            if (r0 == r1) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.s(android.graphics.BitmapFactory$Options):boolean");
    }

    private static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.a(j2));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = f16846n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d2) {
        return (int) (d2 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, BitmapPool bitmapPool, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.e(i2, i3, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public Resource<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, Options options) throws IOException {
        return e(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.f16850d, this.f16849c), i2, i3, options, f16844l);
    }

    public Resource<Bitmap> f(InputStream inputStream, int i2, int i3, Options options) throws IOException {
        return g(inputStream, i2, i3, options, f16844l);
    }

    public Resource<Bitmap> g(InputStream inputStream, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return e(new ImageReader.InputStreamImageReader(inputStream, this.f16850d, this.f16849c), i2, i3, options, decodeCallbacks);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
