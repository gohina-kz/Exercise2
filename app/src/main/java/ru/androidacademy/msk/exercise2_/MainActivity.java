package ru.androidacademy.msk.exercise2_;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private EditText message;
    private Button sendMessage;
    private ImageButton insta;
    private ImageButton fb;
    private ImageButton gitHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendMessage = findViewById(R.id.send_message);
        insta = findViewById(R.id.insta);
        fb = findViewById(R.id.fb);
        gitHub = findViewById(R.id.gitHub);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = findViewById(R.id.message);
                String messageContent = message.getText().toString();
                message.getText().clear();
                message.clearFocus();
                String uriText =
                        "mailto:zhumabek.gauhar@gmail.com" +
                                "?subject=" + Uri.encode("My sent email:") +
                                "&body=" + Uri.encode(messageContent);
                Uri uri = Uri.parse(uriText);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Send email"));
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String instaProfile = "https://www.instagram.com/gohin_kz";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instaProfile));
                startActivity(browserIntent);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String instaProfile = "https://www.facebook.com/gaukhar.zhumabek";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instaProfile));
                startActivity(browserIntent);
            }
        });

        gitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String instaProfile = "https://github.com/gohina-kz";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instaProfile));
                startActivity(browserIntent);
            }
        });
    }

}

