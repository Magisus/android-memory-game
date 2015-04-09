package hu.ait.android.maggie.memorygame.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Set;

import hu.ait.android.maggie.memorygame.R;

/**
 * Created by Magisus on 4/9/2015.
 */
public class SettingsDisplayFragment extends Fragment {

    public static final String TAG = "SettingsDisplayFragment";

    public static final String NA = "--";

    private TextView nameText;
    private TextView ageText;
    private TextView genderText;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings_display, container, false);

        SharedPreferences prefs = getActivity().getSharedPreferences(SettingsActivity.SETTINGS,
                Context.MODE_PRIVATE);
        nameText = (TextView) rootView.findViewById(R.id.nameText);
        nameText.setText(prefs.getString(SettingsActivity.NAME, NA));

        ageText = (TextView) rootView.findViewById(R.id.ageText);
        ageText.setText(prefs.getString(SettingsActivity.AGE, NA));

        genderText = (TextView) rootView.findViewById(R.id.genderText);
        genderText.setText(prefs.getString(SettingsActivity.GENDER, NA));

        Button editUserBtn = (Button) rootView.findViewById(R.id.editUserBtn);
        editUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).showFragment(EditUserFragment.TAG);
            }
        });
        return rootView;
    }
}
