package com.example.moonmayor.livemaps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ErrandListFragment extends Fragment implements ValueEventListener {
    @BindView(R.id.errands)
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ErrandAdapter errandAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_errand_list, container, false);

        ButterKnife.bind(this, root);

        DatabaseReference errands = FirebaseDatabase.getInstance().getReference("errands");
        errands.addValueEventListener(this);

        boolean isTwoPane = false;
        if (root.findViewById(R.id.map_fragment_container) != null) {
            isTwoPane = true;
        }

        linearLayoutManager = new LinearLayoutManager(getContext());
        errandAdapter = new ErrandAdapter(this, isTwoPane);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(errandAdapter);

        return root;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Errand> errands = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            errands.add(Errand.fromSnapshot(snapshot));
        }
        errandAdapter.errands = errands;
        errandAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}

