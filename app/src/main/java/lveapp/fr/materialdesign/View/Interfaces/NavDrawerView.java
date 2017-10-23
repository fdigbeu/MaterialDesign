package lveapp.fr.materialdesign.View.Interfaces;

/**
 * Created by Maranatha on 19/10/2017.
 */

public class NavDrawerView {
    public interface INavDrawer{
        /**
         * Initialize widgets
         */
        public void initialize();

        /**
         * Manage Widgets events
         */
        public void events();
    }

    /**
     * Presenter
     */
    public interface IPresenter{}
}
