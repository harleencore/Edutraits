package harleen.tutorassist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.MyViewHolder> {

    private Context context;
    private List<Student> studentList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, level;
        public ImageView thumbnail;

        public MyViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.name);
            level = view.findViewById(R.id.level);
            thumbnail = view.findViewById(R.id.thumbnail);
        }
    }

    public StudentsAdapter(Context context, List<Student> studentList){
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position){
        Student student = studentList.get(position);
        holder.name.setText(student.getName());
        holder.level.setText(student.getLevel());

        //loading student pictures with Glide library
        Glide.with(context).load(student.getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


}
