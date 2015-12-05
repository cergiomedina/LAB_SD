package laboratorio_1_sd;


public class FrontService {

    static String[] queries = {"query 1", "query 2", "query 3", "query 4", "query 5", "query 6", "query 7", "query 8", "query 9", "query 10", "query 11", "query 12", "query 13", "query 14", "query 15", "query 16", "query 17", "query 18", "query 19", "query 20"};
    static String answers[] = {"answer 1", "answer 2", "answer 3", "answer 4", "answer 5", "answer 6", "answer 7", "answer 8", "answer 9", "answer 10", "answer 11", "answer 12", "answer 13", "answer 14", "answer 15", "answer 16", "answer 17", "answer 18", "answer 19", "answer 20"};

    public static String getEntry(String query) {
        for (int i = 0; i < queries.length; i++) {
            if (queries[i].equals(query)) {
                return answers[i];
            }
        }
        return null;
    }
}
