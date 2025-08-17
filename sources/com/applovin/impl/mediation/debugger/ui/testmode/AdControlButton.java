package com.applovin.impl.mediation.debugger.ui.testmode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.sdk.utils.f;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.R;

public class AdControlButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final Button f14756a;

    /* renamed from: b  reason: collision with root package name */
    private final com.applovin.impl.adview.a f14757b;

    /* renamed from: c  reason: collision with root package name */
    private b f14758c;

    /* renamed from: d  reason: collision with root package name */
    private MaxAdFormat f14759d;

    /* renamed from: e  reason: collision with root package name */
    private a f14760e;

    public interface a {
        void onClick(AdControlButton adControlButton);
    }

    public enum b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Button button = new Button(getContext());
        this.f14756a = button;
        com.applovin.impl.adview.a aVar = new com.applovin.impl.adview.a(getContext(), 20, 16842873);
        this.f14757b = aVar;
        b bVar = b.LOAD;
        this.f14758c = bVar;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        button.setTextColor(-1);
        button.setOnClickListener(this);
        frameLayout.addView(button, new FrameLayout.LayoutParams(-1, -1, 17));
        aVar.setColor(-1);
        addView(aVar, new FrameLayout.LayoutParams(-1, -1, 17));
        a(bVar);
    }

    private void a(b bVar) {
        if (b.LOADING == bVar) {
            setEnabled(false);
            this.f14757b.a();
        } else {
            setEnabled(true);
            this.f14757b.b();
        }
        this.f14756a.setText(b(bVar));
        this.f14756a.setBackgroundColor(c(bVar));
    }

    private String b(b bVar) {
        return b.LOAD == bVar ? "Load" : b.LOADING == bVar ? "" : "Show";
    }

    private int c(b bVar) {
        return f.a((b.LOAD == bVar || b.LOADING == bVar) ? R.color.applovin_sdk_brand_color : R.color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
    }

    public b getControlState() {
        return this.f14758c;
    }

    public MaxAdFormat getFormat() {
        return this.f14759d;
    }

    public void onClick(View view) {
        a aVar = this.f14760e;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    public void setControlState(b bVar) {
        if (this.f14758c != bVar) {
            a(bVar);
        }
        this.f14758c = bVar;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.f14759d = maxAdFormat;
    }

    public void setOnClickListener(a aVar) {
        this.f14760e = aVar;
    }
}
