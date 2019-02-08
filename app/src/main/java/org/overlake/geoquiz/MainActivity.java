package org.overlake.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String CURRENT_INDEX = "current_index";
    private static final String TAG = "MainActivity";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;

    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;

    private Question[] mQuestionBank = new Question[]{
        new Question(R.string.question_one, true),
        new Question(R.string.question_two, false),
        new Question(R.string.question_three, true),
        new Question(R.string.question_four, true),
        new Question(R.string.question_five, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(CURRENT_INDEX, 0);
        }

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mNextButton = findViewById(R.id.next_button);

        findViewById(R.id.cheat_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CheatActivity.class);
                startActivity(intent);
            }
        });

        mQuestionTextView = findViewById(R.id.question_text_view);
        updateQuestion();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
    }

    private void updateQuestion(){
        int questionId = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(questionId);
    }

    private void checkAnswer(boolean userClickedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if(answerIsTrue == userClickedTrue){
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause() called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_INDEX,mCurrentIndex);
    }
}
