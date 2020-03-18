package br.com.lheme.cache.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.lheme.cache.model.Plano;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheImp {
	
	private static final String PLANOS_CACHE = "planosDeSaude";
	private static final String PATH = "./file/planos.csv";

	public static void main(String[] args) throws IOException {
		
		CacheManager manager = CacheManager.getInstance();
		manager.addCache(PLANOS_CACHE);
		
		Cache cache = manager.getCache(PLANOS_CACHE);
		List<Plano> planos = readFile(PATH);
		
		for (Plano plano : planos) {
			cache.put(new Element(plano.getNomePlano(), plano));
		}
		
		Element element = cache.get("IPT");
		Plano p = (Plano) element.getValue();
		
		System.out.println(p.getNomePlano());
		manager.shutdown();
		
	}

	final static List<Plano> readFile(String caminho) throws IOException {
		String registro = "";
		String separadorCVS = ";";
		List<Plano> planos = new ArrayList<Plano>();
		
		BufferedReader br = new BufferedReader(new FileReader(caminho));
		while ((registro = br.readLine()) != null) {
			String[] p = registro.split(separadorCVS);
			
			if (p.length == 3) {
				Plano plano = new Plano(p[0], p[1], p[2]);
				planos.add(plano);
			} else {
				Plano plano = new Plano(p[0], p[1], null);
				planos.add(plano);				
			}
		}
		return planos;
	}
}
