package com.original.tase.model.media.movie.tmdb;

import com.original.tase.model.media.TmdbVideosBean;
import java.util.List;

public class TmdbMovieInfoResult {
    private boolean adult;
    private String backdrop_path;
    private BelongsToCollectionBean belongs_to_collection;
    private long budget;
    private List<GenresBean> genres;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private List<ProductionCompaniesBean> production_companies;
    private List<ProductionCountriesBean> production_countries;
    private String release_date;
    private ReleasesBean releases;
    private long revenue;
    private int runtime;
    private List<SpokenLanguagesBean> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private TmdbVideosBean videos;
    private double vote_average;
    private int vote_count;

    public static class BelongsToCollectionBean {
        private String backdrop_path;
        private int id;
        private String name;
        private String poster_path;

        public String getBackdrop_path() {
            return this.backdrop_path;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getPoster_path() {
            return this.poster_path;
        }

        public void setBackdrop_path(String str) {
            this.backdrop_path = str;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPoster_path(String str) {
            this.poster_path = str;
        }
    }

    public static class GenresBean {
        private int id;
        private String name;

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public static class ProductionCompaniesBean {
        private int id;
        private String name;

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public static class ProductionCountriesBean {
        private String iso_3166_1;
        private String name;

        public String getIso_3166_1() {
            return this.iso_3166_1;
        }

        public String getName() {
            return this.name;
        }

        public void setIso_3166_1(String str) {
            this.iso_3166_1 = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public static class ReleasesBean {
        private List<CountriesBean> countries;

        public static class CountriesBean {
            private String certification;
            private String iso_3166_1;
            private boolean primary;
            private String release_date;

            public String getCertification() {
                return this.certification;
            }

            public String getIso_3166_1() {
                return this.iso_3166_1;
            }

            public String getRelease_date() {
                return this.release_date;
            }

            public boolean isPrimary() {
                return this.primary;
            }

            public void setCertification(String str) {
                this.certification = str;
            }

            public void setIso_3166_1(String str) {
                this.iso_3166_1 = str;
            }

            public void setPrimary(boolean z2) {
                this.primary = z2;
            }

            public void setRelease_date(String str) {
                this.release_date = str;
            }
        }

        public List<CountriesBean> getCountries() {
            return this.countries;
        }

        public void setCountries(List<CountriesBean> list) {
            this.countries = list;
        }
    }

    public static class SpokenLanguagesBean {
        private String iso_639_1;
        private String name;

        public String getIso_639_1() {
            return this.iso_639_1;
        }

        public String getName() {
            return this.name;
        }

        public void setIso_639_1(String str) {
            this.iso_639_1 = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public String getBackdrop_path() {
        return this.backdrop_path;
    }

    public BelongsToCollectionBean getBelongs_to_collection() {
        return this.belongs_to_collection;
    }

    public long getBudget() {
        return this.budget;
    }

    public List<GenresBean> getGenres() {
        return this.genres;
    }

    public String getHomepage() {
        return this.homepage;
    }

    public int getId() {
        return this.id;
    }

    public String getImdb_id() {
        return this.imdb_id;
    }

    public String getOriginal_language() {
        return this.original_language;
    }

    public String getOriginal_title() {
        return this.original_title;
    }

    public String getOverview() {
        return this.overview;
    }

    public double getPopularity() {
        return this.popularity;
    }

    public String getPoster_path() {
        return this.poster_path;
    }

    public List<ProductionCompaniesBean> getProduction_companies() {
        return this.production_companies;
    }

    public List<ProductionCountriesBean> getProduction_countries() {
        return this.production_countries;
    }

    public String getRelease_date() {
        return this.release_date;
    }

    public ReleasesBean getReleases() {
        return this.releases;
    }

    public long getRevenue() {
        return this.revenue;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public List<SpokenLanguagesBean> getSpoken_languages() {
        return this.spoken_languages;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTagline() {
        return this.tagline;
    }

    public String getTitle() {
        return this.title;
    }

    public TmdbVideosBean getVideos() {
        return this.videos;
    }

    public double getVote_average() {
        return this.vote_average;
    }

    public int getVote_count() {
        return this.vote_count;
    }

    public boolean isAdult() {
        return this.adult;
    }

    public boolean isVideo() {
        return this.video;
    }

    public void setAdult(boolean z2) {
        this.adult = z2;
    }

    public void setBackdrop_path(String str) {
        this.backdrop_path = str;
    }

    public void setBelongs_to_collection(BelongsToCollectionBean belongsToCollectionBean) {
        this.belongs_to_collection = belongsToCollectionBean;
    }

    public void setBudget(int i2) {
        this.budget = (long) i2;
    }

    public void setGenres(List<GenresBean> list) {
        this.genres = list;
    }

    public void setHomepage(String str) {
        this.homepage = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setImdb_id(String str) {
        this.imdb_id = str;
    }

    public void setOriginal_language(String str) {
        this.original_language = str;
    }

    public void setOriginal_title(String str) {
        this.original_title = str;
    }

    public void setOverview(String str) {
        this.overview = str;
    }

    public void setPopularity(double d2) {
        this.popularity = d2;
    }

    public void setPoster_path(String str) {
        this.poster_path = str;
    }

    public void setProduction_companies(List<ProductionCompaniesBean> list) {
        this.production_companies = list;
    }

    public void setProduction_countries(List<ProductionCountriesBean> list) {
        this.production_countries = list;
    }

    public void setRelease_date(String str) {
        this.release_date = str;
    }

    public void setReleases(ReleasesBean releasesBean) {
        this.releases = releasesBean;
    }

    public void setRevenue(int i2) {
        this.revenue = (long) i2;
    }

    public void setRuntime(int i2) {
        this.runtime = i2;
    }

    public void setSpoken_languages(List<SpokenLanguagesBean> list) {
        this.spoken_languages = list;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTagline(String str) {
        this.tagline = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideo(boolean z2) {
        this.video = z2;
    }

    public void setVideos(TmdbVideosBean tmdbVideosBean) {
        this.videos = tmdbVideosBean;
    }

    public void setVote_average(double d2) {
        this.vote_average = d2;
    }

    public void setVote_count(int i2) {
        this.vote_count = i2;
    }
}
