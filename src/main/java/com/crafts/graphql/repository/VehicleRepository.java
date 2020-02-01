package com.crafts.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crafts.graphql.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
