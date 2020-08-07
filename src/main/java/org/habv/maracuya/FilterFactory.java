package org.habv.maracuya;

import java.util.Collection;
import java.util.Map;

/**
 * Factory for the creation of common filters.
 *
 * @author Herman Barrantes
 * @since 1.0.0
 */
public final class FilterFactory {

    /**
     * SQL equals token.
     */
    private static final String EQUALS_TOKEN = " = ";
    /**
     * SQL not equals token.
     */
    private static final String NOT_EQUALS_TOKEN = " <> ";
    /**
     * SQL greater than token.
     */
    private static final String GREATER_TOKEN = " > ";
    /**
     * SQL greater or equals token.
     */
    @SuppressWarnings("PMD.LongVariable")
    private static final String GREATER_OR_EQUAL_TOKEN = " >= ";
    /**
     * SQL less than token.
     */
    private static final String LESS_TOKEN = " < ";
    /**
     * SQL less or equals token.
     */
    @SuppressWarnings("PMD.LongVariable")
    private static final String LESS_OR_EQUAL_TOKEN = " <= ";
    /**
     * SQL like token.
     */
    private static final String LIKE_TOKEN = " LIKE ";
    /**
     * SQL not like token.
     */
    private static final String NOT_LIKE_TOKEN = " NOT LIKE ";
    /**
     * SQL in token.
     */
    private static final String IN_TOKEN = " IN ";
    /**
     * SQL not in token.
     */
    private static final String NOT_IN_TOKEN = " NOT IN ";
    /**
     * SQL is null token.
     */
    private static final String IS_NULL_TOKEN = " IS NULL ";
    /**
     * SQL is not null token.
     */
    private static final String IS_NOT_NULL_TOKEN = " IS NOT NULL ";
    /**
     * SQL between token.
     */
    private static final String BETWEEN_TOKEN = " BETWEEN ";
    /**
     * SQL not between token.
     */
    private static final String NOT_BETWEEN_TOKEN = " NOT BETWEEN ";
    /**
     * SQL named parameter prefix.
     */
    private static final String PREFIX = ":";
    /**
     * SQL and token.
     */
    private static final String AND_TOKEN = " AND ";
    /**
     * SQL or token.
     */
    private static final String OR_TOKEN = " OR ";
    /**
     * SQL lower token.
     */
    private static final String LOWER_TOKEN = "LOWER";
    /**
     * SQL left parenthesis.
     */
    private static final String LEFT_PARENTHESIS = "(";
    /**
     * SQL right parenthesis.
     */
    private static final String RIGHT_PARENTHESIS = ")";
    /**
     * SQL percentage sign.
     */
    private static final String PERCENTAGE_SIGN = "%";
    /**
     * Empty String.
     */
    private static final String EMPTY_STRING = "";

    /**
     * Utility class, do not create instances, instead use static methods.
     */
    private FilterFactory() {
        throw new RuntimeException("do not create instances, instead use static methods");
    }

    /**
     * Create a filter with equals operator.
     * <p>
     * For example: {@code equal("book.isbn","isbn","978-3-16-148410-0")} will
     * generate the following sql: {@code book.isbn = :isbn} and put in the
     * parameters the following key/value:
     * {@code map.put("isbn","978-3-16-148410-0");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with equals operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter equal(String columnName, String paramName, Object value) {
        return isNullOrEmpty(value)
                ? none()
                : single(columnName, EQUALS_TOKEN, paramName, value);
    }

    /**
     * Create a filter with not equals operator.
     * <p>
     * For example: {@code notEqual("book.isbn","isbn","978-3-16-148410-0")}
     * will generate the following sql: {@code book.isbn <> :isbn} and put in
     * the parameters the following key/value:
     * {@code map.put("isbn","978-3-16-148410-0");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with not equals operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter notEqual(String columnName, String paramName, Object value) {
        return isNullOrEmpty(value)
                ? none()
                : single(columnName, NOT_EQUALS_TOKEN, paramName, value);
    }

    /**
     * Create a filter with greater operator.
     * <p>
     * For example: {@code greater("book.price","price",9.99)} will generate the
     * following sql: {@code book.price > :price} and put in the parameters the
     * following key/value: {@code map.put("price",9.99);}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with greater than operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter greater(String columnName, String paramName, Object value) {
        return isNullOrEmpty(value)
                ? none()
                : single(columnName, GREATER_TOKEN, paramName, value);
    }

    /**
     * Create a filter with greater or equal operator.
     * <p>
     * For example: {@code greaterOrEqual("book.price","price",9.99)} will
     * generate the following sql: {@code book.price >= :price} and put in the
     * parameters the following key/value: {@code map.put("price",9.99);}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with greater than or equals operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter greaterOrEqual(String columnName, String paramName, Object value) {
        return isNullOrEmpty(value)
                ? none()
                : single(columnName, GREATER_OR_EQUAL_TOKEN, paramName, value);
    }

    /**
     * Create a filter with less operator.
     * <p>
     * For example: {@code less("book.price","price",9.99)} will generate the
     * following sql: {@code book.price < :price} and put in the parameters the
     * following key/value: {@code map.put("price",9.99);}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with less than operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter less(String columnName, String paramName, Object value) {
        return isNullOrEmpty(value)
                ? none()
                : single(columnName, LESS_TOKEN, paramName, value);
    }

    /**
     * Create a filter with less or equal operator.
     * <p>
     * For example: {@code lessOrEqual("book.price","price",9.99)} will generate
     * the following sql: {@code book.price <= :price} and put in the parameters
     * the following key/value: {@code map.put("price",9.99);}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with less than or equals operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter lessOrEqual(String columnName, String paramName, Object value) {
        return isNullOrEmpty(value)
                ? none()
                : single(columnName, LESS_OR_EQUAL_TOKEN, paramName, value);
    }

    /**
     * Create a filter with like operator.
     * <p>
     * For example: {@code like("book.title","title","Dracula")} will generate
     * the following sql: {@code LOWER(book.title) LIKE :title} and put in the
     * parameters the following key/value: {@code map.put("title","%dracula%");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with like operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter like(String columnName, String paramName, String value) {
        return isNullOrEmpty(value)
                ? none()
                : text(columnName, LIKE_TOKEN, paramName, value, true, true, true);
    }

    /**
     * Create a filter with like operator.
     * <p>
     * For example: {@code likeCaseSensitive("book.title","title","Dracula")}
     * will generate the following sql: {@code book.title LIKE :title} and put
     * in the parameters the following key/value:
     * {@code map.put("title","%Dracula%");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with like operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter likeCaseSensitive(String columnName, String paramName, String value) {
        return isNullOrEmpty(value)
                ? none()
                : text(columnName, LIKE_TOKEN, paramName, value, true, true, false);
    }

    /**
     * Create a filter with not like operator.
     * <p>
     * For example: {@code notLike("book.title","title","Dracula")} will
     * generate the following sql: {@code LOWER(book.title) NOT LIKE :title} and
     * put in the parameters the following key/value:
     * {@code map.put("title","%dracula%");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with not like operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter notLike(String columnName, String paramName, String value) {
        return isNullOrEmpty(value)
                ? none()
                : text(columnName, NOT_LIKE_TOKEN, paramName, value, true, true, true);
    }

    /**
     * Create a filter with not like operator.
     * <p>
     * For example: {@code notLikeCaseSensitive("book.title","title","Dracula")}
     * will generate the following sql: {@code book.title NOT LIKE :title} and
     * put in the parameters the following key/value:
     * {@code map.put("title","%Dracula%");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with not like operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter notLikeCaseSensitive(String columnName, String paramName, String value) {
        return isNullOrEmpty(value)
                ? none()
                : text(columnName, NOT_LIKE_TOKEN, paramName, value, true, true, false);
    }

    /**
     * Create a filter with like operator.
     * <p>
     * For example: {@code startsWith("book.title","title","Dracula")} will
     * generate the following sql: {@code LOWER(book.title) LIKE :title} and put
     * in the parameters the following key/value:
     * {@code map.put("title","dracula%");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with like operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter startsWith(String columnName, String paramName, String value) {
        return isNullOrEmpty(value)
                ? none()
                : text(columnName, LIKE_TOKEN, paramName, value, false, true, true);
    }

    /**
     * Create a filter with like operator.
     * <p>
     * For example:
     * {@code startsWithCaseSensitive("book.title","title","Dracula")} will
     * generate the following sql: {@code book.title LIKE :title} and put in the
     * parameters the following key/value: {@code map.put("title","Dracula%");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with like operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter startsWithCaseSensitive(String columnName, String paramName, String value) {
        return isNullOrEmpty(value)
                ? none()
                : text(columnName, LIKE_TOKEN, paramName, value, false, true, false);
    }

    /**
     * Create a filter with like operator.
     * <p>
     * For example: {@code endsWith("book.title","title","Dracula")} will
     * generate the following sql: {@code LOWER(book.title) LIKE :title} and put
     * in the parameters the following key/value:
     * {@code map.put("title","%dracula");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with like operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter endsWith(String columnName, String paramName, String value) {
        return isNullOrEmpty(value)
                ? none()
                : text(columnName, LIKE_TOKEN, paramName, value, true, false, true);
    }

    /**
     * Create a filter with like operator.
     * <p>
     * For example:
     * {@code endsWithCaseSensitive("book.title","title","Dracula")} will
     * generate the following sql: {@code book.title LIKE :title} and put in the
     * parameters the following key/value: {@code map.put("title","%Dracula");}
     *
     * @param columnName column name
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with like operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static Filter endsWithCaseSensitive(String columnName, String paramName, String value) {
        return isNullOrEmpty(value)
                ? none()
                : text(columnName, LIKE_TOKEN, paramName, value, true, false, false);
    }

    /**
     * Create a filter with in operator.
     * <p>
     * For example: {@code in("book.category","categories",someCollection)} will
     * generate the following sql: {@code book.category IN :categories} and put
     * in the parameters the following key/value:
     * {@code map.put("categories",someCollection);}
     *
     * @param <T> generic type to ensure that the collection is the same type or
     * a subtype
     * @param columnName column name
     * @param paramName parameter name
     * @param values parameter value
     * @return filter with in operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    @SuppressWarnings("PMD.ShortMethodName")
    public static <T> Filter in(String columnName, String paramName, Collection<? extends T> values) {
        return isNullOrEmpty(values)
                ? none()
                : single(columnName, IN_TOKEN, paramName, values);
    }

    /**
     * Create a filter with not in operator.
     * <p>
     * For example: {@code notIn("book.category","categories",someCollection)}
     * will generate the following sql: {@code book.category NOT IN :categories}
     * and put in the parameters the following key/value:
     * {@code map.put("categories",someCollection);}
     *
     * @param <T> generic type to ensure that the collection is the same type or
     * a subtype
     * @param columnName column name
     * @param paramName parameter name
     * @param values parameter value
     * @return filter with not in operator
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    public static <T> Filter notIn(String columnName, String paramName, Collection<? extends T> values) {
        return isNullOrEmpty(values)
                ? none()
                : single(columnName, NOT_IN_TOKEN, paramName, values);
    }

    /**
     * Create a filter with is null operator.
     * <p>
     * For example: {@code isNull("book.authorId","authorId",true)} will
     * generate the following sql: {@code book.authorId IS NULL :authorId} and
     * put in the parameters the following key/value:
     * {@code map.put("authorId",true);}
     *
     * @param columnName column name
     * @param apply indicates whether the filter can be applied
     * @return filter with is null operator
     * @throws NullPointerException if {@code columnName} are {@code null}
     */
    @SuppressWarnings("PMD.LinguisticNaming")
    public static Filter isNull(String columnName, boolean apply) {
        required(columnName, "columnName");
        return apply
                ? (query, parameters) -> query.append(columnName).append(IS_NULL_TOKEN)
                : none();
    }

    /**
     * Create a filter with is not null operator.
     * <p>
     * For example: {@code isNotNull("book.authorId","authorId",true)} will
     * generate the following sql: {@code book.authorId IS NOT NULL :authorId}
     * and put in the parameters the following key/value:
     * {@code map.put("authorId",true);}
     *
     * @param columnName column name
     * @param apply indicates whether the filter can be applied
     * @return filter with is not null operator
     * @throws NullPointerException if {@code columnName} are {@code null}
     */
    @SuppressWarnings("PMD.LinguisticNaming")
    public static Filter isNotNull(String columnName, boolean apply) {
        required(columnName, "columnName");
        return apply
                ? (query, parameters) -> query.append(columnName).append(IS_NOT_NULL_TOKEN)
                : none();
    }

    /**
     * Create a filter with between operator.
     * <p>
     * For example: {@code between("book.published","start","end",1980,2020)}
     * will generate the following sql:
     * {@code book.published BETWEEN :start AND :end} and put in the parameters
     * the following key/value:
     * <pre>{@code map.put("start",1980);
     *map.put("end",2020);}</pre>
     *
     * @param <T> generic type to ensure that the pair is of the same type
     * @param columnName column name
     * @param leftParamName left parameter name
     * @param rightParamName right parameter name
     * @param leftValue left parameter value
     * @param rightValue right parameter value
     * @return filter with between operator
     * @throws NullPointerException if {@code columnName}, {@code leftParamName}
     * or {@code rightParamName} are {@code null}
     */
    public static <T> Filter between(String columnName, String leftParamName, String rightParamName, T leftValue, T rightValue) {
        return isNullOrEmpty(leftValue) || isNullOrEmpty(rightValue)
                ? none()
                : pair(columnName, BETWEEN_TOKEN, leftParamName, rightParamName, leftValue, rightValue);
    }

    /**
     * Create a filter with between operator.
     * <p>
     * For example: {@code notBetween("book.published","start","end",1980,2020)}
     * will generate the following sql:
     * {@code book.published NOT BETWEEN :start AND :end} and put in the
     * parameters the following key/value:
     * <pre>{@code map.put("start",1980);
     *map.put("end",2020);}</pre>
     *
     * @param <T> generic type to ensure that the pair is of the same type
     * @param columnName column name
     * @param leftParamName left parameter name
     * @param rightParamName right parameter name
     * @param leftValue left parameter value
     * @param rightValue right parameter value
     * @return filter with not between operator
     * @throws NullPointerException if {@code columnName}, {@code leftParamName}
     * or {@code rightParamName} are {@code null}
     */
    public static <T> Filter notBetween(String columnName, String leftParamName, String rightParamName, T leftValue, T rightValue) {
        return isNullOrEmpty(leftValue) || isNullOrEmpty(rightValue)
                ? none()
                : pair(columnName, NOT_BETWEEN_TOKEN, leftParamName, rightParamName, leftValue, rightValue);
    }

    /**
     * Filter that joins several filters using the logical operator "and".
     * <p>
     * For example:
     * <pre>{@code and(
     *     equal("book.title","title","Dracula"),
     *     equal("book.category","category","Horror")
     * )}</pre> will generate the following sql:
     * {@code book.title = :title AND book.category = :category}
     *
     * @param filters filters to be joined
     * @return filter that joins several filters using the logical operator
     * "and"
     */
    public static Filter and(Filter... filters) {
        return filters.length == 0
                ? none()
                : new Logical(AND_TOKEN, filters);
    }

    /**
     * Filter that joins several filters using the logical operator "and".
     *
     * @param filters filters to be joined
     * @return filter that joins several filters using the logical operator
     * "and"
     */
    public static Filter and(Collection<? extends Filter> filters) {
        return isNullOrEmpty(filters)
                ? none()
                : new Logical(AND_TOKEN, filters);
    }

    /**
     * Filter that joins several filters using the logical operator "or".
     * <p>
     * For example:
     * <pre>{@code or(
     *     equal("book.title","title","Dracula"),
     *     equal("book.category","category","Horror")
     * )}</pre> will generate the following sql:
     * {@code book.title = :title OR book.category = :category}
     *
     * @param filters filters to be joined
     * @return filter that joins several filters using the logical operator "or"
     */
    @SuppressWarnings("PMD.ShortMethodName")
    public static Filter or(Filter... filters) {
        return filters.length == 0
                ? none()
                : new Logical(OR_TOKEN, filters);
    }

    /**
     * Filter that joins several filters using the logical operator "or".
     *
     * @param filters filters to be joined
     * @return filter that joins several filters using the logical operator "or"
     */
    @SuppressWarnings("PMD.ShortMethodName")
    public static Filter or(Collection<? extends Filter> filters) {
        return isNullOrEmpty(filters)
                ? none()
                : new Logical(OR_TOKEN, filters);
    }

    /**
     * Create a filter that only sets one parameter.
     * <p>
     * For example: {@code parameter("active",true)} put in the parameters the
     * following key/value: {@code map.put("active",true);}
     *
     * @param paramName parameter name
     * @param value parameter value
     * @return filter that only sets one parameter
     * @throws NullPointerException if {@code paramName} is {@code null}
     */
    public static Filter parameter(String paramName, Object value) {
        required(paramName, "paramName");
        return isNullOrEmpty(value)
                ? none()
                : (query, parameters) -> parameters.put(paramName, value);
    }

    /**
     * Create a filter with a specified statement and set the parameter.
     * <p>
     * For example: {@code literal("book.active = :active","active",true)} will
     * generate the following sql: {@code book.active = :active} and put in the
     * parameters the following key/value: {@code map.put("active",true);}
     *
     * @param literal literal query value
     * @param paramName parameter name
     * @param value parameter value
     * @return filter with a specified statement and set the parameter
     */
    public static Filter literal(String literal, String paramName, Object value) {
        required(literal, "literal");
        required(paramName, "paramName");
        return isNullOrEmpty(value)
                ? none()
                : (query, parameters) -> {
                    query.append(literal);
                    parameters.put(paramName, value);
                };
    }

    /**
     * Returns {@code true} if the provided object is {@code null}, or it is an
     * empty {@code CharSequence}, {@code Collection} or {@code Map}, otherwise
     * returns {@code false}.
     *
     * @param value a object to be checked against {@code null} or empty
     * @return {@code true} if the provided object is {@code null}, or it is an
     * empty {@code CharSequence}, {@code Collection} or {@code Map}, otherwise
     * returns {@code false}
     */
    public static boolean isNullOrEmpty(Object value) {
        if (value == null) {
            return true;
        }
        if (value instanceof CharSequence) {
            return ((CharSequence) value).length() == 0;
        }
        if (value instanceof Collection) {
            return ((Collection) value).isEmpty();
        }
        if (value instanceof Map) {
            return ((Map) value).isEmpty();
        }
        return false;
    }

    /**
     * Checks that the specified parameter reference is not {@code null} and not
     * empty and throws a customized {@link NullPointerException} if it is.
     *
     * @param parameter the parameter name to check for nullity
     * @param message detail message to be used in the event that a
     * {@code NullPointerException} is thrown
     */
    private static void required(String parameter, String message) {
        if (parameter == null || parameter.trim().isEmpty()) {
            throw new NullPointerException(String.format("%s must not be null or empty", message));
        }
    }

    /**
     * Filter that does not perform any operation. It does not concatenate
     * anything to the query and does not add any parameters.
     *
     * @return filter that does not perform any operation
     */
    public static Filter none() {
        return new None();
    }

    /**
     * Filter that does not perform any operation. It does not concatenate
     * anything to the query and does not add any parameters.
     *
     * @author Herman Barrantes
     * @since 1.0.0
     */
    private static final class None implements Filter {

        /**
         * Always returns {@code false}.
         *
         * @return always returns {@code false}
         */
        @Override
        public boolean canApply() {
            return false;
        }

        /**
         * Do not perform any operation.
         *
         * @param query query
         * @param parameters parameters
         */
        @Override
        public void apply(StringBuilder query, Map<String, Object> parameters) {
            //Do not perform any operation
        }
    }

    /**
     * Create a filter with a single value.
     *
     * @param columnName column name
     * @param operator operator
     * @param paramName parameter name
     * @param value value
     * @return filter with a single value
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    private static Filter single(String columnName, String operator, String paramName, Object value) {
        required(columnName, "columnName");
        required(paramName, "paramName");
        return (query, parameters) -> {
            query.append(columnName);
            query.append(operator);
            query.append(PREFIX);
            query.append(paramName);
            parameters.put(paramName, value);
        };
    }

    /**
     * Create a filter with a single String value.
     *
     * @param columnName column name
     * @param operator operator
     * @param paramName parameter name
     * @param value value
     * @param left true to concatenate the percent sign at the beginning of the
     * text
     * @param right true to concatenate the percent sign at the end of the text
     * @param ignoreCase true to be case insensitive
     * @return filter with a single String value
     * @throws NullPointerException if {@code columnName} or {@code paramName}
     * are {@code null}
     */
    private static Filter text(String columnName, String operator, String paramName, String value, boolean left, boolean right, boolean ignoreCase) {
        required(columnName, "columnName");
        required(paramName, "paramName");
        return (query, parameters) -> {
            if (ignoreCase) {
                query.append(LOWER_TOKEN);
                query.append(LEFT_PARENTHESIS);
            }
            query.append(columnName);
            if (ignoreCase) {
                query.append(RIGHT_PARENTHESIS);
            }
            query.append(operator);
            query.append(PREFIX);
            query.append(paramName);
            String preparedValue
                    = (left ? PERCENTAGE_SIGN : EMPTY_STRING)
                    + (ignoreCase ? value.toLowerCase() : value)
                    + (right ? PERCENTAGE_SIGN : EMPTY_STRING);
            parameters.put(paramName, preparedValue);
        };
    }

    /**
     * Create a filter with a pair of values.
     *
     * @param columnName column name
     * @param operator operator
     * @param leftParamName left paramenter name
     * @param rightParamName right paramenter name
     * @param leftValue left value
     * @param rightValue tight value
     * @return filter with a pair of values
     * @throws NullPointerException if {@code columnName}, {@code leftParamName}
     * or {@code rightParamName} are {@code null}
     */
    private static Filter pair(String columnName, String operator, String leftParamName, String rightParamName, Object leftValue, Object rightValue) {
        required(columnName, "columnName");
        required(leftParamName, "leftParamName");
        required(rightParamName, "rightParamName");
        return (query, parameters) -> {
            query.append(columnName);
            query.append(operator);
            query.append(PREFIX);
            query.append(leftParamName);
            query.append(AND_TOKEN);
            query.append(PREFIX);
            query.append(rightParamName);
            parameters.put(leftParamName, leftValue);
            parameters.put(rightParamName, rightValue);
        };
    }

    /**
     * Filter that joins multiple filters using a logical operator.
     *
     * @author Herman Barrantes
     * @since 1.0.0
     */
    private static final class Logical implements Filter {

        /**
         * Logical operator.
         */
        private final String operator;
        /**
         * Array of Filters.
         */
        private final Filter[] filters;

        /**
         * Create a filter with multiple filters using a logical operator.
         *
         * @param operator logical operator
         * @param filters array of filters
         */
        private Logical(String operator, Filter... filters) {
            this.operator = operator;
            this.filters = filters;
        }

        /**
         * Create a filter with multiple filters using a logical operator.
         *
         * @param operator logical operator
         * @param filters collection of filters
         */
        private Logical(String operator, Collection<? extends Filter> filters) {
            this.operator = operator;
            this.filters = filters.toArray(new Filter[0]);
        }

        /**
         * Check if at least one of the filters can be applied.
         *
         * @return Returns {@code true} if at least one of the filters can be
         * applied, otherwise returns {@code false}
         */
        @Override
        public boolean canApply() {
            for (Filter filter : filters) {
                if (filter.canApply()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public void apply(StringBuilder query, Map<String, Object> parameters) {
            boolean foundOne = false;
            for (Filter filter : filters) {
                if (filter.canApply()) {
                    if (foundOne) {
                        query.append(operator);
                    }
                    foundOne = true;
                    boolean parenthesis = filter instanceof Logical;
                    if (parenthesis) {
                        query.append(LEFT_PARENTHESIS);
                    }
                    filter.apply(query, parameters);
                    if (parenthesis) {
                        query.append(RIGHT_PARENTHESIS);
                    }
                }
            }
        }

    }

}
