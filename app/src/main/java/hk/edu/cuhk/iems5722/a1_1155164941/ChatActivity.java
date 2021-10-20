package hk.edu.cuhk.iems5722.a1_1155164941;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

//      switch to main activity
        Toolbar toolbar1 = findViewById(R.id.tb_room);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<Message> arrayofMessages=new ArrayList<Message>();
//      click button_send and send message
        Button button_send = findViewById(R.id.btn_send);
        MessageAdapter adapter=new MessageAdapter(this,arrayofMessages);
        ListView listView = findViewById(R.id.lv_msg);
        listView.setAdapter(adapter);
        EditText inputText=findViewById(R.id.text_input);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=inputText.getText().toString();
                if(!msg.trim().isEmpty()){
                    Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
                    String time=c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE);
                    Message message=new Message(msg,time);
                    adapter.add(message);
                    inputText.getText().clear();
                }
            }
        });



    }

}