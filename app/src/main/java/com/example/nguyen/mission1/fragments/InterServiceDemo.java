package com.example.nguyen.mission1.fragments;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class InterServiceDemo extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public InterServiceDemo(String name) {
        super(name);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
