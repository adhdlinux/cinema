package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class ISO2022KRSMModel extends SMModel {

    /* renamed from: f  reason: collision with root package name */
    private static int[] f42028f = {PkgInt.b(2, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 1, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 3, 0, 0, 0), PkgInt.b(0, 4, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 5, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2)};

    /* renamed from: g  reason: collision with root package name */
    private static int[] f42029g = {PkgInt.b(0, 3, 1, 0, 0, 0, 1, 1), PkgInt.b(1, 1, 1, 1, 2, 2, 2, 2), PkgInt.b(2, 2, 1, 1, 1, 4, 1, 1), PkgInt.b(1, 1, 1, 1, 5, 1, 1, 1), PkgInt.b(1, 1, 1, 2, 0, 0, 0, 0)};

    /* renamed from: h  reason: collision with root package name */
    private static int[] f42030h = {0, 0, 0, 0, 0, 0};

    public ISO2022KRSMModel() {
        super(new PkgInt(3, 7, 2, 15, f42028f), 6, new PkgInt(3, 7, 2, 15, f42029g), f42030h, Constants.f41846c);
    }
}
