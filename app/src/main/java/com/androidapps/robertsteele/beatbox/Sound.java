package com.androidapps.robertsteele.beatbox;

public class Sound {

    private String mAssetPath;
    private String mName;

    public String getmAssetPath() {
        return mAssetPath;
    }

    public String getmName() {
        return mName;
    }

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String fileName = components[components.length -1];
        mName = fileName.replace(".wav", "");
    }
}
