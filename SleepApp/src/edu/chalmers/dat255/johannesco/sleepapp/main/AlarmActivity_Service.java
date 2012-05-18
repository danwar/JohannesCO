
package edu.chalmers.dat255.johannesco.sleepapp.main;


import java.io.IOException;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.widget.Toast;


public class AlarmActivity_Service extends Service {
    NotificationManager mNM;

    @Override
    public void onCreate() {
        mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        // show the icon in the status bar
        showNotification();

        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.
        Thread thr = new Thread(null, mTask, "AlarmActivity_Service");
        thr.start();
    }

    @Override
    public void onDestroy() {
        // Cancel the notification -- we use the same ID that we had used to start it
        mNM.cancel(R.string.alarm_service_started);

        // Tell the user we stopped.
        Toast.makeText(this, R.string.alarm_service_finished, Toast.LENGTH_SHORT).show();
    }

    /**
     * The function that runs in our worker thread
     */
    Runnable mTask = new Runnable() {
        public void run() {
            // Normally we would do some work here...  for our sample, we will
            // just sleep for 30 seconds.
        
        	long endTime = System.currentTimeMillis() + 3*1000;
            while (System.currentTimeMillis() < endTime) {
                synchronized (mBinder) {
                    try {
                        mBinder.wait(endTime - System.currentTimeMillis());
                    } catch (Exception e) {
                    }                   
                }
                
            }
            Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM); 
       	 MediaPlayer mMediaPlayer = new MediaPlayer();
       	 try {
				mMediaPlayer.setDataSource(getApplicationContext(), alert);
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       	 final AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
       	 if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
       		 mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
       		 mMediaPlayer.setLooping(false);
       	            try {
       	            	mMediaPlayer.prepare();
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
       	            mMediaPlayer.start();
       	  }

            // Done with our work...  stop the service!
            AlarmActivity_Service.this.stopSelf();
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * Show a notification while this service is running.
     */
    @SuppressWarnings("deprecation")
	private void showNotification() {
        // In this sample, we'll use the same text for the ticker and the expanded notification
        CharSequence text = getText(R.string.alarm_service_started);

        // Set the icon, scrolling text and timestamp
        Notification notification = new Notification(R.drawable.stat_sample, text,
                System.currentTimeMillis());

        // The PendingIntent to launch our activity if the user selects this notification
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, AlarmActivity.class), 0);

        // Set the info for the views that show in the notification panel.
        notification.setLatestEventInfo(this, getText(R.string.alarm_service_label),
                       text, contentIntent);

        // Send the notification.
        // We use a layout id because it is a unique number.  We use it later to cancel.
        mNM.notify(R.string.alarm_service_started, notification);
    }

    /**
     * This is the object that receives interactions from clients.  See RemoteService
     * for a more complete example.
     */
    private final IBinder mBinder = new Binder() {
        @Override
                protected boolean onTransact(int code, Parcel data, Parcel reply,
                        int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        }
    };
}