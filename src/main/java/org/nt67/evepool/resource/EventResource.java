package org.nt67.evepool.resource;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * イベント情報を返却するリソースクラスです。
 * 
 * @author ntakeda
 */
@Stateless
@Path("/event")
public class EventResource {
    @GET
    public String getEvent(){
        return "Event";
    }
    
}
