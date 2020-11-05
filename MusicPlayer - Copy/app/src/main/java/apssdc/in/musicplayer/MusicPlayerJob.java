package apssdc.in.musicplayer;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.widget.Toast;

public class MusicPlayerJob extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Intent intent = new Intent(this,MusicService.class);
        startService(intent);
        Toast.makeText(this, "JOB SCHEDULED! YOU SHOULD BE LISTENING TO MUSIC!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Intent intent = new Intent(this,MusicService.class);
        stopService(intent);
        Toast.makeText(this, "JOB CANCELLED", Toast.LENGTH_SHORT).show();
        return true;
    }
}
