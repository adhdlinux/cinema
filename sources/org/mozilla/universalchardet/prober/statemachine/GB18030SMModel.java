package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class GB18030SMModel extends SMModel {

    /* renamed from: f  reason: collision with root package name */
    private static int[] f42016f = {PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 0, 0), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 0, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 1, 1, 1, 1, 1, 1), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 4), PkgInt.b(5, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 0)};

    /* renamed from: g  reason: collision with root package name */
    private static int[] f42017g = {PkgInt.b(1, 0, 0, 0, 0, 0, 3, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 1, 1, 0), PkgInt.b(4, 1, 0, 0, 1, 1, 1, 1), PkgInt.b(1, 1, 5, 1, 1, 1, 2, 1), PkgInt.b(1, 1, 0, 0, 0, 0, 0, 0)};

    /* renamed from: h  reason: collision with root package name */
    private static int[] f42018h = {0, 1, 1, 1, 1, 1, 2};

    public GB18030SMModel() {
        super(new PkgInt(3, 7, 2, 15, f42016f), 7, new PkgInt(3, 7, 2, 15, f42017g), f42018h, Constants.f41851h);
    }
}
