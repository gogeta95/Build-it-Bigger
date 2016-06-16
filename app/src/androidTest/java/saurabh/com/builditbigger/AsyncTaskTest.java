package saurabh.com.builditbigger;

import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;

/**
 * Created by singh on 15-06-2016.
 */

public class AsyncTaskTest extends InstrumentationTestCase {
    private static boolean called;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        called = false;
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public final void testSuccessFullFetch() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
            }
        });

    }
}
