package pl.com.gymtech.courierspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.gymtech.courierspring.mapper.TrackingMapper;
import pl.com.gymtech.courierspring.dto.TrackingDTO;
import pl.com.gymtech.courierspring.entity.Order;
import pl.com.gymtech.courierspring.entity.Tracking;
import pl.com.gymtech.courierspring.repository.TrackingRepository;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class TrackingService {
    TrackingRepository trackingRepository;
    TrackingMapper trackingMapper;

    @Transactional
    public TrackingDTO createOrderTracking(TrackingDTO trackingDTO, Order order){
        Tracking tracking=new Tracking(order,trackingDTO.getEventType(),trackingDTO.getEventTime(),trackingDTO.getLocation(),trackingDTO.getDescription());
       return trackingMapper.trackingToTrackingDTO(trackingRepository.save(tracking));

    }

    public TrackingDTO getTracking(String id){
        return trackingMapper.trackingToTrackingDTO(trackingRepository.findByOrderId(id).orElseThrow(()->new NoSuchElementException("Tracking with id: "+id+ " not found!" )));

    }
    @Transactional

    public TrackingDTO updateTracking(String id,TrackingDTO trackingDTO){

        Tracking tracking= trackingRepository.findById(id).orElseThrow(()->new NoSuchElementException("Tracking with id: "+id+ "not found!" ));
        tracking.setEventTime(trackingDTO.getEventTime());
        tracking.setDescription(trackingDTO.getDescription());
        tracking.setEventType(trackingDTO.getEventType());
        tracking.setLocation(trackingDTO.getLocation());
        return trackingMapper.trackingToTrackingDTO(trackingRepository.save(tracking));



    }

}
