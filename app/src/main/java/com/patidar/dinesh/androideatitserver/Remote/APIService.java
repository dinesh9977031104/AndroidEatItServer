package com.patidar.dinesh.androideatitserver.Remote;

import com.patidar.dinesh.androideatitserver.Model.DataMessage;
import com.patidar.dinesh.androideatitserver.Model.MyResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers(
            {
                    "Content-type:application/json",
                    "Authorization:key=AAAApQqKUj4:APA91bGCoj4zgnE-9qvaaaY72KvyHfnXk9vSdyjs8Mqpnbo7gLaItmltZRIJAc0UIRh7vNCuAA_VGROoB7bfSlLcbXhlzElAYhLDchPFU-ePKKCcIiuvxNwdTTnArgFcjSw7HYMcZJ0L"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification (@Body DataMessage body);
}
