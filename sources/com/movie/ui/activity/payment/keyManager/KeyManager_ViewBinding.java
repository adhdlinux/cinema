package com.movie.ui.activity.payment.keyManager;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Utils;
import com.movie.ui.activity.BaseActivity_ViewBinding;
import com.movie.ui.widget.AnimatorStateView;
import com.yoku.marumovie.R;

public class KeyManager_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private KeyManager f32334b;

    public KeyManager_ViewBinding(KeyManager keyManager, View view) {
        super(keyManager, view);
        this.f32334b = keyManager;
        keyManager.rvDeviceItems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rvDeviceItems, "field 'rvDeviceItems'", RecyclerView.class);
        keyManager.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progressBar3, "field 'loading'", ProgressBar.class);
        keyManager.view_error = (AnimatorStateView) Utils.findRequiredViewAsType(view, R.id.view_error, "field 'view_error'", AnimatorStateView.class);
        keyManager.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    public void unbind() {
        KeyManager keyManager = this.f32334b;
        if (keyManager != null) {
            this.f32334b = null;
            keyManager.rvDeviceItems = null;
            keyManager.loading = null;
            keyManager.view_error = null;
            keyManager.toolbar = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
