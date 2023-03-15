package SQL_JDBC_HW;

public class Lessons {
    private Integer lessonId;
    private String name;
    private String homeWork;

    public Lessons(String name, String homework) {
        this.name = name;
        this.homeWork = homework;
    }

    public Lessons(Integer lessonId, String name, String homeWork) {
        this.lessonId = lessonId;
        this.name = name;
        this.homeWork = homeWork;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    @Override
    public String toString() {
        return "Lesson \n" +
                "lessonId = " + lessonId +
                "\n" +
                "name = " + name +
                '\n' +
                "homework = " + homeWork +
                '\n';
    }
}
