package com.movie.data.model.cinema;

import com.database.entitys.CrawlCount;
import com.google.gson.Gson;
import java.util.List;

public class CrawlBody {
    private List<CrawlCount> list;
    private String time;

    public List<CrawlCount> getList() {
        return this.list;
    }

    public String getTime() {
        return this.time;
    }

    public void setList(List<CrawlCount> list2) {
        this.list = list2;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        return new Gson().u(this);
    }
}
