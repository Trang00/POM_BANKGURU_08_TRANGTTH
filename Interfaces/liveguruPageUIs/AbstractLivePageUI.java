package liveguruPageUIs;

public class AbstractLivePageUI {
	public static final String DYNAMIC_MENU = "//header[@id='header']//span[text()='%s']";

	public static final String DYNAMIC_LINK = "//a[text()='%s']";//

	public static final String DYNAMIC_TEXTBOX = "//input[@name='%s']";

	public static final String DYNAMIC_BUTTON = "//button[@title='%s']";

	public static final String DYNAMIC_VERIFY_TEXT = "//span[text()='%s']";
	
	public static final String DYNAMIC_COST_LIST="//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
	
	public static final String DYNAMIC_COST_DETAIL = "//span[@class='%s']";

	public static final String DYNAMIC_ADD_CART = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']";
	
	public static final String QTY_TEXTBOX="//a[text()='%s']/ancestor::td/following-sibling::td[@class='product-cart-actions']/input";
	
	public static final String DYNAMIC_COMPARE = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']";
	
	public static final String DYNAMIC_TEXT_H1 = "//h1[text()='%s']";//
	
	//

}
