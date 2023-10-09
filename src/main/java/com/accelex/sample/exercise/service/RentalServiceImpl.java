package com.accelex.sample.exercise.service;

import com.accelex.sample.exercise.domain.Rental;
import com.accelex.sample.exercise.domain.RentalStatus;
import com.accelex.sample.exercise.dto.RentalDto;
import com.accelex.sample.exercise.dto.RentalRequestDto;
import com.accelex.sample.exercise.dto.ReturnVehicleDto;
import com.accelex.sample.exercise.mapper.RentalMapper;
import com.accelex.sample.exercise.repository.RentalRepository;
import com.accelex.sample.exercise.service.interfaces.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper mapper;

    @Override
    public RentalDto createRentalRequest(RentalRequestDto dto) {
        RentalDto saved = null;
        if(!rentalRepository.alreadyExistSameRentalRequest(dto.getVehicleId(),dto.getStartDate(),dto.getEndDate())){
            saved = mapper.map(rentalRepository.save(mapper.map(dto)));
        }
        return saved;
    }

    @Override
    public Boolean approveRentalRequest(Long id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        if(!rentalRepository.isVehicleAlreadyInUse(rental.getVehicle().getId())){
            return updateRentalStatus(rental,RentalStatus.PENDING,RentalStatus.OUT);
        }
        return false;
    }

    @Override
    public Boolean returnVehicle(ReturnVehicleDto dto) {
        Rental rental = rentalRepository.findById(dto.getRentalId()).orElseThrow();
        return updateRentalStatus(rental,RentalStatus.OUT,dto.getStatus());
    }

    @Override
    public List<RentalDto> getAllRentalRequests() {
        return mapper.map(rentalRepository.findAllByStatus(RentalStatus.PENDING));
    }

    private boolean updateRentalStatus(Rental rental, RentalStatus conditionStatus, RentalStatus newStatus){
        boolean updated = false;
        if(rental.getStatus().equals(conditionStatus)){
            rental.setStatus(newStatus);
            rentalRepository.save(rental);
            updated = true;
        }
        return updated;

    }

}
