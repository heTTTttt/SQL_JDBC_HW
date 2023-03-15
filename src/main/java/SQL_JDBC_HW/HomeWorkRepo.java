package SQL_JDBC_HW;

import java.sql.SQLException;

public interface HomeWorkRepo {
    HomeWork find(Integer id);
    HomeWork findByName(String name);
    HomeWork findByDescription(String description);
    HomeWork findWithLesson(Integer id);
    void create(HomeWork hm) throws SQLException;
}
