package com.androidapps.robertsteele.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {

    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;
    private List<Sound> mSounds = new ArrayList<>();
    private AssetManager mAssets;
    private SoundPool mSoundPools;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        mSoundPools = (SoundPool) new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor assetFileDescriptor = mAssets.openFd(sound.getmAssetPath());
        int soundId = mSoundPools.load(assetFileDescriptor, 1);
        sound.setmSoundId(soundId);
    }

    public void play(Sound sound) {
        Integer soundId = sound.getmSoundId();
        if(soundId == null) {
            return;
        }
        mSoundPools.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void release() {
        mSoundPools.release();
    }

    private void loadSounds() {
        String[] soundNames;
        String soundPath;
        Sound sound;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.d(TAG, "found " + soundNames.length + " sounds");
        } catch (IOException ioe) {
            Log.d(TAG, "Could not load assets", ioe);
            return;
        }
        for (String fileName : soundNames) {
            try {
                soundPath = SOUNDS_FOLDER + "/" + fileName;
                sound = new Sound(soundPath);
                load(sound);
                mSounds.add(sound);
            } catch (java.io.IOException ioe) {
                Log.e(TAG, "Could not load sound" + fileName, ioe);
            }
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
