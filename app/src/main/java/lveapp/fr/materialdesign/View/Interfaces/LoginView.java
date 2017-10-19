package lveapp.fr.materialdesign.View.Interfaces;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class LoginView {
    public interface ILogin{
        public void initialize();
        public void events();
        public void closeActivity();
        public void displayEmailError();
        public void displayPasswordError();
        public void displayToast(String text);
    }
    public interface IPresenter{}
}
