package net.ripadbaisor.ranking.videogame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.text.DateFormatter;

public class Videogame {

    private String name;
    private Date launchDate;
    private ArrayList<Float> graphicsScore;
    private ArrayList<Float> gameplayScore;
    private ArrayList<Float> optimizationScore;
    private ArrayList<Float> storyScore;
    private Float finalScore;

    public Videogame(String name, Date launchDate) {
        this.name = name;
        this.launchDate = launchDate;

        this.graphicsScore.add(0f);
        this.gameplayScore.add(0f);
        this.optimizationScore.add(0f);
        this.storyScore.add(0f);
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

        Float totalScores = 0f;

        for (int i = 0; i < graphicsScore.size(); i++) {
            
            totalScores += graphicsScore.get(i);

        }

        return totalScores / graphicsScore.size();
    }

    public void setGraphicsScore(Float graphicsScore) {
        this.graphicsScore.add(graphicsScore);
    }

    public float getGameplayScore() {
                Float totalScores = 0f;

        for (int i = 0; i < gameplayScore.size(); i++) {
            
            totalScores += gameplayScore.get(i);

        }

        return totalScores / gameplayScore.size();
    }

    public void setGameplayScore(Float gameplayScore) {
        this.gameplayScore.add(gameplayScore);
    }

    public float getOptimizationScore() {
                Float totalScores = 0f;

        for (int i = 0; i < optimizationScore.size(); i++) {
            
            totalScores += optimizationScore.get(i);

        }

        return totalScores / optimizationScore.size();
    }

    public void setOptimizationScore(Float optimizationScore) {
        this.optimizationScore.add(optimizationScore);
    }

    public float getStoryScore() {
        Float totalScores = 0f;

        for (int i = 0; i < storyScore.size(); i++) {
            
            totalScores += storyScore.get(i);

        }

        return totalScores / storyScore.size();
    }

    public void setStoryScore(Float storyScore) {
        
        this.storyScore.add(storyScore);
    }

    public float getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Float finalScore) {
        this.finalScore = (this.getGraphicsScore() + this.getGameplayScore() +
                            this.getOptimizationScore() + this.getStoryScore()) / 4;
    }

}