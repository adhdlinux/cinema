package com.startapp;

import com.startapp.sdk.components.ComponentLocator;

public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentLocator f34208a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ba f34209b;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Boolean f34210a;

        public a(Boolean bool) {
            this.f34210a = bool;
        }

        public void run() {
            aa.this.f34209b.a(this.f34210a);
        }
    }

    public aa(ba baVar, ComponentLocator componentLocator) {
        this.f34209b = baVar;
        this.f34208a = componentLocator;
    }

    public void run() {
        this.f34208a.f36452z.b().execute(new a(this.f34209b.a()));
    }
}
