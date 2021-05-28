package frsl.metamodel;

public class SystemAction extends Action {
	private boolean getDataFromSource;
	private boolean displayWindow;
	private boolean showErrorMessage;
	private boolean validate;
	
	public SystemAction() {
		
	}
	
	public SystemAction(String description) {
		this.description = description;
	}
	
	public void getIsTrue() {
		this.getDataFromSource = true;
	}
	
	public void displayIsTrue() {
		this.displayWindow = true;
	}
	
	public void errorIsTrue() {
		this.showErrorMessage = true;
	}
	
	public void hasValidate() {
		this.validate = true;
	}
	
	public boolean isGetData() {
		return getDataFromSource;
	}	
	
	public boolean isDisplayWindow() {
		return displayWindow;
	}
	
	public boolean isShowError() {
		return showErrorMessage;
	}
	
	public boolean isValidate() {
		return validate;
	}
}
