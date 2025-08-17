package com.original.tase.model.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.format.Formatter;
import com.movie.FreeMoviesApp;
import com.movie.data.model.cinema.SyncLink;
import com.movie.data.model.realdebrid.MagnetObject;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Resolver.BaseResolver;
import com.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;

public class MediaSource implements Parcelable, Comparable {
    public static final Parcelable.Creator<MediaSource> CREATOR = new Parcelable.Creator<MediaSource>() {
        public MediaSource createFromParcel(Parcel parcel) {
            return new MediaSource(parcel);
        }

        public MediaSource[] newArray(int i2) {
            return new MediaSource[i2];
        }
    };
    private static HashMap<Integer, String> streamTypeHashMap;
    private boolean alldebrid;
    private boolean debrid;
    private long duration = 0;
    private String extension;
    private String externalName;
    private String extra;
    private long fileSize;
    private String filename;
    private Boolean hls;
    private String hostName;
    private boolean isCachedLink = false;
    private boolean isPlayed = false;
    private boolean isRawTorrent = false;
    private boolean isResolved = false;
    private boolean isTorrent = false;
    private ArrayList<MagnetObject> magnetObjects;
    private String movieName;
    private int nLeek = 0;
    private int nSeek = 0;
    private boolean needToSync = true;
    private String originalLink;
    private HashMap<String, String> playHeader;
    private boolean premiumize;
    private String providerName;
    private String quality;
    private boolean realdebrid;
    private long requestTime;
    private String streamLink;
    private String torrentFileID = "";

    protected MediaSource(Parcel parcel) {
        Boolean bool;
        boolean z2 = false;
        this.premiumize = parcel.readByte() != 0;
        this.realdebrid = parcel.readByte() != 0;
        this.alldebrid = parcel.readByte() != 0;
        this.fileSize = parcel.readLong();
        byte readByte = parcel.readByte();
        if (readByte == 0) {
            bool = null;
        } else {
            bool = Boolean.valueOf(readByte == 1);
        }
        this.hls = bool;
        this.hostName = parcel.readString();
        this.providerName = parcel.readString();
        this.quality = parcel.readString();
        this.streamLink = parcel.readString();
        this.movieName = parcel.readString();
        this.filename = parcel.readString();
        this.extension = parcel.readString();
        this.playHeader = (HashMap) parcel.readSerializable();
        setOriginalLink(parcel.readString());
        this.needToSync = parcel.readByte() != 0;
        this.duration = parcel.readLong();
        this.isTorrent = parcel.readByte() != 0;
        this.isRawTorrent = parcel.readByte() != 0;
        this.nSeek = parcel.readInt();
        this.nLeek = parcel.readInt();
        this.isCachedLink = parcel.readByte() != 0;
        this.isResolved = parcel.readByte() != 0 ? true : z2;
        this.torrentFileID = parcel.readString();
        this.externalName = parcel.readString();
        this.magnetObjects = parcel.readArrayList(MagnetObject.class.getClassLoader());
        this.extra = parcel.readString();
    }

    public MediaSource cloneDeeply() {
        Parcel obtain = Parcel.obtain();
        obtain.writeValue(this);
        obtain.setDataPosition(0);
        return (MediaSource) obtain.readValue(MediaSource.class.getClassLoader());
    }

    public int compareTo(Object obj) {
        MediaSource mediaSource = (MediaSource) obj;
        if (getPriority() > mediaSource.getPriority()) {
            return -1;
        }
        if (getPriority() < mediaSource.getPriority()) {
            return 1;
        }
        if (getFileSize() > mediaSource.getFileSize()) {
            return -1;
        }
        if (getFileSize() < mediaSource.getFileSize()) {
            return 1;
        }
        return 0;
    }

    public SyncLink.Link convertToSynLink() {
        SyncLink.Link link = new SyncLink.Link();
        int i2 = 1;
        if (!this.isTorrent || this.magnetObjects.size() <= 0) {
            link.f31933l = getOriginalLink();
        } else {
            link.f31933l = Regex.a(getMagnetObjects().get(0).getMagnet(), "(magnet:\\?xt=urn:btih:[^&.]+)", 1).toLowerCase();
        }
        link.f31931d = String.valueOf(getDuration());
        if (!isRealdebrid()) {
            if (isPremiumize()) {
                i2 = 2;
            } else if (isAlldebrid()) {
                i2 = 4;
            } else {
                i2 = 0;
            }
        }
        link.f31934p = String.valueOf(i2);
        link.f31936t = String.valueOf(getStreamType());
        link.f31937z = String.valueOf(this.fileSize);
        link.f31935q = getQuality();
        link.f31932h = getProviderName().replace(" ", "_");
        return link;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaSource mediaSource = (MediaSource) obj;
        String str = this.streamLink;
        if (str != null ? !str.equals(mediaSource.streamLink) : mediaSource.streamLink != null) {
            return false;
        }
        HashMap<String, String> hashMap = this.playHeader;
        if (hashMap != null) {
            return hashMap.equals(mediaSource.playHeader);
        }
        if (mediaSource.playHeader == null) {
            return true;
        }
        return false;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getEpisodeOrder() {
        String a2 = Regex.a(this.filename, "([Ss]?([0-9]{1,2}))[Eex]", 2);
        String a3 = Regex.a(this.filename, "([Eex]([0-9]{2})(?:[^0-9]|$))", 2);
        try {
            return Integer.parseInt(a2 + a3);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getEps() {
        try {
            return Integer.parseInt(Regex.a(this.filename, "([Eex]([0-9]{2})(?:[^0-9]|$))", 2));
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getExtension() {
        return this.extension;
    }

    public String getExtra() {
        return this.extra;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileSizeString() {
        if (this.fileSize < 0) {
            return "";
        }
        return "[" + Formatter.formatFileSize(Utils.v(), this.fileSize) + "]";
    }

    public String getFilename() {
        return this.filename;
    }

    public Boolean getHLSBase() {
        return this.hls;
    }

    public String getHostName() {
        return this.hostName;
    }

    public ArrayList<MagnetObject> getMagnetObjects() {
        return this.magnetObjects;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getOriginalLink() {
        return this.originalLink;
    }

    public HashMap<String, String> getPlayHeader() {
        return this.playHeader;
    }

    public int getPriority() {
        boolean z2 = FreeMoviesApp.p().getBoolean("pref_show_sort_link_by_size2", true);
        if (FreeMoviesApp.p().getBoolean("pref_show_sort_link_by_quality", true)) {
            return getQualityPriority();
        }
        if (z2) {
            return 0;
        }
        String string = FreeMoviesApp.p().getString("pref_choose_host_priority3", BaseResolver.d());
        String str = this.hostName;
        if (isRealdebrid()) {
            str = "RealDebird";
        }
        if (isAlldebrid()) {
            str = "AllDebird";
        }
        if (isPremiumize()) {
            str = "PREMIUMIZE";
        }
        int indexOf = string.indexOf(str);
        if (indexOf != -1) {
            return (string.length() - indexOf) + getQualityPriority();
        }
        return indexOf;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getQuality() {
        return this.quality;
    }

    public int getQualityPriority() {
        if (this.quality.contains("4K") || this.quality.contains("2K") || this.quality.contains("1440")) {
            return 10;
        }
        if (this.quality.contains("1080") || this.quality.contains("Auto")) {
            return 9;
        }
        if (this.quality.contains("720")) {
            return 8;
        }
        if (this.quality.contains("HD")) {
            return 7;
        }
        if (this.quality.contains("480")) {
            return 6;
        }
        if (this.quality.contains("HQ")) {
            return 5;
        }
        return 0;
    }

    public long getRequestTime() {
        return this.requestTime;
    }

    public int getSeason() {
        try {
            return Integer.parseInt(Regex.a(this.filename, "([Ss]?([0-9]{1,2}))[Eex]", 2));
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getStreamLink() {
        return this.streamLink;
    }

    public long getStreamType() {
        if (isDebrid()) {
            return 8;
        }
        if (isHLS()) {
            return 16;
        }
        if (this.originalLink.contains("drive.google")) {
            return 2;
        }
        if (GoogleVideoHelper.n(this.originalLink)) {
            return 4;
        }
        if (this.originalLink.contains("magnet:") || this.originalLink.contains(".torrent")) {
            return 34359738368L;
        }
        if (this.originalLink.contains("openload") || this.originalLink.contains("oload.")) {
            return 32;
        }
        if (this.originalLink.contains("vidlink")) {
            return 2199023255552L;
        }
        if (this.originalLink.contains("downace")) {
            return 262144;
        }
        if (this.originalLink.contains("userscloud")) {
            return 68719476736L;
        }
        if (this.originalLink.contains("uptobox") || this.originalLink.contains("uptostream")) {
            return 512;
        }
        if (this.originalLink.contains("rapidvideo") || this.originalLink.contains("raptu")) {
            return 128;
        }
        if (this.originalLink.contains("streamango") || this.originalLink.contains("streamcherry")) {
            return 64;
        }
        if (this.originalLink.contains("vidto.me")) {
            return 70368744177664L;
        }
        if (this.originalLink.contains("vidlox")) {
            return 4398046511104L;
        }
        if (this.originalLink.contains("vidtodo") || this.originalLink.contains("vidstodo")) {
            return 140737488355328L;
        }
        if (this.originalLink.contains("vodlock")) {
            return 4503599627370496L;
        }
        if (this.originalLink.contains("powvideo")) {
            return 4294967296L;
        }
        if (this.originalLink.contains("estream")) {
            return PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        if (this.originalLink.contains("daclips")) {
            return 131072;
        }
        if (this.originalLink.contains("movpod")) {
            return 134217728;
        }
        if (this.originalLink.contains("thevideo.me")) {
            return 17179869184L;
        }
        if (this.originalLink.contains("vidzi")) {
            return 2251799813685248L;
        }
        if (this.originalLink.contains("vidoza")) {
            return 17592186044416L;
        }
        if (this.originalLink.contains("them4ufree")) {
            return 8589934592L;
        }
        if (this.originalLink.contains("vidup.me") || this.originalLink.contains("vidup.io") || this.originalLink.contains("vidup.tv")) {
            return 1125899906842624L;
        }
        if (this.originalLink.contains("ok.ru")) {
            return 562949953421312L;
        }
        if (this.originalLink.contains("vidstreaming") || this.originalLink.contains("vidcloud.icu")) {
            return 35184372088832L;
        }
        if (this.originalLink.contains("vidcloud") || this.originalLink.contains("loadvid")) {
            return 1024;
        }
        if (this.originalLink.contains("vcstream")) {
            return 274877906944L;
        }
        if (this.originalLink.contains("gorillavid")) {
            return PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        if (this.originalLink.contains("yourupload")) {
            return 36028797018963968L;
        }
        if (this.originalLink.contains("entervideo")) {
            return 8192;
        }
        if (this.originalLink.contains("mp4upload")) {
            return 268435456;
        }
        if (this.originalLink.contains("fastplay.")) {
            return PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        if (this.originalLink.contains("vshare.eu")) {
            return 9007199254740992L;
        }
        if (this.originalLink.contains("thevideobee.to")) {
            return 2048;
        }
        if (this.originalLink.contains("novamov.com") || this.originalLink.contains("auroravid.to")) {
            return 1073741824;
        }
        if (this.originalLink.contains("nowvideo.sx")) {
            return 2147483648L;
        }
        if (this.originalLink.contains("putload.tv")) {
            return 256;
        }
        if (this.originalLink.contains("cloudvideo")) {
            return 65536;
        }
        if (this.originalLink.contains("vidmoly")) {
            return 8796093022208L;
        }
        if (this.originalLink.contains("gounlimited")) {
            return PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        if (this.originalLink.contains("fembed")) {
            return 4096;
        }
        if (this.originalLink.contains("jawcloud")) {
            return 33554432;
        }
        if (this.originalLink.contains("watchvideo")) {
            return 16384;
        }
        if (this.originalLink.contains("clipwatching")) {
            return 32768;
        }
        if (this.originalLink.contains("idtbox")) {
            return 16777216;
        }
        if (this.originalLink.contains("nofile")) {
            return 536870912;
        }
        if (this.originalLink.contains("xstreamcdn")) {
            return 18014398509481984L;
        }
        if (this.originalLink.contains("viduplayer")) {
            return 281474976710656L;
        }
        if (this.originalLink.contains("streamx.live")) {
            return 8388608;
        }
        if (this.originalLink.contains("vcdn.io")) {
            return 137438953472L;
        }
        if (this.originalLink.contains("jetload")) {
            return 67108864;
        }
        if (this.originalLink.contains("verystream")) {
            return 549755813888L;
        }
        return 144115188075855872L;
    }

    public String getStringToBeCompared() {
        String str;
        String str2 = getQuality().trim().toLowerCase().replace("4k", "2160p").replace("2K", "1440p").replace("quadhd", "1440p").replace("hd", "720p").replace("sd", "480p").replace("hq", "360p") + " [" + this.fileSize + "]";
        if (GoogleVideoHelper.n(getStreamLink())) {
            str = str2 + " [AAA]";
        } else if (isDebrid()) {
            str = str2 + " [BBB]";
        } else {
            str = str2 + " [XXX]";
        }
        String str3 = str + " - " + this.providerName + " [" + this.hostName + "]";
        if (!isHLS()) {
            return str3;
        }
        return str3 + " [HLS]";
    }

    public String getTorrentFileID() {
        return this.torrentFileID;
    }

    public int hashCode() {
        int i2;
        String str = this.streamLink;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = i2 * 31;
        HashMap<String, String> hashMap = this.playHeader;
        if (hashMap != null) {
            i3 = hashMap.hashCode();
        }
        return i4 + i3;
    }

    public boolean isAlldebrid() {
        return this.alldebrid;
    }

    public boolean isCachedLink() {
        return this.isCachedLink;
    }

    public boolean isDebrid() {
        return isAlldebrid() || isRealdebrid() || isPremiumize();
    }

    public boolean isDownload() {
        if (this.providerName.equals("ReleaseBB") || this.providerName.equals("ScnSrc")) {
            return false;
        }
        if (this.streamLink.trim().toLowerCase().contains(".mp4") || this.streamLink.trim().toLowerCase().contains(".mkv")) {
            return true;
        }
        return false;
    }

    public boolean isHD() {
        return this.quality.contains("HD") || this.quality.contains("1080") || this.quality.contains("720") || this.quality.contains("4K") || this.quality.contains("2K") || this.quality.contains("1440");
    }

    public boolean isHLS() {
        Boolean bool = this.hls;
        return (bool != null && bool.booleanValue()) || (this.hls == null && (this.streamLink.trim().toLowerCase().contains("m3u8") || this.streamLink.trim().toLowerCase().contains("/playlist/")));
    }

    public boolean isNeedToSync() {
        return this.needToSync;
    }

    public boolean isPlayed() {
        return this.isPlayed;
    }

    public boolean isPremiumize() {
        return this.premiumize;
    }

    public boolean isRawTorrent() {
        return this.isRawTorrent;
    }

    public boolean isRealdebrid() {
        return this.realdebrid;
    }

    public boolean isResolved() {
        return this.isResolved;
    }

    public boolean isTorrent() {
        return this.isTorrent;
    }

    public void setAlldebrid(boolean z2) {
        this.alldebrid = z2;
    }

    public void setCachedLink(boolean z2) {
        this.isCachedLink = z2;
    }

    public void setDebrid(boolean z2) {
        this.debrid = z2;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setHLS(boolean z2) {
        this.hls = Boolean.valueOf(z2);
    }

    public void setHostName(String str) {
        this.hostName = str;
    }

    public void setMagnetObjects(ArrayList<MagnetObject> arrayList) {
        this.magnetObjects = arrayList;
    }

    public void setMovieName(String str) {
        this.movieName = str;
    }

    public void setNeedToSync(boolean z2) {
        this.needToSync = z2;
    }

    public void setOriginalLink(String str) {
        if (str != null && str.endsWith(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
            str = str.replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "");
        }
        this.originalLink = str;
    }

    public void setPlayHeader(HashMap<String, String> hashMap) {
        this.playHeader = hashMap;
    }

    public void setPlayed(boolean z2) {
        this.isPlayed = z2;
    }

    public void setPremiumize(boolean z2) {
        this.premiumize = z2;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void setQuality(int i2) {
        setQuality(String.valueOf(i2));
    }

    public void setRawTorrent(boolean z2) {
        this.isRawTorrent = z2;
    }

    public void setRealdebrid(boolean z2) {
        this.realdebrid = z2;
    }

    public void setRequestTime(long j2) {
        this.requestTime = j2;
    }

    public void setResolved(boolean z2) {
        this.isResolved = z2;
    }

    public void setStreamLink(String str) {
        if (this.streamLink == null && this.originalLink == null) {
            this.originalLink = str;
        }
        this.streamLink = str;
    }

    public void setTorrent(boolean z2) {
        this.isTorrent = z2;
    }

    public void setTorrentFileID(String str) {
        this.torrentFileID = str;
    }

    public String toString() {
        String str = this.quality + " - [" + this.hostName + "] ";
        if (isHLS()) {
            str = str + " [HLS] ";
        }
        String str2 = str + getFileSizeString();
        if (str2.length() <= 0 || !str2.endsWith(" ")) {
            return str2;
        }
        return str2.substring(0, str2.length() - 1);
    }

    public String toString2() {
        String str;
        String str2 = this.quality + " - " + this.providerName + " [" + this.hostName + "] ";
        String str3 = this.externalName;
        if (str3 != null && !str3.isEmpty()) {
            str2 = this.quality + " - " + this.externalName;
        }
        if (FreeMoviesApp.p().getBoolean("pref_show_file_name_if_available", false) && (str = this.filename) != null && !str.isEmpty()) {
            str2 = this.quality + " - " + this.filename;
        }
        if (isHLS()) {
            str2 = str2 + "[HLS] ";
        }
        if (this.realdebrid) {
            str2 = str2 + "[DEB] ";
        }
        if (this.alldebrid) {
            str2 = str2 + "[ALL-DEB] ";
        }
        if (this.premiumize) {
            str2 = str2 + "[PREMIUMIZE] ";
        }
        if (this.isRawTorrent) {
            str2 = str2 + "[S/L:" + this.nSeek + "/" + this.nLeek + "][Need torrent player] ";
        }
        String str4 = str2 + getFileSizeString();
        if (str4.length() <= 0 || !str4.endsWith(" ")) {
            return str4;
        }
        return str4.substring(0, str4.length() - 1);
    }

    public String toStringAllObjs() {
        return "MediaSource { providerName='" + this.providerName + '\'' + ", hostName='" + this.hostName + '\'' + ", originalLink=" + this.originalLink + '\'' + ", requestTime=" + this.requestTime + '\'' + ", quality='" + this.quality + '\'' + ", streamLink='" + this.streamLink + '\'' + ", playHeader=" + this.playHeader + '\'' + ", fileSize=" + this.fileSize + '\'' + ", alldebrid=" + this.alldebrid + '\'' + ", premiumize=" + this.premiumize + '\'' + ", realdebrid=" + this.realdebrid + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        parcel.writeByte(this.premiumize ? (byte) 1 : 0);
        parcel.writeByte(this.realdebrid ? (byte) 1 : 0);
        parcel.writeByte(this.alldebrid ? (byte) 1 : 0);
        parcel.writeLong(this.fileSize);
        Boolean bool = this.hls;
        if (bool == null) {
            i3 = 0;
        } else if (bool.booleanValue()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.hostName);
        parcel.writeString(this.providerName);
        parcel.writeString(this.quality);
        parcel.writeString(this.streamLink);
        parcel.writeString(this.movieName);
        parcel.writeString(this.filename);
        parcel.writeString(this.extension);
        parcel.writeSerializable(this.playHeader);
        parcel.writeString(getOriginalLink());
        parcel.writeByte(this.needToSync ? (byte) 1 : 0);
        parcel.writeLong(this.duration);
        parcel.writeByte(this.isTorrent ? (byte) 1 : 0);
        parcel.writeByte(this.isRawTorrent ? (byte) 1 : 0);
        parcel.writeInt(this.nSeek);
        parcel.writeInt(this.nLeek);
        parcel.writeByte(this.isCachedLink ? (byte) 1 : 0);
        parcel.writeByte(this.isResolved ? (byte) 1 : 0);
        parcel.writeString(this.torrentFileID);
        parcel.writeString(this.externalName);
        parcel.writeList(this.magnetObjects);
        parcel.writeString(this.extra);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0083, code lost:
        if (r1 != 47689303) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        if (r0.equals("1440p") != false) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setQuality(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = r10.trim()
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "p"
            boolean r2 = r0.endsWith(r1)
            java.lang.String r3 = "4K"
            java.lang.String r4 = "2K"
            r5 = -1
            r6 = 2
            r7 = 1
            if (r2 != 0) goto L_0x0060
            boolean r2 = com.original.tase.utils.Utils.o(r0)
            if (r2 == 0) goto L_0x0060
            int r2 = r0.hashCode()
            r8 = 1511391(0x170fdf, float:2.11791E-39)
            if (r2 == r8) goto L_0x0044
            r8 = 1513189(0x1716e5, float:2.12043E-39)
            if (r2 == r8) goto L_0x003b
            r8 = 1538361(0x177939, float:2.155703E-39)
            if (r2 == r8) goto L_0x0031
            goto L_0x0044
        L_0x0031:
            java.lang.String r2 = "2160"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0044
            r5 = 2
            goto L_0x0044
        L_0x003b:
            java.lang.String r2 = "1600"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0044
            r5 = 1
        L_0x0044:
            if (r5 == r7) goto L_0x005d
            if (r5 == r6) goto L_0x005a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r9.quality = r1
            goto L_0x00af
        L_0x005a:
            r9.quality = r3
            return
        L_0x005d:
            r9.quality = r4
            return
        L_0x0060:
            boolean r2 = r0.endsWith(r1)
            if (r2 == 0) goto L_0x00af
            java.lang.String r2 = ""
            java.lang.String r1 = r0.replace(r1, r2)
            boolean r1 = com.original.tase.utils.Utils.o(r1)
            if (r1 == 0) goto L_0x00af
            int r1 = r0.hashCode()
            r2 = 46853233(0x2caec71, float:2.9816943E-37)
            if (r1 == r2) goto L_0x0086
            r2 = 46908971(0x2cbc62b, float:2.9941912E-37)
            if (r1 == r2) goto L_0x008f
            r2 = 47689303(0x2d7ae57, float:3.1691477E-37)
            if (r1 == r2) goto L_0x0099
            goto L_0x00a2
        L_0x0086:
            java.lang.String r1 = "1440p"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x008f
            goto L_0x00a2
        L_0x008f:
            java.lang.String r1 = "1600p"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0099
            r5 = 1
            goto L_0x00a2
        L_0x0099:
            java.lang.String r1 = "2160p"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00a2
            r5 = 2
        L_0x00a2:
            if (r5 == r7) goto L_0x00ac
            if (r5 == r6) goto L_0x00a9
            r9.quality = r0
            goto L_0x00af
        L_0x00a9:
            r9.quality = r3
            return
        L_0x00ac:
            r9.quality = r4
            return
        L_0x00af:
            java.lang.String r1 = "quadhd"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00bb
            r9.quality = r4
            goto L_0x0187
        L_0x00bb:
            java.lang.String r1 = "4k"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0181
            java.lang.String r1 = "2k"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0181
            java.lang.String r1 = "hd"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0181
            java.lang.String r1 = "hq"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0181
            java.lang.String r1 = "sd"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00e5
            goto L_0x0181
        L_0x00e5:
            java.lang.String r1 = "cam"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x017c
            java.lang.String r1 = "ts"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x00f7
            goto L_0x017c
        L_0x00f7:
            java.lang.String r1 = "vod"
            boolean r1 = r0.equals(r1)
            java.lang.String r2 = "HQ"
            if (r1 != 0) goto L_0x0179
            java.lang.String r1 = "dvd"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x010b
            goto L_0x0179
        L_0x010b:
            java.lang.String r1 = "10"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0119
            java.lang.String r10 = "1080p"
            r9.quality = r10
            goto L_0x0187
        L_0x0119:
            java.lang.String r1 = "7"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0174
            java.lang.String r1 = "6"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0174
            java.lang.String r1 = "8"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0174
            java.lang.String r1 = "9"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x013a
            goto L_0x0174
        L_0x013a:
            java.lang.String r1 = "4"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x016f
            java.lang.String r1 = "5"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x014b
            goto L_0x016f
        L_0x014b:
            java.lang.String r1 = "3"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x016a
            java.lang.String r1 = "2"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x015c
            goto L_0x016a
        L_0x015c:
            java.lang.String r1 = "auto"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r9.quality = r10
            goto L_0x0187
        L_0x0167:
            r9.quality = r2
            goto L_0x0187
        L_0x016a:
            java.lang.String r10 = "360p"
            r9.quality = r10
            goto L_0x0187
        L_0x016f:
            java.lang.String r10 = "480p"
            r9.quality = r10
            goto L_0x0187
        L_0x0174:
            java.lang.String r10 = "720p"
            r9.quality = r10
            goto L_0x0187
        L_0x0179:
            r9.quality = r2
            goto L_0x0187
        L_0x017c:
            java.lang.String r10 = "CAM"
            r9.quality = r10
            goto L_0x0187
        L_0x0181:
            java.lang.String r10 = r0.toUpperCase()
            r9.quality = r10
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.model.media.MediaSource.setQuality(java.lang.String):void");
    }

    public MediaSource(MediaSource mediaSource) {
        this.providerName = mediaSource.getProviderName();
        this.hostName = mediaSource.getHostName();
        this.quality = mediaSource.getQuality();
        this.streamLink = mediaSource.getStreamLink();
        this.playHeader = mediaSource.getPlayHeader();
        this.fileSize = mediaSource.getFileSize();
        this.hls = mediaSource.getHLSBase();
        this.realdebrid = mediaSource.isRealdebrid();
        this.alldebrid = mediaSource.isAlldebrid();
        this.premiumize = mediaSource.isPremiumize();
        this.movieName = mediaSource.movieName;
        this.filename = mediaSource.filename;
        this.extension = mediaSource.extension;
        setOriginalLink(mediaSource.originalLink);
        this.needToSync = mediaSource.needToSync;
        this.duration = mediaSource.duration;
        this.isTorrent = mediaSource.isTorrent;
        this.isRawTorrent = mediaSource.isRawTorrent;
        this.nSeek = mediaSource.nSeek;
        this.nLeek = mediaSource.nLeek;
        this.isCachedLink = mediaSource.isCachedLink;
        this.isResolved = mediaSource.isResolved;
        this.torrentFileID = mediaSource.torrentFileID;
        this.externalName = mediaSource.externalName;
        this.magnetObjects = mediaSource.magnetObjects;
        this.extra = mediaSource.extra;
    }

    public MediaSource(String str, String str2, boolean z2) {
        this.providerName = str;
        this.hostName = str2;
        this.fileSize = -1;
        this.movieName = "";
        this.extension = "";
        this.hls = null;
        this.debrid = false;
        this.alldebrid = false;
        this.premiumize = false;
        if (str == null || str2 == null || str.isEmpty() || this.hostName.isEmpty()) {
            this.quality = "HQ";
        }
    }
}
