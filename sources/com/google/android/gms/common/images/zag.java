package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

public abstract class zag {
    final zad zaa;
    protected int zab = 0;

    public zag(Uri uri, int i2) {
        this.zaa = new zad(uri);
        this.zab = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zaa(Drawable drawable, boolean z2, boolean z3, boolean z4);

    /* access modifiers changed from: package-private */
    public final void zab(Context context, zam zam, boolean z2) {
        Drawable drawable;
        int i2 = this.zab;
        if (i2 != 0) {
            drawable = context.getResources().getDrawable(i2);
        } else {
            drawable = null;
        }
        zaa(drawable, z2, false, false);
    }

    /* access modifiers changed from: package-private */
    public final void zac(Context context, Bitmap bitmap, boolean z2) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
