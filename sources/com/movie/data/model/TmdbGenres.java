package com.movie.data.model;

import android.util.SparseArray;

public class TmdbGenres {
    private static SparseArray<String> mvlist;
    private static SparseArray<String> tvlist;

    public static boolean canFilter(int i2, boolean z2) {
        return z2 ? (i2 == -6 || i2 == -7 || i2 == -8 || i2 == -9 || i2 == -10) ? false : true : (i2 == -6 || i2 == -7 || i2 == -8) ? false : true;
    }

    public static SparseArray<String> getMVCategory() {
        if (mvlist == null) {
            SparseArray<String> sparseArray = new SparseArray<>();
            mvlist = sparseArray;
            sparseArray.put(28, "Action");
            mvlist.put(12, "Adventure");
            mvlist.put(16, "Animation");
            mvlist.put(35, "Comedy");
            mvlist.put(80, "Crime");
            mvlist.put(99, "Documentary");
            mvlist.put(18, "Drama");
            mvlist.put(10751, "Family");
            mvlist.put(14, "Fantasy");
            mvlist.put(36, "History");
            mvlist.put(27, "Horror");
            mvlist.put(10402, "Music");
            mvlist.put(9648, "Mystery");
            mvlist.put(10749, "Romance");
            mvlist.put(878, "Sci-fi");
            mvlist.put(10770, "TV Movie");
            mvlist.put(53, "Thriller");
            mvlist.put(10752, "War");
            mvlist.put(37, "Western");
        }
        return mvlist;
    }

    public static SparseArray<String> getTVCategory() {
        if (tvlist == null) {
            SparseArray<String> sparseArray = new SparseArray<>();
            tvlist = sparseArray;
            sparseArray.put(10759, "Action & Adventure");
            tvlist.put(16, "Animation");
            tvlist.put(35, "Comedy");
            tvlist.put(80, "Crime");
            tvlist.put(99, "Documentary");
            tvlist.put(18, "Drama");
            tvlist.put(10751, "Family");
            tvlist.put(10762, "Kids");
            tvlist.put(9648, "Mystery");
            tvlist.put(10763, "News");
            tvlist.put(10764, "Reality");
            tvlist.put(10765, "Sci-Fi & Fantasy");
            tvlist.put(10766, "Soap");
            tvlist.put(10767, "Talk");
            tvlist.put(10768, "War & Politics");
            tvlist.put(37, "Western");
        }
        return tvlist;
    }
}
