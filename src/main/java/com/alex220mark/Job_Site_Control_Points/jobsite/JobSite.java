package com.alex220mark.Job_Site_Control_Points.jobsite;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Job_Site")
@Table(name = "job_sites")
public class JobSite {

	@Id
	//is this needed if we created it using postgreSQL?
	@SequenceGenerator(name = "job_sites_job_site_id_seq", sequenceName = "job_sites_job_site_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_sites_job_site_id_seq")
	@Column(name = "job_site_id", nullable = false, updatable = false)
	private BigInteger jobSiteId; // should this be a BigInteger? like the postgres DB?
	@Column(name = "job_site_name", nullable = false, columnDefinition = "TEXT")
	@NotBlank // validation spring
	private String jobSiteName;

	public JobSite() {
	}

	public JobSite(@NotBlank String jobSiteName) {
		this.jobSiteName = jobSiteName;
	}

	@Override
	public String toString() {
		return "Job Site Id:  " + jobSiteId + "   |   Job Site Name: " + jobSiteName;
	}

}
