package com.androidapps.robertsteele.beatbox;

public class Sound {

    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    public String getmAssetPath() {
        return mAssetPath;
    }

    public String getmName() {
        return mName;
    }

    public int getmSoundId() {
        return mSoundId;
    }

    public void setmSoundId(int mSoundId) {
        this.mSoundId = mSoundId;
    }

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String fileName = components[components.length - 1];
        mName = fileName.replace(".wav", "");
    }
}
