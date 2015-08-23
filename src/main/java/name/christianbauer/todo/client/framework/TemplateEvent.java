package name.christianbauer.todo.client.framework;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface TemplateEvent<T> {

    @JsProperty
    TemplateInstance<T> getModel();

}
