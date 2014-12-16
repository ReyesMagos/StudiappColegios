package co.reyesmagos.studiappcolegios.fragments.util;

/**
 * Created by Alexis-PC on 29/11/2014.
 */
public class NavigationDrawItem {

    private String title;
    private int icon;
    private String count;
    private boolean isCounterVisible = false;

    public NavigationDrawItem(){

    }

    public NavigationDrawItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public NavigationDrawItem(String title, int icon, boolean isCounterVisible, String count){
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public boolean isCounterVisible() {
        return isCounterVisible;
    }

    public void setCounterVisible(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }
}
