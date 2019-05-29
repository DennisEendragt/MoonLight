import com.limelight.preferences.PreferenceConfiguration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StreamPreferencesTest {

    //Arrange: Since most of these tests will be using similar information for their tests,
    // the arrange step is done outside of the unit test. The data that contains the following:

    // The default fps that is set when calculating the default bitrate
    private static final String defaultFps = "30";

    // All the resolution options, this list is used to check the width, heigth, bitrate and the correct resolution format
    private static final String[] resolutionOptions = {"360p", "480p", "720p", "1080p", "1440p", "4K"};

    // All the possible height options to validate the calculation
    private static final int[] resolutionHeightOptions = {360, 480, 720, 1080, 1440, 2160};

    // All the possible weigth options to validate the calculation
    private static final int[] resolutionWidthOptions = {640, 854, 1280, 1920, 2560, 3840};

    // All the default bitrate options(:default means if fps = "30") to validate the bitrate calculation
    private static final int[] bitrateOptions30fps = {1000, 1500, 5000, 10000, 20000, 40000};

    @Before
    public void setup() {

    }

    @Test
    public void getHeightTest() {
        int retrievedHeight;
        for (int i = 0; i < resolutionOptions.length; i++) {
            //Act: Calling the getHeigth method supplied with the current resolution(i), which will return an value.
            retrievedHeight = PreferenceConfiguration.getHeightFromResolutionString(resolutionOptions[i]);

            //Assert: If the method works as expected, the value of retrievedHeight should be the same as the
            //current value of resolutionHeightOptions(which contains the expected height values in order of resolution).
            Assert.assertEquals(retrievedHeight, resolutionHeightOptions[i]);
        }
    }

    @Test
    public void getWidthTest() {
        int retrievedWidth;
        for (int i = 0; i < resolutionOptions.length; i++) {
            //Act: Calling the getWidth method supplied with the current resolution(i), which will return an value.
            retrievedWidth = PreferenceConfiguration.getWidthFromResolutionString(resolutionOptions[i]);

            //Assert: If the method works as expected, the value of retrievedWidth should be the same as the
            //current value of resolutionWidthOptions(which contains the expected width values in order of resolution).
            Assert.assertEquals(retrievedWidth, resolutionWidthOptions[i]);
        }
    }

    @Test
    public void getResolutionTest() {
        String retrievedResolution;
        for (int i = 0; i < resolutionOptions.length; i++) {
            //Act: Calling the getResolution method supplied with the current width(i) and height(i), which will return an value.
            retrievedResolution = PreferenceConfiguration.getResolutionString(resolutionWidthOptions[i], resolutionHeightOptions[i]);

            //Assert: If the method works as expected, the value of retrievedResolution should be the same as the
            //current value of resolutionOptions(which contains the expected width values in order of resolution).
            Assert.assertEquals(retrievedResolution, resolutionOptions[i]);
        }
    }

    @Test
    public void getResolutionFormatTest() {
        String retrievedResolution;
        //Act: Calling the getResolution method supplied with the current width(i) and height(i), which will return an value.
        retrievedResolution = PreferenceConfiguration.getResolutionString(resolutionWidthOptions[0], resolutionHeightOptions[0]);

        //Assert: After receiving a value, the format has to be checked. The value should have more than one character
        //and less than five (to cover format mistakes like 19200p, which should be 1920p) and should also contain the letter "p".
        Assert.assertTrue(retrievedResolution.length() > 0 && retrievedResolution.length() <= 5 && retrievedResolution.contains("p"));
    }

    @Test
    public void getDefaultBitrate() {
        int calculatedDefaultBitrate;
        for (int i = 0; i < resolutionOptions.length; i++) {
            //Act: Calling the getDefaultBitrate method supplied with the current resolution(i) and the defaultFps(i), which will return an value.
            calculatedDefaultBitrate = PreferenceConfiguration.getDefaultBitrate(resolutionOptions[i], defaultFps);

            //Assert: If the method works as expected, the retrieved value should be a calculation that should be the same as the
            //current value of bitrateOptions30fps(which contains the expected bitrate values in order of resolution).
            Assert.assertEquals(calculatedDefaultBitrate, bitrateOptions30fps[i]);
        }
    }
}
