package com.startapp.sdk.ads.banner.banner3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.hc;
import com.startapp.p;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.json.RatingBar;

public class Banner3DView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f35905a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35906b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35907c;

    /* renamed from: d  reason: collision with root package name */
    public RatingBar f35908d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35909e;

    /* renamed from: f  reason: collision with root package name */
    public Point f35910f;

    public enum Template {
        XS,
        S,
        M,
        L,
        XL
    }

    public class a extends ShapeDrawable {
        public a(Banner3DView banner3DView, Shape shape) {
            super(shape);
        }

        public void onDraw(Shape shape, Canvas canvas, Paint paint) {
            paint.setColor(-11363070);
            paint.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 5.0f, 3.0f));
            super.onDraw(shape, canvas, paint);
        }
    }

    public Banner3DView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        Context context = getContext();
        Template template = Template.S;
        int i2 = this.f35910f.x;
        Banner3DSize$Size banner3DSize$Size = Banner3DSize$Size.SMALL;
        if (i2 > banner3DSize$Size.getSize().f35750a.x || this.f35910f.y > banner3DSize$Size.getSize().f35750a.y) {
            template = Template.M;
        }
        int i3 = this.f35910f.x;
        Banner3DSize$Size banner3DSize$Size2 = Banner3DSize$Size.MEDIUM;
        if (i3 > banner3DSize$Size2.getSize().f35750a.x || this.f35910f.y > banner3DSize$Size2.getSize().f35750a.y) {
            template = Template.L;
        }
        int i4 = this.f35910f.x;
        Banner3DSize$Size banner3DSize$Size3 = Banner3DSize$Size.LARGE;
        if (i4 > banner3DSize$Size3.getSize().f35750a.x || this.f35910f.y > banner3DSize$Size3.getSize().f35750a.y) {
            template = Template.XL;
        }
        setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{AdsCommonMetaData.f36186h.p(), AdsCommonMetaData.f36186h.o()}));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int a2 = p.a(context, 2);
        int a3 = p.a(context, 3);
        p.a(context, 4);
        int a4 = p.a(context, 5);
        int a5 = p.a(context, 6);
        int a6 = p.a(context, 8);
        p.a(context, 10);
        int a7 = p.a(context, 20);
        p.a(context, 84);
        int a8 = p.a(context, 90);
        setPadding(a4, 0, a4, 0);
        setTag(this);
        ImageView imageView = new ImageView(context);
        this.f35907c = imageView;
        imageView.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a8, a8);
        layoutParams.addRule(15);
        this.f35907c.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        this.f35905a = textView;
        textView.setId(2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(hc.a(17), 1);
        layoutParams2.addRule(14);
        this.f35905a.setLayoutParams(layoutParams2);
        this.f35905a.setTextColor(AdsCommonMetaData.f36186h.q().intValue());
        this.f35905a.setGravity(hc.a(8388611));
        this.f35905a.setBackgroundColor(0);
        int ordinal = template.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            this.f35905a.setTextSize(17.0f);
            this.f35905a.setPadding(a3, 0, 0, a2);
            layoutParams2.width = p.a(getContext(), (int) (((double) this.f35910f.x) * 0.55d));
        } else if (ordinal == 2) {
            this.f35905a.setTextSize(17.0f);
            this.f35905a.setPadding(a3, 0, 0, a2);
            layoutParams2.width = p.a(getContext(), (int) (((double) this.f35910f.x) * 0.65d));
        } else if (ordinal == 3 || ordinal == 4) {
            this.f35905a.setTextSize(22.0f);
            this.f35905a.setPadding(a3, 0, 0, a4);
        }
        this.f35905a.setSingleLine(true);
        this.f35905a.setEllipsize(TextUtils.TruncateAt.END);
        p.a(this.f35905a, AdsCommonMetaData.f36186h.r());
        TextView textView2 = new TextView(context);
        this.f35906b = textView2;
        textView2.setId(3);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(hc.a(17), 1);
        layoutParams3.addRule(3, 2);
        layoutParams3.setMargins(0, 0, 0, a4);
        this.f35906b.setLayoutParams(layoutParams3);
        this.f35906b.setTextColor(AdsCommonMetaData.f36186h.l().intValue());
        this.f35906b.setTextSize(18.0f);
        this.f35906b.setMaxLines(2);
        this.f35906b.setLines(2);
        this.f35906b.setSingleLine(false);
        this.f35906b.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f35906b.setHorizontallyScrolling(true);
        this.f35906b.setPadding(a3, 0, 0, 0);
        RatingBar ratingBar = new RatingBar(getContext());
        this.f35908d = ratingBar;
        ratingBar.setId(5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        int ordinal2 = template.ordinal();
        if (ordinal2 == 0 || ordinal2 == 1 || ordinal2 == 2) {
            layoutParams4.addRule(hc.a(17), 1);
            layoutParams4.addRule(8, 1);
        } else if (ordinal2 == 3 || ordinal2 == 4) {
            layoutParams4.addRule(hc.a(17), 2);
            layoutParams3.width = p.a(getContext(), (int) (((double) this.f35910f.x) * 0.6d));
        }
        layoutParams4.setMargins(a3, a6, a3, 0);
        this.f35908d.setLayoutParams(layoutParams4);
        this.f35909e = new TextView(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        int ordinal3 = template.ordinal();
        if (ordinal3 == 0 || ordinal3 == 1 || ordinal3 == 2) {
            this.f35909e.setTextSize(13.0f);
            layoutParams5.addRule(hc.a(17), 2);
            layoutParams5.addRule(15);
        } else if (ordinal3 == 3) {
            layoutParams5.addRule(hc.a(17), 3);
            layoutParams5.addRule(15);
            layoutParams5.setMargins(a7, 0, 0, 0);
            this.f35909e.setTextSize(26.0f);
        } else if (ordinal3 == 4) {
            layoutParams5.addRule(hc.a(17), 3);
            layoutParams5.addRule(15);
            layoutParams5.setMargins(a7 * 7, 0, 0, 0);
            this.f35909e.setTextSize(26.0f);
        }
        this.f35909e.setPadding(a5, a5, a5, a5);
        this.f35909e.setLayoutParams(layoutParams5);
        setButtonText(false);
        this.f35909e.setTextColor(-1);
        this.f35909e.setTypeface((Typeface) null, 1);
        this.f35909e.setId(4);
        this.f35909e.setShadowLayer(2.5f, -3.0f, 3.0f, -9013642);
        this.f35909e.setBackgroundDrawable(new a(this, new RoundRectShape(new float[]{10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f}, (RectF) null, (float[]) null)));
        addView(this.f35907c);
        addView(this.f35905a);
        int ordinal4 = template.ordinal();
        if (ordinal4 == 0 || ordinal4 == 1 || ordinal4 == 2) {
            addView(this.f35909e);
        } else if (ordinal4 == 3 || ordinal4 == 4) {
            addView(this.f35909e);
            addView(this.f35906b);
        }
        addView(this.f35908d);
    }

    public void setButtonText(boolean z2) {
        if (z2) {
            this.f35909e.setText("OPEN");
        } else {
            this.f35909e.setText("DOWNLOAD");
        }
    }

    public void setDescription(String str) {
        if (str != null) {
            String str2 = "";
            if (str.compareTo(str2) != 0) {
                String[] a2 = a(str);
                String str3 = a2[0];
                String str4 = a2[1];
                if (str4 != null) {
                    str2 = a(str4)[0];
                }
                if (str.length() >= 110) {
                    str2 = str2 + "...";
                }
                this.f35906b.setText(str3 + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + str2);
            }
        }
    }

    public void setImage(Bitmap bitmap) {
        this.f35907c.setImageBitmap(bitmap);
    }

    public void setRating(float f2) {
        try {
            this.f35908d.setRating(f2);
        } catch (NullPointerException unused) {
        }
    }

    public void setText(String str) {
        this.f35905a.setText(str);
    }

    public void setImage(int i2, int i3, int i4) {
        this.f35907c.setImageResource(i2);
        ViewGroup.LayoutParams layoutParams = this.f35907c.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i4;
        this.f35907c.setLayoutParams(layoutParams);
    }

    public Banner3DView(Context context, Point point) {
        super(context);
        this.f35910f = point;
        a();
    }

    public Banner3DView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void setImage(Bitmap bitmap, int i2, int i3) {
        this.f35907c.setImageBitmap(bitmap);
        ViewGroup.LayoutParams layoutParams = this.f35907c.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.f35907c.setLayoutParams(layoutParams);
    }

    public Banner3DView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public final String[] a(String str) {
        boolean z2;
        String[] strArr = new String[2];
        int i2 = 55;
        if (str.length() > 55) {
            char[] charArray = str.substring(0, 55).toCharArray();
            int length = charArray.length - 1;
            int i3 = length - 1;
            while (true) {
                if (i3 <= 0) {
                    z2 = false;
                    break;
                } else if (charArray[i3] == ' ') {
                    length = i3;
                    z2 = true;
                    break;
                } else {
                    i3--;
                }
            }
            if (z2) {
                i2 = length;
            }
            strArr[0] = str.substring(0, i2);
            strArr[1] = str.substring(i2 + 1, str.length());
        } else {
            strArr[0] = str;
            strArr[1] = null;
        }
        return strArr;
    }
}
