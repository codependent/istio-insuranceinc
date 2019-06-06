import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class MyTest {

    @Test
    public void testRestTemplateExchange() {
        RestTemplate restTemplate = mock(RestTemplate.class);

        HttpEntity<String> httpRequestEntity = new HttpEntity<>("someString");

        List<String> list = Arrays.asList("1", "2");
        ResponseEntity mockResponse = new ResponseEntity<>(list, HttpStatus.ACCEPTED);
        when(restTemplate.exchange(anyString(), any(), any(), any(ParameterizedTypeReference.class), any(Object[].class)))
                .thenReturn(mockResponse);


        final ResponseEntity<List<String>> exchange = restTemplate.exchange("/someUrl", HttpMethod.GET, httpRequestEntity, new ParameterizedTypeReference<List<String>>() {
        });

        Assert.assertEquals(list, exchange.getBody());

    }

}
