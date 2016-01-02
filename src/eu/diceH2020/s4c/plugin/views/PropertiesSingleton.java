package eu.diceH2020.s4c.plugin.views;

public class PropertiesSingleton {
	
	private  TextExtended address;
	private  TextExtended port;
	private  TextExtended username;
	private  TextExtended password;
	private  TextExtended accuracy;
	private  TextExtended cycles;
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
		if (address != null) {
			this.address.getTextBox().setText(address);			
		}
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
		if (port != null) {
			this.port.getTextBox().setText(port);			
		}
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


	/**
	 * @return the username
	 */
	public TextExtended getUsername() {
		return username;
	}

	public String getUsernameString() {
		return username.getTextBox().getText();
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(TextExtended username) {
		this.username = username;
	}

	public void setUsernameString(String username) {
		if (username != null) {
			this.username.getTextBox().setText(username);
		}
	}


	/**
	 * @return the password
	 */
	public TextExtended getPassword() {
		return password;
	}
	public String getPasswordString() {
		return password.getTextBox().getText();
	}

	public void setPassword(TextExtended password){
		this.password = password;
	}	
	
	public void setPasswordString(String password) {
		if (password != null) {
			this.password.getTextBox().setText(password);
		}
	}


	/**
	 * @return the accuracy
	 */
	public TextExtended getAccuracy() {
		return accuracy;
	}
	public String getAccuracyString() {
		return accuracy.getTextBox().getText();
	}

	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(TextExtended accuracy) {
		this.accuracy = accuracy;
	}

	public void setAccuracyString(String accuracy) {
		if (accuracy != null) {
			this.accuracy.getTextBox().setText(accuracy);
		}
	}

	/**
	 * @return the cycles
	 */
	public TextExtended getCycles() {
		return cycles;
	}

	public String getCyclesString() {
		return cycles.getTextBox().getText();
	}

	/**
	 * @param cycles the cycles to set
	 */
	public void setCycles(TextExtended cycles) {
		this.cycles = cycles;
	}
	public void setCyclesString(String cycles) {
		if (cycles != null) {
			this.cycles.getTextBox().setText(cycles);
		}
	}

	
}
