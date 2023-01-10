package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReturnCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;

    public ReturnCompleted(Delivery aggregate){
        super(aggregate);
    }
    public ReturnCompleted(){
        super();
    }
}
