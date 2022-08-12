package com.alex220mark.Job_Site_Control_Points.controlpoint;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlPointRepository extends JpaRepository<ControlPoint, UUID> {
	// why is the Repository always an interface?

	// @Query("SELECT p FROM ControlPoint p WHERE p.point_id = ?2")
	Optional<ControlPoint> findByPointId(String pointId);

	// so how do we implement this method so in Service Classes, i can just call
	// this method, instead of creating an Optional<ControlPoint> and getting its
	// UUID to delete it
	Optional<ControlPoint> deleteByPointId(String pointId);

	@Query(value = "SELECT * FROM control_points WHERE job_site_id = ?1", nativeQuery = true)
	List<ControlPoint> getControlPointsWithJobSite(BigInteger jobSiteId);

	// @Query is expecting results back, we have handled this with a try catch in
	// uITS deleteAllControlPointsInCurrentJob
	@Query(value = "DELETE FROM control_points WHERE job_site_id = ?1", nativeQuery = true)
	void deleteControlPointsFromOneJobSite(BigInteger jobSiteId);

}
