package SQL_JDBC_HW;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        LessonDao lessonDao = new LessonDao();

        lessonDao.add(new Lessons("Sport", "Pull up 10 times"));
        lessonDao.add(new Lessons("Math", "Solve 10 tasks"));
        lessonDao.add(new Lessons("Physic", "Blow up 10 bombs"));

        lessonDao.remove(10);

        lessonDao.getAllLessons();

        lessonDao.getLessonViaId(8);
    }
}