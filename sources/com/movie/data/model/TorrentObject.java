package com.movie.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.database.entitys.premiumEntitys.torrents.TorrentEntity;
import com.original.tase.utils.Regex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TorrentObject implements Parcelable {
    public static final Parcelable.Creator<TorrentObject> CREATOR = new Parcelable.Creator<TorrentObject>() {
        public TorrentObject createFromParcel(Parcel parcel) {
            return new TorrentObject(parcel);
        }

        public TorrentObject[] newArray(int i2) {
            return new TorrentObject[i2];
        }
    };
    private String addedTime;
    private String file_id;
    List<FileBean> files;
    private String folder_id;
    private String hash;
    private String id;
    private boolean isGotDetails;
    List<String> listLink;
    private String name;
    private long size;
    private StatusBean statusBean;
    private TorrentEntity torrentEntity;
    private Type type;

    public interface TorrentObjectConverter {
        TorrentObject convert();
    }

    public enum Type {
        RD(0),
        AD(1),
        PM(2);
        
        private int type;

        private Type(int i2) {
            this.type = i2;
        }
    }

    public TorrentObject() {
        this.listLink = new ArrayList();
        this.isGotDetails = false;
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
        TorrentObject torrentObject = (TorrentObject) obj;
        if (!Objects.equals(this.hash, torrentObject.hash) || this.type != torrentObject.type) {
            return false;
        }
        return true;
    }

    public String getAddedTime() {
        return this.addedTime;
    }

    public String getFile_id() {
        return this.file_id;
    }

    public List<FileBean> getFiles() {
        return this.files;
    }

    public String getFolder_id() {
        return this.folder_id;
    }

    public String getHash() {
        return this.hash;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getListLink() {
        return this.listLink;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public StatusBean getStatusBean() {
        return this.statusBean;
    }

    public TorrentEntity getTorrentEntity() {
        return this.torrentEntity;
    }

    public Type getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.hash, this.type});
    }

    public boolean isGotDetails() {
        return this.isGotDetails;
    }

    public void setAddedTime(String str) {
        this.addedTime = str;
    }

    public void setFile_id(String str) {
        this.file_id = str;
    }

    public void setFiles(List<FileBean> list) {
        this.files = list;
    }

    public void setFolder_id(String str) {
        this.folder_id = str;
    }

    public void setGotDetails(boolean z2) {
        this.isGotDetails = z2;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setListLink(List<String> list) {
        this.listLink = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(long j2) {
        this.size = j2;
    }

    public void setStatusBean(StatusBean statusBean2) {
        this.statusBean = statusBean2;
    }

    public void setTorrentEntity(TorrentEntity torrentEntity2) {
        this.torrentEntity = torrentEntity2;
    }

    public void setType(Type type2) {
        this.type = type2;
    }

    public TorrentObject sort() {
        List<FileBean> list = this.files;
        if (list == null) {
            return this;
        }
        Collections.sort(list, new Comparator<FileBean>() {
            public int compare(FileBean fileBean, FileBean fileBean2) {
                return fileBean.getOrder() < fileBean2.getOrder() ? -1 : 1;
            }
        });
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        parcel.writeTypedList(this.files);
        parcel.writeStringList(this.listLink);
        parcel.writeByte(this.isGotDetails ? (byte) 1 : 0);
        parcel.writeString(this.name);
        parcel.writeString(this.hash);
        parcel.writeString(this.id);
        parcel.writeString(this.folder_id);
        parcel.writeString(this.file_id);
        parcel.writeLong(this.size);
        parcel.writeString(this.addedTime);
        parcel.writeParcelable(this.statusBean, i2);
        parcel.writeParcelable(this.torrentEntity, i2);
        Type type2 = this.type;
        if (type2 == null) {
            i3 = -1;
        } else {
            i3 = type2.ordinal();
        }
        parcel.writeInt(i3);
    }

    protected TorrentObject(Parcel parcel) {
        this.listLink = new ArrayList();
        boolean z2 = false;
        this.isGotDetails = false;
        this.files = parcel.createTypedArrayList(FileBean.CREATOR);
        this.listLink = parcel.createStringArrayList();
        this.isGotDetails = parcel.readByte() != 0 ? true : z2;
        this.name = parcel.readString();
        this.hash = parcel.readString();
        this.id = parcel.readString();
        this.folder_id = parcel.readString();
        this.file_id = parcel.readString();
        this.size = parcel.readLong();
        this.addedTime = parcel.readString();
        this.statusBean = (StatusBean) parcel.readParcelable(StatusBean.class.getClassLoader());
        this.torrentEntity = (TorrentEntity) parcel.readParcelable(TorrentEntity.class.getClassLoader());
        this.type = Type.values()[parcel.readInt()];
    }

    public static class StatusBean implements Parcelable {
        public static final Parcelable.Creator<StatusBean> CREATOR = new Parcelable.Creator<StatusBean>() {
            public StatusBean createFromParcel(Parcel parcel) {
                return new StatusBean(parcel);
            }

            public StatusBean[] newArray(int i2) {
                return new StatusBean[i2];
            }
        };
        private int progress;
        private int seeders;
        private long speed;
        private String status;

        public StatusBean(String str, int i2, int i3, long j2) {
            this.status = str;
            this.progress = i2;
            this.seeders = i3;
            this.speed = j2;
        }

        public int describeContents() {
            return 0;
        }

        public int getProgress() {
            return this.progress;
        }

        public int getSeeders() {
            return this.seeders;
        }

        public long getSpeed() {
            return this.speed;
        }

        public String getStatus() {
            return this.status;
        }

        public boolean isReady() {
            return getProgress() == 100;
        }

        public void setProgress(int i2) {
            this.progress = i2;
        }

        public void setSeeders(int i2) {
            this.seeders = i2;
        }

        public void setSpeed(long j2) {
            this.speed = j2;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.status);
            parcel.writeInt(this.progress);
            parcel.writeInt(this.seeders);
            parcel.writeDouble((double) this.speed);
        }

        protected StatusBean(Parcel parcel) {
            this.status = parcel.readString();
            this.progress = parcel.readInt();
            this.seeders = parcel.readInt();
            this.speed = parcel.readLong();
        }
    }

    public static class FileBean implements Parcelable {
        public static final Parcelable.Creator<FileBean> CREATOR = new Parcelable.Creator<FileBean>() {
            public FileBean createFromParcel(Parcel parcel) {
                return new FileBean(parcel);
            }

            public FileBean[] newArray(int i2) {
                return new FileBean[i2];
            }
        };
        private String id;
        private String link;
        private String name;
        private String quality;
        private long size;

        protected FileBean(Parcel parcel) {
            this.name = parcel.readString();
            this.link = parcel.readString();
            this.size = parcel.readLong();
            this.id = parcel.readString();
            this.quality = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getId() {
            return this.id;
        }

        public String getLink() {
            return this.link;
        }

        public String getName() {
            return this.name;
        }

        public int getOrder() {
            String a2 = Regex.a(this.name, "([Ss]?([0-9]{1,2}))[Eex]", 2);
            String a3 = Regex.a(this.name, "([Eex]([0-9]{2})(?:[^0-9]|$))", 2);
            try {
                return Integer.parseInt(a2 + a3);
            } catch (Exception unused) {
                return 0;
            }
        }

        public String getQuality() {
            return this.quality;
        }

        public long getSize() {
            return this.size;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setQuality(String str) {
            this.quality = str;
        }

        public void setSize(long j2) {
            this.size = j2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.name);
            parcel.writeString(this.link);
            parcel.writeLong(this.size);
            parcel.writeString(this.id);
            parcel.writeString(this.quality);
        }

        public FileBean(String str, String str2, long j2, String str3) {
            this.name = str;
            this.link = str2;
            this.size = j2;
            this.id = str3;
        }
    }
}
