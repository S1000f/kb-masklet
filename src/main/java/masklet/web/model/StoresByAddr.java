package masklet.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StoresByAddr {

    @JsonProperty("address")
    private String address;
    @JsonProperty("count")
    private int count;
    @JsonProperty("stores")
    private List<Store> storesList;
}