package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class Big5SMModel extends SMModel {

    /* renamed from: f  reason: collision with root package name */
    private static int[] f42000f = {PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 0, 0), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 0, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 1), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 0)};

    /* renamed from: g  reason: collision with root package name */
    private static int[] f42001g = {PkgInt.b(1, 0, 0, 3, 1, 1, 1, 1), PkgInt.b(1, 1, 2, 2, 2, 2, 2, 1), PkgInt.b(1, 0, 0, 0, 0, 0, 0, 0)};

    /* renamed from: h  reason: collision with root package name */
    private static int[] f42002h = {0, 1, 1, 2, 0};

    public Big5SMModel() {
        super(new PkgInt(3, 7, 2, 15, f42000f), 5, new PkgInt(3, 7, 2, 15, f42001g), f42002h, Constants.f41850g);
    }
}
