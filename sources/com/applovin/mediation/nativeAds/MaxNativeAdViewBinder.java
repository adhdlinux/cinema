package com.applovin.mediation.nativeAds;

import android.view.View;

public class MaxNativeAdViewBinder {
    protected final int advertiserTextViewId;
    protected final int bodyTextViewId;
    protected final int callToActionButtonId;
    protected final int iconContentViewId;
    protected final int iconImageViewId;
    protected final int layoutResourceId;
    protected final View mainView;
    protected final int mediaContentFrameLayoutId;
    protected final int mediaContentViewGroupId;
    protected final int optionsContentFrameLayoutId;
    protected final int optionsContentViewGroupId;
    protected final String templateType;
    protected final int titleTextViewId;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final View f16002a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16003b;

        /* renamed from: c  reason: collision with root package name */
        private int f16004c;

        /* renamed from: d  reason: collision with root package name */
        private int f16005d;

        /* renamed from: e  reason: collision with root package name */
        private int f16006e;

        /* renamed from: f  reason: collision with root package name */
        private int f16007f;

        /* renamed from: g  reason: collision with root package name */
        private int f16008g;

        /* renamed from: h  reason: collision with root package name */
        private int f16009h;

        /* renamed from: i  reason: collision with root package name */
        private int f16010i;

        /* renamed from: j  reason: collision with root package name */
        private int f16011j;

        /* renamed from: k  reason: collision with root package name */
        private int f16012k;

        /* renamed from: l  reason: collision with root package name */
        private int f16013l;

        /* renamed from: m  reason: collision with root package name */
        private String f16014m;

        public Builder(int i2) {
            this(i2, (View) null);
        }

        private Builder(int i2, View view) {
            this.f16004c = -1;
            this.f16005d = -1;
            this.f16006e = -1;
            this.f16007f = -1;
            this.f16008g = -1;
            this.f16009h = -1;
            this.f16010i = -1;
            this.f16011j = -1;
            this.f16012k = -1;
            this.f16013l = -1;
            this.f16003b = i2;
            this.f16002a = view;
        }

        public Builder(View view) {
            this(-1, view);
        }

        public MaxNativeAdViewBinder build() {
            return new MaxNativeAdViewBinder(this.f16002a, this.f16003b, this.f16004c, this.f16005d, this.f16006e, this.f16007f, this.f16008g, this.f16009h, this.f16010i, this.f16011j, this.f16012k, this.f16013l, this.f16014m);
        }

        public Builder setAdvertiserTextViewId(int i2) {
            this.f16005d = i2;
            return this;
        }

        public Builder setBodyTextViewId(int i2) {
            this.f16006e = i2;
            return this;
        }

        public Builder setCallToActionButtonId(int i2) {
            this.f16013l = i2;
            return this;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public Builder setIconContentViewId(int i2) {
            this.f16008g = i2;
            return this;
        }

        public Builder setIconImageViewId(int i2) {
            this.f16007f = i2;
            return this;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public Builder setMediaContentFrameLayoutId(int i2) {
            this.f16012k = i2;
            return this;
        }

        public Builder setMediaContentViewGroupId(int i2) {
            this.f16011j = i2;
            return this;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public Builder setOptionsContentFrameLayoutId(int i2) {
            this.f16010i = i2;
            return this;
        }

        public Builder setOptionsContentViewGroupId(int i2) {
            this.f16009h = i2;
            return this;
        }

        /* access modifiers changed from: protected */
        public Builder setTemplateType(String str) {
            this.f16014m = str;
            return this;
        }

        public Builder setTitleTextViewId(int i2) {
            this.f16004c = i2;
            return this;
        }
    }

    private MaxNativeAdViewBinder(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, String str) {
        this.mainView = view;
        this.layoutResourceId = i2;
        this.titleTextViewId = i3;
        this.advertiserTextViewId = i4;
        this.bodyTextViewId = i5;
        this.iconImageViewId = i6;
        this.iconContentViewId = i7;
        this.optionsContentViewGroupId = i8;
        this.optionsContentFrameLayoutId = i9;
        this.mediaContentViewGroupId = i10;
        this.mediaContentFrameLayoutId = i11;
        this.callToActionButtonId = i12;
        this.templateType = str;
    }
}
