package com.photovoltaic.commons.cache;


import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.config.CacheConfig;

public interface ICacheManagerService {

	void evictAllRedisCaches();

	JsonResult getStatus(String type);

	void evictAllGuavaCaches();

	void evictGuavaCaches(CacheConfig.Caches... cacheName);
}
