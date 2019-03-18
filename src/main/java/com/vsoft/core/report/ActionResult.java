package com.vsoft.core.report;

public class ActionResult {

	private boolean status;
	private String description;
	private String ActionName;
	private String elementName;

	public ActionResult(boolean status) {
		this.setStatus(status);
		this.setDescription("Action status: " + (status ? "Passed" : "Failed"));
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getElementName() {
		return this.elementName;
	}

	public void setActionName(String actionName) {
		this.ActionName = actionName;
	}

	public String getActionName() {
		return this.ActionName;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
