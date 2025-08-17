package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST;
    private boolean[] array;
    private int size;

    static {
        BooleanArrayList booleanArrayList = new BooleanArrayList(new boolean[0], 0);
        EMPTY_LIST = booleanArrayList;
        booleanArrayList.makeImmutable();
    }

    BooleanArrayList() {
        this(new boolean[10], 0);
    }

    public static BooleanArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i2) {
        return "Index:" + i2 + ", Size:" + this.size;
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i2 = booleanArrayList.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.array;
            if (i4 > zArr.length) {
                this.array = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
            this.size = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addBoolean(boolean z2) {
        ensureIsMutable();
        int i2 = this.size;
        boolean[] zArr = this.array;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i3 = this.size;
        this.size = i3 + 1;
        zArr3[i3] = z2;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.array[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public boolean getBoolean(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + Internal.hashBoolean(this.array[i3]);
        }
        return i2;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size2 = size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.array[i2] == booleanValue) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i2, int i3) {
        ensureIsMutable();
        if (i3 >= i2) {
            boolean[] zArr = this.array;
            System.arraycopy(zArr, i3, zArr, i2, this.size - i3);
            this.size -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean setBoolean(int i2, boolean z2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        boolean[] zArr = this.array;
        boolean z3 = zArr[i2];
        zArr[i2] = z2;
        return z3;
    }

    public int size() {
        return this.size;
    }

    private BooleanArrayList(boolean[] zArr, int i2) {
        this.array = zArr;
        this.size = i2;
    }

    public Boolean get(int i2) {
        return Boolean.valueOf(getBoolean(i2));
    }

    public Internal.BooleanList mutableCopyWithCapacity(int i2) {
        if (i2 >= this.size) {
            return new BooleanArrayList(Arrays.copyOf(this.array, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Boolean remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        boolean[] zArr = this.array;
        boolean z2 = zArr[i2];
        int i3 = this.size;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z2);
    }

    public Boolean set(int i2, Boolean bool) {
        return Boolean.valueOf(setBoolean(i2, bool.booleanValue()));
    }

    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    public void add(int i2, Boolean bool) {
        addBoolean(i2, bool.booleanValue());
    }

    private void addBoolean(int i2, boolean z2) {
        int i3;
        ensureIsMutable();
        if (i2 < 0 || i2 > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
        }
        boolean[] zArr = this.array;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.array, i2, zArr2, i2 + 1, this.size - i2);
            this.array = zArr2;
        }
        this.array[i2] = z2;
        this.size++;
        this.modCount++;
    }
}
