package com.yoku.house.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.common.util.UriUtil;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.vungle.ads.internal.Constants;
import com.yoku.house.ads.helper.HouseAdsHelper;
import com.yoku.house.ads.helper.cacheImages.PicassoHelper;
import com.yoku.house.ads.listener.AdListener;
import com.yoku.house.ads.model.InterstitialModal;
import java.util.ArrayList;
import n1.e;
import n1.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HouseAdsInterstitial {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static AdListener f37991d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static boolean f37992e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static Bitmap f37993f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static String f37994g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f37995a;

    /* renamed from: b  reason: collision with root package name */
    private int f37996b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f37997c;

    public static class InterstitialActivity extends Activity {
        /* access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            if (HouseAdsInterstitial.f37994g.startsWith(UriUtil.HTTP_SCHEME)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(HouseAdsInterstitial.f37994g));
                intent.setPackage("com.android.chrome");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(HouseAdsInterstitial.f37994g)));
                }
                if (HouseAdsInterstitial.f37991d != null) {
                    HouseAdsInterstitial.f37991d.b();
                }
                finish();
                return;
            }
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + HouseAdsInterstitial.f37994g)));
                if (HouseAdsInterstitial.f37991d != null) {
                    HouseAdsInterstitial.f37991d.b();
                }
                finish();
            } catch (ActivityNotFoundException unused) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + HouseAdsInterstitial.f37994g)));
                if (HouseAdsInterstitial.f37991d != null) {
                    HouseAdsInterstitial.f37991d.b();
                }
                finish();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            finish();
            if (HouseAdsInterstitial.f37991d != null) {
                HouseAdsInterstitial.f37991d.onAdClosed();
            }
        }

        public void onBackPressed() {
            if (HouseAdsInterstitial.f37991d != null) {
                HouseAdsInterstitial.f37991d.onAdClosed();
            }
            finish();
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (HouseAdsInterstitial.f37991d != null) {
                HouseAdsInterstitial.f37991d.c();
            }
            setContentView(R$layout.house_ads_interstitial_layout);
            ImageView imageView = (ImageView) findViewById(R$id.f38016j);
            imageView.setImageBitmap(HouseAdsInterstitial.f37993f);
            imageView.setOnClickListener(new e(this));
            ((ImageButton) findViewById(R$id.button_close)).setOnClickListener(new f(this));
        }
    }

    public HouseAdsInterstitial(Context context, String str) {
        this.f37995a = context;
        this.f37997c = str;
    }

    private void i(String str) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        try {
            JSONArray optJSONArray = new JSONObject(new String(sb)).optJSONArray("apps");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                if (jSONObject.optString("app_adType").equals(Constants.PLACEMENT_TYPE_INTERSTITIAL)) {
                    if (jSONObject.has("hideIfAppInstalled")) {
                        z2 = jSONObject.optBoolean("hideIfAppInstalled");
                    } else {
                        z2 = true;
                    }
                    if (jSONObject.optString("app_uri").startsWith(UriUtil.HTTP_SCHEME) || !z2 || !HouseAdsHelper.a(this.f37995a, jSONObject.optString("app_uri"))) {
                        InterstitialModal interstitialModal = new InterstitialModal();
                        interstitialModal.c(jSONObject.optString("app_interstitial_url"));
                        interstitialModal.d(jSONObject.optString("app_uri"));
                        arrayList.add(interstitialModal);
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (arrayList.size() > 0) {
            InterstitialModal interstitialModal2 = (InterstitialModal) arrayList.get(this.f37996b);
            if (this.f37996b == arrayList.size() - 1) {
                this.f37996b = 0;
            } else {
                this.f37996b++;
            }
            PicassoHelper.b(interstitialModal2.a()).into((Target) new Target() {
                public void onBitmapFailed(Exception exc, Drawable drawable) {
                    if (HouseAdsInterstitial.f37991d != null) {
                        HouseAdsInterstitial.f37991d.a(exc);
                    }
                    boolean unused = HouseAdsInterstitial.f37992e = false;
                }

                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                    Bitmap unused = HouseAdsInterstitial.f37993f = bitmap;
                    if (HouseAdsInterstitial.f37991d != null) {
                        HouseAdsInterstitial.f37991d.onAdLoaded();
                    }
                    boolean unused2 = HouseAdsInterstitial.f37992e = true;
                }

                public void onPrepareLoad(Drawable drawable) {
                }
            });
            f37994g = interstitialModal2.b();
        }
    }

    public boolean f() {
        return f37992e;
    }

    public void g() {
        if (!this.f37997c.trim().isEmpty()) {
            i(this.f37997c);
            return;
        }
        AdListener adListener = f37991d;
        if (adListener != null) {
            adListener.a(new Exception("Null Response"));
        }
    }

    public void h(AdListener adListener) {
        f37991d = adListener;
    }

    public void j() {
        this.f37995a.startActivity(new Intent(this.f37995a, InterstitialActivity.class));
        Context context = this.f37995a;
        if (context instanceof AppCompatActivity) {
            ((AppCompatActivity) context).overridePendingTransition(0, 0);
        }
    }
}
