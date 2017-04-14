package model.dao;

import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.collections.MapUtils;

import java.util.Map;

public class SessionDao {

    private static Map<String, Object> sessionMap = MapUtils.EMPTY_MAP;

    static  {
        while (sessionMap == MapUtils.EMPTY_MAP) {
            sessionMap = ActionContext.getContext().getSession();
        }
    }

    public synchronized void put(String key, Object value) {
        sessionMap.put(key, value);
    }

    public synchronized Object getValue(String key) {
        return sessionMap.get(key);
    }

    public synchronized boolean containsValue(Object value) {
        return sessionMap.containsValue(value);
    }

    public synchronized void remove(String key) {
        sessionMap.remove(key);
    }

}
