package SQL_JDBC_HW;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        LessonsDao lessonsDao = new LessonsDao();

        lessonsDao.add(new Lessons("Sport", "Pull up 10 times"));
        lessonsDao.add(new Lessons("Math", "Solve 10 tasks"));
        lessonsDao.add(new Lessons("Physic", "Blow up 10 bombs"));

        lessonsDao.remove(10);

        lessonsDao.getAllLessons();

        lessonsDao.getLessonViaId(8);
    }
}