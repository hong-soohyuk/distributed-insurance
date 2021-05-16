package client;

public class Property {
	private  long car;
	private String carRegistrationNo;
	private long house;
	private String houseRegistrationNo;
	
	public long getCar() {
		return car;
	}
	public void setCar(long l) {
		this.car = l;
	}
	public long getHouse() {
		return house;
	}
	public void setHouse(long l) {
		this.house = l;
	}
	public String getCarRegistrationNo() {
		return carRegistrationNo;
	}
	public void setCarRegistrationNo(String carRegistrationNo) {
		this.carRegistrationNo = carRegistrationNo;
	}
	public String getHouseRegistrationNo() {
		return houseRegistrationNo;
	}
	public void setHouseRegistrationNo(String houseRegistrationNo) {
		this.houseRegistrationNo = houseRegistrationNo;
	}
}
