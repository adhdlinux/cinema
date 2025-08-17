package com.startapp.sdk.ads.video.vast;

import com.google.android.gms.cast.MediaError;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public enum VASTErrorCodes {
    ErrorNone(0),
    XMLParsingError(100),
    SchemaValidationError(101),
    VersionOfResponseNotSupported(102),
    TraffickingError(200),
    VideoPlayerExpectingDifferentLinearity(201),
    VideoPlayerExpectingDifferentDuration(202),
    VideoPlayerExpectingDifferentSize(203),
    AdCategoryRequired(204),
    GeneralWrapperError(300),
    WrapperTimeout(301),
    WrapperLimitReached(Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE),
    WrapperNoReponse(303),
    InlineResponseTimeout(Sdk$SDKError.Reason.AD_EXPIRED_VALUE),
    GeneralLinearError(400),
    FileNotFound(401),
    TimeoutMediaFileURI(402),
    MediaNotSupported(403),
    MediaFileDisplayError(405),
    MezzanineNotPovided(406),
    MezzanineDownloadInProgrees(407),
    ConditionalAdRejected(408),
    InteractiveCreativeFileNotExecuted(409),
    VerificationNotExecuted(410),
    MezzanineNotAsExpected(MediaError.DetailedErrorCode.HLS_MANIFEST_MASTER),
    GeneralNonLinearAdsError(500),
    CreativeTooLarge(501),
    ResourceDownloadFailed(502),
    NonLinearResourceNotSupported(503),
    GeneralCompanionAdsError(600),
    CompanionTooLarge(601),
    CompanionNotDisplay(602),
    CompanionFetchFailed(603),
    CompanionNotSupported(604),
    UndefinedError(MediaError.DetailedErrorCode.APP),
    GeneralVPAIDerror(MediaError.DetailedErrorCode.BREAK_CLIP_LOADING_ERROR),
    SAShowBeforeVast(10000),
    SAProcessSuccess(20000);
    
    private int value;

    /* access modifiers changed from: public */
    VASTErrorCodes(int i2) {
        this.value = i2;
    }

    public int a() {
        return this.value;
    }
}
