package com.startapp;

import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final x f36932a;

    public y(x xVar) {
        this.f36932a = xVar;
    }

    public static y a(s sVar) {
        x xVar = (x) sVar;
        p.a((Object) sVar, "AdSession is null");
        if (!xVar.e()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        } else if (xVar.f36851g) {
            throw new IllegalStateException("AdSession is started");
        } else if (!xVar.f36852h) {
            AdSessionStatePublisher adSessionStatePublisher = xVar.f36850f;
            if (adSessionStatePublisher.f31611c == null) {
                y yVar = new y(xVar);
                adSessionStatePublisher.f31611c = yVar;
                return yVar;
            }
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        } else {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public final void a(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }
}
