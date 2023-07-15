package pl.com.gymtech.courierspring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import pl.com.gymtech.courierspring.dto.OrderDTO;
import pl.com.gymtech.courierspring.entity.Order;

import java.util.List;

@Component
@Slf4j
public class JmsProducer {

    final
    JmsTemplate jmsTemplate;

    private String queue="Raport";

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }



    public void sendMessage(List<OrderDTO> message){
        try{
            log.info("Attempting Send message to Queue: " + queue);
            ObjectMapper objectMapper = new ObjectMapper();
           objectMapper.registerModule(new JavaTimeModule());
            jmsTemplate.convertAndSend(queue, objectMapper.writeValueAsString(message));
        } catch(Exception e){
            log.error("Received Exception during send Message: ", e);
        }
    }
}
