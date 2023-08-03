package algonquin.cst2335.quiz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import algonquin.cst2335.quiz.Activities.QuestionActivity;
import algonquin.cst2335.quiz.MainActivity;
import algonquin.cst2335.quiz.Models.SetModel;
import algonquin.cst2335.quiz.R;
import algonquin.cst2335.quiz.databinding.ItemSetsBinding;

public class SetAdapter extends RecyclerView.Adapter<SetAdapter.viewHolder> {


    Context context;
    ArrayList<SetModel> list;

    public SetAdapter(Context context, ArrayList<SetModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SetAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.item_sets,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final SetModel model = list.get(position);

        holder.binding.setName.setText(model.getSetNmae());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, QuestionActivity.class);

                intent.putExtra("set",model.getSetNmae());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ItemSetsBinding binding;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemSetsBinding.bind(itemView);
        }
    }
}
