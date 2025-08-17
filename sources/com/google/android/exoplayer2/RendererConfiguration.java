package com.google.android.exoplayer2;

public final class RendererConfiguration {

    /* renamed from: b  reason: collision with root package name */
    public static final RendererConfiguration f23450b = new RendererConfiguration(false);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f23451a;

    public RendererConfiguration(boolean z2) {
        this.f23451a = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && RendererConfiguration.class == obj.getClass() && this.f23451a == ((RendererConfiguration) obj).f23451a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f23451a ^ true ? 1 : 0;
    }
}
