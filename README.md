### adb命令传参给APP
## 步骤
-  播放	    adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 0 --ei type 5
-  暂停	    adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 1 --ei type 5
-  上一个    adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 2 --ei type 5
-  下一个    adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 3 --ei type 5
-  快进	    adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 4 --ei type 5
-  快退	    adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 5 --ei type 5
-  搜索	    adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 6 --ei type 5
-  播放搜索  adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 7 --ei type 5
-  自动播放  adb shell am start-foreground-service -n cn.yhsh.adbinputserver/cn.yhsh.adbinputserver.service.AdbService --ei position 8 --ei type 5 
-  上面的adb指令就是传参示例
-  先运行项目打开APP，然后使用上面的adb命令即可传参，主要穿了两个参数一个position一个type