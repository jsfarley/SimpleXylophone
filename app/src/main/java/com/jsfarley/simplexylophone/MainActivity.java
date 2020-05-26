package com.jsfarley.simplexylophone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
	//SoundPool Constants
	private final int NO_OF_SIMULTANEOUS_SOUNDS = 8;
	private final float LEFT_VOLUME = 1.0f;
	private final float RIGHT_VOLUME = 1.0f;
	private final int NO_LOOP = 0;
	private final int PRIORITY = 0;
	private final float NORMAL_PLAY_RATE = 1.0f;
	private final int SOURCE_QUALITY = 0;
	//MemberVariables
	 SoundPool mSoundPool;
	 private int mLoCSoundId;
	 private int mDSoundId;
	 private int mESoundId;
	 private int mFSoundId;
	 private int mGSoundId;
	 private int mASoundId;
	 private int mBSoundId;
	 private int mCSoundId;
	 LinearLayout mLinearLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//checks for build version greater than LOLLIPOP
 		if ((Build.VERSION.SDK_INT) >= Build.VERSION_CODES.LOLLIPOP){
			AudioAttributes audioAttributes = new AudioAttributes.Builder()
					.setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
					.setContentType(AudioAttributes.CONTENT_TYPE_MOVIE)
					.build();
			mSoundPool = new SoundPool.Builder()
					.setMaxStreams(NO_OF_SIMULTANEOUS_SOUNDS)
					.setAudioAttributes(audioAttributes)
					.build();
		}else{
			mSoundPool = new SoundPool(NO_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC,SOURCE_QUALITY);
		}
		mLinearLayout = (LinearLayout)findViewById(R.id.linearLayout);
	}
	@Override
	protected void onStart() {
		super.onStart();
		getUpdatedBackground();
		setNoteScale();
	}
	private void setNoteScale() {
		mLoCSoundId = mSoundPool.load(getApplicationContext(), R.raw.lo_c, 1);
		mDSoundId = mSoundPool.load(getApplicationContext(), R.raw.d, 1);
		mESoundId = mSoundPool.load(getApplicationContext(), R.raw.e, 1);
		mFSoundId = mSoundPool.load(getApplicationContext(), R.raw.f, 1);
		mGSoundId = mSoundPool.load(getApplicationContext(), R.raw.g, 1);
		mASoundId = mSoundPool.load(getApplicationContext(), R.raw.a, 1);
		mBSoundId = mSoundPool.load(getApplicationContext(), R.raw.b, 1);
		mCSoundId = mSoundPool.load(getApplicationContext(), R.raw.c, 1);
	}
	//Sets background color based on time of day. Substitute for DayNight Theme
	private void getUpdatedBackground() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		int hours = c.get(Calendar.HOUR_OF_DAY);
		Colors mColors = new Colors();
		if(hours>=1 && hours<=7){
			mLinearLayout.setBackgroundColor(mColors.getDarkTheme());
		}else if(hours>=7 && hours<=18){
			mLinearLayout.setBackgroundColor(mColors.getLightTheme());
		}else if(hours>=18 && hours<=24){
			mLinearLayout.setBackgroundColor(mColors.getDarkTheme());
		}
	}
	public void playLoCKey(View view) {
		mSoundPool.play(mLoCSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
	}
	public void playDKey(View view) {
		mSoundPool.play(mDSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
	}
	public void playEKey(View view) {
		mSoundPool.play(mESoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
	}
	public void playFKey(View view){
		mSoundPool.play(mFSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
	}
	public void playGKey(View view){
		mSoundPool.play(mGSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
	}
	public void playAKey(View view){
		mSoundPool.play(mASoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
	}
	public void playBKey(View view){
		mSoundPool.play(mBSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
	}
	public void playCKey(View view){
		mSoundPool.play(mCSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
	}
}
