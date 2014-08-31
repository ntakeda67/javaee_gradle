package org.nt67.evepool.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link EventResource}のコンポーネントテストクラスです。
 * @author ntakeda
 */
@RunWith(Enclosed.class)
public class EventResourceTest {
    
    public static class GetEvent実行時 {
        
        private EventResource testInstance;
        
        @Before
        public void setUpTestInstance(){
            testInstance = new EventResource();
        }
        
        @Test
        public void 固定文字列_Event_を返却する() throws Exception {
            assertThat("Event", is(testInstance.getEvent()));
        }
        
    }
    
}
