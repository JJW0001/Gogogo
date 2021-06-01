package gogogo.entity;

/**
 * @author 86155
 */
public class Goods {
	private String goodsNo;
	private String shelvesAdr;
	private String cartAdr;
	private float goodsPrice;
	private int goodsStock;
	private String goodsDesc;
	private String goodsState;
	
	public Goods(){}
	
	public Goods(String goodsNo, String goodsState){
		this.goodsNo = goodsNo;
		this.goodsState = goodsState;
	}
	
	public Goods(String goodsNo, float goodsPrice, String goodsDesc) {
		this.goodsNo = goodsNo;
		this.goodsPrice = goodsPrice;
		this.goodsDesc = goodsDesc;
	}
	
	public Goods(String goodsNo, String shelvesAdr, String cartAdr, float goodsPrice, int goodsStock, String goodsDesc, String goodsState) {
		this.goodsNo = goodsNo;
		this.cartAdr = cartAdr;
		this.shelvesAdr = shelvesAdr;
		this.goodsPrice = goodsPrice;
		this.goodsStock = goodsStock;
		this.goodsDesc = goodsDesc;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getCartAdr() {
		return cartAdr;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public void setCartAdr(String cartAdr) {
		this.cartAdr = cartAdr;
	}
	
	public String getShelvesAdr() {
		return shelvesAdr;
	}

	public void setShelvesAdr(String shelvesAdr) {
		this.shelvesAdr = shelvesAdr;
	}

	public float getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsStock() {
		return goodsStock;
	}

	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}

	public String getGoodsState() {
		return goodsState;
	}

	public void setGoodsState(String goodsState) {
		this.goodsState = goodsState;
	}
	
	
}
