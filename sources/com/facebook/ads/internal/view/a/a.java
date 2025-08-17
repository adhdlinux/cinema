package com.facebook.ads.internal.view.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.q.b.b;
import com.facebook.ads.internal.q.b.c;
import java.util.List;

@TargetApi(19)
public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f20823a = Color.rgb(224, 224, 224);

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f20824b = Uri.parse("http://www.facebook.com");

    /* renamed from: c  reason: collision with root package name */
    private static final View.OnTouchListener f20825c = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                x.a(view, a.f20826d);
            } else if (action == 1) {
                x.a(view, 0);
            }
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final int f20826d = Color.argb(34, 0, 0, 0);

    /* renamed from: e  reason: collision with root package name */
    private ImageView f20827e;

    /* renamed from: f  reason: collision with root package name */
    private e f20828f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f20829g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public C0038a f20830h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f20831i;

    /* renamed from: com.facebook.ads.internal.view.a.a$a  reason: collision with other inner class name */
    public interface C0038a {
        void a();
    }

    public a(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        float f2 = getResources().getDisplayMetrics().density;
        int i2 = (int) (50.0f * f2);
        int i3 = (int) (f2 * 4.0f);
        x.a((View) this, -1);
        setGravity(16);
        this.f20827e = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        this.f20827e.setScaleType(ImageView.ScaleType.CENTER);
        this.f20827e.setImageBitmap(c.a(b.BROWSER_CLOSE));
        ImageView imageView = this.f20827e;
        View.OnTouchListener onTouchListener = f20825c;
        imageView.setOnTouchListener(onTouchListener);
        this.f20827e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.f20830h != null) {
                    a.this.f20830h.a();
                }
            }
        });
        addView(this.f20827e, layoutParams);
        this.f20828f = new e(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.f20828f.setPadding(0, i3, 0, i3);
        addView(this.f20828f, layoutParams2);
        this.f20829g = new ImageView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, i2);
        this.f20829g.setScaleType(ImageView.ScaleType.CENTER);
        this.f20829g.setOnTouchListener(onTouchListener);
        this.f20829g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.f20831i) && !"about:blank".equals(a.this.f20831i)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a.this.f20831i));
                    intent.addFlags(268435456);
                    a.this.getContext().startActivity(intent);
                }
            }
        });
        addView(this.f20829g, layoutParams3);
        setupDefaultNativeBrowser(context);
    }

    private void setupDefaultNativeBrowser(Context context) {
        Bitmap bitmap;
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", f20824b), 65536);
        if (queryIntentActivities.size() == 0) {
            this.f20829g.setVisibility(8);
            bitmap = null;
        } else {
            bitmap = c.a((queryIntentActivities.size() != 1 || !"com.android.chrome".equals(queryIntentActivities.get(0).activityInfo.packageName)) ? b.BROWSER_LAUNCH_NATIVE : b.BROWSER_LAUNCH_CHROME);
        }
        this.f20829g.setImageBitmap(bitmap);
    }

    public void setListener(C0038a aVar) {
        this.f20830h = aVar;
    }

    public void setTitle(String str) {
        this.f20828f.setTitle(str);
    }

    public void setUrl(String str) {
        this.f20831i = str;
        if (TextUtils.isEmpty(str) || "about:blank".equals(str)) {
            this.f20828f.setSubtitle((String) null);
            this.f20829g.setEnabled(false);
            this.f20829g.setColorFilter(new PorterDuffColorFilter(f20823a, PorterDuff.Mode.SRC_IN));
            return;
        }
        this.f20828f.setSubtitle(str);
        this.f20829g.setEnabled(true);
        this.f20829g.setColorFilter((ColorFilter) null);
    }
}
