package ch.heig_vd.iict.sym_exercice2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import ch.heig_vd.iict.sym_exercice2.R;
import ch.heig_vd.iict.sym_exercice2.adapters.AdapterExecutorPool;
import ch.heig_vd.iict.sym_exercice2.adapters.AdapterAsyncTasks;
import ch.heig_vd.iict.sym_exercice2.adapters.AdapterResources;
import ch.heig_vd.iict.sym_exercice2.adapters.BaseImageAdapter;

/**
 * A fragment representing a list of Items
 */
public class ImageFragment extends Fragment {

    private static final String TAG = ImageFragment.class.getSimpleName();

    private static final String ARG_TYPE_KEY = "type";
    public enum Type {
        RESOURCES,
        //SIMPLE_THREAD,
        ASYNCTASK,
        THREAD_EXECUTOR
    }

    private Type type = null;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ImageFragment() {
        type = Type.RESOURCES; //by default
    }

    public static ImageFragment newInstance(Type type) {
        ImageFragment fragment = new ImageFragment();
        Bundle data = new Bundle();
        data.putSerializable(ARG_TYPE_KEY, type);
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null && getArguments().containsKey(ARG_TYPE_KEY)) {
            this.type = (Type) getArguments().getSerializable(ARG_TYPE_KEY);
        }
        Log.d(TAG, "onCreate() with type: " + type.name());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        BaseImageAdapter adapter = null;
        switch(type) {
            default:
            case RESOURCES:
                adapter = new AdapterResources(getContext());
                break;
            case ASYNCTASK:
                adapter = new AdapterAsyncTasks(getContext());
                break;
            case THREAD_EXECUTOR:
                adapter = new AdapterExecutorPool(getContext());
                break;
        }

        ((GridView) view.findViewById(R.id.image_grid)).setAdapter(adapter);

        return view;
    }

}
