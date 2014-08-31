package org.nt67.evepool.resource;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.net.URL;
import javax.ws.rs.ApplicationPath;
import static org.hamcrest.CoreMatchers.is;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * {@link EventResource}の返却値を検証するテストクラスです。
 * @author ntakeda
 */
@RunWith(Arquillian.class)
public class EventResourceIT {
    
    @Deployment(testable = false )
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                //FIXME use signature
            .addPackages(true, "org.nt67.evepool.resource")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");    
    }
    
    @ArquillianResource
    URL deploymentUrl;
    
    private final String RESOURCE_PREFIX = JaxRsActivator.class.getAnnotation(ApplicationPath.class).value().substring(1);
    
    private static String customerRequestUrl;
    
    @Before
    public void resolveRequestPath(){
        customerRequestUrl = deploymentUrl.toString() + RESOURCE_PREFIX + "/event/";
    }
    
    @Test
    public void EventをGETメソッドで取得すると_HTTPレスポンスコード200_レスポンスボディに_Event_文字列が返却される() throws UnirestException{
        HttpResponse<String> response = Unirest.get(customerRequestUrl).asString();
        
        assertThat(response.getCode(), is(200));
        assertThat(response.getBody(), is("Event"));
    }
    
    
}
