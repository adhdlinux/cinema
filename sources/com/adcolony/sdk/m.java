package com.adcolony.sdk;

class m implements j0 {

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13252b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13253c;

        a(m mVar, String str, String str2) {
            this.f13252b = str;
            this.f13253c = str2;
        }

        public void run() {
            try {
                AdColonyCustomMessageListener adColonyCustomMessageListener = a.f().v0().get(this.f13252b);
                if (adColonyCustomMessageListener != null) {
                    adColonyCustomMessageListener.a(new AdColonyCustomMessage(this.f13252b, this.f13253c));
                }
            } catch (RuntimeException unused) {
            }
        }
    }

    m() {
        a.e("CustomMessage.controller_send", this);
    }

    public void a(h0 h0Var) {
        f1 a2 = h0Var.a();
        z0.A(new a(this, c0.E(a2, "type"), c0.E(a2, "message")));
    }
}
