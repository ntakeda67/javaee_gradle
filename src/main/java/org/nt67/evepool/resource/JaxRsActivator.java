package org.nt67.evepool.resource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * JAX-RSを有効にするためのクラスです。
 * 本クラスはJAX-RSのリクエストを受け付けるパスのルートを規定します。s
 * @author ntakeda
 */
@ApplicationPath("/resource")
public class JaxRsActivator extends Application {
    
}
