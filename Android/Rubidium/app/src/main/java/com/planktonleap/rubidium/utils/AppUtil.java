package com.planktonleap.rubidium.utils;


import android.content.Context;

import com.planktonleap.rubidium.R;

/**
 * Created by Pongtep Pakakat on 2/9/2017.
 */

public class AppUtil {
    /**
     * Please replace this with a valid API key which is enabled for the
     * YouTube Data API v3 service. Go to the
     * <a href="https://console.developers.google.com/">Google Developers Console</a>
     * to register a new developer key.
     */
    //public static final String DEVELOPER_KEY = null;

    private Context context;

    public AppUtil(){}

    public AppUtil(Context context){
        this.context = context;
    }

    public String getYoutubeAPIKey(){
      return context.getResources().getString(R.string.google_youtube_api_key);
    }


}
