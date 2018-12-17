package com.example.gaurav.comfortzoneserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaurav.comfortzoneserver.Common.Common;
import com.example.gaurav.comfortzoneserver.Interface.ItemClickListener;
import com.example.gaurav.comfortzoneserver.R;

/**
 * Created by Gaurav on 5/17/2018.
 */

public class CourseViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,
        View.OnCreateContextMenuListener



{

    public TextView course_name;
    public ImageView course_image;

    private ItemClickListener itemClickListener;

    public CourseViewHolder(View itemView) {
        super(itemView);

        course_name = (TextView)itemView.findViewById(R.id.course_name);
        course_image = (ImageView)itemView.findViewById(R.id.course_image);

        itemView.setOnCreateContextMenuListener(this);
        itemView.setOnClickListener(this);

    }
    public void setItemClickListener(ItemClickListener itemClickListener) {

        this.itemClickListener = itemClickListener;
    }



    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }


    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        contextMenu.setHeaderTitle("Select the action");

        contextMenu.add(0,0,getAdapterPosition(), Common.UPDATE);
        contextMenu.add(0,1,getAdapterPosition(), Common.DELETE);
    }
}
