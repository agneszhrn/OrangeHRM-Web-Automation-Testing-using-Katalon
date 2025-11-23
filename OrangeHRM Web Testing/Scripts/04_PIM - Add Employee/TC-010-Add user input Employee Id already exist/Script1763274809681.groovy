import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// ========== Pre-Condition ==========
CustomKeywords.'login.LoginKeywords.loginToOrangeHRM'('Admin', 'admin123')

// ============ Test Steps ===========
// Click the PIM button on the left sidebar menu
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Common/menu_PIM'))

// Click the "Add Employee" button
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/button_AddEmployee'))

// Input Employee First Name
WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_LastName'), 'Harry1')

// Input Employee Last Name
WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_FirstName'), 'Potter1')

// Input Employee Id
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId_active'))
WebUI.sendKeys(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId_active'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId_active'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId_active'), '0123')

// Click button "Save"
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/button_Save'))

// =========== Validation ============
// Validation 1 : Verify the error message “Employee Id already exists” is displayed below the Employee Id field
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/errorMessage_EmployeeId_Required'))

// ============ End Test =============
WebUI.closeBrowser()