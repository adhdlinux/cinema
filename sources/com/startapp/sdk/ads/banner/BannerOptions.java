package com.startapp.sdk.ads.banner;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import org.joda.time.DateTimeConstants;

public class BannerOptions implements Serializable {
    private static final long serialVersionUID = 6023183209176231429L;
    private int adsNumber = 4;
    private boolean checkCoverage = true;
    private boolean checkFocus = true;
    private int delayFaceTime = 5000;
    @j0(type = Effect.class)
    private Effect effect = Effect.ROTATE_3D;
    private int height = 50;
    private float heightRatio = 1.0f;
    private int htmlAdsNumber = 10;
    private float minScale = 0.88f;
    private int minViewabilityPercentage = 50;
    private int refreshRate = DateTimeConstants.MILLIS_PER_MINUTE;
    private int refreshRate3D = DateTimeConstants.MILLIS_PER_MINUTE;
    private boolean rotateThroughOnStart = true;
    private int rotateThroughSpeedMult = 2;
    private int scalePower = 4;
    private int stepSize = 5;
    private int timeBetweenFrames = 25;
    private int width = 300;
    private float widthRatio = 1.0f;

    public enum Effect {
        ROTATE_3D(1),
        EXCHANGE(2),
        FLY_IN(3);
        
        private int index;

        private Effect(int i2) {
            this.index = i2;
        }

        public int getRotationMultiplier() {
            return (int) Math.pow(2.0d, (double) (this.index - 1));
        }
    }

    public BannerOptions() {
    }

    public void a(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public int b() {
        return this.delayFaceTime;
    }

    public Effect c() {
        return this.effect;
    }

    public int d() {
        return this.height;
    }

    public float e() {
        return this.heightRatio;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BannerOptions.class != obj.getClass()) {
            return false;
        }
        BannerOptions bannerOptions = (BannerOptions) obj;
        if (this.width == bannerOptions.width && this.height == bannerOptions.height && this.minViewabilityPercentage == bannerOptions.minViewabilityPercentage && this.checkFocus == bannerOptions.checkFocus && this.checkCoverage == bannerOptions.checkCoverage && this.timeBetweenFrames == bannerOptions.timeBetweenFrames && this.stepSize == bannerOptions.stepSize && this.delayFaceTime == bannerOptions.delayFaceTime && this.adsNumber == bannerOptions.adsNumber && this.htmlAdsNumber == bannerOptions.htmlAdsNumber && this.refreshRate3D == bannerOptions.refreshRate3D && Float.compare(this.widthRatio, bannerOptions.widthRatio) == 0 && Float.compare(this.heightRatio, bannerOptions.heightRatio) == 0 && Float.compare(this.minScale, bannerOptions.minScale) == 0 && this.scalePower == bannerOptions.scalePower && this.rotateThroughOnStart == bannerOptions.rotateThroughOnStart && this.rotateThroughSpeedMult == bannerOptions.rotateThroughSpeedMult && this.refreshRate == bannerOptions.refreshRate && this.effect == bannerOptions.effect) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.htmlAdsNumber;
    }

    public float g() {
        return this.minScale;
    }

    public int h() {
        return this.minViewabilityPercentage;
    }

    public int hashCode() {
        Object[] objArr = {Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(this.minViewabilityPercentage), Boolean.valueOf(this.checkFocus), Boolean.valueOf(this.checkCoverage), Integer.valueOf(this.timeBetweenFrames), Integer.valueOf(this.stepSize), Integer.valueOf(this.delayFaceTime), Integer.valueOf(this.adsNumber), Integer.valueOf(this.htmlAdsNumber), Integer.valueOf(this.refreshRate3D), Float.valueOf(this.widthRatio), Float.valueOf(this.heightRatio), Float.valueOf(this.minScale), Integer.valueOf(this.scalePower), this.effect, Boolean.valueOf(this.rotateThroughOnStart), Integer.valueOf(this.rotateThroughSpeedMult), Integer.valueOf(this.refreshRate)};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public int i() {
        return this.refreshRate;
    }

    public int j() {
        return this.refreshRate3D;
    }

    public int k() {
        return this.rotateThroughSpeedMult;
    }

    public int l() {
        return this.scalePower;
    }

    public int m() {
        return this.stepSize;
    }

    public int n() {
        return this.timeBetweenFrames;
    }

    public int o() {
        return this.width;
    }

    public float p() {
        return this.widthRatio;
    }

    public boolean q() {
        return this.checkCoverage;
    }

    public boolean r() {
        return this.checkFocus;
    }

    public boolean s() {
        return this.rotateThroughOnStart;
    }

    public int a() {
        return this.adsNumber;
    }

    public BannerOptions(BannerOptions bannerOptions) {
        this.width = bannerOptions.width;
        this.height = bannerOptions.height;
        this.timeBetweenFrames = bannerOptions.timeBetweenFrames;
        this.stepSize = bannerOptions.stepSize;
        this.delayFaceTime = bannerOptions.delayFaceTime;
        this.adsNumber = bannerOptions.adsNumber;
        this.htmlAdsNumber = bannerOptions.htmlAdsNumber;
        this.refreshRate3D = bannerOptions.refreshRate3D;
        this.widthRatio = bannerOptions.widthRatio;
        this.heightRatio = bannerOptions.heightRatio;
        this.minScale = bannerOptions.minScale;
        this.scalePower = bannerOptions.scalePower;
        this.effect = bannerOptions.effect;
        this.rotateThroughOnStart = bannerOptions.rotateThroughOnStart;
        this.rotateThroughSpeedMult = bannerOptions.rotateThroughSpeedMult;
        this.refreshRate = bannerOptions.refreshRate;
        this.minViewabilityPercentage = bannerOptions.minViewabilityPercentage;
        this.checkFocus = bannerOptions.checkFocus;
        this.checkCoverage = bannerOptions.checkCoverage;
    }
}
