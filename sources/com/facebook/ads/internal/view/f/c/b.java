package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.view.f.a.c;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.k;
import com.unity3d.services.core.device.MimeTypes;
import java.lang.ref.WeakReference;

public class b extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<AudioManager.OnAudioFocusChangeListener> f21353a = null;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.ads.internal.view.f.b.c f21354b = new com.facebook.ads.internal.view.f.b.c() {
        public void a(com.facebook.ads.internal.view.f.b.b bVar) {
            ((AudioManager) b.this.getContext().getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).abandonAudioFocus(b.this.f21353a == null ? null : (AudioManager.OnAudioFocusChangeListener) b.this.f21353a.get());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final i f21355c = new i() {
        public void a(h hVar) {
            ((AudioManager) b.this.getContext().getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).abandonAudioFocus(b.this.f21353a == null ? null : (AudioManager.OnAudioFocusChangeListener) b.this.f21353a.get());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final k f21356d = new k() {
        public void a(j jVar) {
            if (b.this.f21353a == null || b.this.f21353a.get() == null) {
                WeakReference unused = b.this.f21353a = new WeakReference(new AudioManager.OnAudioFocusChangeListener() {
                    public void onAudioFocusChange(final int i2) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                if (b.this.getVideoView() != null && i2 <= 0) {
                                    b.this.getVideoView().a(false);
                                }
                            }
                        });
                    }
                });
            }
            ((AudioManager) b.this.getContext().getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) b.this.f21353a.get(), 3, 1);
        }
    };

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().a((T[]) new f[]{this.f21356d, this.f21354b, this.f21355c});
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().b((T[]) new f[]{this.f21355c, this.f21354b, this.f21356d});
        }
        super.b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AudioManager audioManager = (AudioManager) getContext().getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        WeakReference<AudioManager.OnAudioFocusChangeListener> weakReference = this.f21353a;
        audioManager.abandonAudioFocus(weakReference == null ? null : weakReference.get());
        super.onDetachedFromWindow();
    }
}
