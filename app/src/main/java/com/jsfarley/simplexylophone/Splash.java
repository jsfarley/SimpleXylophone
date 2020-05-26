package com.jsfarley.simplexylophone;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class Splash extends AppCompatActivity {
	private AnimationDrawable mAnimationDrawable;
	Handler mHandler;
	private MediaPlayer splashSound;
	Colors mColors = new Colors();
	private int sPColors;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loadSplash();
}
	private void loadSplash() {
		sPColors = mColors.getSplashScreen();
		EasySplashScreen easySplashScreen = new EasySplashScreen(Splash.this)
				.withFullScreen()
				.withTargetActivity(MainActivity.class)
				.withBackgroundColor(sPColors)
				.withLogo(R.drawable.ic_launcher_foreground)
				.withSplashTimeOut(3000);
		View easySplach = easySplashScreen.create();
		setContentView(easySplach);
		}
	}

