package mall.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import mall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import mall.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired InventoryRepository inventoryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCompleted'")
    public void wheneverDeliveryCompleted_CompletedDelivery(@Payload DeliveryCompleted deliveryCompleted){

        DeliveryCompleted event = deliveryCompleted;
        System.out.println("\n\n##### listener CompletedDelivery : " + deliveryCompleted + "\n\n");


        

        // Sample Logic //
        Inventory.completedDelivery(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReturnCompleted'")
    public void wheneverReturnCompleted_CompleteCollect(@Payload ReturnCompleted returnCompleted){

        ReturnCompleted event = returnCompleted;
        System.out.println("\n\n##### listener CompleteCollect : " + returnCompleted + "\n\n");


        

        // Sample Logic //
        Inventory.completeCollect(event);
        

        

    }

}


