package com.weebly.docrosby.proclassicsquiz_crosby;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;


public class QuestionActivity extends ActionBarActivity {
    private Button mSubmit;
    private Button mQuit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);

    }
}
