package com.androidapps.robertsteele.beatbox;

import android.support.v4.app.Fragment;
import android.os.Bundle;

public class BeatBoxActivity extends com.androidapps.robertsteele.beatbox.SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }

    @Override
    int getLayoutResId() {
        return R.layout.activity_fragment;
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_beat_box);
//    }
}
