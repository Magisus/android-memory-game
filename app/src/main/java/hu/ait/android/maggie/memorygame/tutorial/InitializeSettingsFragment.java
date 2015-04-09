package hu.ait.android.maggie.memorygame.tutorial;

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

/**
 * Created by Magisus on 4/9/2015.
 */
public class InitializeSettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.init_settings_fragment, container, false);

        Button startBtn = (Button) rootView.findViewById(R.id.startButton);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitializeSettingsFragment.this.startActivity(new Intent(getActivity(),
                        GameScreenActivity
                        .class));
            }
        });

        return rootView;
    }
}
