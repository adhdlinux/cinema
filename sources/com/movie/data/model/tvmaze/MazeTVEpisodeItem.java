package com.movie.data.model.tvmaze;

import java.util.List;

public class MazeTVEpisodeItem {
    private LinksBeanX _links;
    private String airdate;
    private String airstamp;
    private String airtime;
    private int id;
    private Object image;
    private String name;
    private int number;
    private int runtime;
    private int season;
    private ShowBean show;
    private Object summary;
    private String url;

    public static class LinksBeanX {
        private SelfBeanX self;

        public static class SelfBeanX {
            private String href;

            public String getHref() {
                return this.href;
            }

            public void setHref(String str) {
                this.href = str;
            }
        }

        public SelfBeanX getSelf() {
            return this.self;
        }

        public void setSelf(SelfBeanX selfBeanX) {
            this.self = selfBeanX;
        }
    }

    public static class ShowBean {
        private LinksBean _links;
        private ExternalsBean externals;
        private List<String> genres;
        private int id;
        private ImageBean image;
        private String language;
        private String name;
        private NetworkBean network;
        private String officialSite;
        private String premiered;
        private RatingBean rating;
        private int runtime;
        private ScheduleBean schedule;
        private String status;
        private String summary;
        private String type;
        private int updated;
        private String url;
        private Object webChannel;
        private int weight;

        public static class ExternalsBean {
            private String imdb;
            private int thetvdb;
            private int tvrage;

            public String getImdb() {
                return this.imdb;
            }

            public int getThetvdb() {
                return this.thetvdb;
            }

            public int getTvrage() {
                return this.tvrage;
            }

            public void setImdb(String str) {
                this.imdb = str;
            }

            public void setThetvdb(int i2) {
                this.thetvdb = i2;
            }

            public void setTvrage(int i2) {
                this.tvrage = i2;
            }
        }

        public static class ImageBean {
            private String medium;
            private String original;

            public String getMedium() {
                return this.medium;
            }

            public String getOriginal() {
                return this.original;
            }

            public void setMedium(String str) {
                this.medium = str;
            }

            public void setOriginal(String str) {
                this.original = str;
            }
        }

        public static class LinksBean {
            private NextepisodeBean nextepisode;
            private PreviousepisodeBean previousepisode;
            private SelfBean self;

            public static class NextepisodeBean {
                private String href;

                public String getHref() {
                    return this.href;
                }

                public void setHref(String str) {
                    this.href = str;
                }
            }

            public static class PreviousepisodeBean {
                private String href;

                public String getHref() {
                    return this.href;
                }

                public void setHref(String str) {
                    this.href = str;
                }
            }

            public static class SelfBean {
                private String href;

                public String getHref() {
                    return this.href;
                }

                public void setHref(String str) {
                    this.href = str;
                }
            }

            public NextepisodeBean getNextepisode() {
                return this.nextepisode;
            }

            public PreviousepisodeBean getPreviousepisode() {
                return this.previousepisode;
            }

            public SelfBean getSelf() {
                return this.self;
            }

            public void setNextepisode(NextepisodeBean nextepisodeBean) {
                this.nextepisode = nextepisodeBean;
            }

            public void setPreviousepisode(PreviousepisodeBean previousepisodeBean) {
                this.previousepisode = previousepisodeBean;
            }

            public void setSelf(SelfBean selfBean) {
                this.self = selfBean;
            }
        }

        public static class NetworkBean {
            private CountryBean country;
            private int id;
            private String name;

            public static class CountryBean {
                private String code;
                private String name;
                private String timezone;

                public String getCode() {
                    return this.code;
                }

                public String getName() {
                    return this.name;
                }

                public String getTimezone() {
                    return this.timezone;
                }

                public void setCode(String str) {
                    this.code = str;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public void setTimezone(String str) {
                    this.timezone = str;
                }
            }

            public CountryBean getCountry() {
                return this.country;
            }

            public int getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public void setCountry(CountryBean countryBean) {
                this.country = countryBean;
            }

            public void setId(int i2) {
                this.id = i2;
            }

            public void setName(String str) {
                this.name = str;
            }
        }

        public static class RatingBean {
            private double average;

            public double getAverage() {
                return this.average;
            }

            public void setAverage(double d2) {
                this.average = d2;
            }
        }

        public static class ScheduleBean {
            private List<String> days;
            private String time;

            public List<String> getDays() {
                return this.days;
            }

            public String getTime() {
                return this.time;
            }

            public void setDays(List<String> list) {
                this.days = list;
            }

            public void setTime(String str) {
                this.time = str;
            }
        }

        public ExternalsBean getExternals() {
            return this.externals;
        }

        public List<String> getGenres() {
            return this.genres;
        }

        public int getId() {
            return this.id;
        }

        public ImageBean getImage() {
            return this.image;
        }

        public String getLanguage() {
            return this.language;
        }

        public String getName() {
            return this.name;
        }

        public NetworkBean getNetwork() {
            return this.network;
        }

        public String getOfficialSite() {
            return this.officialSite;
        }

        public String getPremiered() {
            return this.premiered;
        }

        public RatingBean getRating() {
            return this.rating;
        }

        public int getRuntime() {
            return this.runtime;
        }

        public ScheduleBean getSchedule() {
            return this.schedule;
        }

        public String getStatus() {
            return this.status;
        }

        public String getSummary() {
            return this.summary;
        }

        public String getType() {
            return this.type;
        }

        public int getUpdated() {
            return this.updated;
        }

        public String getUrl() {
            return this.url;
        }

        public Object getWebChannel() {
            return this.webChannel;
        }

        public int getWeight() {
            return this.weight;
        }

        public LinksBean get_links() {
            return this._links;
        }

        public void setExternals(ExternalsBean externalsBean) {
            this.externals = externalsBean;
        }

        public void setGenres(List<String> list) {
            this.genres = list;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setImage(ImageBean imageBean) {
            this.image = imageBean;
        }

        public void setLanguage(String str) {
            this.language = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNetwork(NetworkBean networkBean) {
            this.network = networkBean;
        }

        public void setOfficialSite(String str) {
            this.officialSite = str;
        }

        public void setPremiered(String str) {
            this.premiered = str;
        }

        public void setRating(RatingBean ratingBean) {
            this.rating = ratingBean;
        }

        public void setRuntime(int i2) {
            this.runtime = i2;
        }

        public void setSchedule(ScheduleBean scheduleBean) {
            this.schedule = scheduleBean;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setSummary(String str) {
            this.summary = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUpdated(int i2) {
            this.updated = i2;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setWebChannel(Object obj) {
            this.webChannel = obj;
        }

        public void setWeight(int i2) {
            this.weight = i2;
        }

        public void set_links(LinksBean linksBean) {
            this._links = linksBean;
        }
    }

    public String getAirdate() {
        return this.airdate;
    }

    public String getAirstamp() {
        return this.airstamp;
    }

    public String getAirtime() {
        return this.airtime;
    }

    public int getId() {
        return this.id;
    }

    public Object getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public int getSeason() {
        return this.season;
    }

    public ShowBean getShow() {
        return this.show;
    }

    public Object getSummary() {
        return this.summary;
    }

    public String getUrl() {
        return this.url;
    }

    public LinksBeanX get_links() {
        return this._links;
    }

    public void setAirdate(String str) {
        this.airdate = str;
    }

    public void setAirstamp(String str) {
        this.airstamp = str;
    }

    public void setAirtime(String str) {
        this.airtime = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setImage(Object obj) {
        this.image = obj;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNumber(int i2) {
        this.number = i2;
    }

    public void setRuntime(int i2) {
        this.runtime = i2;
    }

    public void setSeason(int i2) {
        this.season = i2;
    }

    public void setShow(ShowBean showBean) {
        this.show = showBean;
    }

    public void setSummary(Object obj) {
        this.summary = obj;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void set_links(LinksBeanX linksBeanX) {
        this._links = linksBeanX;
    }
}
