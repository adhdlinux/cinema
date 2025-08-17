package com.yarolegovich.lovelydialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.yarolegovich.lovelydialog.AbsLovelyDialog;

public abstract class AbsLovelyDialog<T extends AbsLovelyDialog> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Dialog f37951a;

    /* renamed from: b  reason: collision with root package name */
    private View f37952b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f37953c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f37954d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f37955e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f37956f;

    protected class ClickListenerDecorator implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private View.OnClickListener f37957b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f37958c;

        protected ClickListenerDecorator(View.OnClickListener onClickListener, boolean z2) {
            this.f37957b = onClickListener;
            this.f37958c = z2;
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f37957b;
            if (onClickListener != null) {
                if (onClickListener instanceof LovelyDialogCompat$DialogOnClickListenerAdapter) {
                    ((LovelyDialogCompat$DialogOnClickListenerAdapter) onClickListener).a(AbsLovelyDialog.this.f37951a, view.getId());
                } else {
                    onClickListener.onClick(view);
                }
            }
            if (this.f37958c) {
                AbsLovelyDialog.this.c();
            }
        }
    }

    public AbsLovelyDialog(Context context) {
        this(context, 0);
    }

    private void g(AlertDialog.Builder builder, int i2) {
        View inflate = LayoutInflater.from(builder.getContext()).inflate(i2, (ViewGroup) null);
        this.f37952b = inflate;
        this.f37951a = builder.setView(inflate).create();
        this.f37953c = (ImageView) d(R$id.ld_icon);
        this.f37955e = (TextView) d(R$id.ld_title);
        this.f37956f = (TextView) d(R$id.ld_message);
        this.f37954d = (TextView) d(R$id.ld_top_title);
    }

    /* access modifiers changed from: protected */
    public int b(int i2) {
        return ContextCompat.getColor(e(), i2);
    }

    public void c() {
        this.f37951a.dismiss();
    }

    /* access modifiers changed from: protected */
    public <ViewClass extends View> ViewClass d(int i2) {
        return this.f37952b.findViewById(i2);
    }

    /* access modifiers changed from: protected */
    public Context e() {
        return this.f37952b.getContext();
    }

    /* access modifiers changed from: protected */
    public abstract int f();

    public T h(int i2) {
        this.f37953c.setVisibility(0);
        this.f37953c.setImageResource(i2);
        return this;
    }

    public T i(Drawable drawable) {
        this.f37953c.setVisibility(0);
        this.f37953c.setImageDrawable(drawable);
        return this;
    }

    public T j(CharSequence charSequence) {
        this.f37956f.setVisibility(0);
        this.f37956f.setText(charSequence);
        return this;
    }

    public T k(CharSequence charSequence) {
        this.f37955e.setVisibility(0);
        this.f37955e.setText(charSequence);
        return this;
    }

    public T l(int i2) {
        d(R$id.ld_color_area).setBackgroundColor(i2);
        return this;
    }

    public T m(int i2) {
        return l(b(i2));
    }

    public T n(CharSequence charSequence) {
        this.f37954d.setVisibility(0);
        this.f37954d.setText(charSequence);
        return this;
    }

    public Dialog o() {
        this.f37951a.show();
        return this.f37951a;
    }

    /* access modifiers changed from: protected */
    public String p(int i2) {
        return this.f37952b.getContext().getString(i2);
    }

    public AbsLovelyDialog(Context context, int i2) {
        this(context, i2, 0);
    }

    public AbsLovelyDialog(Context context, int i2, int i3) {
        i3 = i3 == 0 ? f() : i3;
        if (i2 == 0) {
            g(new AlertDialog.Builder(context), i3);
        } else {
            g(new AlertDialog.Builder(context, i2), i3);
        }
    }
}
