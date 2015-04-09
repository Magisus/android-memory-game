package hu.ait.android.maggie.memorygame.mainmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hu.ait.android.maggie.memorygame.R;
import hu.ait.android.maggie.memorygame.gamescreen.GameScreenActivity;
import hu.ait.android.maggie.memorygame.tutorial.TutorialActivity;

/**
 * Created by Magisus on 4/2/2015.
 */
public class MainMenuFragment extends Fragment {

    public static final String TAG = "MainMenu";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.menu_fragment, container, false);

        Button newGameBtn = (Button) rootView.findViewById(R.id.newGameBtn);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenuFragment.this.startActivity(new Intent(getActivity(), GameScreenActivity.class));
            }
        });

        Button tutorialBtn = (Button) rootView.findViewById(R.id.tutorialBtn);
        tutorialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenuFragment.this.startActivity(new Intent(getActivity(), TutorialActivity.class));
            }
        });
        return rootView;
    }
}
