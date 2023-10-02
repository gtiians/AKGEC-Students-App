package gtiians.akgec.students.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import gtiians.akgec.students.R;

public class LoginActivity extends AppCompatActivity {

    private EditText logEmail, logPassword;
    private TextView openReg, openForgetPassword;
    private Button login;
    private String email, password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        openReg = findViewById(R.id.openReg);
        logEmail = findViewById(R.id.logEmail);
        logPassword = findViewById(R.id.logPassword);
        login = findViewById(R.id.login);

        openForgetPassword = findViewById(R.id.openForgetPassword);


        openReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

        openForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
                
            }
        });

    }

    private void validateData() {
        email = logEmail.getText().toString();
        password=logPassword.getText().toString();
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please Provide All Fields", Toast.LENGTH_SHORT).show();
        }else {
            loginUser();
        }
    }

    private void loginUser() {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    openPortal();
                }else {
                    Toast.makeText(LoginActivity.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openPortal() {
        startActivity(new Intent(LoginActivity.this, StudentsPortalActivity.class));
        finish();
    }

    private void openRegister() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        finish();
    }

}