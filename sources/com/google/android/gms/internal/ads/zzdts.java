package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

public final class zzdts {
    zzdts() {
    }

    public static final void zza(Context context, ViewGroup viewGroup, AdView adView) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setTag("layout");
        zzf(linearLayout, -1, -1);
        linearLayout.setGravity(17);
        linearLayout.addView(adView);
        adView.setTag("ad_view");
        viewGroup.addView(linearLayout);
    }

    public static final void zzb(Context context, ViewGroup viewGroup, NativeAd nativeAd) {
        String str;
        String str2;
        String str3;
        NativeAdView nativeAdView = new NativeAdView(context);
        nativeAdView.setTag("ad_view_tag");
        zzf(nativeAdView, -1, -1);
        viewGroup.addView(nativeAdView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setTag("layout_tag");
        linearLayout.setOrientation(1);
        zzf(linearLayout, -1, -1);
        linearLayout.setBackgroundColor(-1);
        nativeAdView.addView(linearLayout);
        Resources zzd = zzt.zzo().zzd();
        if (zzd == null) {
            str = "Headline";
        } else {
            str = zzd.getString(R.string.native_headline);
        }
        linearLayout.addView(zzc(context, str, "headline_header_tag"));
        TextView zzd2 = zzd(context, zzfpw.zzc(nativeAd.getHeadline()), "headline_tag");
        nativeAdView.setHeadlineView(zzd2);
        linearLayout.addView(zzd2);
        if (zzd == null) {
            str2 = "Body";
        } else {
            str2 = zzd.getString(R.string.native_body);
        }
        linearLayout.addView(zzc(context, str2, "body_header_tag"));
        TextView zzd3 = zzd(context, zzfpw.zzc(nativeAd.getBody()), "body_tag");
        nativeAdView.setBodyView(zzd3);
        linearLayout.addView(zzd3);
        if (zzd == null) {
            str3 = "Media View";
        } else {
            str3 = zzd.getString(R.string.native_media_view);
        }
        linearLayout.addView(zzc(context, str3, "media_view_header_tag"));
        MediaView mediaView = new MediaView(context);
        mediaView.setTag("media_view_tag");
        nativeAdView.setMediaView(mediaView);
        linearLayout.addView(mediaView);
        nativeAdView.setNativeAd(nativeAd);
    }

    private static TextView zzc(Context context, String str, String str2) {
        return zze(context, str, 16973894, -9210245, 0.0f, str2);
    }

    private static TextView zzd(Context context, String str, String str2) {
        return zze(context, str, 16973892, -16777216, 12.0f, str2);
    }

    private static TextView zze(Context context, String str, int i2, int i3, float f2, String str2) {
        TextView textView = new TextView(context);
        textView.setTag(str2);
        zzf(textView, -2, -2);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new TableRow.LayoutParams();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        marginLayoutParams.bottomMargin = (int) TypedValue.applyDimension(1, f2, textView.getResources().getDisplayMetrics());
        textView.setLayoutParams(marginLayoutParams);
        textView.setTextAppearance(context, i2);
        textView.setTextColor(i3);
        textView.setText(str);
        return textView;
    }

    private static void zzf(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new TableRow.LayoutParams();
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(layoutParams);
        layoutParams2.height = i2;
        layoutParams2.width = i3;
        view.setLayoutParams(layoutParams2);
    }
}
