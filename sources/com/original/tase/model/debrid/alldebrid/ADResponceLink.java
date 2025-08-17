package com.original.tase.model.debrid.alldebrid;

import java.util.List;

public class ADResponceLink {
    private DataBean data;
    private String status;

    public static class DataBean {
        private String filename;
        private long filesize;
        private String host;
        private String id;
        private String link;
        private boolean paws;
        private List<?> streaming;
        private List<StreamsBean> streams;

        public static class StreamsBean {
            private String ext;
            private long filesize;
            private String id;
            private String link;
            private String name;
            private int quality;

            public String getExt() {
                return this.ext;
            }

            public long getFilesize() {
                return this.filesize;
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

            public int getQuality() {
                return this.quality;
            }

            public void setExt(String str) {
                this.ext = str;
            }

            public void setFilesize(long j2) {
                this.filesize = j2;
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

            public void setQuality(int i2) {
                this.quality = i2;
            }
        }

        public String getFilename() {
            return this.filename;
        }

        public long getFilesize() {
            return this.filesize;
        }

        public String getHost() {
            return this.host;
        }

        public String getId() {
            return this.id;
        }

        public String getLink() {
            return this.link;
        }

        public StreamsBean getMaxQuality() {
            StreamsBean streamsBean = this.streams.get(0);
            for (StreamsBean next : this.streams) {
                if (next.getQuality() > streamsBean.getQuality()) {
                    streamsBean = next;
                }
            }
            return streamsBean;
        }

        public List<?> getStreaming() {
            return this.streaming;
        }

        public List<StreamsBean> getStreams() {
            return this.streams;
        }

        public boolean isPaws() {
            return this.paws;
        }

        public void setFilename(String str) {
            this.filename = str;
        }

        public void setFilesize(long j2) {
            this.filesize = j2;
        }

        public void setHost(String str) {
            this.host = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setPaws(boolean z2) {
            this.paws = z2;
        }

        public void setStreaming(List<?> list) {
            this.streaming = list;
        }

        public void setStreams(List<StreamsBean> list) {
            this.streams = list;
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
