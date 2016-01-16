# HeadlineCardView
Android CardView for just Headlines and optional menu

![Demo](/images/demo-screenshot.png)

## Usage

Add HeadlineCardView to the project and create a HeadlineCardView to layout like:

```xml
<space.darkowlzz.headlinecardview.HeadlineCardView
        android:id="@+id/headlineCard"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="7dp"
        android:layout_marginBottom="7dp"
        headlinecard:headline_text="Headline Text"
        headlinecard:headline_padding="10dp"
        headlinecard:headline_style="@android:style/TextAppearance.Large"
        headlinecard:headline_align_centerInParent="true"
        headlinecard:background_color="#44B449"
        headlinecard:card_elevation="10dp"
        headlinecard:menu_enabled="true"
        headlinecard:menu_options="@menu/headline_menu_options"
        headlinecard:menuicon_padding="5dp"
        headlinecard:menuicon_align_parentRight="true"
        headlinecard:menuicon_align_centerVertical="true"
        android:clickable="true"
        android:foreground="?android:attr/selectableItemBackground"/>
```

Add the namespace as
```xml
xmlns:headlinecard="http://schemas.android.com/apk/res-auto"
```

`headlinecard:menu_options` refers to a `menu` resource file with menu `items` like
```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/add"
        android:title="Add"/>
    <item android:id="@+id/del"
        android:title="Delete"/>
    <item android:id="@+id/undo"
        android:title="Undo"/>
</menu>
```

To add click listeners to each of these menu items define a `MenuClickHandler()` and pass it to `setMenuOptionsHandler` of a `HeadlineCardView` object.
```java
HeadlineCardView headlineCardView = (HeadlineCardView) findViewById(R.id.headlineCard);
headlineCardView.setMenuOptionsHandler(new HeadlineCardView.MenuClickHandler() {
    @Override
    public void onMenuOptionClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.del:
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.undo:
                Toast.makeText(getApplicationContext(), "Undo", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), "Unknown option", Toast.LENGTH_SHORT).show();
        }
    }
});
```

Learn more about the available attribuetes from [here](https://github.com/darkowlzz/HeadlineCardView/blob/master/headlinecardview/src/main/res/values/attr.xml).


## Gradle

Not yet available in bintray.

```groovy
dependencies {
    compile 'space.darkowlzz:headlineCardView:UNAVAILABLE'
}
```

## LICENSE

MIT &copy; 2016 Sunny (darkowlzz)
