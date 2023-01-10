package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Stockdecreased extends AbstractEvent {

    private Long id;
    private Long productId;
    private Long productName;
    private Long stock;
    private Long productImage;

    public Stockdecreased(Inventory aggregate){
        super(aggregate);
    }
    public Stockdecreased(){
        super();
    }
}
