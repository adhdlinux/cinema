package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ResourceRecycler {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16572a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f16573b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());

    private static final class ResourceRecyclerCallback implements Handler.Callback {
        ResourceRecyclerCallback() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    ResourceRecycler() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(Resource<?> resource, boolean z2) {
        if (!this.f16572a) {
            if (!z2) {
                this.f16572a = true;
                resource.recycle();
                this.f16572a = false;
            }
        }
        this.f16573b.obtainMessage(1, resource).sendToTarget();
    }
}
