package com.flask.colorpicker.builder;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.R$dimen;
import com.flask.colorpicker.R$id;
import com.flask.colorpicker.R$layout;
import com.flask.colorpicker.Utils;
import com.flask.colorpicker.slider.AlphaSlider;
import com.flask.colorpicker.slider.LightnessSlider;

public class ColorPickerDialogBuilder {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog.Builder f21993a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f21994b;

    /* renamed from: c  reason: collision with root package name */
    private ColorPickerView f21995c;

    /* renamed from: d  reason: collision with root package name */
    private LightnessSlider f21996d;

    /* renamed from: e  reason: collision with root package name */
    private AlphaSlider f21997e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f21998f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f21999g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22000h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22001i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f22002j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22003k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f22004l;

    /* renamed from: m  reason: collision with root package name */
    private int f22005m;

    /* renamed from: n  reason: collision with root package name */
    private int f22006n;

    /* renamed from: o  reason: collision with root package name */
    private int f22007o;

    /* renamed from: p  reason: collision with root package name */
    private Integer[] f22008p;

    private ColorPickerDialogBuilder(Context context) {
        this(context, 0);
    }

    private static int e(Context context, int i2) {
        return (int) (context.getResources().getDimension(i2) + 0.5f);
    }

    private int f(Integer[] numArr) {
        Integer g2 = g(numArr);
        if (g2 == null) {
            return -1;
        }
        return numArr[g2.intValue()].intValue();
    }

    private Integer g(Integer[] numArr) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < numArr.length && numArr[i2] != null) {
            i2++;
            i3 = Integer.valueOf(i2 / 2);
        }
        return i3;
    }

    /* access modifiers changed from: private */
    public void k(DialogInterface dialogInterface, ColorPickerClickListener colorPickerClickListener) {
        colorPickerClickListener.a(dialogInterface, this.f21995c.getSelectedColor(), this.f21995c.getAllColors());
    }

    public static ColorPickerDialogBuilder s(Context context) {
        return new ColorPickerDialogBuilder(context);
    }

    public ColorPickerDialogBuilder b() {
        this.f22000h = false;
        this.f22001i = true;
        return this;
    }

    public AlertDialog c() {
        int i2;
        Context context = this.f21993a.getContext();
        ColorPickerView colorPickerView = this.f21995c;
        Integer[] numArr = this.f22008p;
        colorPickerView.j(numArr, g(numArr).intValue());
        this.f21995c.setShowBorder(this.f22002j);
        if (this.f22000h) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, e(context, R$dimen.default_slider_height));
            LightnessSlider lightnessSlider = new LightnessSlider(context);
            this.f21996d = lightnessSlider;
            lightnessSlider.setLayoutParams(layoutParams);
            this.f21994b.addView(this.f21996d);
            this.f21995c.setLightnessSlider(this.f21996d);
            this.f21996d.setColor(f(this.f22008p));
            this.f21996d.setShowBorder(this.f22002j);
        }
        if (this.f22001i) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, e(context, R$dimen.default_slider_height));
            AlphaSlider alphaSlider = new AlphaSlider(context);
            this.f21997e = alphaSlider;
            alphaSlider.setLayoutParams(layoutParams2);
            this.f21994b.addView(this.f21997e);
            this.f21995c.setAlphaSlider(this.f21997e);
            this.f21997e.setColor(f(this.f22008p));
            this.f21997e.setShowBorder(this.f22002j);
        }
        if (this.f22003k) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            EditText editText = (EditText) View.inflate(context, R$layout.color_edit, (ViewGroup) null);
            this.f21998f = editText;
            editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
            this.f21998f.setSingleLine();
            this.f21998f.setVisibility(8);
            if (this.f22001i) {
                i2 = 9;
            } else {
                i2 = 7;
            }
            this.f21998f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
            this.f21994b.addView(this.f21998f, layoutParams3);
            this.f21998f.setText(Utils.e(f(this.f22008p), this.f22001i));
            this.f21995c.setColorEdit(this.f21998f);
        }
        if (this.f22004l) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(context, R$layout.color_preview, (ViewGroup) null);
            this.f21999g = linearLayout;
            linearLayout.setVisibility(8);
            this.f21994b.addView(this.f21999g);
            if (this.f22008p.length != 0) {
                int i3 = 0;
                while (true) {
                    Integer[] numArr2 = this.f22008p;
                    if (i3 >= numArr2.length || i3 >= this.f22005m || numArr2[i3] == null) {
                        break;
                    }
                    LinearLayout linearLayout2 = (LinearLayout) View.inflate(context, R$layout.color_selector, (ViewGroup) null);
                    ((ImageView) linearLayout2.findViewById(R$id.image_preview)).setImageDrawable(new ColorDrawable(this.f22008p[i3].intValue()));
                    this.f21999g.addView(linearLayout2);
                    i3++;
                }
            } else {
                ((ImageView) View.inflate(context, R$layout.color_selector, (ViewGroup) null)).setImageDrawable(new ColorDrawable(-1));
            }
            this.f21999g.setVisibility(0);
            this.f21995c.h(this.f21999g, g(this.f22008p));
        }
        return this.f21993a.create();
    }

    public ColorPickerDialogBuilder d(int i2) {
        this.f21995c.setDensity(i2);
        return this;
    }

    public ColorPickerDialogBuilder h(int i2) {
        this.f22008p[0] = Integer.valueOf(i2);
        return this;
    }

    public ColorPickerDialogBuilder i() {
        this.f22000h = true;
        this.f22001i = false;
        return this;
    }

    public ColorPickerDialogBuilder j() {
        this.f22000h = false;
        this.f22001i = false;
        return this;
    }

    public ColorPickerDialogBuilder l(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f21993a.i(charSequence, onClickListener);
        return this;
    }

    public ColorPickerDialogBuilder m(OnColorSelectedListener onColorSelectedListener) {
        this.f21995c.a(onColorSelectedListener);
        return this;
    }

    public ColorPickerDialogBuilder n(CharSequence charSequence, final ColorPickerClickListener colorPickerClickListener) {
        this.f21993a.l(charSequence, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                ColorPickerDialogBuilder.this.k(dialogInterface, colorPickerClickListener);
            }
        });
        return this;
    }

    public ColorPickerDialogBuilder o(String str) {
        this.f21993a.setTitle(str);
        return this;
    }

    public ColorPickerDialogBuilder p(boolean z2) {
        this.f22002j = z2;
        return this;
    }

    public ColorPickerDialogBuilder q(boolean z2) {
        this.f22003k = z2;
        return this;
    }

    public ColorPickerDialogBuilder r(ColorPickerView.WHEEL_TYPE wheel_type) {
        this.f21995c.setRenderer(ColorWheelRendererBuilder.a(wheel_type));
        return this;
    }

    private ColorPickerDialogBuilder(Context context, int i2) {
        this.f22000h = true;
        this.f22001i = true;
        this.f22002j = true;
        this.f22003k = false;
        this.f22004l = false;
        this.f22005m = 1;
        this.f22006n = 0;
        this.f22007o = 0;
        this.f22008p = new Integer[]{null, null, null, null, null};
        this.f22006n = e(context, R$dimen.default_slider_margin);
        this.f22007o = e(context, R$dimen.default_margin_top);
        this.f21993a = new AlertDialog.Builder(context, i2);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f21994b = linearLayout;
        linearLayout.setOrientation(1);
        this.f21994b.setGravity(1);
        LinearLayout linearLayout2 = this.f21994b;
        int i3 = this.f22006n;
        linearLayout2.setPadding(i3, this.f22007o, i3, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        ColorPickerView colorPickerView = new ColorPickerView(context);
        this.f21995c = colorPickerView;
        this.f21994b.addView(colorPickerView, layoutParams);
        this.f21993a.setView(this.f21994b);
    }
}
