package net.ripadbaisor.ranking.videogame;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

public class Videogame {

    private String name;
    private Date launchDate;
    private float graphicsScore;
    private float gameplayScore;
    private float optimizationScore;
    private float storyScore;
    private float finalScore;

    public Videogame(String name, Date launchDate) {
        this.name = name;
        this.launchDate = launchDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public String getLaunchDateFormatted() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormated = dateFormat.format(launchDate);

        return dateFormated;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public float getGraphicsScore() {
        return graphicsScore;
    }

    public void setGraphicsScore(float graphicsScore) {
        this.graphicsScore = graphicsScore;
    }

    public float getGameplayScore() {
        return gameplayScore;
    }

    public void setGameplayScore(float gameplayScore) {
        this.gameplayScore = gameplayScore;
    }

    public float getOptimizationScore() {
        return optimizationScore;
    }

    public void setOptimizationScore(float optimizationScore) {
        this.optimizationScore = optimizationScore;
    }

    public float getStoryScore() {
        return storyScore;
    }

    public void setStoryScore(float storyScore) {
        this.storyScore = storyScore;
    }

    public float getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(float finalScore) {
        this.finalScore = finalScore;
    }

}