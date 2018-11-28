package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer myPlayer;
    float leftVolume;
    float rightVolume;
    boolean released;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPlayer = MediaPlayer.create(this, R.raw.sugar_plum);
        released = false;
        Button play = (Button) findViewById(R.id.playButton);
        Button pause = (Button) findViewById(R.id.pauseButton);
        Button stop = (Button) findViewById(R.id.stopButton);
        Button up = (Button) findViewById(R.id.addVolume);
        Button down = (Button) findViewById(R.id.lowerVolume);
        leftVolume = 0.2f;
        rightVolume = 0.2f;
        //set initial volume
        //myPlayer.setVolume(leftVolume,rightVolume);
        myPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "I'm done",Toast.LENGTH_LONG).show();
                myPlayer.release();
            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(released == false)
                {
                    /*Boolean isPaused = !myPlayer.isPlaying() && myPlayer.getCurrentPosition() > 1;

                    if(isPaused)*/
                    myPlayer.start();

                }else
                {
                    myPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sugar_plum);
                    myPlayer.setVolume(leftVolume,rightVolume);
                    myPlayer.start();
                    released = false;
                }
            }

        });

        pause.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                if(myPlayer!=null)
                {
                    myPlayer.pause();
                }

            }

        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myPlayer!=null && myPlayer.isPlaying())
                {
                    myPlayer.stop();
                    myPlayer.release();
                    released = true;

                }

            }
        });

        up.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {


                if(myPlayer!=null)
                {
                    if(leftVolume <1f)
                    {
                        rightVolume= leftVolume = 0.1f + leftVolume;
                    }


                    myPlayer.setVolume(leftVolume, rightVolume);
                }
                }



        });

        down.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if(myPlayer!=null)
                {
                    if(leftVolume>0f)
                    {
                        rightVolume= leftVolume = leftVolume-0.1f;
                    }

                    myPlayer.setVolume(leftVolume, rightVolume);
                }
            }
        });
    }


}
