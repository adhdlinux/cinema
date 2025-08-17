package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class EUCJPSMModel extends SMModel {

    /* renamed from: f  reason: collision with root package name */
    private static int[] f42007f = {PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 5, 5), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 5, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.b(5, 5, 5, 5, 5, 5, 1, 3), PkgInt.b(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.b(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.b(5, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.b(0, 0, 0, 0, 0, 0, 0, 5)};

    /* renamed from: g  reason: collision with root package name */
    private static int[] f42008g = {PkgInt.b(3, 4, 3, 5, 0, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 2, 2, 2, 2), PkgInt.b(2, 2, 0, 1, 0, 1, 1, 1), PkgInt.b(1, 1, 0, 1, 1, 1, 3, 1), PkgInt.b(3, 1, 1, 1, 0, 0, 0, 0)};

    /* renamed from: h  reason: collision with root package name */
    private static int[] f42009h = {2, 2, 2, 3, 1, 0};

    public EUCJPSMModel() {
        super(new PkgInt(3, 7, 2, 15, f42007f), 6, new PkgInt(3, 7, 2, 15, f42008g), f42009h, Constants.f41852i);
    }
}
