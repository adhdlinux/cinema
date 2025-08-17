package com.movie.ui.activity.payment;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import butterknife.internal.Utils;
import com.movie.ui.activity.BaseActivity_ViewBinding;
import com.yoku.marumovie.R;

public class BitcoinGatewayActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private BitcoinGatewayActivity f32256b;

    public BitcoinGatewayActivity_ViewBinding(BitcoinGatewayActivity bitcoinGatewayActivity, View view) {
        super(bitcoinGatewayActivity, view);
        this.f32256b = bitcoinGatewayActivity;
        bitcoinGatewayActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    public void unbind() {
        BitcoinGatewayActivity bitcoinGatewayActivity = this.f32256b;
        if (bitcoinGatewayActivity != null) {
            this.f32256b = null;
            bitcoinGatewayActivity.toolbar = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
