package com.facebook.react.views.switchview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import androidx.appcompat.widget.SwitchCompat;

class ReactSwitch extends SwitchCompat {
    private boolean mAllowChange = true;
    private Integer mTrackColorForFalse = null;
    private Integer mTrackColorForTrue = null;

    public ReactSwitch(Context context) {
        super(context);
    }

    private ColorStateList createRippleDrawableColorStateList(Integer num) {
        return new ColorStateList(new int[][]{new int[]{16842919}}, new int[]{num.intValue()});
    }

    public void setBackgroundColor(int i2) {
        setBackground(new RippleDrawable(createRippleDrawableColorStateList(Integer.valueOf(i2)), new ColorDrawable(i2), (Drawable) null));
    }

    public void setChecked(boolean z2) {
        if (!this.mAllowChange || isChecked() == z2) {
            super.setChecked(isChecked());
            return;
        }
        this.mAllowChange = false;
        super.setChecked(z2);
        setTrackColor(z2);
    }

    /* access modifiers changed from: package-private */
    public void setColor(Drawable drawable, Integer num) {
        if (num == null) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(num.intValue(), PorterDuff.Mode.MULTIPLY);
        }
    }

    /* access modifiers changed from: package-private */
    public void setOn(boolean z2) {
        if (isChecked() != z2) {
            super.setChecked(z2);
            setTrackColor(z2);
        }
        this.mAllowChange = true;
    }

    public void setThumbColor(Integer num) {
        setColor(super.getThumbDrawable(), num);
        if (num != null && (super.getBackground() instanceof RippleDrawable)) {
            ((RippleDrawable) super.getBackground()).setColor(createRippleDrawableColorStateList(num));
        }
    }

    public void setTrackColor(Integer num) {
        setColor(super.getTrackDrawable(), num);
    }

    public void setTrackColorForFalse(Integer num) {
        if (num != this.mTrackColorForFalse) {
            this.mTrackColorForFalse = num;
            if (!isChecked()) {
                setTrackColor(this.mTrackColorForFalse);
            }
        }
    }

    public void setTrackColorForTrue(Integer num) {
        if (num != this.mTrackColorForTrue) {
            this.mTrackColorForTrue = num;
            if (isChecked()) {
                setTrackColor(this.mTrackColorForTrue);
            }
        }
    }

    private void setTrackColor(boolean z2) {
        Integer num = this.mTrackColorForTrue;
        if (num != null || this.mTrackColorForFalse != null) {
            if (!z2) {
                num = this.mTrackColorForFalse;
            }
            setTrackColor(num);
        }
    }
}
