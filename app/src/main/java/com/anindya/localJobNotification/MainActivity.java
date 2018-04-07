package com.anindya.localJobNotification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.evernote.android.job.JobRequest;

public class MainActivity extends AppCompatActivity {

    JobRequest.Builder jobRequestBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init job request builder
        jobRequestBuilder = ShowNotificationJob.getJobRequestBuilder();
    }

    public void enableNotification(View view) {
        ShowNotificationJob.schedulePeriodic(jobRequestBuilder);
    }

    public void disableNotification(View view) {
        ShowNotificationJob.cancelJob();
    }
}
