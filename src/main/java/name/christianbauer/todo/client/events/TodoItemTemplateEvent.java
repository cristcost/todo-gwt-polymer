package name.christianbauer.todo.client.events;

import com.google.gwt.core.client.js.JsType;
import name.christianbauer.todo.client.model.TodoItem;
import name.christianbauer.todo.client.framework.TemplateEvent;

@JsType
public interface TodoItemTemplateEvent extends TemplateEvent<TodoItem> {
}
