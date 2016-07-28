package ir.ac.sadjad.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/***
 * Created by reza on 95/2/15.
 ***/
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<String> list;
    private int rowLayout;

    public ListAdapter(int rowLayout, List<String> list) {
        this.rowLayout = rowLayout;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Log.d("ListLogs", "onBindViewHolder: " + position);

        String data = list.get(position);
        holder.textView.setText(data);
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
    }
}