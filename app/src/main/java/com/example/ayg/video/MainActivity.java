package com.example.ayg.video;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;
    private Button btn_start;
    private Button btn_pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private void bindViews() {
        videoView = (VideoView) findViewById(R.id.videoView);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_pause = (Button) findViewById(R.id.btn_pause);
        btn_start.setOnClickListener(this);
        btn_pause.setOnClickListener(this);

        //根据文件路径播放
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            videoView.setVideoPath(Environment.getExternalStorageDirectory() + "/test.mp4");
        }
        //ListView和Adapter没有做出来，已删，设计先扫描SD卡中的所有视频文件后用Adapter送到ListView中

        //读取放在raw目录下的文件
        videoView.setVideoURI(Uri.parse("android.resource://com.example.ayg.video/" + R.raw.test));
        videoView.setMediaController(new MediaController(this));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_listViewId:
                videoView.start();
                break;
            case R.id.btn_start:
                videoView.start();
                break;
            case R.id.btn_pause:
                videoView.pause();
                break;
        }
    }
}