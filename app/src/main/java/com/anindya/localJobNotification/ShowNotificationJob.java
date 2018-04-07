package com.anindya.localJobNotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;

import java.util.Random;
import java.util.concurrent.TimeUnit;



class ShowNotificationJob extends Job {

    static final String TAG = "show_notification_job_tag";

    @NonNull
    @Override
    protected Result onRunJob(Params params) {
        PendingIntent pi = PendingIntent.getActivity(getContext(), 0,
                new Intent(getContext(), MainActivity.class), 0);

        Notification notification = new NotificationCompat.Builder(getContext())
                .setContentTitle("Local Notification")
                .setContentText("Notification from Android Demo App.")
                .setAutoCancel(true)
                .setContentIntent(pi)
                .setSmallIcon(R.drawable.ic_action_send_post)
                .setShowWhen(true)
                .setColor(Color.RED)
                .setLocalOnly(true)
                .build();

        NotificationManagerCompat.from(getContext())
                .notify(new Random().nextInt(), notification);

        return Result.SUCCESS;
    }

    static JobRequest.Builder getJobRequestBuilder(){
        JobRequest.Builder jobRequestBuilder = new JobRequest.Builder(ShowNotificationJob.TAG);
        return jobRequestBuilder;
    }

    static void schedulePeriodic(JobRequest.Builder jobRequestBuilder) {
        jobRequestBuilder.setPeriodic(TimeUnit.MINUTES.toMillis(2), TimeUnit.MINUTES.toMillis(1))
                .setUpdateCurrent(true)
                .setPersisted(true)
                .build()
                .schedule();
    }

    static void cancelJob() {
        JobManager.instance().cancelAll();
    }
}
