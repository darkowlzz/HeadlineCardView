package space.darkowlzz.headlinecardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.widget.PopupMenu;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by sunny on 16/01/16.
 */
public class HeadlineCardView extends android.support.v7.widget.CardView {

    private final int DEFAULT_HEADLINE_TEXT_SIZE = 0;

    private String headlineText = "";
    private TextView headlineTextView;
    private int headlineStyle;
    private float headlineTextSize;
    private int backgroundColor; // background of the whole headline card
    private ImageView cardMenuIcon;
    private Boolean cardMenuEnabled;
    private int menuItemsResource;
    private float cardElevation;
    private int headlineColor;

    // Headline text padding
    private int headlinePadding;
    private int headlinePaddingRight;
    private int headlinePaddingLeft;
    private int headlinePaddingTop;
    private int headlinePaddingBottom;

    // Menu icon padding
    private int menuIconPadding;
    private int menuIconPaddingRight;
    private int menuIconPaddingLeft;
    private int menuIconPaddingTop;
    private int menuIconPaddingBottom;

    // Headline alignment
    private boolean headlineAlignParentRight;
    private boolean headlineAlignParentLeft;
    private boolean headlineCenterInParent;

    // Menu icon alignment
    private boolean menuIconAlignParentRight;
    private boolean menuIconAlignParentLeft;
    private boolean menuIconCenterVertical;


    /** Getters **/

    public int getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public float getCardElevation() {
        return cardElevation;
    }

    public Boolean getCardMenuEnabled() {
        return cardMenuEnabled;
    }

    public ImageView getCardMenuIcon() {
        return cardMenuIcon;
    }

    public int getHeadlineColor() {
        return headlineColor;
    }

    public int getHeadlineStyle() {
        return headlineStyle;
    }

    public String getHeadlineText() {
        return headlineText;
    }

    public float getHeadlineTextSize() {
        return headlineTextSize;
    }

    public TextView getHeadlineTextView() {
        return headlineTextView;
    }

    public int getMenuItemsResource() {
        return menuItemsResource;
    }

    public boolean isHeadlineAlignParentLeft() {
        return headlineAlignParentLeft;
    }

    public boolean isHeadlineAlignParentRight() {
        return headlineAlignParentRight;
    }

    public boolean isHeadlineCenterInParent() {
        return headlineCenterInParent;
    }

    public int getHeadlinePadding() {
        return headlinePadding;
    }

    public int getHeadlinePaddingBottom() {
        return headlinePaddingBottom;
    }

    public int getHeadlinePaddingLeft() {
        return headlinePaddingLeft;
    }

    public int getHeadlinePaddingRight() {
        return headlinePaddingRight;
    }

    public int getHeadlinePaddingTop() {
        return headlinePaddingTop;
    }

    public boolean isMenuIconAlignParentLeft() {
        return menuIconAlignParentLeft;
    }

    public boolean isMenuIconAlignParentRight() {
        return menuIconAlignParentRight;
    }

    public boolean isMenuIconCenterVertical() {
        return menuIconCenterVertical;
    }

    public int getMenuIconPadding() {
        return menuIconPadding;
    }

    public int getMenuIconPaddingBottom() {
        return menuIconPaddingBottom;
    }

    public int getMenuIconPaddingLeft() {
        return menuIconPaddingLeft;
    }

    public int getMenuIconPaddingRight() {
        return menuIconPaddingRight;
    }

    public int getMenuIconPaddingTop() {
        return menuIconPaddingTop;
    }


    /** Constructors **/

    public interface MenuClickHandler {
        void onMenuOptionClick(MenuItem item);
    }

    public HeadlineCardView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.headlinecard_layout, this);
    }

    public HeadlineCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public HeadlineCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context, attrs);
    }


    /** Helper methods **/

    private int getDimensionResource(int res) {
        return getResources().getDimensionPixelSize(res);
    }

    private int getColorResource(int res) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getResources().getColor(res, getContext().getTheme());
        } else {
            return getResources().getColor(res);
        }
    }

    /** View initializer **/

    private void initViews(final Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.HeadlineCardView, 0, 0);

        try {
            headlineText = a.getString(R.styleable.HeadlineCardView_headline_text);
            headlineStyle = a.getResourceId(R.styleable.HeadlineCardView_headline_style, android.R.style.TextAppearance_Medium);
            headlineTextSize = a.getDimensionPixelSize(R.styleable.HeadlineCardView_headline_textSize, DEFAULT_HEADLINE_TEXT_SIZE);
            cardMenuEnabled = a.getBoolean(R.styleable.HeadlineCardView_menu_enabled, false);
            menuItemsResource = a.getResourceId(R.styleable.HeadlineCardView_menu_options, R.menu.default_options);
            cardElevation = a.getDimensionPixelSize(R.styleable.HeadlineCardView_card_elevation,
                                                    getDimensionResource(R.dimen.default_card_elevation));

            // Assign the generic padding value to allPadding if provided
            headlinePadding = a.getDimensionPixelSize(R.styleable.HeadlineCardView_headline_padding,
                                                    getDimensionResource(R.dimen.default_headline_padding));
            // Use the new headlinePadding or the default headlinePadding value to set the other padding
            headlinePaddingRight = a.getDimensionPixelSize(R.styleable.HeadlineCardView_headline_paddingRight, headlinePadding);
            headlinePaddingLeft = a.getDimensionPixelSize(R.styleable.HeadlineCardView_headline_paddingLeft, headlinePadding);
            headlinePaddingTop = a.getDimensionPixelSize(R.styleable.HeadlineCardView_headline_paddingTop, headlinePadding);
            headlinePaddingBottom = a.getDimensionPixelSize(R.styleable.HeadlineCardView_headline_paddingBottom, headlinePadding);

            headlineAlignParentRight = a.getBoolean(R.styleable.HeadlineCardView_headline_align_parentRight, false);
            headlineAlignParentLeft = a.getBoolean(R.styleable.HeadlineCardView_headline_align_parentLeft, false);
            headlineCenterInParent = a.getBoolean(R.styleable.HeadlineCardView_headline_align_centerInParent, false);

            // Assign the generic padding value to allPadding if provided
            menuIconPadding = a.getDimensionPixelSize(R.styleable.HeadlineCardView_menuicon_padding,
                                                    getDimensionResource(R.dimen.default_menuicon_padding));
            // Use the new menuIconPadding or the default menuIconPadding value to set the other padding
            menuIconPaddingRight = a.getDimensionPixelSize(R.styleable.HeadlineCardView_menuicon_paddingRight, menuIconPadding);
            menuIconPaddingLeft = a.getDimensionPixelSize(R.styleable.HeadlineCardView_menuicon_paddingLeft, menuIconPadding);
            menuIconPaddingTop = a.getDimensionPixelSize(R.styleable.HeadlineCardView_menuicon_paddingTop, menuIconPadding);
            menuIconPaddingBottom = a.getDimensionPixelSize(R.styleable.HeadlineCardView_menuicon_paddingBottom, menuIconPadding);

            menuIconAlignParentRight = a.getBoolean(R.styleable.HeadlineCardView_menuicon_align_parentRight, false);
            menuIconAlignParentLeft = a.getBoolean(R.styleable.HeadlineCardView_menuicon_align_parentLeft, false);
            menuIconCenterVertical = a.getBoolean(R.styleable.HeadlineCardView_menuicon_align_centerVertical, false);

            backgroundColor = a.getColor(R.styleable.HeadlineCardView_background_color, getColorResource(R.color.defaultBackground));
            headlineColor = a.getColor(R.styleable.HeadlineCardView_headline_textColor, getColorResource(R.color.defaultHeadlineText));
        } finally {
            a.recycle();
        }

        // Inflate layout of the whole view
        LayoutInflater.from(context).inflate(R.layout.headlinecard_layout, this);

        headlineTextView = (TextView) this.findViewById(R.id.headline);
        cardMenuIcon = (ImageView) this.findViewById(R.id.optionsMenu);

        // Set headline text content
        headlineTextView.setText(headlineText);
        // Set textAppearance of headline
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            headlineTextView.setTextAppearance(headlineStyle);
        } else {
            headlineTextView.setTextAppearance(context, headlineStyle);
        }
        // Set headline text color
        headlineTextView.setTextColor(headlineColor);

        // set textSize only when it's other than the default value of DEFAULT_HEADLINE_TEXT_SIZE i.e. 0
        if (headlineTextSize != DEFAULT_HEADLINE_TEXT_SIZE) {
            headlineTextView.setTextSize(headlineTextSize);
        }

        // Set headline padding
        headlineTextView.setPadding(headlinePaddingLeft, headlinePaddingTop, headlinePaddingRight, headlinePaddingBottom);
        // Set menu icon padding
        cardMenuIcon.setPadding(menuIconPaddingLeft, menuIconPaddingTop, menuIconPaddingRight, menuIconPaddingBottom);

        // Set headline cardview background
        setCardBackgroundColor(backgroundColor);
        // Set headline cardview elevation
        setCardElevation(cardElevation);
        // Set menu visibility
        cardMenuIcon.setVisibility(cardMenuEnabled ? VISIBLE : INVISIBLE);

        // Get headline textview layout params
        RelativeLayout.LayoutParams headlineLayoutParams = (RelativeLayout.LayoutParams)headlineTextView.getLayoutParams();
        // Set headline layout params
        if (headlineAlignParentRight) {
            headlineLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        }
        if (headlineAlignParentLeft) {
            headlineLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        }
        if (headlineCenterInParent) {
            headlineLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        }

        // Get menu icon layout params
        RelativeLayout.LayoutParams menuLayoutParams = (RelativeLayout.LayoutParams)cardMenuIcon.getLayoutParams();
        // Set menu icon layout params
        // Left/Right alignment
        if (menuIconAlignParentRight) {
            menuLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        }
        if (menuIconAlignParentLeft) {
            menuLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        }
        // Vertically center alignment
        if (menuIconCenterVertical) {
            menuLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        }

        // if menu is enabled, set default menu onclick listener
        if (cardMenuEnabled) {
            cardMenuIcon.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(context, v);
                    MenuInflater inflater = popup.getMenuInflater();
                    inflater.inflate(menuItemsResource, popup.getMenu());
                    popup.show();
                }
            });
        }
    }

    // Should be used to set custom menu onclick listener
    public void setMenuOptionsHandler(final MenuClickHandler clickHandler) {
        cardMenuIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getContext(), v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(menuItemsResource, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        clickHandler.onMenuOptionClick(item);
                        return true;
                    }
                });
                popup.show();
            }
        });
    }
}