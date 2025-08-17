package com.startapp.sdk.inappbrowser;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.startapp.p;
import com.startapp.vd;
import java.util.Map;

public class NavigationBarLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final int f36501a = Color.rgb(78, 86, 101);

    /* renamed from: b  reason: collision with root package name */
    public static final int f36502b = Color.rgb(148, 155, 166);

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f36503c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36504d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f36505e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f36506f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f36507g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f36508h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f36509i;

    /* renamed from: j  reason: collision with root package name */
    public Boolean f36510j = Boolean.FALSE;

    /* renamed from: k  reason: collision with root package name */
    public Map<String, vd> f36511k;

    public NavigationBarLayout(Context context) {
        super(context);
    }

    public void a(WebView webView) {
        if (this.f36510j.booleanValue()) {
            if (webView.canGoBack()) {
                this.f36507g.setImageBitmap(this.f36511k.get("BACK_DARK").f36745a);
                this.f36507g.setEnabled(true);
            } else {
                this.f36507g.setImageBitmap(this.f36511k.get("BACK").f36745a);
                this.f36507g.setEnabled(false);
            }
            if (webView.canGoForward()) {
                this.f36505e.setImageBitmap(this.f36511k.get("FORWARD_DARK").f36745a);
                this.f36505e.setEnabled(true);
            } else {
                this.f36505e.setImageBitmap(this.f36511k.get("FORWARD").f36745a);
                this.f36505e.setEnabled(false);
            }
            if (webView.getTitle() != null) {
                this.f36508h.setText(webView.getTitle());
            }
        } else if (webView.canGoBack()) {
            this.f36507g.setImageBitmap(this.f36511k.get("BACK_DARK").f36745a);
            addView(this.f36507g, p.a(getContext(), new int[]{6, 0, 0, 0}, new int[]{15, 9}));
            ImageView imageView = this.f36505e;
            RelativeLayout.LayoutParams a2 = p.a(getContext(), new int[]{9, 0, 0, 0}, new int[]{15});
            a2.addRule(1, 2105);
            addView(imageView, a2);
            removeView(this.f36503c);
            this.f36503c.removeView(this.f36509i);
            this.f36503c.removeView(this.f36508h);
            this.f36503c.addView(this.f36508h, p.a(getContext(), new int[]{0, 0, 0, 0}, new int[]{14}));
            RelativeLayout relativeLayout = this.f36503c;
            TextView textView = this.f36509i;
            RelativeLayout.LayoutParams a3 = p.a(getContext(), new int[]{0, 0, 0, 0}, new int[]{14});
            a3.addRule(3, RemoteMediaPlayer.STATUS_TIMED_OUT);
            relativeLayout.addView(textView, a3);
            RelativeLayout.LayoutParams a4 = p.a(getContext(), new int[]{16, 0, 16, 0}, new int[]{15});
            a4.addRule(1, 2106);
            a4.addRule(0, CastStatusCodes.MEDIA_ERROR);
            addView(this.f36503c, a4);
            this.f36510j = Boolean.TRUE;
        }
    }

    public void setButtonsListener(View.OnClickListener onClickListener) {
        this.f36504d.setOnClickListener(onClickListener);
        this.f36507g.setOnClickListener(onClickListener);
        this.f36505e.setOnClickListener(onClickListener);
        this.f36506f.setOnClickListener(onClickListener);
    }

    public void a() {
        this.f36511k = null;
    }
}
