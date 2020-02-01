package com.crafts.graphql.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crafts.graphql.entity.Vehicle;
import com.crafts.graphql.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public Vehicle createVehicle(final String type, final String modelCode, final String brandName,
			final String launchDate) {
		final Vehicle vehicle = new Vehicle();
		vehicle.setType(type);
		vehicle.setModelCode(modelCode);
		vehicle.setBrandName(brandName);
		vehicle.setLaunchDate(LocalDate.parse(launchDate));
		return this.vehicleRepository.save(vehicle);
	}

	public List<Vehicle> getAllVehicles(final int count) {
		return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
	}

	public Optional<Vehicle> getVehicle(final Long id) {
		return this.vehicleRepository.findById(id);
	}

}
