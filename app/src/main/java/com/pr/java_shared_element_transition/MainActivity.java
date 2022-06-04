package com.pr.java_shared_element_transition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String > namearraylist;
    ArrayList<Integer> imagearraylist;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview1);

        namearraylist=new ArrayList<>();
        imagearraylist=new ArrayList<>();


        namearraylist.add("Red");
        namearraylist.add("Invoker");
        namearraylist.add("Storm");
        namearraylist.add("Invoker 2");

        imagearraylist.add(R.drawable.red);
        imagearraylist.add(R.drawable.voker);
        imagearraylist.add(R.drawable.torm);
        imagearraylist.add(R.drawable.ertetretr);
        myAdapter=new MyAdapter(MainActivity.this,namearraylist,imagearraylist);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        recyclerView.setAdapter(myAdapter);


    }
}