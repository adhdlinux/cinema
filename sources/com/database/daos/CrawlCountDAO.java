package com.database.daos;

import com.database.entitys.CrawlCount;
import java.util.List;

public interface CrawlCountDAO {
    List<CrawlCount> getAll();
}
