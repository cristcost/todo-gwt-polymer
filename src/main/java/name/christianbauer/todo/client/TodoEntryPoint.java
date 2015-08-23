package name.christianbauer.todo.client;

import name.christianbauer.todo.client.components.TodoListType;

import java.util.logging.Logger;

import static name.christianbauer.todo.client.framework.Polymer.register;

public class TodoEntryPoint implements com.google.gwt.core.client.EntryPoint {

    private static final Logger LOG = Logger.getLogger(TodoEntryPoint.class.getName());

    @Override
    public void onModuleLoad() {
        register(new TodoListType());
    }
}
