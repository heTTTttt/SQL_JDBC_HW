package SQL_JDBC_HW;

import java.sql.SQLException;
import java.util.List;

public interface LessonsRepo {
    void add(Lessons lessons) throws SQLException;
    void remove(int id);
    List<Lessons> getAllLessons() throws SQLException;
    List<Lessons> getLessonViaId(int id) throws SQLException;
}
