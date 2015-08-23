package name.christianbauer.todo.client.framework;

import elemental.js.util.JsMapFromStringTo;

import java.util.logging.Logger;

public abstract class ComponentEvent {

    protected JsMapFromStringTo options = JsMapFromStringTo.create();

    public ComponentEvent() {
        this(true);
    }

    public ComponentEvent(boolean bubbles) {
        options.put("bubbles", bubbles);
    }

    private static final Logger LOG = Logger.getLogger(ComponentEvent.class.getName());

    public static String getType(String simpleClassName) {
        String type = Util.toLowerCaseDash(simpleClassName);

        if (type.length() > 6 && type.substring(type.length()-6).equals("-event"))
            type = type.substring(0, type.length()-6);

        return type;
    }

    public static String getType(Class<? extends ComponentEvent> eventClass) {
        return getType(eventClass.getSimpleName());
    }

    public String getType() {
        return getType(getClass());
    }

    public static String getListenerName(Class<? extends ComponentEvent> eventClass) {
        String listenerName = "on" + eventClass.getSimpleName();
        if (listenerName.substring(listenerName.length()-5).equals("Event")) {
            listenerName = listenerName.substring(0, listenerName.length()-5);
        }
        return listenerName;
    }

    public void fire(Component component) {
        LOG.fine("Firing event on '" + component.getLocalName() + "': " + getType());
        component.fire(getType(), getDetail(), getOptions());
    }

    public JsMapFromStringTo getOptions() {
        return options;
    }

    public abstract Object getDetail();

}
