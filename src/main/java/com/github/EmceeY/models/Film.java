package com.github.EmceeY.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * Created by User on 4/18/17.
 */
@Entity
public class Film {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String mpaaRating;

    @NotNull
    private String length;

    private int receptionCritical;

    private int receptionAudience;

    private String genre;

    private ArrayList<String> keywords;

    private int yearMade;

    private int availableDate;

    private ArrayList<String> cast;

    public Film(String name, String mpaaRating, String length, int receptionCritical, int receptionAudience,
                String genre, ArrayList<String> keywords, int yearMade, int availableDate, ArrayList<String> cast){

        this.name = name;
        this.mpaaRating = mpaaRating;
        this.length = length;
        this.receptionCritical = receptionCritical;
        this.receptionAudience = receptionAudience;
        this.genre = genre;
        this.keywords = keywords;
        this.yearMade = yearMade;
        this.availableDate = availableDate;
        this.cast = cast;

    }

    public Film(){ }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getReceptionCritical() {
        return receptionCritical;
    }

    public void setReceptionCritical(int receptionCritical) {
        this.receptionCritical = receptionCritical;
    }

    public int getReceptionAudience() {
        return receptionAudience;
    }

    public void setReceptionAudience(int receptionAudience) {
        this.receptionAudience = receptionAudience;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public int getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(int availableDate) {
        this.availableDate = availableDate;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }
}
