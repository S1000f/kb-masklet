package masklet.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import masklet.service.ApiUrlProvider;
import masklet.service.StoresByAddrService;
import masklet.web.model.AddressCommand;
import masklet.web.model.StoresByAddr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URL;

@Controller
public class MainController {

    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/")
    public String main(AddressCommand addressCommand) {
        return "main";
    }

    @PostMapping("/")
    public String storesByAddr(AddressCommand addressCommand, Model model) throws IOException {
        ApiUrlProvider apiUrlProvider = new StoresByAddrService(addressCommand);
        URL url = apiUrlProvider.getApiUrl();

        StoresByAddr storesByAddr = mapper.readValue(url, StoresByAddr.class);
        model.addAttribute("storesByAddr", storesByAddr);

        return "main";
    }
}
