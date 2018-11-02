package com.example.yajch.photogallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // Image title and id arrays
    // private final String image_titles[] = {"android1", "android2", "android3"};
    private final Integer image_IDs[] = {R.drawable.android1, R.drawable.android2, R.drawable.android3,
            R.drawable.android4, R.drawable.android5, R.drawable.android6,
            R.drawable.android7, R.drawable.android8, R.drawable.android9,
            R.drawable.android10, R.drawable.android11, R.drawable.android12,
            R.drawable.android22,
            R.drawable.android7, R.drawable.android8, R.drawable.android9,
            R.drawable.android10, R.drawable.android11, R.drawable.android12,
            R.drawable.android22, R.drawable.android1, R.drawable.android2, R.drawable.android3,
            R.drawable.android4, R.drawable.android5, R.drawable.android6,};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates the recycler view used to create as many image views as needed
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Cell> cells = prepareData();
        MyAdapter adapter = new MyAdapter(getApplicationContext(), cells);
        recyclerView.setAdapter(adapter);
    }

    // Function to put the images into the 'cells', the small image views
    private ArrayList<Cell> prepareData()
    {
        ArrayList<Cell> theImage = new ArrayList<>();
        for(int i = 0; i < image_IDs.length; i++)
        {
            Cell cell = new Cell();
            // cell.setTitle(image_titles[i]);
            cell.setImg(image_IDs[i]);
            theImage.add(cell);
        }

        return theImage;
    }

}
