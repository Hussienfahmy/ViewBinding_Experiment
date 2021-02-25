package android.example.viewbindingexperiment;

import android.example.viewbindingexperiment.databinding.RowItemBinding;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter_ViewBinding_Solution_2 extends RecyclerView.Adapter<MyAdapter_ViewBinding_Solution_2.ViewHolder> {

    private final List<Model> modelList;

    public MyAdapter_ViewBinding_Solution_2(List<Model> modelList) {
        setHasStableIds(true);
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RowItemBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = modelList.get(position);

        holder.binding.rowTitle.setText(model.getTitle());

        if (model.isClicked){
            holder.binding.rowItemLayout.setBackgroundColor(Color.GREEN);
        }else {
            holder.binding.rowItemLayout.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return modelList.get(position).getId();
    }

    @Override
    public long getItemId(int position) {
        return modelList.get(position).getId();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RowItemBinding binding;

        public ViewHolder(@NonNull RowItemBinding b) {
            super(b.getRoot());
            binding = b;

            binding.rowItemLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Model model = modelList.get(getAdapterPosition());
            model.setClicked(!model.isClicked);
            notifyDataSetChanged();
        }
    }
}