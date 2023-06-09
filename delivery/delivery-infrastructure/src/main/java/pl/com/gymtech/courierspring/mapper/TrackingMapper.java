package pl.com.gymtech.courierspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.com.gymtech.courierspring.dto.TrackingDTO;
import pl.com.gymtech.courierspring.entity.Tracking;

@Mapper(componentModel = "spring")
public abstract class TrackingMapper {

    @Mapping(source = "order.id", target = "orderId")
    public abstract TrackingDTO trackingToTrackingDTO(Tracking tracking);
    @Mapping(target = "id", ignore = true)
    public abstract Tracking trackingDTOToTracking(TrackingDTO trackingDTO);
}
