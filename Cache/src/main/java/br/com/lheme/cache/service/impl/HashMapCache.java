package br.com.lheme.cache.service.impl;

import br.com.lheme.cache.model.Plano;
import br.com.lheme.cache.service.Cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapCache implements Cache {

    private static HashMapCache instance;
    private static Map<String,Plano> memoryCache = new HashMap<String, Plano>();


    private  HashMapCache() {
    }

    public static HashMapCache getInstance() {
        if (instance == null) {
            instance = new HashMapCache();
        }
        return instance;
    }

    public void cacheItem(String key, Plano value) {
            memoryCache.put(key, value);
    }

    public void cacheItens(List<Plano> values) {
        values.forEach(value -> cacheItem(value.getNomePlano(), value));
    }

    public void remove(String key) {
        memoryCache.remove(key);
    }

    public Plano getElement(String key) {
        return memoryCache.get(key);
    }

    public Map<String, Plano> getCache() {
        return memoryCache;
    }

    public void resetCache() {
        memoryCache.clear();
    }
}
