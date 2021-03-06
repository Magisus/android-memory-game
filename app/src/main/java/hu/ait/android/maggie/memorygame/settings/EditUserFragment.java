package hu.ait.android.maggie.memorygame.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import hu.ait.android.maggie.memorygame.R;
import hu.ait.android.maggie.memorygame.gamescreen.GameScreenActivity;

/**
 * Created by Magisus on 4/9/2015.
 */
public class EditUserFragment extends Fragment {

    public static final String TAG = "EditUserFragment";
    public static final String FROM_TUTORIAL = "FROM_TUTORIAL";

    private Button saveBtn;

    private EditText nameEdit;
    private EditText ageEdit;
    private RadioButton femaleRadio;
    private RadioButton maleRadio;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.edit_user_fragment, container, false);

        saveBtn = (Button) rootView.findViewById(R.id.saveBtn);
        boolean fromTutorial = getArguments().getBoolean(FROM_TUTORIAL);
        if(fromTutorial){
            saveBtn.setText("Save and start!");
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
                if (getArguments().getBoolean(FROM_TUTORIAL)) {
                    EditUserFragment.this.startActivity(new Intent(getActivity(),
                            GameScreenActivity.class));
                } else {
                    ((SettingsActivity) getActivity()).showFragment(SettingsDisplayFragment.TAG);
                }
            }
        });

        nameEdit = (EditText) rootView.findViewById(R.id.nameEdit);
        ageEdit = (EditText) rootView.findViewById(R.id.ageEdit);
        femaleRadio = (RadioButton) rootView.findViewById(R.id.femaleRadio);
        maleRadio = (RadioButton) rootView.findViewById(R.id.maleRadio);

        return rootView;
    }

    private void saveUserData() {
        SharedPreferences prefs = getActivity().getSharedPreferences(SettingsActivity.SETTINGS,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(SettingsActivity.NAME, nameEdit.getText().toString());
        editor.putString(SettingsActivity.AGE, ageEdit.getText().toString());
        editor.putString(SettingsActivity.GENDER, femaleRadio.isChecked() ? femaleRadio.getText()
                .toString() : maleRadio.getText().toString());
        editor.commit();
    }

    public static EditUserFragment newInstance(boolean fromTutorial) {
        EditUserFragment fragment = new EditUserFragment();
        Bundle args = new Bundle();
        args.putBoolean(FROM_TUTORIAL, fromTutorial);
        fragment.setArguments(args);
        return fragment;
    }
}
