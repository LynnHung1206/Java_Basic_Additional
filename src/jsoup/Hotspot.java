package jsoup;
public class Hotspot {
	private String id, spot_name, type, district, address;

	public Hotspot(String id, String spot_name, String type, String district, String address) {
		super();
		this.id = id;
		this.spot_name = spot_name;
		this.type = type;
		this.district = district;
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id = " + id + "\n");
		sb.append("spot_name = " + spot_name + "\n");
		sb.append("type = " + type + "\n");
		sb.append("district = " + district + "\n");
		sb.append("address = " + address + "\n");
		return sb.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSpot_name() {
		return spot_name;
	}

	public void setSpot_name(String spot_name) {
		this.spot_name = spot_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
