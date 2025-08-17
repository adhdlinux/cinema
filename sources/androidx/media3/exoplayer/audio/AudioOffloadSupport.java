package androidx.media3.exoplayer.audio;

public final class AudioOffloadSupport {

    /* renamed from: d  reason: collision with root package name */
    public static final AudioOffloadSupport f5648d = new Builder().d();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5649a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5650b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5651c;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f5652a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f5653b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f5654c;

        public AudioOffloadSupport d() {
            if (this.f5652a || (!this.f5653b && !this.f5654c)) {
                return new AudioOffloadSupport(this);
            }
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }

        public Builder e(boolean z2) {
            this.f5652a = z2;
            return this;
        }

        public Builder f(boolean z2) {
            this.f5653b = z2;
            return this;
        }

        public Builder g(boolean z2) {
            this.f5654c = z2;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioOffloadSupport.class != obj.getClass()) {
            return false;
        }
        AudioOffloadSupport audioOffloadSupport = (AudioOffloadSupport) obj;
        if (this.f5649a == audioOffloadSupport.f5649a && this.f5650b == audioOffloadSupport.f5650b && this.f5651c == audioOffloadSupport.f5651c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5649a ? 1 : 0) << true) + ((this.f5650b ? 1 : 0) << true) + (this.f5651c ? 1 : 0);
    }

    private AudioOffloadSupport(Builder builder) {
        this.f5649a = builder.f5652a;
        this.f5650b = builder.f5653b;
        this.f5651c = builder.f5654c;
    }
}
