import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import saurabh.com.builditbigger.MainActivity;
import saurabh.com.builditbigger.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by singh on 17-06-2016.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class JokesTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void jokesLoaded() throws InterruptedException {
        onView(withId(R.id.button)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.recycler_view)).check(matches(hasDescendant(withText("Girl: You would be a good dancer except for two things. \nBoy: What are the two things? \nGirl: Your feet. "))));
    }
}
