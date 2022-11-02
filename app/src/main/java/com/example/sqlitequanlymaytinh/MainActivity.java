package com.example.sqlitequanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = openOrCreateDatabase("quanlymaytinh.db", MODE_PRIVATE, null);

        if (!isTableExists(database,"category")){
            doCreateDB(database);
        }

        ConstraintLayout bt1 = (ConstraintLayout) findViewById(R.id.constraintLayout);
        ConstraintLayout bt2 = (ConstraintLayout) findViewById(R.id.constraintLayout2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"bang loai co ton tai "+(isTableExists(database,"category")),Toast.LENGTH_SHORT).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"bang may tinh co ton tai "+(isTableExists(database,"computer")),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean isTableExists(SQLiteDatabase database, String tableName) {
        Cursor cursor = database.rawQuery("select DISTINCT tbl_name " +
                "from sqlite_master where tbl_name = '"+tableName+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

    public void doCreateDB(SQLiteDatabase database) {

//        doCreateCategoryTable
        String sqlcategory = "Create table category (maloai TEXT primary key, tenloai TEXT)";
        database.execSQL(sqlcategory);

//        doCreateComputerTable
        String sqlcomputer = "CREATE TABLE computer (" +
                "mamt TEXT PRIMARY KEY, " +
                "cpu TEXT, " +
                "ram TEXT,  " +
                "maloai TEXT NOT NULL " +
                "CONSTRAINT maloai REFERENCES category(maloai) ON DELETE CASCADE) ";
        database.execSQL(sqlcomputer);

//        doInsertCategory
        ContentValues valuescategory = new ContentValues();
        valuescategory.put("maloai","LT");
        valuescategory.put("tenloai","Laptop cầm tay");
        if (database.insert("category",null,valuescategory) == -1) {
            Toast.makeText(this, "Fail to insert record", Toast.LENGTH_SHORT).show();
        }

//        doInsertComputer
        ContentValues valuescomputer = new ContentValues();
        valuescomputer.put("mamt","Laptop asus tuf");
        valuescomputer.put("cpu","I5 9000");
        valuescomputer.put("ram","8GB");
        valuescomputer.put("maloai","LT");
        if (database.insert("computer",null,valuescomputer) == -1) {
            Toast.makeText(this, "Fail to insert record", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(MainActivity.this,"chen thanh cong",Toast.LENGTH_SHORT).show();

    }

//    public void updateLopName(String malop,String new_tenlop)
//    {
//        ContentValues values=new ContentValues();
//        values.put("tenlop", new_tenlop);
//        String msg="";
//        int ret=database.update("tbllop", values,
//                "malop=?", new String[]{malop});
//        if(ret==0){
//            msg="Failed to update";
//        }
//        else{
//            msg="updating is successful";
//        }
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
//    }
    //    public void dodeleteDB() {
//        String msg = "";
//        if (deleteDatabase("qlsinhvien.db") == true) {
//            msg = "Delete database [qlsinhvien.db] is successful";
//        } else {
//            msg = "Delete database [qlsinhvien.db] is failed";
//        }
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//    }

//    public void XoaTableLop(){
//        database.delete("tblop",null,null);
//        //xoa toan bo bang
//    }
//
//    public void XoaTableLop(String id){
//        database.delete("tblop","malop =?",new String[]{id});
//        //xoa theo
//    }
}