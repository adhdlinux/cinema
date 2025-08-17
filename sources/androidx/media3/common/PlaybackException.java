package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import com.facebook.ads.AdError;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.location.GeofenceStatusCodes;

public class PlaybackException extends Exception {

    /* renamed from: e  reason: collision with root package name */
    private static final String f4294e = Util.B0(0);

    /* renamed from: f  reason: collision with root package name */
    private static final String f4295f = Util.B0(1);

    /* renamed from: g  reason: collision with root package name */
    private static final String f4296g = Util.B0(2);

    /* renamed from: h  reason: collision with root package name */
    private static final String f4297h = Util.B0(3);

    /* renamed from: i  reason: collision with root package name */
    private static final String f4298i = Util.B0(4);

    /* renamed from: j  reason: collision with root package name */
    private static final String f4299j = Util.B0(5);

    /* renamed from: b  reason: collision with root package name */
    public final int f4300b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4301c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f4302d;

    protected PlaybackException(String str, Throwable th, int i2, Bundle bundle, long j2) {
        super(str, th);
        this.f4300b = i2;
        this.f4302d = bundle;
        this.f4301c = j2;
    }

    public static String b(int i2) {
        if (i2 == -100) {
            return "ERROR_CODE_DISCONNECTED";
        }
        if (i2 == -6) {
            return "ERROR_CODE_NOT_SUPPORTED";
        }
        if (i2 == -4) {
            return "ERROR_CODE_PERMISSION_DENIED";
        }
        if (i2 == -3) {
            return "ERROR_CODE_BAD_VALUE";
        }
        if (i2 == -2) {
            return "ERROR_CODE_INVALID_STATE";
        }
        if (i2 == 7000) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED";
        }
        if (i2 == 7001) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED";
        }
        switch (i2) {
            case -110:
                return "ERROR_CODE_CONTENT_ALREADY_PLAYING";
            case -109:
                return "ERROR_CODE_END_OF_PLAYLIST";
            case -108:
                return "ERROR_CODE_SETUP_REQUIRED";
            case -107:
                return "ERROR_CODE_SKIP_LIMIT_REACHED";
            case -106:
                return "ERROR_CODE_NOT_AVAILABLE_IN_REGION";
            case -105:
                return "ERROR_CODE_PARENTAL_CONTROL_RESTRICTED";
            case -104:
                return "ERROR_CODE_CONCURRENT_STREAM_LIMIT";
            case -103:
                return "ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED";
            case -102:
                return "ERROR_CODE_AUTHENTICATION_EXPIRED";
            default:
                switch (i2) {
                    case 1000:
                        return "ERROR_CODE_UNSPECIFIED";
                    case 1001:
                        return "ERROR_CODE_REMOTE_ERROR";
                    case 1002:
                        return "ERROR_CODE_BEHIND_LIVE_WINDOW";
                    case 1003:
                        return "ERROR_CODE_TIMEOUT";
                    case GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION /*1004*/:
                        return "ERROR_CODE_FAILED_RUNTIME_CHECK";
                    default:
                        switch (i2) {
                            case 2000:
                                return "ERROR_CODE_IO_UNSPECIFIED";
                            case 2001:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                            case 2002:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                            case 2003:
                                return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                            case 2004:
                                return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                            case 2005:
                                return "ERROR_CODE_IO_FILE_NOT_FOUND";
                            case 2006:
                                return "ERROR_CODE_IO_NO_PERMISSION";
                            case 2007:
                                return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                            case 2008:
                                return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                            default:
                                switch (i2) {
                                    case 3001:
                                        return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                                    case 3002:
                                        return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                                    case AuthApiStatusCodes.AUTH_API_SERVER_ERROR /*3003*/:
                                        return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                                    case AuthApiStatusCodes.AUTH_TOKEN_ERROR /*3004*/:
                                        return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                                    default:
                                        switch (i2) {
                                            case 4001:
                                                return "ERROR_CODE_DECODER_INIT_FAILED";
                                            case 4002:
                                                return "ERROR_CODE_DECODER_QUERY_FAILED";
                                            case 4003:
                                                return "ERROR_CODE_DECODING_FAILED";
                                            case 4004:
                                                return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                            case 4005:
                                                return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                            case 4006:
                                                return "ERROR_CODE_DECODING_RESOURCES_RECLAIMED";
                                            default:
                                                switch (i2) {
                                                    case 5001:
                                                        return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
                                                    case 5002:
                                                        return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
                                                    case 5003:
                                                        return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED";
                                                    case 5004:
                                                        return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED";
                                                    default:
                                                        switch (i2) {
                                                            case 6000:
                                                                return "ERROR_CODE_DRM_UNSPECIFIED";
                                                            case AdError.MEDIAVIEW_MISSING_ERROR_CODE /*6001*/:
                                                                return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                                            case AdError.ICONVIEW_MISSING_ERROR_CODE /*6002*/:
                                                                return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                                            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /*6003*/:
                                                                return "ERROR_CODE_DRM_CONTENT_ERROR";
                                                            case 6004:
                                                                return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                                            case 6005:
                                                                return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                                            case 6006:
                                                                return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                                            case 6007:
                                                                return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                                            case 6008:
                                                                return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                                            default:
                                                                return i2 >= 1000000 ? "custom error code" : "invalid error code";
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public final String a() {
        return b(this.f4300b);
    }
}
