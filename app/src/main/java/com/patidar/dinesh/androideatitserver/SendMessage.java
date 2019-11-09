package com.patidar.dinesh.androideatitserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.patidar.dinesh.androideatitserver.Common.Common;
import com.patidar.dinesh.androideatitserver.Model.DataMessage;
import com.patidar.dinesh.androideatitserver.Model.MyResponse;
import com.patidar.dinesh.androideatitserver.Model.Token;
import com.patidar.dinesh.androideatitserver.Remote.APIService;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendMessage extends AppCompatActivity {

    MaterialEditText edtMessage, edtTitle;
    Button btnSend;

    APIService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        mService = Common.getFCMClient();

        edtMessage = (MaterialEditText)findViewById(R.id.edtMessage);
        edtTitle = (MaterialEditText)findViewById(R.id.edtTitle);
        btnSend = (Button)findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Notification notification = new Notification(edtTitle.getText().toString(),edtMessage.getText().toString());
                Sender toTopic = new Sender();
                toTopic.to = new StringBuilder("/topics").append(Common.topicName).toString();
                toTopic.notification = notification;*/



                Map<String,String> dataSend = new HashMap<>();
                dataSend.put("title","Dinesh Patidar");
                dataSend.put("message",edtMessage.getText().toString());
                DataMessage dataMessage = new DataMessage(new StringBuilder("/topics/").append(Common.topicName).toString(),dataSend);

                mService.sendNotification(dataMessage)
                        .enqueue(new Callback<MyResponse>() {
                            @Override
                            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                                if (response.isSuccessful())
                                    Toast.makeText(SendMessage.this, "Message sent", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<MyResponse> call, Throwable t) {
                                Toast.makeText(SendMessage.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });
    }
}
