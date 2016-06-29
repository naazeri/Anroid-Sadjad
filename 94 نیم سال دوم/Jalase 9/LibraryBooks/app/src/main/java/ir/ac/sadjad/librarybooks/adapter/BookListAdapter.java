package ir.ac.sadjad.librarybooks.adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ir.ac.sadjad.librarybooks.R;
import ir.ac.sadjad.librarybooks.model.ModelBook;

/***
 * Created by reza on 95/2/15.
 ***/
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {
    private List<ModelBook> list;
    private int layoutId;

    public BookListAdapter(List<ModelBook> list, int layoutId) {
        this.list = list;
        this.layoutId = layoutId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Log.d("reza", "onBindViewHolder: " + position);
        ModelBook book = list.get(position);
        holder.bookName_textView.setText(book.getBookName());
        holder.count_textView.setText(book.getCount().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setModel(List<ModelBook> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.bookList_textView_bookName)
        public TextView bookName_textView;
        @Bind(R.id.bookList_textView_count)
        public TextView count_textView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            Typeface font = Typeface.createFromAsset(view.getContext().getAssets(), "font/b_yekan.ttf");
            bookName_textView.setTypeface(font);
            count_textView.setTypeface(font);
        }
    }
}