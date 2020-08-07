package org.habv.maracuya;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Herman Barrantes
 */
public class QueryObject {

    private final String query;
    private final Map<String, Object> paramenters;

    /**
     *
     * @param query
     */
    public QueryObject(String query) {
        this.query = query;
        this.paramenters = new HashMap<>();
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public QueryObject setParam(String key, Object value) {
        paramenters.put(key, value);
        return this;
    }

    /**
     *
     */
    public void print() {
        System.out.printf("Query: %s%n", query);
        for (Map.Entry<String, Object> param : paramenters.entrySet()) {
            System.out.printf("  --> Key: %s Value: %s Type: %s%n",
                    param.getKey(),
                    param.getValue(),
                    param.getValue().getClass().getSimpleName());
        }
    }

}
