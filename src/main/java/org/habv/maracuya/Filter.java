package org.habv.maracuya;

import java.util.Map;

/**
 * Filter that could be concatenated to the query.
 *
 * @author Herman Barrantes
 * @since 1.0.0
 */
@FunctionalInterface
public interface Filter {

    /**
     * Verify that the filter can be applied.
     *
     * @return returns true when it can be applied, false otherwise.
     */
    default boolean canApply() {
        return true;
    }

    /**
     * Concatenates the filter in the query and stores the parameter values.
     *
     * @param query query
     * @param parameters parameter values
     */
    void apply(StringBuilder query, Map<String, Object> parameters);
}
