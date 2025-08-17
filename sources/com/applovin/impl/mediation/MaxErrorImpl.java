package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxError;

public class MaxErrorImpl implements MaxError {
    private String adLoadFailureInfo;
    private final int errorCode;
    private final String errorMessage;
    private String loadTag;
    private final int mediatedNetworkErrorCode;
    private final String mediatedNetworkErrorMessage;
    private MaxAdWaterfallInfo waterfall;

    public MaxErrorImpl(int i2) {
        this(i2, "");
    }

    public MaxErrorImpl(int i2, String str) {
        this(i2, str, -1, "");
    }

    public MaxErrorImpl(int i2, String str, int i3, String str2) {
        this.errorCode = i2;
        this.errorMessage = StringUtils.emptyIfNull(str);
        this.mediatedNetworkErrorCode = i3;
        this.mediatedNetworkErrorMessage = StringUtils.emptyIfNull(str2);
    }

    public MaxErrorImpl(String str) {
        this(-1, str);
    }

    public String getAdLoadFailureInfo() {
        return this.adLoadFailureInfo;
    }

    public int getCode() {
        return this.errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getLoadTag() {
        return this.loadTag;
    }

    public int getMediatedNetworkErrorCode() {
        return this.mediatedNetworkErrorCode;
    }

    public String getMediatedNetworkErrorMessage() {
        return this.mediatedNetworkErrorMessage;
    }

    public String getMessage() {
        return this.errorMessage;
    }

    public MaxAdWaterfallInfo getWaterfall() {
        return this.waterfall;
    }

    public void setAdLoadFailureInfo(String str) {
        this.adLoadFailureInfo = str;
    }

    public void setLoadTag(String str) {
        this.loadTag = str;
    }

    public void setWaterfall(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.waterfall = maxAdWaterfallInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MaxError{code=" + getCode() + ", message=\"" + getMessage() + "\"");
        if (getCode() == -4205) {
            sb.append(", mediatedNetworkErrorCode=");
            sb.append(getMediatedNetworkErrorCode());
            sb.append(", mediatedNetworkErrorMessage=\"");
            sb.append(getMediatedNetworkErrorMessage());
            sb.append("\"");
        }
        sb.append("}");
        return sb.toString();
    }
}
