package by.makedon.graphicseditor.tool;

import by.makedon.graphicseditor.tool.impl.Line;
import by.makedon.graphicseditor.tool.impl.Pencil;
import by.makedon.graphicseditor.tool.impl.Quadrangle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yahor Makedon
 */
public final class ToolManager {
    private static ToolManager instance;

    private Map<Class<?>, Tool> toolMap;

    private ToolManager() {
        toolMap = new HashMap<>();
        toolMap.put(Pencil.class, new Pencil());
        toolMap.put(Line.class, new Line());
        toolMap.put(Quadrangle.class, new Quadrangle());
    }

    public static ToolManager getInstance() {
        if (instance == null) {
            instance = new ToolManager();
        }
        return instance;
    }

    public Tool getTool(Class<?> clazz) {
        Tool tool = toolMap.get(clazz);
        if (tool == null) {
            throw new NullPointerException("Tool shouldn't be null");
        } else {
            return tool;
        }
    }
}
