package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

class InvalidationLiveDataContainer {

    /* renamed from: a  reason: collision with root package name */
    final Set<LiveData> f11399a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase f11400b;

    InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        this.f11400b = roomDatabase;
    }
}
