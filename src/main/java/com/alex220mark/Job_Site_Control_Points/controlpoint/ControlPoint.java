package com.alex220mark.Job_Site_Control_Points.controlpoint;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Control_Point")
@Table(name = "control_points", uniqueConstraints = {
		@UniqueConstraint(name = "pointId_unique", columnNames = "point_id") })
public class ControlPoint {

	@Id
	@Column(name = "uid", nullable = false, updatable = false)
//	@JsonIgnore 			// so the uid isnt seen upon GetMapping Request, no uid private field in DTO will not show it also...
	private final UUID uid;
	@Column(name = "point_id", nullable = false, columnDefinition = "TEXT")
	@NotBlank // validation spring
	private String pointId;
	@Column(name = "easting", nullable = false)
	private BigDecimal easting;
	@Column(name = "northing", nullable = false)
	private BigDecimal northing;
	@Column(name = "rl", nullable = false)
	private BigDecimal rl;
	private String code;
	private BigInteger jobSiteId;

	public ControlPoint() {
		this.uid = UUID.randomUUID();
	}

	public ControlPoint(String pointID, BigDecimal easting, BigDecimal northing, BigDecimal rl, String code,
			BigInteger jobSiteId) {
		this.uid = UUID.randomUUID();
		this.pointId = pointID.toUpperCase();
		this.easting = easting.setScale(3, RoundingMode.HALF_UP);
		this.northing = northing.setScale(3, RoundingMode.HALF_UP);
		this.rl = rl.setScale(3, RoundingMode.HALF_UP);
		this.code = code.toUpperCase();
		this.jobSiteId = jobSiteId;
	}

	@Override
	public String toString() {
		return "pointId = " + pointId + ", easting = " + easting + ", northing = " + northing + ", rl = " + rl
				+ ", code = " + code;
	}
}
