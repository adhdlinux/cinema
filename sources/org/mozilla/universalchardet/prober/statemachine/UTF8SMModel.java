package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class UTF8SMModel extends SMModel {

    /* renamed from: f  reason: collision with root package name */
    private static int[] f42044f = {PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 0, 0), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 0, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(2, 2, 2, 2, 3, 3, 3, 3), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.b(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.b(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.b(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.b(0, 0, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(7, 8, 8, 8, 8, 8, 8, 8), PkgInt.b(8, 8, 8, 8, 8, 9, 8, 8), PkgInt.b(10, 11, 11, 11, 11, 11, 11, 11), PkgInt.b(12, 13, 13, 13, 14, 15, 0, 0)};

    /* renamed from: g  reason: collision with root package name */
    private static int[] f42045g = {PkgInt.b(1, 0, 1, 1, 1, 1, 12, 10), PkgInt.b(9, 11, 8, 7, 6, 5, 4, 3), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(1, 1, 5, 5, 5, 5, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 5, 5, 5, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 7, 7, 7, 7, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 7, 7, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 9, 9, 9, 9, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 9, 9, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 12, 12, 12, 12, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 12, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 12, 12, 12, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 0, 0, 0, 0, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1)};

    /* renamed from: h  reason: collision with root package name */
    private static int[] f42046h = {0, 1, 0, 0, 0, 0, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6};

    public UTF8SMModel() {
        super(new PkgInt(3, 7, 2, 15, f42044f), 16, new PkgInt(3, 7, 2, 15, f42045g), f42046h, Constants.f41864u);
    }
}
