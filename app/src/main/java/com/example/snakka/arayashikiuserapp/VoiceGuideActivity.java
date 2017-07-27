package com.example.snakka.arayashikiuserapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

public class VoiceGuideActivity extends AppCompatActivity{
    private VoiceRevival voiceRev;
    public static TextView textView1,textView2;
    public static Button reVoice;
    private static BLEManager bleMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_guide);
        // TextViewオブジェクト生成
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        // Buttonオブジェクト作成
        reVoice = (Button)findViewById(R.id.button);
        //再生機構の初期化
        voiceRev = new VoiceRevival(getApplicationContext());


        //BEL
        //initBLE();
    }

    /** BLE通信をするために必要な前準備を実装したメソッド */
    private void initBLE(){
        bleMgr = new BLEManager(this);

        bleMgr.onBluetooth(this); //Bluetoothを起動
    }

    @Override
    protected void onStart(){
        super.onStart();
        //行ける方向の音声再生、文字表示、もう一度再生可能(全てを司る！！！)
        voiceRev.mainVoice();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("onResume", "scan開始だってばよ");
        //bleMgr.execute(); //BLEスキャン開始
    }


    @Override
    protected void onPause(){
        super.onPause();
        //bleMgr.getProDialog().cancel();
        Log.d("onPause", "cancelだってばよ");
    }

}
