package pl.com.gymtech.courierspring.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.com.gymtech.courierspring.Mapper.TrackingMapper;
import pl.com.gymtech.courierspring.dto.TrackingDTO;
import pl.com.gymtech.courierspring.entity.Tracking;
import pl.com.gymtech.courierspring.repository.TrackingRepository;

@Service
public class TrackingService {
    TrackingRepository trackingRepository;
    TrackingMapper trackingMapper;

    public TrackingService(TrackingRepository trackingRepository, TrackingMapper trackingMapper) {
        this.trackingRepository = trackingRepository;
        this.trackingMapper = trackingMapper;
    }

    public TrackingDTO getTracking(String id){
        return trackingMapper.trackingToTrackingDTO(trackingRepository.findByOrderId(id).orElseThrow());

    }
    public TrackingDTO updateTracking(String id,TrackingDTO trackingDTO){

        Tracking tracking= trackingRepository.findById(id).orElseThrow();
        tracking.setEventTime(trackingDTO.getEventTime());
        tracking.setDescription(trackingDTO.getDescription());
        tracking.setEventType(trackingDTO.getEventType());
        tracking.setLocation(trackingDTO.getLocation());
        return trackingMapper.trackingToTrackingDTO(trackingRepository.save(tracking));



    }

}
