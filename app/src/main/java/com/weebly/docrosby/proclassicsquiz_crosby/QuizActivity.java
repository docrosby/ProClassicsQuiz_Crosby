package com.weebly.docrosby.proclassicsquiz_crosby;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class QuizActivity extends ActionBarActivity {
    private Button mLatin;
    private Button mGreek;
    private Button mMixed;
    private Button mExit;
    private EditText mEditText;
    Intent mIntent;
    private static String playerName;
    public static int quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mEditText=  (EditText)findViewById(R.id.player_name);
        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText("");
            }
        });
        mLatin = (Button)findViewById(R.id.latin_btn);
        mLatin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz = 0;
                dualBtnFunction(true);
            }
        });

        mGreek = (Button)findViewById(R.id.greek_btn);
        mGreek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz = 1;
                dualBtnFunction(true);
            }
        });
        mMixed = (Button)findViewById(R.id.mixed_btn);
        mMixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz = 2;
                dualBtnFunction(true);
            }
        });
        mExit = (Button)findViewById(R.id.exit_btn);
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dualBtnFunction(false);
            }
        });
    }

    public void dualBtnFunction(boolean tf){
        mIntent = new Intent(QuizActivity.this,QuestionActivity.class);
        playerName = mEditText.getText().toString();
        /*
        mIntent.putExtra("quizType",quiz);
        mIntent.putExtra("player",playerName);
        */
        startActivity(mIntent);
        if (tf){
            finish();
        }
        else{
            finish();
            System.exit(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.latn_menu_settings) {
            quiz = 0;
            dualBtnFunction(true);
            return true;
        }
        else if(id == R.id.grek_menu_settings) {
            quiz = 1;
            dualBtnFunction(true);
            return true;
        }
        else if (id == R.id.mixd_menu_settings) {
            quiz = 2;
            dualBtnFunction(true);
            return true;
        }
        else if (id == R.id.exit_menu_settings) {
            dualBtnFunction(false);
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
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
    public static String getPlayerName (){
        return playerName;
    }

    public static int getQuiz(){return quiz;}
}
