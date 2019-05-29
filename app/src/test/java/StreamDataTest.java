import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.KeyEvent;

import com.limelight.R;
import com.limelight.binding.input.KeyboardTranslator;
import com.limelight.binding.input.TouchContext;
import com.limelight.preferences.AddComputerManually;
import com.limelight.preferences.PreferenceConfiguration;
import com.limelight.preferences.StreamSettings;
import com.limelight.utils.Vector2d;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.robolectric.util.FragmentTestUtil;

import java.util.Random;

import static android.view.KeyEvent.KEYCODE_POUND;
import static com.limelight.binding.input.KeyboardTranslator.KEY_PREFIX;
import static com.limelight.binding.input.KeyboardTranslator.VK_0;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class StreamDataTest {

    @Mock
    Context mockContext;

    @Before
    public void setup(){

    }

    @Test
    public void vector2DScalarMultiplyTest() {
        //Arrange: When dealing with user input, the application works with the x and y axis by using 2d vectors
        //To test the scalarmultiplication method of the used class Vector2d, we first declare the multiplication factor\
        //Followed by a random x and y value, followed by their respective multiplications.
        int multiplicationFactor = 5;

        float valueX = new Random().nextInt(100);
        float valueY = new Random().nextInt(100);

        float multipliedX = valueX * multiplicationFactor;
        float multipliedY = valueY * multiplicationFactor;


        Vector2d v2d = new Vector2d();
        v2d.initialize(valueX, valueY);

        //Act: Calling the scalarmultiply method supplied by the specified multiplicationfactor
        v2d.scalarMultiply(multiplicationFactor);

        //Assert: If the method works properly, the x and y value of the vector should be equal to
        //the specified multiplications created during the arranging stage of the test
        assertTrue(((v2d.getX() == multipliedX) && (v2d.getY() == multipliedY)));
    }

    @Test
    public void keyNeedsShiftTest(){
        //Arrange: When receiving user input from the user, we sometimes get keycodes that need shifting.
        //All of the keycodes that need shifting are provided in the array below. We than proceed to run the
        //test using a random keycode from the array.
        int[] shiftNeedingKeyCodes = new int[] {
                KeyEvent.KEYCODE_AT,
                KeyEvent.KEYCODE_POUND,
                KeyEvent.KEYCODE_PLUS,
                KeyEvent.KEYCODE_STAR};

        int randomShiftNeedingKeyCode = shiftNeedingKeyCodes[
                new Random().nextInt(shiftNeedingKeyCodes.length)];

        //Act: We register the returned value of the method which can be true or false
        boolean result = KeyboardTranslator.needsShift(randomShiftNeedingKeyCode);

        //Assert: The expected value of the result should be true, as we're using a key which needs shifting
        assertTrue(result);
    }


    @Test
    public void translateKeyToGFEKeyCodeTest(){
        //This test makes use of the FIRST testing principle.

        //Arrange: Mimicking a user provided keycode and converting it, the expectedresult should be the
        //GFE keycode conversion of the converted keycode.
        int keyCode = KeyEvent.KEYCODE_9;
        int conversion = (keyCode - KeyEvent.KEYCODE_0) + VK_0;
        short expectedResult = (short) ((KEY_PREFIX << 8) | conversion);

        //Act: Converting the supplied keycode to a GFE keycode
        short result = KeyboardTranslator.translate(keyCode);

        //Assert: Asserting that the result equals the expected result
        assertEquals(KeyboardTranslator.translate(keyCode), expectedResult);
    }
}
