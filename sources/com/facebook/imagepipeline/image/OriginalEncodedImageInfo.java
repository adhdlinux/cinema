package com.facebook.imagepipeline.image;

import android.net.Uri;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class OriginalEncodedImageInfo {
    public static final OriginalEncodedImageInfo EMPTY = new OriginalEncodedImageInfo();
    private final Object mCallerContext;
    private final int mHeight;
    private final EncodedImageOrigin mOrigin;
    private final int mSize;
    private final Uri mUri;
    private final int mWidth;

    private OriginalEncodedImageInfo() {
        this.mUri = null;
        this.mOrigin = EncodedImageOrigin.NOT_SET;
        this.mCallerContext = null;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSize = -1;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public EncodedImageOrigin getOrigin() {
        return this.mOrigin;
    }

    public int getSize() {
        return this.mSize;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public OriginalEncodedImageInfo(Uri uri, EncodedImageOrigin encodedImageOrigin, Object obj, int i2, int i3, int i4) {
        this.mUri = uri;
        this.mOrigin = encodedImageOrigin;
        this.mCallerContext = obj;
        this.mWidth = i2;
        this.mHeight = i3;
        this.mSize = i4;
    }
}
