package com.flask.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.flask.colorpicker.builder.ColorWheelRendererBuilder;
import com.flask.colorpicker.builder.PaintBuilder;
import com.flask.colorpicker.renderer.ColorWheelRenderOption;
import com.flask.colorpicker.renderer.ColorWheelRenderer;
import com.flask.colorpicker.slider.AlphaSlider;
import com.flask.colorpicker.slider.LightnessSlider;
import java.util.ArrayList;
import java.util.Iterator;

public class ColorPickerView extends View {
    private int A;
    private int B;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f21931b;

    /* renamed from: c  reason: collision with root package name */
    private Canvas f21932c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f21933d;

    /* renamed from: e  reason: collision with root package name */
    private Canvas f21934e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21935f;

    /* renamed from: g  reason: collision with root package name */
    private int f21936g = 8;

    /* renamed from: h  reason: collision with root package name */
    private float f21937h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f21938i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f21939j = 0;

    /* renamed from: k  reason: collision with root package name */
    private Integer[] f21940k = {null, null, null, null, null};

    /* renamed from: l  reason: collision with root package name */
    private int f21941l = 0;

    /* renamed from: m  reason: collision with root package name */
    private Integer f21942m;

    /* renamed from: n  reason: collision with root package name */
    private Integer f21943n;

    /* renamed from: o  reason: collision with root package name */
    private Paint f21944o = PaintBuilder.c().b(0).a();

    /* renamed from: p  reason: collision with root package name */
    private Paint f21945p = PaintBuilder.c().b(0).a();

    /* renamed from: q  reason: collision with root package name */
    private Paint f21946q = PaintBuilder.c().a();

    /* renamed from: r  reason: collision with root package name */
    private ColorCircle f21947r;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<OnColorChangedListener> f21948s = new ArrayList<>();

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<OnColorSelectedListener> f21949t = new ArrayList<>();

    /* renamed from: u  reason: collision with root package name */
    private LightnessSlider f21950u;

    /* renamed from: v  reason: collision with root package name */
    private AlphaSlider f21951v;

    /* renamed from: w  reason: collision with root package name */
    private EditText f21952w;

    /* renamed from: x  reason: collision with root package name */
    private TextWatcher f21953x = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            try {
                ColorPickerView.this.g(Color.parseColor(charSequence.toString()), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    /* renamed from: y  reason: collision with root package name */
    private LinearLayout f21954y;

    /* renamed from: z  reason: collision with root package name */
    private ColorWheelRenderer f21955z;

    public enum WHEEL_TYPE {
        FLOWER,
        CIRCLE;

        public static WHEEL_TYPE a(int i2) {
            if (i2 == 0) {
                return FLOWER;
            }
            if (i2 != 1) {
                return FLOWER;
            }
            return CIRCLE;
        }
    }

    public ColorPickerView(Context context) {
        super(context);
        f(context, (AttributeSet) null);
    }

    private void c() {
        this.f21932c.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f21934e.drawColor(0, PorterDuff.Mode.CLEAR);
        if (this.f21955z != null) {
            float width = ((float) this.f21932c.getWidth()) / 2.0f;
            int i2 = this.f21936g;
            float f2 = (width - 1.5374999f) - (width / ((float) i2));
            ColorWheelRenderOption b2 = this.f21955z.b();
            b2.f22015a = this.f21936g;
            b2.f22016b = f2;
            b2.f22017c = (f2 / ((float) (i2 - 1))) / 2.0f;
            b2.f22018d = 1.5374999f;
            b2.f22019e = this.f21938i;
            b2.f22020f = this.f21937h;
            b2.f22021g = this.f21932c;
            this.f21955z.c(b2);
            this.f21955z.a();
        }
    }

    private ColorCircle d(int i2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        char c2 = 1;
        char c3 = 0;
        double cos = ((double) fArr[1]) * Math.cos((((double) fArr[0]) * 3.141592653589793d) / 180.0d);
        double sin = ((double) fArr[1]) * Math.sin((((double) fArr[0]) * 3.141592653589793d) / 180.0d);
        ColorCircle colorCircle = null;
        double d2 = Double.MAX_VALUE;
        for (ColorCircle next : this.f21955z.d()) {
            float[] b2 = next.b();
            double d3 = sin;
            double cos2 = ((double) b2[c2]) * Math.cos((((double) b2[c3]) * 3.141592653589793d) / 180.0d);
            double d4 = cos - cos2;
            double sin2 = d3 - (((double) b2[1]) * Math.sin((((double) b2[0]) * 3.141592653589793d) / 180.0d));
            double d5 = (d4 * d4) + (sin2 * sin2);
            if (d5 < d2) {
                d2 = d5;
                colorCircle = next;
            }
            sin = d3;
            c2 = 1;
            c3 = 0;
        }
        return colorCircle;
    }

    private ColorCircle e(float f2, float f3) {
        ColorCircle colorCircle = null;
        double d2 = Double.MAX_VALUE;
        for (ColorCircle next : this.f21955z.d()) {
            double g2 = next.g(f2, f3);
            if (d2 > g2) {
                colorCircle = next;
                d2 = g2;
            }
        }
        return colorCircle;
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f21985s);
        this.f21936g = obtainStyledAttributes.getInt(R$styleable.f21989w, 10);
        this.f21942m = Integer.valueOf(obtainStyledAttributes.getInt(R$styleable.f21990x, -1));
        this.f21943n = Integer.valueOf(obtainStyledAttributes.getInt(R$styleable.D, -1));
        ColorWheelRenderer a2 = ColorWheelRendererBuilder.a(WHEEL_TYPE.a(obtainStyledAttributes.getInt(R$styleable.F, 0)));
        this.A = obtainStyledAttributes.getResourceId(R$styleable.f21987u, 0);
        this.B = obtainStyledAttributes.getResourceId(R$styleable.f21992z, 0);
        setRenderer(a2);
        setDensity(this.f21936g);
        i(this.f21942m.intValue(), true);
        obtainStyledAttributes.recycle();
    }

    private void k() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight < measuredWidth) {
            measuredWidth = measuredHeight;
        }
        if (measuredWidth > 0) {
            Bitmap bitmap = this.f21931b;
            if (bitmap == null || bitmap.getWidth() != measuredWidth) {
                this.f21931b = Bitmap.createBitmap(measuredWidth, measuredWidth, Bitmap.Config.ARGB_8888);
                this.f21932c = new Canvas(this.f21931b);
                this.f21946q.setShader(PaintBuilder.b(26));
            }
            Bitmap bitmap2 = this.f21933d;
            if (bitmap2 == null || bitmap2.getWidth() != measuredWidth) {
                this.f21933d = Bitmap.createBitmap(measuredWidth, measuredWidth, Bitmap.Config.ARGB_8888);
                this.f21934e = new Canvas(this.f21933d);
            }
            c();
            invalidate();
        }
    }

    private void setColorPreviewColor(int i2) {
        Integer[] numArr;
        int i3;
        LinearLayout linearLayout = this.f21954y;
        if (linearLayout != null && (numArr = this.f21940k) != null && (i3 = this.f21941l) <= numArr.length && numArr[i3] != null && linearLayout.getChildCount() != 0 && this.f21954y.getVisibility() == 0) {
            View childAt = this.f21954y.getChildAt(this.f21941l);
            if (childAt instanceof LinearLayout) {
                ((ImageView) ((LinearLayout) childAt).findViewById(R$id.image_preview)).setImageDrawable(new ColorCircleDrawable(i2));
            }
        }
    }

    private void setColorText(int i2) {
        boolean z2;
        EditText editText = this.f21952w;
        if (editText != null) {
            if (this.f21951v != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            editText.setText(Utils.e(i2, z2));
        }
    }

    private void setColorToSliders(int i2) {
        LightnessSlider lightnessSlider = this.f21950u;
        if (lightnessSlider != null) {
            lightnessSlider.setColor(i2);
        }
        AlphaSlider alphaSlider = this.f21951v;
        if (alphaSlider != null) {
            alphaSlider.setColor(i2);
        }
    }

    private void setHighlightedColor(int i2) {
        int childCount = this.f21954y.getChildCount();
        if (childCount != 0 && this.f21954y.getVisibility() == 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f21954y.getChildAt(i3);
                if (childAt instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) childAt;
                    if (i3 == i2) {
                        linearLayout.setBackgroundColor(-1);
                    } else {
                        linearLayout.setBackgroundColor(0);
                    }
                }
            }
        }
    }

    public void a(OnColorSelectedListener onColorSelectedListener) {
        this.f21949t.add(onColorSelectedListener);
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3) {
        ArrayList<OnColorChangedListener> arrayList = this.f21948s;
        if (arrayList != null && i2 != i3) {
            Iterator<OnColorChangedListener> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                try {
                    it2.next().a(i3);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(int i2, boolean z2) {
        i(i2, z2);
        k();
        invalidate();
    }

    public Integer[] getAllColors() {
        return this.f21940k;
    }

    public int getSelectedColor() {
        int i2;
        ColorCircle colorCircle = this.f21947r;
        if (colorCircle != null) {
            i2 = Utils.c(colorCircle.a(), this.f21937h);
        } else {
            i2 = 0;
        }
        return Utils.a(this.f21938i, i2);
    }

    public void h(LinearLayout linearLayout, Integer num) {
        if (linearLayout != null) {
            this.f21954y = linearLayout;
            if (num == null) {
                num = 0;
            }
            int childCount = linearLayout.getChildCount();
            if (childCount != 0 && linearLayout.getVisibility() == 0) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = linearLayout.getChildAt(i2);
                    if (childAt instanceof LinearLayout) {
                        LinearLayout linearLayout2 = (LinearLayout) childAt;
                        if (i2 == num.intValue()) {
                            linearLayout2.setBackgroundColor(-1);
                        }
                        ImageView imageView = (ImageView) linearLayout2.findViewById(R$id.image_preview);
                        imageView.setClickable(true);
                        imageView.setTag(Integer.valueOf(i2));
                        imageView.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Object tag;
                                if (view != null && (tag = view.getTag()) != null && (tag instanceof Integer)) {
                                    ColorPickerView.this.setSelectedColor(((Integer) tag).intValue());
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    public void i(int i2, boolean z2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        this.f21938i = Utils.d(i2);
        this.f21937h = fArr[2];
        this.f21940k[this.f21941l] = Integer.valueOf(i2);
        this.f21942m = Integer.valueOf(i2);
        setColorPreviewColor(i2);
        setColorToSliders(i2);
        if (this.f21952w != null && z2) {
            setColorText(i2);
        }
        this.f21947r = d(i2);
    }

    public void j(Integer[] numArr, int i2) {
        this.f21940k = numArr;
        this.f21941l = i2;
        Integer num = numArr[i2];
        if (num == null) {
            num = -1;
        }
        i(num.intValue(), true);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        ColorCircle colorCircle;
        super.onDraw(canvas);
        canvas.drawColor(this.f21939j);
        float width = ((((float) canvas.getWidth()) / 1.025f) / ((float) this.f21936g)) / 2.0f;
        if (this.f21931b != null && (colorCircle = this.f21947r) != null) {
            this.f21944o.setColor(Color.HSVToColor(colorCircle.c(this.f21937h)));
            this.f21944o.setAlpha((int) (this.f21938i * 255.0f));
            float f2 = 4.0f + width;
            this.f21934e.drawCircle(this.f21947r.d(), this.f21947r.e(), f2, this.f21946q);
            this.f21934e.drawCircle(this.f21947r.d(), this.f21947r.e(), f2, this.f21944o);
            this.f21945p = PaintBuilder.c().b(-1).e(Paint.Style.STROKE).d(0.5f * width).f(PorterDuff.Mode.CLEAR).a();
            if (this.f21935f) {
                this.f21932c.drawCircle(this.f21947r.d(), this.f21947r.e(), (this.f21945p.getStrokeWidth() / 2.0f) + width, this.f21945p);
            }
            canvas.drawBitmap(this.f21931b, 0.0f, 0.0f, (Paint) null);
            this.f21934e.drawCircle(this.f21947r.d(), this.f21947r.e(), width + (this.f21945p.getStrokeWidth() / 2.0f), this.f21945p);
            canvas.drawBitmap(this.f21933d, 0.0f, 0.0f, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (this.A != 0) {
            setAlphaSlider((AlphaSlider) getRootView().findViewById(this.A));
        }
        if (this.B != 0) {
            setLightnessSlider((LightnessSlider) getRootView().findViewById(this.B));
        }
        k();
        this.f21947r = d(this.f21942m.intValue());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 0) {
            if (mode == Integer.MIN_VALUE) {
                i2 = View.MeasureSpec.getSize(i2);
            } else if (mode == 1073741824) {
                i2 = View.MeasureSpec.getSize(i2);
            } else {
                i2 = 0;
            }
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 != 0) {
            if (mode2 == Integer.MIN_VALUE) {
                i3 = View.MeasureSpec.getSize(i3);
            } else if (mode2 == 1073741824) {
                i3 = View.MeasureSpec.getSize(i3);
            } else {
                i3 = 0;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        setMeasuredDimension(i2, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        k();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r0 != 2) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x003b
            if (r0 == r1) goto L_0x000d
            r2 = 2
            if (r0 == r2) goto L_0x003b
            goto L_0x0063
        L_0x000d:
            int r4 = r3.getSelectedColor()
            java.util.ArrayList<com.flask.colorpicker.OnColorSelectedListener> r0 = r3.f21949t
            if (r0 == 0) goto L_0x002e
            java.util.Iterator r0 = r0.iterator()
        L_0x0019:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r0.next()
            com.flask.colorpicker.OnColorSelectedListener r2 = (com.flask.colorpicker.OnColorSelectedListener) r2
            r2.a(r4)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0019
        L_0x0029:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x0019
        L_0x002e:
            r3.setColorToSliders(r4)
            r3.setColorText(r4)
            r3.setColorPreviewColor(r4)
            r3.invalidate()
            goto L_0x0063
        L_0x003b:
            int r0 = r3.getSelectedColor()
            float r2 = r4.getX()
            float r4 = r4.getY()
            com.flask.colorpicker.ColorCircle r4 = r3.e(r2, r4)
            r3.f21947r = r4
            int r4 = r3.getSelectedColor()
            r3.b(r0, r4)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r3.f21942m = r0
            r3.setColorToSliders(r4)
            r3.k()
            r3.invalidate()
        L_0x0063:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flask.colorpicker.ColorPickerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        k();
        this.f21947r = d(this.f21942m.intValue());
    }

    public void setAlphaSlider(AlphaSlider alphaSlider) {
        this.f21951v = alphaSlider;
        if (alphaSlider != null) {
            alphaSlider.setColorPicker(this);
            this.f21951v.setColor(getSelectedColor());
        }
    }

    public void setAlphaValue(float f2) {
        Integer num;
        boolean z2;
        int selectedColor = getSelectedColor();
        this.f21938i = f2;
        Integer valueOf = Integer.valueOf(Color.HSVToColor(Utils.b(f2), this.f21947r.c(this.f21937h)));
        this.f21942m = valueOf;
        EditText editText = this.f21952w;
        if (editText != null) {
            int intValue = valueOf.intValue();
            if (this.f21951v != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            editText.setText(Utils.e(intValue, z2));
        }
        LightnessSlider lightnessSlider = this.f21950u;
        if (!(lightnessSlider == null || (num = this.f21942m) == null)) {
            lightnessSlider.setColor(num.intValue());
        }
        b(selectedColor, this.f21942m.intValue());
        k();
        invalidate();
    }

    public void setColorEdit(EditText editText) {
        this.f21952w = editText;
        if (editText != null) {
            editText.setVisibility(0);
            this.f21952w.addTextChangedListener(this.f21953x);
            setColorEditTextColor(this.f21943n.intValue());
        }
    }

    public void setColorEditTextColor(int i2) {
        this.f21943n = Integer.valueOf(i2);
        EditText editText = this.f21952w;
        if (editText != null) {
            editText.setTextColor(i2);
        }
    }

    public void setDensity(int i2) {
        this.f21936g = Math.max(2, i2);
        invalidate();
    }

    public void setLightness(float f2) {
        Integer num;
        boolean z2;
        int selectedColor = getSelectedColor();
        this.f21937h = f2;
        if (this.f21947r != null) {
            Integer valueOf = Integer.valueOf(Color.HSVToColor(Utils.b(this.f21938i), this.f21947r.c(f2)));
            this.f21942m = valueOf;
            EditText editText = this.f21952w;
            if (editText != null) {
                int intValue = valueOf.intValue();
                if (this.f21951v != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                editText.setText(Utils.e(intValue, z2));
            }
            AlphaSlider alphaSlider = this.f21951v;
            if (!(alphaSlider == null || (num = this.f21942m) == null)) {
                alphaSlider.setColor(num.intValue());
            }
            b(selectedColor, this.f21942m.intValue());
            k();
            invalidate();
        }
    }

    public void setLightnessSlider(LightnessSlider lightnessSlider) {
        this.f21950u = lightnessSlider;
        if (lightnessSlider != null) {
            lightnessSlider.setColorPicker(this);
            this.f21950u.setColor(getSelectedColor());
        }
    }

    public void setRenderer(ColorWheelRenderer colorWheelRenderer) {
        this.f21955z = colorWheelRenderer;
        invalidate();
    }

    public void setSelectedColor(int i2) {
        Integer[] numArr = this.f21940k;
        if (numArr != null && numArr.length >= i2) {
            this.f21941l = i2;
            setHighlightedColor(i2);
            Integer num = this.f21940k[i2];
            if (num != null) {
                g(num.intValue(), true);
            }
        }
    }

    public void setShowBorder(boolean z2) {
        this.f21935f = z2;
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        f(context, attributeSet);
    }
}
