package com.example.locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

import com.vsoft.elements.core.BaseElement;



public enum DocuCite implements BaseElement {

	editUsername(MobileBy.id("com.hycite.docucite:id/input_username"),MobileBy.xpath("//XCUIElementTypeTextField[@value='Username']")),
	teditPassword(MobileBy.id("com.hycite.docucite:id/input_password"),MobileBy.xpath("//XCUIElementTypeSecureTextField[@value='Password']")),
	btnLogin(MobileBy.id("com.hycite.docucite:id/btnGifLogin"),MobileBy.AccessibilityId("animation")),
	
	lstSelectLanguage(MobileBy.xpath("//android.widget.CheckedTextView[@text='replaceit']"),MobileBy.xpath("//XCUIElementTypeStaticText[@name='replaceit']")),
	btnAllowDocuCite(MobileBy.id("com.android.packageinstaller:id/permission_allow_button"),MobileBy.AccessibilityId("Allow")),
	btnDenyDocuCite(MobileBy.id("com.android.packageinstaller:id/permission_deny_button"),null),
	textLocationEnable(MobileBy.id("android:id/message"),null),
	btnYesSelectLanguage(MobileBy.id("//android.widget.Button[@text='Yes']"),null),
	btnNoSelectLanguage(MobileBy.id("//android.widget.Button[@text='No']"),null),
	
	
	chkBoxDistributoracceptance(MobileBy.id("com.hycite.docucite:id/accept_checkbox"),null),
	btnAgreeacceptance(MobileBy.id("com.hycite.docucite:id/btn_agree"),null),
	btnCancelacceptance(MobileBy.id("com.hycite.docucite:id/btn_cancel"),null),
	
	//home page
	textDataLoading(MobileBy.xpath("//android.widget.TextView[@text='Data Loading...']"),null),
	elementStartNewOder(MobileBy.id("com.hycite.docucite:id/home_screen_start_new_order_ll_txt"),MobileBy.xpath("//XCUIElementTypeButton[@name='home_new_order_button']/..")),
	elementOderApproval(MobileBy.id("com.hycite.docucite:id/home_screen_order_approval_ll_txt"),null),
	elementMatchToOder(MobileBy.id("com.hycite.docucite:id/home_screen_match_order_ll_text"),null),
	elementProcessPayment(MobileBy.id("com.hycite.docucite:id/home_screen_process_payment_ll_text"),null),
	elementHomePageLogo(MobileBy.id("com.hycite.docucite:id/imgLogo"),null),
	elementEmailIcon(MobileBy.id("com.hycite.docucite:id/home_screen_email_img"),null),
	elementMenuIcon(MobileBy.id("com.hycite.docucite:id/home_screen_menu_img"),null),
	
	//new Order Home
	editFirstname(MobileBy.id("com.hycite.docucite:id/dist_customer_first_name_et"),MobileBy.xpath("//XCUIElementTypeStaticText[@name='First Name']//following-sibling::XCUIElementTypeTextField[1]")),
	editMiddlename(MobileBy.id("com.hycite.docucite:id/dist_customer_middle_name_et"),MobileBy.xpath("//XCUIElementTypeStaticText[@name='Middle Name']//following-sibling::XCUIElementTypeTextField[1]")),
	editLastname(MobileBy.id("com.hycite.docucite:id/dist_customer_last_name_et"),MobileBy.xpath("//XCUIElementTypeStaticText[@name='Last Name']//following-sibling::XCUIElementTypeTextField[1]")),
	textDistributor(MobileBy.xpath("com.hycite.docucite:id/dist_customer_distributor_text"),null),
	btnDone(MobileBy.id("com.hycite.docucite:id/sliding_panel_layout_done_button"),MobileBy.xpath("//XCUIElementTypeButton[@name='Done']")),
	btnBack(MobileBy.id("com.hycite.docucite:id/mto_back"),null),
	btnOK(MobileBy.id("com.hycite.docucite:id/mto_ok"),MobileBy.xpath("//XCUIElementTypeButton[@label='OK Button 55']")),
	lstDistributorItem(MobileBy.xpath("//android.widget.TextView[@text='replaceit']"),MobileBy.xpath("//XCUIElementTypePickerWheel")),
	
	
	//New oder documents
	elementFirstMiddleName(MobileBy.id("com.hycite.docucite:id/order_main_screen_customer_name"),MobileBy.AccessibilityId("full_name_label")),
	elementLastName(MobileBy.id("com.hycite.docucite:id/order_main_screen_customer_name2"),MobileBy.AccessibilityId("last_name_label")),
	elementDocumentCount(MobileBy.id("com.hycite.docucite:id/order_main_screen_documents_count"),MobileBy.AccessibilityId("document_count_label")),
	elementNewOrder(MobileBy.id("com.hycite.docucite:id/order_main_screen_order_type"),null),
	
	elementDeleteIcon(MobileBy.id("	com.hycite.docucite:id/order_main_screen_nButton"),null),
	elementInformationIcon(MobileBy.id("com.hycite.docucite:id/order_main_screen_mButton"),null),
	elementPlusIcon(MobileBy.id("com.hycite.docucite:id/order_main_screen_arcMenu"),MobileBy.AccessibilityId("HomeAdd 55")),
	elementCloudIcon(MobileBy.id("com.hycite.docucite:id/order_main_screen_pButton"),MobileBy.AccessibilityId("HomeOrderUpload 55")),
	popUpCameraAccess(null,MobileBy.xpath("//XCUIElementTypeAlert[@name=\"“DocuCiteDev” Would Like to Access the Camera\"]")),
	btnAllowCameraAccess(null,MobileBy.AccessibilityId("OK")),
	popUpLocationAccess(null,MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Allow “DocuCiteDev” to access your location while you are using the app?\"]")),
	
	//Camera elements //Please wait�
	btnAutoManual(MobileBy.id("com.hycite.docucite:id/tgAutoMan"),MobileBy.AccessibilityId("capture_toggle_switch")),
	btnCapture(MobileBy.id("com.hycite.docucite:id/capture"),MobileBy.AccessibilityId("capture_button")),
	btndeletePhoto(MobileBy.id("com.hycite.docucite:id/mto_del"),null),
	
	textDocumentQualitymsg(MobileBy.id("com.hycite.docucite:id/txtZMMessage"),MobileBy.AccessibilityId("carefully check document quality")),
	
	//Ready To Go Page
	textFullName(MobileBy.id("com.hycite.docucite:id/order_confirm_full_name1"),MobileBy.xpath("//XCUIElementTypeStaticText[@name='NEW ORDER']/following-sibling::XCUIElementTypeStaticText[1]")),
	textReadToGo(MobileBy.id("com.hycite.docucite:id/headerTextTitle"),MobileBy.AccessibilityId("order_confirmation_label")),
	textNewOrderTitle(MobileBy.id("com.hycite.docucite:id/order_confirm_order_type_Title"),null),
	textDistributorCode(MobileBy.id("com.hycite.docucite:id/order_confirm_dist_no_country_code"),null),
	textDistributorName(MobileBy.id("com.hycite.docucite:id/order_confirm_dist_name"),null),
	textDocumentCount(MobileBy.id("com.hycite.docucite:id/order_confirm_doc_count"),null),
	textNewOrderConfirmMessage(MobileBy.id("com.hycite.docucite:id/order_confirm_doc_count"),null),
	
	textNewOrderConfirmQueue(MobileBy.id("com.hycite.docucite:id/thank_you_msg"),MobileBy.AccessibilityId("thankyou_confirmation_text_label")),
	btnThankUOK(MobileBy.id("com.hycite.docucite:id/thank_you_ok"),null),
	//Process Payment
	popUpProcessPayment(MobileBy.id("com.hycite.docucite:id/alertTitle"),MobileBy.xpath("//XCUIElementTypeAlert[@name='Process Payment']")),
	btnPaymentNo(MobileBy.id("android:id/button2"),MobileBy.AccessibilityId("No")),
	btnPaymentYes(MobileBy.id("android:id/button1"),MobileBy.AccessibilityId("Yes")),
	;
	
	
	private static final Logger logger = Logger.getLogger(DocuCite.class);
	
	private By iosby,aby;
	private By oldAndriod;
	private By oldIOS;
	
	DocuCite(By aby,By iby) {
		this.aby = aby;
		this.oldAndriod = aby;
		this.iosby = iby;
		this.oldIOS = iby;
	}


	public By getLocator(String os) {
		if(os.equals("ios"))
			return iosby;
		else
			return aby;
	}
	public String getName() {
		return name();
	}

	
	public By getAndroidLocator() {
		return aby;
	}
	
	public By getIOSLocator() {
		return iosby;
	}

	
	public void resetLocator() {
		this.aby = this.oldAndriod;
		logger.info("Old android is " + this.oldAndriod);
		this.iosby = this.oldIOS;
		logger.info("Old IOS is " + this.oldIOS);
		//return this;
	}

	public BaseElement setLocator(String platformName,By by) {
		if(platformName.equals("android"))
		{
		this.aby = by;
		logger.info("set android is " + this.aby);
		}
		else
		{
		this.iosby = by;
		logger.info("set ios is " + this.iosby);
		}
		return this;
	}	
}
