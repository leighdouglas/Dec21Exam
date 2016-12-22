package nyc.c4q.leighdouglas.dec21exam;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.leighdouglas.dec21exam.model.Animal;

/**
 * Created by leighdouglas on 12/21/16.
 */

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    public AnimalViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.name);
    }

    public void bind(Animal animal){
        textView.setTextColor(Color.parseColor(animal.getTextColor()));
        textView.setHint(animal.getName());
    }
}
