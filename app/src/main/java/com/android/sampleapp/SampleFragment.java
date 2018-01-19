package com.android.sampleapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ayush on 19/1/18.
 */

public class SampleFragment extends Fragment{
    private int screenId;

    public static Fragment newInstance(int screenId) {
        Bundle bundle=new Bundle();
        bundle.putInt("ScreenId",screenId);
        SampleFragment sampleFragment = new SampleFragment();
        sampleFragment.setArguments(bundle);
        return sampleFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        if (bundle != null ) {
            screenId = bundle.getInt("ScreenId");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sample_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView=view.findViewById(R.id.screen_tv);
        textView.setText(getResources().getStringArray(R.array.tab_titles)[screenId]);
    }
}
