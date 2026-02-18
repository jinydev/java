---
layout: gui
title: "03. AWT Layout Manager"
---

# 03. AWT Layout Manager

## 1. What is a Layout Manager?
A class that determines **how components are arranged** inside a container (Frame, Panel, etc.).
It uses classes that implement the `java.awt.LayoutManager` interface.

-   **Containers usually have a default layout manager.**
    -   Default for `Frame`: `BorderLayout`
    -   Default for `Panel`: `FlowLayout`

---

## 2. Major Layout Managers

### 1) FlowLayout
-   Arranges components **from left to right, like flowing water**.
-   If the window width is too narrow, it automatically wraps to the next line.
-   This is the default layout manager for `Panel`.

```java
Frame f = new Frame();
f.setLayout(new FlowLayout()); // Set FlowLayout

f.add(new Button("1"));
f.add(new Button("2"));
f.add(new Button("3"));
```

### 2) BorderLayout
-   Divides the container into 5 regions: **East, West, South, North, Center**.
-   Only one component can be added to each region.
-   This is the default layout manager for `Frame`.

```java
Frame f = new Frame();
f.setLayout(new BorderLayout());

f.add(new Button("North"), BorderLayout.NORTH);
f.add(new Button("South"), BorderLayout.SOUTH);
f.add(new Button("Center"), BorderLayout.CENTER);
// East and West can be omitted
```

### 3) GridLayout
-   Divides the container uniformly into a **grid (rows, columns)**.
-   All components are set to the same size.
-   Useful for creating UIs like a calculator button pad.

```java
Frame f = new Frame();
f.setLayout(new GridLayout(2, 3)); // 2 rows, 3 columns

f.add(new Button("1"));
f.add(new Button("2"));
f.add(new Button("3"));
f.add(new Button("4"));
f.add(new Button("5"));
f.add(new Button("6"));
```

### 4) Null Layout (Absolute Positioning)
-   Does not use a layout manager; the developer manually specifies coordinates (x, y) and size (width, height).
-   Component positions remain fixed even if the window size changes.

```java
Frame f = new Frame();
f.setLayout(null); // Remove layout manager

Button b = new Button("Click");
b.setBounds(50, 50, 100, 30); // x=50, y=50, w=100, h=30

f.add(b);
```

---

## 3. Layout Manager Example (Calculator Style)

```java
import java.awt.*;

public class LayoutExam {
    public static void main(String[] args) {
        Frame f = new Frame("Calculator Layout");
        f.setSize(300, 400);
        f.setLayout(new BorderLayout()); // Use BorderLayout globally

        // Top: Result display (TextField)
        TextField result = new TextField("0");
        f.add(result, BorderLayout.NORTH);

        // Center: Buttons (Panel + GridLayout)
        Panel p = new Panel();
        p.setLayout(new GridLayout(4, 3)); // 4 rows, 3 columns

        for (int i = 1; i <= 9; i++) {
            p.add(new Button(String.valueOf(i)));
        }
        p.add(new Button("*"));
        p.add(new Button("0"));
        p.add(new Button("#"));

        f.add(p, BorderLayout.CENTER);

        f.setVisible(true);
    }
}
```
