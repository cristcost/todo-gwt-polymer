package name.christianbauer.todo.client.framework;

import com.google.gwt.core.client.js.JsFunction;

@JsFunction
public interface ComponentFunction {
    Object call(Component component);
}
