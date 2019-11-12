package com.example.abhishekpathak.fab_button;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
//    DECLARATION OF VARIABLES OF FAB BUTTONS
    FloatingActionButton fab_plus,fab_twitter,fab_fb,fab_menu;
//    DECLARATION OF VARIABLES FOR ANIMATIONS THAT ARE NEEDED TO BE PERFORMED
    Animation FabOpen,FabClose,FabRClock,FabRAnticlock;
    //VARIABLE FOR CHECKING THE STATUS OF MAIN FAB BUTTON
    boolean isOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   // EXTRACTING ALL VARIABLES FROM THEIR CORRESPONDENT XML AND ANIMATION FILE
        fab_plus=findViewById(R.id.fab_plus);
        fab_twitter=findViewById(R.id.fab_twitter);
        fab_fb=findViewById(R.id.fab_fb);
        fab_menu=findViewById(R.id.fab_menu);
        FabOpen=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabRClock=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRAnticlock=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // IF MAIN FAB BUTTON IS ALREADY OPEN THEN IT WILL CLOSE THE OPENED FAB BUTTONS AND ROTATE MAIN FAB ANTICLOCKWISE 45 DEGREES
                if(isOpen){
                    fab_twitter.startAnimation(FabClose);
                    fab_fb.startAnimation(FabClose);
                    fab_menu.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRAnticlock);
                    fab_twitter.setClickable(false);
                    fab_fb.setClickable(false);
                    fab_menu.setClickable(false);
                    isOpen=false;


                }
                // IF MAIN BUTTON IS NOT OPEN THEN IT WILL OPEN ALL THE OTHER FAB BUTTONS AND ROTATE THE MAIN FAB BUTTON CLOCKWISE 45 DEGREES
                else{
                    fab_twitter.startAnimation(FabOpen);
                    fab_fb.startAnimation(FabOpen);
                    fab_menu.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClock);
                    fab_twitter.setClickable(true);
                    fab_fb.setClickable(true);
                    fab_menu.setClickable(true);
                    isOpen=true;


                }
            }
        });
    }
}
