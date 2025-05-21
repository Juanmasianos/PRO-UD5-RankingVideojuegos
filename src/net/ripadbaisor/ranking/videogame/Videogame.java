package net.ripadbaisor.ranking.videogame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.text.DateFormatter;

public class Videogame {

    private String name;
    private Date launchDate;
    private ArrayList<Float> graphicsScore = new ArrayList<Float>();
    private ArrayList<Float> gameplayScore = new ArrayList<Float>();
    private ArrayList<Float> optimizationScore = new ArrayList<Float>();
    private ArrayList<Float> storyScore = new ArrayList<Float>();
    private Float finalScore;
    private boolean isRated;

    public Videogame(String name, Date launchDate) {
        this.name = name;
        this.launchDate = launchDate;

        setFinalScore();
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
        if (graphicsScore > 0) {
            this.isRated = true;
        }

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
        if (gameplayScore > 0) {
            this.isRated = true;
        }

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
        if (optimizationScore > 0) {
            this.isRated = true;
        }

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
        if (storyScore > 0) {
            this.isRated = true;
        }
        
        this.storyScore.add(storyScore);
    }

    public float getFinalScore() {
        return finalScore;
    }

    public void setFinalScore() {

        if (isRated) {
            this.finalScore = (this.getGraphicsScore() + this.getGameplayScore() +
                            this.getOptimizationScore() + this.getStoryScore()) / 4;
        } else {

            this.finalScore = 0f;

        }
    }

}