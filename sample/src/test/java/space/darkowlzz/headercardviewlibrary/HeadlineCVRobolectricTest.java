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

}
