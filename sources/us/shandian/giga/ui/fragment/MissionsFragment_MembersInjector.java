package us.shandian.giga.ui.fragment;

import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.helper.PlayerHelper;
import dagger.MembersInjector;
import javax.inject.Named;

public final class MissionsFragment_MembersInjector implements MembersInjector<MissionsFragment> {
    public static void a(MissionsFragment missionsFragment, MoviesHelper moviesHelper) {
        missionsFragment.f42288n = moviesHelper;
    }

    public static void b(MissionsFragment missionsFragment, TMDBRepositoryImpl tMDBRepositoryImpl) {
        missionsFragment.f42289o = tMDBRepositoryImpl;
    }

    @Named("MainActivity")
    public static void c(MissionsFragment missionsFragment, PlayerHelper playerHelper) {
        missionsFragment.f42290p = playerHelper;
    }
}
