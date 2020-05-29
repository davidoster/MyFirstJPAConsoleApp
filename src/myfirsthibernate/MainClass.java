/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirsthibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import myfirsthibernate.entities.User;

/**
 *
 * @author mac
 */
public class MainClass {
    //@PersistenceUnit
    private static EntityManagerFactory emf;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        emf = Persistence.createEntityManagerFactory("CB10PTJAVAHibernatePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<User> users = (List<User>)em.createQuery("select u from User u").getResultList();
        System.out.println("Users");
        for (User user : users) {
            System.out.println("User :" + user);
        }
        em.getTransaction().commit();
    }
}
