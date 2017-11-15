package ua.room.project.dbflow;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by kunde on 15.11.2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(this);
    }
}
