package algonquin.cst2335.quiz.Adapters;
/**
 * This class is used to store the top 10 scores of the quiz game.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import algonquin.cst2335.quiz.Activities.QuestionActivity;
import algonquin.cst2335.quiz.Models.SetModel;
import algonquin.cst2335.quiz.R;
import algonquin.cst2335.quiz.databinding.ItemSetsBinding;

/**
 * This class is used to store the top 10 scores of the quiz game.
 * It has two attributes: userName and score.
 * userName is the name of the user who played the game.
 * score is the score of the user.
 *
 * @author Felipe Barbosa Figueira
 *
 * @param userName is the name of the user who played the game.
 * @param context is the score of the user.
 * @param list is the score of the user.
 * @return
 */
public class SetAdapter extends RecyclerView.Adapter<SetAdapter.viewHolder> {


    Context context;
    ArrayList<SetModel> list;

    public SetAdapter(Context context, ArrayList<SetModel> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public SetAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.item_sets,parent,false);

        return new viewHolder(view);
    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
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

    /**
     *
     * @param position The position of the item within the adapter's data set.
     * @return
     */
    public class viewHolder extends RecyclerView.ViewHolder {

        ItemSetsBinding binding;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemSetsBinding.bind(itemView);
        }
    }
}