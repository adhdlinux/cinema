package com.database.daos.premiumDAO.torrents;

import com.database.entitys.premiumEntitys.torrents.CachedTorrentFileEntity;
import java.util.List;

public interface CachedTorrentFileDAO {
    void a(CachedTorrentFileEntity... cachedTorrentFileEntityArr);

    List<CachedTorrentFileEntity> b(int i2, int i3, int i4);

    void c(CachedTorrentFileEntity... cachedTorrentFileEntityArr);

    void d(CachedTorrentFileEntity... cachedTorrentFileEntityArr);
}
