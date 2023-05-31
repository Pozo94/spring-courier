package pl.com.gymtech.courierspring.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.gymtech.courierspring.Mapper.TrackingMapper;
import pl.com.gymtech.courierspring.dto.TrackingDTO;
import pl.com.gymtech.courierspring.entity.Order;
import pl.com.gymtech.courierspring.entity.Tracking;
import pl.com.gymtech.courierspring.repository.TrackingRepository;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)

public class TrackingService {
    TrackingRepository trackingRepository;
    TrackingMapper trackingMapper;
    public TrackingService(TrackingRepository trackingRepository, TrackingMapper trackingMapper) {
        this.trackingRepository = trackingRepository;
        this.trackingMapper = trackingMapper;
    }
    @Transactional
    public TrackingDTO createOrderTracking(TrackingDTO trackingDTO, Order order){
        Tracking tracking=new Tracking(order,trackingDTO.getEventType(),trackingDTO.getEventTime(),trackingDTO.getLocation(),trackingDTO.getDescription());
       return trackingMapper.trackingToTrackingDTO(trackingRepository.save(tracking));

    }

    public TrackingDTO getTracking(String id){
        return trackingMapper.trackingToTrackingDTO(trackingRepository.findByOrderId(id).orElseThrow());

    }
    @Transactional

    public TrackingDTO updateTracking(String id,TrackingDTO trackingDTO){

        Tracking tracking= trackingRepository.findById(id).orElseThrow();
        tracking.setEventTime(trackingDTO.getEventTime());
        tracking.setDescription(trackingDTO.getDescription());
        tracking.setEventType(trackingDTO.getEventType());
        tracking.setLocation(trackingDTO.getLocation());
        return trackingMapper.trackingToTrackingDTO(trackingRepository.save(tracking));



    }

}
