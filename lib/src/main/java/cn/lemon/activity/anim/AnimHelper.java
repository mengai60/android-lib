package cn.lemon.activity.anim;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;

import cn.lemon.androidlib.R;

public class AnimHelper {

    public static ActivityOptionsCompat push(Activity activity, Class<?> cla, boolean directStart) {
        ActivityOptionsCompat aoc = ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.activity_push_in, R.anim.activity_push_out);
        if (directStart) {
            ActivityCompat.startActivity(activity, new Intent(activity, cla), aoc.toBundle());
        }
        return aoc;
    }

    public static ActivityOptionsCompat present(Activity activity, Class<?> cla, boolean directStart) {
        ActivityOptionsCompat aoc = ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.activity_present_in, R.anim.activity_present_out);
        if (directStart) {
            ActivityCompat.startActivity(activity, new Intent(activity, cla), aoc.toBundle());
        }
        return aoc;
    }

    public static void finish(AppCompatActivity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

}
