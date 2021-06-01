package gogogo.entity;

/**
 * @author 86155
 */
public class Carts {
	private Integer cartsNo;
	private String userName;
	private String goodsNo;
	private int addNum;
	private String addTime;
	
	public Carts(){}
	
	public Carts(String userName) {
		this.userName = userName;
	}
	
	public Carts(String userName, String goodsNo) {
		this.userName = userName;
		this.goodsNo = goodsNo;
	}

	public Carts(Integer cartsNo, String userName, String goodsNo, int addNum, String addTime) {
		this.cartsNo = cartsNo;
		this.userName = userName;
		this.goodsNo = goodsNo;
		this.addNum = addNum;
		this.addTime = addTime;
	}

	public Integer getCartsNo() {
		return cartsNo;
	}

	public void setCartsNo(Integer cartsNo) {
		this.cartsNo = cartsNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public int getAddNum() {
		return addNum;
	}

	public void setAddNum(int addNum) {
		this.addNum = addNum;
	}
	
	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
}
