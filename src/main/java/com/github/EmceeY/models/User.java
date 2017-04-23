package com.github.EmceeY.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * Created by User on 4/23/17.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Length(min=3, max=20)
    private String name;

    @NotNull
    @Length(min=3, max=20)
    private String password;

    @NotNull
    @Email
    private String email;

    private ArrayList<String> myList;

    private ArrayList<String> watchedFilms;

    public User (String name, String password, String email, ArrayList<String> myList, ArrayList<String> watchedFilms){
        this.name = name;
        this.password = password;
        this.email = email;
        this.myList = myList;
        this.watchedFilms = watchedFilms;
    }

    public User () { }

    public void addToMyList(String name, ArrayList<String> myList){
        myList.add(name);
    }

    public void watched(String name, ArrayList<String> myList, ArrayList<String> watchedFilms){
        myList.remove(name);
        watchedFilms.add(name);
    }

    public void watched(String name, ArrayList<String> watchedFilms){
        watchedFilms.add(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<String> myList) {
        this.myList = myList;
    }

    public ArrayList<String> getWatchedFilms() {
        return watchedFilms;
    }

    public void setWatchedFilms(ArrayList<String> watchedFilms) {
        this.watchedFilms = watchedFilms;
    }
}
