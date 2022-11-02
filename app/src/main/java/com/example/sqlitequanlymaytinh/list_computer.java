package com.example.sqlitequanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class list_computer extends AppCompatActivity {

    ListView listbook;
    ArrayList<Book> arrayBook;
    ListViewAdapter listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_computer);
        listbook = findViewById(R.id.listbook);
        //lấy dữ liệu
        arrayBook = new ArrayList<>();

        listViewAdapter = new ListViewAdapter(this,R.layout.item_computer,arrayBook);
        listbook.setAdapter(listViewAdapter);
    }
}