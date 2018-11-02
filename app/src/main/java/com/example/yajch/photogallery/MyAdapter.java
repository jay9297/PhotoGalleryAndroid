package com.example.yajch.photogallery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private ArrayList<Cell> galleryList;
    private Context context;

    public MyAdapter(Context context, ArrayList<Cell>galleryList)
    {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder viewHolder, final int i)
    {
        // Set up the individual photo views
        // viewHolder.title.setText(galleryList.get(i).getTitle());
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.img.setImageResource(galleryList.get(i).getImg());
        viewHolder.img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Displays the image title on tapping the image -- This is where the fullscreen on tap functionality should go
                // Toast.makeText(context, "" + galleryList.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                final Intent zoomIntent = new Intent (context, ZoomActivity.class);
                int imageID = galleryList.get(i).getImg();
                zoomIntent.putExtra("thisImage", imageID);
                context.startActivity(zoomIntent);
                // Displays the image title on tapping the image -- This is where the fullscreen on tap functionality should go
                // Toast.makeText(context, "" + galleryList.get(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Tells how many cells we need to create to hold the images
    @Override
    public int getItemCount()
    {
        return galleryList.size();
    }

    // Creates the ImageViews for the images
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title;
        private ImageView img;
        public ViewHolder(View view)
        {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            img = (ImageView) view.findViewById(R.id.img);
        }
    }
}
