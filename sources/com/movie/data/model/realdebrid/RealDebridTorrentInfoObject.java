package com.movie.data.model.realdebrid;

import android.os.Parcel;
import android.os.Parcelable;
import com.movie.data.model.TorrentObject;
import java.util.ArrayList;
import java.util.List;

public class RealDebridTorrentInfoObject implements Parcelable, TorrentObject.TorrentObjectConverter {
    public static final Parcelable.Creator<RealDebridTorrentInfoObject> CREATOR = new Parcelable.Creator<RealDebridTorrentInfoObject>() {
        public RealDebridTorrentInfoObject createFromParcel(Parcel parcel) {
            return new RealDebridTorrentInfoObject(parcel);
        }

        public RealDebridTorrentInfoObject[] newArray(int i2) {
            return new RealDebridTorrentInfoObject[i2];
        }
    };
    private String added;
    private long bytes;
    private String ended;
    private String filename;
    private List<FilesBean> files;
    private String hash;
    private String host;
    private String id;
    private boolean isGotDetails = false;
    private List<String> links;
    private long original_bytes;
    private String original_filename;
    private int progress;
    private int seeders;
    private long speed;
    private int split;
    private String status;

    public static class FilesBean implements Parcelable {
        public static final Parcelable.Creator<FilesBean> CREATOR = new Parcelable.Creator<FilesBean>() {
            public FilesBean createFromParcel(Parcel parcel) {
                return new FilesBean(parcel);
            }

            public FilesBean[] newArray(int i2) {
                return new FilesBean[i2];
            }
        };
        private long bytes;
        /* access modifiers changed from: private */
        public int id;
        private String link;
        /* access modifiers changed from: private */
        public String path;
        private int selected;

        public FilesBean() {
        }

        public int describeContents() {
            return 0;
        }

        public long getBytes() {
            return this.bytes;
        }

        public int getId() {
            return this.id;
        }

        public String getLink() {
            return this.link;
        }

        public String getPath() {
            return this.path;
        }

        public int getSelected() {
            return this.selected;
        }

        public void setBytes(long j2) {
            this.bytes = j2;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public void setSelected(int i2) {
            this.selected = i2;
        }

        public String toString() {
            return String.valueOf(this.id);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.id);
            parcel.writeString(this.path);
            parcel.writeLong(this.bytes);
            parcel.writeInt(this.selected);
            parcel.writeString(this.link);
        }

        protected FilesBean(Parcel parcel) {
            this.id = parcel.readInt();
            this.path = parcel.readString();
            this.bytes = parcel.readLong();
            this.selected = parcel.readInt();
            this.link = parcel.readString();
        }
    }

    public RealDebridTorrentInfoObject() {
    }

    public RealDebridTorrentInfoObject cloneDeeply() {
        Parcel obtain = Parcel.obtain();
        obtain.writeValue(this);
        obtain.setDataPosition(0);
        return (RealDebridTorrentInfoObject) obtain.readValue(RealDebridTorrentInfoObject.class.getClassLoader());
    }

    public TorrentObject convert() {
        ArrayList arrayList = new ArrayList();
        List<FilesBean> list = this.files;
        if (list != null) {
            for (FilesBean next : list) {
                if (next.getSelected() == 1) {
                    arrayList.add(new TorrentObject.FileBean(next.path, "", next.getBytes(), String.valueOf(next.getId())));
                }
            }
        }
        TorrentObject torrentObject = new TorrentObject();
        torrentObject.setAddedTime(getAdded());
        torrentObject.setFiles(arrayList);
        torrentObject.setHash(getHash());
        torrentObject.setId(getId());
        torrentObject.setListLink(getLinks());
        torrentObject.setName(getFilename());
        torrentObject.setSize(getBytes());
        torrentObject.setStatusBean(new TorrentObject.StatusBean(getStatus(), getProgress(), getSeeders(), getSpeed()));
        torrentObject.setType(TorrentObject.Type.RD);
        return torrentObject;
    }

    public int describeContents() {
        return 0;
    }

    public String getAdded() {
        return this.added;
    }

    public long getBytes() {
        return this.bytes;
    }

    public String getEnded() {
        return this.ended;
    }

    public List<String> getFileIDList() {
        ArrayList arrayList = new ArrayList();
        for (FilesBean access$000 : this.files) {
            arrayList.add(String.valueOf(access$000.id));
        }
        return arrayList;
    }

    public String getFilename() {
        return this.filename;
    }

    public List<FilesBean> getFiles() {
        return this.files;
    }

    public String getHash() {
        return this.hash;
    }

    public String getHost() {
        return this.host;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getLinks() {
        return this.links;
    }

    public long getOriginal_bytes() {
        return this.original_bytes;
    }

    public String getOriginal_filename() {
        return this.original_filename;
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

    public int getSplit() {
        return this.split;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isGotDetails() {
        return this.isGotDetails;
    }

    public void setAdded(String str) {
        this.added = str;
    }

    public void setBytes(long j2) {
        this.bytes = j2;
    }

    public void setEnded(String str) {
        this.ended = str;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setFiles(List<FilesBean> list) {
        this.files = list;
    }

    public void setGotDetails(boolean z2) {
        this.isGotDetails = z2;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLinks(List<String> list) {
        this.links = list;
    }

    public void setOriginal_bytes(long j2) {
        this.original_bytes = j2;
    }

    public void setOriginal_filename(String str) {
        this.original_filename = str;
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

    public void setSplit(int i2) {
        this.split = i2;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.filename);
        parcel.writeString(this.original_filename);
        parcel.writeString(this.hash);
        parcel.writeLong(this.bytes);
        parcel.writeLong(this.original_bytes);
        parcel.writeString(this.host);
        parcel.writeInt(this.split);
        parcel.writeInt(this.progress);
        parcel.writeInt(this.seeders);
        parcel.writeString(this.status);
        parcel.writeString(this.added);
        parcel.writeString(this.ended);
        parcel.writeLong(this.speed);
        parcel.writeTypedList(this.files);
        parcel.writeStringList(this.links);
        parcel.writeByte(this.isGotDetails ? (byte) 1 : 0);
    }

    protected RealDebridTorrentInfoObject(Parcel parcel) {
        boolean z2 = false;
        this.id = parcel.readString();
        this.filename = parcel.readString();
        this.original_filename = parcel.readString();
        this.hash = parcel.readString();
        this.bytes = parcel.readLong();
        this.original_bytes = parcel.readLong();
        this.host = parcel.readString();
        this.split = parcel.readInt();
        this.progress = parcel.readInt();
        this.seeders = parcel.readInt();
        this.status = parcel.readString();
        this.added = parcel.readString();
        this.ended = parcel.readString();
        this.speed = parcel.readLong();
        this.files = parcel.createTypedArrayList(FilesBean.CREATOR);
        this.links = parcel.createStringArrayList();
        this.isGotDetails = parcel.readByte() != 0 ? true : z2;
    }
}
