package com.startapp;

import android.text.TextUtils;
import com.startapp.sdk.ads.video.tracking.VideoTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoTrackingParams;
import com.startapp.sdk.ads.video.vast.VASTErrorCodes;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class d6 {

    /* renamed from: a  reason: collision with root package name */
    public VideoTrackingLink[] f34342a;

    /* renamed from: b  reason: collision with root package name */
    public VideoTrackingParams f34343b;

    /* renamed from: c  reason: collision with root package name */
    public String f34344c;

    /* renamed from: d  reason: collision with root package name */
    public int f34345d;

    /* renamed from: e  reason: collision with root package name */
    public String f34346e = "";

    /* renamed from: f  reason: collision with root package name */
    public VASTErrorCodes f34347f;

    public d6(VideoTrackingLink[] videoTrackingLinkArr, VideoTrackingParams videoTrackingParams, String str, int i2) {
        this.f34342a = videoTrackingLinkArr;
        this.f34343b = videoTrackingParams;
        this.f34344c = str;
        this.f34345d = i2;
    }

    public c6 a() {
        boolean z2;
        Object obj;
        boolean z3;
        String str;
        if (this.f34342a == null || this.f34343b == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Object obj2 = null;
        if (!z2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        VideoTrackingLink[] videoTrackingLinkArr = this.f34342a;
        int length = videoTrackingLinkArr.length;
        int i2 = 0;
        while (i2 < length) {
            VideoTrackingLink videoTrackingLink = videoTrackingLinkArr[i2];
            if (videoTrackingLink.c() == null || (this.f34343b.b() > 0 && !videoTrackingLink.d())) {
                obj = obj2;
            } else {
                StringBuilder sb = new StringBuilder();
                VideoTrackingLink.TrackingSource b2 = videoTrackingLink.b();
                if (b2 == null) {
                    if (lb.d(videoTrackingLink.c())) {
                        b2 = VideoTrackingLink.TrackingSource.STARTAPP;
                    } else {
                        b2 = VideoTrackingLink.TrackingSource.EXTERNAL;
                    }
                }
                VideoTrackingParams videoTrackingParams = this.f34343b;
                if (b2 == VideoTrackingLink.TrackingSource.STARTAPP) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                videoTrackingParams.internalParamsIndicator = z3;
                VideoTrackingParams c2 = videoTrackingParams.a(videoTrackingLink.d()).c(videoTrackingLink.a());
                String c3 = videoTrackingLink.c();
                String str2 = this.f34344c;
                if (str2 != null) {
                    str = TextUtils.htmlEncode(str2);
                } else {
                    str = "";
                }
                String replace = c3.replace("[ASSETURI]", str);
                int i3 = this.f34345d;
                long convert = TimeUnit.SECONDS.convert((long) i3, TimeUnit.MILLISECONDS);
                long j2 = (long) (i3 % 1000);
                Locale locale = Locale.US;
                String replace2 = replace.replace("[CONTENTPLAYHEAD]", TextUtils.htmlEncode(String.format(locale, "%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(convert / 3600), Long.valueOf((convert % 3600) / 60), Long.valueOf(convert % 60), Long.valueOf(j2)}))).replace("[CACHEBUSTING]", TextUtils.htmlEncode(String.valueOf(new SecureRandom().nextInt(90000000) + 10000000)));
                String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", locale).format(new Date());
                int length2 = format.length() - 2;
                String replace3 = replace2.replace("[TIMESTAMP]", TextUtils.htmlEncode(format.substring(0, length2) + ":" + format.substring(length2)));
                VASTErrorCodes vASTErrorCodes = this.f34347f;
                if (vASTErrorCodes != null) {
                    replace3 = replace3.replace("[ERRORCODE]", String.valueOf(vASTErrorCodes.a()));
                }
                sb.append(replace3);
                sb.append(c2.e());
                if (c2.internalParamsIndicator) {
                    obj = null;
                    sb.append(fc.c(o6.a(c3, (String) null)));
                } else {
                    obj = null;
                }
                arrayList.add(sb.toString());
            }
            i2++;
            obj2 = obj;
        }
        return new c6(arrayList, this.f34346e);
    }
}
