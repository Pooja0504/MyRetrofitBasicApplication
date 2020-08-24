package pooja.jadhav.myretrofitbasicapplication.fragments;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.regex.Pattern;

import pooja.jadhav.myretrofitbasicapplication.R;
import pooja.jadhav.myretrofitbasicapplication.activities.MainActivity;
import pooja.jadhav.myretrofitbasicapplication.extras.AppPreference;
import pooja.jadhav.myretrofitbasicapplication.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {

    EditText name_input,email_input,phone_input,password_input;
    Button register_button;
    public RegisterFragment()
    {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_register,container,false);
        name_input = view.findViewById(R.id.nameInput);
        email_input = view.findViewById(R.id.emailInput);
        phone_input = view.findViewById(R.id.phoneInput);
        password_input = view.findViewById(R.id.passwordInput);
        register_button = view.findViewById(R.id.regBtn);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regiterUser();
            }
        });


        return view;
    }

    private void regiterUser() {
        String name=name_input.getText().toString().trim();
        String email=email_input.getText().toString().trim();
        String phone=phone_input.getText().toString().trim();
        String password=password_input.getText().toString().trim();
        if (TextUtils.isEmpty(name))
        {
            MainActivity.appPreference.showToast("Enter your name");
        }
        if (TextUtils.isEmpty(email))
        {
            MainActivity.appPreference.showToast("Enter your email id");
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            MainActivity.appPreference.showToast("Email id is invalid");
        }else if (TextUtils.isEmpty(phone))
        {
            MainActivity.appPreference.showToast("Enter your phone number");
        }else if (TextUtils.isEmpty(password))
        {
            MainActivity.appPreference.showToast("Enter your passworrd");
        }else if (TextUtils.isEmpty(name))
        {
            MainActivity.appPreference.showToast("Enter your name");
        }
        else if (password.length()<6)
        {
            MainActivity.appPreference.showToast("Password too short!");
        }
        else{

            //data on server
            Call<User> userCall = MainActivity.serviceApi.doRegistration(name,email,phone,password);
            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(@NonNull Call<User> call,@NonNull Response<User> response) {
                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                    Log.i("My response",response.body().getResponse());
                }

                @Override
                public void onFailure(@NonNull Call<User> call,@NonNull Throwable t) {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                    System.out.println("MyError"+t.getMessage());
                }
            });
        }
    }
}
