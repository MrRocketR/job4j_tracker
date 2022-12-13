package ru.job4j.tracker.trackers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private static final String REPLACE_HQL = "UPDATE Item as i SET i.name = :fName, "
            + "i.created = :fCreated  WHERE i.id = :fId";

    private static final String DELETE_HQL = "DELETE from Item where id = :fId";
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
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int res = 0;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            res = session.createQuery(
                            REPLACE_HQL)
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return res == 1;
    }

    @Override
    public boolean delete(int id) {
        int res = 0;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
           res = session.createQuery(
                            DELETE_HQL)
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return res == 1;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> list = session.createQuery(FIND_ALL_HQL, Item.class).list();
        session.close();
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery(
                FIND_BY_NAME, Item.class);
        List<Item> list = query.setParameter("fName", key).list();
        session.close();
        return list;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery(
                FIND_BY_ID, Item.class);
        query.setParameter("fId", id);
        Item item = query.uniqueResult();
        session.close();
        return item;
    }

    @Override
    public void close() throws Exception {
        sf.close();
        StandardServiceRegistryBuilder.destroy(registry);
    }

    public SessionFactory getSf() {
        return sf;
    }

    public void wipeTable() {
        Session session = sf.openSession();
        session.beginTransaction();
        System.out.println("Cleaning tables!");
        session.createNativeQuery("TRUNCATE TABLE Items RESTART IDENTITY");
        session.getTransaction().commit();
        System.out.println("Cleaning done!");
    }
}
