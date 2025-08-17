package androidx.media;

import android.media.VolumeProvider;
import android.os.Build;

public abstract class VolumeProviderCompat {

    /* renamed from: a  reason: collision with root package name */
    private final int f3855a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3856b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3857c;

    /* renamed from: d  reason: collision with root package name */
    private int f3858d;

    /* renamed from: e  reason: collision with root package name */
    private Callback f3859e;

    /* renamed from: f  reason: collision with root package name */
    private VolumeProvider f3860f;

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void a(VolumeProvider volumeProvider, int i2) {
            volumeProvider.setCurrentVolume(i2);
        }
    }

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    public VolumeProviderCompat(int i2, int i3, int i4, String str) {
        this.f3855a = i2;
        this.f3856b = i3;
        this.f3858d = i4;
        this.f3857c = str;
    }

    public final int a() {
        return this.f3858d;
    }

    public final int b() {
        return this.f3856b;
    }

    public final int c() {
        return this.f3855a;
    }

    public Object d() {
        if (this.f3860f == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f3860f = new VolumeProvider(this.f3855a, this.f3856b, this.f3858d, this.f3857c) {
                    public void onAdjustVolume(int i2) {
                        VolumeProviderCompat.this.e(i2);
                    }

                    public void onSetVolumeTo(int i2) {
                        VolumeProviderCompat.this.f(i2);
                    }
                };
            } else {
                this.f3860f = new VolumeProvider(this.f3855a, this.f3856b, this.f3858d) {
                    public void onAdjustVolume(int i2) {
                        VolumeProviderCompat.this.e(i2);
                    }

                    public void onSetVolumeTo(int i2) {
                        VolumeProviderCompat.this.f(i2);
                    }
                };
            }
        }
        return this.f3860f;
    }

    public abstract void e(int i2);

    public abstract void f(int i2);

    public void g(Callback callback) {
        this.f3859e = callback;
    }

    public final void h(int i2) {
        this.f3858d = i2;
        Api21Impl.a((VolumeProvider) d(), i2);
        Callback callback = this.f3859e;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
