package ch.heig_vd.iict.sym_exercice2.adapters;

import android.content.Context;

import android.util.Log;
import android.view.View;

import java.util.concurrent.Future;

/**
 * Created by Fabien on 26.10.2016.
 */

public class AdapterExecutorPool extends BaseImageAdapter<Future> {

    private static final String TAG = AdapterExecutorPool.class.getSimpleName();

    public AdapterExecutorPool(Context context) {
        super(context);
    }

    @Override
    protected void initView(View view, int position) {
        final ViewHolder<Future> holder = (ViewHolder<Future>) view.getTag();
        if(holder == null) {
            Log.e(TAG, "ViewHolder is null");
            return;
        }

        /* TODO implementation with ThreadPoolExecutor */

    }
}
