package com.daniel.simpleweather;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 *
 * Created by Daniel Feng W on 2016/11/6.
 */

@Entity
public class WeatherBean {
	@Generated(hash = 585023127)
	public WeatherBean(String description) {
		this.description = description;
	}

	public WeatherBean() {
	}

	public String description;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
