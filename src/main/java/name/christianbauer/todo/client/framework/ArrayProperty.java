package name.christianbauer.todo.client.framework;

import com.google.gwt.core.client.js.JsType;
import elemental.js.util.JsArrayOf;

@JsType
public class ArrayProperty extends Property {

    public ArrayProperty() {
        super(Type.Array, Util.createArray());
    }

    public ArrayProperty(boolean reflectToAttribute, boolean readOnly, boolean notify) {
        super(Type.Array, Util.createArray(), reflectToAttribute, readOnly, notify, null, null);
    }

    public ArrayProperty(boolean reflectToAttribute, boolean readOnly, boolean notify, String computed, String observer) {
        super(Type.Array, Util.createArray(), reflectToAttribute, readOnly, notify, computed, observer);
    }

    public ArrayProperty(Object... items) {
        super(Type.Array, Util.createArray());
        if (items != null) {
            JsArrayOf<Object> array = (JsArrayOf) getValue();
            for (Object item : items) {
                array.push(item);
            }
        }
    }
}
