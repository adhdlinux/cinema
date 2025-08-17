package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import org.json.JSONObject;

public final class zzcqp extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcqp(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcqp zza(Context context, View view, zzezn zzezn) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcqp zzcqp = new zzcqp(context);
        if (!(zzezn.zzv.isEmpty() || (resources = zzcqp.zza.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzezo zzezo = (zzezo) zzezn.zzv.get(0);
            float f2 = displayMetrics.density;
            zzcqp.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzezo.zza) * f2), (int) (((float) zzezo.zzb) * f2)));
        }
        zzcqp.zzb = view;
        zzcqp.addView(view);
        zzt.zzx();
        zzcar.zzb(zzcqp, zzcqp);
        zzt.zzx();
        zzcar.zza(zzcqp, zzcqp);
        JSONObject jSONObject = zzezn.zzai;
        RelativeLayout relativeLayout = new RelativeLayout(zzcqp.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            zzcqp.zzc(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzcqp.zzc(optJSONObject2, relativeLayout, 12);
        }
        zzcqp.addView(relativeLayout);
        return zzcqp;
    }

    private final int zzb(double d2) {
        zzay.zzb();
        return zzbzk.zzx(this.zza, (int) d2);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i2) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb2 = zzb(jSONObject.optDouble(ViewProps.PADDING, 0.0d));
        textView.setPadding(0, zzb2, 0, zzb2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i2);
        relativeLayout.addView(textView, layoutParams);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }
}
