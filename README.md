# [MyAndroidCalculator](https://github.com/upwon/MyAndroidCalculator)
 简易 Android 计算器的实现 ，暗黑风格，实现简单的加减乘除，实时显示运算结果，可撤销操作。

<br/>

### 演示

![image](https://tvax4.sinaimg.cn/large/003pPIslgy1gtnjnk92luj60de0o0whe02.jpg)

![演示4](https://tva4.sinaimg.cn/large/003pPIslgy1gtnjpg1k4vg61hc0sa7mf02.gif)

<br />

<br />

### 安装教程

1. Gradle Plugin 版本设置

   ![image](https://tvax2.sinaimg.cn/large/003pPIslgy1gtnjqn8zm7j60wz0hdwgf02.jpg)

2. Java version 设置为 11.0.1

3. 编译运行

<br />

<br />

### 部分过程记录



#### 圆角制作

 ```cpp
 <?xml version="1.0" encoding="utf-8"?>
 <shape xmlns:android="http://schemas.android.com/apk/res/android">
     <solid android:color="#1f2129" />
     <corners
         android:topLeftRadius="40dp"
         android:topRightRadius="40dp" />
 
 </shape>
 ```

![image-20210819003058901](https://cdn.jsdelivr.net/gh/upwon/MyPicture@master/imgimage-20210819003058901.png)

 layout/activity_main.xml 中 添加一个 widget下的view 调整好

点击④和⑤ 使其填充

![image](https://tva2.sinaimg.cn/large/003pPIslgy1gtleysdecuj61ig0vbkez02.jpg)



然后设置 background 为刚刚制作的圆角

![image](https://tva4.sinaimg.cn/large/003pPIslgy1gtlf11nionj61ig0vb4j602.jpg)



#### 取消状态栏

values/themes.xml 和  values-night/themes.xml 将上面中的 DarkActionBar 改为 NoActionBar

```xml
<style name="Theme.MyCalculator" parent="Theme.MaterialComponents.DayNight.NoActionBar">
```

重新运行

![image](https://tvax1.sinaimg.cn/large/003pPIslgy1gtlfaoeuxjj60cc0qojrw02.jpg)



#### 全屏

若需要全屏：

values/themes.xml 和  values-night/themes.xml  加入

```
<item name="android:windowFullscreen">true</item>
```



比如

```cpp
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.MyCalculator" parent="Theme.MaterialComponents.DayNight.NoActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/purple_200</item>
        <item name="colorPrimaryVariant">@color/purple_700</item>
        <item name="colorOnPrimary">@color/black</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/teal_200</item>
        <item name="colorSecondaryVariant">@color/teal_200</item>
        <item name="colorOnSecondary">@color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
        <item name="android:windowFullscreen">true</item>

    </style>
</resources>
```





#### 输入显示 

textView_input 为输入显示，放于顶部，并设置为填充

设置颜色 android:textColor="#FFFFFF"

设置字体大小 android:textSize="24sp"

设置底部右对齐 android:gravity="bottom|right"

设置字母间的间距 android:letterSpacing="0.2"



显示结果的 textView_input  类似的这样设计

```
android:id="@+id/textView_result"
android:layout_width="0dp"
android:layout_height="0dp"
android:gravity="right|center_vertical"
android:textSize="32sp"
android:letterSpacing="0.1"
android:text="1200"
```

左右边距

```xml
android:layout_marginStart="20dp"
android:layout_marginEnd="20dp"
```





#### 计算器按键



设计键盘圆角（与前面的背景圆角一样的步骤）

![image](https://tvax4.sinaimg.cn/large/003pPIslgy1gtmfc4ejytj61ig0vb1iw02.jpg)





```cpp
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <corners android:radius="10dp" />
    <solid android:color="#1e2026" />
    <size android:height="60dp"/>
    <size android:width="60dp"/>
</shape>
```

![image](https://tvax2.sinaimg.cn/large/003pPIslgy1gtmfg88ylrj615j0mun3402.jpg)





键盘 按钮可以使用 button或者textview



#### 布局

然后复制，将四个button组合为水平chain【先固定左右两个button分别依附左右两边】

![多个控件水平对齐](https://tva1.sinaimg.cn/large/003pPIslgy1gtmi0axz1hg61hc0sb1kx02.gif)



添加图标

![添加图标](https://tva4.sinaimg.cn/large/003pPIslgy1gtmiedsqu4g61hc0sa1kz02.gif)



然后分别将所有按钮 连接并做相应的顶部对齐或着左对齐





