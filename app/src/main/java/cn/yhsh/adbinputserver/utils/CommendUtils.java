package cn.yhsh.adbinputserver.utils;

import android.util.Log;

/**
 * @author xiayiye5
 * @date 2022/1/20 19:16
 */
public class CommendUtils {
    private CommendUtils() {
    }

    private static final CommendUtils COMMEND_UTILS = new CommendUtils();

    public static CommendUtils getInstance() {
        return COMMEND_UTILS;
    }

    public void sendCommend(String commend, String dataId) {
        Log.e("打印获取到的指令信息", commend + "==" + dataId);
    }
}
