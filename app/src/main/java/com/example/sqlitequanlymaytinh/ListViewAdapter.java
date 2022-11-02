package com.example.sqlitequanlymaytinh;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Book> itemList;

    public ListViewAdapter(Context context, int layout, List<Book> itemList) {
        this.context = context;
        this.layout = layout;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView ten,cpu,ram,loai;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            //ánh xạ view
            holder.ten = view.findViewById(R.id.nameitem);
            holder.cpu = view.findViewById(R.id.cpuitem);
            holder.ram = view.findViewById(R.id.ramitem);
            holder.loai = view.findViewById(R.id.categoryitem);
            view.setTag(holder);
        }
        else {
            holder=(ViewHolder) view.getTag();
        }
        Book book = itemList.get(i);
        holder.ten.setText(book.getTen());
        holder.cpu.setText(book.getCpu());
        holder.ram.setText(book.getRam());
        holder.loai.setText(book.getLoai());
        return view;
    }
}
