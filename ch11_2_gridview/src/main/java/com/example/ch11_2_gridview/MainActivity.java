package com.example.ch11_2_gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);

        MyGridAdapter gAdapter = new MyGridAdapter(this);

        gv.setAdapter(gAdapter);
    }

    class MyGridAdapter extends BaseAdapter{

//        AppCompatActivity act1;
//
//        public MyGridAdapter(AppCompatActivity act1) {
//            this.act1 = act1;
//        }
//2번: 데이터
    Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
            R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
            R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
            R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10 };

        String[] posterTitle = { "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자",
                "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처", "써니", "완득이", "괴물", "라디오스타",
                "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처", "써니", "완득이",
                "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이",
                "빽투더퓨처", "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드",
                "웰컴투동막골", "헬보이", "빽투더퓨처" };


        Context c;

        public MyGridAdapter(Context c) {
            this.c = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override//3번 1칸의 디자인 만들기(커스텀 디자인)
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView iv1 = new ImageView(c);
            iv1.setLayoutParams(new ViewGroup.LayoutParams(200,300));
            iv1.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv1.setImageResource(posterID[position]);

            iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    View view1 = View.inflate(c,R.layout.dialog1,null);

                    ImageView iv2 = view1.findViewById(R.id.ivPoster);
                    iv2.setImageResource(posterID[position]);

                    AlertDialog.Builder dlg = new AlertDialog.Builder(c);

                    dlg.setTitle(posterTitle[position]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(view1);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();

                }
            });

            return iv1;
        }
    }


}
