package com.uwetrottmann.trakt5.entities;

import java.util.List;

public class ListItemRank {
    public List<Long> rank;

    public static ListItemRank from(List<Long> list) {
        ListItemRank listItemRank = new ListItemRank();
        listItemRank.rank = list;
        return listItemRank;
    }
}
