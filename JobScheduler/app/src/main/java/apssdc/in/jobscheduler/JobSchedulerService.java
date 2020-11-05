package apssdc.in.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

public class JobSchedulerService extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        doTheWork(jobParameters);
        return true;
        // We have offloaded the work that has to happen inside the
        // onStartJob() Method to a worker Thread. That's why we have
        // to return true as the value from this method.
    }

    private void doTheWork(final JobParameters jobParameters) {
        // Fake Job That happens in a separate thread.
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    Log.d("JOB", ""+(i+1));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                jobFinished(jobParameters,false);
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Toast.makeText(this, "Job is Stopped!", Toast.LENGTH_SHORT).show();
        return false;
    }
}
