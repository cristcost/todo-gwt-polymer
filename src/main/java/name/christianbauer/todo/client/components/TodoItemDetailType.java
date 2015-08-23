package name.christianbauer.todo.client.components;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;
import name.christianbauer.todo.client.events.TodoItemChangedEvent;
import name.christianbauer.todo.client.events.TodoItemRemoveEvent;
import name.christianbauer.todo.client.framework.ComponentType;
import name.christianbauer.todo.client.framework.Property;
import name.christianbauer.todo.client.model.TodoItem;

import java.util.logging.Logger;

import static name.christianbauer.todo.client.framework.Property.Type.Object;
import static name.christianbauer.todo.client.framework.Util.wrap;

@JsType
public class TodoItemDetailType extends ComponentType {

    private static final Logger LOG = Logger.getLogger(TodoItemDetailType.class.getName());

    public TodoItemDetailType() {
        super("todo-item-detail");

        getProperties().put("todoItem", new Property(Object, null, false, false, false, null, "todoItemChanged"));

        setRemoveItem(wrap((component, event, detail) -> {
            new TodoItemRemoveEvent((TodoItem) component.get("todoItem"))
                .fire(component);
        }));

        setTodoItemChanged(wrap(component -> {
            new TodoItemChangedEvent((TodoItem) component.get("todoItem"))
                .fire(component);
            return null;
        }));
    }

    @JsProperty
    public void setRemoveItem(JavaScriptObject jso) {
    }

    @JsProperty
    public void setTodoItemChanged(JavaScriptObject jso) {
    }
}
