package com.applovin.mediation.nativeAds;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.ads.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.R;
import java.lang.ref.WeakReference;

@SuppressLint({"ViewConstructor"})
public class MaxNativeAdView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final View f15986a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f15987b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f15988c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f15989d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f15990e;

    /* renamed from: f  reason: collision with root package name */
    private final FrameLayout f15991f;

    /* renamed from: g  reason: collision with root package name */
    private final ViewGroup f15992g;

    /* renamed from: h  reason: collision with root package name */
    private final FrameLayout f15993h;

    /* renamed from: i  reason: collision with root package name */
    private final ViewGroup f15994i;

    /* renamed from: j  reason: collision with root package name */
    private final FrameLayout f15995j;

    /* renamed from: k  reason: collision with root package name */
    private final Button f15996k;

    /* renamed from: l  reason: collision with root package name */
    private b f15997l;

    public MaxNativeAdView(MaxNativeAd maxNativeAd, Activity activity) {
        this(maxNativeAd, (String) null, activity);
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        super(context);
        boolean z2 = maxNativeAdViewBinder.templateType != null;
        MaxAdFormat format = maxNativeAd != null ? maxNativeAd.getFormat() : MaxAdFormat.NATIVE;
        View view = maxNativeAdViewBinder.mainView;
        if (view != null) {
            this.f15986a = view;
        } else {
            this.f15986a = LayoutInflater.from(context).inflate(z2 ? a(maxNativeAdViewBinder.templateType, format) : maxNativeAdViewBinder.layoutResourceId, this, false);
        }
        addView(this.f15986a);
        this.f15987b = (TextView) findViewById(maxNativeAdViewBinder.titleTextViewId);
        this.f15988c = (TextView) findViewById(maxNativeAdViewBinder.advertiserTextViewId);
        this.f15989d = (TextView) findViewById(maxNativeAdViewBinder.bodyTextViewId);
        this.f15990e = (ImageView) findViewById(maxNativeAdViewBinder.iconImageViewId);
        this.f15991f = (FrameLayout) findViewById(maxNativeAdViewBinder.iconContentViewId);
        this.f15992g = (ViewGroup) findViewById(maxNativeAdViewBinder.optionsContentViewGroupId);
        this.f15993h = (FrameLayout) findViewById(maxNativeAdViewBinder.optionsContentFrameLayoutId);
        this.f15994i = (ViewGroup) findViewById(maxNativeAdViewBinder.mediaContentViewGroupId);
        this.f15995j = (FrameLayout) findViewById(maxNativeAdViewBinder.mediaContentFrameLayoutId);
        this.f15996k = (Button) findViewById(maxNativeAdViewBinder.callToActionButtonId);
        if (maxNativeAd != null) {
            a(maxNativeAd);
        }
    }

    @Deprecated
    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Activity activity) {
        this(maxNativeAd, str, activity.getApplicationContext());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaxNativeAdView(com.applovin.mediation.nativeAds.MaxNativeAd r3, java.lang.String r4, android.content.Context r5) {
        /*
            r2 = this;
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r0 = new com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder
            r1 = -1
            r0.<init>((int) r1)
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r0.setTemplateType(r4)
            int r0 = com.applovin.sdk.R.id.native_title_text_view
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setTitleTextViewId(r0)
            int r0 = com.applovin.sdk.R.id.native_advertiser_text_view
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setAdvertiserTextViewId(r0)
            int r0 = com.applovin.sdk.R.id.native_body_text_view
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setBodyTextViewId(r0)
            int r0 = com.applovin.sdk.R.id.native_icon_image_view
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setIconImageViewId(r0)
            int r0 = com.applovin.sdk.R.id.native_icon_view
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setIconContentViewId(r0)
            int r0 = com.applovin.sdk.R.id.options_view
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setOptionsContentViewGroupId(r0)
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setOptionsContentFrameLayoutId(r0)
            int r0 = com.applovin.sdk.R.id.native_media_content_view
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setMediaContentViewGroupId(r0)
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setMediaContentFrameLayoutId(r0)
            int r0 = com.applovin.sdk.R.id.native_cta_button
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder$Builder r4 = r4.setCallToActionButtonId(r0)
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder r4 = r4.build()
            r2.<init>((com.applovin.mediation.nativeAds.MaxNativeAd) r3, (com.applovin.mediation.nativeAds.MaxNativeAdViewBinder) r4, (android.content.Context) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.mediation.nativeAds.MaxNativeAdView.<init>(com.applovin.mediation.nativeAds.MaxNativeAd, java.lang.String, android.content.Context):void");
    }

    public MaxNativeAdView(MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        this((MaxNativeAd) null, maxNativeAdViewBinder, context);
    }

    public MaxNativeAdView(String str, Context context) {
        this((MaxNativeAd) null, str, context);
    }

    private int a(String str, MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.NATIVE) {
            if ("small_template_1".equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_small_template_1;
            }
            if ("medium_template_1".equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_medium_template_1;
            }
            throw new IllegalArgumentException("Attempting to render MAX native ad with invalid format: " + str);
        } else if (maxAdFormat == MaxAdFormat.BANNER) {
            return "vertical_banner_template".equals(str) ? R.layout.max_native_ad_vertical_banner_view : ("media_banner_template".equals(str) || "no_body_banner_template".equals(str)) ? R.layout.max_native_ad_media_banner_view : "vertical_media_banner_template".equals(str) ? R.layout.max_native_ad_vertical_media_banner_view : R.layout.max_native_ad_banner_view;
        } else {
            if (maxAdFormat == MaxAdFormat.LEADER) {
                return "vertical_leader_template".equals(str) ? R.layout.max_native_ad_vertical_leader_view : R.layout.max_native_ad_leader_view;
            }
            if (maxAdFormat == MaxAdFormat.MREC) {
                return R.layout.max_native_ad_mrec_view;
            }
            throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
        }
    }

    private void a() {
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.inner_parent_layout);
        if (viewGroup != null) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                final WeakReference weakReference = new WeakReference(viewTreeObserver);
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                            m mVar = AppLovinSdk.getInstance(MaxNativeAdView.this.getContext()).coreSdk;
                            if (v.a()) {
                                mVar.A().d("MaxNativeAdView", "Failed to remove onPreDrawListener since the view tree observer is not alive.");
                            }
                        } else {
                            viewTreeObserver.removeOnPreDrawListener(this);
                        }
                        weakReference.clear();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                        layoutParams.height = ((View) viewGroup.getParent()).getWidth();
                        viewGroup.setLayoutParams(layoutParams);
                        return true;
                    }
                });
            }
        }
    }

    private void a(MaxNativeAd maxNativeAd) {
        this.f15987b.setText(maxNativeAd.getTitle());
        if (this.f15988c != null) {
            if (StringUtils.isValidString(maxNativeAd.getAdvertiser())) {
                this.f15988c.setText(maxNativeAd.getAdvertiser());
            } else {
                this.f15988c.setVisibility(8);
            }
        }
        if (this.f15989d != null) {
            if (StringUtils.isValidString(maxNativeAd.getBody())) {
                this.f15989d.setText(maxNativeAd.getBody());
            } else {
                this.f15989d.setVisibility(4);
            }
        }
        if (this.f15996k != null) {
            if (StringUtils.isValidString(maxNativeAd.getCallToAction())) {
                this.f15996k.setText(maxNativeAd.getCallToAction());
            } else {
                this.f15996k.setVisibility(4);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        View iconView = maxNativeAd.getIconView();
        FrameLayout frameLayout = this.f15991f;
        if (frameLayout != null) {
            if (icon == null || this.f15990e == null) {
                if (iconView != null) {
                    iconView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    this.f15991f.removeAllViews();
                    this.f15991f.addView(iconView);
                } else {
                    frameLayout.setVisibility(8);
                }
            } else if (icon.getDrawable() != null) {
                this.f15990e.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() == null || !StringUtils.isValidString(icon.getUri().toString())) {
                this.f15991f.setVisibility(8);
            } else {
                this.f15990e.setImageURI(icon.getUri());
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        FrameLayout frameLayout2 = this.f15993h;
        if (frameLayout2 != null && optionsView != null) {
            optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f15993h.addView(optionsView);
        } else if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        View mediaView = maxNativeAd.getMediaView();
        if (this.f15995j != null) {
            if (mediaView != null) {
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f15995j.addView(mediaView);
            } else if (maxNativeAd.getFormat() == MaxAdFormat.LEADER) {
                this.f15995j.setVisibility(8);
            }
        }
        a();
        postDelayed(new Runnable() {
            public void run() {
                MaxNativeAdView.this.setSelected(true);
            }
        }, 2000);
    }

    private void b(MaxNativeAd maxNativeAd) {
        if (this.f15987b != null) {
            if (StringUtils.isValidString(maxNativeAd.getTitle())) {
                this.f15987b.setText(maxNativeAd.getTitle());
            } else {
                this.f15987b.setText((CharSequence) null);
            }
        }
        String body = maxNativeAd.getBody();
        if (this.f15989d != null) {
            if (StringUtils.isValidString(body)) {
                this.f15989d.setText(body);
            } else {
                this.f15989d.setText((CharSequence) null);
            }
        }
        String advertiser = maxNativeAd.getAdvertiser();
        if (this.f15988c != null) {
            if (StringUtils.isValidString(advertiser)) {
                this.f15988c.setText(advertiser);
            } else {
                this.f15988c.setText((CharSequence) null);
            }
        }
        String callToAction = maxNativeAd.getCallToAction();
        if (this.f15996k != null) {
            if (StringUtils.isValidString(callToAction)) {
                this.f15996k.setText(callToAction);
            } else {
                this.f15996k.setText((CharSequence) null);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        ImageView imageView = this.f15990e;
        if (imageView != null) {
            if (icon == null) {
                imageView.setImageDrawable((Drawable) null);
            } else if (icon.getDrawable() != null) {
                this.f15990e.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() != null) {
                this.f15990e.setImageURI(icon.getUri());
            } else {
                this.f15990e.setImageDrawable((Drawable) null);
            }
        }
        View mediaView = maxNativeAd.getMediaView();
        ViewGroup viewGroup = this.f15994i;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (mediaView != null) {
                ViewParent parent = mediaView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeAllViews();
                }
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f15994i.addView(mediaView);
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        ViewGroup viewGroup2 = this.f15992g;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            if (optionsView != null) {
                ViewParent parent2 = optionsView.getParent();
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeAllViews();
                }
                optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f15992g.addView(optionsView);
            }
        }
    }

    public b getAdViewTracker() {
        return this.f15997l;
    }

    public TextView getAdvertiserTextView() {
        return this.f15988c;
    }

    public TextView getBodyTextView() {
        return this.f15989d;
    }

    public Button getCallToActionButton() {
        return this.f15996k;
    }

    @Deprecated
    public FrameLayout getIconContentView() {
        return this.f15991f;
    }

    public ImageView getIconImageView() {
        return this.f15990e;
    }

    public View getMainView() {
        return this.f15986a;
    }

    @Deprecated
    public FrameLayout getMediaContentView() {
        return this.f15995j;
    }

    public ViewGroup getMediaContentViewGroup() {
        ViewGroup viewGroup = this.f15994i;
        return viewGroup != null ? viewGroup : this.f15995j;
    }

    @Deprecated
    public FrameLayout getOptionsContentView() {
        return this.f15993h;
    }

    public ViewGroup getOptionsContentViewGroup() {
        ViewGroup viewGroup = this.f15992g;
        return viewGroup != null ? viewGroup : this.f15993h;
    }

    public TextView getTitleTextView() {
        return this.f15987b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f15997l;
        if (bVar != null) {
            bVar.b();
        }
        if (!isHardwareAccelerated() && v.a()) {
            v.h("MaxNativeAdView", "Attached to non-hardware accelerated window: some native ad views require hardware accelerated Activities to render properly.");
        }
    }

    public void recycle() {
        b bVar = this.f15997l;
        if (bVar != null) {
            bVar.a();
            this.f15997l = null;
        }
        View view = this.f15986a;
        if (view != null && view.getParent() != this) {
            ViewGroup viewGroup = (ViewGroup) this.f15986a.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                removeView(viewGroup);
            }
            addView(this.f15986a);
        }
    }

    public void render(d dVar, a.C0011a aVar, m mVar) {
        recycle();
        if (!dVar.y().get() || !dVar.x().get()) {
            this.f15997l = new b(dVar, aVar, mVar);
        }
        MaxNativeAd nativeAd = dVar.getNativeAd();
        if (StringUtils.isValidString(dVar.v())) {
            a(nativeAd);
        } else {
            b(nativeAd);
        }
    }
}
