package com.movie.ui.activity;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class BaseActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private BaseActivity f31996a;

    public BaseActivity_ViewBinding(BaseActivity baseActivity, View view) {
        this.f31996a = baseActivity;
        baseActivity.mToolbar = (Toolbar) Utils.findOptionalViewAsType(view, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    }

    public void unbind() {
        BaseActivity baseActivity = this.f31996a;
        if (baseActivity != null) {
            this.f31996a = null;
            baseActivity.mToolbar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
