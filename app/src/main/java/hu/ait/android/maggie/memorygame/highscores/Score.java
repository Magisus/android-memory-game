package hu.ait.android.maggie.memorygame.highscores;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Magisus on 4/11/2015.
 */
public class Score extends SugarRecord<Score> {

    public enum Difficulty { EASY, MEDIUM, HARD }

    private String time;
    private String name;
    private Date date;
    private Difficulty difficulty;

    public Score(){
        //default constructor
    }

    public Score(String time, String name, Date date, Difficulty difficulty) {
       this.time = time;
        this.name = name;
        this.date = date;
        this.difficulty = difficulty;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

}
