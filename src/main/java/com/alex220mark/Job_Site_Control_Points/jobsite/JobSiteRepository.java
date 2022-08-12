package com.alex220mark.Job_Site_Control_Points.jobsite;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSiteRepository extends JpaRepository<JobSite, BigInteger> {

	@Query(value = "SELECT * FROM job_sites", nativeQuery = true)
	List<JobSite> getAllJobSites();

	Optional<JobSite> findByJobSiteName(String jobSiteName);

	// @Query is expecting results, so an exception is thrown - dunno how to get
	// @SQLUpdate to work yet!
	@Query(value = "UPDATE job_sites SET job_site_name = ? WHERE job_site_id = ?", nativeQuery = true)
	void changeJobSiteName(String newJobSiteName, BigInteger jobSiteId);

}
