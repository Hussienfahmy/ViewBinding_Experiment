package android.example.viewbindingexperiment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ChipGroup.OnCheckedChangeListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));


        ChipGroup chipGroup = findViewById(R.id.chipGroup);
        chipGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(ChipGroup group, int checkedId) {
        if (checkedId == R.id.chip_holder){
            MyAdapter_Holder adapter = new MyAdapter_Holder(getPopulatedModelList(10));
            recyclerView.setAdapter(adapter);
        }else if (checkedId == R.id.chip_binding){
            MyAdapter_ViewBinding adapter = new MyAdapter_ViewBinding(getPopulatedModelList(10));
            recyclerView.setAdapter(adapter);
        }else if (checkedId == R.id.chip_binding_solution1){
            MyAdapter_ViewBinding_Solution_1 adapter = new MyAdapter_ViewBinding_Solution_1(getPopulatedModelList(10));
            recyclerView.setAdapter(adapter);
        }else if (checkedId == R.id.chip_binding_solution2){
            MyAdapter_ViewBinding_Solution_2 adapter = new MyAdapter_ViewBinding_Solution_2(getPopulatedModelList(10));
            recyclerView.setAdapter(adapter);
        }
    }

    private List<Model> getPopulatedModelList(int count) {
        List<Model> modelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Model model = new Model(i, "Row Number " + i);
            modelList.add(model);
        }
        return modelList;
    }
}