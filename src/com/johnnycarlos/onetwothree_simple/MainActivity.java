package com.johnnycarlos.onetwothree_simple;

import java.io.IOException;

import com.johnnycarlos.onetwothree_simple.R;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class MainActivity extends Activity {
    
    private int n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;
    
    private int currentImage;
    private int currentSound;
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	
        super.onCreate(savedInstanceState);
		
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);

        loadSoundFiles();
		
        currentImage = R.drawable.splash;  // splash screen
        
        currentSound = n1;
        
        runGame();  

    } 

    /**
     * This is the main game method.  It loads the first graphic, registers a click listener
     * that displays the next letter and plays the corresponding sound file.
     */
    private void runGame(){

        final ImageView imageView = (ImageView)findViewById(R.id.main_image_id);

        imageView.setOnClickListener(new OnClickListener() {
        
            public void onClick(View v) {

                setImageAndSoundFiles(); 
                
                // Draw the current letter
                Drawable image = getResources().getDrawable( currentImage );
                imageView.setImageDrawable(image);

                // Play the current sound
                soundPool.play(currentSound, 1, 1, 0, 0, 1);
            }
                	
        }); // end setOnClickListener

    } // end runGame
    
    /**
     * This method sets the sound and graphic files.
     * It looks at the global variables currentImage and currentSound, and
     * sets them to the next letter in the alphabet.
     */
    private void setImageAndSoundFiles(){

        switch (currentImage){
        case R.drawable.splash:  
            currentImage = R.drawable.n1;
            currentSound = n1;
            break;
        case R.drawable.n1:  
            currentImage = R.drawable.n2;
            currentSound = n2;
            break;
        case R.drawable.n2:  
            currentImage = R.drawable.n3;
            currentSound = n3;
            break;
        case R.drawable.n3:  
            currentImage = R.drawable.n4;
            currentSound = n4;
            break;
        case R.drawable.n4:  
            currentImage = R.drawable.n5;
            currentSound = n5;
            break;
        case R.drawable.n5:  
            currentImage = R.drawable.n6;
            currentSound = n6;
            break;
        case R.drawable.n6:  
            currentImage = R.drawable.n7;
            currentSound = n7;
            break;
        case R.drawable.n7:  
            currentImage = R.drawable.n8;
            currentSound = n8;
            break;
        case R.drawable.n8:  
            currentImage = R.drawable.n9;
            currentSound = n9;
            break;
        case R.drawable.n9:
            currentImage = R.drawable.n10;
            currentSound = n10;
            break;
        case R.drawable.n10:
            currentImage = R.drawable.n1;
            currentSound = n1;
            break;
        default:
            break;                
       } // end switch

    }
    
    //TODO:  Put this in a loop or a hash or something
    /**
     * This method loads all the sound files into global integers(a,b,c, etc) that represent
     * their location in the soundPool.
     */
    private void loadSoundFiles(){
        try{
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor = assetManager.openFd("1.ogg");
            n1 = soundPool.load(descriptor, 1);
            
            descriptor = assetManager.openFd("2.ogg");
            n2 = soundPool.load(descriptor, 1);

            descriptor = assetManager.openFd("3.ogg");
            n3 = soundPool.load(descriptor, 1);
            
            descriptor = assetManager.openFd("4.ogg");
            n4 = soundPool.load(descriptor, 1);

            descriptor = assetManager.openFd("5.ogg");
            n5 = soundPool.load(descriptor, 1);
            
            descriptor = assetManager.openFd("6.ogg");
            n6 = soundPool.load(descriptor, 1);

            descriptor = assetManager.openFd("7.ogg");
            n7 = soundPool.load(descriptor, 1);
            
            descriptor = assetManager.openFd("8.ogg");
            n8 = soundPool.load(descriptor, 1);

            descriptor = assetManager.openFd("9.ogg");
            n9 = soundPool.load(descriptor, 1);
            
            descriptor = assetManager.openFd("10.ogg");
            n10 = soundPool.load(descriptor, 1);
            
        } 
        catch(IOException e) {
           Log.d("loadSoundFiles Exception:", e.toString());
        }
    }

} // end class