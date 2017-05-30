package com.sample.samplechat.features.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sample.samplechat.R;
import com.sample.samplechat.features.main.MainActivity;
import com.sample.samplechat.features.signup.SignUpActivity;

public class LoginActivity extends AppCompatActivity {

  private EditText emailView;
  private EditText passwordView;

  private Button loginButton;
  private Button signUpButton;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    initUI();
  }

  private void initUI() {

    emailView = (EditText) findViewById(R.id.et_email);
    passwordView = (EditText) findViewById(R.id.et_password);
    loginButton = (Button) findViewById(R.id.button_login);
    signUpButton = (Button) findViewById(R.id.button_signup);

    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        validateFields();
      }
    });

    signUpButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        signUp();
      }
    });
  }

  private void validateFields() {
    String email = emailView.getText().toString();
    String password = passwordView.getText().toString();

    if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
      showValidationError();
      return;
    }

    logIn();
  }

  private void showValidationError() {
    Toast.makeText(this, "Заполните поля!", Toast.LENGTH_SHORT).show();
  }

  private void logIn() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

  private void signUp() {
    Intent intent = new Intent(this, SignUpActivity.class);
    startActivity(intent);
  }
}
