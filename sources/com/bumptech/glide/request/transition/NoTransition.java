package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

public class NoTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    static final NoTransition<?> f17126a = new NoTransition<>();

    /* renamed from: b  reason: collision with root package name */
    private static final TransitionFactory<?> f17127b = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        public Transition<R> build(DataSource dataSource, boolean z2) {
            return NoTransition.f17126a;
        }
    }

    public static <R> Transition<R> a() {
        return f17126a;
    }

    public static <R> TransitionFactory<R> b() {
        return f17127b;
    }

    public boolean transition(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
