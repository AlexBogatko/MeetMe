package com.meetme.data;

import android.content.Context;

import com.meetme.DataManager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by user on 12.02.2018.
 */

@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;

    @Inject
    public AppDataManager(Context context) {
        mContext = context;
    }
}
