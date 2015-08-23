package name.christianbauer.todo.client.framework;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface TemplateInstance<T> {

    @JsProperty
    int getIndex();

    @JsProperty
    T getItem();

}
