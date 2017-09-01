package crash.com.mcgregorsoundboard;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    private AnimationDrawable rotateHead_Animation;
    MediaPlayer mediaPlayer;


    // Sound drawables. These make up the McGregor soundboard sounds
    int[] sound = {
            R.raw.every_year_is_my_year,
            R.raw.dollar_bill_signs,
            R.raw.dogg,
            R.raw.i_dont_care_what_country,
            R.raw.money_in_a_briefcase,
            R.raw.the_mcgregor_show,
            R.raw.yelling,
            R.raw.laugh,
            R.raw.dressed_like_el_chapo
    } ;

    // Set the image source to the drawable head
         int imageId = R.drawable.rotate;


    // OnCreate is called whenever the Activity is created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);


        final CustomGrid adapter = new CustomGrid(MainActivity.this, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);



    // Setting click listeners for each item in the gridview
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // When a grid item is clicked, then play the sound and animation
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                // Stopping the mediaplayer is required. If a sound is already playing,
                // and the user clicks another gridview item, the sounds will overlap,
                // creating a messy sound.

                if(mediaPlayer != null){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, sound[position]);
                mediaPlayer.start();


                // Assign imageView so it can be used to run the rotate.xml animation
                ImageView imageView = (ImageView) view.findViewById(R.id.grid_image);

                // Holds the head rotation animation
                imageView.setBackgroundResource(R.drawable.rotate);


                // Same idea as stopping the media player above. This is a catch to ensure that any
                // Previous running animations are stopped so only one animation is running at one time
                if(rotateHead_Animation != null) {
                    rotateHead_Animation.stop();
                }

                rotateHead_Animation = (AnimationDrawable) imageView.getBackground();

                // Starting the head rotation animation
                rotateHead_Animation.start();

            }
        });

    }
}