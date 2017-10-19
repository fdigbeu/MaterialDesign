package lveapp.fr.materialdesign.Presenter;

import android.support.design.widget.TextInputEditText;
import android.view.View;

import java.util.HashMap;
import java.util.Hashtable;

import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Interfaces.LoginView;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class LoginPresenter {
    private LoginView.ILogin iLogin;

    public LoginPresenter(LoginView.ILogin iLogin) {
        this.iLogin = iLogin;
    }

    public void loadData(){
        iLogin.initialize();
        iLogin.events();
    }

    public void retrieveUserAction(View view, Hashtable<String, String> enterData){
        switch (view.getId()){
            case R.id.btnLoginPassword:
                if(enterData.get("email") != null && enterData.get("password") != null){
                    if(!CommonPresenter.emailValidator(enterData.get("email"))){
                        iLogin.displayEmailError();
                        return;
                    }
                    //--
                    if(enterData.get("password").length()==0){
                        iLogin.displayPasswordError();
                        return;
                    }
                    //--
                    iLogin.displayToast("Success full! {"+enterData.get("email")+" : "+enterData.get("password")+"}");
                    iLogin.closeActivity();
                }
                else{
                    if(enterData.get("email") == null){
                        iLogin.displayEmailError();
                        return;
                    }
                    //--
                    if(enterData.get("password") == null){
                        iLogin.displayPasswordError();
                        return;
                    }
                }
                break;
        }
    }
}
