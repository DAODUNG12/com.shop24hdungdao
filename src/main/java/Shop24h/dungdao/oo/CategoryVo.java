package Shop24h.dungdao.oo;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class CategoryVo implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;

	@NotEmpty(message = "Name must be not blank")
	String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
