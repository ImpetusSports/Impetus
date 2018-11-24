/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.database;


import com.impetussports.utils.PackageContents;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Michael Orner
 */
public class DBConnect {

    final String hibernateConfigurationFile = "com/impetussports/database/hibernate.cfg.xml";
    final String annotatedClassesPackage = "com.impetussports.dbobjects";
    
    private static ArrayList<Class> annotatedClasses;
    private static AnnotationConfiguration config;
    private static Session session;
    private static SessionFactory dbFactory;

    public DBConnect()  {
        config = new AnnotationConfiguration();
        addAnnotatedClasses();
        config.configure(hibernateConfigurationFile);
  //      new SchemaExport(config).create(true , true);
        dbFactory = config.buildSessionFactory();
        session = dbFactory.getCurrentSession();
    }

    private void addAnnotatedClasses() {
        try {
            annotatedClasses = PackageContents.getPackageClasses(annotatedClassesPackage);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error1");
        } catch (IOException ex) {
            System.out.println("Error2");
        } catch (URISyntaxException ex) {
            System.out.println("Error3");
        }
        for (Class annotadedClass : annotatedClasses) {
            config.addAnnotatedClass(annotadedClass);
            System.out.println(annotadedClass.toString());
        }

    }

    public static AnnotationConfiguration getConfig() {
        return config;
    }

    public static Session getSession() {
        return session;
    }

    public static SessionFactory getDbFactory() {
        return dbFactory;
    } 

}
