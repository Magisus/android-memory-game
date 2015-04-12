package hu.ait.android.maggie.memorygame.highscores;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import hu.ait.android.maggie.memorygame.R;
import hu.ait.android.maggie.memorygame.gamescreen.DifficultyDialog;

public class HighScoresActivity extends ActionBarActivity implements ClearOptionsDialog.MultiOptionsFragmentInterface{

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new HighScoresFragmentAdapter(getSupportFragmentManager(), getApplicationContext()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_high_scores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_clear) {
            ClearOptionsDialog clearDialog = new ClearOptionsDialog();
            clearDialog.show(getSupportFragmentManager(), ClearOptionsDialog.TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsFragmentResult(List<String> choices) {
        for(String difficulty : choices) {
            Score.deleteAll(Score.class, "difficulty = ?", difficulty);
        }
        pager.setAdapter(new HighScoresFragmentAdapter(getSupportFragmentManager(), getApplicationContext()));
    }
}
