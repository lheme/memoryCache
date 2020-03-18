package br.com.lheme.cache.impl;

import br.com.lheme.cache.model.Plano;
import br.com.lheme.cache.service.impl.HashMapCache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemoryCacheImpl {

    private static final String PATH = "./file/planos.csv";

    public static void main(String[] args) {

        HashMapCache cache = HashMapCache.getInstance();
        System.out.println("Inicializando o cache maroto");
        System.out.println(cache.getCache().size());
        System.out.println("Leitura do arquivo de carga");
        List<Plano> planos = readFile(PATH);
        cache.cacheItens(planos);
        System.out.println("Cache maroto inicializado");
        cache.getCache().values().forEach(v -> System.out.println(v));
    }

    final static List<Plano> readFile(String caminho)  {
        String registro = "";
        String separadorCVS = ";";
        List<Plano> planos = new ArrayList<Plano>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(caminho));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!((registro = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
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
