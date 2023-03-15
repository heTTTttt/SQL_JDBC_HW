package SQL_JDBC_HW;

import java.util.List;

public class HomeWork {

    private Integer id;
    private String name;
    private String description;
    private List<Lessons> lessons;

    public HomeWork() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", lessons = " + lessons +
                '}';
    }
}
