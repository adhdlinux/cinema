package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zal;
import java.lang.ref.WeakReference;

public final class zae extends zag {
    private final WeakReference zac;

    public zae(ImageView imageView, int i2) {
        super(Uri.EMPTY, i2);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference(imageView);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zae)) {
            return false;
        }
        ImageView imageView = (ImageView) this.zac.get();
        ImageView imageView2 = (ImageView) ((zae) obj).zac.get();
        if (imageView2 == null || imageView == null || !Objects.equal(imageView2, imageView)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void zaa(Drawable drawable, boolean z2, boolean z3, boolean z4) {
        ImageView imageView = (ImageView) this.zac.get();
        if (imageView == null) {
            return;
        }
        if (z3 || z4 || !(imageView instanceof zal)) {
            boolean z5 = false;
            if (!z3 && !z2) {
                z5 = true;
            }
            if (z5) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof zak) {
                    drawable2 = ((zak) drawable2).zaa();
                }
                drawable = new zak(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zal) {
                zal zal = (zal) imageView;
                throw null;
            } else if (drawable != null && z5) {
                ((zak) drawable).zab(250);
            }
        } else {
            zal zal2 = (zal) imageView;
            throw null;
        }
    }

    public zae(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference(imageView);
    }
}
