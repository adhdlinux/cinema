package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

class GetAction extends Action<Void> {
    GetAction(Picasso picasso, Request request, int i2, int i3, Object obj, String str) {
        super(picasso, null, request, i2, i3, 0, (Drawable) null, str, obj, false);
    }

    /* access modifiers changed from: package-private */
    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
    }

    public void error(Exception exc) {
    }
}
