package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class ReturnCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
}


