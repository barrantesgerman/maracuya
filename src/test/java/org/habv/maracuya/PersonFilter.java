package org.habv.maracuya;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.habv.maracuya.FilterFactory.*;

/**
 *
 * @author Herman Barrantes
 */
public class PersonFilter implements Filterable {

    private String name;
    private Integer age;
    private LocalDate start;
    private LocalDate end;
    private List<String> hobbies;

    @Override
    public String select() {
        return "SELECT p ";
    }

    @Override
    public String from() {
        return "FROM Person p";
    }

    @Override
    public Filter filter() {
        return and(
                like("p.name", "name", name),
                or(
                        greater("p.age", "age", age),
                        between("p.date", "start", "end", start, end)),
                                in("p.hobbies", "hobbies", hobbies));
//        return and();
    }

    @Override
    public Optional<String> orderBy() {
        return Optional.of(" ORDER BY p.name ASC");
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    public LocalDate getStart() {
        return start;
    }

    /**
     *
     * @param start
     */
    public void setStart(LocalDate start) {
        this.start = start;
    }

    /**
     *
     * @return
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     *
     * @param end
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    /**
     *
     * @return
     */
    public List<String> getHobbies() {
        return hobbies;
    }

    /**
     *
     * @param hobbies
     */
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

}
