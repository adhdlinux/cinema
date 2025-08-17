package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import okio.Source;

public abstract class RequestHandler {

    public static final class Result {
        private final Bitmap bitmap;
        private final int exifOrientation;
        private final Picasso.LoadedFrom loadedFrom;
        private final Source source;

        public Result(Bitmap bitmap2, Picasso.LoadedFrom loadedFrom2) {
            this((Bitmap) Utils.checkNotNull(bitmap2, "bitmap == null"), (Source) null, loadedFrom2, 0);
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        /* access modifiers changed from: package-private */
        public int getExifOrientation() {
            return this.exifOrientation;
        }

        public Picasso.LoadedFrom getLoadedFrom() {
            return this.loadedFrom;
        }

        public Source getSource() {
            return this.source;
        }

        public Result(Source source2, Picasso.LoadedFrom loadedFrom2) {
            this((Bitmap) null, (Source) Utils.checkNotNull(source2, "source == null"), loadedFrom2, 0);
        }

        Result(Bitmap bitmap2, Source source2, Picasso.LoadedFrom loadedFrom2, int i2) {
            if ((bitmap2 != null) != (source2 == null ? false : true)) {
                this.bitmap = bitmap2;
                this.source = source2;
                this.loadedFrom = (Picasso.LoadedFrom) Utils.checkNotNull(loadedFrom2, "loadedFrom == null");
                this.exifOrientation = i2;
                return;
            }
            throw new AssertionError();
        }
    }

    static void calculateInSampleSize(int i2, int i3, BitmapFactory.Options options, Request request) {
        calculateInSampleSize(i2, i3, options.outWidth, options.outHeight, options, request);
    }

    static BitmapFactory.Options createBitmapOptions(Request request) {
        boolean z2;
        boolean hasSize = request.hasSize();
        if (request.config != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!hasSize && !z2 && !request.purgeable) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = hasSize;
        boolean z3 = request.purgeable;
        options.inInputShareable = z3;
        options.inPurgeable = z3;
        if (z2) {
            options.inPreferredConfig = request.config;
        }
        return options;
    }

    static boolean requiresInSampleSize(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public abstract boolean canHandleRequest(Request request);

    /* access modifiers changed from: package-private */
    public int getRetryCount() {
        return 0;
    }

    public abstract Result load(Request request, int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public boolean shouldRetry(boolean z2, NetworkInfo networkInfo) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsReplay() {
        return false;
    }

    static void calculateInSampleSize(int i2, int i3, int i4, int i5, BitmapFactory.Options options, Request request) {
        int i6;
        double floor;
        if (i5 > i3 || i4 > i2) {
            if (i3 == 0) {
                floor = Math.floor((double) (((float) i4) / ((float) i2)));
            } else if (i2 == 0) {
                floor = Math.floor((double) (((float) i5) / ((float) i3)));
            } else {
                int floor2 = (int) Math.floor((double) (((float) i5) / ((float) i3)));
                int floor3 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                i6 = request.centerInside ? Math.max(floor2, floor3) : Math.min(floor2, floor3);
            }
            i6 = (int) floor;
        } else {
            i6 = 1;
        }
        options.inSampleSize = i6;
        options.inJustDecodeBounds = false;
    }
}
