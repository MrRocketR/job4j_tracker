package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;

public class SqlTracker implements Store, AutoCloseable {

    private List<Item> items = new ArrayList<>();
    private int ids = 1;
    private Connection cn;

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
        try (PreparedStatement pS = cn.prepareStatement(
                "INSERT INTO tracker (name, created_date) "
                        + "values (?,?)"
        )) {
            pS.setString(1, strSQL);
            pS.setTimestamp(2, timestampSQL);
            pS.execute();
        } catch (SQLException SQLEx) {
            SQLEx.printStackTrace();
        }
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if ((items.get(i).getId() == id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        String strSQL = item.getName();
        Timestamp timestampSQL = Timestamp.valueOf(item.getCurrentDateTime());
        try (PreparedStatement pS = cn.prepareStatement(
                "UPDATE tracker SET name = (?),  created_date = (?) "
                        + "WHERE id = (?)"
        )) {
            pS.setString(1, strSQL);
            pS.setTimestamp(2, timestampSQL);
            pS.setInt(3, id);
            pS.execute();
            result = true;
        } catch (SQLException SQLEx) {
            SQLEx.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement pS = cn.prepareStatement(
                "DELETE from tracker "
                        + "where id = (?);"
        )) {
            pS.setInt(3, id);
            pS.execute();
            result = true;
        } catch (SQLException SQLEx) {
            SQLEx.printStackTrace();
        }
        return result;

    }

    @Override
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    @Override
    public List<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item temp: items) {
            if (key.equals(temp.getName())) {
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public static void main(String[] args) throws Exception {
       SqlTracker sqlTracker = new SqlTracker();
       sqlTracker.init();
       sqlTracker.close();

    }
}
