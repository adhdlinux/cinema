package com.flask.colorpicker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class ColorPickerPreference extends Preference {

    /* renamed from: b  reason: collision with root package name */
    protected boolean f21919b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f21920c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f21921d;

    /* renamed from: e  reason: collision with root package name */
    protected int f21922e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected ColorPickerView.WHEEL_TYPE f21923f;

    /* renamed from: g  reason: collision with root package name */
    protected int f21924g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21925h;

    /* renamed from: i  reason: collision with root package name */
    private String f21926i;

    /* renamed from: j  reason: collision with root package name */
    private String f21927j;

    /* renamed from: k  reason: collision with root package name */
    private String f21928k;

    /* renamed from: l  reason: collision with root package name */
    protected ImageView f21929l;

    public ColorPickerPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }

    public static int a(int i2, float f2) {
        return Color.argb(Color.alpha(i2), Math.max((int) (((float) Color.red(i2)) * f2), 0), Math.max((int) (((float) Color.green(i2)) * f2), 0), Math.max((int) (((float) Color.blue(i2)) * f2), 0));
    }

    /* JADX INFO: finally extract failed */
    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f21985s);
        try {
            this.f21919b = obtainStyledAttributes.getBoolean(R$styleable.f21986t, false);
            this.f21920c = obtainStyledAttributes.getBoolean(R$styleable.f21991y, false);
            this.f21921d = obtainStyledAttributes.getBoolean(R$styleable.f21988v, true);
            this.f21924g = obtainStyledAttributes.getInt(R$styleable.f21989w, 8);
            this.f21923f = ColorPickerView.WHEEL_TYPE.a(obtainStyledAttributes.getInt(R$styleable.F, 0));
            this.f21922e = obtainStyledAttributes.getInt(R$styleable.f21990x, -1);
            this.f21925h = obtainStyledAttributes.getBoolean(R$styleable.C, true);
            String string = obtainStyledAttributes.getString(R$styleable.E);
            this.f21926i = string;
            if (string == null) {
                this.f21926i = "Choose color";
            }
            String string2 = obtainStyledAttributes.getString(R$styleable.A);
            this.f21927j = string2;
            if (string2 == null) {
                this.f21927j = "cancel";
            }
            String string3 = obtainStyledAttributes.getString(R$styleable.B);
            this.f21928k = string3;
            if (string3 == null) {
                this.f21928k = "ok";
            }
            obtainStyledAttributes.recycle();
            setWidgetLayoutResource(R$layout.color_widget);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void c(int i2) {
        if (callChangeListener(Integer.valueOf(i2))) {
            this.f21922e = i2;
            persistInt(i2);
            notifyChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        int i2;
        ColorCircleDrawable colorCircleDrawable;
        super.onBindView(view);
        if (isEnabled()) {
            i2 = this.f21922e;
        } else {
            i2 = a(this.f21922e, 0.5f);
        }
        ImageView imageView = (ImageView) view.findViewById(R$id.color_indicator);
        this.f21929l = imageView;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof ColorCircleDrawable)) {
            colorCircleDrawable = null;
        } else {
            colorCircleDrawable = (ColorCircleDrawable) drawable;
        }
        if (colorCircleDrawable == null) {
            colorCircleDrawable = new ColorCircleDrawable(i2);
        }
        this.f21929l.setImageDrawable(colorCircleDrawable);
    }

    /* access modifiers changed from: protected */
    public void onClick() {
        ColorPickerDialogBuilder l2 = ColorPickerDialogBuilder.s(getContext()).o(this.f21926i).h(this.f21922e).p(this.f21921d).r(this.f21923f).d(this.f21924g).q(this.f21925h).n(this.f21928k, new ColorPickerClickListener() {
            public void a(DialogInterface dialogInterface, int i2, Integer[] numArr) {
                ColorPickerPreference.this.c(i2);
            }
        }).l(this.f21927j, (DialogInterface.OnClickListener) null);
        boolean z2 = this.f21919b;
        if (!z2 && !this.f21920c) {
            l2.j();
        } else if (!z2) {
            l2.i();
        } else if (!this.f21920c) {
            l2.b();
        }
        l2.c().show();
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(boolean z2, Object obj) {
        c(z2 ? getPersistedInt(0) : ((Integer) obj).intValue());
    }
}
