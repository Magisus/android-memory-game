package hu.ait.android.maggie.memorygame.gamescreen;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import hu.ait.android.maggie.memorygame.R;

public class GameScreenActivity extends ActionBarActivity implements DifficultyDialog.OptionsFragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        showDifficultyDialog();
    }

    private void showDifficultyDialog() {
        DifficultyDialog difficultySelect = new DifficultyDialog();
        difficultySelect.show(getSupportFragmentManager(), DifficultyDialog.TAG);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsFragmentResult(String difficulty) {
        Toast.makeText(this, difficulty, Toast.LENGTH_LONG).show();
    }
}
