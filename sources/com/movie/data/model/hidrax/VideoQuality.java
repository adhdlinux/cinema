package com.movie.data.model.hidrax;

import java.util.List;

public class VideoQuality {
    private List<Long> fullHd;
    private List<Long> hd;
    private int pieceLength;
    private List<Long> sd;

    public List<Long> getFullHd() {
        return this.fullHd;
    }

    public List<Long> getHd() {
        return this.hd;
    }

    public int getPieceLength() {
        return this.pieceLength;
    }

    public List<Long> getSd() {
        return this.sd;
    }

    public void setFullHd(List<Long> list) {
        this.fullHd = list;
    }

    public void setHd(List<Long> list) {
        this.hd = list;
    }

    public void setPieceLength(int i2) {
        this.pieceLength = i2;
    }

    public void setSd(List<Long> list) {
        this.sd = list;
    }
}
