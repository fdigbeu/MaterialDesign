package lveapp.fr.materialdesign.View.Interfaces;

import android.app.Activity;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class MainView {
    public interface IMain{
        /**
         * Initialize widgets
         */
        public void initialize();

        /**
         * Manage Widgets events
         */
        public void events();

        /**
         * Launch to show activity
         * @param c : destination activity class
         */
        public void launch(Class c);
    }
}
