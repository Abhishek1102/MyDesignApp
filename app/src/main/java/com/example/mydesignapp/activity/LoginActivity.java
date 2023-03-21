package com.example.mydesignapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.AppConstant;
import com.example.mydesignapp.helper.SecurePreferences;
import com.example.mydesignapp.helper.Utils;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    String number;
    String password;
    String email;
    String name;
    LinearLayout lv_login, lv_register;
    TextView tv_login, tv_register;
    View view_login, view_register;
    EditText edt_loginpassword, edt_loginemail, edt_registernumber, edt_email, edt_password, edt_confirmpassword, edt_registername;
    Button btn_register, btn_login;
    SharedPreferences sharedPreferences;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        Utils.blackIconStatusBar(LoginActivity.this, R.color.blue_app);

        tv_login = findViewById(R.id.tv_login);
        tv_register = findViewById(R.id.tv_register);
        lv_login = findViewById(R.id.lv_login);
        lv_register = findViewById(R.id.lv_register);
        view_login = findViewById(R.id.view_linelogin);
        view_register = findViewById(R.id.view_lineregister);
        edt_loginemail = findViewById(R.id.edt_loginemail);
        edt_loginpassword = findViewById(R.id.edt_loginpassword);
        edt_registernumber = findViewById(R.id.edt_registerphonenumber);
        edt_email = findViewById(R.id.edt_registeremailid);
        edt_password = findViewById(R.id.edt_registerpassword);
        edt_confirmpassword = findViewById(R.id.edt_registerconfirmpassword);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        edt_registername = findViewById(R.id.edt_registername);

        introtourapp();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);


        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv_register.setVisibility(View.VISIBLE);
                lv_login.setVisibility(View.GONE);
                view_register.setVisibility(View.VISIBLE);
                view_login.setVisibility(View.GONE);

            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv_login.setVisibility(View.VISIBLE);
                lv_register.setVisibility(View.GONE);
                view_login.setVisibility(View.VISIBLE);
                view_register.setVisibility(View.GONE);


            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AppConstant.isOnline(getApplicationContext())) {
                    validatelogindata();
                }

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AppConstant.isOnline(getApplicationContext())) {
                    validateregisterdata();
                }
            }
        });

    }

    private void validateregisterdata() {
        if (edt_registername.getText().toString().trim().isEmpty()) {
            edt_registername.setError("Required");
            edt_registername.requestFocus();
        } else if (edt_registernumber.getText().toString().isEmpty()) {
            edt_registernumber.setError("Required");
            edt_registernumber.requestFocus();
        } else if (edt_email.getText().toString().isEmpty()) {
            edt_email.setError("Required");
            edt_email.requestFocus();
        } else if (!edt_email.getText().toString().trim().matches(emailPattern)) {
            edt_email.setError("Please enter valid email");
            edt_email.requestFocus();
        } else if (edt_password.getText().toString().isEmpty()) {
            edt_password.setError("Required");
            edt_password.requestFocus();
        } else if (edt_confirmpassword.getText().toString().isEmpty()) {
            edt_confirmpassword.setError("Required");
            edt_confirmpassword.requestFocus();
        } else if (!edt_password.getText().toString().equals(edt_confirmpassword.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter confirm password", Toast.LENGTH_SHORT).show();
            edt_password.requestFocus();
            edt_confirmpassword.requestFocus();
        } else if (!edt_email.getText().toString().matches(emailPattern)) {
            edt_email.setError("Please enter valid mail");
            edt_email.requestFocus();
        } else if (edt_registernumber.length() < 10) {
            edt_registernumber.setError("Please enter valid number");
            edt_registernumber.requestFocus();
        } else {
            successfulregistration();
        }

    }

    private void successfulregistration() {
        name = edt_registername.getText().toString();
        number = edt_registernumber.getText().toString();
        password = edt_password.getText().toString();
        email = edt_email.getText().toString();

        SecurePreferences.savePreferences(getApplicationContext(), AppConstant.user_name, name);
        SecurePreferences.savePreferences(getApplicationContext(), AppConstant.user_number, number);
        SecurePreferences.savePreferences(getApplicationContext(), AppConstant.user_email, email);
        //  Toast.makeText(getApplicationContext(), "Register! \n please login to continue", Toast.LENGTH_SHORT).show();
        edt_registername.setText("");
        edt_registernumber.setText("");
        edt_email.setText("");
        edt_password.setText("");
        edt_confirmpassword.setText("");
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            toast("success", "Registration Successful");
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    lv_login.setVisibility(View.VISIBLE);
                                    lv_register.setVisibility(View.GONE);
                                    view_login.setVisibility(View.VISIBLE);
                                    view_register.setVisibility(View.GONE);
                                }
                            }, 1000);
                        } else {
                            toast("error", "Registration Failed");
                        }
                    }
                });
    }

    private void validatelogindata() {

        if (edt_loginemail.getText().toString().isEmpty()) {
            edt_loginemail.setError("Required");
            edt_loginemail.requestFocus();
        } else if (edt_loginpassword.getText().toString().isEmpty()) {
            edt_loginpassword.setError("Required");
            edt_loginpassword.requestFocus();
        } else if (!edt_loginemail.getText().toString().trim().matches(emailPattern)) {
            edt_loginemail.setError("Please enter valid email");
            edt_loginemail.requestFocus();
        } else {
            loginsuccessful();
        }
    }

    private void loginsuccessful() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("loginnumber", edt_loginemail.getText().toString());
        editor.putString("loginpassword", edt_loginpassword.getText().toString());
        editor.commit();
        firebaseAuth.signInWithEmailAndPassword(edt_loginemail.getText().toString(), edt_loginpassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    toast("success", "Login Success");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            openDash();
                        }
                    }, 1000);
                } else {
                    toast("error", "Login Failed");
                }
            }
        });

    }

    private void openDash() {
        Intent i = new Intent(LoginActivity.this, SwipeDesignMainActivity.class);
        //to clear previous activity so user can't return to it
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }


    private void toast(String type, String desc) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.lv_customtoast));
        ImageView iv_messageimage = layout.findViewById(R.id.iv_messageimage);
        TextView tv_messagetitle = layout.findViewById(R.id.tv_messagetitle);
        TextView tv_messagedesc = layout.findViewById(R.id.tv_messagedesc);
        LinearLayout lv_message = layout.findViewById(R.id.lv_message);

        if (type.equalsIgnoreCase("success"))//success
        {
            lv_message.setBackgroundColor(getResources().getColor(R.color.green2));
//            iv_messageimage.setBackground(getResources().getDrawable(R.drawable.gradient_green));
            iv_messageimage.setImageResource(R.drawable.tick);
            tv_messagetitle.setText("Success");
            tv_messagedesc.setText(desc);
            tv_messagedesc.setText(desc);
        } else if (type.equalsIgnoreCase("info"))//info
        {
            lv_message.setBackgroundColor(getResources().getColor(R.color.blue));
            iv_messageimage.setImageResource(R.drawable.info);
            tv_messagetitle.setText("Info");
            tv_messagedesc.setText(desc);
            tv_messagedesc.setText(desc);
        } else if (type.equalsIgnoreCase("error")) {
            lv_message.setBackgroundColor(getResources().getColor(R.color.red_2));
            iv_messageimage.setImageResource(R.drawable.danger);
            tv_messagetitle.setText("Danger");
            tv_messagedesc.setText(desc);
        } else if (type.equalsIgnoreCase("warning")) {
            lv_message.setBackgroundColor(getResources().getColor(R.color.orange4));
            iv_messageimage.setImageResource(R.drawable.exclamation);
            tv_messagetitle.setText("Warning");
            tv_messagedesc.setText(desc);
        }


        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    private void introtourapp(){
        new TapTargetSequence(this)
                .targets(
                        TapTarget.forView(tv_register,"Registration","Register here to create account")
                                .outerCircleColor(R.color.teal_200)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(23)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(15)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(50),
                        TapTarget.forView(tv_login,"Login","Click login if already have account")
                                .outerCircleColor(R.color.teal_200)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(23)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(15)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(50),
                        TapTarget.forView(edt_registername,"Name","Enter data to proceed")
                                .outerCircleColor(R.color.teal_200)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(23)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(15)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(50)).listener(new TapTargetSequence.Listener() {
            @Override
            public void onSequenceFinish() {

                Toast.makeText(getApplicationContext(),"Tour Finished",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

//                Toast.makeText(getApplicationContext(),"GREAT!",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSequenceCanceled(TapTarget lastTarget) {

            }
        }).start();
    }


}