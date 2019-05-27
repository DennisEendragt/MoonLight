import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Display;

import com.limelight.R;
import com.limelight.preferences.AddComputerManually;
import com.limelight.preferences.PreferenceConfiguration;
import com.limelight.preferences.StreamSettings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.robolectric.util.FragmentTestUtil;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StreamDataTest {

    private static final String resoultion = "720p";
    private static final String fps = "60";

    @Mock
    Context mockContext;

    @Before
    public void setup(){

    }

    @Test
    public void getDefaultBitrate() {
        int calculatedDefaultBitrate = 0;
        calculatedDefaultBitrate = PreferenceConfiguration.getDefaultBitrate(resoultion, fps);
        Assert.assertTrue(calculatedDefaultBitrate > 0);
    }
}
