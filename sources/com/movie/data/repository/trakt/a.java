package com.movie.data.repository.trakt;

import com.movie.data.repository.trakt.TraktRepositoryImpl;
import com.uwetrottmann.trakt5.entities.ListEntry;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return TraktRepositoryImpl.AnonymousClass9.c((ListEntry) obj, (ListEntry) obj2);
    }
}
