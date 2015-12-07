package laboratorio_1_sd;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.net.*;
import java.io.*;

public class LRUCache {

    static LinkedHashMap<String, String> cache;
    static int size = 5;
    
    public static void main(String[] args) {
       
        initServer();
    }
    
    public static void initServer(){
        final int PUERTO=5000;
        ServerSocket sc;
        Socket so;
        String MensajeRecibido;
        DataOutputStream salida;
        BufferedReader entrada;
        String mensajeRecibido;
        try {
            sc = new ServerSocket(PUERTO);
            so = new Socket();
            System.out.println("Cache esperando pregunta...");
            so = sc.accept();
            entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
            salida = new DataOutputStream(so.getOutputStream());
            mensajeRecibido = entrada.readLine();
            salida.writeUTF(mensajeRecibido);
            System.out.println("CACHE RECIBIO COMO PREGUNTA: "+mensajeRecibido);
            sc.close();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        
        
    }

    public String getEntryFromCache(String query) {
        String result = cache.get(query);
        if(result != null) {
            cache.remove(query);
            cache.put(query, result);
        }
        return result;
    }
    
    public void addEntryToCache(String query, String answer) {
        if (cache.containsKey(query)) { // HIT
            // Bring to front
            cache.remove(query);
            cache.put(query, answer);
        } else { // MISS
            if(cache.size() == size) {
                String first_element = cache.entrySet().iterator().next().getKey();
                System.out.println("Removiendo: '" + first_element + "'");
                cache.remove(first_element);
            }
            cache.put(query, answer);
        }
    }

    public void print() {
        System.out.println("===== My LRU Cache =====");
        System.out.println("| " + String.join(" | ", cache.keySet()) + " | ");
        System.out.println("========================");
    }

}
