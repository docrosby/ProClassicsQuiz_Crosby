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


public class QuestionActivity extends ActionBarActivity {
    private Button mSubmit;
    private Button mQuit;
    private static int quizType, mIncorrect=0,mCorrect=0, mQuestCnt=1;
    private static double mScore = 0.0;
//    private static String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
/*
        Bundle extras = getIntent().getExtras();
        if (savedInstanceState == null) {
            Bundle b = getIntent().getExtras();
            if (b == null) {
                quizType = 0;
                playerName = null;
            } else {
                quizType = b.getInt("quizType", 0);
                playerName = b.getString("player", null);
            }
        }
        else {
            quizType = (int)savedInstanceState.getSerializable("quizType");
            playerName = (String)savedInstanceState.getSerializable("player");
        }
*/
        quizType = QuizActivity.getQuiz();
        mQuit = (Button)findViewById(R.id.quit_button);
        mQuit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navFunctions();
            }
        });
        mSubmit = (Button)findViewById(R.id.submit_btn);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void navFunctions(){
        Intent mIntent = new Intent(QuestionActivity.this,ResultsActivity.class);
/*
        mIntent.putExtra("player",playerName);
        mIntent.putExtra("score",mScore);
        mIntent.putExtra("inc",mIncorrect);
        mIntent.putExtra("cor",mCorrect);
*/
        startActivity(mIntent);
        finish();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here..
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.submit_menu_settings) {
            // do something
            return true;
        }
        else if(id == R.id.quit_menu_settings) {
            navFunctions();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }
    public static int getIncorrect(){
        return mIncorrect;
    }
    public static int getCorrect(){
        return mCorrect;
    }
    public static double getScore(){
        return (double)mCorrect/mQuestCnt;
    }
}
