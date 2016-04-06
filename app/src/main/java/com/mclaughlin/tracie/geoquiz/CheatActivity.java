package com.mclaughlin.tracie.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tracie on 4/2/2016.
 */
public class CheatActivity extends AppCompatActivity {

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.mclaughlin.tracie.geoquiz.answer_is_true";

    public static final String EXTRA_ANSWER_SHOWN=
            "com.mclaughlin.tracie.geoquiz.answer_shown";

    private void setExtraAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK,data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        setExtraAnswerShownResult(false);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setExtraAnswerShownResult(true);
            }

        } );
    }

}