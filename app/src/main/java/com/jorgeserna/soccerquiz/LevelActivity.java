package com.jorgeserna.soccerquiz;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class LevelActivity extends AppCompatActivity {

    private Button mCheckAnswer;
    private Country mCountry;
    private Country mFilename;
    private String mImage;
    private List<Country> mCountryList;
    private ImageView mCountryView;
    private EditText mAnswer;
    private String mCorrectAnswer;
    private int mToast;
    private Drawable image;

    private void updatePhotoView() {
        Country country = new Country(mCountry.getCountry(), mFilename.getFilename());
        country.setFilename(mFilename.getFilename());

        mImage = country.getFilename();
        int imageResource = getResources().getIdentifier(mImage, "drawable", getPackageName());
        mCountryView = (ImageView) findViewById(R.id.country_logo);
        image = ResourcesCompat.getDrawable(getResources(), imageResource, null);
        mCountryView.setImageDrawable(image);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        Intent intent = getIntent();
        int mLevel = intent.getExtras().getInt(QuizActivity.LEVEL);

        CountryLab countryLab = new CountryLab(getApplicationContext());
        mCountryList = countryLab.getCountries(mLevel);

        mCountry = mCountryList.get(0);
        mFilename = mCountryList.get(0);
        mCorrectAnswer = mCountry.getCountry();

        mAnswer = (EditText) findViewById(R.id.answer);

        mCountryView = (ImageView) findViewById(R.id.country_logo);
//        updatePhotoView();

        mCheckAnswer = (Button) findViewById(R.id.check_button);

        mCheckAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswer.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the Data", Toast.LENGTH_SHORT).show();
                } else {
                    if (mAnswer.getText().equals(mCorrectAnswer)) {
                        mToast = R.string.correct_toast;
                        Toast.makeText(getApplicationContext(), mToast, Toast.LENGTH_SHORT).show();
                    } else {
                        mToast = R.string.wrong_toast;
                        Toast.makeText(getApplicationContext(), mToast, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

          /*mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                mIsCheater = false;
                updateQuestion();
            }
        });

        mPreviousButton = (ImageButton) findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                if (mCurrentIndex < 0) {
                    mCurrentIndex = mQuestionBank.length - 1;
                }

                updateQuestion();
            }
        });*/
    }
}
