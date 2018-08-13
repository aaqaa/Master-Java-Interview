package qureshi.aaq.com.crackit;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;


public class MenuFragment extends Fragment {
    Context c;
    private FragmentManager fm;
    private RecyclerView recyclerView;
    private Recycler_view_adapter rvAdapter;
    private List<String> titleList;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        this.titleList = Arrays.asList(getResources().getStringArray(R.array.Titles));
        this.rvAdapter = new Recycler_view_adapter(this.titleList);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(this.rvAdapter);
        this.recyclerView.addOnItemTouchListener(new Recycler_view_clickListner(getActivity().getApplicationContext(), this.recyclerView, new Recycler_view_clickListner.OnItemClickListener() {
            public void onItemClick(View view, int position) {
                fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.menu_fragment, new Basic_fragment(position)).addToBackStack(null).commit();
            }

            public void onItemLongClick(View view, int position) {
            }
        }));

    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_fragment, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().finish();
    }
}
