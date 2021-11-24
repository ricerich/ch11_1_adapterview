package com.example.ch11_2_gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);

        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {

        Context context;
        Integer[] posterID = { R.drawable.mov11, R.drawable.mov12,
                R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
                R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
                R.drawable.mov19, R.drawable.mov20 };

        String[] posterTitle = { "여인의 향기", "쥬라기 공원", "포레스트 검프", "사랑의 블랙홀",
                "혹성탈출", "아름다운비행", "내이름은 칸", "해리포터", "마더", "킹콩을 들다" };


        public MyGalleryAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);
            imageview.setImageResource(posterID[position]);

            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView iv1 = findViewById(R.id.ivPoster);
                    iv1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    iv1.setImageResource(posterID[position]);


                    //토스트 띄우기, 비슷한게 2번그리드에서 다이얼로그 띄우기
                    View view1 = View.inflate(context,R.layout.toast1,null);
                    Toast toast1 = new Toast(context);
//                    toast1.setText(posterTitle[position]);//이렇게 하면 안됨!
//
                    TextView tv1 = view1.findViewById(R.id.tv1);
                    tv1.setText(posterTitle[position]);

                    toast1.setView(view1);
                    toast1.show();

                }
            });

//            final int pos = position;
//            imageview.setOnTouchListener(new View.OnTouchListener() {
//                public boolean onTouch(View v, MotionEvent event) {
//                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
//                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                    ivPoster.setImageResource(posterID[pos]);
//                    return false;
//                }
//            });

            return imageview;
        }
    }
}
