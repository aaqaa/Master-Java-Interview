package qureshi.aaq.com.crackit;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by asheer.qureshi on 2/17/2018.
 */

public class Recycler_view_adapter extends RecyclerView.Adapter<Recycler_view_adapter.MyViewHolder> {

    private List<String> titleList;
    private  int prevpos=0;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText((CharSequence) this.titleList.get(position));
        switch (position){
            case 0:
                holder.image_rv.setImageResource(R.mipmap.one);
                break;
            case 1:
                holder.image_rv.setImageResource(R.mipmap.two);
                break;
            case 2:
                holder.image_rv.setImageResource(R.mipmap.three);
                break;
            case 3:
                holder.image_rv.setImageResource(R.mipmap.four);
                break;
            case 4:
                holder.image_rv.setImageResource(R.mipmap.five);
                break;
            case 5:
                holder.image_rv.setImageResource(R.mipmap.six);
                break;
            case 6:
                holder.image_rv.setImageResource(R.mipmap.seven);
                break;
            case 7:
                holder.image_rv.setImageResource(R.mipmap.eight);
                break;
            case 8:
                holder.image_rv.setImageResource(R.mipmap.nine);
                break;
            case 9:
                holder.image_rv.setImageResource(R.mipmap.ten);
                break;
            case 10:
                holder.image_rv.setImageResource(R.mipmap.eleven);
                break;
            case 11:
                holder.image_rv.setImageResource(R.mipmap.twelve);
                break;
            case 12:
                holder.image_rv.setImageResource(R.mipmap.thirteen);
                break;
            case 13:
                holder.image_rv.setImageResource(R.mipmap.fourteen);
                break;
            case 14:
                holder.image_rv.setImageResource(R.mipmap.fifteen);
                break;





        }
        if(position>prevpos)
            Animate_utils.animate(holder,true);
        else
            Animate_utils.animate(holder,false);
        prevpos=position;


    }

    @Override
    public int getItemCount() {
        return this.titleList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView title;
        public ImageView image_rv;
        public MyViewHolder(View view) {
            super(view);

            this.title = (TextView) view.findViewById(R.id.row_text);
            this.cv = (CardView) view.findViewById(R.id.card_view);
            this.image_rv = (ImageView)view.findViewById(R.id.image_rv);
        }
    }

    public Recycler_view_adapter(List<String> list) {
        this.titleList = list;
    }



}
