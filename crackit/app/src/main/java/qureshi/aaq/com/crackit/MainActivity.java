package qureshi.aaq.com.crackit;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends Activity {
    ScheduledExecutorService scheduler;
    FragmentManager fm;
    private InterstitialAd mInterstitialAd;
    MenuFragment menuFragment;
    ViewGroup viewGroup;
    TextView tv1,tv2;
    void init() {
        this.fm = getFragmentManager();
        this.menuFragment = new MenuFragment();
        this.viewGroup = findViewById(R.id.head_content);
        this.tv1 = findViewById(R.id.tv_one);
        this.tv2 = findViewById(R.id.tv_two);
    }



public void toggle(View ...views){
        for(View v:views)
        {
            if(v.getVisibility()==View.VISIBLE)
            {
                v.setVisibility(View.INVISIBLE);
            }
        }
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        MobileAds.initialize(this,"ca-app-pub-8557079357114808/1243249707");
        loadInterstial();
        repeatAd();
        init();
        if(Build.VERSION.SDK_INT>=21){
            TransitionInflater inflater = TransitionInflater.from(this);
            Transition transition=inflater.inflateTransition(R.transition.activity_transition);
            getWindow().setEnterTransition(transition);

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fade fade = new Fade();
                fade.setDuration(2000);
                TransitionManager.beginDelayedTransition(viewGroup,fade);
                toggle(tv1,tv2);

            }
        },2000);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                FragmentTransaction transaction = MainActivity.this.fm.beginTransaction();
                transaction.replace(R.id.frame_layout, MainActivity.this.menuFragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        }, 4000);



    }
    void loadInterstial(){

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8557079357114808/1243249707");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
    void repeatAd(){
       scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                        }
                        loadInterstial();
                    }
                });
            }
        }, 10, 200, TimeUnit.SECONDS);
    }

    @Override
    protected void onStop() {
        super.onStop();
        scheduler.shutdown();
    }
}
