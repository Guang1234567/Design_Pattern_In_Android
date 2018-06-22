package com.gg.design_pattern.sample;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gg.design_pattern.sample.decorator.notification.NotifyProxy;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.gg.design_pattern.sample.R.layout.activity_main);

        btnNotify = (Button) findViewById(R.id.btn_notify);
        btnNotify.setText(stringFromJNI());
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NotifyProxy(
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE),
                        getApplication()
                ).send();
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
