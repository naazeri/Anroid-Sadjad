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
    private View.OnClickListener clickListener;

    public ListAdapter(int rowLayout, List<String> list, View.OnClickListener clickListener) {
        this.rowLayout = rowLayout;
        this.list = list;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        view.setOnClickListener(clickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Log.d("ListLogs", "onBindViewHolder: " + position);

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

        public ViewHolder(View view, View.OnClickListener clickListener) {
            super(view);
            textView = (TextView) view.findViewById(R.id.list_textView_myText);
            textView.setOnClickListener(clickListener);
        }
    }
}