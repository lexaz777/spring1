package ru.zakharov.mainapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.zakharov.entities.Client;
import ru.zakharov.entities.Manufacturer;
import ru.zakharov.entities.Product;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Manufacturer.class)
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            //посмотреть какие товары покупал клиент 1
            Client client1 = session.get(Client.class, 1L);
            if (client1 != null)
                System.out.println("Покупки клиента 1 - " + client1.getProducts());

            //посмотреть какие товары покупал клиент 2
            Client client2 = session.get(Client.class, 2L);
            if (client2 != null)
                System.out.println("Покупки клиента 2 - " + client2.getProducts());

            //посмотреть какие товары покупал клиент 3
            Client client3 = session.get(Client.class, 1L);
            if (client3 != null)
                System.out.println("Покупки клиента 3 - " + client3.getProducts());

            //какие клиенты купили определенный товар 1
            Product currentProduct = session.get(Product.class, 1L);
            if (currentProduct != null)
                System.out.println("Список клиентов, купивших 1-й товар:" + currentProduct.getClients());


            //какие клиенты купили определенный товар 2
            if (currentProduct != null) {
                currentProduct = session.get(Product.class, 2L);
                System.out.println("Список клиентов, купивших 2-й товар:" + currentProduct.getClients());
            }
            //удалить товар из БД
            Product product = session.get(Product.class, 1L);
            session.delete(product);

            //удалить покупателя из БД
            Client client = session.get(Client.class, 1L);
            session.delete(client);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
