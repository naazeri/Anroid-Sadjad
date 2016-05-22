package ir.ac.sadjad.librarybooks;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;

import java.io.InputStream;
import java.net.URL;

class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private Context context;
    private String title, content, uri;

    public DownloadImageTask(Context context, String Title, String Content, String uri) {
        this.context = context;
        this.title = Title;
        this.content = Content;
        this.uri = uri;
    }

    protected Bitmap doInBackground(String... imageUrls) {
        String imageUrl = imageUrls[0];
        Bitmap bitmap = null;
        try {
            InputStream in = new URL(imageUrl).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
//            Log.e("Error", e.getMessage());
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap image) {
        showNotification(title, content, uri, image);
    }

    private void showNotification(String title, String content, String uri, Bitmap largeIcon) {
        Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
        notificationIntent.setData(Uri.parse(uri));

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        String ticker = getApplicationName(context);
        Notification notification = new NotificationCompat.Builder(context)
                .setTicker("2")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setLargeIcon(largeIcon)
                .setContentInfo("اطلاعیه:")
                .setContentText(content)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

    private String getApplicationName(Context context) {
        return context.getString(context.getApplicationInfo().labelRes);
    }
}