package com.photovoltaic.commons.cache.impl;

import com.google.common.cache.CacheStats;
import com.photovoltaic.commons.cache.ICacheManagerService;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.config.CacheConfig;
import com.photovoltaic.config.CacheConfig.Caches;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CacheManagerService implements ICacheManagerService {

	private static final Logger logger = LoggerFactory.getLogger(CacheManagerService.class);

	@Resource
    CacheManager redisCacheManager;
	
	@Resource
    CacheManager guavaCacheManager;
	
	@Override
	public void evictAllRedisCaches() {
		logger.info("EVICT ALL REDIS CACHEABLE CACHE, ALL ENTRIES");
		
		for(String cacheName : redisCacheManager.getCacheNames()){
			redisCacheManager.getCache(cacheName).clear();
		}
		logger.info("EVICT ALL REDIS CACHEABLE CACHE DONE.");
		
	}

	@Override
	public void evictAllGuavaCaches() {
		logger.info("EVICT ALL GUAVA CACHEABLE CACHE, ALL ENTRIES");

		for(String cacheName : guavaCacheManager.getCacheNames()){
			guavaCacheManager.getCache(cacheName).clear();
		}
		logger.info("EVICT ALL GUAVA CACHEABLE CACHE DONE.");
		
	}

	@Override
	public void evictGuavaCaches(CacheConfig.Caches... caches) {
		for(CacheConfig.Caches cache: caches){
			guavaCacheManager.getCache(cache.name()).clear();
		}
	}

	@Override
	public JsonResult getStatus(String type){
		JsonResult jr = null;
		
		switch (type) {
		case "guava":
			List<Map<String, Object>> list = new LinkedList<>();
			
			for(String cacheName : guavaCacheManager.getCacheNames()){
				GuavaCache cache = (GuavaCache) guavaCacheManager.getCache(cacheName);
				com.google.common.cache.Cache<Object, Object> nativeCache = cache.getNativeCache();
				
				Map<String, Object> map =  new LinkedHashMap<>();
				NumberFormat percent = NumberFormat.getPercentInstance(); // 百分比格式化
				
				Caches c = CacheConfig.Caches.findCacheByName(cacheName);
				
				map.put("cacheName", cacheName);
				map.put("size", nativeCache.size());
				map.put("maxSize", c.getMaxSize());
				map.put("duration", c.getTtl());
				CacheStats cs = nativeCache.stats();
				map.put("hitCount", cs.hitCount());
				map.put("requestCount", cs.requestCount());
				map.put("hitRate", cs.requestCount()==0 ? "N/A" : percent.format(cs.hitRate()));
				
				list.add(map);
			}
			
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("cacheList", list);

			jr = new JsonResult(ReturnCode.SUCCESS, "成功获取了guava cache信息。", data);
			
			break;

		default:
			jr = new JsonResult(ReturnCode.PARAMSERROR, "不支持的cache type！", null);
			break;
		}
		return jr;
	}

}
