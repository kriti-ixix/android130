package com.kriti.android1_30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTPAuthentication extends AppCompatActivity {

    EditText editText;
    String phoneNumber;
    Button sendOtpButton;
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpauthentication);

        editText = findViewById(R.id.phoneEditText);
        sendOtpButton = findViewById(R.id.getOtpButton);
        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();

        sendOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber = editText.getText().toString();

                if (phoneNumber.equals(""))
                    editText.setError("Please enter a phone number");
                else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    verifyPhone(phoneNumber);
                }
            }
        });
    }

    void verifyPhone(final String phoneNumber)
    {
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(OTPAuthentication.this, "Verification completed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(OTPAuthentication.this, "Verification failed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                String verificationCode = s;
                final EditText editText = new EditText(OTPAuthentication.this);

                AlertDialog.Builder builder = new AlertDialog.Builder(OTPAuthentication.this);
                builder.setTitle("Enter OTP");
                builder.setView(editText);

                builder.setPositiveButton("Verify", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String code = editText.getText().toString();
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, code);
                        signInWithPhoneAuthCredential(credential);
                    }
                });

                builder.setNegativeButton("Cancel", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        };

        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber(phoneNumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(OTPAuthentication.this)
                .setCallbacks(mCallbacks)
                .build();

        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(OTPAuthentication.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                            Toast.makeText(OTPAuthentication.this, "Verification completed", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(OTPAuthentication.this, "Verification failed", Toast.LENGTH_LONG).show();

                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
}