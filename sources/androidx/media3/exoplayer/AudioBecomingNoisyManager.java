package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

final class AudioBecomingNoisyManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5116a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioBecomingNoisyReceiver f5117b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f5118c;

    private final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final EventListener f5119b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f5120c;

        public AudioBecomingNoisyReceiver(Handler handler, EventListener eventListener) {
            this.f5120c = handler;
            this.f5119b = eventListener;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f5120c.post(this);
            }
        }

        public void run() {
            if (AudioBecomingNoisyManager.this.f5118c) {
                this.f5119b.q();
            }
        }
    }

    public interface EventListener {
        void q();
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, EventListener eventListener) {
        this.f5116a = context.getApplicationContext();
        this.f5117b = new AudioBecomingNoisyReceiver(handler, eventListener);
    }

    public void b(boolean z2) {
        if (z2 && !this.f5118c) {
            this.f5116a.registerReceiver(this.f5117b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f5118c = true;
        } else if (!z2 && this.f5118c) {
            this.f5116a.unregisterReceiver(this.f5117b);
            this.f5118c = false;
        }
    }
}
