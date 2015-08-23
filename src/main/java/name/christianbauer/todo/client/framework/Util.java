package name.christianbauer.todo.client.framework;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Locale;

public class Util {

    static public native void log(Object o) /*-{
        console.dir(o);
    }-*/;

    static public native void logKeys(Object o) /*-{
        console.log(Object.keys(o));
    }-*/;

    // TODO: I had weird problems with JsArrayOf and other wrappers, so let's do this...
    static public native Object createArray() /*-{
        return [];
    }-*/;

    // TODO: I don't know JavaScript...
    static public native Object getGlobalObject(String key) /*-{
        return $wnd[key];
    }-*/;

    // TODO https://www.mail-archive.com/google-web-toolkit-contributors@googlegroups.com/msg33431.html
    static public native JavaScriptObject wrap(ComponentFunction impl) /*-{
        return function () {
            return impl.@name.christianbauer.todo.client.framework.ComponentFunction::call(*)(this);
        }
    }-*/;

    static public native JavaScriptObject wrap(ComponentFunction1 impl) /*-{
        return function (a) {
            return impl.@name.christianbauer.todo.client.framework.ComponentFunction1::call(*)(this, a);
        }
    }-*/;

    static public native JavaScriptObject wrap(ComponentEventListener impl) /*-{
        return function (event, detail) {
            impl.@name.christianbauer.todo.client.framework.ComponentEventListener::call(*)(this, event, detail);
        }
    }-*/;

    public static String toLowerCaseDash(String camelCase) {
        // Transforms 'EXFooBar123' into 'ex-foo-bar-123 and "attributeX" into "attribute-x" without regex (GWT!)
        if (camelCase == null)
            return null;
        if (camelCase.length() == 0)
            return camelCase;
        StringBuilder sb = new StringBuilder();
        char[] chars = camelCase.toCharArray();
        boolean inNonLowerCase = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!Character.isLowerCase(c)) {
                if (!inNonLowerCase) {
                    if (i > 0)
                        sb.append("-");
                } else if (i < chars.length - 1 && Character.isLowerCase(chars[i + 1])) {
                    sb.append("-");
                }
                inNonLowerCase = true;
            } else {
                inNonLowerCase = false;
            }
            sb.append(c);
        }
        String name = sb.toString();
        name = name.toLowerCase(Locale.ROOT);
        return name;
    }

}
