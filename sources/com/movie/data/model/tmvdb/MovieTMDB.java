package com.movie.data.model.tmvdb;

import android.os.Parcel;
import com.database.entitys.MovieEntity;
import com.movie.data.model.MovieConverter;
import com.movie.data.model.tmvdb.TvTMDB;
import java.util.ArrayList;
import java.util.List;

public final class MovieTMDB {
    private int page;
    private List<ResultsBean> results;
    private int total_pages;
    private int total_results;

    public static class ResultsBean implements MovieConverter {
        private boolean adult;
        private String backdrop_path;
        private Credit credits;
        private ExternalID external_ids;
        private List<Integer> genre_ids;
        private List<TvTMDB.ResultsBean.GenresBean> genres;
        private int id;
        private String imdb_id;
        private String original_language;
        private String original_title;
        private String overview;
        private double popularity;
        private String poster_path;
        private String release_date;
        private long runtime;
        private String title;
        private boolean video;
        private double vote_average;
        private int vote_count;

        public static class Credit {
            private List<CastBean> cast;
            private List<CrewBean> crew;

            public static class CastBean {
                private int cast_id;
                private String character;
                private String credit_id;
                private int gender;
                private int id;
                private String name;
                private int order;
                private String profile_path;

                public int getCast_id() {
                    return this.cast_id;
                }

                public String getCharacter() {
                    return this.character;
                }

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

                public int getOrder() {
                    return this.order;
                }

                public String getProfile_path() {
                    return this.profile_path;
                }

                public void setCast_id(int i2) {
                    this.cast_id = i2;
                }

                public void setCharacter(String str) {
                    this.character = str;
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

                public void setOrder(int i2) {
                    this.order = i2;
                }

                public void setProfile_path(String str) {
                    this.profile_path = str;
                }
            }

            public static class CrewBean {
                private String credit_id;
                private String department;
                private int gender;
                private int id;
                private String job;
                private String name;
                private Object profile_path;

                public String getCredit_id() {
                    return this.credit_id;
                }

                public String getDepartment() {
                    return this.department;
                }

                public int getGender() {
                    return this.gender;
                }

                public int getId() {
                    return this.id;
                }

                public String getJob() {
                    return this.job;
                }

                public String getName() {
                    return this.name;
                }

                public Object getProfile_path() {
                    return this.profile_path;
                }

                public void setCredit_id(String str) {
                    this.credit_id = str;
                }

                public void setDepartment(String str) {
                    this.department = str;
                }

                public void setGender(int i2) {
                    this.gender = i2;
                }

                public void setId(int i2) {
                    this.id = i2;
                }

                public void setJob(String str) {
                    this.job = str;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public void setProfile_path(Object obj) {
                    this.profile_path = obj;
                }
            }

            public List<CastBean> getCast() {
                return this.cast;
            }

            public List<CrewBean> getCrew() {
                return this.crew;
            }

            public void setCast(List<CastBean> list) {
                this.cast = list;
            }

            public void setCrew(List<CrewBean> list) {
                this.crew = list;
            }
        }

        public MovieEntity convert() {
            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setTmdbID((long) getId());
            movieEntity.setPoster_path(getPoster_path());
            movieEntity.setBackdrop_path(getBackdrop_path());
            movieEntity.setName(getTitle());
            movieEntity.setRealeaseDate(getRelease_date());
            movieEntity.setOverview(getOverview());
            movieEntity.setVote(Double.valueOf(getVote_average()));
            movieEntity.setTV(Boolean.FALSE);
            movieEntity.setImdbIDStr(getImdb_id());
            movieEntity.setDuration(getRuntime());
            return movieEntity;
        }

        public String getBackdrop_path() {
            return this.backdrop_path;
        }

        public Credit getCredits() {
            return this.credits;
        }

        public ExternalID getExternal_ids() {
            return this.external_ids;
        }

        public List<Integer> getGenre_ids() {
            List<Integer> list = this.genre_ids;
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }

        public List<TvTMDB.ResultsBean.GenresBean> getGenres() {
            List<TvTMDB.ResultsBean.GenresBean> list = this.genres;
            if (list == null) {
                return new ArrayList();
            }
            return list;
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

        public String getRelease_date() {
            return this.release_date;
        }

        public long getRuntime() {
            return this.runtime;
        }

        public String getTitle() {
            return this.title;
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

        public void setCredits(Credit credit) {
            this.credits = credit;
        }

        public void setGenre_ids(List<Integer> list) {
            this.genre_ids = list;
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

        public void setRelease_date(String str) {
            this.release_date = str;
        }

        public void setRuntime(long j2) {
            this.runtime = j2;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setVideo(boolean z2) {
            this.video = z2;
        }

        public void setVote_average(double d2) {
            this.vote_average = d2;
        }

        public void setVote_count(int i2) {
            this.vote_count = i2;
        }
    }

    protected MovieTMDB(Parcel parcel) {
        this.page = parcel.readInt();
        this.total_results = parcel.readInt();
        this.total_pages = parcel.readInt();
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
