package ir.ac.sadjad.imageloading;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.main_imageView1);
        imageView2 = (ImageView) findViewById(R.id.main_imageView2);
        imageView3 = (ImageView) findViewById(R.id.main_imageView3);

        loadFromRes(MainActivity.this, R.drawable.image01);
//        loadFromInternet(MainActivity.this, "http://www.freeiconspng.com/uploads/android-phone-icon-png-14.png");
    }

    private void loadFromRes(Context context, int imageAddress) {
        Picasso.with(context)
                .load(imageAddress)
                .into(imageView1);

        Picasso.with(context)
                .load(imageAddress)
                .into(imageView2);

        Picasso.with(context)
                .load(imageAddress)
                .into(imageView3);
    }

    private void loadFromInternet(Context context, String url) {
        Picasso.with(context)
                .load(url)
                .into(imageView1);

        Picasso.with(context)
                .load(url)
                .resize(500, 500)
                .centerCrop()
                .into(imageView2);

        Picasso.with(context)
                .load(url)
                .resize(500, 500)
                .centerCrop()
                .into(imageView3);
    }
}
