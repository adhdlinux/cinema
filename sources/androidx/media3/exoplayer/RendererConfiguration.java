package androidx.media3.exoplayer;

public final class RendererConfiguration {

    /* renamed from: c  reason: collision with root package name */
    public static final RendererConfiguration f5507c = new RendererConfiguration(0, false);

    /* renamed from: a  reason: collision with root package name */
    public final int f5508a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5509b;

    public RendererConfiguration(int i2, boolean z2) {
        this.f5508a = i2;
        this.f5509b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RendererConfiguration.class != obj.getClass()) {
            return false;
        }
        RendererConfiguration rendererConfiguration = (RendererConfiguration) obj;
        if (this.f5508a == rendererConfiguration.f5508a && this.f5509b == rendererConfiguration.f5509b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f5508a << 1) + (this.f5509b ? 1 : 0);
    }
}
