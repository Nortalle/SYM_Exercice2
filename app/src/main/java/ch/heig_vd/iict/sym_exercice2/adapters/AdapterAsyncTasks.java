package ch.heig_vd.iict.sym_exercice2.adapters;

import android.content.Context;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

/**
 * Created by Fabien on 25.10.2016.
 */

public class AdapterAsyncTasks extends BaseImageAdapter<Void> {

    private static final String TAG = AdapterAsyncTasks.class.getSimpleName();

    public AdapterAsyncTasks(Context context) {
        super(context);
    }

    @Override
    protected void initView(View view, int position) {
        final ViewHolder<AsyncTask> holder = (ViewHolder<AsyncTask>) view.getTag(); //specify type
        if(holder == null) {
            Log.e(TAG, "ViewHolder is null");
            return;
        }

        /* TODO implementation with Asynctask */

    }

}
