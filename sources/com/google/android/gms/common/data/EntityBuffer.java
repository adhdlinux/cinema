package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean zaa = false;
    private ArrayList zab;

    @KeepForSdk
    protected EntityBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zab() {
        synchronized (this) {
            if (!this.zaa) {
                int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                ArrayList arrayList = new ArrayList();
                this.zab = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                    int i2 = 1;
                    while (i2 < count) {
                        int windowIndex = this.mDataHolder.getWindowIndex(i2);
                        String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i2, windowIndex);
                        if (string2 != null) {
                            if (!string2.equals(string)) {
                                this.zab.add(Integer.valueOf(i2));
                                string = string2;
                            }
                            i2++;
                        } else {
                            throw new NullPointerException("Missing value for markerColumn: " + primaryDataMarkerColumn + ", at row: " + i2 + ", for window: " + windowIndex);
                        }
                    }
                }
                this.zaa = true;
            }
        }
    }

    @KeepForSdk
    public final T get(int i2) {
        int i3;
        int i4;
        zab();
        int zaa2 = zaa(i2);
        int i5 = 0;
        if (i2 >= 0 && i2 != this.zab.size()) {
            if (i2 == this.zab.size() - 1) {
                i4 = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                i3 = ((Integer) this.zab.get(i2)).intValue();
            } else {
                i4 = ((Integer) this.zab.get(i2 + 1)).intValue();
                i3 = ((Integer) this.zab.get(i2)).intValue();
            }
            int i6 = i4 - i3;
            if (i6 == 1) {
                int zaa3 = zaa(i2);
                int windowIndex = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(zaa3);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, zaa3, windowIndex) != null) {
                    i5 = 1;
                }
            } else {
                i5 = i6;
            }
        }
        return getEntry(zaa2, i5);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public String getChildDataMarkerColumn() {
        return null;
    }

    @KeepForSdk
    public int getCount() {
        zab();
        return this.zab.size();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract T getEntry(int i2, int i3);

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract String getPrimaryDataMarkerColumn();

    /* access modifiers changed from: package-private */
    public final int zaa(int i2) {
        if (i2 >= 0 && i2 < this.zab.size()) {
            return ((Integer) this.zab.get(i2)).intValue();
        }
        throw new IllegalArgumentException("Position " + i2 + " is out of bounds for this buffer");
    }
}
