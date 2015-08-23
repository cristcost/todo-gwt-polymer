package name.christianbauer.todo.client.components;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;
import elemental.js.util.JsArrayOf;
import name.christianbauer.todo.client.events.TodoItemTemplateEvent;
import name.christianbauer.todo.client.framework.ArrayProperty;
import name.christianbauer.todo.client.framework.ComponentType;
import name.christianbauer.todo.client.framework.IntegerFunction1;
import name.christianbauer.todo.client.framework.Property;
import name.christianbauer.todo.client.model.TodoItem;

import java.util.logging.Logger;

import static name.christianbauer.todo.client.framework.Polymer.register;
import static name.christianbauer.todo.client.framework.Property.Type.Number;
import static name.christianbauer.todo.client.framework.Util.wrap;

@JsType
public class TodoListType extends ComponentType {

    private static final Logger LOG = Logger.getLogger(TodoListType.class.getName());

    public TodoListType() {
        super("todo-list");

        setRegistered(() -> {
            register(new TodoItemDetailType());
        });

        getProperties().put("todoItems", new ArrayProperty(new TodoItem("Some test data...", false)));
        getProperties().put("openItems", new Property(Number, 0));
        getProperties().put("doneItems", new Property(Number, 0));

        setCalculateIndex((IntegerFunction1) a -> a + 1);

        setTodoItemsChanged(wrap((component) -> {
            JsArrayOf items = (JsArrayOf) component.get("todoItems");
            int open = 0;
            int done = 0;
            for (int i = 0; i < items.length(); i++) {
                TodoItem todoItem = (TodoItem) items.get(i);
                if (todoItem.isDone()) {
                    done++;
                } else {
                    open++;
                }
            }
            component.set("openItems", open);
            component.set("doneItems", done);
            return null;
        }));

        setAddItem(wrap(component -> {
            component.push("todoItems", new TodoItem("I have something to do...", false));
            return null;
        }));

        setRemoveItem(wrap((component, event, detail) -> {
            TodoItemTemplateEvent templateEvent = (TodoItemTemplateEvent) event;
            component.splice("todoItems", templateEvent.getModel().getIndex(), 1);
        }));
    }

    @Override
    protected String[] initializeObservers() {
        return new String[]{
            "todoItemsChanged(todoItems.*)"
        };
    }

    @JsProperty
    protected void setCalculateIndex(Object function) {
    }

    @JsProperty
    protected void setTodoItemsChanged(Object function) {
    }

    @JsProperty
    protected void setAddItem(Object function) {
    }

    @JsProperty
    public void setRemoveItem(Object function) {
    }
}
