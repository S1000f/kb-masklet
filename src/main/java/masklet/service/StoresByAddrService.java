package masklet.service;

import lombok.Setter;
import masklet.web.model.AddressCommand;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

@Component
public class StoresByAddrService implements ApiUrlProvider {

    private static final String STORES_BY_ADDR =
            "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByAddr/json?address=";
    @Setter
    private AddressCommand addressCommand;

    public StoresByAddrService() {
    }

    public StoresByAddrService(AddressCommand addressCommand) {
        this.addressCommand = addressCommand;
    }

    @Override
    public URL getApiUrl() throws IOException {

        StringBuilder address = new StringBuilder();
        address.append(addressCommand.getCity()).append(" ").append(addressCommand.getGu());

        if (! addressCommand.getDong().isEmpty()) {
            address.append(" ").append(addressCommand.getDong());
        }

        String encodedAddress = URLEncoder.encode(address.toString(), "utf-8");

        return new URL(STORES_BY_ADDR + encodedAddress);
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
