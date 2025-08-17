package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final GenericGF f31232a;

    /* renamed from: b  reason: collision with root package name */
    private final List<GenericGFPoly> f31233b;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.f31232a = genericGF;
        ArrayList arrayList = new ArrayList();
        this.f31233b = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    private GenericGFPoly a(int i2) {
        if (i2 >= this.f31233b.size()) {
            List<GenericGFPoly> list = this.f31233b;
            GenericGFPoly genericGFPoly = list.get(list.size() - 1);
            for (int size = this.f31233b.size(); size <= i2; size++) {
                GenericGF genericGF = this.f31232a;
                genericGFPoly = genericGFPoly.g(new GenericGFPoly(genericGF, new int[]{1, genericGF.c((size - 1) + genericGF.d())}));
                this.f31233b.add(genericGFPoly);
            }
        }
        return this.f31233b.get(i2);
    }

    public void b(int[] iArr, int i2) {
        if (i2 != 0) {
            int length = iArr.length - i2;
            if (length > 0) {
                GenericGFPoly a2 = a(i2);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] d2 = new GenericGFPoly(this.f31232a, iArr2).h(i2, 1).b(a2)[1].d();
                int length2 = i2 - d2.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr[length + i3] = 0;
                }
                System.arraycopy(d2, 0, iArr, length + length2, d2.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
