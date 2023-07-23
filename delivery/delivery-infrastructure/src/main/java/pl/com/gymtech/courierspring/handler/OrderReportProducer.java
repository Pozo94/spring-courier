package pl.com.gymtech.courierspring.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import pl.com.gymtech.courierspring.dto.OrderDTO;

import java.util.List;

@Component
@Slf4j
public class OrderReportProducer {

    final
    JmsTemplate jmsTemplate;

    private String queue="Raport";

    public OrderReportProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    private String convertToString(List<OrderDTO> orderDTOList){
        StringBuilder reportMessage=new StringBuilder();
        for (OrderDTO order:orderDTOList){
            reportMessage.append("Order ID: ").append(order.getId()).append(System.lineSeparator());
            reportMessage.append("Customer ID: ").append(order.getCustomerId()).append(System.lineSeparator());
            reportMessage.append("Adres nadawcy: ").append(order.getSenderAddress()).append(System.lineSeparator());
            reportMessage.append("Adres dostawy: ").append(order.getReceiverAddress()).append(System.lineSeparator());
            reportMessage.append("Typ przesyłki: ").append(order.getPackageType()).append(System.lineSeparator());
            reportMessage.append("Wielkość przesyłki: ").append(order.getPackageSize()).append(System.lineSeparator());
            reportMessage.append("Status: ").append(order.getStatus()).append(System.lineSeparator());
            reportMessage.append(System.lineSeparator());

        }
        return reportMessage.toString();
    }

    public void sendOrderReport(List<OrderDTO> list){
        try{
            log.info("Attempting Send message to Queue: " + queue);

            jmsTemplate.convertAndSend(queue, convertToString(list));
        } catch(Exception e){
            log.error("Received Exception during send Message: ", e);
        }
    }
}
