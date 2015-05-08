package com.weebly.docrosby.proclassicsquiz_crosby;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultsActivity extends ActionBarActivity {
    private Button mAnother;
    private Button mReset;
    private TextView mIncorrect, mCorrect, mScore, mResults;
    private String resultLine;
    private int mCntInc, mCntCor;
    private double mScr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
/*
        Bundle extras = getIntent().getExtras();
        if (savedInstanceState == null) {
            Bundle b = getIntent().getExtras();
            if (b == null) {
                mCntCor = 0;
                mCntInc = 0;
                mScr = 0.0;
                resultLine = null;
            } else {
                mCntCor = b.getInt("cor", 0);
                mCntInc = b.getInt("inc", 0);
                mScr = b.getDouble("score", 0.0);
                resultLine = b.getString("player", null);
            }
        }
        else {
            mCntCor = (int)savedInstanceState.getSerializable("cor");
            mCntInc = (int)savedInstanceState.getSerializable("inc");
            mScr = (double)savedInstanceState.getSerializable("score");
            resultLine = (String)savedInstanceState.getSerializable("player");
        }
        resultLine += getResources().getString(R.string.result_address);
*/
        resultLine = QuizActivity.getPlayerName()+ getResources().getString(R.string.result_address);
        mResults = (TextView)findViewById(R.id.result_salute);
        mResults.setText(resultLine);

        mCorrect =  (TextView)findViewById(R.id.cor_txt);
        mCorrect.setText(getResources().getString(R.string.correct_num) + " " + QuestionActivity.getCorrect());

        mIncorrect =  (TextView)findViewById(R.id.inc_txt);
        mIncorrect.setText(getResources().getString(R.string.incorrect_num) + " " + QuestionActivity.getIncorrect());

        mScore =  (TextView)findViewById(R.id.scr_txt);
        mScore.setText(getResources().getString(R.string.score) + " " + QuestionActivity.getScore() + "%");

        mAnother = (Button)findViewById(R.id.another_quiz_btn);
        mAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoNavFunctions(QuestionActivity.class);
            }
        });
        mReset = (Button)findViewById(R.id.reset_button);
        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoNavFunctions(QuizActivity.class);
            }
        });
    }
    public void twoNavFunctions(Class c){
        Intent mIntent = new Intent(ResultsActivity.this, c );
        //reset
        startActivity(mIntent);
        finish();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        for (int i=0; i<menu.size(); i++) {
            MenuItem mi = menu.getItem(i);
            String title = mi.getTitle().toString();
            Spannable newTitle = new SpannableString(title);
            newTitle.setSpan(new ForegroundColorSpan(Color.WHITE), 0, newTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mi.setTitle(newTitle);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here..
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.another_q_menu_settings) {
            twoNavFunctions(QuestionActivity.class);
            return true;
        }
        else if(id == R.id.reset_menu_settings) {
            twoNavFunctions(QuizActivity.class);
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }
}
