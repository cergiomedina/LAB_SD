package laboratorio_1_sd;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.net.*;
import java.io.*;

public class LRUCache extends Thread {

    static LinkedHashMap<String, String> cache;
    static int size = 20;
    static LinkedHashMap<String,String> cache1;
    static LinkedHashMap<String,String> cache2;
    static LinkedHashMap<String,String> cache3;
    static LinkedHashMap<String,String> cache4;
    static LinkedHashMap<String,String> cache5;
    
    public static void main(String[] args) {
       
        initServer();
      
    }

    private static String busquedaEnCache(String mensajeRecibido) {
        String resultado = null;
        
       switch(mensajeRecibido.charAt(0)){
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                        resultado = getEntryFromCache(cache,mensajeRecibido);
                    break;
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                        resultado = getEntryFromCache(cache1,mensajeRecibido);
                    break;
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                        resultado = getEntryFromCache(cache2,mensajeRecibido);
                    break;
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                        resultado = getEntryFromCache(cache3,mensajeRecibido);
                    break;
                case 'q':
                case 'r':
                case 's':
                case 't':
                        resultado = getEntryFromCache(cache4,mensajeRecibido);
                    break;
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                        resultado = getEntryFromCache(cache5,mensajeRecibido);
                    break;
                    
            }
       return resultado;
    }

    public void run(){
        
            
        
        
    }
    
    public static void initServer (){
        cache = new LinkedHashMap<>();
        cache1 = new LinkedHashMap<>();
        cache2 = new LinkedHashMap<>();
        cache3 = new LinkedHashMap<>();
        cache4 = new LinkedHashMap<>();
        cache5 = new LinkedHashMap<>();
        final int PUERTO=5000;
        ServerSocket sc;
        Socket so;
        //DataOutputStream salida;
        BufferedReader entrada;
        String mensajeRecibido;
        try {
            sc = new ServerSocket(PUERTO);
            so = new Socket();
            
            //COMIENZA A  ESCUCHAR
            boolean bandera = true;
            //while(bandera){ // debe estar siempre escuchando, por eso el ciclo
            System.out.println("Cache esperando pregunta...");
            so = sc.accept(); // SE CONECTA
            entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
           // salida = new DataOutputStream(so.getOutputStream());
            mensajeRecibido = entrada.readLine();
            // RECIBE LA CONSULTA
            System.out.println("CACHE RECIBIO COMO PREGUNTA: "+mensajeRecibido);
            String resultado = null;
            
            resultado = busquedaEnCache(mensajeRecibido); // BUSCO SI ESTA EN LA PARTICION CORRESPONDIENTE EN EL CACHE
            
            // MUESTRO EL RESULTADO DE LA CONSULTA POR PARTE DEL CLIENTE, ACA EN EL SERVIDOR

            System.out.println("EL RESULTADO DE LA BUSQUEDA ES: "+resultado);
           
               // FALTA QUE ENVIE LA RESPUESTA AL CLIENTE Y QUE EL CLIENTE LE GUARDE LA RESPUESTA
               // CORRECTA EN CASO DE QUE NO ESTE AQUI, PASANDO OBVIAMENTE POR EL FRONT SERVICE 
            
            //OutputStream aux = so.getOutputStream();
            //DataOutputStream flujo= new DataOutputStream( aux );
            //flujo.writeUTF(resultado);
            //salida.writeUTF(resultado);
            //}

            sc.close();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        
        
    }

    public static String getEntryFromCache(LinkedHashMap<String,String> cache,String query) {
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
