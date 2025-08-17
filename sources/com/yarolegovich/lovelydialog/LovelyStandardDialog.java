package com.yarolegovich.lovelydialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.yarolegovich.lovelydialog.AbsLovelyDialog;

public class LovelyStandardDialog extends AbsLovelyDialog<LovelyStandardDialog> {

    /* renamed from: j  reason: collision with root package name */
    public static final int f37962j = R$id.ld_btn_yes;

    /* renamed from: k  reason: collision with root package name */
    public static final int f37963k = R$id.ld_btn_no;

    /* renamed from: l  reason: collision with root package name */
    public static final int f37964l = R$id.ld_btn_neutral;

    /* renamed from: g  reason: collision with root package name */
    private Button f37965g = ((Button) d(R$id.ld_btn_yes));

    /* renamed from: h  reason: collision with root package name */
    private Button f37966h = ((Button) d(R$id.ld_btn_no));

    /* renamed from: i  reason: collision with root package name */
    private Button f37967i = ((Button) d(R$id.ld_btn_neutral));

    public enum ButtonLayout {
        HORIZONTAL(R$layout.dialog_standard),
        VERTICAL(R$layout.dialog_standard_vertical);
        

        /* renamed from: b  reason: collision with root package name */
        final int f37971b;

        private ButtonLayout(int i2) {
            this.f37971b = i2;
        }
    }

    public LovelyStandardDialog(Context context, ButtonLayout buttonLayout) {
        super(context, 0, buttonLayout.f37971b);
    }

    /* access modifiers changed from: protected */
    public int f() {
        return ButtonLayout.HORIZONTAL.f37971b;
    }

    public LovelyStandardDialog q(int i2) {
        this.f37965g.setTextColor(i2);
        this.f37966h.setTextColor(i2);
        this.f37967i.setTextColor(i2);
        return this;
    }

    public LovelyStandardDialog r(int i2) {
        return q(b(i2));
    }

    public LovelyStandardDialog s(int i2, View.OnClickListener onClickListener) {
        return t(p(i2), onClickListener);
    }

    public LovelyStandardDialog t(String str, View.OnClickListener onClickListener) {
        this.f37966h.setVisibility(0);
        this.f37966h.setText(str);
        this.f37966h.setOnClickListener(new AbsLovelyDialog.ClickListenerDecorator(onClickListener, true));
        return this;
    }

    public LovelyStandardDialog u(int i2, View.OnClickListener onClickListener) {
        return v(p(i2), onClickListener);
    }

    public LovelyStandardDialog v(String str, View.OnClickListener onClickListener) {
        this.f37965g.setVisibility(0);
        this.f37965g.setText(str);
        this.f37965g.setOnClickListener(new AbsLovelyDialog.ClickListenerDecorator(onClickListener, true));
        return this;
    }
}
