package ir.ac.sadjad.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<String> list;
    private int rowLayout;
    private View.OnLongClickListener longClickListener;

    public ListAdapter(int rowLayout, List<String> list, View.OnLongClickListener longClickListener) {
        this.rowLayout = rowLayout;
        this.list = list;
        this.longClickListener = longClickListener;
    }

    public void addItem(String data) {
        list.add(data);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        view.setOnLongClickListener(longClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String book = list.get(position);
        holder.textView.setText(book);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.list_textView_myText);
        }

        public ViewHolder(View view, View.OnLongClickListener longClickListener) {
            super(view);
            textView = (TextView) view.findViewById(R.id.list_textView_myText);
            textView.setOnLongClickListener(longClickListener);
        }
    }
}