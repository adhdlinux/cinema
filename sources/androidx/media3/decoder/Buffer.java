package androidx.media3.decoder;

public abstract class Buffer {
    private int flags;

    public final void addFlag(int i2) {
        this.flags = i2 | this.flags;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int i2) {
        this.flags = (~i2) & this.flags;
    }

    /* access modifiers changed from: protected */
    public final boolean getFlag(int i2) {
        return (this.flags & i2) == i2;
    }

    public final boolean hasSupplementalData() {
        return getFlag(268435456);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isFirstSample() {
        return getFlag(134217728);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final boolean isLastSample() {
        return getFlag(536870912);
    }

    public final void setFlags(int i2) {
        this.flags = i2;
    }
}
