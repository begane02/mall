package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ItemShipped extends AbstractEvent {

    private Long id;
    private Long orderId;

    public ItemShipped(Delivery aggregate){
        super(aggregate);
    }
    public ItemShipped(){
        super();
    }
}
