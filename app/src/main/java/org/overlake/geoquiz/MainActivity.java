package org.overlake.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        int questionId = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(questionId);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT);
                t.show();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }
}
