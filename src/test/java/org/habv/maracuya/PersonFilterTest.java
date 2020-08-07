package org.habv.maracuya;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Herman Barrantes
 */
public class PersonFilterTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        PersonFilter pf = new PersonFilter();
        pf.setName("Herman");
        pf.setAge(18);
        pf.setStart(LocalDate.of(2020, 1, 1));
        pf.setEnd(LocalDate.of(2020, 1, 31));
        pf.setHobbies(new ArrayList<>());
        pf.getHobbies().add("Movies");
        pf.getHobbies().add("Games");

        pf.apply(QueryObject::new, QueryObject::setParam).print();
    }

    private static void test2() {
        PersonFilter pf = new PersonFilter();

        pf.apply(QueryObject::new, QueryObject::setParam).print();
    }

    private static void test3() {
        PersonFilter pf = new PersonFilter();
        pf.setName("Herman");
        pf.setStart(LocalDate.of(2020, 1, 1));
        pf.setEnd(LocalDate.of(2020, 1, 31));
        pf.setHobbies(new ArrayList<>());

        pf.apply(QueryObject::new, QueryObject::setParam).print();
    }

    private static void test4() {
        PersonFilter pf = new PersonFilter();
        pf.setName("Herman");
        pf.setHobbies(new ArrayList<>());
        pf.getHobbies().add("Movies");
        pf.getHobbies().add("Games");

        pf.apply(QueryObject::new, QueryObject::setParam).print();
    }
}
