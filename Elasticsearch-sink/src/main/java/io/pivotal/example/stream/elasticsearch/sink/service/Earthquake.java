package io.pivotal.example.stream.elasticsearch.sink.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;

//@Document(indexName = "earthquakes", type = "earthquake", shards = 1, replicas = 0, refreshInterval = "-1")
public class Earthquake {
	
	@JsonProperty(value="@timestamp")
	private String timestamp;

	//private Float latitude;
	
	//private Float longitude;
	
	@JsonProperty(value="location")
	private String location;

	@JsonProperty(value="depth")
	private Float depth;

	@JsonProperty(value="mag")
	private Float magnitude;
	
	@JsonProperty(value="magType")
	private String magType;
	
	@JsonProperty(value="nst")
	private Integer NBStations;
	
	@JsonProperty(value="gap")
	private Float gap;
	
	@JsonProperty(value="dmin")
	private Float distance;
	
	@JsonProperty(value="rms")
	private Float RMS;
	
	@JsonProperty(value="source")
	private String source;
	
//	@Id
	@JsonProperty(value="event_id")
	private String eventId;
	


	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getMagType() {
		return magType;
	}

	public void setMagType(String magType) {
		this.magType = magType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
/*
	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
*/
	public Float getDepth() {
		return depth;
	}

	public void setDepth(Float depth) {
		this.depth = depth;
	}

	public Float getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(Float magnitude) {
		this.magnitude = magnitude;
	}

	public Integer getNBStations() {
		return NBStations;
	}

	public void setNBStations(Integer nBStations) {
		NBStations = nBStations;
	}

	public Float getGap() {
		return gap;
	}

	public void setGap(Float gap) {
		this.gap = gap;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public Float getRMS() {
		return RMS;
	}

	public void setRMS(Float rMS) {
		RMS = rMS;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
