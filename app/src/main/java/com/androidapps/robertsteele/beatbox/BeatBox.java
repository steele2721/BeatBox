package com.androidapps.robertsteele.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {

    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private List<Sound> mSounds = new ArrayList<>();


    private AssetManager mAssets;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        String soundPath;
        Sound sound;
        try{
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.d(TAG, "found " +  soundNames.length + " sounds");
        }catch (IOException ioe) {
            Log.d(TAG, "Could not load assets", ioe);
            return;
        }
        for (String name : soundNames) {
            soundPath = SOUNDS_FOLDER + "/" + name + ".wav";
            sound = new Sound(soundPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
