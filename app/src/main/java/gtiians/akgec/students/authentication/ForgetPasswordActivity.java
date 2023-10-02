package gtiians.akgec.students.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import gtiians.akgec.students.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button forgetBtn;
    private EditText txtEmail;
    private String email;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        auth = FirebaseAuth.getInstance();
        txtEmail = findViewById(R.id.forgetEmail);
        forgetBtn = findViewById(R.id.forgetBtn);

        forgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

    }

    private void validateData() {
        email = txtEmail.getText().toString();
        if (email.isEmpty()) {
            txtEmail.setError("Please Enter the Email");
        } else {
            forgetPassword();
        }
    }

    private void forgetPassword() {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if ((task.isSuccessful())) {
                    Toast.makeText(ForgetPasswordActivity.this, "Reset Link Sent to Your Email", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ForgetPasswordActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(ForgetPasswordActivity.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}