package com.movie.ui.fragment.history;

import com.database.MvDatabase;
import com.movie.data.api.tmdb.TMDBApi;
import dagger.MembersInjector;

public final class HistoryFragment_MembersInjector implements MembersInjector<HistoryFragment> {
    public static void a(HistoryFragment historyFragment, MvDatabase mvDatabase) {
        historyFragment.f33350u = mvDatabase;
    }

    public static void b(HistoryFragment historyFragment, TMDBApi tMDBApi) {
        historyFragment.f33351v = tMDBApi;
    }
}
