import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.RallyScreen
import com.example.compose.rally.ui.components.RallyTopAppBar
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Before
    fun setupTopAppBar() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTheme {
                RallyTopAppBar(
                    allScreens = allScreens,
                    onTabSelected = { /*TODO*/ },
                    currentScreen = RallyScreen.Accounts
                )
            }
        }
    }

    @Test
    fun rallyTopAppBarTest() {

//        Thread.sleep(5000)
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()
    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

//        composeTestRule
//            .onNodeWithContentDescription (RallyScreen.Accounts.name)
//            .assertExists()

        composeTestRule.onNode(
    hasText(RallyScreen.Accounts.name.uppercase(Locale.getDefault())) and
            hasParent(
                hasContentDescription(RallyScreen.Accounts.name)
            ),
            useUnmergedTree = true
        ).assertExists()
    }

    @Test
    fun rallyTopAppBarTest_clickBills() {

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Bills.name).apply {
            performClick()
        }
        // TODO assert using the state
    }
}