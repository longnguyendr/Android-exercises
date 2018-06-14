package fi.jamk.notifications;


import android.app.Notification;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.ProgressDialog;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity implements ProductDialogFragment.ProductDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exitDialog(View view) {
        ExitDialogFragment eDialog = new ExitDialogFragment();
        eDialog.show(getFragmentManager(), "exit");
    }

    public void listDialog(View view) {
        ListDialogFragment eDialog = new ListDialogFragment();
        eDialog.show(getFragmentManager(), "");
    }

    public void customDialog(View view) {
        ProductDialogFragment eDialog = new ProductDialogFragment();
        eDialog.show(getFragmentManager(), "Add a new Product");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String productName) {
        Toast.makeText(getApplicationContext(), "New Product = " + productName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
    }

    public void progressDialog(View view) {

        ProgressDialogTask task = new ProgressDialogTask(this);
        task.execute();
    }

    class ProgressDialogTask extends AsyncTask<Void, Void, Void> {

        public static final int WAIT_LENGTH = 3000;
        private ProgressDialog dialog;

        public ProgressDialogTask(Activity activity) {
            dialog = new ProgressDialog(activity);
        }

        @Override
        protected void onPreExecute() {
            dialog.setMessage("Loading...");
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis()-start < WAIT_LENGTH){}
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            if(dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    private int notify_id = 1;

    public void launchPublicNotification(View view) {
        createNotification(Notification.VISIBILITY_PUBLIC, getString(R.string.public_text));
    }

    public void launchPrivateNotification(View view) {
        createNotification(Notification.VISIBILITY_PRIVATE, getString(R.string.private_text));
    }

    public void launchSecretNotification(View view) {
        createNotification(Notification.VISIBILITY_SECRET, getString(R.string.secret_text));
    }

    public void launchHeadsUpNotification(View view) {
        // create pending intent to launch web site
        Intent actionIntent = new Intent(Intent.ACTION_VIEW);
        actionIntent.setData(Uri.parse("http://google.com"));
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, actionIntent, 0);

        // create action intent to open application in device (ResultActivity)
        Intent contentIntent = new Intent(this,ResultActivity.class);
        // Adds the back stack - see manifest
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // adds the Intent to the top of the stack
        stackBuilder.addParentStack(ResultActivity.class);
        // adds the Intent to the top of the stack
        stackBuilder.addNextIntent(contentIntent);
        // gets a PendingIntent containing the entire back stack
        PendingIntent contentPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // create a notification
        Notification notification = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_PROMO)
                .setContentTitle("pikachu notification")
                .setContentText("Something cool happens now on google.")
                .setSmallIcon(R.drawable.rocket)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .addAction(android.R.drawable.ic_menu_view, "View details", actionPendingIntent)
                .setContentIntent(contentPendingIntent)
                .setPriority(Notification.PRIORITY_HIGH)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000}).build(); // wait, vibrate, wait, ...
        // cancel the notification after it is launched
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        // connect notification manager and create unique notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notify_id++;
        notificationManager.notify(notify_id, notification);
    }

    public void launchBigViewNotification(View view) {
        // create action intent to open application in device (SpecialActivity)
        Intent specialIntent = new Intent(this,SpecialActivity.class);
        specialIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // just launch a special activity (not a full stack of activities)
        PendingIntent specialPendingIntent = PendingIntent.getActivity(this, 0, specialIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // create a new notification
        Notification notification  = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Pikachu notification")
                .setContentText("Something cool happens now on Pikachu.")
                .setStyle(new Notification.BigTextStyle().bigText("Big Android seminar today. Remember register at PTM website! Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."))
                .setSmallIcon(R.drawable.rocket)
                .setContentIntent(specialPendingIntent)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_PUBLIC).build();
        // connect notification manager and create a notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notify_id++;
        notificationManager.notify(notify_id, notification);
    }

    public void createNotification(int visibility, String text) {
        // create a new notification
        Notification notification  = new Notification.Builder(this)
                .setContentTitle("Pikachu notification")
                .setContentText(text)
                .setSmallIcon(R.drawable.rocket)
                .setAutoCancel(true)
                .setVisibility(visibility).build();
        // connect notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // make a new notification with a new unique id
        notify_id++;
        notificationManager.notify(notify_id, notification);
    }

}