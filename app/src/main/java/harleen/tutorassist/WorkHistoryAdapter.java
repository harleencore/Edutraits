package harleen.tutorassist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class WorkHistoryAdapter extends RecyclerView.Adapter<WorkHistoryAdapter.ViewHolder> {

    private Context context;
    private List<WorkHistoryUtils> workHistoryUtils;

    public WorkHistoryAdapter(Context context, List personUtils) {
        this.context = context;
        this.workHistoryUtils = personUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.work_history_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(workHistoryUtils.get(position));

        WorkHistoryUtils wh = workHistoryUtils.get(position);

        holder.workname.setText(wh.getWorkname());
        holder.type.setText(wh.getType());

    }

    @Override
    public int getItemCount() {
        return workHistoryUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView workname;
        public TextView type;

        public ViewHolder(View itemView) {
            super(itemView);

            workname = itemView.findViewById(R.id.workname);
            type = itemView.findViewById(R.id.type);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    WorkHistoryUtils cpu = (WorkHistoryUtils) view.getTag();

                    Toast.makeText(view.getContext(), cpu.getWorkname()+  cpu.getType(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

}