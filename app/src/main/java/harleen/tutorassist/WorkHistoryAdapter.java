package harleen.tutorassist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class WorkHistoryAdapter extends RecyclerView.Adapter<WorkHistoryAdapter.MyViewHolder> {

    private Context context;
    private List<WorkHistoryItem> workHistList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, type, durn, rating;

        public MyViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.title);
            type = view.findViewById(R.id.type);
            durn = view.findViewById(R.id.durn);
            rating = view.findViewById(R.id.rating);
        }
    }

    public WorkHistoryAdapter(Context context, List<WorkHistoryItem> workHistList){
        this.context = context;
        this.workHistList = workHistList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.work_history_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position){
        WorkHistoryItem workHistoryItem = workHistList.get(position);
        holder.title.setText(workHistoryItem.getTitle());
        holder.type.setText(workHistoryItem.getType());
        holder.durn.setText(Integer.toString(workHistoryItem.getDurn()));
        holder.rating.setText(Integer.toString(workHistoryItem.getRating()));


    }

    @Override
    public int getItemCount() {
        return workHistList.size();
    }


}
