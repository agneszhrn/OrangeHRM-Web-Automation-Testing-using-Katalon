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
WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_LastName'), 'Harry')

// Input Employee Last Name
WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_FirstName'), 'Potter')

// Input Employee Id
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId_active'))

WebUI.sendKeys(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId_active'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId_active'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId_active'), '0123')

// Click button "Save"
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/button_Save'))

// =========== Validation ============
// Validation 1 : Verify the “Successfully Saved” pop-up notification message is present within 2 seconds
WebUI.verifyElementText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved'), 'Successfully Saved')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved'), 2)

// Validation 2 : Verify the First Name field value attribute is “Personals Details”
WebUI.verifyElementText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/text_PersonalsDetails'), 'Personal Details')

// Validation 3 : Verify the First Name field value attribute is “Harry”
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_LastName'), 'value', 'Harry', 0)

// Validation 4 : Verify the Last Name field value attribute is “Potter”
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_FirstName'), 'value', 'Potter', 0)

// Validation 5 : Verify the Employee ID field value attribute is “0123”
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId'), 'value', '0123', 0)

// ============ End Test =============
WebUI.closeBrowser()