package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

@KeepForSdk
public final class ListenerHolder<L> {
    private final Executor zaa;
    private volatile Object zab;
    private volatile ListenerKey zac;

    @KeepForSdk
    public static final class ListenerKey<L> {
        private final Object zaa;
        private final String zab;

        @KeepForSdk
        ListenerKey(L l2, String str) {
            this.zaa = l2;
            this.zab = str;
        }

        @KeepForSdk
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            if (this.zaa != listenerKey.zaa || !this.zab.equals(listenerKey.zab)) {
                return false;
            }
            return true;
        }

        @KeepForSdk
        public int hashCode() {
            return (System.identityHashCode(this.zaa) * 31) + this.zab.hashCode();
        }

        @KeepForSdk
        public String toIdString() {
            String str = this.zab;
            int identityHashCode = System.identityHashCode(this.zaa);
            return str + "@" + identityHashCode;
        }
    }

    @KeepForSdk
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(L l2);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    @KeepForSdk
    ListenerHolder(Looper looper, L l2, String str) {
        this.zaa = new HandlerExecutor(looper);
        this.zab = Preconditions.checkNotNull(l2, "Listener must not be null");
        this.zac = new ListenerKey(l2, Preconditions.checkNotEmpty(str));
    }

    @KeepForSdk
    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    @KeepForSdk
    public ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    @KeepForSdk
    public boolean hasListener() {
        return this.zab != null;
    }

    @KeepForSdk
    public void notifyListener(Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.execute(new zacb(this, notifier));
    }

    /* access modifiers changed from: package-private */
    public final void zaa(Notifier notifier) {
        Object obj = this.zab;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e2) {
            notifier.onNotifyListenerFailed();
            throw e2;
        }
    }

    @KeepForSdk
    ListenerHolder(Executor executor, L l2, String str) {
        this.zaa = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.zab = Preconditions.checkNotNull(l2, "Listener must not be null");
        this.zac = new ListenerKey(l2, Preconditions.checkNotEmpty(str));
    }
}
