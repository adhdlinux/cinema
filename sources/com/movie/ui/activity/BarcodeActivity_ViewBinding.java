package com.movie.ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.internal.Utils;
import com.movie.ui.widget.AspectLockedImageView;
import com.yoku.marumovie.R;

public class BarcodeActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private BarcodeActivity f31995b;

    public BarcodeActivity_ViewBinding(BarcodeActivity barcodeActivity, View view) {
        super(barcodeActivity, view);
        this.f31995b = barcodeActivity;
        barcodeActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        barcodeActivity.tvText = (TextView) Utils.findRequiredViewAsType(view, R.id.tvText, "field 'tvText'", TextView.class);
        barcodeActivity.imgbarcode = (AspectLockedImageView) Utils.findRequiredViewAsType(view, R.id.imgbarcode, "field 'imgbarcode'", AspectLockedImageView.class);
    }

    public void unbind() {
        BarcodeActivity barcodeActivity = this.f31995b;
        if (barcodeActivity != null) {
            this.f31995b = null;
            barcodeActivity.toolbar = null;
            barcodeActivity.tvText = null;
            barcodeActivity.imgbarcode = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
