package com.database.daos;

import com.database.entitys.TvWatchedEpisode;
import java.util.List;

public interface TvWatchedEpisodeDAO {
    int a();

    void b(TvWatchedEpisode... tvWatchedEpisodeArr);

    int c(long j2, String str, long j3, long j4, int i2, int i3);

    void d(long j2, String str, long j3, long j4, int i2, int i3);

    List<TvWatchedEpisode> e(long j2, String str, long j3, long j4, int i2, int i3);

    TvWatchedEpisode f(int i2);

    int g(long j2, String str, long j3, long j4, int i2, int i3, long j5, long j6, String str2);

    List<TvWatchedEpisode> h(long j2, String str, long j3, long j4, int i2);

    long i(long j2, String str, long j3, long j4, int i2, int i3, long j5, long j6, String str2);

    List<TvWatchedEpisode> j(long j2, String str, long j3, long j4);

    List<TvWatchedEpisode> k();

    void l(TvWatchedEpisode... tvWatchedEpisodeArr);
}
