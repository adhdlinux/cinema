package com.startapp.sdk.ads.nativead;

import com.startapp.sdk.adsbase.model.AdPreferences;

public class NativeAdPreferences extends AdPreferences {
    private static final long serialVersionUID = 1;
    private int adsNumber = 1;
    private boolean autoBitmapDownload = false;
    private NativeAdBitmapSize bitmapSize;
    private boolean isContentAd = false;
    private int moreImage = -1;
    private int primaryImage = -1;
    private boolean useSimpleToken = true;

    public enum NativeAdBitmapSize {
        SIZE72X72(72, 72),
        SIZE100X100(100, 100),
        SIZE150X150(150, 150),
        SIZE340X340(340, 340);
        
        public int height;
        public int width;

        private NativeAdBitmapSize(int i2, int i3) {
            this.width = i2;
            this.height = i3;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public int getAdsNumber() {
        return this.adsNumber;
    }

    public NativeAdBitmapSize getImageSize() {
        return this.bitmapSize;
    }

    public int getPrimaryImageSize() {
        return this.primaryImage;
    }

    public int getSecondaryImageSize() {
        return this.moreImage;
    }

    public boolean isAutoBitmapDownload() {
        return this.autoBitmapDownload;
    }

    public boolean isContentAd() {
        return this.isContentAd;
    }

    public boolean isSimpleToken() {
        return this.useSimpleToken;
    }

    public NativeAdPreferences setAdsNumber(int i2) {
        if (i2 > 0) {
            this.adsNumber = i2;
            return this;
        }
        throw new IllegalArgumentException("Ads Number must be >= 1");
    }

    public NativeAdPreferences setAutoBitmapDownload(boolean z2) {
        this.autoBitmapDownload = z2;
        return this;
    }

    public NativeAdPreferences setContentAd(boolean z2) {
        this.isContentAd = z2;
        return this;
    }

    public NativeAdPreferences setImageSize(NativeAdBitmapSize nativeAdBitmapSize) {
        this.bitmapSize = nativeAdBitmapSize;
        return this;
    }

    public NativeAdPreferences setPrimaryImageSize(int i2) {
        this.primaryImage = i2;
        return this;
    }

    public NativeAdPreferences setSecondaryImageSize(int i2) {
        this.moreImage = i2;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n===== NativeAdConfig =====\n");
        stringBuffer.append("    adsNumber: [" + getAdsNumber() + "]\n");
        stringBuffer.append("    autoBitmapDownload: [" + isAutoBitmapDownload() + "]\n");
        stringBuffer.append("    useSimpleToken: [" + isSimpleToken() + "]\n");
        stringBuffer.append("===== End NativeAdConfig =====");
        return stringBuffer.toString();
    }

    public NativeAdPreferences useSimpleToken(boolean z2) {
        this.useSimpleToken = z2;
        return this;
    }
}
