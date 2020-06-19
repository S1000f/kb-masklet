package masklet.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import masklet.web.model.StoresByAddr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

@Controller
public class MainController {

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/")
    public String main(Model model) throws IOException {
        String apiURL = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByAddr/json?address=";
        String address = "대구광역시 북구 복현동";
        String encodedAddress = URLEncoder.encode(address, "utf-8");

        String url = apiURL + encodedAddress;

        StoresByAddr storesByAddr = mapper.readValue(new URL(url), StoresByAddr.class);
        model.addAttribute("storesByAddr", storesByAddr);

        return "main";
    }
}
