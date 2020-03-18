package br.com.lheme.cache.service;

import br.com.lheme.cache.model.Plano;

import java.util.List;
import java.util.Map;

public interface Cache {

    void cacheItem(String key, Plano value);

    void cacheItens(List<Plano> values);

    void remove(String key);

    Plano getElement(String key);

    Map<String, Plano> getCache();

    void resetCache();


}
