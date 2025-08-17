package com.movie.data.model.tmvdb;

import android.os.Parcel;
import android.os.Parcelable;
import com.database.entitys.MovieEntity;
import com.database.entitys.SeasonEntity;
import com.movie.data.model.MovieConverter;
import java.util.ArrayList;
import java.util.List;

public class TvTMDB {
    private int page;
    private List<ResultsBean> results;
    private int total_pages;
    private int total_results;

    public static class ResultsBean implements MovieConverter {
        private String backdrop_path;
        private List<CreatedByBean> created_by;
        private List<Integer> episode_run_time;
        private ExternalID external_ids;
        private String first_air_date;
        private List<Integer> genre_ids;
        private List<GenresBean> genres;
        private String homepage;
        private int id;
        private boolean in_production;
        private List<String> languages;
        private String last_air_date;
        private LastEpisodeToAirBean last_episode_to_air;
        private String name;
        private List<NetworksBean> networks;
        private NextEpisodeToAirBean next_episode_to_air;
        private int number_of_episodes;
        private int number_of_seasons;
        private List<String> origin_country;
        private String original_language;
        private String original_name;
        private String overview;
        private double popularity;
        private String poster_path;
        private List<ProductionCompaniesBean> production_companies;
        private List<SeasonsBean> seasons;
        private String status;
        private String type;
        private double vote_average;
        private int vote_count;

        public static class CreatedByBean {
            private String credit_id;
            private int gender;
            private int id;
            private String name;
            private String profile_path;

            public String getCredit_id() {
                return this.credit_id;
            }

            public int getGender() {
                return this.gender;
            }

            public int getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public String getProfile_path() {
                return this.profile_path;
            }

            public void setCredit_id(String str) {
                this.credit_id = str;
            }

            public void setGender(int i2) {
                this.gender = i2;
            }

            public void setId(int i2) {
                this.id = i2;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setProfile_path(String str) {
                this.profile_path = str;
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

        public static class LastEpisodeToAirBean implements Parcelable {
            public static final Parcelable.Creator<LastEpisodeToAirBean> CREATOR = new Parcelable.Creator<LastEpisodeToAirBean>() {
                public LastEpisodeToAirBean createFromParcel(Parcel parcel) {
                    return new LastEpisodeToAirBean(parcel);
                }

                public LastEpisodeToAirBean[] newArray(int i2) {
                    return new LastEpisodeToAirBean[i2];
                }
            };
            private String air_date;
            private int episode_number;
            private int id;
            private String name;
            private String overview;
            private Object production_code;
            private int season_number;
            private int show_id;
            private String still_path;
            private double vote_average;
            private int vote_count;

            protected LastEpisodeToAirBean(Parcel parcel) {
                this.air_date = parcel.readString();
                this.episode_number = parcel.readInt();
                this.id = parcel.readInt();
                this.name = parcel.readString();
                this.overview = parcel.readString();
                this.season_number = parcel.readInt();
                this.show_id = parcel.readInt();
                this.still_path = parcel.readString();
                this.vote_average = parcel.readDouble();
                this.vote_count = parcel.readInt();
            }

            public int describeContents() {
                return 0;
            }

            public String getAir_date() {
                return this.air_date;
            }

            public int getEpisode_number() {
                return this.episode_number;
            }

            public int getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public String getOverview() {
                return this.overview;
            }

            public Object getProduction_code() {
                return this.production_code;
            }

            public int getSeason_number() {
                return this.season_number;
            }

            public int getShow_id() {
                return this.show_id;
            }

            public String getStill_path() {
                return this.still_path;
            }

            public double getVote_average() {
                return this.vote_average;
            }

            public int getVote_count() {
                return this.vote_count;
            }

            public void setAir_date(String str) {
                this.air_date = str;
            }

            public void setEpisode_number(int i2) {
                this.episode_number = i2;
            }

            public void setId(int i2) {
                this.id = i2;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setOverview(String str) {
                this.overview = str;
            }

            public void setProduction_code(Object obj) {
                this.production_code = obj;
            }

            public void setSeason_number(int i2) {
                this.season_number = i2;
            }

            public void setShow_id(int i2) {
                this.show_id = i2;
            }

            public void setStill_path(String str) {
                this.still_path = str;
            }

            public void setVote_average(double d2) {
                this.vote_average = d2;
            }

            public void setVote_count(int i2) {
                this.vote_count = i2;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeString(this.air_date);
                parcel.writeInt(this.episode_number);
                parcel.writeInt(this.id);
                parcel.writeString(this.name);
                parcel.writeString(this.overview);
                parcel.writeInt(this.season_number);
                parcel.writeInt(this.show_id);
                parcel.writeString(this.still_path);
                parcel.writeDouble(this.vote_average);
                parcel.writeInt(this.vote_count);
            }
        }

        public static class NetworksBean {
            private int id;
            private String logo_path;
            private String name;
            private String origin_country;

            public int getId() {
                return this.id;
            }

            public String getLogo_path() {
                return this.logo_path;
            }

            public String getName() {
                return this.name;
            }

            public String getOrigin_country() {
                return this.origin_country;
            }

            public void setId(int i2) {
                this.id = i2;
            }

            public void setLogo_path(String str) {
                this.logo_path = str;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setOrigin_country(String str) {
                this.origin_country = str;
            }
        }

        public static class NextEpisodeToAirBean {
            private String air_date;
            private int episode_number;
            private int id;
            private String name;
            private String overview;
            private Object production_code;
            private int season_number;
            private int show_id;
            private Object still_path;
            private double vote_average;
            private int vote_count;

            public String getAir_date() {
                return this.air_date;
            }

            public int getEpisode_number() {
                return this.episode_number;
            }

            public int getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public String getOverview() {
                return this.overview;
            }

            public Object getProduction_code() {
                return this.production_code;
            }

            public int getSeason_number() {
                return this.season_number;
            }

            public int getShow_id() {
                return this.show_id;
            }

            public Object getStill_path() {
                return this.still_path;
            }

            public double getVote_average() {
                return this.vote_average;
            }

            public int getVote_count() {
                return this.vote_count;
            }

            public void setAir_date(String str) {
                this.air_date = str;
            }

            public void setEpisode_number(int i2) {
                this.episode_number = i2;
            }

            public void setId(int i2) {
                this.id = i2;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setOverview(String str) {
                this.overview = str;
            }

            public void setProduction_code(Object obj) {
                this.production_code = obj;
            }

            public void setSeason_number(int i2) {
                this.season_number = i2;
            }

            public void setShow_id(int i2) {
                this.show_id = i2;
            }

            public void setStill_path(Object obj) {
                this.still_path = obj;
            }

            public void setVote_average(double d2) {
                this.vote_average = d2;
            }

            public void setVote_count(int i2) {
                this.vote_count = i2;
            }
        }

        public static class ProductionCompaniesBean {
            private int id;
            private Object logo_path;
            private String name;
            private String origin_country;

            public int getId() {
                return this.id;
            }

            public Object getLogo_path() {
                return this.logo_path;
            }

            public String getName() {
                return this.name;
            }

            public String getOrigin_country() {
                return this.origin_country;
            }

            public void setId(int i2) {
                this.id = i2;
            }

            public void setLogo_path(Object obj) {
                this.logo_path = obj;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setOrigin_country(String str) {
                this.origin_country = str;
            }
        }

        public static class SeasonsBean {
            private String air_date;
            private int episode_count;
            private int id;
            private String name;
            private String overview;
            private String poster_path;
            private int season_number;

            public SeasonEntity convert() {
                SeasonEntity seasonEntity = new SeasonEntity();
                seasonEntity.l(this.episode_count);
                seasonEntity.m(this.id);
                seasonEntity.r(this.season_number);
                seasonEntity.k(this.air_date);
                seasonEntity.q(this.poster_path);
                seasonEntity.p(this.overview);
                seasonEntity.o(this.name);
                return seasonEntity;
            }

            public String getAir_date() {
                return this.air_date;
            }

            public int getEpisode_count() {
                return this.episode_count;
            }

            public int getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public String getOverview() {
                return this.overview;
            }

            public String getPoster_path() {
                return this.poster_path;
            }

            public int getSeason_number() {
                return this.season_number;
            }

            public void setAir_date(String str) {
                this.air_date = str;
            }

            public void setEpisode_count(int i2) {
                this.episode_count = i2;
            }

            public void setId(int i2) {
                this.id = i2;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setOverview(String str) {
                this.overview = str;
            }

            public void setPoster_path(String str) {
                this.poster_path = str;
            }

            public void setSeason_number(int i2) {
                this.season_number = i2;
            }
        }

        public MovieEntity convert() {
            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setTmdbID((long) getId());
            movieEntity.setPoster_path(getPoster_path());
            movieEntity.setBackdrop_path(getBackdrop_path());
            movieEntity.setName(getName());
            movieEntity.setRealeaseDate(getFirst_air_date());
            movieEntity.setOverview(getOverview());
            movieEntity.setVote(Double.valueOf(getVote_average()));
            movieEntity.setTV(Boolean.TRUE);
            return movieEntity;
        }

        public String getBackdrop_path() {
            return this.backdrop_path;
        }

        public List<CreatedByBean> getCreated_by() {
            return this.created_by;
        }

        public List<Integer> getEpisode_run_time() {
            return this.episode_run_time;
        }

        public ExternalID getExternal_ids() {
            return this.external_ids;
        }

        public String getFirst_air_date() {
            return this.first_air_date;
        }

        public List<Integer> getGenre_ids() {
            return this.genre_ids;
        }

        public List<GenresBean> getGenres() {
            List<GenresBean> list = this.genres;
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }

        public String getHomepage() {
            return this.homepage;
        }

        public int getId() {
            return this.id;
        }

        public List<String> getLanguages() {
            return this.languages;
        }

        public String getLast_air_date() {
            return this.last_air_date;
        }

        public LastEpisodeToAirBean getLast_episode_to_air() {
            return this.last_episode_to_air;
        }

        public String getName() {
            return this.name;
        }

        public List<NetworksBean> getNetworks() {
            return this.networks;
        }

        public NextEpisodeToAirBean getNext_episode_to_air() {
            return this.next_episode_to_air;
        }

        public int getNumber_of_episodes() {
            return this.number_of_episodes;
        }

        public int getNumber_of_seasons() {
            return this.number_of_seasons;
        }

        public List<String> getOrigin_country() {
            return this.origin_country;
        }

        public String getOriginal_language() {
            return this.original_language;
        }

        public String getOriginal_name() {
            return this.original_name;
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

        public List<SeasonsBean> getSeasons() {
            return this.seasons;
        }

        public String getStatus() {
            return this.status;
        }

        public String getType() {
            return this.type;
        }

        public double getVote_average() {
            return this.vote_average;
        }

        public int getVote_count() {
            return this.vote_count;
        }

        public boolean isIn_production() {
            return this.in_production;
        }

        public void setBackdrop_path(String str) {
            this.backdrop_path = str;
        }

        public void setCreated_by(List<CreatedByBean> list) {
            this.created_by = list;
        }

        public void setEpisode_run_time(List<Integer> list) {
            this.episode_run_time = list;
        }

        public void setExternal_ids(ExternalID externalID) {
            this.external_ids = externalID;
        }

        public void setFirst_air_date(String str) {
            this.first_air_date = str;
        }

        public void setGenre_ids(List<Integer> list) {
            this.genre_ids = list;
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

        public void setIn_production(boolean z2) {
            this.in_production = z2;
        }

        public void setLanguages(List<String> list) {
            this.languages = list;
        }

        public void setLast_air_date(String str) {
            this.last_air_date = str;
        }

        public void setLast_episode_to_air(LastEpisodeToAirBean lastEpisodeToAirBean) {
            this.last_episode_to_air = lastEpisodeToAirBean;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNetworks(List<NetworksBean> list) {
            this.networks = list;
        }

        public void setNext_episode_to_air(NextEpisodeToAirBean nextEpisodeToAirBean) {
            this.next_episode_to_air = nextEpisodeToAirBean;
        }

        public void setNumber_of_episodes(int i2) {
            this.number_of_episodes = i2;
        }

        public void setNumber_of_seasons(int i2) {
            this.number_of_seasons = i2;
        }

        public void setOrigin_country(List<String> list) {
            this.origin_country = list;
        }

        public void setOriginal_language(String str) {
            this.original_language = str;
        }

        public void setOriginal_name(String str) {
            this.original_name = str;
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

        public void setSeasons(List<SeasonsBean> list) {
            this.seasons = list;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setVote_average(double d2) {
            this.vote_average = d2;
        }

        public void setVote_count(int i2) {
            this.vote_count = i2;
        }
    }

    public int getPage() {
        return this.page;
    }

    public List<ResultsBean> getResults() {
        return this.results;
    }

    public int getTotal_pages() {
        return this.total_pages;
    }

    public int getTotal_results() {
        return this.total_results;
    }

    public void setPage(int i2) {
        this.page = i2;
    }

    public void setResults(List<ResultsBean> list) {
        this.results = list;
    }

    public void setTotal_pages(int i2) {
        this.total_pages = i2;
    }

    public void setTotal_results(int i2) {
        this.total_results = i2;
    }
}
