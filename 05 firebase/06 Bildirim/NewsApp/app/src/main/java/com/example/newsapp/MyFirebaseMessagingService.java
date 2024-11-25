package com.example.newsapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService  {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        showNotification(message.getData().get("message")); // Mesaj içeriği alınıp bildirim gösteren metod çağırılıyor
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.i("FirebaseInfo", "onNewToken: " + token);
    }
    private void showNotification(String message) {

        Intent i = new Intent(this,MainActivity.class); // Bildirime basıldığında hangi aktiviteye gidilecekse
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setAutoCancel(true) // Kullanıcı bildirime girdiğinde otomatik olarak silinsin. False derseniz bildirim kalıcı olur.
                .setContentTitle("FCM Test") // Bildirim başlığı
                .setContentText(message) // Bildirim mesajı
                .setSmallIcon(R.drawable.new_releases) // Bildirim simgesi
                .setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(0,builder.build());
    }

}
