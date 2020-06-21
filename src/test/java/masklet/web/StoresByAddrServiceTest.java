package masklet.web;

import masklet.service.ApiUrlProvider;
import masklet.service.StoresByAddrService;
import masklet.web.model.AddressCommand;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoresByAddrServiceTest {

    @Test
    public void urlBuildCorrectlyWithDong() throws Exception {
        AddressCommand addressCommand = new AddressCommand();
        addressCommand.setCity("대구광역시");
        addressCommand.setGu("북구");
        addressCommand.setDong("복현동");

        ApiUrlProvider apiUrlProvider = new StoresByAddrService(addressCommand);

        assertEquals(apiUrlProvider.getApiUrl(),
                new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByAddr/json?address=" +
                        "%EB%8C%80%EA%B5%AC%EA%B4%91%EC%97%AD%EC%8B%9C+%EB%B6%81%EA%B5%AC+%EB%B3%B5%ED%98%84%EB%8F%99"));
    }
}
