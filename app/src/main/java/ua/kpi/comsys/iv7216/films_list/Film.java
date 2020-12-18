package ua.kpi.comsys.iv7216.films_list;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Film implements Cloneable, Serializable {
    private String title;
    private String year;
    private String type;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private String country;
    private String awards;
    private String poster;
    private String rating;
    private String production;
    private String language;

    public Film(String title, String year, String type, String released, String runtime, String genre, String director, String actors, String plot, String country, String awards, String poster, String rating, String production, String language) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.rating = rating;
        this.production = production;
        this.language = language;
    }

    public Film() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @NonNull
    @Override
    protected Film clone() throws CloneNotSupportedException {
        return new Film(this.title,
                this.year,
                this.type,
                this.released,
                this.runtime,
                this.genre,
                this.director,
                this.actors,
                this.plot,
                this.country,
                this.awards,
                this.poster,
                this.rating,
                this.production,
                this.language);
    }
}
