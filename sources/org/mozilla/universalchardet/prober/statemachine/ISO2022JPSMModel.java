package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class ISO2022JPSMModel extends SMModel {

    /* renamed from: f  reason: collision with root package name */
    private static int[] f42025f = {PkgInt.b(2, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 2, 2), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 1, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 7, 0, 0, 0), PkgInt.b(3, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(6, 0, 4, 0, 8, 0, 0, 0), PkgInt.b(0, 9, 5, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2)};

    /* renamed from: g  reason: collision with root package name */
    private static int[] f42026g = {PkgInt.b(0, 3, 1, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 1, 1), PkgInt.b(1, 5, 1, 1, 1, 4, 1, 1), PkgInt.b(1, 1, 1, 6, 2, 1, 2, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 2, 2), PkgInt.b(1, 1, 1, 2, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 2, 1, 0, 0)};

    /* renamed from: h  reason: collision with root package name */
    private static int[] f42027h = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public ISO2022JPSMModel() {
        super(new PkgInt(3, 7, 2, 15, f42025f), 10, new PkgInt(3, 7, 2, 15, f42026g), f42027h, Constants.f41844a);
    }
}
