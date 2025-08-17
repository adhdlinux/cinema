package androidx.media3.exoplayer.drm;

import android.media.MediaDrm;
import androidx.media3.exoplayer.drm.ExoMediaDrm;

public final /* synthetic */ class w implements MediaDrm.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f6272a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnEventListener f6273b;

    public /* synthetic */ w(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnEventListener onEventListener) {
        this.f6272a = frameworkMediaDrm;
        this.f6273b = onEventListener;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
        this.f6272a.A(this.f6273b, mediaDrm, bArr, i2, i3, bArr2);
    }
}
