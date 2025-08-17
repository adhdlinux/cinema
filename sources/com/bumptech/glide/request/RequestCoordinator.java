package com.bumptech.glide.request;

public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        

        /* renamed from: b  reason: collision with root package name */
        private final boolean f17060b;

        private RequestState(boolean z2) {
            this.f17060b = z2;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f17060b;
        }
    }

    boolean canNotifyCleared(Request request);

    boolean canNotifyStatusChanged(Request request);

    boolean canSetImage(Request request);

    RequestCoordinator getRoot();

    boolean isAnyResourceSet();

    void onRequestFailed(Request request);

    void onRequestSuccess(Request request);
}
