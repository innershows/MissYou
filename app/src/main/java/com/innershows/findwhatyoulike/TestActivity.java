package com.innershows.findwhatyoulike;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void btn(View view) {
        //view.setTranslationX();
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationX", 0, 100);

        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "translationY", 0, 100);


        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                System.out.println("=====>onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                System.out.println("=====>onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                System.out.println("=====>onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                System.out.println("=====>onAnimationRepeat");
            }
        });

        set.setDuration(2000);
        set.playTogether(anim , anim2);
        set.start();
    }
}
