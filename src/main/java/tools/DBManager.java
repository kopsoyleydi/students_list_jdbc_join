package tools;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/students?useUnicode=true&serverTimezone=UTC","root", ""
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean addItem(Students student){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(""
                    + "INSERT INTO students (id, user, surname, birthdate, city_id)" +
                    "VALUES (NULL, ?, ?, ?, ?)"
            );

            statement.setString(1,student.getUser());
            statement.setString(2,student.getSurname());
            statement.setString(3,student.getBirthdate());
            statement.setLong(4, student.getCity().getId());
            rows = statement.executeUpdate();

            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static Students getStudent(Long id){
            try {
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT st.id, st.user, st.surname,st.birthdate, st.city_id, c.name AS city, c.code\n" +
                                "FROM students as st\n" +
                                "INNER JOIN cities c on st.city_id = c.id\n" +
                                "WHERE st.id = ?"
                );
                statement.setLong(1,id);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    Students students = new Students (
                            resultSet.getLong("id"),
                            resultSet.getString("user"),
                            resultSet.getString("surname"),
                            resultSet.getString("birthdate"),
                            new Cities(resultSet.getLong("city_id"),
                                    resultSet.getString("city"),
                                    resultSet.getString("code"))
                    );
                    return students;
                }
                statement.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
    }
    public static ArrayList<Students> getStudents(){

        ArrayList<Students> students = new ArrayList<>();
        Cities city = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT st.id, st.user, st.surname,st.birthdate, st.city_id, c.name AS city, c.code\n" +
                            "FROM students as st\n" +
                            "INNER JOIN cities c on st.city_id = c.id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String user = resultSet.getString("user");
                String surname = resultSet.getString("surname");
                String birthdate = resultSet.getString("birthdate");
                city = new Cities(
                        resultSet.getLong("city_id"),
                        resultSet.getString("city"),
                        resultSet.getString("code")
                );
                students.add(new Students(id,user,surname,birthdate,city));
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static void UpdateStudent(Students students){
        try{
           PreparedStatement statement = connection.prepareStatement(
                   "UPDATE students SET user = ?, surname = ?, birthdate = ?, city_id = ? WHERE id = ?"
           );
           statement.setString(1,students.getUser());
           statement.setString(2,students.getSurname());
           statement.setString(3,students.getBirthdate());
           statement.setLong(4,students.getCity().getId());
           statement.setLong(5,students.getId());
           statement.executeUpdate();
           statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void DeleteStudents(Long id){
        try{
            PreparedStatement statement = connection.prepareStatement(""
            + "DELETE FROM students WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Cities> getCities(){
        ArrayList<Cities> cities = new ArrayList<>();
        Cities city = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM cities");
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()){
                        Long id = resultSet.getLong("id");
                        String name = resultSet.getString("name");
                        String code = resultSet.getString("code");
                        cities.add(new Cities(id, name,code));
                    }
                    statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cities;
    }

    public static Cities getCity(Long id){
        Cities city = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM cities WHERE id = ?"
            );
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                city = new Cities (
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code")
                );
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return city;
    }
    public static void addCity(Cities cities){
        try {
            PreparedStatement statement = connection.prepareStatement(""
                    + "INSERT INTO cities (id, name, code)" +
                    "VALUES (NULL, ?, ?)"
            );
            statement.setString(1,cities.getName());
            statement.setString(2,cities.getCode());
            statement.executeUpdate();

            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void DeleteCity(Long id){
        try{
            PreparedStatement statement = connection.prepareStatement(""
                    + "DELETE FROM cities WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean UpdateCity(Cities cities){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE cities SET name = ?, code = ?" +
                    "WHERE id = ? "
            );
            statement.setString(1,cities.getName());
            statement.setString(2,cities.getCode());
            statement.setLong(3,cities.getId());

            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
}
