package com.jsfarley.simplexylophone;

import android.graphics.Color;

import java.util.Random;

public class Colors {
	private int mDarkTheme;
	private int mLightTheme;
	 String[] mSplashScreen ={
			"#8e44ad",
			"#ff3493c8",
			"#1abc9c",
			"#2ecc71",
			"#f1c40f",
			"#e67e22",
			"#d35400",
			"#c0392b"
	};

	public int getSplashScreen() {
		Random random = new Random();
		int randomNumber = random.nextInt(mSplashScreen.length);
		int splashColor = Color.parseColor(mSplashScreen[randomNumber]);
		return splashColor ;
	}

	public int getDarkTheme() {
		mDarkTheme = Color.parseColor("#242426");

		return mDarkTheme;
	}

	public int getLightTheme() {
		mLightTheme = Color.parseColor("#FFFFFF");
		return mLightTheme;
	}
	public Colors(){
	}
}
