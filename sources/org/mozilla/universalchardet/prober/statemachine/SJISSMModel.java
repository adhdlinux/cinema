package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class SJISSMModel extends SMModel {

    /* renamed from: f  reason: collision with root package name */
    private static int[] f42036f = {PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 0, 0), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 0, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 1), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 3, 3, 3, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.b(4, 4, 4, 4, 4, 0, 0, 0)};

    /* renamed from: g  reason: collision with root package name */
    private static int[] f42037g = {PkgInt.b(1, 0, 0, 3, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 2, 2, 2, 2), PkgInt.b(2, 2, 1, 1, 0, 0, 0, 0)};

    /* renamed from: h  reason: collision with root package name */
    private static int[] f42038h = {0, 1, 1, 2, 0, 0};

    public SJISSMModel() {
        super(new PkgInt(3, 7, 2, 15, f42036f), 6, new PkgInt(3, 7, 2, 15, f42037g), f42038h, Constants.f41855l);
    }
}
