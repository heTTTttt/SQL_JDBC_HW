package SQL_JDBC_HW;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonsDao implements LessonsRepo {
    public LessonsDao() throws SQLException {
    }

    @Override
    public void add(Lessons lesson) throws SQLException {

        DataBaseConnection dbc = new DataBaseConnection();

        // Встановлення з'єднання з БД
        Connection connection = dbc.getConnection();


        // Підготовка SQL запиту з плейсхолдерами
        String sql = "INSERT INTO lessons (name, homework) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Передача значень параметрів через плейсхолдери
        statement.setString(1, lesson.getName());
        statement.setString(2, lesson.getHomeWork());

        // Виконання запиту на додавання
        statement.executeUpdate();

        // Закриття з'єднання з БД
        dbc.close(connection);

    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM lessons WHERE lesson_id = ?";
        DataBaseConnection dbc = new DataBaseConnection();

        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            // тут ми змінюємо знак питання в рядку slq на id, який ми вказуємо у параметрах методу.
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Lessons> getAllLessons() throws SQLException {
        List<Lessons> lessons = new ArrayList<>();

        DataBaseConnection dbc = new DataBaseConnection();
        // Встановлення з'єднання з БД
        Connection connection = dbc.getConnection();
        // створюємо запит на отримання всіх уроків
        String query = "SELECT * FROM lessons";
        // створюємо об'єкт Statement для виконання запиту
        Statement statement = connection.createStatement();
        // виконуємо запит та отримуємо результат
        ResultSet resultSet = statement.executeQuery(query);
        // проходимо по всіх результатах та створюємо об'єкти Lesson
        while (resultSet.next()) {
            Integer id = resultSet.getInt("lesson_id");
            String name = resultSet.getString("name");
            String homework = resultSet.getString("homework");

            Lessons lesson = new Lessons(id, name, homework);
            lessons.add(lesson);
            System.out.println("Lesson with id: " + id + ", name: " + name + " and homework: \n" + homework);
            System.out.println();
        }
        return lessons.stream().toList();
    }

    @Override
    public List<Lessons> getLessonViaId(int id) throws SQLException {
        List<Lessons> lessons = new ArrayList<>();
        String sql = "SELECT * FROM lessons WHERE lesson_id = ?";

        DataBaseConnection dbc = new DataBaseConnection();

        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            // тут ми змінюємо знак питання в рядку slq на id, який ми вказуємо у параметрах методу.
            ps.setInt(1, id);

            // з цього моменту ми робимо все те, що і робили у методі getAllLessons().
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Integer lessonId = resultSet.getInt("lesson_id");
                String name = resultSet.getString("name");
                String homework = resultSet.getString("homework");
                Lessons lesson = new Lessons(lessonId, name, homework);
                lessons.add(lesson);
                System.out.println("Object " + lessons.get(lessons.size() - 1) + " added");
            }
            // якщо список був пустий, то повертаємо null.
            if (lessons.isEmpty()) {
                return null;
            } else {
                return lessons;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}