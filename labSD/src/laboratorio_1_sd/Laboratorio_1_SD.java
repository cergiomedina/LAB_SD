
package laboratorio_1_sd;

public class Laboratorio_1_SD {

    public static void main(String[] args) {
        int total_hits = 0, total_miss = 0;
        LRUCache lru_cache = new LRUCache(5);
        String my_queries[] = {"query 2", "query 6", "query 5", "query 2", "query 3", "query 6", "query 6", "query 12", "query 15", "query 19", "query 10", "query 15"};
        for (int i = 0; i < my_queries.length; i++) {
            System.out.println("Query: '" + my_queries[i] + "'");
            String result = lru_cache.getEntryFromCache(my_queries[i]);
            if (result == null) { // MISS
                System.out.println("MISS :(");
                total_miss++;
                result = FrontService.getEntry(my_queries[i]);
                lru_cache.addEntryToCache(my_queries[i], result);
            }else{
                System.out.println("HIT !");
                total_hits++;
            }
            lru_cache.print();
            System.out.println("");
        }
        lru_cache.print();
        System.out.println("");
        int total = total_hits + total_miss;
        float percentage_hits = (100 * total_hits) / total;
        float percentage_miss = (100 * total_miss) / total;
        System.out.println("Total queries: " + total);
        System.out.println("Hits: " + total_hits + " ("+ percentage_hits +"%)");
        System.out.println("Miss: " + total_miss + " ("+ percentage_miss +"%)");
    }
}