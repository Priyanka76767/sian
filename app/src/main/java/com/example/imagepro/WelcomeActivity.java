package com.example.imagepro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.imagepro.databinding.ActivityWelcomeBinding;

public final class WelcomeActivity extends AppCompatActivity {
    public ActivityWelcomeBinding splashBinding;
    public final ActivityWelcomeBinding getSplashBinding() {
        ActivityWelcomeBinding var10000 = this.splashBinding;
//        if (var10000 == null) {
//            Intrinsics.throwUninitializedPropertyAccessException("splashBinding");
//        }

        return var10000;
    }

    public final void setSplashBinding(ActivityWelcomeBinding var1) {
//        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.splashBinding = var1;
    }

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityWelcomeBinding var10001 = ActivityWelcomeBinding.inflate(this.getLayoutInflater());
//        Intrinsics.checkNotNullExpressionValue(var10001, "ActivityWelcomeBinding.inflate(layoutInflater)");
        this.splashBinding = var10001;
        ActivityWelcomeBinding var10000 = this.splashBinding;
//        if (var10000 == null) {
//            Intrinsics.throwUninitializedPropertyAccessException("splashBinding");
//        }

        ConstraintLayout var5 = var10000.getRoot();
//        Intrinsics.checkNotNullExpressionValue(var5, "splashBinding.root");
        ConstraintLayout view = var5;
        this.setContentView((View)view);
        Animation alphaAnimation = AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.splash_anim);
        var10000 = this.splashBinding;
//        if (var10000 == null) {
//            Intrinsics.throwUninitializedPropertyAccessException("splashBinding");
//        }

        var10000.textView.startAnimation(alphaAnimation);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed((Runnable)(new Runnable() {
            public void run() {
                Intent intent = new Intent((Context)WelcomeActivity.this, HomeActivity.class);
                WelcomeActivity.this.startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }), 7000L);
    }
}
