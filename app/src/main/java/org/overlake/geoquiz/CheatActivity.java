package org.overlake.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public static final String USER_CHEATED = "user_cheated";
    private TextView mCheatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mCheatTextView = findViewById(R.id.cheat_text_view);
        findViewById(R.id.cheat_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean is_answer_true = getIntent()
                        .getBooleanExtra(MainActivity.ANSWER_IS_CORRECT,false);
                mCheatTextView
                        .setText(is_answer_true ? R.string.true_button : R.string.false_button);
                Intent data = new Intent();
                data.putExtra(USER_CHEATED,true);
                setResult(RESULT_OK,data);
            }
        });
    }


}
