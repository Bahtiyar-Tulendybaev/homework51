package com.example.homework51;

import com.example.homework51.dao.CommentDao;
import com.example.homework51.dao.LikeDao;
import com.example.homework51.dao.UsersDao;
import com.example.homework51.entity.Comment;
import com.example.homework51.entity.Like;
import com.example.homework51.entity.User;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Service
public class Hw51Service {
    private Connection conn;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private LikeDao likeDao;
    @Autowired
    private CommentDao commentDao;

    public Hw51Service(UsersDao usersDao, CommentDao commentDao, LikeDao likeDao) {
        this.usersDao = usersDao;
        this.commentDao = commentDao;
        this.likeDao = likeDao;
    }
    private Connection getNewConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/postgres?user=postgres&password=qwerty";
        return DriverManager.getConnection(url);
    }

    public String getDataSourceConn() {
        DataSource dataSource = getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1)) {
                return "All ok!";
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private DataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setUsername("postgres");
        config.setPassword("qwerty");
        config.setJdbcUrl("jdbc:postgresql://localhost/postgres?user=postgres&password=qwerty");
        return new HikariDataSource(config);
    }
    public String connect() {
        try {
            init();
            return "Connection successful";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private void init() throws SQLException {
        conn = getNewConnection();
    }
    private int executeUpdate(String query) throws SQLException {
        init();
        Statement statement = conn.createStatement();
        int result = statement.executeUpdate(query);
        return result;
    }
    private void createUserTable()throws SQLException{
        String customerTableQuery ="CREATE TABLE users " +
                "(id INTEGER PRIMARY KEY, name TEXT, login TEXT, email TEXT, password TEXT)";
        String customerEntryQuery = "INSERT INTO users " +
                "VALUES (77, 'James', 'james' , 'james@mail.ru', 'james123')";
        executeUpdate(customerTableQuery);
        executeUpdate(customerEntryQuery);
    }
    private void createCommentTable()throws SQLException{
        String commentTableQuery ="CREATE TABLE comments " +
                "(id INTEGER PRIMARY KEY,  text TEXT)";
        String commentEntryQuery = "INSERT INTO comments " +
                "VALUES (15, 'some comment')";
        executeUpdate(commentTableQuery);
        executeUpdate(commentEntryQuery);
    }
    private void createLikeTable()throws SQLException{
        String likeTableQuery ="CREATE TABLE likes " +
                "(id INTEGER PRIMARY KEY)";
        String likeEntryQuery = "INSERT INTO likes " +
                "VALUES (17)";
        executeUpdate(likeTableQuery);
        executeUpdate(likeEntryQuery);
    }
    public String shouldCreateTable(){
        try{
            createUserTable();
            conn.createStatement().execute("select * from users");
            return "All it is OK!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public String shouldCreateCommentTable(){
        try{
            createCommentTable();
            conn.createStatement().execute("select * from comments");
            return "All it is OK!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public String shouldCreateLikeTable(){
        try{
            createLikeTable();
            conn.createStatement().execute("select * from likes");
            return "All it is OK!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public String shouldSelectData() {
        try {

            String query = "select * from users where name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "James");
            if (ps.execute()) {
                ResultSet resultSet = ps.getResultSet();
                resultSet.next();
                String email = resultSet.getString("email");
                return String.format("Email %s", email);
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public List<User> getUsers(){
        return usersDao.getUsers();
    }
public List<User>userGetName(){
        return usersDao.userGetName();
}
    public List<Comment> getComments(){
        return commentDao.getComments();
    }
    public List<Like>getLikes(){
        return likeDao.getLikes();
    }
    }
