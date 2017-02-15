package com.planktonleap.rubidium.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.planktonleap.rubidium.R;
import com.planktonleap.rubidium.adapters.PageAdapter;
import com.planktonleap.rubidium.models.VideoEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pongtep Pakakat on 2/15/2017.
 */

public class VideoListFragment extends ListFragment {
    /** The duration of the animation sliding up the video in portrait. */
    private static final int ANIMATION_DURATION_MILLIS = 300;

    private static final List<VideoEntry> VIDEO_LIST;
    static {
        List<VideoEntry> list = new ArrayList<VideoEntry>();
        list.add(new VideoEntry("YouTube Collection", "Y_UmWdcTrrc"));
        list.add(new VideoEntry("GMail Tap", "1KhZKNZO8mQ"));
        list.add(new VideoEntry("Chrome Multitask", "UiLSiqyDf4Y"));
        list.add(new VideoEntry("Google Fiber", "re0VRK6ouwI"));
        list.add(new VideoEntry("Autocompleter", "blB_X38YSxQ"));
        list.add(new VideoEntry("GMail Motion", "Bu927_ul_X0"));
        list.add(new VideoEntry("Translate for Animals", "3I24bSteJpw"));
        VIDEO_LIST = Collections.unmodifiableList(list);
    }

    private PageAdapter adapter;
    private View videoBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PageAdapter(getActivity(), VIDEO_LIST);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        videoBox = getActivity().findViewById(R.id.video_box);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String videoId = VIDEO_LIST.get(position).getVideoId();

        VideoFragment videoFragment =
                (VideoFragment) getFragmentManager().findFragmentById(R.id.video_fragment_container);
        videoFragment.setVideoId(videoId);

        // The videoBox is INVISIBLE if no video was previously selected, so we need to show it now.
        if (videoBox.getVisibility() != View.VISIBLE) {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                // Initially translate off the screen so that it can be animated in from below.
                videoBox.setTranslationY(videoBox.getHeight());
            }
            videoBox.setVisibility(View.VISIBLE);
        }

        // If the fragment is off the screen, we animate it in.
        if (videoBox.getTranslationY() > 0) {
            videoBox.animate().translationY(0).setDuration(ANIMATION_DURATION_MILLIS);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        adapter.releaseLoaders();
    }

    public void setLabelVisibility(boolean visible) {
        adapter.setLabelVisibility(visible);
    }
}
