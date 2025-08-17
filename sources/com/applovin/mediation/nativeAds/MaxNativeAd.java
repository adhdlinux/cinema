package com.applovin.mediation.nativeAds;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import com.applovin.mediation.MaxAdFormat;

public class MaxNativeAd {
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final MaxAdFormat format;
    private final MaxNativeAdImage icon;
    private final View iconView;
    private final MaxNativeAdImage mainImage;
    private final float mediaContentAspectRatio;
    private final View mediaView;
    private MaxNativeAdView nativeAdView;
    private final View optionsView;
    private final String title;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public MaxAdFormat f15972a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f15973b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f15974c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f15975d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f15976e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public MaxNativeAdImage f15977f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public View f15978g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public View f15979h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public View f15980i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public MaxNativeAdImage f15981j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public float f15982k;

        public MaxNativeAd build() {
            return new MaxNativeAd(this);
        }

        public Builder setAdFormat(MaxAdFormat maxAdFormat) {
            this.f15972a = maxAdFormat;
            return this;
        }

        public Builder setAdvertiser(String str) {
            this.f15974c = str;
            return this;
        }

        public Builder setBody(String str) {
            this.f15975d = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.f15976e = str;
            return this;
        }

        public Builder setIcon(MaxNativeAdImage maxNativeAdImage) {
            this.f15977f = maxNativeAdImage;
            return this;
        }

        public Builder setIconView(View view) {
            this.f15978g = view;
            return this;
        }

        public Builder setMainImage(MaxNativeAdImage maxNativeAdImage) {
            this.f15981j = maxNativeAdImage;
            return this;
        }

        public Builder setMediaContentAspectRatio(float f2) {
            this.f15982k = f2;
            return this;
        }

        public Builder setMediaView(View view) {
            this.f15980i = view;
            return this;
        }

        public Builder setOptionsView(View view) {
            this.f15979h = view;
            return this;
        }

        public Builder setTitle(String str) {
            this.f15973b = str;
            return this;
        }
    }

    public static class MaxNativeAdImage {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f15983a;

        /* renamed from: b  reason: collision with root package name */
        private Uri f15984b;

        public MaxNativeAdImage(Drawable drawable) {
            this.f15983a = drawable;
        }

        public MaxNativeAdImage(Uri uri) {
            this.f15984b = uri;
        }

        public Drawable getDrawable() {
            return this.f15983a;
        }

        public Uri getUri() {
            return this.f15984b;
        }
    }

    public MaxNativeAd(Builder builder) {
        this.format = builder.f15972a;
        this.title = builder.f15973b;
        this.advertiser = builder.f15974c;
        this.body = builder.f15975d;
        this.callToAction = builder.f15976e;
        this.icon = builder.f15977f;
        this.iconView = builder.f15978g;
        this.optionsView = builder.f15979h;
        this.mediaView = builder.f15980i;
        this.mainImage = builder.f15981j;
        this.mediaContentAspectRatio = builder.f15982k;
    }

    public final String getAdvertiser() {
        return this.advertiser;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getCallToAction() {
        return this.callToAction;
    }

    public final MaxAdFormat getFormat() {
        return this.format;
    }

    public final MaxNativeAdImage getIcon() {
        return this.icon;
    }

    public final View getIconView() {
        return this.iconView;
    }

    public final MaxNativeAdImage getMainImage() {
        return this.mainImage;
    }

    public final float getMediaContentAspectRatio() {
        return this.mediaContentAspectRatio;
    }

    public final View getMediaView() {
        return this.mediaView;
    }

    public final View getOptionsView() {
        return this.optionsView;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void performClick() {
        Button callToActionButton;
        MaxNativeAdView maxNativeAdView = this.nativeAdView;
        if (maxNativeAdView != null && (callToActionButton = maxNativeAdView.getCallToActionButton()) != null) {
            callToActionButton.performClick();
        }
    }

    public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
    }

    public void setNativeAdView(MaxNativeAdView maxNativeAdView) {
        this.nativeAdView = maxNativeAdView;
    }
}
