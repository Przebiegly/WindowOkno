package com.example.windowokno;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final ArrayList<Task> taskList;
    private final OnTaskClickListener onTaskClickListener;

    public TaskAdapter(ArrayList<Task> taskList, OnTaskClickListener onTaskClickListener) {
        this.taskList = taskList;
        this.onTaskClickListener = onTaskClickListener;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.bind(task, position);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        private final TextView taskTitle;
        private final TextView taskDescription;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.task_name);
            taskDescription = itemView.findViewById(R.id.task_description);
        }

        public void bind(Task task, int position) {
            taskTitle.setText(task.getTitle());
            taskDescription.setText(task.getDescription());
            itemView.setOnClickListener(view -> onTaskClickListener.onTaskClick(position));
        }
    }

    public interface OnTaskClickListener {
        void onTaskClick(int position);
    }
}
