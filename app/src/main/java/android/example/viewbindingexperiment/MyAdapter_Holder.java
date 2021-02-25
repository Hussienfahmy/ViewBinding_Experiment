package android.example.viewbindingexperiment;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter_Holder extends RecyclerView.Adapter<MyAdapter_Holder.ViewHolder> {

    private final List<Model> modelList;

    public MyAdapter_Holder(List<Model> modelList) {
        setHasStableIds(true);
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = modelList.get(position);
        holder.title.setText(model.getTitle());

        if (model.isClicked){
            holder.row_item_layout.setBackgroundColor(Color.GREEN);
        }else {
            holder.row_item_layout.setBackgroundColor(Color.WHITE);
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

        TextView title;
        LinearLayout row_item_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.row_title);
            row_item_layout = itemView.findViewById(R.id.row_item_layout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Model model = modelList.get(getAdapterPosition());
            model.setClicked(!model.isClicked);
            notifyDataSetChanged();
        }
    }
}