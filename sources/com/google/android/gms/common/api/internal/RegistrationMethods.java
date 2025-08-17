package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L> {
    @KeepForSdk
    public final RegisterListenerMethod<A, L> register;
    public final UnregisterListenerMethod zaa;
    public final Runnable zab;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, L> {
        /* access modifiers changed from: private */
        public RemoteCall zaa;
        /* access modifiers changed from: private */
        public RemoteCall zab;
        private Runnable zac = zacj.zaa;
        private ListenerHolder zad;
        private Feature[] zae;
        private boolean zaf = true;
        private int zag;

        private Builder() {
        }

        /* synthetic */ Builder(zacm zacm) {
        }

        @KeepForSdk
        public RegistrationMethods<A, L> build() {
            boolean z2;
            boolean z3;
            boolean z4 = true;
            if (this.zaa != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Must set register function");
            if (this.zab != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Must set unregister function");
            if (this.zad == null) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Must set holder");
            return new RegistrationMethods<>(new zack(this, this.zad, this.zae, this.zaf, this.zag), new zacl(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(this.zad.getListenerKey(), "Key must not be null")), this.zac, (zacn) null);
        }

        @KeepForSdk
        public Builder<A, L> onConnectionSuspended(Runnable runnable) {
            this.zac = runnable;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> setAutoResolveMissingFeatures(boolean z2) {
            this.zaf = z2;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> setFeatures(Feature... featureArr) {
            this.zae = featureArr;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> setMethodKey(int i2) {
            this.zag = i2;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.zab = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> withHolder(ListenerHolder<L> listenerHolder) {
            this.zad = listenerHolder;
            return this;
        }
    }

    /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, zacn zacn) {
        this.register = registerListenerMethod;
        this.zaa = unregisterListenerMethod;
        this.zab = runnable;
    }

    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder<>((zacm) null);
    }
}
