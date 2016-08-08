package ir.ac.sadjad.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Model> list;
    private int rowLayout;
    private View.OnLongClickListener longClickListener;
    private View.OnClickListener clickListener;

    public ListAdapter(int rowLayout, List<Model> list, View.OnLongClickListener longClickListener, View.OnClickListener clickListener) {
        this.rowLayout = rowLayout;
        this.list = list;
        this.longClickListener = longClickListener;
        this.clickListener = clickListener;
    }

    public void setList(List<Model> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addItem(Model data) {
        list.add(data);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    public void removeItem(Model model) {
        list.remove(model);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        view.setOnLongClickListener(longClickListener);
        view.setOnClickListener(clickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model model = list.get(position);
        holder.textView.setText(model.getBookName());
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