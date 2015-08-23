package name.christianbauer.todo.client.framework;

import elemental.dom.Element;

public class Polymer {

    static public native void register(ComponentType componentType) /*-{
        var ctor = $wnd.Polymer.Class(componentType);
        $doc.registerElement(componentType.is, ctor);
    }-*/;

    static public native Component create(ComponentType componentType) /*-{
        return $doc.createElement(componentType.is);
    }-*/;

    static public native Component.DOM dom(Element element) /*-{
        return $wnd.Polymer.dom(element);
    }-*/;

}
