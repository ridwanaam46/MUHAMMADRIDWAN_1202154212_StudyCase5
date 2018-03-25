package com.example.asusx453sa.muhammadridwan_1202154212_studycase5;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class input_data extends AppCompatActivity {

    private EditText a, b,c;
    private Button d;
    private SQLiteDatabase tulis;
    TodoAdapter userAdapter;
    List<Data> userList;

    DataHelper sqlite = new DataHelper(this);

    String nama,desk,jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        a = (EditText) findViewById(R.id.namatodo);
        b = (EditText) findViewById(R.id.deskripsi);
        c = (EditText) findViewById(R.id.priority);
        tulis       = sqlite.getWritableDatabase();

        userList                    = new ArrayList<>();
        userAdapter                 = new TodoAdapter(userList);


        d = (Button) findViewById(R.id.tambahtodo);

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void save() {

        if (String.valueOf(a.getText()).equals(null) || String.valueOf(b.getText()).equals("") ||
                String.valueOf(c.getText()).equals(null) || String.valueOf(c.getText()).equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please input name or address ...", Toast.LENGTH_SHORT).show();
        } else {
            sqlite.insert(a.getText().toString().trim(), b.getText().toString().trim(),c.getText().toString().trim());
            blank();
            Intent a = new Intent(input_data.this,MainActivity.class);
            startActivity(a);

//            tulis.execSQL("INSERT INTO modul5 (nama,deskripsi,jumlah) VALUES ('"+a.getText()+"', '"+b.getText()+"', '"+c.getText()+"')");
//            Toast.makeText(Input.this, "Berhasil", Toast.LENGTH_SHORT).show();
//            userAdapter.notifyDataSetChanged();
//            Intent a = new Intent (Input.this,MainActivity.class);
//            startActivity(a);
        }
    }

    private void blank() {
        a.requestFocus();
        a.setText(null);
        b.setText(null);
        c.setText(null);
    }
}
