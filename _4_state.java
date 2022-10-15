// BEHAVIOURAL PATTERN

// Use Abstract if we want to use both common code and abstract methods
// Use Interface if we want to use only methods (contracts)

// Allows an object to behave differently when its state changes
// Reference to context
// States are allowed to replace the context
// Single state
// The behaviour (method) is defined by the sub class

interface Tool {
    void moveUp();

    void moveDown();
}

class SelectionTool implements Tool {
    @Override
    public void moveUp() {
        System.out.println("Select something");
    }

    @Override
    public void moveDown() {
        System.out.println("Select something");
    }
}

class BrushTool implements Tool {
    @Override
    public void moveUp() {
        System.out.println("Draw something");
    }

    @Override
    public void moveDown() {
        System.out.println("Draw something");
    }
}

class Canvas {
    private Tool currentTool;

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool tool) {
        currentTool = tool;
        return;
    }

    public void moveUp() {
        currentTool.moveUp();
    }

    public void moveDown() {
        currentTool.moveDown();
    }

} 
 
public class _4_state {
    public static void main(String[] args) {
        var canvas = new Canvas();
        canvas.setCurrentTool(new BrushTool());
        canvas.moveUp();
    }
}
