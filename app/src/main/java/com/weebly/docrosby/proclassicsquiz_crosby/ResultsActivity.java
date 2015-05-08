package com.weebly.docrosby.proclassicsquiz_crosby;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.TextView;


public class ResultsActivity extends ActionBarActivity {
    private Button mAnother;
    private Button mReset;
    private TextView mYourResults, mCorrect, mIncorrect, mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

    }
}
