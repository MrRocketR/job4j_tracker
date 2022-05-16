package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;


import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;
    private int ids = 0;

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    public SqlTracker() {
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item)  {

        String strSQL = item.getName();
        Timestamp timestampSQL = Timestamp.valueOf(item.getCurrentDateTime());
        String sql = "INSERT INTO tracker (name, created_date) "
                + "values (?,?)";
        try (PreparedStatement pS = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pS.setString(1, strSQL);
            pS.setTimestamp(2, timestampSQL);
            pS.execute();
            ids++;
            ResultSet generatedKeys = pS.getGeneratedKeys();
                while (generatedKeys.next()) {
                    if (generatedKeys.getInt(1) == ids) {
                        item.setId(generatedKeys.getInt(1));
                    }
                }
        } catch (SQLException SQLEx) {
            SQLEx.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        String strSQL = item.getName();
        Timestamp timestampSQL = Timestamp.valueOf(item.getCurrentDateTime());
        String sql = "UPDATE tracker SET name = (?),  created_date = (?) "
                + "WHERE id = (?)";
        try (PreparedStatement pS = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet generatedKeys = pS.getGeneratedKeys();
            while (generatedKeys.next()) {
                if (generatedKeys.getInt(1) == id) {
                    pS.setString(1, strSQL);
                    pS.setTimestamp(2, timestampSQL);
                    pS.setInt(3, id);
                    result = true;
                }
            }
        } catch (SQLException SQLEx) {
            SQLEx.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String sql = "DELETE from tracker "
                + "where id = (?);";
        try (PreparedStatement pS = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet generatedKeys = pS.getGeneratedKeys();
            while (generatedKeys.next()) {
                if (generatedKeys.getInt(1) == id) {
                    pS.setInt(3, id);
                    pS.execute();
                    result = true;
                    }
                }
        } catch (SQLException SQLEx) {
            SQLEx.printStackTrace();
        }
        return result;

    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String sql = "select * from tracker";
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key)  {
        List<Item> items = new ArrayList<>();
        String sql = "select * from tracker";
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getString("name").equals(key)) {
                        items.add(new Item(
                                resultSet.getInt("id"),
                                resultSet.getString("name")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item returnedItem = new Item(0,  null);
        String sql = "select * from tracker";
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getInt("id") == id) {
                        returnedItem.setId(resultSet.getInt("id"));
                        returnedItem.setName(resultSet.getString("name"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedItem;
    }

    public static void main(String[] args) throws Exception {
       SqlTracker sqlTracker = new SqlTracker();
       sqlTracker.init();
       sqlTracker.close();
    }
}

