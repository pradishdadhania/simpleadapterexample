package com.example.simpleadapterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView simpleListView;
    String[] fruitsNames = {"Apple", "Banana", "Litchi", "Mango", "PineApple"};//fruit names array
    int[] fruitsImages = {R.drawable.apple,
            R.drawable.banana,
            R.drawable.litchi,
            R.drawable.mango,
            R.drawable.pineapple};//fruits images


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleListView=(ListView)findViewById(R.id.simpleListView);
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<fruitsNames.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",fruitsNames[i]);
            hashMap.put("image",fruitsImages[i]+"");
            arrayList.add(hashMap);//add the hashmap into arrayList
        }

        String[] from={"name","image"};//string array
        int[] to={R.id.textView,R.id.imageView};//int array of views id's

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);//Create object and set the parameters for simpleAdapter https://abhiandroid.com/ui/simpleadapter.html
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),fruitsNames[i],Toast.LENGTH_LONG).show();//show the selected image in toast according to position
            }
        });
    }

    //Manu
    // Overriding onCreateoptionMenu() to make Option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflating menu by overriding inflate() method of MenuInflater class.
        //Inflating here means parsing layout XML to views.
        getMenuInflater().inflate(R.menu.deptmenu, menu);
        return true;
    }
    //Overriding onOptionsItemSelected to perform event on menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Toast.makeText(this, "You chose : " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
        switch (menuItem.getItemId()) {
            case R.id.search:
                //Your code here
                Intent i=new Intent(MainActivity.this, TextCompleteView.class);
                startActivity(i);
                return true;
            case R.id.filter:
                //Your code here
                return true;
            case R.id.wishlist:
                //Your code here
                return true;
            case R.id.MyCart:
                //Your code here
                return true;
            case R.id.My_account:
                //Your code here
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }



}