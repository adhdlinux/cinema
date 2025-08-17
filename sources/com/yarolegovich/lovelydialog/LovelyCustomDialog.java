package com.yarolegovich.lovelydialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yarolegovich.lovelydialog.AbsLovelyDialog;

public class LovelyCustomDialog extends AbsLovelyDialog<LovelyCustomDialog> {

    /* renamed from: g  reason: collision with root package name */
    private View f37960g;

    public LovelyCustomDialog(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public int f() {
        return R$layout.dialog_custom;
    }

    public LovelyCustomDialog q(ViewConfigurator<View> viewConfigurator) {
        View view = this.f37960g;
        if (view != null) {
            viewConfigurator.a(view);
            return this;
        }
        throw new IllegalStateException(p(R$string.ex_msg_dialog_view_not_set));
    }

    public LovelyCustomDialog r(int i2, View.OnClickListener onClickListener) {
        return s(i2, false, onClickListener);
    }

    public LovelyCustomDialog s(int i2, boolean z2, View.OnClickListener onClickListener) {
        if (this.f37960g != null) {
            d(i2).setOnClickListener(new AbsLovelyDialog.ClickListenerDecorator(onClickListener, z2));
            return this;
        }
        throw new IllegalStateException(p(R$string.ex_msg_dialog_view_not_set));
    }

    public LovelyCustomDialog t(int i2) {
        this.f37960g = LayoutInflater.from(e()).inflate(i2, (ViewGroup) d(R$id.ld_custom_view_container), true);
        return this;
    }
}
