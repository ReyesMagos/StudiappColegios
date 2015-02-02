package co.reyesmagos.studiappcolegios.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseUser;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.activities.teachers.HomeWorksFragment;
import co.reyesmagos.studiappcolegios.controladores.LoginController;
import co.reyesmagos.studiappcolegios.fragments.CalendarFragment;
import co.reyesmagos.studiappcolegios.fragments.ConfigurationFragmentActivity;
import co.reyesmagos.studiappcolegios.fragments.NavigationDrawerFragment;
import co.reyesmagos.studiappcolegios.fragments.NotasFragmentActivity;
import co.reyesmagos.studiappcolegios.fragments.NotificacionesFragmentActivity;
import co.reyesmagos.studiappcolegios.fragments.TareasFragmentActivity;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.teacher.HorarioFragment;
import co.reyesmagos.studiappcolegios.fragments.teachers.GroupsActivityFragment;
import co.reyesmagos.studiappcolegios.fragments.teachers.HomeTeacherActivity;


public class NavigationActivityMain extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing co.reyesmagos.aplicacioncolegios.fragments
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = null;

        if (ParseUser.getCurrentUser().get("rol").equals("Padre")) {
            switch (position) {
                case 0:
                    fragment = new NotificacionesFragmentActivity();
                    break;
                case 1:
                    fragment = new NotificacionesFragmentActivity();
                    break;
                case 2:
                    fragment = new TareasFragmentActivity();
                    //fragment = new CalendarFragment();
                    break;
                case 3:
                    fragment = new NotasFragmentActivity();
                    break;
                case 4:
                    break;
                case 5:
                    fragment = new ConfigurationFragmentActivity();
                    break;
                case 6:
                    break;
                case 7:
                    //fragment = new NotificacionesFragmentActivity();
                    //LoginController loginController = new LoginController(this);
                    //loginController.logoutUser();
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this).setMessage("¿Desea cerrar Sesión?")
                            .setTitle("Alerta").setCancelable(true).setPositiveButton("Salir", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    ParseUser.logOut();
                                    ParseUser parseUser = ParseUser.getCurrentUser();
                                    NavigationActivityMain.this.finish();
                                    //System.exit(0);
                                }
                            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alertDialog2 = alertDialog.create();

                    alertDialog2.show();
                    return;

            }
        } else {
            switch (position) {
                case 0:
                    fragment = new HomeTeacherActivity();
                    break;
                case 1:
                    fragment = new HomeTeacherActivity();
                    break;
                case 2:
                    fragment = new GroupsActivityFragment();
                    break;
                case 3:
                    fragment = new HorarioFragment();
                    break;
                case 4:
                    fragment = new CalendarFragment();
                    break;
                case 5:

                    fragment = new HomeWorksFragment();
                    break;
                case 6:
                    break;
                case 7:
                    //LoginController loginController = new LoginController(this);
                    //loginController.logoutUser();
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this).setMessage("¿Desea cerrar Sesión?")
                            .setTitle("Alerta").setCancelable(true).setPositiveButton("Salir", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    ParseUser.logOut();
                                    ParseUser parseUser = ParseUser.getCurrentUser();
                                    NavigationActivityMain.this.finish();
                                    //System.exit(0);
                                }
                            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alertDialog2 = alertDialog.create();

                    alertDialog2.show();
                    return;

            }
        }

        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment).commit();

    }

    public void onSectionAttached(int number) {

        String m;
        switch (number) {

            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3498db")));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.navigation_activity_main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        /*
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_navigation_activity_main, container, false);
            return rootView;
        }*/

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((NavigationActivityMain) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
