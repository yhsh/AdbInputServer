package cn.yhsh.adbinputserver.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import cn.yhsh.adbinputserver.utils.CommendUtils;

/**
 * @author xiayiye5
 * @date 2022/1/19 11:38
 * adb输入传参使用方法如下
 * 播放	adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 0 --ei type 5
 * 暂停	adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 1 --ei type 5
 * 上一个	adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 2 --ei type 5
 * 下一个	adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 3 --ei type 5
 * 快进	adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 4 --ei type 5
 * 快退	adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 5 --ei type 5
 * 搜索	adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 6 --ei type 5
 * 播放搜索	adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 7 --ei type 5
 * 自动播放	adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 8 --ei type 5
 * 上面传入的参数主要有position和type两个字段
 */
public class AdbService extends Service {

    private static final String TAG = "AdbService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            NotificationChannel notificationChannel = new NotificationChannel(
                    "cn.yhsh.adbinputserver",
                    "ChannelAsr", NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(notificationChannel);
            startForeground(1, new NotificationCompat.Builder(this, "cn.yhsh.adbinputserver").build());
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int type = intent.getIntExtra("type", -1);
        int position = intent.getIntExtra("position", -1);
        Log.e(TAG, "打印position:" + position + "==" + type);
        if (position == 0) {
            CommendUtils.getInstance().sendCommend(
                    "{\"displayId\": 0,\"protocol\": \"earth\"}",
                    "command.media.play"
            );
        } else if (position == 1) {
            CommendUtils.getInstance().sendCommend(
                    "{\"displayId\": 0,\"protocol\": \"earth\"}",
                    "command.media.pause"
            );
        } else if (position == 2) {
            CommendUtils.getInstance().sendCommend(
                    "{\"displayId\": 0,\"protocol\": \"earth\"}",
                    "command.media.previous"
            );
        } else if (position == 3) {
            CommendUtils.getInstance().sendCommend(
                    "{\"displayId\": 0,\"protocol\": \"earth\"}",
                    "command.media.next"
            );
        } else if (position == 4) {
            CommendUtils.getInstance().sendCommend(
                    "{\"displayId\": 0,\"protocol\": \"earth\",\"duration\": 10000,\"mediaType\": 5}",
                    "command.media.forward"
            );
            Log.e(TAG, "打印快进:" + position + "==" + type);
        } else if (position == 5) {
            CommendUtils.getInstance().sendCommend(
                    "{\"displayId\": 0,\"protocol\": \"earth\",\"duration\": 10000,\"mediaType\": 5}",
                    "command.media.rewind"
            );
            Log.e(TAG, "打印快退:" + position + "==" + type);
        } else if (position == 6) {
            CommendUtils.getInstance().sendCommend(
                    "{\"displayId\":0,\"protocol\":\"earth\",\"keywords\":\"哈妮\",\"pageIndex\":1,\"pageSize\":20}",
                    "command.media.search"
            );
        } else if (position == 7) {
            CommendUtils.getInstance().sendCommend(
                    "{\"displayId\": 0,\"protocol\": \"earth\",\"mediaType\": 5,\"extras\": {\"deviceId\":\"743666966c88443d381881f4082bdcc3\",\"mediaId\":\"/storage/F299-6882/哈妮摇摇马.mp4\"}}",
                    "command.media.search.item"
            );
        } else if (position == 8) {
            CommendUtils.getInstance().sendCommend(
                    "{\"displayId\": 0,\"protocol\": \"earth\",\"mediaType\": 5,\"extras\": {}}",
                    "command.media.play.auto"
            );
        }
        startForeground(1, new NotificationCompat.Builder(this, "cn.yhsh.adbinputserver").build());
        return START_STICKY;
    }

}
