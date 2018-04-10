package cn.lemon.requestactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class ActivitySecond extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = new View(this);
        setContentView(contentView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        contentView.setBackgroundColor(Color.BLUE);
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AnimHelper.dismiss(ActivitySecond.this);
            }
        });
    }
}