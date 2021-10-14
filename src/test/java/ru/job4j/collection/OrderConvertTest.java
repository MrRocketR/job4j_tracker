package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenIdentical() {
        List<Order> orders = new ArrayList<>();
        Order o1 = new Order("3sfe","T-shirt");
        Order o2 = new Order("3sfe","Dress");
        orders.add(o1);
        orders.add(o2);
        HashMap<String, Order> expect = new HashMap<String, Order> ();
        expect.put("3sfe",o1);
        expect.put("3sfe",o2);
        HashMap<String, Order> map = OrderConvert.process(orders);
        boolean rsl = map.equals(expect);
        assertTrue(rsl);
    }
}