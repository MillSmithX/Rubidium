package com.planktonleap.rubidium.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.planktonleap.rubidium.R;
import com.planktonleap.rubidium.activities.PlayerViewDemoActivity;
import com.planktonleap.rubidium.adapters.VideosAdapter;
import com.planktonleap.rubidium.models.VideoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private VideosAdapter mAdapter;
    RecyclerView mRecyclerView;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        bindData();
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private void initInstances(View rootView){
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycleView);
    }

    private void bindData(){

        List<VideoModel> videos = populateTestData();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Fill item into adapter
        mAdapter = new VideosAdapter(getActivity(), videos);

        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(clickListener);
    }

    /*
	 * Listener variable.
	 */
    VideosAdapter.OnItemClickListener clickListener = new VideosAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, VideoModel obj, int position) {
            watchYoutubeVideo(obj.getVideoID());
        }
    };

    public void watchYoutubeVideo(String id){
//        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
//        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
//        try {
//
//            startActivity(appIntent);
//        } catch (ActivityNotFoundException ex) {
//            startActivity(webIntent);
//        }

        Intent intent = new Intent(getActivity(), PlayerViewDemoActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }


    private List<VideoModel> populateTestData(){
        List<VideoModel> videos = new ArrayList<>();
        VideoModel model = new VideoModel();
        model.setVideoID("BaDXkKtHr3w");
        model.setVideoTitle("Gardel - Por Una Cabeza");
        videos.add(model);

        model = new VideoModel();
        model.setVideoID("LAiNi5nORjc");
        model.setVideoTitle("Endless Rain - หน้ากากอีกาดำ | THE MASK SINGER หน้ากากนักร้อง");
        videos.add(model);

        model = new VideoModel();
        model.setVideoID("3phVp93WZJ8");
        model.setVideoTitle("No One Else Like You - Adam Levine");
        videos.add(model);

        model = new VideoModel();
        model.setVideoID("o0HwDzKoxRg");
        model.setVideoTitle("Best of The Dark Knight Soundtrack");
        videos.add(model);

        model = new VideoModel();
        model.setVideoID("PSeJckOUZrs");
        model.setVideoTitle("The Best of Hans Zimmer");
        videos.add(model);

        model = new VideoModel();
        model.setVideoID("hmidpJI04Qc");
        model.setVideoTitle("Tears - X Japan");
        videos.add(model);

        model = new VideoModel();
        model.setVideoID("08OLcU8Ts8g");
        model.setVideoTitle("ชาละวัน");
        videos.add(model);

        model = new VideoModel();
        model.setVideoID("42c1VhSNEQ8");
        model.setVideoTitle("บ่อสร้างกางจ้อง ϟ ทอม ดันดี");
        videos.add(model);
        return videos;
    }
}
