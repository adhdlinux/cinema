package d0;

import com.database.daos.TvWatchedEpisodeDAO;
import com.database.entitys.TvWatchedEpisode;

public final /* synthetic */ class b {
    public static void a(TvWatchedEpisodeDAO tvWatchedEpisodeDAO, TvWatchedEpisode... tvWatchedEpisodeArr) {
        for (TvWatchedEpisode tvWatchedEpisode : tvWatchedEpisodeArr) {
            tvWatchedEpisodeDAO.c(tvWatchedEpisode.h(), tvWatchedEpisode.d(), tvWatchedEpisode.j(), tvWatchedEpisode.i(), tvWatchedEpisode.f(), tvWatchedEpisode.c());
        }
    }

    public static void b(TvWatchedEpisodeDAO tvWatchedEpisodeDAO, TvWatchedEpisode... tvWatchedEpisodeArr) {
        for (TvWatchedEpisode tvWatchedEpisode : tvWatchedEpisodeArr) {
            if (tvWatchedEpisodeDAO.g(tvWatchedEpisode.h(), tvWatchedEpisode.d(), tvWatchedEpisode.j(), tvWatchedEpisode.i(), tvWatchedEpisode.f(), tvWatchedEpisode.c(), tvWatchedEpisode.e(), tvWatchedEpisode.b(), tvWatchedEpisode.g()) <= 0) {
                tvWatchedEpisodeDAO.i(tvWatchedEpisode.h(), tvWatchedEpisode.d(), tvWatchedEpisode.j(), tvWatchedEpisode.i(), tvWatchedEpisode.f(), tvWatchedEpisode.c(), tvWatchedEpisode.e(), tvWatchedEpisode.b(), tvWatchedEpisode.g());
            }
        }
    }
}
