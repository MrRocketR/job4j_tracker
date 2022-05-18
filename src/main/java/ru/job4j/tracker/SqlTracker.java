package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;


import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

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
        String sql = "INSERT INTO items (name, created) "
                + "values (?,?)";
        try (PreparedStatement pS = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pS.setString(1, strSQL);
            pS.setTimestamp(2, timestampSQL);
            pS.execute();
            ResultSet generatedKeys = pS.getGeneratedKeys();
                if (generatedKeys.next()) {
                        item.setId(generatedKeys.getInt(1));
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
        String sql = "UPDATE items SET name = (?),  created = (?) "
                + "WHERE id =  (?)";
        try (PreparedStatement pS = cn.prepareStatement(sql)) {
            pS.setString(1, strSQL);
            pS.setTimestamp(2, timestampSQL);
            pS.setInt(3, id);
            result = pS.executeUpdate() > 0;
        } catch (SQLException SQLEx) {
            SQLEx.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String sql = "DELETE from items "
                + "where id = (?)";
        try (PreparedStatement pS = cn.prepareStatement(sql)) {
            pS.setInt(1, id);
            result = pS.executeUpdate() > 0;
        } catch (SQLException SQLEx) {
            SQLEx.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String sql = "select * from items";
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(getFromDB(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key)  {
        List<Item> items = new ArrayList<>();
        String sql = "select * from items where name = (?)";
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(getFromDB(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item newItem = null;
        String sql = "select * from items where id = (?)";
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    newItem = getFromDB(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newItem;
    }

    private Item getFromDB(ResultSet set) throws SQLException {
        return new Item(
                set.getInt("id"),
                set.getString("name"),
                set.getTimestamp("created").toLocalDateTime()
        );
    }

    public static void main(String[] args) throws Exception {
       SqlTracker sqlTracker = new SqlTracker();
       sqlTracker.init();
       sqlTracker.close();
    }
}

