package masklet.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Store {

    @JsonProperty("addr")
    private String addr;
    @JsonProperty("code")
    private String code;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("lat")
    private Long lat;
    @JsonProperty("lng")
    private Long lng;
    @JsonProperty("name")
    private String name;
    @JsonProperty("remain_stat")
    private String remainStat;
    @JsonProperty("stock_at")
    private String stockAt;
    @JsonProperty("type")
    private String type;
}
