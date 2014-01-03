package com.Megadodo.Canary.test;

import com.Megadodo.canary.MainActivity;
import com.Megadodo.canary.R;
import org.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class CanaryUnitTests {

    @Test
    public void shouldHaveHappySmiles() throws Exception {
        String hello = new MainActivity().getResources().getString(R.string.string_to_be_displayed);
        assertThat(hello, equalTo("Hello World, MyActivity!"));
    }
}