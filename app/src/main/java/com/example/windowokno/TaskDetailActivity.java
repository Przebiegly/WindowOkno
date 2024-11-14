package com.example.windowokno;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private Task task;
    private int taskPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        Button buttonSave = findViewById(R.id.buttonSave);

        Intent intent = getIntent();
        task = (Task) intent.getSerializableExtra("task");
        taskPosition = intent.getIntExtra("position", -1);

        if (task != null) {
            editTextTitle.setText(task.getTitle());
            editTextDescription.setText(task.getDescription());
        }

        buttonSave.setOnClickListener(view -> {
            String updatedTitle = editTextTitle.getText().toString();
            String updatedDescription = editTextDescription.getText().toString();

            task.setTitle(updatedTitle);
            task.setDescription(updatedDescription);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("task", task);
            resultIntent.putExtra("position", taskPosition);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
