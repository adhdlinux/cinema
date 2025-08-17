package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

final class ActionDisposable extends ReferenceDisposable<Action> {
    ActionDisposable(Action action) {
        super(action);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(Action action) {
        try {
            action.run();
        } catch (Throwable th) {
            throw ExceptionHelper.d(th);
        }
    }
}
