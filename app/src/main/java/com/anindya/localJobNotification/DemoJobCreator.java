package com.anindya.localJobNotification;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;



class DemoJobCreator implements JobCreator {

    @Override
    public Job create(String tag) {
        switch (tag) {
            case ShowNotificationJob.TAG:
                return new ShowNotificationJob();
            default:
                return null;
        }
    }
}
