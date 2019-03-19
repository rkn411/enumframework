package com.doc.pages;

import com.example.locators.DocuCite;
import com.vsoft.actions.AppiumReportWrapper;
import com.vsoft.base.TestBase;

public class NewOderFlowPage extends TestBase {
	AppiumReportWrapper allActions = new AppiumReportWrapper();

	public void selectDistributor(String distributor) {
		if (platformName.get().equalsIgnoreCase("android")) {
			DocuCite.lstDistributorItem.updateLocator(platformName.get(), "US - 13039 : NAOMY C WILLIS");
			DocuCite.lstDistributorItem.scrollIntoElement("US - 13039 : NAOMY C WILLIS");
			DocuCite.lstDistributorItem.click();
		} else {
			DocuCite.lstDistributorItem.pickerWheelEnterText("US - 13039: NAOMY C WILLIS");
		}
		DocuCite.btnDone.click();
	}

	public void enterNameDetails(String firstName, String middleName, String lastName) {
		DocuCite.editFirstname.click();
		DocuCite.editFirstname.enterText(firstName);
		DocuCite.editMiddlename.click();
		DocuCite.editMiddlename.enterText(middleName);
		DocuCite.editLastname.click();
		DocuCite.editLastname.enterText(lastName);
		allActions.hideKeyboard();
		DocuCite.btnOK.click();
	}
}
