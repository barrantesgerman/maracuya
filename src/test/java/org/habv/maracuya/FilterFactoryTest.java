package org.habv.maracuya;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test FilterFactory.
 *
 * @author Herman Barrantes
 * @since 1.0.0
 */
public class FilterFactoryTest {

    /**
     * Test of equal method, of class FilterFactory.
     */
    @Test
    public void testEqual() {
        System.out.println("equal");
        String columnName = "book.isbn";
        String paramName = "isbn";
        String value = "978-3-16-148410-0";
        Filter filter = FilterFactory.equal(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.isbn = :isbn");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of notEqual method, of class FilterFactory.
     */
    @Test
    public void testNotEqual() {
        System.out.println("notEqual");
        String columnName = "book.isbn";
        String paramName = "isbn";
        String value = "978-3-16-148410-0";
        Filter filter = FilterFactory.notEqual(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.isbn <> :isbn");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of greater method, of class FilterFactory.
     */
    @Test
    public void testGreater() {
        System.out.println("greater");
        String columnName = "book.price";
        String paramName = "price";
        Double value = 9.99;
        Filter filter = FilterFactory.greater(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.price > :price");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of greaterOrEqual method, of class FilterFactory.
     */
    @Test
    public void testGreaterOrEqual() {
        System.out.println("greaterOrEqual");
        String columnName = "book.price";
        String paramName = "price";
        Double value = 9.99;
        Filter filter = FilterFactory.greaterOrEqual(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.price >= :price");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of less method, of class FilterFactory.
     */
    @Test
    public void testLess() {
        System.out.println("less");
        String columnName = "book.price";
        String paramName = "price";
        Double value = 9.99;
        Filter filter = FilterFactory.less(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.price < :price");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of lessOrEqual method, of class FilterFactory.
     */
    @Test
    public void testLessOrEqual() {
        System.out.println("lessOrEqual");
        String columnName = "book.price";
        String paramName = "price";
        Double value = 9.99;
        Filter filter = FilterFactory.lessOrEqual(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.price <= :price");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of like method, of class FilterFactory.
     */
    @Test
    public void testLike() {
        System.out.println("like");
        String columnName = "book.title";
        String paramName = "title";
        String value = "Dracula";
        Filter filter = FilterFactory.like(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "LOWER(book.title) LIKE :title");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), "%" + value.toLowerCase() + "%");
    }

    /**
     * Test of likeCaseSensitive method, of class FilterFactory.
     */
    @Test
    public void testLikeCaseSensitive() {
        System.out.println("likeCaseSensitive");
        String columnName = "book.title";
        String paramName = "title";
        String value = "Dracula";
        Filter filter = FilterFactory.likeCaseSensitive(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.title LIKE :title");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), "%" + value + "%");
    }

    /**
     * Test of notLike method, of class FilterFactory.
     */
    @Test
    public void testNotLike() {
        System.out.println("notLike");
        String columnName = "book.title";
        String paramName = "title";
        String value = "Dracula";
        Filter filter = FilterFactory.notLike(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "LOWER(book.title) NOT LIKE :title");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), "%" + value.toLowerCase() + "%");
    }

    /**
     * Test of notLikeCaseSensitive method, of class FilterFactory.
     */
    @Test
    public void testNotLikeCaseSensitive() {
        System.out.println("notLikeCaseSensitive");
        String columnName = "book.title";
        String paramName = "title";
        String value = "Dracula";
        Filter filter = FilterFactory.notLikeCaseSensitive(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.title NOT LIKE :title");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), "%" + value + "%");
    }

    /**
     * Test of startsWith method, of class FilterFactory.
     */
    @Test
    public void testStartsWith() {
        System.out.println("startsWith");
        String columnName = "book.title";
        String paramName = "title";
        String value = "Dracula";
        Filter filter = FilterFactory.startsWith(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "LOWER(book.title) LIKE :title");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value.toLowerCase() + "%");
    }

    /**
     * Test of startsWithCaseSensitive method, of class FilterFactory.
     */
    @Test
    public void testStartsWithCaseSensitive() {
        System.out.println("startsWithCaseSensitive");
        String columnName = "book.title";
        String paramName = "title";
        String value = "Dracula";
        Filter filter = FilterFactory.startsWithCaseSensitive(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.title LIKE :title");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value + "%");
    }

    /**
     * Test of endsWith method, of class FilterFactory.
     */
    @Test
    public void testEndsWith() {
        System.out.println("endsWith");
        String columnName = "book.title";
        String paramName = "title";
        String value = "Dracula";
        Filter filter = FilterFactory.endsWith(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "LOWER(book.title) LIKE :title");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), "%" + value.toLowerCase());
    }

    /**
     * Test of endsWithCaseSensitive method, of class FilterFactory.
     */
    @Test
    public void testEndsWithCaseSensitive() {
        System.out.println("endsWithCaseSensitive");
        String columnName = "book.title";
        String paramName = "title";
        String value = "Dracula";
        Filter filter = FilterFactory.endsWithCaseSensitive(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.title LIKE :title");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), "%" + value);
    }

    /**
     * Test of in method, of class FilterFactory.
     */
    @Test
    public void testIn() {
        System.out.println("in");
        String columnName = "book.category";
        String paramName = "categories";
        List<String> value = new ArrayList<>();
        value.add("Action");
        value.add("Comedy");
        value.add("Horror");
        Filter filter = FilterFactory.in(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.category IN :categories");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of notIn method, of class FilterFactory.
     */
    @Test
    public void testNotIn() {
        System.out.println("notIn");
        String columnName = "book.category";
        String paramName = "categories";
        List<String> value = new ArrayList<>();
        value.add("Action");
        value.add("Comedy");
        value.add("Horror");
        Filter filter = FilterFactory.notIn(columnName, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.category NOT IN :categories");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of isNull method, of class FilterFactory.
     */
    @Test
    public void testIsNull() {
        System.out.println("isNull");
        String columnName = "book.authorId";
        boolean apply = true;
        Filter filter = FilterFactory.isNull(columnName, apply);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.authorId IS NULL ");
        assertTrue(params.isEmpty());
    }

    /**
     * Test of isNotNull method, of class FilterFactory.
     */
    @Test
    public void testIsNotNull() {
        System.out.println("isNotNull");
        String columnName = "book.authorId";
        boolean apply = true;
        Filter filter = FilterFactory.isNotNull(columnName, apply);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.authorId IS NOT NULL ");
        assertTrue(params.isEmpty());
    }

    /**
     * Test of between method, of class FilterFactory.
     */
    @Test
    public void testBetween() {
        System.out.println("between");
        String columnName = "book.published";
        String leftParamName = "start";
        String rightParamName = "end";
        Integer leftValue = 1980;
        Integer rightValue = 2020;
        Filter filter = FilterFactory.between(columnName, leftParamName, rightParamName, leftValue, rightValue);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.published BETWEEN :start AND :end");
        assertTrue(params.containsKey(leftParamName));
        assertEquals(params.get(leftParamName), leftValue);
        assertTrue(params.containsKey(rightParamName));
        assertEquals(params.get(rightParamName), rightValue);
    }

    /**
     * Test of notBetween method, of class FilterFactory.
     */
    @Test
    public void testNotBetween() {
        System.out.println("notBetween");
        String columnName = "book.published";
        String leftParamName = "start";
        String rightParamName = "end";
        Integer leftValue = 1980;
        Integer rightValue = 2020;
        Filter filter = FilterFactory.notBetween(columnName, leftParamName, rightParamName, leftValue, rightValue);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "book.published NOT BETWEEN :start AND :end");
        assertTrue(params.containsKey(leftParamName));
        assertEquals(params.get(leftParamName), leftValue);
        assertTrue(params.containsKey(rightParamName));
        assertEquals(params.get(rightParamName), rightValue);
    }

    /**
     * Test of and method, of class FilterFactory.
     */
    @org.testng.annotations.Test
    public void testAnd_FilterArr() {
        System.out.println("and");
        Filter[] filters = {
            FilterFactory.literal("first", "first", true),
            FilterFactory.none(),
            FilterFactory.literal("second", "second", true),
            FilterFactory.literal("third", "third", true)
        };
        Filter filter = FilterFactory.and(filters);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "first AND second AND third");
        assertTrue(params.containsKey("first"));
        assertEquals(params.get("first"), true);
        assertTrue(params.containsKey("second"));
        assertEquals(params.get("second"), true);
        assertTrue(params.containsKey("third"));
        assertEquals(params.get("third"), true);

    }

    /**
     * Test of and method, of class FilterFactory.
     */
    @org.testng.annotations.Test
    public void testAnd_Collection() {
        System.out.println("and");
        List<Filter> filters = new ArrayList<>();
        filters.add(FilterFactory.literal("first", "first", true));
        filters.add(FilterFactory.none());
        filters.add(FilterFactory.literal("second", "second", true));
        filters.add(FilterFactory.literal("third", "third", true));
        Filter filter = FilterFactory.and(filters);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "first AND second AND third");
        assertTrue(params.containsKey("first"));
        assertEquals(params.get("first"), true);
        assertTrue(params.containsKey("second"));
        assertEquals(params.get("second"), true);
        assertTrue(params.containsKey("third"));
        assertEquals(params.get("third"), true);
    }

    /**
     * Test of or method, of class FilterFactory.
     */
    @org.testng.annotations.Test
    public void testOr_FilterArr() {
        System.out.println("or");
        Filter[] filters = {
            FilterFactory.literal("first", "first", true),
            FilterFactory.none(),
            FilterFactory.literal("second", "second", true),
            FilterFactory.literal("third", "third", true)
        };
        Filter filter = FilterFactory.or(filters);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "first OR second OR third");
        assertTrue(params.containsKey("first"));
        assertEquals(params.get("first"), true);
        assertTrue(params.containsKey("second"));
        assertEquals(params.get("second"), true);
        assertTrue(params.containsKey("third"));
        assertEquals(params.get("third"), true);
    }

    /**
     * Test of or method, of class FilterFactory.
     */
    @org.testng.annotations.Test
    public void testOr_Collection() {
        System.out.println("or");
        List<Filter> filters = new ArrayList<>();
        filters.add(FilterFactory.literal("first", "first", true));
        filters.add(FilterFactory.none());
        filters.add(FilterFactory.literal("second", "second", true));
        filters.add(FilterFactory.literal("third", "third", true));
        Filter filter = FilterFactory.or(filters);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "first OR second OR third");
        assertTrue(params.containsKey("first"));
        assertEquals(params.get("first"), true);
        assertTrue(params.containsKey("second"));
        assertEquals(params.get("second"), true);
        assertTrue(params.containsKey("third"));
        assertEquals(params.get("third"), true);
    }

    /**
     * Test of parameter method, of class FilterFactory.
     */
    @org.testng.annotations.Test
    public void testParameter() {
        System.out.println("parameter");
        String paramName = "isbn";
        String value = "978-3-16-148410-0";
        Filter filter = FilterFactory.parameter(paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "");
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of literal method, of class FilterFactory.
     */
    @org.testng.annotations.Test
    public void testLiteral() {
        System.out.println("literal");
        String literal = "book.isbn = :isbn";
        String paramName = "isbn";
        String value = "978-3-16-148410-0";
        Filter filter = FilterFactory.literal(literal, paramName, value);
        assertNotNull(filter);
        assertTrue(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), literal);
        assertTrue(params.containsKey(paramName));
        assertEquals(params.get(paramName), value);
    }

    /**
     * Test of isNullOrEmpty method, of class FilterFactory.
     */
    @Test
    public void testIsNullOrEmpty() {
        System.out.println("isNullOrEmpty");

        assertTrue(FilterFactory.isNullOrEmpty(null));
        assertTrue(FilterFactory.isNullOrEmpty(""));
        assertTrue(FilterFactory.isNullOrEmpty(Collections.emptyList()));
        assertTrue(FilterFactory.isNullOrEmpty(Collections.emptySet()));
        assertTrue(FilterFactory.isNullOrEmpty(Collections.emptyMap()));

        assertFalse(FilterFactory.isNullOrEmpty(1));
        assertFalse(FilterFactory.isNullOrEmpty("1"));
        assertFalse(FilterFactory.isNullOrEmpty(Collections.singletonList(1)));
        assertFalse(FilterFactory.isNullOrEmpty(Collections.singleton(1)));
        assertFalse(FilterFactory.isNullOrEmpty(Collections.singletonMap("1", 1)));
    }

    /**
     * Test of none method, of class FilterFactory.
     */
    @Test
    public void testNone() {
        System.out.println("none");
        Filter filter = FilterFactory.none();
        assertNotNull(filter);
        assertFalse(filter.canApply());
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        filter.apply(query, params);
        assertEquals(query.toString(), "");
        assertTrue(params.isEmpty());
    }

}
