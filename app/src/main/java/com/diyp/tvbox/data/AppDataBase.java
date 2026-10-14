package com.diyp.tvbox.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.diyp.tvbox.cache.Cache;
import com.diyp.tvbox.cache.CacheDao;
import com.diyp.tvbox.cache.SearchDao;
import com.diyp.tvbox.cache.SearchHistory;
import com.diyp.tvbox.cache.StorageDrive;
import com.diyp.tvbox.cache.StorageDriveDao;
import com.diyp.tvbox.cache.VodCollect;
import com.diyp.tvbox.cache.VodCollectDao;
import com.diyp.tvbox.cache.VodRecord;
import com.diyp.tvbox.cache.VodRecordDao;


/**
 * 类描述:
 *
 * @author pj567
 * @since 2020/5/15
 */
@Database(entities = {Cache.class, VodRecord.class, VodCollect.class, StorageDrive.class, SearchHistory.class}, version = 3)
public abstract class AppDataBase extends RoomDatabase {
    public abstract CacheDao getCacheDao();

    public abstract VodRecordDao getVodRecordDao();

    public abstract VodCollectDao getVodCollectDao();

    public abstract StorageDriveDao getStorageDriveDao();

    public abstract SearchDao getSearchDao();
}
