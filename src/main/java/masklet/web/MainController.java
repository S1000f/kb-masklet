package masklet.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import masklet.service.StoresByAddrService;
import masklet.web.model.AddressCommand;
import masklet.web.model.StoresByAddr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.net.URL;

@Controller
public class MainController {

    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private StoresByAddrService storesByAddrService;

    @GetMapping("/")
    public String main(AddressCommand addressCommand) {

        return "main";
    }

    @PostMapping("/")
    public String storesByAddr(AddressCommand addressCommand, Model model) throws IOException {

        storesByAddrService.setAddressCommand(addressCommand);
        URL url = storesByAddrService.getApiUrl();

        StoresByAddr storesByAddr = mapper.readValue(url, StoresByAddr.class);
        model.addAttribute("storesByAddr", storesByAddr);

        return "main";
    }
}
