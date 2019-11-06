package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
/**
 *
 * @author hung
 */
public class DAO {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DAO db = new DAO();
        ArrayList<Question> a = new ArrayList<>();
        a = db.getQuestions();
        for (Question u : a) {
            System.out.println(u.toString());
        }

    }

    public Connection conn = null;

    public DAO() throws ClassNotFoundException, SQLException {
        conn = connect();
    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/QuizData", "root", "1234");
        return conn;
    }

    public ArrayList<Question> getQuestions() {
        ArrayList<Question> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM QuizData.questions limit 3;");
            while (rs.next()) {
                list.add(new Question(rs.getString("questionContent"),
                        rs.getString("answerA"),
                        rs.getString("answerB"),
                        rs.getString("answerC"),
                        rs.getString("answerD"),
                        rs.getString("answerTrue")
                ));
            }
        } catch (Exception e) {
        }

        return list;
    }

    public ArrayList<User> getPlayers() {
        ArrayList<User> listUSer = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM QuizData.players;");
            while (rs.next()) {
                listUSer.add(new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("maxpoint")));
            }
        } catch (Exception e) {
        }
        return listUSer;
    }

    public static ArrayList<User> getListUSer() {
        ArrayList<User> listUSer = new ArrayList<>();
        listUSer.add(new User("hung", "111", 111));
        listUSer.add(new User("dao", "222", 222));
        listUSer.add(new User("va", "333", 333));
        listUSer.add(new User("uoc", "444", 444));
        return listUSer;
    }

    public User getUserInfor(String username) {
        //lay du lieu user co username = username

        return null;
    }

    public static boolean checkUSer(String username, String pass) {
        ArrayList<User> list = getListUSer();
        for (User u : list) {
            if (u.getUsername().equals(username) && u.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

}
