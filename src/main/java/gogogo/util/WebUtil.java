package gogogo.util;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author 86155
 */
@Deprecated
public class WebUtil {
    public static <T>T getBean(Class<T> tClass){
        WebApplicationContext ioc = ContextLoader.getCurrentWebApplicationContext();
        assert ioc != null;
        return ioc.getBean(tClass);
    }
}
