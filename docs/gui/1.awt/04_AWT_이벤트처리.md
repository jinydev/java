# 04. AWT Event Handling

## 1. Event Delegation Model
Java AWT uses the **Delegation Event Model**.
-   **Event Source**: The component where the event occurs (e.g., Button).
-   **Event Listener**: The code to be executed when an event happens (Implementation of an Interface).
-   **Event Object**: Information about the occurred event (e.g., clicked button, mouse coordinates).

In other words, you **register a listener (add) to an event source**, and when an event occurs, the **listener's method is called**.

---

## 2. Major Events and Listeners

| Component        | Event Class   | Listener Interface | Major Method                        |
| :--------------- | :------------ | :----------------- | :---------------------------------- |
| `Button`         | `ActionEvent` | `ActionListener`   | `actionPerformed(ActionEvent e)`    |
| `List`, `Choice` | `ItemEvent`   | `ItemListener`     | `itemStateChanged(ItemEvent e)`     |
| `TextField`      | `TextEvent`   | `TextListener`     | `textValueChanged(TextEvent e)`     |
| `Frame` (Window) | `WindowEvent` | `WindowListener`   | `windowClosing(WindowEvent e)`      |
| Mouse            | `MouseEvent`  | `MouseListener`    | `mouseClicked`, `mousePressed`, ... |
| Keyboard         | `KeyEvent`    | `KeyListener`      | `keyPressed`, `keyReleased`, ...    |

---

## 3. How to Handle Events

### Method 1: Implementing the Listener Interface Directly
This method involves making the class itself act as a listener.

```java
import java.awt.*;
import java.awt.event.*;

public class EventExam implements ActionListener {
    Frame f;
    Button b;

    public EventExam() {
        f = new Frame("Event Test");
        f.setLayout(new FlowLayout());

        b = new Button("Click Me");
        b.addActionListener(this); // Register the listener (myself) to the button

        f.add(b);
        f.setSize(300, 200);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked!");
    }

    public static void main(String[] args) {
        new EventExam();
    }
}
```

### Method 2: Using Anonymous Inner Classes
This method implements the listener on the spot without creating a separate class implementation. It is the most common approach.

```java
import java.awt.*;
import java.awt.event.*;

public class AnonymousEventExam {
    public static void main(String[] args) {
        Frame f = new Frame("Anonymous Event");
        f.setSize(300, 200);
        f.setLayout(new FlowLayout());

        Button b = new Button("Close Window");

        // 1. Handling Button Click (ActionListener)
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Close button clicked");
                System.exit(0);
            }
        });

        // 2. Handling Window 'X' Button (WindowListener -> WindowAdapter)
        // Since WindowListener has 7 methods, we use the Adapter class to override only what we need.
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(b);
        f.setVisible(true);
    }
}
```

### * Adapter Class
When it is cumbersome to implement all methods of an interface (e.g., `WindowListener` has 7 methods), you can inherit from an **Adapter Class** (like `WindowAdapter`) which has empty implementations of these methods, and **override only the necessary methods**.
-   `WindowListener` -> `WindowAdapter`
-   `MouseListener` -> `MouseAdapter`
-   `KeyListener` -> `KeyAdapter`
-   (Since `ActionListener` has only one method, it does not have an adapter.)
