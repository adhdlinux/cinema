package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f17119a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17120b;

    /* renamed from: c  reason: collision with root package name */
    private DrawableCrossFadeTransition f17121c;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final int f17122a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f17123b;

        public Builder() {
            this(300);
        }

        public DrawableCrossFadeFactory a() {
            return new DrawableCrossFadeFactory(this.f17122a, this.f17123b);
        }

        public Builder(int i2) {
            this.f17122a = i2;
        }
    }

    protected DrawableCrossFadeFactory(int i2, boolean z2) {
        this.f17119a = i2;
        this.f17120b = z2;
    }

    private Transition<Drawable> a() {
        if (this.f17121c == null) {
            this.f17121c = new DrawableCrossFadeTransition(this.f17119a, this.f17120b);
        }
        return this.f17121c;
    }

    public Transition<Drawable> build(DataSource dataSource, boolean z2) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return NoTransition.a();
        }
        return a();
    }
}
