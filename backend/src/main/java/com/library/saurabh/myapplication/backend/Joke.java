package com.library.saurabh.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class Joke {

    private String jokeText;

    public String getJokeText() {
        return jokeText;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    public Joke(String jokeText) {
        this.jokeText = jokeText;
    }
}