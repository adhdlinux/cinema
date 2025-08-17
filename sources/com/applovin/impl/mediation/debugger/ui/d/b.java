package com.applovin.impl.mediation.debugger.ui.d;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public TextView f14694a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14695b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f14696c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f14697d;

    /* renamed from: e  reason: collision with root package name */
    private c f14698e;

    /* renamed from: f  reason: collision with root package name */
    private int f14699f;

    public int a() {
        return this.f14699f;
    }

    public void a(int i2) {
        this.f14699f = i2;
    }

    public void a(c cVar) {
        this.f14698e = cVar;
        this.f14694a.setText(cVar.k());
        this.f14694a.setTextColor(cVar.n());
        if (this.f14695b != null) {
            if (!TextUtils.isEmpty(cVar.c_())) {
                this.f14695b.setTypeface((Typeface) null, 0);
                this.f14695b.setVisibility(0);
                this.f14695b.setText(cVar.c_());
                this.f14695b.setTextColor(cVar.c());
                if (cVar.d_()) {
                    this.f14695b.setTypeface((Typeface) null, 1);
                }
            } else {
                this.f14695b.setVisibility(8);
            }
        }
        if (this.f14696c != null) {
            if (cVar.e() > 0) {
                this.f14696c.setImageResource(cVar.e());
                this.f14696c.setColorFilter(cVar.o());
                this.f14696c.setVisibility(0);
            } else {
                this.f14696c.setVisibility(8);
            }
        }
        if (this.f14697d == null) {
            return;
        }
        if (cVar.f() > 0) {
            this.f14697d.setImageResource(cVar.f());
            this.f14697d.setColorFilter(cVar.g());
            this.f14697d.setVisibility(0);
            return;
        }
        this.f14697d.setVisibility(8);
    }

    public c b() {
        return this.f14698e;
    }
}
