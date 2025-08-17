package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class ISO2022CNSMModel extends SMModel {

    /* renamed from: f  reason: collision with root package name */
    private static int[] f42022f = {PkgInt.b(2, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 1, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 3, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 4, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2)};

    /* renamed from: g  reason: collision with root package name */
    private static int[] f42023g = {PkgInt.b(0, 3, 1, 0, 0, 0, 0, 0), PkgInt.b(0, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 1, 1, 1, 4, 1), PkgInt.b(1, 1, 1, 2, 1, 1, 1, 1), PkgInt.b(5, 6, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 2, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 2, 1, 0)};

    /* renamed from: h  reason: collision with root package name */
    private static int[] f42024h = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public ISO2022CNSMModel() {
        super(new PkgInt(3, 7, 2, 15, f42022f), 9, new PkgInt(3, 7, 2, 15, f42023g), f42024h, Constants.f41845b);
    }
}
