package name.christianbauer.todo.client.events;

import com.google.gwt.core.client.js.JsType;
import name.christianbauer.todo.client.model.TodoItem;

@JsType
public class TodoItemChangedEvent extends TodoItemEvent {
    public TodoItemChangedEvent(TodoItem item) {
        super(item);
    }
}
