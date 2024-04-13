package com.contact.contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class ContactsAppSplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_app_splash_screen);

        // Find the LottieAnimationView by its ID defined in the XML layout file
        LottieAnimationView lottieAnimationView = findViewById(R.id.splash_lottie);

//        TextView textView = findViewById(R.id.myTextView);
//
//        Animation splashComponentsAnimation = AnimationUtils.loadAnimation(ContactsAppSplashScreen.this, R.anim.alpha);
//        Animation imageComponentsAnimation = AnimationUtils.loadAnimation(ContactsAppSplashScreen.this, R.anim.imagesplashanim);
//        textView.startAnimation(splashComponentsAnimation);
//
//        // Make sure to check if lottieAnimationView is not null before using it
//        if (lottieAnimationView != null) {
//            lottieAnimationView.setAnimation(R.raw.splash_lottie);
//            lottieAnimationView.playAnimation();
//        }

        Intent homeIntent = new Intent(ContactsAppSplashScreen.this, MainActivity.class);
        new Handler().postDelayed(() -> {
            startActivity(homeIntent);
            finish();
        }, 3250);
    }
}
