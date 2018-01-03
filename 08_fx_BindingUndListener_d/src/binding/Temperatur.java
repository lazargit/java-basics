package binding;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

/*
 * JavFX Bean
 * verwendbar für Listener oder Binding
 */
public class Temperatur {
	
	private FloatProperty temperatur = new SimpleFloatProperty();

	public final FloatProperty temperaturProperty() {
		return this.temperatur;
	}
	

	public final float getTemperatur() {
		return this.temperaturProperty().get();
	}
	

	public final void setTemperatur(final float temperatur) {
		this.temperaturProperty().set(temperatur);
	}
	

}
