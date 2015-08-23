package name.christianbauer.todo.client.framework;

import com.google.gwt.core.client.js.JsFunction;

@JsFunction
public interface ComponentFunction1<T1> {
    Object call(Component component, T1 a);
}
