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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import gtiians.akgec.students.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText regName, regEmail, regPwd;
    private Button register;

    private String name, email, pwd;
    private FirebaseAuth auth;

    private DatabaseReference reference, dbRef;

    private TextView openLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        regName = findViewById(R.id.reg_name);
        regEmail = findViewById(R.id.reg_email);
        regPwd = findViewById(R.id.reg_password);
        register = findViewById(R.id.register);
        openLogin = findViewById(R.id.openLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

        openLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

}

    private void openLogin() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser()!=null){
            openPortal();
        }
    }

    private void openPortal() {
        startActivity(new Intent(RegisterActivity.this, StudentsPortalActivity.class));
        finish();
    }

    private void validateData() {
        name = regName.getText().toString();
        email = regEmail.getText().toString();
        pwd = regPwd.getText().toString();
        if (name.isEmpty()) {
            regName.setError("Please Enter the Name");
            regName.requestFocus();
        } else if (email.isEmpty()) {
            regEmail.setError("Please Enter the Email");
            regEmail.requestFocus();
        } else if (pwd.isEmpty()) {
            regPwd.setError("Please Enter the Password");
            regPwd.requestFocus();
        }else {
            createuser();
        }
}

    private void createuser() {
        auth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isComplete()){
                    uploadUser();
                }else {
                    Toast.makeText(RegisterActivity.this, "Error "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, "Error "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void uploadUser() {
        dbRef = reference.child("Students Portal");
        String key = dbRef.push().getKey();

        HashMap<String, String> user = new HashMap<>();
        user.put("key", key);
        user.put("name", name);
        user.put("email", email);

        dbRef.child(key).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}