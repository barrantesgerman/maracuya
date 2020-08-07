package org.habv.maracuya;

/**
 * Consumer to set the parameters to the query object.
 *
 * @param <Q> Generic type of Query Object
 *
 * @author Herman Barrantes
 * @since 1.0.0
 */
@FunctionalInterface
public interface ParameterSetter<Q> {

    /**
     * Set the parameter to the query object.
     *
     * @param query query object
     * @param name parameter name
     * @param value parameter value
     */
    void set(Q query, String name, Object value);
}
