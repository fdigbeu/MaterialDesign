package lveapp.fr.materialdesign.View.Interfaces;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class BottomNavView {
    public interface IBottomNav{
        public void initialize();
        public void events();
        public void displayContent(String text);
    }
}
