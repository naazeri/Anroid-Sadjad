package ir.ac.sadjad.src.introapplication;

import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class Intro extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(AppIntroFragment.newInstance("خوش آمدید", "توضیحات ۱", R.drawable.image1, Color.parseColor("#F44336")));
        addSlide(AppIntroFragment.newInstance("صفحه ۲", "توضیحات ۲", R.drawable.image2, Color.parseColor("#2196F3")));
        addSlide(AppIntroFragment.newInstance("صفحه ۳", "توضیحات ۳", R.drawable.image3, Color.YELLOW));
    }

    @Override
    public void onSkipPressed() {

    }

    @Override
    public void onDonePressed() {

    }

    @Override
    public void onNextPressed() {
    }

    @Override
    public void onSlideChanged() {
    }
}
