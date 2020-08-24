package pooja.jadhav.myretrofitbasicapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import pooja.jadhav.myretrofitbasicapplication.R;
import pooja.jadhav.myretrofitbasicapplication.constants.Constant;
import pooja.jadhav.myretrofitbasicapplication.extras.AppPreference;
import pooja.jadhav.myretrofitbasicapplication.fragments.LoginFragment;
import pooja.jadhav.myretrofitbasicapplication.fragments.ProfileFragment;
import pooja.jadhav.myretrofitbasicapplication.fragments.RegisterFragment;
import pooja.jadhav.myretrofitbasicapplication.services.MyInterface;
import pooja.jadhav.myretrofitbasicapplication.services.RetrofitClient;
import pooja.jadhav.myretrofitbasicapplication.services.ServiceApi;

public class MainActivity extends AppCompatActivity implements MyInterface {

    FrameLayout container_fragment;
    public static AppPreference appPreference;
    public static ServiceApi serviceApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container_fragment = findViewById(R.id.fragment_container);
        appPreference = new AppPreference(this);
        serviceApi= RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApi.class);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new LoginFragment())
                .commit();

    }

    @Override
    public void register() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new RegisterFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void login(String name, String email, String created_at) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new ProfileFragment())

                .commit();


    }

    @Override
    public void logout() {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new LoginFragment())

                .commit();

    }


}
