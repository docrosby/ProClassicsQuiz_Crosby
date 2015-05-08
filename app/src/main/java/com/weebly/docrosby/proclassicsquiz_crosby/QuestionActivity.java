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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class QuestionActivity extends ActionBarActivity {
    private Button mSubmit;
    private Button mQuit;
    private static int quizType, mIncorrect=0,mCorrect=6, mQuestCnt = 11;//temp values to test score
    private static double mScore = 0.0;
    private static String mEngVar = "temporary place holder";
    private TextView mQuestNum, mQuestions;
    private RadioGroup mRadioGroup;
    private RadioButton mRadio1, mRadio2, mRadio3, mRadio4, mRadio5;
    private String[][] mStringArray;
    private String[] mTempArray;

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
        mQuestNum = (TextView)findViewById(R.id.q_num);
        mQuestNum.setText(getResources().getString(R.string.question_number)+ " " + mQuestCnt + ":");

        mQuestions = (TextView)findViewById(R.id.q_text);
        mQuestions.setText(getResources().getString(R.string.question_label)+ " " + mEngVar + "?");

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
        mTempArray = getResources().getStringArray(R.array.word_classics);
        mStringArray = new String[mTempArray.length][];
        for(int i = 0; i < mTempArray.length;i++){
            mStringArray[i] = mTempArray[i].split("|");
        }
   //     mQuestNum.setText(mStringArray[0][0] +" - "+ mStringArray[0][1] +" - "+ mStringArray[0][2]);
   //     mQuestions.setText(mStringArray[mStringArray.length-1][0] +" - "+ mStringArray[mStringArray.length-1][1] + " - " + mStringArray[mTempArray.length-1][2]);
        mRadioGroup = (RadioGroup)findViewById(R.id.rBtnGroup);
        mRadio1 = (RadioButton)findViewById(R.id.rBtn1);
        mRadio2 = (RadioButton)findViewById(R.id.rBtn2);
        mRadio3 = (RadioButton)findViewById(R.id.rBtn3);
        mRadio4 = (RadioButton)findViewById(R.id.rBtn4);
        mRadio5 = (RadioButton)findViewById(R.id.rBtn5);
        setRadioButton();
    }
    public void setRadioButton(){
        int type, quiz = QuizActivity.getQuiz();
        if (quiz == 0){}
        else if (quiz == 1){}
        else{}
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
        return (double)((mCorrect*100)/(double)mQuestCnt);
    }
}
