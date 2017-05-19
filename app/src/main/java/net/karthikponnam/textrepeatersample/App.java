package net.karthikponnam.textrepeatersample;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by ponna on 19-05-2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /*
        Calligraphy Configuration and Init
        fonts are placed in assets/fonts folder in .ttf format
         */
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Signika-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
