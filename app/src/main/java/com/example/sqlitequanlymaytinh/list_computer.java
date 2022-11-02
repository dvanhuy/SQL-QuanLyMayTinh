package com.example.sqlitequanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        initdata();
        listViewAdapter = new ListViewAdapter(this,R.layout.item_computer,arrayBook);
        listbook.setAdapter(listViewAdapter);
    }

    public void initdata(){
        SQLiteDatabase database = openOrCreateDatabase("quanlymaytinh.db", MODE_PRIVATE, null);
        Cursor cur=database.query("computer", null, null, null, null, null, null);
        cur.moveToFirst();
        arrayBook = new ArrayList();
        while(cur.isAfterLast()==false)
        {
            Book b=new Book();
            b.setTen(cur.getString(0));
            b.setCpu(cur.getString(1));
            b.setRam(cur.getString(2));
            b.setLoai(cur.getString(3));
            arrayBook.add(b);
            cur.moveToNext();
        }
        cur.close();
    }
}