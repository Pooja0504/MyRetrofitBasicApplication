package pooja.jadhav.myretrofitbasicapplication.fragments;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pooja.jadhav.myretrofitbasicapplication.R;
import pooja.jadhav.myretrofitbasicapplication.services.MyInterface;

public class LoginFragment extends Fragment {
    MyInterface myInterface;
    Button login_button;
    EditText emailInput_op,passwordInput_op;
    TextView registerTV_op;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login,container,false);
        emailInput_op=view.findViewById(R.id.emailInput);
        passwordInput_op=view.findViewById(R.id.passwordInput);
        login_button=view.findViewById(R.id.loginBtn);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Login", Toast.LENGTH_SHORT).show();
            }
        });
        registerTV_op=view.findViewById(R.id.registerTV);
        registerTV_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Register", Toast.LENGTH_SHORT).show();
                myInterface.register();

            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity= (Activity) context;
        myInterface= (MyInterface) activity;
    }
}