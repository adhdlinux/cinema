package com.movie.data.api.tmdb;

import com.movie.data.model.cinema.Review;
import com.movie.data.model.cinema.Session;
import com.movie.data.model.cinema.Video;
import com.movie.data.model.tmvdb.External;
import com.movie.data.model.tmvdb.ExternalID;
import com.movie.data.model.tmvdb.ExternalTV;
import com.movie.data.model.tmvdb.FindResult;
import com.movie.data.model.tmvdb.GenreTMDB;
import com.movie.data.model.tmvdb.ImageResponse;
import com.movie.data.model.tmvdb.ListResult;
import com.movie.data.model.tmvdb.MovieTMDB;
import com.movie.data.model.tmvdb.SearchTMDB;
import com.movie.data.model.tmvdb.SeasonTMDB;
import com.movie.data.model.tmvdb.TvTMDB;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBApi {
    @GET("discover/movie?append_to_response=external_ids")
    Observable<MovieTMDB> discoverMovies(@Query("sort_by") String str, @Query("page") int i2, @Query("with_genres") String str2, @Query("primary_release_year") Integer num);

    @GET("search/multi?append_to_response=external_ids")
    Observable<SearchTMDB> discoverMoviesByQuery(@Query(encoded = true, value = "query") String str, @Query("page") int i2);

    @GET("discover/session?append_to_response=external_ids")
    Observable<Session.Response> discoverSession(@Query("tvName") long j2);

    @GET("discover/tv?append_to_response=external_ids")
    Observable<TvTMDB> discoverTvShows(@Query("sort_by") String str, @Query("page") int i2, @Query("with_genres") String str2, @Query("first_air_date_year") Integer num);

    @GET("discover/tv?append_to_response=external_ids")
    Observable<TvTMDB> discoverTvShowsNetwork(@Query("sort_by") String str, @Query("page") int i2, @Query("with_networks") String str2, @Query("first_air_date_year") Integer num);

    @GET("find/{external_ids}?external_source=imdb_id")
    Observable<FindResult> findbyImdbID(@Path("external_ids") String str);

    @GET("list/{list_id}")
    Observable<ListResult> getList(@Path("list_id") long j2);

    @GET("movie/{movie_id}/external_ids")
    Observable<ExternalID> getMVExternalID(@Path("movie_id") long j2);

    @GET("movie/{movie_id}/recommendations")
    Observable<MovieTMDB> getMVRecomendation(@Path("movie_id") long j2, @Query("page") int i2);

    @GET("movie/{movie_id}?append_to_response=credits,external_ids")
    Observable<MovieTMDB.ResultsBean> getMovieDetails(@Path("movie_id") long j2, @Query("language") String str);

    @GET("movie/{movie_id}/images")
    Observable<ImageResponse> getMovieImages(@Path("movie_id") long j2);

    @GET("discover/movie?sort_by=popularity.desc&with_release_type=2|3")
    Observable<MovieTMDB> getMovieNowPLaying(@Query("page") int i2, @Query("release_date.gte") String str, @Query("release_date.lte") String str2);

    @GET("discover/movie?sort_by=popularity.desc")
    Observable<MovieTMDB> getMoviePopular(@Query("page") int i2);

    @GET("discover/movie?sort_by=vote_average.desc&vote_count.gte=200")
    Observable<MovieTMDB> getMovieTopRated(@Query("page") int i2);

    @GET("discover/movie")
    Observable<MovieTMDB> getMovieUpComming(@Query("page") int i2, @Query("release_date.gte") String str, @Query("release_date.lte") String str2);

    @GET("movie/{reqParam}?&sort_by=popularity.desc&append_to_response=external_ids")
    Observable<MovieTMDB> getMvExtraList(@Path("reqParam") String str, @Query("page") int i2, @Query("primary_release_year") Integer num);

    @GET("tv/{tv_id}/season/{season_number}")
    Observable<SeasonTMDB> getSeasonDetails(@Path("tv_id") long j2, @Path("season_number") int i2);

    @GET("discover/tv?sort_by=popularity.desc")
    Observable<TvTMDB> getShowAringToday(@Query("page") int i2, @Query("air_date.gte") String str, @Query("air_date.lte") String str2);

    @GET("discover/tv?sort_by=popularity.desc")
    Observable<TvTMDB> getShowOnTheAir(@Query("page") int i2, @Query("air_date.gte") String str, @Query("air_date.lte") String str2);

    @GET("discover/tv?sort_by=popularity.desc")
    Observable<TvTMDB> getShowPopular(@Query("page") int i2);

    @GET("discover/tv?sort_by=vote_average.desc&vote_count.gte=200")
    Observable<TvTMDB> getShowTopRated(@Query("page") int i2);

    @GET("tv/{movie_id}?append_to_response=external_ids")
    Observable<TvTMDB.ResultsBean> getTVDetails(@Path("movie_id") long j2, @Query("language") String str);

    @GET("find/{external_ids}?language=en-US")
    Observable<ExternalTV> getTVDetails(@Path("external_ids") String str, @Query("external_source") String str2);

    @GET("tv/{tv_id}/external_ids")
    Observable<ExternalID> getTVExternalID(@Path("tv_id") long j2);

    @GET("tv/{tv_id}/recommendations")
    Observable<TvTMDB> getTVRecomendation(@Path("tv_id") long j2, @Query("page") int i2);

    @GET("tv/{tmdbID}?language=en-US")
    Observable<TvTMDB.ResultsBean> getTvDetails(@Path("tmdbID") long j2);

    @GET("list/{external_ids}?&sort_by=popularity.desc&append_to_response=external_ids")
    Observable<External> getTvExternList(@Path("external_ids") long j2, @Query("page") int i2, @Query("first_air_date_year") Integer num);

    @GET("tv/{reqParam}?&sort_by=popularity.desc&append_to_response=external_ids")
    Observable<TvTMDB> getTvExtraList(@Path("reqParam") String str, @Query("page") int i2, @Query("first_air_date_year") Integer num);

    @GET("genre/movie/list")
    Observable<GenreTMDB> movieGenres();

    @GET("movie/{id}/reviews")
    Observable<Review.Response> reviews(@Path("id") long j2, @Query("page") int i2);

    @GET("genre/tv/list")
    Observable<GenreTMDB> tvGenres();

    @GET("movie/{id}/videos")
    Observable<Video.Response> videos(@Path("id") long j2);
}
