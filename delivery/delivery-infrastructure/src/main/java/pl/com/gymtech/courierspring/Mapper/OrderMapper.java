package pl.com.gymtech.courierspring.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.entity.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    public abstract OrderDTO orderToOrderDTO(Order order);
    @Mapping(target = "id", ignore = true)
    public abstract Order orderDTOToOrder(OrderDTO orderDTO);
    public abstract List<OrderDTO> orderToOrderDTO(List<Order> orders);
}
