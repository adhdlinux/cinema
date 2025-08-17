package com.yoku.house.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.palette.graphics.Palette;
import com.facebook.common.util.UriUtil;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import com.yoku.house.ads.helper.HouseAdsHelper;
import com.yoku.house.ads.helper.RemoveJsonObjectCompat;
import com.yoku.house.ads.helper.cacheImages.PicassoHelper;
import com.yoku.house.ads.listener.NativeAdListener;
import com.yoku.house.ads.model.DialogModal;
import com.yoku.house.ads.model.HouseAdsNativeView;
import java.util.ArrayList;
import n1.g;
import n1.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HouseAdsNative {

    /* renamed from: i  reason: collision with root package name */
    private static int f37999i;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f38000a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38001b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f38002c = true;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f38003d = false;

    /* renamed from: e  reason: collision with root package name */
    private HouseAdsNativeView f38004e;

    /* renamed from: f  reason: collision with root package name */
    private View f38005f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public NativeAdListener f38006g;

    /* renamed from: h  reason: collision with root package name */
    ArrayList<DialogModal> f38007h = new ArrayList<>();

    public HouseAdsNative(Context context, String str) {
        this.f38000a = context;
        this.f38001b = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(DialogModal dialogModal, View view) {
        String f2 = dialogModal.f();
        if (f2.trim().startsWith(UriUtil.HTTP_SCHEME)) {
            this.f38000a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f2)));
            return;
        }
        try {
            Context context = this.f38000a;
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + f2)));
        } catch (ActivityNotFoundException unused) {
            Context context2 = this.f38000a;
            context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + f2)));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(DialogModal dialogModal, View view) {
        String f2 = dialogModal.f();
        if (f2.trim().startsWith(UriUtil.HTTP_SCHEME)) {
            this.f38000a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f2)));
            return;
        }
        try {
            Context context = this.f38000a;
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + f2)));
        } catch (ActivityNotFoundException unused) {
            Context context2 = this.f38000a;
            context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + f2)));
        }
    }

    private void k(String str) {
        boolean z2;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("apps");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                if (jSONObject.optString("app_adType").equals("native")) {
                    if (jSONObject.has("hideIfAppInstalled")) {
                        z2 = jSONObject.optBoolean("hideIfAppInstalled");
                    } else {
                        z2 = true;
                    }
                    if (jSONObject.optString("app_uri").startsWith(UriUtil.HTTP_SCHEME) || !z2 || !HouseAdsHelper.a(this.f38000a, jSONObject.optString("app_uri"))) {
                        DialogModal dialogModal = new DialogModal();
                        dialogModal.j(jSONObject.optString("app_title"));
                        dialogModal.i(jSONObject.optString("app_desc"));
                        dialogModal.l(jSONObject.optString("app_icon"));
                        dialogModal.m(jSONObject.optString("app_header_image"));
                        dialogModal.k(jSONObject.optString("app_cta_text"));
                        dialogModal.n(jSONObject.optString("app_uri"));
                        dialogModal.p(jSONObject.optString("app_rating"));
                        dialogModal.o(jSONObject.optString("app_price"));
                        this.f38007h.add(dialogModal);
                    }
                } else {
                    new RemoveJsonObjectCompat(i2, optJSONArray).execute(new JSONArray[0]);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void i() {
        this.f38003d = false;
        if (!this.f38001b.trim().isEmpty()) {
            k(this.f38001b);
            return;
        }
        NativeAdListener nativeAdListener = this.f38006g;
        if (nativeAdListener != null) {
            nativeAdListener.a(new Exception("Null Response"));
        }
    }

    public void j(NativeAdListener nativeAdListener) {
        this.f38006g = nativeAdListener;
    }

    public boolean l(ViewGroup viewGroup, boolean z2) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        View findViewById;
        CardView cardView;
        ImageView imageView;
        ImageView imageView2;
        RatingBar ratingBar;
        if (this.f38007h.size() > 0) {
            if (z2) {
                this.f38005f = View.inflate(viewGroup.getContext(), R$layout.house_ads_native_banner, (ViewGroup) null);
            } else {
                this.f38005f = View.inflate(viewGroup.getContext(), R$layout.house_ads_native_layout, (ViewGroup) null);
            }
            viewGroup.addView(this.f38005f);
            DialogModal dialogModal = this.f38007h.get(f37999i);
            if (f37999i == this.f38007h.size() - 1) {
                f37999i = 0;
            } else {
                f37999i++;
            }
            HouseAdsNativeView houseAdsNativeView = this.f38004e;
            if (houseAdsNativeView != null) {
                textView = houseAdsNativeView.h();
                textView2 = houseAdsNativeView.c();
                textView3 = houseAdsNativeView.f();
                findViewById = houseAdsNativeView.a();
                cardView = houseAdsNativeView.b();
                imageView = houseAdsNativeView.e();
                imageView2 = houseAdsNativeView.d();
                ratingBar = houseAdsNativeView.g();
            } else {
                View view = this.f38005f;
                if (view != null) {
                    textView = (TextView) view.findViewById(R$id.houseAds_title);
                    textView2 = (TextView) this.f38005f.findViewById(R$id.houseAds_description);
                    textView3 = (TextView) this.f38005f.findViewById(R$id.houseAds_price);
                    findViewById = this.f38005f.findViewById(R$id.houseAds_cta);
                    cardView = (CardView) this.f38005f.findViewById(R$id.houseAds_card_view);
                    imageView = (ImageView) this.f38005f.findViewById(R$id.houseAds_app_icon);
                    imageView2 = (ImageView) this.f38005f.findViewById(R$id.houseAds_header_image);
                    ratingBar = (RatingBar) this.f38005f.findViewById(R$id.houseAds_rating);
                } else {
                    throw new NullPointerException("NativeAdView is Null. Either pass HouseAdsNativeView or a View in showNative()");
                }
            }
            TextView textView4 = textView;
            TextView textView5 = textView2;
            TextView textView6 = textView3;
            View view2 = findViewById;
            ImageView imageView3 = imageView2;
            RatingBar ratingBar2 = ratingBar;
            ImageView imageView4 = imageView;
            CardView cardView2 = cardView;
            ImageView imageView5 = imageView4;
            if (dialogModal.d().trim().isEmpty() || !dialogModal.d().trim().contains(UriUtil.HTTP_SCHEME)) {
                throw new IllegalArgumentException("Icon URL should not be Null or Blank & should start with \"http\"");
            } else if (!dialogModal.e().trim().isEmpty() && !dialogModal.e().trim().contains(UriUtil.HTTP_SCHEME)) {
                throw new IllegalArgumentException("Header Image URL should start with \"http\"");
            } else if (dialogModal.b().trim().isEmpty() || dialogModal.a().trim().isEmpty()) {
                throw new IllegalArgumentException("Title & description should not be Null or Blank.");
            } else {
                AnonymousClass1 r9 = r0;
                final ImageView imageView6 = imageView5;
                RequestCreator b2 = PicassoHelper.b(dialogModal.d());
                final View view3 = view2;
                ImageView imageView7 = imageView3;
                final DialogModal dialogModal2 = dialogModal;
                View view4 = view2;
                ImageView imageView8 = imageView5;
                final RatingBar ratingBar3 = ratingBar2;
                CardView cardView3 = cardView2;
                final ImageView imageView9 = imageView7;
                AnonymousClass1 r02 = new Callback() {
                    public void onError(Exception exc) {
                        boolean unused = HouseAdsNative.this.f38003d = false;
                        if ((imageView9 == null || dialogModal2.e().isEmpty()) && HouseAdsNative.this.f38006g != null) {
                            HouseAdsNative.this.f38006g.a(exc);
                        }
                    }

                    public void onSuccess() {
                        if (HouseAdsNative.this.f38002c) {
                            int h2 = Palette.b(((BitmapDrawable) imageView6.getDrawable()).getBitmap()).b().h(ContextCompat.getColor(HouseAdsNative.this.f38000a, R$color.colorAccent));
                            if (view3.getBackground() instanceof ColorDrawable) {
                                view3.setBackground(new GradientDrawable());
                            }
                            ((GradientDrawable) view3.getBackground()).setColor(h2);
                            if (dialogModal2.h() > 0.0f) {
                                ratingBar3.setRating(dialogModal2.h());
                                DrawableCompat.n(ratingBar3.getProgressDrawable(), h2);
                            } else {
                                ratingBar3.setVisibility(8);
                            }
                        }
                        if (dialogModal2.e().trim().isEmpty()) {
                            boolean unused = HouseAdsNative.this.f38003d = true;
                            if (HouseAdsNative.this.f38006g != null) {
                                HouseAdsNative.this.f38006g.onAdLoaded();
                            }
                        }
                    }
                };
                b2.into(imageView8, r9);
                if (z2 || dialogModal.e().trim().isEmpty()) {
                    ImageView imageView10 = imageView7;
                    if (imageView10 != null) {
                        imageView10.setVisibility(8);
                    }
                } else {
                    final ImageView imageView11 = imageView7;
                    PicassoHelper.b(dialogModal.e()).into((Target) new Target() {
                        public void onBitmapFailed(Exception exc, Drawable drawable) {
                            if (HouseAdsNative.this.f38006g != null) {
                                HouseAdsNative.this.f38006g.a(exc);
                            }
                            boolean unused = HouseAdsNative.this.f38003d = false;
                        }

                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                            ImageView imageView = imageView11;
                            if (imageView != null) {
                                imageView.setVisibility(0);
                                imageView11.setImageBitmap(bitmap);
                            }
                            boolean unused = HouseAdsNative.this.f38003d = true;
                            if (HouseAdsNative.this.f38006g != null) {
                                HouseAdsNative.this.f38006g.onAdLoaded();
                            }
                        }

                        public void onPrepareLoad(Drawable drawable) {
                        }
                    });
                }
                textView4.setText(dialogModal.b());
                textView5.setText(dialogModal.a());
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    if (!dialogModal.g().trim().isEmpty()) {
                        textView6.setText(String.format("Price: %s", new Object[]{dialogModal.g()}));
                    } else {
                        textView6.setVisibility(8);
                    }
                }
                if (ratingBar2 != null) {
                    ratingBar2.setVisibility(0);
                    if (dialogModal.h() > 0.0f) {
                        ratingBar2.setRating(dialogModal.h());
                    } else {
                        ratingBar2.setVisibility(8);
                    }
                }
                if (view4 != null) {
                    View view5 = view4;
                    boolean z3 = view5 instanceof TextView;
                    if (z3) {
                        ((TextView) view5).setText(dialogModal.c());
                    }
                    if (view5 instanceof Button) {
                        ((Button) view5).setText(dialogModal.c());
                    }
                    if (z3) {
                        view5.setOnClickListener(new g(this, dialogModal));
                    } else {
                        throw new IllegalArgumentException("Call to Action View must be either a Button or a TextView");
                    }
                }
                cardView3.setOnClickListener(new h(this, dialogModal));
            }
        }
        return this.f38003d;
    }

    public void m(boolean z2) {
        this.f38002c = z2;
    }
}
