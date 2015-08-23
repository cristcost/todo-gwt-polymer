package name.christianbauer.todo.client.framework;

import com.google.gwt.core.client.js.JsFunction;

@JsFunction
public interface Function1<I, O> {
    O call(I a);
}
