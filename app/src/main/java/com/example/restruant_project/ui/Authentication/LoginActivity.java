package com.example.restruant_project.ui.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restruant_project.R;
import com.example.restruant_project.ui.Main.MainActivity;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    //login Components
    @BindView(R.id.cardView_login)
    CardView cardView_login;
    @BindView(R.id.tv_login)
    TextView tv_Login;
    @BindView(R.id.tv_signup)
    TextView tv_signUp;
    @BindView(R.id.email_edittext)
    EditText ed_email;
    @BindView(R.id.password_edittext)
    EditText ed_password;
    @BindView(R.id.tv_continue)
    TextView tv_continue;

    //SignUP Components
    @BindView(R.id.cardView_signup)
    CardView cardView_signup;
    @BindView(R.id.sigUp_name)
    TextView sigUp_name;
    @BindView(R.id.sigUp_email)
    EditText sigUp_email;
    @BindView(R.id.sigUp_mobileNumber)
    EditText sigUp_mobileNumber;
    @BindView(R.id.sigUp_password)
    EditText sigUp_password;
    @BindView(R.id.tv_signup_action)
    TextView tv_signup_action;

    @BindView(R.id.tv_continueasGuesst)
    TextView tv_continueasGuesst;

    //Login matrialLayout
    @BindView(R.id.email)
    TextInputLayout login_email;
    @BindView(R.id.password)
    TextInputLayout login_password;

    //SignUP matrialLayout
    @BindView(R.id.LOsigUp_name)
    TextInputLayout LOsigUp_name;
    @BindView(R.id.LOsigUp_email)
    TextInputLayout LOsigUp_email;
    @BindView(R.id.LOsigUp_mobileNumber)
    TextInputLayout LOsigUp_mobileNumber;
    @BindView(R.id.LOsigUp_password)
    TextInputLayout LOsigUp_password;



    Intent intent;



    @OnClick({R.id.tv_login, R.id.tv_signup, R.id.tv_continueasGuesst})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                ShowLoginUI();
                break;
            case R.id.tv_signup:
                ShowSignUpUI();
                break;
            case R.id.tv_continueasGuesst:
                SendToMain();
                break;

        }
    }

    private void SendToMain() {

        intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        ShowLoginUI();









    }

    public void ShowLoginUI()
    {
        cardView_signup.setVisibility(View.GONE);
        cardView_login.setVisibility(View.VISIBLE);
        tv_Login.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.text_yellow));
        tv_signUp.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.white));
        tv_continue.setVisibility(View.VISIBLE);
        tv_signup_action.setVisibility(View.GONE);
        tv_Login.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        tv_signUp.setPaintFlags(0);
    }
    public void ShowSignUpUI()
    {
        cardView_login.setVisibility(View.GONE);
        cardView_signup.setVisibility(View.VISIBLE);
        tv_signUp.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.text_yellow));
        tv_Login.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.white));
        tv_continue.setVisibility(View.GONE);
        tv_signup_action.setVisibility(View.VISIBLE);
        tv_signUp.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        tv_Login.setPaintFlags(0);
    }


}
