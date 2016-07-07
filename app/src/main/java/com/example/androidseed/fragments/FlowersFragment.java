package com.example.androidseed.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidseed.R;
import com.example.androidseed.models.Flower;
import com.example.androidseed.networking.FlowerService;
import com.example.androidseed.networking.FlowerServiceImpl;
import com.example.androidseed.ui.FlowerListAdaptor;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * http://services.hanselandpetal.com/feeds/flowers.json
 * http://services.hanselandpetal.com/photos/
 */
public class FlowersFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    @BindView(R.id.flowersList)
    ListView flowerListView;

    @BindView(R.id.refreshButton)
    Button refreshButton;

    // todo: Use a proper DI framework
    FlowerService flowerServiceImpl = new FlowerServiceImpl();
    private ArrayAdapter adapter;
    private FlowerListAdaptor flowerListAdaptor;

    public FlowersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flowers, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        flowerListAdaptor = new FlowerListAdaptor(getContext(), R.layout.flowerlistitem);
        flowerListView.setAdapter(flowerListAdaptor);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    onRefreshButtonPress();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onRefreshButtonPress() throws IOException {
        // atm retrofit classes are leaking to fragments. todo : decouple fragments from retrofit 1) using RX java or 2) Event bus
        flowerServiceImpl.getFlowers().enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                setupUI(response.body());
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {
            }
        });
    }

    private void setupUI(List<Flower> flowers) {
        flowerListAdaptor.clear();
        flowerListAdaptor.addAll(flowers);
        flowerListAdaptor.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
