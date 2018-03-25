package com.example.asusx453sa.muhammadridwan_1202154212_studycase5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


//    ListView listView;
//    AlertDialog.Builder dialog;
//    List<Data> itemList = new ArrayList<>();
//    Adapter adapter;
//    DataHelper SQLite = new DataHelper(this);

    private RecyclerView recyclerView;
    private SQLiteDatabase tampil;
    private DataHelper dataHelper;
    private List<Data> userList;
    TodoAdapter userAdapter;
    protected Cursor cursor;
    protected RecyclerView.LayoutManager mLayoutManager;


    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_ADDRESS = "deskripsi";
    public static final String TAG_JUMLAH = "jumlah";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // listView = (ListView) findViewById(R.id.list_view);

        dataHelper  =  new DataHelper(getApplicationContext());
        tampil      = dataHelper.getReadableDatabase();

        recyclerView                = (RecyclerView) findViewById(R.id.RCview);
        userList                    = new ArrayList<>();
        userAdapter                 = new TodoAdapter(userList);

        mLayoutManager              = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(userAdapter);




        dataUser();
        setSwipeForRecyclerView();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this,input_data.class);
                startActivity(a);
            }
        });
    }

    private void setSwipeForRecyclerView() {
        SwipeUtilDelete swipeHelper = new SwipeUtilDelete(0, ItemTouchHelper.LEFT, this) {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                TodoAdapter adapter = (TodoAdapter) recyclerView.getAdapter();

                dataHelper.delete(Integer.parseInt(userList.get(position).getId()));

                userList.clear();
                dataUser();
                userAdapter.notifyDataSetChanged();
            }
        };

        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(swipeHelper);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        swipeHelper.setLeftcolorCode(ContextCompat.getColor(this, R.color.colorRed));
    }

    private void dataUser() {

//        cursor     = tampil.rawQuery("SELECT * FROM crud", null);
//
//        for (int i = 0; i < cursor.getCount(); i++) {
//            cursor.moveToNext();
//            Data user = new Data(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
//            userList.add(user);
//        }

        ArrayList<HashMap<String, String>> row = dataHelper.getAllData();
        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(TAG_ID);
            String poster = row.get(i).get(TAG_NAME);
            String title = row.get(i).get(TAG_ADDRESS);
            String jumlah = row.get(i).get(TAG_JUMLAH);

            Data data = new Data();

            data.setId(id);
            data.setName(poster);
            data.setDeskripsi(title);
            data.setJumlah(jumlah);

            userList.add(data);
        }

        userAdapter.notifyDataSetChanged();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        userList.clear();
//        dataUser();
//   }


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
}
