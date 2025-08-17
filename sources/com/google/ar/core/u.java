package com.google.ar.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class u extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InstallActivity f30358a;

    u(InstallActivity installActivity) {
        this.f30358a = installActivity;
    }

    public final void onAnimationEnd(Animator animator) {
        this.f30358a.a();
    }
}
