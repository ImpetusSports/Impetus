/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Michael Orner
 */
public class PackageContents {
        final static String THISPACKAGENAME = "com/impetussports/utils";

    public static ArrayList<Class> getPackageClasses(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
        ArrayList<Class> classes = new ArrayList<>();
        ArrayList<String> contentPaths = getPackageContentsPaths(packageName);
        for (String contentPath : contentPaths) {
            if (contentPath.contains(".class")) {
                contentPath = contentPath.replace('/','.');
                classes.add(Class.forName(contentPath.substring(0,contentPath.lastIndexOf("."))));
            }
        }
        return classes;
    }

    public static ArrayList<String> getPackageFXMLPaths(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
        ArrayList<String> fxmls = new ArrayList<>();
        ArrayList<String> contentPaths = getPackageContentsPaths(packageName);
        for (String content : contentPaths) {
            if (content.contains(".fxml")) {
                fxmls.add(content);
//                System.out.println(content);
            }
        }
        return fxmls;
    }

    public static ArrayList<String> getPackageContentsNames(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> classPaths = getPackageContentsPaths(packageName);
        for (String path : classPaths) {
            String entryName = path.substring(path.lastIndexOf('/')+1, path.lastIndexOf('.'));
    //        System.out.println("Package Contents Name: " + entryName);
            names.add(entryName);
        }
        return names;
    }
    
    public static ArrayList<String> getPackageContentsFiles(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> classPaths = getPackageContentsPaths(packageName);
        for (String path : classPaths) {
            String entryName = path.substring(path.lastIndexOf('/'));
    //        System.out.println("Package Contents Files: " + entryName);
            names.add(entryName);
        }
        return names;
    }

    public static ArrayList<String> getPackageContentsPaths(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
        String packagePath = packageName.replace('.', '/');
        ArrayList<String> packagesAndContents = getPackagesAndContents();
        ArrayList<String> packageContentsPaths = new ArrayList<>();
        for (String contentPaths : packagesAndContents) {
            if (contentPaths.startsWith(packagePath) && contentPaths.length() > packagePath.length() + 1) {
                packageContentsPaths.add(contentPaths);
    //            System.out.println("Package Contents Paths: " + contentPaths);
            }
        }
        return packageContentsPaths;
    }

    public static ArrayList<String> getPackagesAndContents() throws IOException {
        ArrayList<String> packagesAndContents = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL packageURL = classLoader.getResource(THISPACKAGENAME);
        if (packageURL.getProtocol().equals("jar")) {
            // build jar file name, then loop through zipped entries
            String jarFileName = URLDecoder.decode(packageURL.getFile(), "UTF-8");
            jarFileName = jarFileName.substring(5, jarFileName.indexOf("!"));
//            System.out.println(">" + jarFileName);
            JarFile jf = new JarFile(jarFileName);
            Enumeration<JarEntry> jarEntries = jf.entries();
            while (jarEntries.hasMoreElements()) {
                JarEntry currentElement = jarEntries.nextElement();
                String entryName = currentElement.getName();
//                System.out.println("Entry Name: " + entryName);
                packagesAndContents.add(entryName);
            }
        } else {
            System.out.println("Error: Package not found");
        }
        return packagesAndContents;
    }

}
