package radio.sa.com.oir;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


// Project OIR : Test App

public class MainActivity extends AppCompatActivity {

    DatabaseReference RadioRoot = FirebaseDatabase.getInstance().getReference();
    DatabaseReference playURL;
    URLStreamPlayer player;
    Button bbcone,bbctwo;
    TextView Status;
    String URL,Stn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bbcone = findViewById(R.id.bbcone);
        bbctwo = findViewById(R.id.bbctwo);
        Status = findViewById(R.id.radioStatus);
    }

    public void playBBC_One(View v1){

        Stn = getResources().getString(R.string.bbcone);
        proceed_play(Stn);

    }

    public void playBBC_Two(View v2){
        Stn = getResources().getString(R.string.bbctwo);
        proceed_play(Stn);
    }

    public void proceed_play(String stn){
        playURL = RadioRoot.child(stn);
        playURL.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                URL = dataSnapshot.getValue(String.class);
                Status.setText(Stn+" is Live");
                player = new URLStreamPlayer();
                player.URLStreamPlayer(URL);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
