package com.example.myapplication;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.databinding.ConstraintLayoutBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayoutBinding binding = ConstraintLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setText(getString(R.string.put_message2));
        binding.image.setImageResource(R.drawable.flower);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("image", R.drawable.tree);
                start.launch(intent);
                //Log.d("MyTag", "Кнопка была нажата!");
            }
            ActivityResultLauncher<Intent> start = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Bundle image = result.getData().getExtras();
                    ImageView imageView = findViewById(R.id.image);
                    int imageResource = image.getInt("image");
                    imageView.setImageResource(imageResource);
                }
            });
        });
    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);
        TextView textView = findViewById(R.id.main_text);
        textView.setText(getString(R.string.hello_message2));
        ImageView imageView = findViewById(R.id.image);
        imageView.setImageResource(R.drawable.lion);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyTag", "Кнопка была нажата (программно)");
            }
        });
    }

    public void onClick(View view) {
        Log.d("MyTag", "Кнопка была нажата (декларативно)");
    }*/
}