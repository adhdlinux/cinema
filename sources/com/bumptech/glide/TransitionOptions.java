package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.Preconditions;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private TransitionFactory<? super TranscodeType> f16182b = NoTransition.b();

    private CHILD c() {
        return this;
    }

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (TransitionOptions) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final TransitionFactory<? super TranscodeType> b() {
        return this.f16182b;
    }

    public final CHILD d(TransitionFactory<? super TranscodeType> transitionFactory) {
        this.f16182b = (TransitionFactory) Preconditions.d(transitionFactory);
        return c();
    }
}
