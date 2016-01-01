package eu.diceH2020.s4c.plugin.views;

public class PropertiesSingleton {
	
	private  TextExtended address;
	private  TextExtended port;
	
	private BrowserExended browser;
	
	private static PropertiesSingleton instance = null;
	
	public static PropertiesSingleton getInstance() {
	      if(instance == null) {
	         instance = new PropertiesSingleton();
	      }
	      return instance;
	   }

	
	public String getAddressString(){
		return address.getTextBox().getText();
	}
	
	/**
	 * @return the address
	 */
	public TextExtended getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(TextExtended address) {
		this.address = address;
	}
	
	public void setAddressString(String address){
		this.address.getTextBox().setText(address);
	}

	public String getPortString(){
		return port.getTextBox().getText();
	}
	
	
	/**
	 * @return the port
	 */
	public TextExtended getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(TextExtended port) {
		this.port = port;
	}
	
	public void setPortString(String port) {
		this.port.getTextBox().setText(port);
	}


	/**
	 * @return the browser
	 */
	public BrowserExended getBrowser() {
		return browser;
	}


	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(BrowserExended browser) {
		this.browser = browser;
	}


	
}
