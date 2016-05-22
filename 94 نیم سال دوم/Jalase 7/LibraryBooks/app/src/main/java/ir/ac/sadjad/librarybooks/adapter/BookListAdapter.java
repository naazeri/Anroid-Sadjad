package ir.ac.sadjad.librarybooks.adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.ac.sadjad.librarybooks.R;

/***
 * Created by reza on 95/2/15.
 ***/
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {
    private List<String> list;

    public BookListAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_booklist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("reza", "onBindViewHolder: " + position);
        String text = list.get(position);
        holder.bookName_textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.bookList_textView_bookName)
        public TextView bookName_textView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            Typeface font = Typeface.createFromAsset(view.getContext().getAssets(), "font/b_yekan.ttf");
            bookName_textView.setTypeface(font);
        }
    }
}