package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

class OpReorderer {

    /* renamed from: a  reason: collision with root package name */
    final Callback f11210a;

    interface Callback {
        AdapterHelper.UpdateOp a(int i2, int i3, int i4, Object obj);

        void b(AdapterHelper.UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.f11210a = callback;
    }

    private int a(List<AdapterHelper.UpdateOp> list) {
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f10992a != 8) {
                z2 = true;
            } else if (z2) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<AdapterHelper.UpdateOp> list, int i2, AdapterHelper.UpdateOp updateOp, int i3, AdapterHelper.UpdateOp updateOp2) {
        int i4;
        int i5 = updateOp.f10995d;
        int i6 = updateOp2.f10993b;
        if (i5 < i6) {
            i4 = -1;
        } else {
            i4 = 0;
        }
        int i7 = updateOp.f10993b;
        if (i7 < i6) {
            i4++;
        }
        if (i6 <= i7) {
            updateOp.f10993b = i7 + updateOp2.f10995d;
        }
        int i8 = updateOp2.f10993b;
        if (i8 <= i5) {
            updateOp.f10995d = i5 + updateOp2.f10995d;
        }
        updateOp2.f10993b = i8 + i4;
        list.set(i2, updateOp2);
        list.set(i3, updateOp);
    }

    private void d(List<AdapterHelper.UpdateOp> list, int i2, int i3) {
        AdapterHelper.UpdateOp updateOp = list.get(i2);
        AdapterHelper.UpdateOp updateOp2 = list.get(i3);
        int i4 = updateOp2.f10992a;
        if (i4 == 1) {
            c(list, i2, updateOp, i3, updateOp2);
        } else if (i4 == 2) {
            e(list, i2, updateOp, i3, updateOp2);
        } else if (i4 == 4) {
            f(list, i2, updateOp, i3, updateOp2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int a2 = a(list);
            if (a2 != -1) {
                d(list, a2, a2 + 1);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r10, int r11, androidx.recyclerview.widget.AdapterHelper.UpdateOp r12, int r13, androidx.recyclerview.widget.AdapterHelper.UpdateOp r14) {
        /*
            r9 = this;
            int r0 = r12.f10993b
            int r1 = r12.f10995d
            r2 = 1
            r3 = 0
            if (r0 >= r1) goto L_0x0016
            int r4 = r14.f10993b
            if (r4 != r0) goto L_0x0014
            int r4 = r14.f10995d
            int r0 = r1 - r0
            if (r4 != r0) goto L_0x0014
            r0 = 0
            goto L_0x0022
        L_0x0014:
            r0 = 0
            goto L_0x0025
        L_0x0016:
            int r4 = r14.f10993b
            int r5 = r1 + 1
            if (r4 != r5) goto L_0x0024
            int r4 = r14.f10995d
            int r0 = r0 - r1
            if (r4 != r0) goto L_0x0024
            r0 = 1
        L_0x0022:
            r3 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 1
        L_0x0025:
            int r4 = r14.f10993b
            r5 = 2
            if (r1 >= r4) goto L_0x002e
            int r4 = r4 - r2
            r14.f10993b = r4
            goto L_0x0047
        L_0x002e:
            int r6 = r14.f10995d
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x0047
            int r6 = r6 - r2
            r14.f10995d = r6
            r12.f10992a = r5
            r12.f10995d = r2
            int r11 = r14.f10995d
            if (r11 != 0) goto L_0x0046
            r10.remove(r13)
            androidx.recyclerview.widget.OpReorderer$Callback r10 = r9.f11210a
            r10.b(r14)
        L_0x0046:
            return
        L_0x0047:
            int r1 = r12.f10993b
            int r4 = r14.f10993b
            r6 = 0
            if (r1 > r4) goto L_0x0052
            int r4 = r4 + r2
            r14.f10993b = r4
            goto L_0x0068
        L_0x0052:
            int r7 = r14.f10995d
            int r8 = r4 + r7
            if (r1 >= r8) goto L_0x0068
            int r4 = r4 + r7
            int r4 = r4 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r7 = r9.f11210a
            int r1 = r1 + r2
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r6 = r7.a(r5, r1, r4, r6)
            int r1 = r12.f10993b
            int r2 = r14.f10993b
            int r1 = r1 - r2
            r14.f10995d = r1
        L_0x0068:
            if (r3 == 0) goto L_0x0076
            r10.set(r11, r14)
            r10.remove(r13)
            androidx.recyclerview.widget.OpReorderer$Callback r10 = r9.f11210a
            r10.b(r12)
            return
        L_0x0076:
            if (r0 == 0) goto L_0x00a7
            if (r6 == 0) goto L_0x0090
            int r0 = r12.f10993b
            int r1 = r6.f10993b
            if (r0 <= r1) goto L_0x0085
            int r1 = r6.f10995d
            int r0 = r0 - r1
            r12.f10993b = r0
        L_0x0085:
            int r0 = r12.f10995d
            int r1 = r6.f10993b
            if (r0 <= r1) goto L_0x0090
            int r1 = r6.f10995d
            int r0 = r0 - r1
            r12.f10995d = r0
        L_0x0090:
            int r0 = r12.f10993b
            int r1 = r14.f10993b
            if (r0 <= r1) goto L_0x009b
            int r1 = r14.f10995d
            int r0 = r0 - r1
            r12.f10993b = r0
        L_0x009b:
            int r0 = r12.f10995d
            int r1 = r14.f10993b
            if (r0 <= r1) goto L_0x00d5
            int r1 = r14.f10995d
            int r0 = r0 - r1
            r12.f10995d = r0
            goto L_0x00d5
        L_0x00a7:
            if (r6 == 0) goto L_0x00bf
            int r0 = r12.f10993b
            int r1 = r6.f10993b
            if (r0 < r1) goto L_0x00b4
            int r1 = r6.f10995d
            int r0 = r0 - r1
            r12.f10993b = r0
        L_0x00b4:
            int r0 = r12.f10995d
            int r1 = r6.f10993b
            if (r0 < r1) goto L_0x00bf
            int r1 = r6.f10995d
            int r0 = r0 - r1
            r12.f10995d = r0
        L_0x00bf:
            int r0 = r12.f10993b
            int r1 = r14.f10993b
            if (r0 < r1) goto L_0x00ca
            int r1 = r14.f10995d
            int r0 = r0 - r1
            r12.f10993b = r0
        L_0x00ca:
            int r0 = r12.f10995d
            int r1 = r14.f10993b
            if (r0 < r1) goto L_0x00d5
            int r1 = r14.f10995d
            int r0 = r0 - r1
            r12.f10995d = r0
        L_0x00d5:
            r10.set(r11, r14)
            int r14 = r12.f10993b
            int r0 = r12.f10995d
            if (r14 == r0) goto L_0x00e2
            r10.set(r13, r12)
            goto L_0x00e5
        L_0x00e2:
            r10.remove(r13)
        L_0x00e5:
            if (r6 == 0) goto L_0x00ea
            r10.add(r11, r6)
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.e(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.f10995d
            int r1 = r13.f10993b
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto L_0x000d
            int r1 = r1 - r3
            r13.f10993b = r1
            goto L_0x0020
        L_0x000d:
            int r5 = r13.f10995d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0020
            int r5 = r5 - r3
            r13.f10995d = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.f11210a
            int r1 = r11.f10993b
            java.lang.Object r5 = r13.f10994c
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.a(r2, r1, r3, r5)
            goto L_0x0021
        L_0x0020:
            r0 = r4
        L_0x0021:
            int r1 = r11.f10993b
            int r5 = r13.f10993b
            if (r1 > r5) goto L_0x002b
            int r5 = r5 + r3
            r13.f10993b = r5
            goto L_0x0041
        L_0x002b:
            int r6 = r13.f10995d
            int r7 = r5 + r6
            if (r1 >= r7) goto L_0x0041
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r8.f11210a
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f10994c
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = r4.a(r2, r1, r5, r3)
            int r1 = r13.f10995d
            int r1 = r1 - r5
            r13.f10995d = r1
        L_0x0041:
            r9.set(r12, r11)
            int r11 = r13.f10995d
            if (r11 <= 0) goto L_0x004c
            r9.set(r10, r13)
            goto L_0x0054
        L_0x004c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.f11210a
            r11.b(r13)
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r9.add(r10, r0)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r9.add(r10, r4)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.f(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
