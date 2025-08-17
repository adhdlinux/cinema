package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    private HashSet zaa = new HashSet();

    public void addObserver(DataBufferObserver dataBufferObserver) {
        this.zaa.add(dataBufferObserver);
    }

    public void clear() {
        this.zaa.clear();
    }

    public boolean hasObservers() {
        return !this.zaa.isEmpty();
    }

    public void onDataChanged() {
        Iterator it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            ((DataBufferObserver) it2.next()).onDataChanged();
        }
    }

    public void onDataRangeChanged(int i2, int i3) {
        Iterator it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            ((DataBufferObserver) it2.next()).onDataRangeChanged(i2, i3);
        }
    }

    public void onDataRangeInserted(int i2, int i3) {
        Iterator it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            ((DataBufferObserver) it2.next()).onDataRangeInserted(i2, i3);
        }
    }

    public void onDataRangeMoved(int i2, int i3, int i4) {
        Iterator it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            ((DataBufferObserver) it2.next()).onDataRangeMoved(i2, i3, i4);
        }
    }

    public void onDataRangeRemoved(int i2, int i3) {
        Iterator it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            ((DataBufferObserver) it2.next()).onDataRangeRemoved(i2, i3);
        }
    }

    public void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zaa.remove(dataBufferObserver);
    }
}
