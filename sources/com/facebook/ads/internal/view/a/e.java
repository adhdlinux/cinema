package com.facebook.ads.internal.view.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.q.b.b;
import com.facebook.ads.internal.q.b.c;
import com.facebook.common.util.UriUtil;

@TargetApi(19)
public class e extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f20856a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f20857b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f20858c;

    public e(Context context) {
        super(context);
        a();
    }

    private void a() {
        float f2 = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.f20856a = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f20856a.setTextColor(-16777216);
        this.f20856a.setTextSize(2, 20.0f);
        this.f20856a.setEllipsize(TextUtils.TruncateAt.END);
        this.f20856a.setSingleLine(true);
        this.f20856a.setVisibility(8);
        addView(this.f20856a, layoutParams);
        this.f20857b = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.f20857b.setAlpha(0.5f);
        this.f20857b.setTextColor(-16777216);
        this.f20857b.setTextSize(2, 15.0f);
        this.f20857b.setCompoundDrawablePadding((int) (f2 * 5.0f));
        this.f20857b.setEllipsize(TextUtils.TruncateAt.END);
        this.f20857b.setSingleLine(true);
        this.f20857b.setVisibility(8);
        addView(this.f20857b, layoutParams2);
    }

    private Drawable getPadlockDrawable() {
        if (this.f20858c == null) {
            this.f20858c = c.a(getContext(), b.BROWSER_PADLOCK);
        }
        return this.f20858c;
    }

    public void setSubtitle(String str) {
        TextView textView;
        int i2;
        if (TextUtils.isEmpty(str)) {
            this.f20857b.setText((CharSequence) null);
            textView = this.f20857b;
            i2 = 8;
        } else {
            Uri parse = Uri.parse(str);
            this.f20857b.setText(parse.getHost());
            this.f20857b.setCompoundDrawablesRelativeWithIntrinsicBounds(UriUtil.HTTPS_SCHEME.equals(parse.getScheme()) ? getPadlockDrawable() : null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView = this.f20857b;
            i2 = 0;
        }
        textView.setVisibility(i2);
    }

    public void setTitle(String str) {
        TextView textView;
        int i2;
        if (TextUtils.isEmpty(str)) {
            this.f20856a.setText((CharSequence) null);
            textView = this.f20856a;
            i2 = 8;
        } else {
            this.f20856a.setText(str);
            textView = this.f20856a;
            i2 = 0;
        }
        textView.setVisibility(i2);
    }
}
