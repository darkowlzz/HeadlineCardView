package space.darkowlzz.headercardviewlibrary;

import android.content.Context;
import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import space.darkowlzz.headlinecardview.HeadlineCardView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class HeadlineCVRobolectricTest {

    MainActivity activity;
    HeadlineCardView hcv1, hcv2, hcv3, hcv4, hcv5, hcv6;
    Context ctx;

    private int getDimensionResource(int res) {
        return ctx.getResources().getDimensionPixelSize(res);
    }

    private int getColorResource(int res) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ctx.getResources().getColor(res, ctx.getTheme());
        } else {
            return ctx.getResources().getColor(res);
        }
    }

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        ctx = activity.getApplicationContext();
        hcv1 = (HeadlineCardView) activity.findViewById(R.id.headlineCard);
        hcv2 = (HeadlineCardView) activity.findViewById(R.id.headlineCard2);
        hcv3 = (HeadlineCardView) activity.findViewById(R.id.headlineCard3);
        hcv4 = (HeadlineCardView) activity.findViewById(R.id.headlineCard4);
        hcv5 = (HeadlineCardView) activity.findViewById(R.id.headlineCard5);
        hcv6 = (HeadlineCardView) activity.findViewById(R.id.headlineCard6);
    }

    @Test
    public void checkHeadlineTextValue() {
        String headlineString = ctx.getString(R.string.headlineTextValue);
        assertThat(hcv1.getHeadlineText(), is(headlineString));
        assertThat(hcv2.getHeadlineText(), is(headlineString));
        assertThat(hcv3.getHeadlineText(), is(headlineString));
        assertThat(hcv4.getHeadlineText(), is(headlineString));
        assertThat(hcv5.getHeadlineText(), is(headlineString));
        assertThat(hcv6.getHeadlineText(), is(headlineString));
    }

    @Test
    public void checkCardElevation() {
        assertThat(hcv1.getCardElevation(), is((float)getDimensionResource(R.dimen.card_elevation1)));
        assertThat(hcv2.getCardElevation(), is((float)getDimensionResource(R.dimen.card_elevation2)));
        assertThat(hcv3.getCardElevation(), is((float)getDimensionResource(R.dimen.default_card_elevation)));
        assertThat(hcv4.getCardElevation(), is((float)getDimensionResource(R.dimen.default_card_elevation)));
        assertThat(hcv5.getCardElevation(), is((float)getDimensionResource(R.dimen.default_card_elevation)));
        assertThat(hcv6.getCardElevation(), is((float)getDimensionResource(R.dimen.default_card_elevation)));
    }

    @Test
    public void checkBackgroundColor() {
        assertThat(hcv1.getBackgroundColor(), is(getColorResource(R.color.color_card1)));
        assertThat(hcv2.getBackgroundColor(), is(getColorResource(R.color.color_card2)));
        assertThat(hcv3.getBackgroundColor(), is(getColorResource(R.color.color_card_default)));
        assertThat(hcv4.getBackgroundColor(), is(getColorResource(R.color.color_card4)));
        assertThat(hcv5.getBackgroundColor(), is(getColorResource(R.color.color_card4)));
        assertThat(hcv6.getBackgroundColor(), is(getColorResource(R.color.color_card_default)));
    }

    @Test
    public void checkMenuEnabled() {
        assertThat(hcv1.getCardMenuEnabled(), is(true));
        assertThat(hcv2.getCardMenuEnabled(), is(true));
        assertThat(hcv3.getCardMenuEnabled(), is(false));
        assertThat(hcv4.getCardMenuEnabled(), is(true));
        assertThat(hcv5.getCardMenuEnabled(), is(true));
        assertThat(hcv6.getCardMenuEnabled(), is(true));
    }

    @Test
    public void checkHeadlineTextColor() {
        assertThat(hcv5.getHeadlineColor(), is(getColorResource(R.color.color_headline5)));
        assertThat(hcv6.getHeadlineColor(), is(getColorResource(R.color.color_headline6)));
    }

    @Test
    public void checkHeadlineTextSize() {
        assertThat(hcv6.getHeadlineTextSize(), is((float)getDimensionResource(R.dimen.headline_textSize6)));
    }

    @Test
    public void checkHeadlineAlignParentLeft() {
        assertThat(hcv1.isHeadlineAlignParentLeft(), is(false));
        assertThat(hcv2.isHeadlineAlignParentLeft(), is(true));
        assertThat(hcv3.isHeadlineAlignParentLeft(), is(false));
        assertThat(hcv4.isHeadlineAlignParentLeft(), is(false));
        assertThat(hcv5.isHeadlineAlignParentLeft(), is(false));
        assertThat(hcv6.isHeadlineAlignParentLeft(), is(false));
    }

    @Test
    public void checkHeadlineAlignParentRight() {
        assertThat(hcv1.isHeadlineAlignParentRight(), is(false));
        assertThat(hcv2.isHeadlineAlignParentRight(), is(false));
        assertThat(hcv3.isHeadlineAlignParentRight(), is(true));
        assertThat(hcv4.isHeadlineAlignParentRight(), is(false));
        assertThat(hcv5.isHeadlineAlignParentRight(), is(false));
        assertThat(hcv6.isHeadlineAlignParentRight(), is(false));
    }

    @Test
    public void checkHeadlineCenterInParent() {
        assertThat(hcv1.isHeadlineCenterInParent(), is(true));
        assertThat(hcv2.isHeadlineCenterInParent(), is(false));
        assertThat(hcv3.isHeadlineCenterInParent(), is(false));
        assertThat(hcv4.isHeadlineCenterInParent(), is(false));
        assertThat(hcv5.isHeadlineCenterInParent(), is(false));
        assertThat(hcv6.isHeadlineCenterInParent(), is(true));
    }

    @Test
    public void checkHeadlinePadding() {
        assertThat(hcv1.getHeadlinePadding(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv2.getHeadlinePadding(), is(getDimensionResource(R.dimen.headline_padding2)));
        assertThat(hcv3.getHeadlinePadding(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv4.getHeadlinePadding(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv5.getHeadlinePadding(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv6.getHeadlinePadding(), is(getDimensionResource(R.dimen.headline_padding_default)));
    }

    @Test
    public void checkHeadlinePaddingRight() {
        assertThat(hcv1.getHeadlinePaddingRight(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv2.getHeadlinePaddingRight(), is(getDimensionResource(R.dimen.headline_padding2)));
        assertThat(hcv3.getHeadlinePaddingRight(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv4.getHeadlinePaddingRight(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv5.getHeadlinePaddingRight(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv6.getHeadlinePaddingRight(), is(getDimensionResource(R.dimen.headline_padding_default)));
    }

    @Test
    public void checkHeadlinePaddingLeft() {
        assertThat(hcv1.getHeadlinePaddingLeft(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv2.getHeadlinePaddingLeft(), is(getDimensionResource(R.dimen.headline_padding2)));
        assertThat(hcv3.getHeadlinePaddingLeft(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv4.getHeadlinePaddingLeft(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv5.getHeadlinePaddingLeft(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv6.getHeadlinePaddingLeft(), is(getDimensionResource(R.dimen.headline_padding_default)));
    }

    @Test
    public void checkHeadlinePaddingTop() {
        assertThat(hcv1.getHeadlinePaddingTop(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv2.getHeadlinePaddingTop(), is(getDimensionResource(R.dimen.headline_padding2)));
        assertThat(hcv3.getHeadlinePaddingTop(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv4.getHeadlinePaddingTop(), is(getDimensionResource(R.dimen.headline_padding_top4)));
        assertThat(hcv5.getHeadlinePaddingTop(), is(getDimensionResource(R.dimen.headline_padding_top4)));
        assertThat(hcv6.getHeadlinePaddingTop(), is(getDimensionResource(R.dimen.headline_padding_default)));
    }

    @Test
    public void checkHeadlinePaddingBottom() {
        assertThat(hcv1.getHeadlinePaddingBottom(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv2.getHeadlinePaddingBottom(), is(getDimensionResource(R.dimen.headline_padding2)));
        assertThat(hcv3.getHeadlinePaddingBottom(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv4.getHeadlinePaddingBottom(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv5.getHeadlinePaddingBottom(), is(getDimensionResource(R.dimen.headline_padding_default)));
        assertThat(hcv6.getHeadlinePaddingBottom(), is(getDimensionResource(R.dimen.headline_padding_default)));
    }
}
