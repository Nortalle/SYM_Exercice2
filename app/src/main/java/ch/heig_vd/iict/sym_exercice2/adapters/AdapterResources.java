package ch.heig_vd.iict.sym_exercice2.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;

/**
 * Created by Fabien on 25.10.2016.
 */

public class AdapterResources extends BaseImageAdapter<Void> {

    private static final String TAG = AdapterResources.class.getSimpleName();

    public AdapterResources(Context context) {
        super(context);
    }

    @Override
    protected void initView(View view, int position) {
        final ViewHolder<Void> holder = (ViewHolder<Void>) view.getTag();
        if(holder == null) {
            Log.e(TAG, "ViewHolder is null");
            return;
        }

        final Integer item = (Integer) getItem(position);

        //we re-init the view
        holder.img.setVisibility(View.GONE);
        holder.prg.setVisibility(View.VISIBLE);
        holder.txt.setText(String.format("%1$d", item));

        //we search resource id
        String imageName = "img_" + position;
        int drawResid = view.getContext().getResources().getIdentifier( imageName,
                                                                        "drawable",
                                                                        view.getContext().getPackageName());

        if(drawResid != -1) {
            //we update the view
            holder.img.setImageResource(drawResid);
            holder.prg.setVisibility(View.GONE);
            holder.img.setVisibility(View.VISIBLE);
        } else {
            Log.w(TAG, "Resource not found: " + imageName);
        }
    }
}
