package com.superlogico.birraviso.adapter;

/**
 * Created by daniel.benitez on 2/15/2017.
 */


import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.superlogico.birraviso.R;
import com.superlogico.birraviso.model.Beer;
        import java.util.List;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.MyViewHolder> {

    private List<Beer> beerList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public CheckBox checkbox;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            checkbox = (CheckBox) view.findViewById(R.id.chkSelected);
        }
    }


    public BeerAdapter(List<Beer> beerList) {
        this.beerList = beerList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.beer_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Beer beer = beerList.get(position);
        holder.title.setText(beer.getStyle());
        holder.genre.setText(beer.getTrademark());
        holder.year.setText(beer.getName());

        //in some cases, it will prevent unwanted situations
        holder.checkbox.setOnCheckedChangeListener(null);
        holder.checkbox.setChecked(beerList.get(position).isSelected());

        if(beer.isVisible()){
            holder.checkbox.setVisibility(View.VISIBLE);
        }else{
            holder.checkbox.setVisibility(View.INVISIBLE);
        }


        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //set your object's last status
                beer.setSelected(isChecked);
            }
        });

       // holder.id.setText(beer.getId());

    }

    @Override
    public int getItemCount() {

        return beerList.size();
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }
}
