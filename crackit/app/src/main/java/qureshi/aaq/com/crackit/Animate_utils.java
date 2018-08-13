package qureshi.aaq.com.crackit;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by asheer.qureshi on 2/20/2018.
 */

public class Animate_utils {

    public  static void animate(RecyclerView.ViewHolder holder,boolean isgodown) {

        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animatery = ObjectAnimator.ofFloat(holder.itemView, "translationY", isgodown ? 300 : -300, 0);
        ObjectAnimator animaterx = ObjectAnimator.ofFloat(holder.itemView, "translationX", -50, 50, -20, 20, -5, 5,0);
        animatery.setDuration(1000);
       animaterx.setDuration(1000);
        set.playTogether(animaterx,animatery);
        set.start();
    }

}
