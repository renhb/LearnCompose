package learn.compose.example

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import org.junit.Rule
import org.junit.Test

class CounterTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun counterInitTest() {
        composeTestRule.onRoot().printToLog("Counter")
        val buttonText = "Add 1"
        composeTestRule.onAllNodesWithText(buttonText).assertAll(hasText(buttonText))
        composeTestRule.onRoot().printToLog("Test")
    }

    @Test
    fun counterIncrementTest() {
        val buttonText = "Add 1"
        val contentText = "This is 1"
        composeTestRule.onNodeWithText(buttonText).performClick()
        composeTestRule.onNodeWithText(contentText).assertExists()
        composeTestRule.onRoot().printToLog("Counter")
    }


}
