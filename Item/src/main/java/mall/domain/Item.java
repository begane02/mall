package mall.domain;

import mall.domain.Stockdecreased;
import mall.domain.StockIncreased;
import mall.ItemApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Item_table")
@Data

public class Item  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long productId;
    
    
    
    
    
    private Long productName;
    
    
    
    
    
    private Long stock;
    
    
    
    
    
    private Long productImage;

    @PostPersist
    public void onPostPersist(){


        Stockdecreased stockdecreased = new Stockdecreased(this);
        stockdecreased.publishAfterCommit();



        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();

    }

    public static ItemRepository repository(){
        ItemRepository itemRepository = ItemApplication.applicationContext.getBean(ItemRepository.class);
        return itemRepository;
    }




    public static void completedDelivery(DeliveryCompleted deliveryCompleted){

        /** Example 1:  new item 
        Item item = new Item();
        repository().save(item);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(item->{
            
            item // do something
            repository().save(item);


         });
        */

        
    }
    public static void completeCollect(ReturnCompleted returnCompleted){

        /** Example 1:  new item 
        Item item = new Item();
        repository().save(item);

        */

        /** Example 2:  finding and process
        
        repository().findById(returnCompleted.get???()).ifPresent(item->{
            
            item // do something
            repository().save(item);


         });
        */

        
    }


}
