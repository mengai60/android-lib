package cn.lemon.activity.anim;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import cn.lemon.androidlib.R;

public class AnimHelper {

    public static ActivityOptionsCompat pushAnim(Activity activity) {
        return ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.activity_push_in, R.anim.activity_push_out);
    }

    public static void push(Activity activity, Class<?> cla) {
        ActivityOptionsCompat aoc = pushAnim(activity);
        ActivityCompat.startActivity(activity, new Intent(activity, cla), aoc.toBundle());
    }

    public static void pop(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.activity_pop_in, R.anim.activity_pop_out);
    }

    public static ActivityOptionsCompat presentAnim(Activity activity) {
        return ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.activity_present_in, R.anim.activity_present_out);
    }

    public static void present(Activity activity, Class<?> cla) {
        ActivityOptionsCompat aoc = presentAnim(activity);
        ActivityCompat.startActivity(activity, new Intent(activity, cla), aoc.toBundle());
    }

    public static void dismiss(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.activity_dismiss_in, R.anim.activity_dismiss_out);
    }

    public static ActivityOptionsCompat alphaAnim(Activity activity) {
        return ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.activity_alpha_in, R.anim.activity_alpha_out);
    }

    public static void alpha(Activity activity, Class<?> cla) {
        ActivityOptionsCompat aoc = alphaAnim(activity);
        ActivityCompat.startActivity(activity, new Intent(activity, cla), aoc.toBundle());
    }

    public static ActivityOptionsCompat centerAlphaAnim(Activity activity) {
        return ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.activity_center_in, R.anim.activity_center_out);
    }

    public static void centerAlpha(Activity activity, Class<?> cla) {
        ActivityOptionsCompat aoc = centerAlphaAnim(activity);
        ActivityCompat.startActivity(activity, new Intent(activity, cla), aoc.toBundle());
    }

}
