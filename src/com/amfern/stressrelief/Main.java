package com.amfern.stressrelief;

// import android.app.Activity;
// import android.os.Bundle;

// public class Main extends Activity
// {
//     /** Called when the activity is first created. */
//     @Override
//     public void onCreate(Bundle savedInstanceState)
//     {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.main);
//     }
// }


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
   public static void main(String[] args) {
      LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
      cfg.title = "Stress Relief";
      cfg.useGL30 = false;
      cfg.width = 480;
      cfg.height = 320;

      new LwjglApplication(new MyGdxGame(), cfg);
   }
}