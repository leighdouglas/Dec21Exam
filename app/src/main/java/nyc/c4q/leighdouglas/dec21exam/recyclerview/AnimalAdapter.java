package nyc.c4q.leighdouglas.dec21exam.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.dec21exam.R;
import nyc.c4q.leighdouglas.dec21exam.model.Animal;

/**
 * Created by leighdouglas on 12/21/16.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    List<Animal> mAnimalList = new ArrayList<>();

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_viewholder, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal animal = mAnimalList.get(position);
        holder.bind(animal);

    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }


    public void setmAnimalList(List<Animal> list) {
        mAnimalList = list;
        notifyDataSetChanged();
    }
}
