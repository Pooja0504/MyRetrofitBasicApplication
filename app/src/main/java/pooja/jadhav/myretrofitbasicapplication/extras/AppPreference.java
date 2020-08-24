package pooja.jadhav.myretrofitbasicapplication.extras;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import pooja.jadhav.myretrofitbasicapplication.R;

public class AppPreference {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public AppPreference(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(String.valueOf(R.string.s_pre_file),Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();
    }
    //Login status
    public void setLoginStatus(boolean status)
    {
        editor.putBoolean(String.valueOf(R.string.s_pre_login_status),status);
        editor.commit();
    }
    public boolean getLoginStatus()
    {
        return sharedPreferences.getBoolean(String.valueOf(R.string.s_pre_login_status),false);
    }
    //Name
    public void setDisplayName(String name)
    {
        editor.putString(String.valueOf(R.string.s_pre_login_name),"Name");
        editor.commit();
    }
    public String getDisplayName()
    {
        return sharedPreferences.getString(String.valueOf(R.string.s_pre_login_name),"Name");

    }
//Email
    public void setDisplayemail(String name)
    {
        editor.putString(String.valueOf(R.string.s_pre_login_email),"Email");
        editor.commit();
    }
    public String getDisplayemail()
    {
        return sharedPreferences.getString(String.valueOf(R.string.s_pre_login_email),"Email");

    }
//Date
    public void setDisplaydate(String name)
    {
        editor.putString(String.valueOf(R.string.s_pre_login_date),"Date");
        editor.commit();
    }
    public String getDisplaydate()
    {
        return sharedPreferences.getString(String.valueOf(R.string.s_pre_login_date),"Date");

    }
    public void showToast(String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
