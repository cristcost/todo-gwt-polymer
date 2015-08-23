package name.christianbauer.todo.client.framework;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.js.JsFunction;
import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;
import elemental.js.util.JsMapFromStringTo;
import elemental.js.util.JsMapFromStringToString;

import static name.christianbauer.todo.client.framework.ComponentEvent.getListenerName;
import static name.christianbauer.todo.client.framework.ComponentEvent.getType;
import static name.christianbauer.todo.client.framework.Util.wrap;

@JsType
public abstract class ComponentType {

    @JsFunction
    public interface Registered {
        void call();
    }

    public ComponentType(String is) {
        setIs(is);
        setProperties(JsMapFromStringTo.create());
        setListeners(JsMapFromStringToString.create());
        setObservers(initializeObservers());
    }

    @JsProperty
    public void setRegistered(Registered registered) {
    }

    @JsProperty
    public void setIs(String domModule) {
    }

    public void setReady(ComponentFunction ready) {
        setReady(wrap(ready));
    }

    @JsProperty
    protected void setReady(JavaScriptObject ready) {
    }

    public void setAttached(ComponentFunction attached) {
        setAttached(wrap(attached));
    }

    @JsProperty
    protected void setAttached(JavaScriptObject attached) {
    }

    @JsProperty
    public JsMapFromStringTo<Object> getProperties() {
        return null;
    }

    @JsProperty
    public void setProperties(JsMapFromStringTo<Object> properties) {
    }

    @JsProperty
    public JsMapFromStringToString getListeners() {
        return null;
    }

    @JsProperty
    public void setListeners(JsMapFromStringToString listeners) {
    }

    @JsProperty
    public void setObservers(String[] observers) {
    }

    protected String[] initializeObservers() {
        return new String[0];
    }

    public void enableListener(Class<? extends ComponentEvent> eventClass) {
        getListeners().put(getType(eventClass), getListenerName(eventClass));
    }

}
