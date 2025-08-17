package com.yoku.house.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
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
import com.yoku.house.ads.helper.cacheImages.PicassoHelper;
import com.yoku.house.ads.listener.AdListener;
import com.yoku.house.ads.model.DialogModal;
import java.util.ArrayList;
import n1.a;
import n1.b;
import n1.c;
import n1.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HouseAdsDialog {
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static boolean f37972k = false;

    /* renamed from: l  reason: collision with root package name */
    private static int f37973l;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f37974a;

    /* renamed from: b  reason: collision with root package name */
    private String f37975b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f37976c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f37977d = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f37978e = true;

    /* renamed from: f  reason: collision with root package name */
    private int f37979f = 25;

    /* renamed from: g  reason: collision with root package name */
    private int f37980g = 25;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public AdListener f37981h;

    /* renamed from: i  reason: collision with root package name */
    private AlertDialog f37982i;

    /* renamed from: j  reason: collision with root package name */
    private String f37983j;

    public HouseAdsDialog(Context context, String str) {
        this.f37974a = context;
        this.f37983j = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(DialogInterface dialogInterface) {
        AdListener adListener = this.f37981h;
        if (adListener != null) {
            adListener.c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(DialogInterface dialogInterface) {
        AdListener adListener = this.f37981h;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(DialogInterface dialogInterface) {
        AdListener adListener = this.f37981h;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(DialogModal dialogModal, View view) {
        this.f37982i.dismiss();
        String f2 = dialogModal.f();
        if (f2.trim().startsWith(UriUtil.HTTP_SCHEME)) {
            this.f37974a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f2)));
            AdListener adListener = this.f37981h;
            if (adListener != null) {
                adListener.b();
                return;
            }
            return;
        }
        try {
            Context context = this.f37974a;
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + f2)));
            AdListener adListener2 = this.f37981h;
            if (adListener2 != null) {
                adListener2.b();
            }
        } catch (ActivityNotFoundException unused) {
            AdListener adListener3 = this.f37981h;
            if (adListener3 != null) {
                adListener3.b();
            }
            Context context2 = this.f37974a;
            context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + f2)));
        }
    }

    private void o(String str) {
        boolean z2;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f37974a);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("apps");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                if (jSONObject.optString("app_adType").equals("dialog")) {
                    if (jSONObject.has("hideIfAppInstalled")) {
                        z2 = jSONObject.optBoolean("hideIfAppInstalled");
                    } else {
                        z2 = true;
                    }
                    if (jSONObject.optString("app_uri").startsWith(UriUtil.HTTP_SCHEME) || !z2 || !HouseAdsHelper.a(this.f37974a, jSONObject.optString("app_uri"))) {
                        DialogModal dialogModal = new DialogModal();
                        dialogModal.j(jSONObject.optString("app_title"));
                        dialogModal.i(jSONObject.optString("app_desc"));
                        dialogModal.l(jSONObject.optString("app_icon"));
                        dialogModal.m(jSONObject.optString("app_header_image"));
                        dialogModal.k(jSONObject.optString("app_cta_text"));
                        dialogModal.n(jSONObject.optString("app_uri"));
                        dialogModal.p(jSONObject.optString("app_rating"));
                        dialogModal.o(jSONObject.optString("app_price"));
                        arrayList.add(dialogModal);
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (arrayList.size() > 0) {
            DialogModal dialogModal2 = (DialogModal) arrayList.get(f37973l);
            if (f37973l == arrayList.size() - 1) {
                f37973l = 0;
            } else {
                f37973l++;
            }
            View inflate = View.inflate(this.f37974a, R$layout.house_ads_dialog_layout, (ViewGroup) null);
            if (dialogModal2.d().trim().isEmpty() || !dialogModal2.d().trim().startsWith(UriUtil.HTTP_SCHEME)) {
                throw new IllegalArgumentException("Icon URL should not be Null or Blank & should start with \"http\"");
            } else if (!dialogModal2.e().trim().isEmpty() && !dialogModal2.e().trim().startsWith(UriUtil.HTTP_SCHEME)) {
                throw new IllegalArgumentException("Header Image URL should start with \"http\"");
            } else if (dialogModal2.b().trim().isEmpty() || dialogModal2.a().trim().isEmpty()) {
                throw new IllegalArgumentException("Title & description should not be Null or Blank.");
            } else {
                ((CardView) inflate.findViewById(R$id.houseAds_card_view)).setRadius((float) this.f37979f);
                Button button = (Button) inflate.findViewById(R$id.houseAds_cta);
                ((GradientDrawable) button.getBackground()).setCornerRadius((float) this.f37980g);
                ImageView imageView = (ImageView) inflate.findViewById(R$id.houseAds_app_icon);
                final ImageView imageView2 = (ImageView) inflate.findViewById(R$id.houseAds_header_image);
                TextView textView = (TextView) inflate.findViewById(R$id.houseAds_title);
                AnonymousClass1 r9 = r1;
                final ImageView imageView3 = imageView;
                RequestCreator b2 = PicassoHelper.b(dialogModal2.d());
                final Button button2 = button;
                AlertDialog.Builder builder2 = builder;
                TextView textView2 = (TextView) inflate.findViewById(R$id.houseAds_price);
                final DialogModal dialogModal3 = dialogModal2;
                View view = inflate;
                TextView textView3 = (TextView) inflate.findViewById(R$id.houseAds_description);
                final RatingBar ratingBar = (RatingBar) inflate.findViewById(R$id.houseAds_rating);
                AnonymousClass1 r12 = new Callback() {
                    public void onError(Exception exc) {
                        boolean unused = HouseAdsDialog.f37972k = false;
                        if (HouseAdsDialog.this.f37981h != null) {
                            HouseAdsDialog.this.f37981h.a(exc);
                        }
                        imageView3.setVisibility(8);
                    }

                    public void onSuccess() {
                        boolean unused = HouseAdsDialog.f37972k = true;
                        if (HouseAdsDialog.this.f37981h != null) {
                            HouseAdsDialog.this.f37981h.onAdLoaded();
                        }
                        if (imageView3.getVisibility() == 8) {
                            imageView3.setVisibility(0);
                        }
                        Context g2 = HouseAdsDialog.this.f37974a;
                        int i2 = R$color.colorAccent;
                        int color = ContextCompat.getColor(g2, i2);
                        if (HouseAdsDialog.this.f37978e) {
                            color = Palette.b(((BitmapDrawable) imageView3.getDrawable()).getBitmap()).b().h(ContextCompat.getColor(HouseAdsDialog.this.f37974a, i2));
                        }
                        ((GradientDrawable) button2.getBackground()).setColor(color);
                        if (dialogModal3.h() > 0.0f) {
                            ratingBar.setRating(dialogModal3.h());
                            DrawableCompat.n(ratingBar.getProgressDrawable(), color);
                            return;
                        }
                        ratingBar.setVisibility(8);
                    }
                };
                b2.into(imageView, r9);
                if (dialogModal2.e().trim().isEmpty() || !this.f37976c) {
                    imageView2.setVisibility(8);
                } else {
                    PicassoHelper.b(dialogModal2.e()).into((Target) new Target() {
                        public void onBitmapFailed(Exception exc, Drawable drawable) {
                            imageView2.setVisibility(8);
                        }

                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                            imageView2.setImageBitmap(bitmap);
                            imageView2.setVisibility(0);
                        }

                        public void onPrepareLoad(Drawable drawable) {
                        }
                    });
                }
                textView.setText(dialogModal2.b());
                textView3.setText(dialogModal2.a());
                button.setText(dialogModal2.c());
                if (dialogModal2.g().trim().isEmpty()) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(String.format("Price: %s", new Object[]{dialogModal2.g()}));
                }
                AlertDialog.Builder builder3 = builder2;
                builder3.setView(view);
                AlertDialog create = builder3.create();
                this.f37982i = create;
                create.getWindow().setBackgroundDrawableResource(17170445);
                this.f37982i.setOnShowListener(new a(this));
                this.f37982i.setOnCancelListener(new b(this));
                this.f37982i.setOnDismissListener(new c(this));
                button.setOnClickListener(new d(this, dialogModal2));
            }
        }
    }

    public void m() {
        f37972k = false;
        if (this.f37977d || this.f37975b.isEmpty()) {
            if (!this.f37983j.trim().isEmpty()) {
                String str = this.f37983j;
                this.f37975b = str;
                o(str);
            } else {
                AdListener adListener = this.f37981h;
                if (adListener != null) {
                    adListener.a(new Exception("Null Response"));
                }
            }
        }
        if (!this.f37977d && !this.f37975b.trim().isEmpty()) {
            o(this.f37975b);
        }
    }

    public void n(AdListener adListener) {
        this.f37981h = adListener;
    }

    public void p(boolean z2) {
        this.f37976c = z2;
    }

    public void q(boolean z2) {
        this.f37978e = z2;
    }
}
