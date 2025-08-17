package com.google.android.exoplayer2;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class BundleListRetriever extends Binder {

    /* renamed from: c  reason: collision with root package name */
    private static final int f22814c = (Util.f28808a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536);

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<Bundle> f22815b;

    public BundleListRetriever(List<Bundle> list) {
        this.f22815b = ImmutableList.n(list);
    }

    public static ImmutableList<Bundle> a(IBinder iBinder) {
        int readInt;
        ImmutableList.Builder k2 = ImmutableList.k();
        int i2 = 1;
        int i3 = 0;
        while (i2 != 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i3);
                iBinder.transact(1, obtain, obtain2, 0);
                while (true) {
                    readInt = obtain2.readInt();
                    if (readInt != 1) {
                        break;
                    }
                    k2.d((Bundle) Assertions.e(obtain2.readBundle()));
                    i3++;
                }
                obtain2.recycle();
                obtain.recycle();
                i2 = readInt;
            } catch (RemoteException e2) {
                throw new RuntimeException(e2);
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        return k2.k();
    }

    /* access modifiers changed from: protected */
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return super.onTransact(i2, parcel, parcel2, i3);
        }
        int i4 = 0;
        if (parcel2 == null) {
            return false;
        }
        int size = this.f22815b.size();
        int readInt = parcel.readInt();
        while (readInt < size && parcel2.dataSize() < f22814c) {
            parcel2.writeInt(1);
            parcel2.writeBundle(this.f22815b.get(readInt));
            readInt++;
        }
        if (readInt < size) {
            i4 = 2;
        }
        parcel2.writeInt(i4);
        return true;
    }
}
