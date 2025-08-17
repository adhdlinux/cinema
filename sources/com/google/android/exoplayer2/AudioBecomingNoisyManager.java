package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

final class AudioBecomingNoisyManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22783a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioBecomingNoisyReceiver f22784b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f22785c;

    private final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final EventListener f22786b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f22787c;

        public AudioBecomingNoisyReceiver(Handler handler, EventListener eventListener) {
            this.f22787c = handler;
            this.f22786b = eventListener;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f22787c.post(this);
            }
        }

        public void run() {
            if (AudioBecomingNoisyManager.this.f22785c) {
                this.f22786b.q();
            }
        }
    }

    public interface EventListener {
        void q();
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, EventListener eventListener) {
        this.f22783a = context.getApplicationContext();
        this.f22784b = new AudioBecomingNoisyReceiver(handler, eventListener);
    }

    public void b(boolean z2) {
        if (z2 && !this.f22785c) {
            this.f22783a.registerReceiver(this.f22784b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f22785c = true;
        } else if (!z2 && this.f22785c) {
            this.f22783a.unregisterReceiver(this.f22784b);
            this.f22785c = false;
        }
    }
}
