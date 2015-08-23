package name.christianbauer.todo.client.framework;

import com.google.gwt.core.client.js.JsFunction;
import com.google.gwt.user.client.Event;

@JsFunction
public interface ComponentEventListener {
    void call(Component component, Event e, Object detail);
}
