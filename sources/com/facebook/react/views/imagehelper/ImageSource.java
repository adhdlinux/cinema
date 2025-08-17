package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import com.facebook.infer.annotation.Assertions;
import java.util.Objects;

public class ImageSource {
    private boolean isResource;
    private double mSize;
    private String mSource;
    private Uri mUri;

    public ImageSource(Context context, String str, double d2, double d3) {
        this.mSource = str;
        this.mSize = d2 * d3;
        this.mUri = computeUri(context);
    }

    private Uri computeLocalUri(Context context) {
        this.isResource = true;
        return ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(context, this.mSource);
    }

    private Uri computeUri(Context context) {
        try {
            Uri parse = Uri.parse(this.mSource);
            if (parse.getScheme() == null) {
                return computeLocalUri(context);
            }
            return parse;
        } catch (Exception unused) {
            return computeLocalUri(context);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageSource imageSource = (ImageSource) obj;
        if (Double.compare(imageSource.mSize, this.mSize) != 0 || this.isResource != imageSource.isResource || !Objects.equals(this.mUri, imageSource.mUri) || !Objects.equals(this.mSource, imageSource.mSource)) {
            return false;
        }
        return true;
    }

    public double getSize() {
        return this.mSize;
    }

    public String getSource() {
        return this.mSource;
    }

    public Uri getUri() {
        return (Uri) Assertions.assertNotNull(this.mUri);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mUri, this.mSource, Double.valueOf(this.mSize), Boolean.valueOf(this.isResource)});
    }

    public boolean isResource() {
        return this.isResource;
    }

    public ImageSource(Context context, String str) {
        this(context, str, 0.0d, 0.0d);
    }
}
