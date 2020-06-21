package masklet.service;

import masklet.web.model.AddressCommand;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

@Component
public class StoresByAddrService implements ApiUrlProvider {

    private AddressCommand addressCommand;

    public StoresByAddrService() {
    }

    public StoresByAddrService(AddressCommand addressCommand) {
        this.addressCommand = addressCommand;
    }

    @Override
    public URL getApiUrl() throws IOException {
        String apiURL = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByAddr/json?address=";
        String address =
                addressCommand.getCity() + " " + addressCommand.getGu();
        if (! addressCommand.getDong().isEmpty()) {
            address += " " + addressCommand.getDong();
        }
        String encodedAddress = URLEncoder.encode(address, "utf-8");

        String strUrl = apiURL + encodedAddress;

        return new URL(strUrl);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private StoresByAddrService storesByAddrService = new StoresByAddrService();

        public Builder address(AddressCommand addressCommand) {
            storesByAddrService.addressCommand = addressCommand;
            return this;
        }

        public StoresByAddrService build() {
            return storesByAddrService;
        }
    }
}
