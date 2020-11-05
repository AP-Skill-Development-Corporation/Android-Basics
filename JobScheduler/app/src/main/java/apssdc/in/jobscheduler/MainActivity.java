package apssdc.in.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    JobScheduler scheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void startJob(View view)
    {
        ComponentName name = new ComponentName(this,JobSchedulerService.class);
        JobInfo info =
                new JobInfo.Builder(12,name)
                        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                        .setRequiresCharging(true)
                .build();
        scheduler.schedule(info);
    }

    public void stopJob(View view)
    {
        scheduler.cancel(12);
    }
}