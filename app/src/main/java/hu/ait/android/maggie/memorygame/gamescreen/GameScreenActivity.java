package hu.ait.android.maggie.memorygame.gamescreen;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

    private void getGameBoard(String tag){
        Fragment fragment = null;
        fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if(fragment == null){
            if(EasyBoardFragment.TAG.equals(tag)){
                fragment = new EasyBoardFragment();
            }
        }

        if(fragment != null){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction trans = fm.beginTransaction();
            trans.replace(R.id.gameScreenContainer, fragment, tag);
            trans.commit();
        }
    }

    @Override
    public void onOptionsFragmentResult(String difficulty) {
        if(getString(R.string.easy_text).equals(difficulty)){
                getGameBoard(EasyBoardFragment.TAG);
        } else if(getString(R.string.medium_text).equals(difficulty)){
            //get medium board
        } else if(getString(R.string.hard_text).equals(difficulty)){
            //get hard board
        } else {
            //handle this, dunno if it can happen, but handle it
        }
    }
}
