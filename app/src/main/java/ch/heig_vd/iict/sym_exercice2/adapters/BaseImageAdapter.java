package ch.heig_vd.iict.sym_exercice2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import ch.heig_vd.iict.sym_exercice2.R;

/**
 * Created by Fabien on 24.10.2016
 */

public abstract class BaseImageAdapter<T> extends BaseAdapter {

    private static final int ITEM_NUMER = 10000;

    private Context context = null;
    private LayoutInflater layoutInflater = null;

    public BaseImageAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ITEM_NUMER;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public View getView(int position, View recycleView, ViewGroup viewGroup) {
        //we inflate a new view only when necessary, otherwise we reuse a recycled view
        if(recycleView == null) {
            recycleView = this.layoutInflater.inflate(R.layout.item_image, viewGroup, false);
        }

        //link to GUI - we store references into holder
        ViewHolder holder = (ViewHolder) recycleView.getTag();
        if(holder == null) {
            holder = new ViewHolder();
            holder.img = recycleView.findViewById(R.id.image_item_img);
            holder.prg = recycleView.findViewById(R.id.image_item_loading);
            holder.txt = recycleView.findViewById(R.id.image_item_txt);
            recycleView.setTag(holder);
        }

        initView(recycleView, position);

        return recycleView;
    }

    public Context getContext() { return context; }

    protected abstract void initView(View view, int position);

    /**
     *  Object used to store items GUI elements references
     */
    protected static class ViewHolder<T> {
        protected ImageView img;
        protected ProgressBar prg;
        protected TextView txt;
        protected T task;
    }

}
