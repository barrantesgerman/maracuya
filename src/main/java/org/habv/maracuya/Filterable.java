package org.habv.maracuya;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Indicates that the class can be filtered.
 *
 * @author Herman Barrantes
 * @since 1.0.0
 */
public interface Filterable {

    /**
     * Select statement.
     *
     * @return select statement.
     */
    String select();

    /**
     * From statement.
     *
     * @return from statement
     */
    String from();

    /**
     * Applicable filter.
     *
     * @return applicable filter.
     */
    Filter filter();

    /**
     * Where statement.
     *
     * @return where statement
     */
    default String where() {
        return " WHERE ";
    }

    /**
     * Group by statement.
     *
     * @return group by statement.
     */
    default Optional<String> groupBy() {
        return Optional.empty();
    }

    /**
     * Having statement.
     *
     * @return having statement.
     */
    default Optional<String> having() {
        return Optional.empty();
    }

    /**
     * Order by statement.
     *
     * @return order by statement.
     */
    default Optional<String> orderBy() {
        return Optional.empty();
    }

    /**
     * Concatenate the declarations and apply the filters on the query object.
     *
     * @param <Q> generic type of Query Object
     * @param qfi query factory
     * @param psi parameter setter
     * @return query object create by the query factory with the parameters
     * applied
     */
    default <Q> Q apply(QueryFactory<Q> qfi, ParameterSetter<Q> psi) {
        StringBuilder query = new StringBuilder();
        Map<String, Object> parameters = new HashMap<>();

        query.append(select());
        query.append(from());
        if (filter().canApply()) {
            query.append(where());
            filter().apply(query, parameters);
        }
        groupBy().ifPresent(query::append);
        having().ifPresent(query::append);
        orderBy().ifPresent(query::append);

        Q instance = qfi.create(query.toString());
        parameters.forEach((key, value) -> psi.set(instance, key, value));
        return instance;
    }

}
