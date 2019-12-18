package com.example.dbsystem.Helper;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dbsystem.Interface.RegisterCallback;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class RegisterNetWorkHelper {

    private static final int HANDLER_MSG_TELL_RECV = 1;

    private RegisterCallback callback;

    private AppCompatActivity mContent;

    public RegisterNetWorkHelper(AppCompatActivity appCompatActivity) {
        this.mContent = appCompatActivity;
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.obj.equals("1")) {
                callback.onSucceed("注册成功！");
            } else{
                callback.onFalied(msg.obj.toString());
            }
            Log.d("123456", "handleMessage: ");
        }
    };

    public void startNetThread(final String host, final int port, final String data, RegisterCallback myCallback) {
        this.callback = myCallback;
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //创建客户端对象
                    Socket socket = new Socket(host, port);
                    //获取客户端对象的输出流
                    OutputStream outputStream = socket.getOutputStream();
                    //把内容以字节的形式写入（data）.getBytes()
                    outputStream.write(data.getBytes());
                    //刷新管道流
                    outputStream.flush();
                    //拿到客户端输入流
                    InputStream is = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    //回应数据
                    int n = is.read(bytes);

                    Message msg = handler.obtainMessage(HANDLER_MSG_TELL_RECV, new String(bytes, 0, n));
                    msg.sendToTarget();
                    is.close();
                    socket.close();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
