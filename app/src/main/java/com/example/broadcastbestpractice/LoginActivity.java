package com.example.broadcastbestpractice;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 刘子恒 on 2017/9/26.
 */

public class LoginActivity extends BaseActivity {

    private EditText account;
    private EditText password;
    private Button login;
    private Button tip;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        if (Build.VERSION.SDK_INT >= 23) {                                              //权限申请
            if (! Settings.canDrawOverlays(LoginActivity.this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent,10);
            }
        }

        account=findViewById(R.id.accout);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        tip=findViewById(R.id.tip);

        login.setOnClickListener(new myOnClickListener());
        tip.setOnClickListener(new myOnClickListener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!Settings.canDrawOverlays(this)) {
                    // SYSTEM_ALERT_WINDOW permission not granted...
                    Toast.makeText(LoginActivity.this,"not granted",Toast.LENGTH_SHORT);
                }
            }
        }
    }


    private class myOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.login:
                    String tAccount=account.getText().toString();
                    String tPassword=password.getText().toString();

                    if(tAccount.equals("123")&&tPassword.equals("123456")){
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this,"输入错误，老哥！你别是个傻子吧",Toast.LENGTH_SHORT).show();
                    }
                    break;


                case R.id.tip:
                    Toast.makeText(LoginActivity.this,"用户名是123，密码是123456，你可长点心吧！",Toast.LENGTH_LONG).show();
                    break;

                default:
                    break;
            }
        }
    }


}
