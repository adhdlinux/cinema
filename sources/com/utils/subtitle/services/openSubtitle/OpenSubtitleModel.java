package com.utils.subtitle.services.openSubtitle;

public class OpenSubtitleModel {
    private String IDMovie;
    private String IDMovieImdb;
    private String IDSubMovieFile;
    private String IDSubtitle;
    private String IDSubtitleFile;
    private String ISO639;
    private String InfoFormat;
    private String InfoOther;
    private String InfoReleaseGroup;
    private String LanguageName;
    private String MatchedBy;
    private String MovieByteSize;
    private String MovieFPS;
    private String MovieHash;
    private String MovieImdbRating;
    private String MovieKind;
    private String MovieName;
    private Object MovieNameEng;
    private String MovieReleaseName;
    private String MovieTimeMS;
    private String MovieYear;
    private int QueryCached;
    private String QueryNumber;
    private QueryParametersBean QueryParameters;
    private double Score;
    private String SeriesEpisode;
    private String SeriesIMDBParent;
    private String SeriesSeason;
    private String SubActualCD;
    private String SubAddDate;
    private String SubAuthorComment;
    private String SubAutoTranslation;
    private String SubBad;
    private String SubComments;
    private String SubDownloadLink;
    private String SubDownloadsCnt;
    private String SubEncoding;
    private String SubFeatured;
    private String SubFileName;
    private String SubForeignPartsOnly;
    private String SubFormat;
    private String SubFromTrusted;
    private String SubHD;
    private String SubHash;
    private String SubHearingImpaired;
    private String SubLanguageID;
    private String SubLastTS;
    private String SubRating;
    private String SubSize;
    private String SubSumCD;
    private String SubSumVotes;
    private String SubTSGroup;
    private String SubTSGroupHash;
    private String SubTranslator;
    private String SubtitlesLink;
    private String UserID;
    private String UserNickName;
    private String UserRank;
    private String ZipDownloadLink;

    public static class QueryParametersBean {
        private int episode;
        private String imdbid;
        private int season;

        public int getEpisode() {
            return this.episode;
        }

        public String getImdbid() {
            return this.imdbid;
        }

        public int getSeason() {
            return this.season;
        }

        public void setEpisode(int i2) {
            this.episode = i2;
        }

        public void setImdbid(String str) {
            this.imdbid = str;
        }

        public void setSeason(int i2) {
            this.season = i2;
        }
    }

    public String getIDMovie() {
        return this.IDMovie;
    }

    public String getIDMovieImdb() {
        return this.IDMovieImdb;
    }

    public String getIDSubMovieFile() {
        return this.IDSubMovieFile;
    }

    public String getIDSubtitle() {
        return this.IDSubtitle;
    }

    public String getIDSubtitleFile() {
        return this.IDSubtitleFile;
    }

    public String getISO639() {
        return this.ISO639;
    }

    public String getInfoFormat() {
        return this.InfoFormat;
    }

    public String getInfoOther() {
        return this.InfoOther;
    }

    public String getInfoReleaseGroup() {
        return this.InfoReleaseGroup;
    }

    public String getLanguageName() {
        return this.LanguageName;
    }

    public String getMatchedBy() {
        return this.MatchedBy;
    }

    public String getMovieByteSize() {
        return this.MovieByteSize;
    }

    public String getMovieFPS() {
        return this.MovieFPS;
    }

    public String getMovieHash() {
        return this.MovieHash;
    }

    public String getMovieImdbRating() {
        return this.MovieImdbRating;
    }

    public String getMovieKind() {
        return this.MovieKind;
    }

    public String getMovieName() {
        return this.MovieName;
    }

    public Object getMovieNameEng() {
        return this.MovieNameEng;
    }

    public String getMovieReleaseName() {
        return this.MovieReleaseName;
    }

    public String getMovieTimeMS() {
        return this.MovieTimeMS;
    }

    public String getMovieYear() {
        return this.MovieYear;
    }

    public int getQueryCached() {
        return this.QueryCached;
    }

    public String getQueryNumber() {
        return this.QueryNumber;
    }

    public QueryParametersBean getQueryParameters() {
        return this.QueryParameters;
    }

    public double getScore() {
        return this.Score;
    }

    public String getSeriesEpisode() {
        return this.SeriesEpisode;
    }

    public String getSeriesIMDBParent() {
        return this.SeriesIMDBParent;
    }

    public String getSeriesSeason() {
        return this.SeriesSeason;
    }

    public String getSubActualCD() {
        return this.SubActualCD;
    }

    public String getSubAddDate() {
        return this.SubAddDate;
    }

    public String getSubAuthorComment() {
        return this.SubAuthorComment;
    }

    public String getSubAutoTranslation() {
        return this.SubAutoTranslation;
    }

    public String getSubBad() {
        return this.SubBad;
    }

    public String getSubComments() {
        return this.SubComments;
    }

    public String getSubDownloadLink() {
        return this.SubDownloadLink;
    }

    public String getSubDownloadsCnt() {
        return this.SubDownloadsCnt;
    }

    public String getSubEncoding() {
        return this.SubEncoding;
    }

    public String getSubFeatured() {
        return this.SubFeatured;
    }

    public String getSubFileName() {
        return this.SubFileName;
    }

    public String getSubForeignPartsOnly() {
        return this.SubForeignPartsOnly;
    }

    public String getSubFormat() {
        return this.SubFormat;
    }

    public String getSubFromTrusted() {
        return this.SubFromTrusted;
    }

    public String getSubHD() {
        return this.SubHD;
    }

    public String getSubHash() {
        return this.SubHash;
    }

    public String getSubHearingImpaired() {
        return this.SubHearingImpaired;
    }

    public String getSubLanguageID() {
        return this.SubLanguageID;
    }

    public String getSubLastTS() {
        return this.SubLastTS;
    }

    public String getSubRating() {
        return this.SubRating;
    }

    public String getSubSize() {
        return this.SubSize;
    }

    public String getSubSumCD() {
        return this.SubSumCD;
    }

    public String getSubSumVotes() {
        return this.SubSumVotes;
    }

    public String getSubTSGroup() {
        return this.SubTSGroup;
    }

    public String getSubTSGroupHash() {
        return this.SubTSGroupHash;
    }

    public String getSubTranslator() {
        return this.SubTranslator;
    }

    public String getSubtitlesLink() {
        return this.SubtitlesLink;
    }

    public String getUserID() {
        return this.UserID;
    }

    public String getUserNickName() {
        return this.UserNickName;
    }

    public String getUserRank() {
        return this.UserRank;
    }

    public String getZipDownloadLink() {
        return this.ZipDownloadLink;
    }

    public void setIDMovie(String str) {
        this.IDMovie = str;
    }

    public void setIDMovieImdb(String str) {
        this.IDMovieImdb = str;
    }

    public void setIDSubMovieFile(String str) {
        this.IDSubMovieFile = str;
    }

    public void setIDSubtitle(String str) {
        this.IDSubtitle = str;
    }

    public void setIDSubtitleFile(String str) {
        this.IDSubtitleFile = str;
    }

    public void setISO639(String str) {
        this.ISO639 = str;
    }

    public void setInfoFormat(String str) {
        this.InfoFormat = str;
    }

    public void setInfoOther(String str) {
        this.InfoOther = str;
    }

    public void setInfoReleaseGroup(String str) {
        this.InfoReleaseGroup = str;
    }

    public void setLanguageName(String str) {
        this.LanguageName = str;
    }

    public void setMatchedBy(String str) {
        this.MatchedBy = str;
    }

    public void setMovieByteSize(String str) {
        this.MovieByteSize = str;
    }

    public void setMovieFPS(String str) {
        this.MovieFPS = str;
    }

    public void setMovieHash(String str) {
        this.MovieHash = str;
    }

    public void setMovieImdbRating(String str) {
        this.MovieImdbRating = str;
    }

    public void setMovieKind(String str) {
        this.MovieKind = str;
    }

    public void setMovieName(String str) {
        this.MovieName = str;
    }

    public void setMovieNameEng(Object obj) {
        this.MovieNameEng = obj;
    }

    public void setMovieReleaseName(String str) {
        this.MovieReleaseName = str;
    }

    public void setMovieTimeMS(String str) {
        this.MovieTimeMS = str;
    }

    public void setMovieYear(String str) {
        this.MovieYear = str;
    }

    public void setQueryCached(int i2) {
        this.QueryCached = i2;
    }

    public void setQueryNumber(String str) {
        this.QueryNumber = str;
    }

    public void setQueryParameters(QueryParametersBean queryParametersBean) {
        this.QueryParameters = queryParametersBean;
    }

    public void setScore(double d2) {
        this.Score = d2;
    }

    public void setSeriesEpisode(String str) {
        this.SeriesEpisode = str;
    }

    public void setSeriesIMDBParent(String str) {
        this.SeriesIMDBParent = str;
    }

    public void setSeriesSeason(String str) {
        this.SeriesSeason = str;
    }

    public void setSubActualCD(String str) {
        this.SubActualCD = str;
    }

    public void setSubAddDate(String str) {
        this.SubAddDate = str;
    }

    public void setSubAuthorComment(String str) {
        this.SubAuthorComment = str;
    }

    public void setSubAutoTranslation(String str) {
        this.SubAutoTranslation = str;
    }

    public void setSubBad(String str) {
        this.SubBad = str;
    }

    public void setSubComments(String str) {
        this.SubComments = str;
    }

    public void setSubDownloadLink(String str) {
        this.SubDownloadLink = str;
    }

    public void setSubDownloadsCnt(String str) {
        this.SubDownloadsCnt = str;
    }

    public void setSubEncoding(String str) {
        this.SubEncoding = str;
    }

    public void setSubFeatured(String str) {
        this.SubFeatured = str;
    }

    public void setSubFileName(String str) {
        this.SubFileName = str;
    }

    public void setSubForeignPartsOnly(String str) {
        this.SubForeignPartsOnly = str;
    }

    public void setSubFormat(String str) {
        this.SubFormat = str;
    }

    public void setSubFromTrusted(String str) {
        this.SubFromTrusted = str;
    }

    public void setSubHD(String str) {
        this.SubHD = str;
    }

    public void setSubHash(String str) {
        this.SubHash = str;
    }

    public void setSubHearingImpaired(String str) {
        this.SubHearingImpaired = str;
    }

    public void setSubLanguageID(String str) {
        this.SubLanguageID = str;
    }

    public void setSubLastTS(String str) {
        this.SubLastTS = str;
    }

    public void setSubRating(String str) {
        this.SubRating = str;
    }

    public void setSubSize(String str) {
        this.SubSize = str;
    }

    public void setSubSumCD(String str) {
        this.SubSumCD = str;
    }

    public void setSubSumVotes(String str) {
        this.SubSumVotes = str;
    }

    public void setSubTSGroup(String str) {
        this.SubTSGroup = str;
    }

    public void setSubTSGroupHash(String str) {
        this.SubTSGroupHash = str;
    }

    public void setSubTranslator(String str) {
        this.SubTranslator = str;
    }

    public void setSubtitlesLink(String str) {
        this.SubtitlesLink = str;
    }

    public void setUserID(String str) {
        this.UserID = str;
    }

    public void setUserNickName(String str) {
        this.UserNickName = str;
    }

    public void setUserRank(String str) {
        this.UserRank = str;
    }

    public void setZipDownloadLink(String str) {
        this.ZipDownloadLink = str;
    }
}
