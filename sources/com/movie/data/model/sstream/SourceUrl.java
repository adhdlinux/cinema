package com.movie.data.model.sstream;

class SourceUrl {
    private String file;
    private String id;
    private String title;

    SourceUrl() {
    }

    public String getFile() {
        return this.file;
    }

    public String getTitle() {
        return this.title;
    }

    public String getid() {
        return this.id;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setid(String str) {
        this.id = str;
    }
}
