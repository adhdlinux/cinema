package d0;

import com.database.daos.MovieDAO;
import com.database.entitys.MovieEntity;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;

public final /* synthetic */ class a {
    public static int a(MovieDAO movieDAO, MovieEntity... movieEntityArr) {
        Long l2;
        int i2 = 0;
        for (MovieEntity movieEntity : movieEntityArr) {
            if (movieEntity.getWatched_at() == null && movieEntity.getCollected_at() == null) {
                i2 += movieDAO.m(movieEntity.getTmdbID(), movieEntity.getImdbIDStr(), movieEntity.getTraktID(), movieEntity.getTvdbID());
            } else {
                Long l3 = null;
                if (movieEntity.getCollected_at() == null) {
                    l2 = null;
                } else {
                    l2 = Long.valueOf(movieEntity.getCollected_at().toEpochSecond());
                }
                movieDAO.k(l2, movieEntity.getTmdbID(), movieEntity.getImdbIDStr(), movieEntity.getTraktID(), movieEntity.getTvdbID());
                if (movieEntity.getWatched_at() != null) {
                    l3 = Long.valueOf(movieEntity.getWatched_at().toEpochSecond());
                }
                movieDAO.p(l3, movieEntity.getTmdbID(), movieEntity.getImdbIDStr(), movieEntity.getTraktID(), movieEntity.getTvdbID());
            }
        }
        return i2;
    }

    public static void b(MovieDAO movieDAO, MovieEntity... movieEntityArr) throws Exception {
        OffsetDateTime offsetDateTime;
        boolean z2;
        Long l2;
        OffsetDateTime offsetDateTime2;
        boolean z3;
        Long l3;
        for (MovieEntity movieEntity : movieEntityArr) {
            Long l4 = null;
            boolean z4 = true;
            if (movieDAO.l(movieEntity.getTmdbID(), movieEntity.getImdbIDStr(), movieEntity.getTraktID(), movieEntity.getTvdbID()) == null) {
                long tmdbID = movieEntity.getTmdbID();
                String imdbIDStr = movieEntity.getImdbIDStr();
                long traktID = movieEntity.getTraktID();
                long tvdbID = movieEntity.getTvdbID();
                long position = movieEntity.getPosition();
                long duration = movieEntity.getDuration();
                String subtitlepath = movieEntity.getSubtitlepath();
                String poster_path = movieEntity.getPoster_path();
                String backdrop_path = movieEntity.getBackdrop_path();
                String name = movieEntity.getName();
                String realeaseDate = movieEntity.getRealeaseDate();
                String overview = movieEntity.getOverview();
                String b2 = MovieEntity.Converter.b(movieEntity.getGenres());
                Double vote = movieEntity.getVote();
                if (movieEntity.getCreatedDate() == null) {
                    offsetDateTime2 = OffsetDateTime.now((ZoneId) ZoneOffset.UTC);
                } else {
                    offsetDateTime2 = movieEntity.getCreatedDate();
                }
                Long valueOf = Long.valueOf(offsetDateTime2.toEpochSecond());
                if (movieEntity.getCollected_at() != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Boolean valueOf2 = Boolean.valueOf(z3);
                if (movieEntity.getWatched_at() == null) {
                    z4 = false;
                }
                Boolean valueOf3 = Boolean.valueOf(z4);
                Boolean tv = movieEntity.getTV();
                int numberSeason = movieEntity.getNumberSeason();
                if (movieEntity.getCollected_at() == null) {
                    l3 = null;
                } else {
                    l3 = Long.valueOf(movieEntity.getCollected_at().toEpochSecond());
                }
                if (movieEntity.getWatched_at() != null) {
                    l4 = Long.valueOf(movieEntity.getWatched_at().toEpochSecond());
                }
                movieDAO.s(tmdbID, imdbIDStr, traktID, tvdbID, position, duration, subtitlepath, poster_path, backdrop_path, name, realeaseDate, overview, b2, vote, valueOf, valueOf2, valueOf3, tv, numberSeason, l3, l4);
            } else {
                long tmdbID2 = movieEntity.getTmdbID();
                String imdbIDStr2 = movieEntity.getImdbIDStr();
                long traktID2 = movieEntity.getTraktID();
                long tvdbID2 = movieEntity.getTvdbID();
                long position2 = movieEntity.getPosition();
                long duration2 = movieEntity.getDuration();
                String subtitlepath2 = movieEntity.getSubtitlepath();
                String poster_path2 = movieEntity.getPoster_path();
                String backdrop_path2 = movieEntity.getBackdrop_path();
                String name2 = movieEntity.getName();
                String realeaseDate2 = movieEntity.getRealeaseDate();
                String overview2 = movieEntity.getOverview();
                String b3 = MovieEntity.Converter.b(movieEntity.getGenres());
                Double vote2 = movieEntity.getVote();
                if (movieEntity.getCreatedDate() == null) {
                    offsetDateTime = OffsetDateTime.now((ZoneId) ZoneOffset.UTC);
                } else {
                    offsetDateTime = movieEntity.getCreatedDate();
                }
                Long valueOf4 = Long.valueOf(offsetDateTime.toEpochSecond());
                if (movieEntity.getCollected_at() != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Boolean valueOf5 = Boolean.valueOf(z2);
                if (movieEntity.getWatched_at() == null) {
                    z4 = false;
                }
                Boolean valueOf6 = Boolean.valueOf(z4);
                Boolean tv2 = movieEntity.getTV();
                int numberSeason2 = movieEntity.getNumberSeason();
                if (movieEntity.getCollected_at() != null) {
                    l2 = Long.valueOf(movieEntity.getCollected_at().toEpochSecond());
                } else {
                    l2 = null;
                }
                if (movieEntity.getWatched_at() != null) {
                    l4 = Long.valueOf(movieEntity.getWatched_at().toEpochSecond());
                }
                movieDAO.q(tmdbID2, imdbIDStr2, traktID2, tvdbID2, position2, duration2, subtitlepath2, poster_path2, backdrop_path2, name2, realeaseDate2, overview2, b3, vote2, valueOf4, valueOf5, valueOf6, tv2, numberSeason2, l2, l4);
            }
        }
    }
}
