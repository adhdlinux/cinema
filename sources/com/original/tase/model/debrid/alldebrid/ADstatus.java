package com.original.tase.model.debrid.alldebrid;

import com.movie.data.model.TorrentObject;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

public class ADstatus {
    private DataBean data;
    private String status;

    public static class DataBean {
        private List<MagnetsBean> magnets;

        public static class MagnetsBean implements TorrentObject.TorrentObjectConverter {
            private int completionDate;
            private int downloadSpeed;
            private long downloaded;
            private String filename;
            private String hash;
            private int id;
            private List<LinksBean> links;
            private int seeders;
            private long size;
            private String status;
            private int statusCode;
            private int uploadDate;
            private int uploadSpeed;
            private long uploaded;

            public static class FilesLinkBean {

                /* renamed from: n  reason: collision with root package name */
                private String f34047n;

                public String getN() {
                    return this.f34047n;
                }

                public void setN(String str) {
                    this.f34047n = str;
                }
            }

            public static class LinksBean {
                /* access modifiers changed from: private */
                public String filename;
                private List<FilesLinkBean> files;
                private String link;
                private long size;

                public String getFilename() {
                    return this.filename;
                }

                public List<FilesLinkBean> getFiles() {
                    return this.files;
                }

                public String getLink() {
                    return this.link;
                }

                public long getSize() {
                    return this.size;
                }

                public void setFilename(String str) {
                    this.filename = str;
                }

                public void setFiles(List<FilesLinkBean> list) {
                    this.files = list;
                }

                public void setLink(String str) {
                    this.link = str;
                }

                public void setSize(long j2) {
                    this.size = j2;
                }
            }

            private int getprogress() {
                long j2;
                if (this.size <= 0) {
                    return 0;
                }
                if (this.status.contains("Uploading")) {
                    j2 = (this.uploaded * 100) / this.size;
                } else {
                    j2 = (this.downloaded * 100) / this.size;
                }
                return (int) j2;
            }

            public TorrentObject convert() {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                List<LinksBean> list = this.links;
                if (list != null) {
                    for (LinksBean next : list) {
                        arrayList.add(new TorrentObject.FileBean(next.filename, next.getLink(), next.getSize(), (String) null));
                        arrayList2.add(next.getLink());
                    }
                }
                TorrentObject torrentObject = new TorrentObject();
                torrentObject.setAddedTime(new DateTime((long) this.uploadDate).toString());
                torrentObject.setFiles(arrayList);
                torrentObject.setHash(getHash());
                torrentObject.setGotDetails(true);
                torrentObject.setId(String.valueOf(this.id));
                torrentObject.setListLink(arrayList2);
                torrentObject.setName(getFilename());
                torrentObject.setSize(getSize());
                if (this.status.contains("Uploading")) {
                    torrentObject.setStatusBean(new TorrentObject.StatusBean(getStatus(), getprogress(), getSeeders(), (long) getUploadSpeed()));
                } else {
                    torrentObject.setStatusBean(new TorrentObject.StatusBean(getStatus(), getprogress(), getSeeders(), (long) getDownloadSpeed()));
                }
                torrentObject.setType(TorrentObject.Type.AD);
                return torrentObject;
            }

            public int getCompletionDate() {
                return this.completionDate;
            }

            public int getDownloadSpeed() {
                return this.downloadSpeed;
            }

            public long getDownloaded() {
                return this.downloaded;
            }

            public String getFilename() {
                return this.filename;
            }

            public String getHash() {
                return this.hash;
            }

            public int getId() {
                return this.id;
            }

            public List<LinksBean> getLinks() {
                return this.links;
            }

            public int getSeeders() {
                return this.seeders;
            }

            public long getSize() {
                return this.size;
            }

            public String getStatus() {
                return this.status;
            }

            public int getStatusCode() {
                return this.statusCode;
            }

            public int getUploadDate() {
                return this.uploadDate;
            }

            public int getUploadSpeed() {
                return this.uploadSpeed;
            }

            public long getUploaded() {
                return this.uploaded;
            }

            public void setCompletionDate(int i2) {
                this.completionDate = i2;
            }

            public void setDownloadSpeed(int i2) {
                this.downloadSpeed = i2;
            }

            public void setDownloaded(long j2) {
                this.downloaded = j2;
            }

            public void setFilename(String str) {
                this.filename = str;
            }

            public void setHash(String str) {
                this.hash = str;
            }

            public void setId(int i2) {
                this.id = i2;
            }

            public void setLinks(List<LinksBean> list) {
                this.links = list;
            }

            public void setSeeders(int i2) {
                this.seeders = i2;
            }

            public void setSize(long j2) {
                this.size = j2;
            }

            public void setStatus(String str) {
                this.status = str;
            }

            public void setStatusCode(int i2) {
                this.statusCode = i2;
            }

            public void setUploadDate(int i2) {
                this.uploadDate = i2;
            }

            public void setUploadSpeed(int i2) {
                this.uploadSpeed = i2;
            }

            public void setUploaded(long j2) {
                this.uploaded = j2;
            }
        }

        public List<MagnetsBean> getMagnets() {
            return this.magnets;
        }

        public void setMagnets(List<MagnetsBean> list) {
            this.magnets = list;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public String getStatus() {
        return this.status;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
