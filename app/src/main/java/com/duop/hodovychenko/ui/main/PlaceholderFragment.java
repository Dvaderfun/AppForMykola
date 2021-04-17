package com.duop.hodovychenko.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.duop.hodovychenko.R;
import com.duop.hodovychenko.model.FoodModel;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private RendererRecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView recyclerView;

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        mRecyclerViewAdapter = new RendererRecyclerViewAdapter();

        mRecyclerViewAdapter.registerRenderer(new ViewRenderer<>(
                R.layout.list_item_food,
                FoodModel.class,
                (model, finder, payloads) -> finder
                        .setImageResource(R.id.image, R.drawable.ramen)
                        .setText(R.id.price, model.getPrice())
                        .setText(R.id.timeToDeliver, model.getTime())
                        .setText(R.id.foodTitle, model.getBarTitle())
                        .setText(R.id.barTitle, model.getBarTitle())
        ));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mRecyclerViewAdapter);

        //ЭТО МЫ ГРУЗИМ С СЕРВЕРА! ТЕСТОВЫЕ ДАННЫЕ, ПОЭТОМУ ТЕКСТ ХАРДКОД
        ArrayList models = new ArrayList<FoodModel>();
        models.add(new FoodModel("Super Noodle", "$5", "-30%", "Super Ramen Food", "30 min", getResources().getDrawable(R.drawable.ramen)));
        models.add(new FoodModel("Super Noodle", "$5", "-30%", "Super Ramen Food", "30 min", getResources().getDrawable(R.drawable.ramen)));
        models.add(new FoodModel("Super Noodle", "$5", "-30%", "Super Ramen Food", "30 min", getResources().getDrawable(R.drawable.ramen)));
        models.add(new FoodModel("Super Noodle", "$5", "-30%", "Super Ramen Food", "30 min", getResources().getDrawable(R.drawable.ramen)));
        models.add(new FoodModel("Super Noodle", "$5", "-30%", "Super Ramen Food", "30 min", getResources().getDrawable(R.drawable.ramen)));
        models.add(new FoodModel("Super Noodle", "$5", "-30%", "Super Ramen Food", "30 min", getResources().getDrawable(R.drawable.ramen)));

        mRecyclerViewAdapter.setItems(models);
        mRecyclerViewAdapter.notifyDataSetChanged();

        return root;
    }
}