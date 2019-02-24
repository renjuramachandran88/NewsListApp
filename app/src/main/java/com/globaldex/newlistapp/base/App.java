package com.globaldex.newlistapp.base;

import android.app.Application;

import com.globaldex.newlistapp.data.network.NewsNetwork;

/**
 * Created by renjumenon on 21/02/19.
 */
public class App extends Application {
@Override
    public void onCreate(){
    super.onCreate();
    NewsNetwork.init(this);

}
}
