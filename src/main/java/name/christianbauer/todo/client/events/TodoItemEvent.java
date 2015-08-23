package name.christianbauer.todo.client.events;

import com.google.gwt.core.client.js.JsType;
import name.christianbauer.todo.client.framework.ComponentEvent;
import name.christianbauer.todo.client.model.TodoItem;

@JsType
public class TodoItemEvent extends ComponentEvent {

    protected TodoItem item;

    public TodoItemEvent(TodoItem item) {
        this.item = item;
    }

    @Override
    public TodoItem getDetail() {
        return item;
    }
}
