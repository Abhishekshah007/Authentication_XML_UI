package com.example.auth_ui;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignupScreenFragment extends Fragment {


private EditText email_id, password_box,full_name,company_name;
private AppCompatButton signup_btn;
private TextView login_btn;
    public SignupScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_signup_screen, container, false);
        email_id = view.findViewById(R.id.email_id);
        password_box = view.findViewById(R.id.password_box);
        full_name = view.findViewById(R.id.full_name);
        company_name = view.findViewById(R.id.company_name);

        signup_btn = view.findViewById(R.id.signup_btn);


        signup_btn.setOnClickListener(view1 -> {
            String email = email_id.getText().toString().trim();
            String password = password_box.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                email_id.setError("Please enter your email");
                email_id.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                email_id.setError("Please enter a valid email");
                email_id.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                password_box.setError("Please enter your password");
                password_box.requestFocus();
                return;
            }
            // Input validation successful, show success message
            Toast.makeText(getContext(), "Signup successful", Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            LoginScreenFragment loginFragment = new LoginScreenFragment();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, loginFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });


        return view;
    }
}