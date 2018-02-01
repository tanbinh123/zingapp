package org.alpha.aardvard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
	private String type;
	private Value value;
	
	public Quote() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Quote{type='" + type + '\'' + ", value=" + value +
				'}';
		
	}
	
}
/**
 * @JsonIgnorProperties use to indicate that any properties not bound
 * in this type should be ignored.
 * Need to specify the variable name exactly same as the key in the JSON
 * Document returned from the API. In case your variable name and key in
 * JSON doc are not matching, you need to use @JsonProperty annotation
 * to specify the exact key of JSON document
 */
