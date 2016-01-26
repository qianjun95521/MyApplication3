package com.example.think.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ActionFragment.OnFragmentInteractionListener{
    //ArrayList<String> sname=new ArrayList<String>();
    //ArrayAdapter<String> aa;
    ArrayList<MyItem> sname=new ArrayList<MyItem>();
    MyArrayAdapter aa;

    ListFragment listFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //ListView listView=(ListView)this.findViewById(R.id.sname);
        listFragment=new ListFragment();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.action_top,new ActionFragment());
        //fragmentTransaction.add(R.id.action_list,listFragment);
        fragmentTransaction.commit();
        sname.add(new MyItem("qianjun","20"));
        aa=new MyArrayAdapter(this,R.layout.todolist_item,sname);
        listFragment.setListAdapter(aa);
        //listView.setAdapter(aa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String name) {


        FragmentManager fragmentManager=getFragmentManager();
        if(fragmentManager.findFragmentById(R.id.action_list)==null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.action_list, listFragment);
            fragmentTransaction.commit();
        }
         sname.add(new MyItem(name,"21"));
        aa.notifyDataSetChanged();
    }

    @Override
    public void openActivity() {
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);
    }
}
