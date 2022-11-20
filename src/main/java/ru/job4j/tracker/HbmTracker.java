package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private static final String ADD_HQL = "INSERT INTO items (name, created) "
            + "VALUES (:fName, :fCreated)";
    private static final String REPLACE_HQL = "UPDATE Item as i SET i.name = :fName, "
            + "i.created = :fCreated  WHERE i.id = :fId";

    private static final String DELETE_HQL = "DELETE Item where id = :fId";
    private static final String FIND_ALL_HQL = "from Item";
    private static final String FIND_BY_NAME = "from Item as i where i.name = :fName";
    private static final String FIND_BY_ID = "from Item as i where i.id = :fId";
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createNativeQuery(
                            ADD_HQL)
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createNativeQuery(
                            REPLACE_HQL)
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fCreated", item.getCreated())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createNativeQuery(
                            DELETE_HQL)
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return true;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        Session session = sf.openSession();
        List<?> list = session.createQuery(FIND_ALL_HQL).list();
        for (Object o : list) {
            Item item = (Item) o;
            items.add(item);
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        Session session = sf.openSession();
        Query<Item> query = session.createQuery(
                FIND_BY_NAME, Item.class);
        List<?> list = query.setParameter("fName", key).list();
        for (Object o : list) {
            Item item = (Item) o;
            items.add(item);
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery(
                FIND_BY_ID, Item.class);
        return query.uniqueResult();
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
