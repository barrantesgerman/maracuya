package org.habv.maracuya;

/**
 * Factory pattern to create query objects.
 *
 * @param <Q> Generic type of Query Object
 *
 * @author Herman Barrantes
 * @since 1.0.0
 */
@FunctionalInterface
public interface QueryFactory<Q> {

    /**
     * Create a query object.
     *
     * @param query query string
     * @return query object
     */
    Q create(String query);
}
