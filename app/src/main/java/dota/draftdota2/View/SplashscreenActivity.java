package dota.draftdota2.View;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import dota.draftdota2.R;
import dota.draftdota2.MainActivity;

public class SplashscreenActivity extends AppCompatActivity {
    //Set waktu lama splashscreen
    private final int SPLASH_DISPLAY_LENGHT = 5000;
    ProgressBar Loading;

    /** Called when the activity is first created. */
    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
		/* layout splashscreen dengan background gambar */
        setContentView(R.layout.splashscreen);
	/* handler untuk menjalankan splashscreen selama 5 detik lalu
	 * membuat HomeActivity
	 */


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = null;

                mainIntent = new Intent(SplashscreenActivity.this,MainActivity.class);

                SplashscreenActivity.this.startActivity(mainIntent);
                SplashscreenActivity.this.finish();

                Loading = (ProgressBar) findViewById (dota.draftdota2.R.id.progressBar1);
                Loading.setAlpha(SPLASH_DISPLAY_LENGHT);

            }

        }, SPLASH_DISPLAY_LENGHT);
    }

}